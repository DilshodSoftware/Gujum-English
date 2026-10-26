#!/usr/bin/env python3
"""Misol gaplar audiosi va HTML tugmalarini tekshirish."""
import glob
import hashlib
import json
import os
import re
import subprocess
import sys

ROOT = "/home/dilshod/AndroidStudioProjects/GujumEnglish"
ASSETS = os.path.join(ROOT, "app/src/main/assets")
EX_DIR = os.path.join(ASSETS, "grammar/UnitAllLessons/examples_opus")

items = json.load(open(os.path.join(ROOT, "tools/out/voice_items.json"), encoding="utf-8"))
manifest = json.load(open(os.path.join(ROOT, "tools/out/examples_manifest.json"), encoding="utf-8"))
voice_rows = json.load(open(os.path.join(ROOT, "tools/out/voice_rows.json"), encoding="utf-8"))

print(f"1) Noyob matn: {len(items)} | manifest: {len(manifest)}")
missing = [i["slug"] for i in items if not os.path.exists(os.path.join(EX_DIR, i["slug"] + ".opus"))]
print(f"2) Audio fayl yo'q: {len(missing)} {missing[:5]}")

bad_meta = []
for m in manifest:
    p = os.path.join(ASSETS, m["file"])
    if not os.path.exists(p):
        bad_meta.append((m["slug"], "fayl yo'q"))
        continue
    data = open(p, "rb").read()
    if hashlib.sha256(data).hexdigest() != m["sha256"] or len(data) != m["bytes"]:
        bad_meta.append((m["slug"], "sha256/o'lcham"))
    if m["duration"] < 0.2:
        bad_meta.append((m["slug"], f"juda qisqa {m['duration']}"))
print(f"3) Metadata xatolari: {len(bad_meta)} {bad_meta[:5]}")

probe_bad = []
for m in manifest[:]:
    p = os.path.join(ASSETS, m["file"])
    out = subprocess.run(
        ["ffprobe", "-v", "error", "-show_entries",
         "stream=codec_name,sample_rate,channels:format=duration", "-of", "json", p],
        capture_output=True, text=True).stdout
    try:
        d = json.loads(out)
        st = d["streams"][0]
        if st["codec_name"] != "opus" or int(st["sample_rate"]) != 48000 or int(st["channels"]) != 1:
            probe_bad.append((m["slug"], st))
        if float(d["format"]["duration"]) < 0.2:
            probe_bad.append((m["slug"], "duration"))
    except Exception as exc:  # noqa: BLE001
        probe_bad.append((m["slug"], str(exc)))
print(f"4) Opus formati noto'g'ri: {len(probe_bad)} {probe_bad[:5]}")

# HTML tugmalar
refs = 0
missing_refs = []
targets = 0
for p in glob.glob(os.path.join(ASSETS, "grammar/UnitAllLessons/unit_*/*.html")):
    if re.match(r"\d+_Practice_", os.path.basename(p)):
        continue
    raw = open(p, encoding="utf-8").read()
    for rel in re.findall(r"playOpus\('(\.\./examples_opus/[^']+)'", raw):
        refs += 1
        if not os.path.exists(os.path.normpath(os.path.join(os.path.dirname(p), rel))):
            missing_refs.append((os.path.basename(p), rel))
print(f"5) HTML examples_opus havolalari: {refs} | topilmagan: {len(missing_refs)} {missing_refs[:5]}")
print(f"6) Kutilgan target row: {len(voice_rows)} | qo'shilgan tugma: {refs}")

ok = not (missing or bad_meta or probe_bad or missing_refs) and refs == len(voice_rows)
print("\nNATIJA:", "HAMMASI JOYIDA" if ok else "MUAMMO BOR")
sys.exit(0 if ok else 1)
