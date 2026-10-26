#!/usr/bin/env python3
"""080 regeneratsiyasini tekshirish: fayl, sha256, davomiylik va STT namunasi."""
import hashlib
import json
import os
import random
import re
import sqlite3
import subprocess

from faster_whisper import WhisperModel

ROOT = "/home/dilshod/AndroidStudioProjects/GujumEnglish"
ASSETS = os.path.join(ROOT, "app/src/main/assets")
AUDIO = os.path.join(ASSETS, "audio")
MANIFEST = os.path.join(AUDIO, "manifest.json")


def norm(s):
    s = re.sub(r"<[^>]+>", "", s or "")
    return re.sub(r"[^a-z0-9 ]", "", s.lower()).strip()


def similar(a, b):
    wa, wb = set(norm(a).split()), set(norm(b).split())
    if not wa or not wb:
        return False
    return len(wa & wb) / len(wa | wb) >= 0.75


con = sqlite3.connect(os.path.join(ASSETS, "dictionary.db"))
db = {r[0]: r[1] for r in con.execute("SELECT id, sentence FROM dictionary ORDER BY id")}
manifest = json.load(open(MANIFEST, encoding="utf-8"))
entries = {(e["sentenceId"], e["speed"]): e for e in manifest["files"]}

missing, bad_hash, bad_size, bad_dur = [], [], [], []
for sid, text in db.items():
    path = os.path.join(AUDIO, f"s{sid:03d}_080.opus")
    if not os.path.isfile(path):
        missing.append(sid)
        continue
    data = open(path, "rb").read()
    entry = entries[(sid, "0.080")]
    if hashlib.sha256(data).hexdigest() != entry["sha256"]:
        bad_hash.append(sid)
    if len(data) != entry["bytes"]:
        bad_size.append(sid)
    dur = float(subprocess.run(
        ["ffprobe", "-v", "error", "-show_entries", "format=duration", "-of", "csv=p=0", path],
        capture_output=True, text=True).stdout.strip())
    if dur < 0.2:
        bad_dur.append(sid)

print(f"080 fayllar: {len(db)} | yo'q {len(missing)} | sha xato {len(bad_hash)} | "
      f"size xato {len(bad_size)} | juda qisqa {len(bad_dur)}")

model = WhisperModel("base.en", device="cpu", compute_type="int8", cpu_threads=2)
random.seed(42)
sample = random.sample(sorted(db), 40)
ok = 0
problems = []
for sid in sample:
    segs, _ = model.transcribe(os.path.join(AUDIO, f"s{sid:03d}_080.opus"),
                               beam_size=5, language="en", vad_filter=False)
    heard = " ".join(s.text.strip() for s in segs).strip()
    if similar(db[sid], heard):
        ok += 1
    else:
        problems.append((sid, db[sid], heard))
print(f"STT namunasi: {len(sample)} | mos {ok} | mos emas {len(problems)}")
for sid, exp, heard in problems:
    print(f"   id={sid} kutilgan={exp!r} eshitilgan={heard!r}")
