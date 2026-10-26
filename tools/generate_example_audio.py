#!/usr/bin/env python3
"""Nazariya darslaridagi misol gaplar uchun opus audio generatsiyasi.

SuperTonic-3 (F5, speed=0.75, steps=8) — mavjud lug'at audiosi bilan bir xil sozlama.
Har bir noyob matn uchun bitta fayl: UnitAllLessons/examples_opus/<slug>.opus
"""
import hashlib
import json
import os
import subprocess
import sys
import tempfile
import time

from supertonic import TTS

ROOT = "/home/dilshod/AndroidStudioProjects/GujumEnglish"
ITEMS = os.path.join(ROOT, "tools/out/voice_items.json")
OUT_DIR = os.path.join(ROOT, "app/src/main/assets/grammar/UnitAllLessons/examples_opus")
MANIFEST = os.path.join(ROOT, "tools/out/examples_manifest.json")
TMP = "/tmp/opencode/tts_examples"
os.makedirs(OUT_DIR, exist_ok=True)
os.makedirs(TMP, exist_ok=True)

items = json.load(open(ITEMS, encoding="utf-8"))
print(f"Jami noyob matn: {len(items)}")

manifest = {}
if os.path.exists(MANIFEST):
    manifest = {m["slug"]: m for m in json.load(open(MANIFEST, encoding="utf-8"))}

todo = []
for it in items:
    target = os.path.join(OUT_DIR, it["slug"] + ".opus")
    ok = False
    if os.path.exists(target) and os.path.getsize(target) > 800:
        probe = subprocess.run(
            ["ffprobe", "-v", "error", "-show_entries", "format=duration", "-of", "csv=p=0", target],
            capture_output=True, text=True,
        ).stdout.strip()
        try:
            ok = float(probe) > 0.2
        except ValueError:
            ok = False
    if not ok:
        todo.append(it)

print(f"Generatsiya kerak: {len(todo)} | mavjud: {len(items) - len(todo)}")
if not todo:
    sys.exit(0)

tts = TTS()
style = tts.get_voice_style("F5")
print(f"model: {tts.model_name}, sample_rate={tts.sample_rate}")

t_start = time.time()
for n, it in enumerate(todo, 1):
    slug = it["slug"]
    text = it["text"]
    wav_path = os.path.join(TMP, slug + ".wav")
    opus_path = os.path.join(OUT_DIR, slug + ".opus")
    try:
        wav, _ = tts.synthesize(
            text, voice_style=style, lang="en", total_steps=8, speed=0.75
        )
        tts.save_audio(wav, wav_path)
        subprocess.run(
            ["ffmpeg", "-v", "error", "-y", "-i", wav_path,
             "-c:a", "libopus", "-b:a", "32k", "-ar", "48000", "-ac", "1", opus_path],
            check=True,
        )
        os.remove(wav_path)
        dur = float(subprocess.run(
            ["ffprobe", "-v", "error", "-show_entries", "format=duration", "-of", "csv=p=0", opus_path],
            capture_output=True, text=True,
        ).stdout.strip())
        data = open(opus_path, "rb").read()
        manifest[slug] = {
            "text": text,
            "file": f"grammar/UnitAllLessons/examples_opus/{slug}.opus",
            "duration": round(dur, 3),
            "bytes": len(data),
            "sha256": hashlib.sha256(data).hexdigest(),
            "kind": it["kind"],
        }
        status = "OK"
    except Exception as exc:  # noqa: BLE001
        status = f"XATO: {exc}"
        print(f"[{n}/{len(todo)}] {text!r} -> {status}", flush=True)
        continue

    if n % 20 == 0 or n == len(todo):
        el = time.time() - t_start
        eta = el / n * (len(todo) - n)
        print(f"[{n}/{len(todo)}] {status} | {el:.0f}s o'tdi, ETA {eta/60:.1f} min | {text!r}", flush=True)
        json.dump(list(manifest.values()), open(MANIFEST, "w", encoding="utf-8"),
                  ensure_ascii=False, indent=1)

json.dump(list(manifest.values()), open(MANIFEST, "w", encoding="utf-8"),
          ensure_ascii=False, indent=1)
print(f"Tayyor: {len(manifest)} fayl, {time.time()-t_start:.0f}s")
