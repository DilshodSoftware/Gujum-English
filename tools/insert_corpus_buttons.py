#!/usr/bin/env python3
"""Nazariya darslarida allaqachon ovozlangan (DB korpusidagi) misol gaplarga
mavjud `audio/sNNN_080.opus` faylini bog'laydigan tugma qo'shadi.

Yangi audio yaratilmaydi — korpusdagi mavjud fayl ishlatiladi.
"""
import glob
import os
import re
import sqlite3
import sys

ROOT = "/home/dilshod/AndroidStudioProjects/GujumEnglish"
SENT_RE = re.compile(r'<span class="en">(.*?)</span>', re.S)
ROW_RE = re.compile(r'<div class="row">(.*?)</div>', re.S)
TAGS = re.compile(r"<[^>]+>")
REL = "../../../audio"  # assets/grammar/UnitAllLessons/unit_N/ -> assets/audio


def norm(s: str) -> str:
    return re.sub(r"[^a-z0-9 ]", "", s.lower()).strip()


con = sqlite3.connect(os.path.join(ROOT, "app/src/main/assets/dictionary.db"))
db = {}
for i, s in con.execute("SELECT id, sentence FROM dictionary ORDER BY id"):
    db.setdefault(norm(s), i)
con.close()

inserted = 0
already = 0
missing_audio = []
files_touched = 0

for p in sorted(glob.glob(os.path.join(
        ROOT, "app/src/main/assets/grammar/UnitAllLessons/unit_*/*.html"))):
    if re.match(r"\d+_Practice_", os.path.basename(p)):
        continue
    raw = open(p, encoding="utf-8").read()
    inserts = []
    for m in ROW_RE.finditer(raw):
        sm = SENT_RE.search(m.group(1))
        if not sm:
            continue
        if "playOpus" in sm.group(0):
            already += 1
            continue
        txt = re.sub(r"\s+", " ", TAGS.sub("", sm.group(1))).strip()
        if not txt:
            continue
        sid = db.get(norm(txt))
        if not sid:
            continue
        audio = os.path.join(ROOT, "app/src/main/assets/audio", f"s{sid:03d}_080.opus")
        if not os.path.exists(audio):
            missing_audio.append((os.path.basename(p), txt, sid))
            continue
        pos = m.start(1) + sm.end() - len("</span>")
        button = (
            f'<button class="speak" onclick="playOpus(\'{REL}/s{sid:03d}_080.opus\',this)"'
            f' aria-label="Tinglash">\U0001F50A</button>'
        )
        inserts.append((pos, button))
    if inserts:
        for pos, btn in sorted(inserts, key=lambda x: -x[0]):
            raw = raw[:pos] + btn + raw[pos:]
        open(p, "w", encoding="utf-8").write(raw)
        inserted += len(inserts)
        files_touched += 1

print(f"Qo'shildi: {inserted} | fayl: {files_touched}")
print(f"Audio topilmadi: {len(missing_audio)} {missing_audio[:5]}")
sys.exit(1 if missing_audio else 0)
