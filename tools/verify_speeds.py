#!/usr/bin/env python3
"""065/080/090 to'plamlarini tekshirish: fayl, sha256, davomiylik va STT."""
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
CODES = {"065": "0.065", "080": "0.080", "090": "0.090"}


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
print(f"manifest speeds: {manifest['speeds']} | yozuvlar: {len(manifest['files'])}")

model = WhisperModel("base.en", device="cpu", compute_type="int8", cpu_threads=2)
random.seed(123)

dur_by_speed = {}
for code, speed in CODES.items():
    missing = bad_sha = bad_size = short = 0
    durs = {}
    for sid in db:
        path = os.path.join(AUDIO, f"s{sid:03d}_{code}.opus")
        if not os.path.isfile(path):
            missing += 1
            continue
        data = open(path, "rb").read()
        entry = entries[(sid, speed)]
        if hashlib.sha256(data).hexdigest() != entry["sha256"]:
            bad_sha += 1
        if len(data) != entry["bytes"]:
            bad_size += 1
        dur = float(subprocess.run(
            ["ffprobe", "-v", "error", "-show_entries", "format=duration", "-of", "csv=p=0", path],
            capture_output=True, text=True).stdout.strip())
        durs[sid] = dur
        if dur < 0.2:
            short += 1
    dur_by_speed[code] = durs

    sample = random.sample(sorted(db), 20)
    ok = 0
    problems = []
    for sid in sample:
        segs, _ = model.transcribe(os.path.join(AUDIO, f"s{sid:03d}_{code}.opus"),
                                   beam_size=5, language="en", vad_filter=False)
        heard = " ".join(s.text.strip() for s in segs).strip()
        if similar(db[sid], heard):
            ok += 1
        else:
            problems.append((sid, db[sid], heard))
    print(f"\n{code}: yo'q {missing} | sha xato {bad_sha} | size xato {bad_size} | qisqa {short}")
    print(f"  STT namunasi: mos {ok}/20 | mos emas {len(problems)}")
    for sid, exp, heard in problems:
        print(f"    id={sid} kutilgan={exp!r} eshitilgan={heard!r}")

# davomiylik tartibi
bad_order = []
for sid in db:
    d = [dur_by_speed[c].get(sid) for c in ("065", "080", "090")]
    if None in d:
        continue
    if not (d[0] > d[1] > d[2]):
        bad_order.append((sid, *[round(x, 3) for x in d]))
print(f"\nDavomiylik tartibi buzilgan (065>080>090 emas): {len(bad_order)}")
for row in bad_order[:10]:
    print("  ", row)
