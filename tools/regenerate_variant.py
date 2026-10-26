#!/usr/bin/env python3
"""Bitta tezlik to'plamini qayta yaratish (masalan 0.65 -> _065, 0.90 -> _090).

Fayllar vaqtinchalik nomga yoziladi va muvaffaqiyatli tugagach atomar
ravishda asosiy nomga ko'chiriladi — uzilishda qayta ishga tushirish xavfsiz.
"""
import argparse
import os
import sqlite3
import subprocess
import time

from supertonic import TTS

ROOT = "/home/dilshod/AndroidStudioProjects/GujumEnglish"
ASSETS = os.path.join(ROOT, "app/src/main/assets")
AUDIO = os.path.join(ASSETS, "audio")
DB = os.path.join(ASSETS, "dictionary.db")
TMP = "/tmp/opencode/tts_variants"

parser = argparse.ArgumentParser()
parser.add_argument("--speed", type=float, required=True)
parser.add_argument("--code", required=True)
parser.add_argument("--atempo", type=float, default=1.0,
                    help="ffmpeg atempo (masalan 0.928571: 0.70 -> 0.65)")
args = parser.parse_args()

os.makedirs(TMP, exist_ok=True)
con = sqlite3.connect(DB)
rows = list(con.execute("SELECT id, sentence FROM dictionary ORDER BY id"))
todo = [
    (i, t) for i, t in rows
    if not (os.path.exists(os.path.join(AUDIO, f"s{i:03d}_{args.code}.opus"))
            and os.path.getsize(os.path.join(AUDIO, f"s{i:03d}_{args.code}.opus")) > 800)
]
print(f"tezlik={args.speed} kod={args.code} | jami {len(rows)} | kerak {len(todo)}", flush=True)

tts = TTS()
style = tts.get_voice_style("F5")
print(f"model: {tts.model_name}, sample_rate={tts.sample_rate}", flush=True)

t_start = time.time()
for n, (sid, text) in enumerate(todo, 1):
    wav_path = os.path.join(TMP, f"s{sid:03d}_{args.code}.wav")
    tmp_opus = os.path.join(TMP, f"s{sid:03d}_{args.code}.opus")
    target = os.path.join(AUDIO, f"s{sid:03d}_{args.code}.opus")
    try:
        wav, _ = tts.synthesize(
            text, voice_style=style, lang="en", total_steps=8, speed=args.speed
        )
        tts.save_audio(wav, wav_path)
        cmd = ["ffmpeg", "-v", "error", "-y", "-i", wav_path]
        if args.atempo != 1.0:
            cmd += ["-filter:a", f"atempo={args.atempo:.6f}"]
        cmd += ["-c:a", "libopus", "-b:a", "32k", "-ar", "48000", "-ac", "1", tmp_opus]
        subprocess.run(cmd, check=True)
        os.remove(wav_path)
        os.replace(tmp_opus, target)
    except Exception as exc:  # noqa: BLE001
        print(f"[{sid}] XATO: {exc}", flush=True)
        continue

    if n % 25 == 0 or n == len(todo):
        el = time.time() - t_start
        eta = el / n * (len(todo) - n)
        print(f"[{n}/{len(todo)}] {el:.0f}s | ETA {eta/60:.1f} min | id={sid} {text!r}",
              flush=True)

print(f"Tayyor: {args.code}, {time.time()-t_start:.0f}s", flush=True)
