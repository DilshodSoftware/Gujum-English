#!/usr/bin/env python3
"""Barcha 1137 gapning 0.080 tezlikdagi audiosini DB matnidan qayta yaratish.

Sabab: 272547c da yaratilgan 080 fayllar boshqa (siljigan) ro'yxatdan
generatsiya qilingan — matn bilan audio mos kelmaydi. 070/095 esa
5dca688 da to'g'ri yaratilgan. Bu skript 080 ni F5/speed=0.80/steps=8
bilan qayta yaratadi va manifest.json dagi sha256/bytes ni yangilaydi.
"""
import hashlib
import json
import os
import sqlite3
import subprocess
import time

from supertonic import TTS

ROOT = "/home/dilshod/AndroidStudioProjects/GujumEnglish"
ASSETS = os.path.join(ROOT, "app/src/main/assets")
DB = os.path.join(ASSETS, "dictionary.db")
OUT = os.path.join(ASSETS, "audio")
MANIFEST = os.path.join(OUT, "manifest.json")
TMP = "/tmp/opencode/tts_080"
PROGRESS = os.path.join(ROOT, "tools/out/regenerate_080.json")

os.makedirs(TMP, exist_ok=True)
os.makedirs(os.path.dirname(PROGRESS), exist_ok=True)

con = sqlite3.connect(DB)
rows = list(con.execute("SELECT id, sentence FROM dictionary ORDER BY id"))
print(f"DB gaplar: {len(rows)}", flush=True)

manifest = json.load(open(MANIFEST, encoding="utf-8"))
by_key = {(e["sentenceId"], e["speed"]): e for e in manifest["files"]}
missing = [i for i, _ in rows if (i, "0.080") not in by_key]
if missing:
    raise SystemExit(f"Manifestda 080 yozuvi yo'q: {missing[:10]}")

done = {}
if os.path.exists(PROGRESS):
    done = json.load(open(PROGRESS))
    print(f"Oldingi progress: {len(done)} ta", flush=True)

todo = [(i, t) for i, t in rows if str(i) not in done]
print(f"Generatsiya kerak: {len(todo)} | tayyor: {len(done)}", flush=True)
if not todo:
    raise SystemExit(0)

tts = TTS()
style = tts.get_voice_style("F5")
print(f"model: {tts.model_name}, sample_rate={tts.sample_rate}", flush=True)

t_start = time.time()
for n, (sid, text) in enumerate(todo, 1):
    target = os.path.join(OUT, f"s{sid:03d}_080.opus")
    wav_path = os.path.join(TMP, f"s{sid:03d}.wav")
    try:
        wav, _ = tts.synthesize(
            text, voice_style=style, lang="en", total_steps=8, speed=0.80
        )
        tts.save_audio(wav, wav_path)
        subprocess.run(
            ["ffmpeg", "-v", "error", "-y", "-i", wav_path,
             "-c:a", "libopus", "-b:a", "32k", "-ar", "48000", "-ac", "1", target],
            check=True,
        )
        os.remove(wav_path)
    except Exception as exc:  # noqa: BLE001
        print(f"[{sid}] XATO: {exc}", flush=True)
        continue

    data = open(target, "rb").read()
    dur = float(subprocess.run(
        ["ffprobe", "-v", "error", "-show_entries", "format=duration",
         "-of", "csv=p=0", target],
        capture_output=True, text=True,
    ).stdout.strip())
    entry = by_key[(sid, "0.080")]
    entry["sha256"] = hashlib.sha256(data).hexdigest()
    entry["bytes"] = len(data)
    entry["file"] = f"audio/s{sid:03d}_080.opus"
    done[str(sid)] = {
        "text": text,
        "duration": round(dur, 3),
        "bytes": len(data),
        "sha256": entry["sha256"],
    }

    if n % 25 == 0 or n == len(todo):
        json.dump(manifest, open(MANIFEST, "w", encoding="utf-8"),
                  ensure_ascii=False, indent=1)
        json.dump(done, open(PROGRESS, "w", encoding="utf-8"),
                  ensure_ascii=False, indent=1)
        el = time.time() - t_start
        eta = el / n * (len(todo) - n)
        print(f"[{n}/{len(todo)}] {el:.0f}s | ETA {eta/60:.1f} min | id={sid} {text!r}",
              flush=True)

json.dump(manifest, open(MANIFEST, "w", encoding="utf-8"),
          ensure_ascii=False, indent=1)
json.dump(done, open(PROGRESS, "w", encoding="utf-8"),
          ensure_ascii=False, indent=1)
print(f"Tayyor: {len(done)} ta, {time.time()-t_start:.0f}s", flush=True)
