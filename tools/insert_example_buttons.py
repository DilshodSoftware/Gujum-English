#!/usr/bin/env python3
"""Nazariya darslaridagi .row misol gaplarga 🔊 tugma qo'shadi.

Tugma `.en` span ichiga qo'shiladi:
  <span class="en">I am a student.<button class="speak"
      onclick="playOpus('../examples_opus/i_am_a_student.opus',this)">🔊</button></span>
"""
import glob
import json
import os
import re
import sys
from collections import Counter

ROOT = "/home/dilshod/AndroidStudioProjects/GujumEnglish"
SENT_RE = re.compile(r'<span class="en">(.*?)</span>', re.S)
ROW_RE = re.compile(r'<div class="row">(.*?)</div>', re.S)
TAGS = re.compile(r"<[^>]+>")
LABEL_RE = re.compile(
    r"^\s*(Darak|Savol|Inkor|Bo[ls]*lishsiz|So[ro]*roq|Tasdiq|Ijobiy|Salbiy)\s*:\s*", re.I)
UZ_Q_RE = re.compile(
    r"^\s*(Kim|Nima|Nimani|Qachon|Qayerda|Qayerga|Qanday|Nega|Nechta|Necha|"
    r"Qancha|Kimga|Nimaga|Qaysi|Nima uchun)\?\s*", re.I)
NUM_PREFIX_RE = re.compile(r"^\s*\d+\.\s*")
TTS_OVERRIDE = {
    "in 2026": "in twenty twenty-six",
    "in 2024": "in twenty twenty-four",
    "in 2023": "in twenty twenty-three",
    "on 5 May": "on the fifth of May",
    "For 30 minutes.": "For thirty minutes.",
    "I am 12 years old.": "I am twelve years old.",
    "He is 8 years old.": "He is eight years old.",
    "My sister is 20.": "My sister is twenty.",
    "Her birthday is on 5 May.": "Her birthday is on the fifth of May.",
}


def norm(s: str) -> str:
    return re.sub(r"[^a-z0-9 ]", "", s.lower()).strip()


def clean_tts(t: str) -> str:
    s = LABEL_RE.sub("", t)
    s = NUM_PREFIX_RE.sub("", s)
    s = UZ_Q_RE.sub("", s)
    s = re.sub(r"\s+", " ", s).strip()
    return TTS_OVERRIDE.get(s, s)


items = json.load(open(os.path.join(ROOT, "tools/out/voice_items.json"), encoding="utf-8"))
slug_by_text = {norm(i["text"]): i["slug"] for i in items}
rows = json.load(open(os.path.join(ROOT, "tools/out/voice_rows.json"), encoding="utf-8"))

by_file = {}
for r in rows:
    by_file.setdefault(r["file"], []).append(r)

inserted = 0
already = 0
errors = []
touched_files = 0

for rel, file_rows in sorted(by_file.items()):
    path = os.path.join(ROOT, "app/src/main/assets", rel)
    raw = open(path, encoding="utf-8").read()
    matches = list(ROW_RE.finditer(raw))
    inserts = []
    for r in sorted(file_rows, key=lambda x: -x["row_index"]):
        idx = r["row_index"]
        if idx >= len(matches):
            errors.append((os.path.basename(path), idx, "row_index chegaradan tashqarida"))
            continue
        m = matches[idx]
        sm = SENT_RE.search(m.group(1))
        if not sm:
            errors.append((os.path.basename(path), idx, "en span yo'q"))
            continue
        txt = re.sub(r"\s+", " ", TAGS.sub("", sm.group(1))).strip()
        tts = clean_tts(txt)
        if norm(tts) != norm(r["tts_text"]):
            errors.append((os.path.basename(path), idx, f"matn mos emas: {txt!r} != {r['tts_text']!r}"))
            continue
        if "playOpus" in sm.group(0):
            already += 1
            continue
        slug = slug_by_text.get(norm(tts))
        if not slug:
            errors.append((os.path.basename(path), idx, f"slug topilmadi: {tts!r}"))
            continue
        pos = m.start(1) + sm.end() - len("</span>")
        button = (
            f'<button class="speak" onclick="playOpus(\'../examples_opus/{slug}.opus\',this)"'
            f' aria-label="Tinglash">\U0001F50A</button>'
        )
        inserts.append((pos, button))
    if inserts:
        for pos, btn in sorted(inserts, key=lambda x: -x[0]):
            raw = raw[:pos] + btn + raw[pos:]
        open(path, "w", encoding="utf-8").write(raw)
        inserted += len(inserts)
        touched_files += 1

print(f"Qo'shildi: {inserted} tugma | {touched_files} fayl")
print(f"Allaqachon bor edi: {already}")
print(f"Xatolar: {len(errors)}")
for e in errors[:15]:
    print("   ", e)
sys.exit(1 if errors else 0)
