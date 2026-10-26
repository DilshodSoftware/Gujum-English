#!/usr/bin/env python3
"""Yangi 065/090 fayllarni manifestga kiritish va eski 070/095 fayllarni o'chirish."""
import glob
import hashlib
import json
import os

ROOT = "/home/dilshod/AndroidStudioProjects/GujumEnglish"
ASSETS = os.path.join(ROOT, "app/src/main/assets")
AUDIO = os.path.join(ASSETS, "audio")
MANIFEST = os.path.join(AUDIO, "manifest.json")

manifest = json.load(open(MANIFEST, encoding="utf-8"))
speed_map = {"0.070": ("065", "0.065"), "0.095": ("090", "0.090")}

missing = []
updated = 0
for entry in manifest["files"]:
    if entry["speed"] not in speed_map:
        continue
    code, new_speed = speed_map[entry["speed"]]
    rel = f"audio/s{entry['sentenceId']:03d}_{code}.opus"
    path = os.path.join(ASSETS, rel)
    if not os.path.isfile(path):
        missing.append(rel)
        continue
    data = open(path, "rb").read()
    entry["speed"] = new_speed
    entry["file"] = rel
    entry["sha256"] = hashlib.sha256(data).hexdigest()
    entry["bytes"] = len(data)
    updated += 1

if missing:
    raise SystemExit(f"Yangi fayllar yetishmaydi ({len(missing)}): {missing[:10]}")

manifest["speeds"] = ["0.065", "0.080", "0.090"]
tmp = MANIFEST + ".tmp"
with open(tmp, "w", encoding="utf-8") as fh:
    json.dump(manifest, fh, ensure_ascii=False, indent=1)
os.replace(tmp, MANIFEST)

removed = 0
for code in ("070", "095"):
    for path in glob.glob(os.path.join(AUDIO, f"s*_{code}.opus")):
        os.remove(path)
        removed += 1

print(f"manifest yangilandi: {updated} | eski fayl o'chirildi: {removed}")
