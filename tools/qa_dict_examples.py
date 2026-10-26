#!/usr/bin/env python3
"""Lug'at va misol audiolarini STT bilan namunali tekshirish."""
import json
import os
import random
import re

from faster_whisper import WhisperModel

ROOT = "/home/dilshod/AndroidStudioProjects/GujumEnglish"
ASSETS = os.path.join(ROOT, "app/src/main/assets")
EXAMPLES_MANIFEST = os.path.join(ROOT, "tools/out/examples_manifest.json")


def norm(s):
    s = re.sub(r"<[^>]+>", "", s or "")
    return re.sub(r"[^a-z0-9 ]", "", s.lower()).strip()


def similar(a, b, threshold=0.75):
    wa, wb = set(norm(a).split()), set(norm(b).split())
    if not wa or not wb:
        return False
    return len(wa & wb) / len(wa | wb) >= threshold


model = WhisperModel("base.en", device="cpu", compute_type="int8")

# --- lug'at ---
dict_files = []
for root, _dirs, files in os.walk(os.path.join(ASSETS, "grammar/UnitAllLessons")):
    if root.endswith("_dictionary_opus"):
        for f in files:
            if f.endswith(".opus") and f.startswith("d"):
                dict_files.append(os.path.join(root, f))
random.seed(9)
dict_sample = random.sample(dict_files, min(25, len(dict_files)))
dict_bad = []
dict_ok = 0
for p in dict_sample:
    stem = os.path.basename(p).rsplit(".", 1)[0]
    word = stem.split("_", 1)[1].replace("_", " ").replace("-", " ")
    segs, _ = model.transcribe(p, beam_size=5, language="en", vad_filter=False)
    heard = " ".join(s.text.strip() for s in segs).strip()
    if norm(word) in norm(heard) or similar(word, heard, 0.6):
        dict_ok += 1
    else:
        dict_bad.append((os.path.relpath(p, ASSETS), word, heard))
print(f"LUG'AT namunasi: {len(dict_sample)} | mos {dict_ok} | mos emas {len(dict_bad)}")
for rel, word, heard in dict_bad:
    print(f"   {rel} | kutilgan={word!r} eshitilgan={heard!r}")

# --- misollar ---
items = json.load(open(EXAMPLES_MANIFEST, encoding="utf-8"))
random.seed(10)
ex_sample = random.sample(items, min(25, len(items)))
ex_bad = []
ex_ok = 0
for it in ex_sample:
    p = os.path.join(ASSETS, it["file"])
    segs, _ = model.transcribe(p, beam_size=5, language="en", vad_filter=False)
    heard = " ".join(s.text.strip() for s in segs).strip()
    if similar(it["text"], heard):
        ex_ok += 1
    else:
        ex_bad.append((it["text"], heard))
print(f"MISOLLAR namunasi: {len(ex_sample)} | mos {ex_ok} | mos emas {len(ex_bad)}")
for exp, heard in ex_bad:
    print(f"   kutilgan={exp!r} eshitilgan={heard!r}")
