#!/usr/bin/env python3
"""Karta audiolarini DB gapiga mos korpus 080 fayllariga qayta yo'naltirish.

Eski `unit_*_sentence_opus/sNNN_075.opus` fayllari boshqa gapning audiosi
edi (matn bilan mos emas). Har bir kartaning `example` matni DB dagi
gapga to'liq mos keladi, shuning uchun audioFile ni
`audio/s{dbid}_080.opus` ga almashtiramiz.
"""
import json
import os
import re
import sqlite3

ROOT = "/home/dilshod/AndroidStudioProjects/GujumEnglish"
ASSETS = os.path.join(ROOT, "app/src/main/assets")
CARDS = os.path.join(ASSETS, "cards_content.json")
DB = os.path.join(ASSETS, "dictionary.db")


def norm(s):
    s = re.sub(r"<[^>]+>", "", s or "")
    return re.sub(r"[^a-z0-9 ]", "", s.lower()).strip()


con = sqlite3.connect(DB)
by_text = {}
for i, t in con.execute("SELECT id, sentence FROM dictionary ORDER BY id"):
    by_text.setdefault(norm(t), []).append(i)

cards = json.load(open(CARDS, encoding="utf-8"))
changed = same = 0
unmatched = []
unique_examples = set()
for c in cards:
    if not c.get("audioFile"):
        continue
    example = c.get("example") or ""
    ids = by_text.get(norm(example))
    if not ids:
        unmatched.append((c.get("id"), example))
        continue
    sid = ids[0]
    new_path = f"audio/s{sid:03d}_080.opus"
    unique_examples.add(norm(example))
    if c["audioFile"] == new_path:
        same += 1
    else:
        c["audioFile"] = new_path
        changed += 1

with open(CARDS, "w", encoding="utf-8") as fh:
    json.dump(cards, fh, ensure_ascii=False, indent=2)

print(f"audioFile bor kartalar: {changed + same}")
print(f"  o'zgartirildi: {changed}")
print(f"  allaqachon to'g'ri: {same}")
print(f"  noyob misol gaplar: {len(unique_examples)}")
print(f"  DB da topilmadi: {len(unmatched)}")
for cid, ex in unmatched[:20]:
    print(f"    {cid}: {ex!r}")
