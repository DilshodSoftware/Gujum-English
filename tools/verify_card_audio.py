#!/usr/bin/env python3
"""Karta audiolarini tekshirish: fayl mavjudligi va matn mosligi."""
import json
import os
import re
import sqlite3

ROOT = "/home/dilshod/AndroidStudioProjects/GujumEnglish"
ASSETS = os.path.join(ROOT, "app/src/main/assets")


def norm(s):
    s = re.sub(r"<[^>]+>", "", s or "")
    return re.sub(r"[^a-z0-9 ]", "", s.lower()).strip()


con = sqlite3.connect(os.path.join(ASSETS, "dictionary.db"))
db = {r[0]: r[1] for r in con.execute("SELECT id, sentence FROM dictionary")}
cards = json.load(open(os.path.join(ASSETS, "cards_content.json"), encoding="utf-8"))

missing, mismatched, ok = [], [], 0
files = set()
for c in cards:
    rel = c.get("audioFile")
    if not rel:
        continue
    files.add(rel)
    path = os.path.join(ASSETS, rel)
    if not os.path.isfile(path):
        missing.append((c.get("id"), rel))
        continue
    m = re.fullmatch(r"audio/s(\d+)_080\.opus", rel)
    if not m:
        mismatched.append((c.get("id"), rel, "nomuvofiq yo'l"))
        continue
    sid = int(m.group(1))
    if norm(c.get("example")) == norm(db.get(sid)):
        ok += 1
    else:
        mismatched.append((c.get("id"), rel, f"karta={c.get('example')!r} DB[{sid}]={db.get(sid)!r}"))

print(f"audioFile bor kartalar: {sum(1 for c in cards if c.get('audioFile'))}")
print(f"noyob fayl: {len(files)}")
print(f"to'g'ri: {ok} | fayl yo'q: {len(missing)} | nomuvofiq: {len(mismatched)}")
for x in (missing + mismatched)[:20]:
    print("  ", x)
