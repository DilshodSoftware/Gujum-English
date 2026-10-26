#!/usr/bin/env python3
"""Yangi misol audiolarining sifat nazorati:
- har bir matn -> fayl -> manifest mosligi
- nutq (jimlikdan tashqari) davomiyligi yetarlimi
- g'ayritabiiy qisqa/uzun fayllar
"""
import json
import os
import re
import subprocess
from concurrent.futures import ThreadPoolExecutor

ROOT = "/home/dilshod/AndroidStudioProjects/GujumEnglish"
EX = os.path.join(ROOT, "app/src/main/assets/grammar/UnitAllLessons/examples_opus")
items = json.load(open(os.path.join(ROOT, "tools/out/voice_items.json"), encoding="utf-8"))
manifest = {
    os.path.splitext(os.path.basename(m["file"]))[0]: m
    for m in json.load(
        open(os.path.join(ROOT, "tools/out/examples_manifest.json"), encoding="utf-8"))
}


def speech_seconds(path):
    out = subprocess.run(
        ["ffmpeg", "-v", "info", "-i", path, "-af",
         "silencedetect=noise=-40dB:d=0.12", "-f", "null", "-"],
        capture_output=True, text=True).stderr
    total = float(subprocess.run(
        ["ffprobe", "-v", "error", "-show_entries", "format=duration", "-of", "csv=p=0", path],
        capture_output=True, text=True).stdout.strip())
    sil = 0.0
    starts = [float(x) for x in re.findall(r"silence_start: ([\d.]+)", out)]
    ends = [float(x) for x in re.findall(r"silence_end: ([\d.]+)", out)]
    for i, s in enumerate(starts):
        e = ends[i] if i < len(ends) else total
        sil += max(0.0, e - s)
    return total, total - sil


def check(it):
    p = os.path.join(EX, it["slug"] + ".opus")
    total, speech = speech_seconds(p)
    m = manifest.get(it["slug"])
    problems = []
    if not m:
        problems.append("manifest yo'q")
    else:
        if m["text"] != it["text"]:
            problems.append("matn mos emas")
        if abs(m["duration"] - total) > 0.1:
            problems.append(f"davomiylik farqi {m['duration']} vs {total}")
    chars = len(re.findall(r"[A-Za-z]", it["text"]))
    expected = max(0.35, chars * 0.055)
    if speech < expected * 0.45:
        problems.append(f"nutq juda qisqa: {speech:.2f}s (kutilgan ~{expected:.2f}s)")
    return it["text"], total, speech, problems


with ThreadPoolExecutor(max_workers=8) as pool:
    results = list(pool.map(check, items))

bad = [r for r in results if r[3]]
print(f"Tekshirildi: {len(results)} | muammoli: {len(bad)}")
for text, total, speech, probs in bad[:25]:
    print(f"   {text!r}: total {total:.2f}s, nutq {speech:.2f}s -> {probs}")
speech_ratio = [s / t for _, t, s, _ in results if t > 0]
print(f"Nutq ulushi: min {min(speech_ratio):.2f}, o'rtacha {sum(speech_ratio)/len(speech_ratio):.2f}")
