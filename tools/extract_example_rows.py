#!/usr/bin/env python3
"""Nazariya darslaridagi .row misol gaplarini ajratib oladi va tozalaydi.

Natija:
  tools/out/rows.json        — barcha 1009 row (tur bo'yicha)
  tools/out/voice_items.json — ovoz kerak bo'lgan noyob matnlar (642 atrofida)
"""
import re
import glob
import os
import json
import sqlite3
from collections import Counter

ROOT = "/home/dilshod/AndroidStudioProjects/GujumEnglish"
OUT = os.path.join(ROOT, "tools", "out")
os.makedirs(OUT, exist_ok=True)

SENT_RE = re.compile(r'<span class="en">(.*?)</span>', re.S)
ROW_RE = re.compile(r'<div class="row">(.*?)</div>', re.S)
TAGS = re.compile(r"<[^>]+>")

# "Darak:", "Savol:", "Inkor:" kabi o'zbekcha yorliqlar
LABEL_RE = re.compile(
    r"^\s*(Darak|Savol|Inkor|Bo[ls]*lishsiz|So[ro]*roq|Tasdiq|Ijobiy|Salbiy)\s*:\s*",
    re.I,
)
# "Kim?", "Nimani?" kabi o'zbekcha savol so'zlari gap boshida
UZ_Q_RE = re.compile(
    r"^\s*(Kim|Nima|Nimani|Qachon|Qayerda|Qayerga|Qanday|Nega|Nechta|Necha|"
    r"Qancha|Kimga|Nimaga|Qaysi|Nima uchun)\?\s*",
    re.I,
)
NUM_PREFIX_RE = re.compile(r"^\s*\d+\.\s*")

# Raqamlarni so'z bilan o'qish (aniq bo'lishi uchun qo'lda)
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


def has_uz(t: str) -> bool:
    if re.search(r"[\u2018\u2019\u02bb]", t):
        return True
    return bool(
        re.search(
            r"\b(harf|tovush|unli|undosh|kabi|va|yoki|bilan|emas|bor|yo[\u2018']q|"
            r"aytilmaydi|yoziladi|jim|bitta)\b",
            t,
            re.I,
        )
    )


def pure_en(t: str) -> bool:
    return bool(re.fullmatch(r"[A-Za-z0-9 .,!?'\-/]+", t))


def slugify(t: str, maxlen: int = 48) -> str:
    s = t.lower()
    s = re.sub(r"[^a-z0-9]+", "_", s).strip("_")
    if not s:
        s = "x"
    return s[:maxlen].strip("_")


def clean_tts(t: str) -> str:
    """Ovoz uchun matnni tozalaydi."""
    s = LABEL_RE.sub("", t)
    s = NUM_PREFIX_RE.sub("", s)
    s = UZ_Q_RE.sub("", s)
    s = re.sub(r"\s+", " ", s).strip()
    s = TTS_OVERRIDE.get(s, s)
    return s


con = sqlite3.connect(os.path.join(ROOT, "app/src/main/assets/dictionary.db"))
db = {norm(r[0]) for r in con.execute("SELECT sentence FROM dictionary")}
con.close()

rows = []
for p in sorted(
    glob.glob(os.path.join(ROOT, "app/src/main/assets/grammar/UnitAllLessons/unit_*/*.html"))
):
    base = os.path.basename(p)
    if re.match(r"\d+_Practice_", base):
        continue
    unit = re.search(r"unit_(\d+)", p).group(1)
    lesson_no = int(re.match(r"(\d+)_", base).group(1))
    raw = open(p, encoding="utf-8").read()
    for idx, m in enumerate(ROW_RE.finditer(raw)):
        sm = SENT_RE.search(m.group(1))
        if not sm:
            continue
        txt = re.sub(r"\s+", " ", TAGS.sub("", sm.group(1))).strip()
        if not txt:
            continue
        if norm(txt) in db:
            continue  # allaqachon ovozlangan (DB korpusi)
        if "→" in txt or "->" in txt:
            kind = "A"
        elif has_uz(txt):
            kind = "B"
        elif not pure_en(txt):
            kind = "C"
        else:
            words = len(re.findall(r"[A-Za-z']+", txt))
            kind = "D" if words <= 2 else "E"

        # "Darak: She likes tea." -> E (yorliq olib tashlanadi)
        if kind in ("B", "C"):
            st = LABEL_RE.sub("", txt)
            if st != txt and pure_en(st) and len(re.findall(r"[A-Za-z']+", st)) >= 3:
                kind = "E"

        rows.append(
            {
                "unit": unit,
                "file": os.path.relpath(p, os.path.join(ROOT, "app/src/main/assets")),
                "html": base,
                "lesson": lesson_no,
                "row_index": idx,
                "text": txt,
                "kind": kind,
            }
        )

# --- Ovoz ro'yxatini shakllantirish ---
voice_rows, skipped = [], []
for r in rows:
    if r["kind"] not in ("D", "E"):
        continue
    tts = clean_tts(r["text"])
    # Pattern/dual rows: "one car / four cars", "a / an" — ovoz kerakmas
    if "/" in tts:
        skipped.append((r["text"], "slash"))
        continue
    letters = re.findall(r"[A-Za-z]", tts)
    if not letters:
        skipped.append((r["text"], "harfsiz"))
        continue
    words = re.findall(r"[A-Za-z']+", tts)
    if len(words) < 2 and r["kind"] == "D":
        # bir so'zli bo'lak (masalan "I") — baribir foydali, qoldiramiz
        pass
    voice_rows.append({**r, "tts_text": tts})

seen = {}
for r in voice_rows:
    key = norm(r["tts_text"])
    if key not in seen:
        seen[key] = {
            "text": r["tts_text"],
            "source_text": r["text"],
            "kind": r["kind"],
            "slug": slugify(r["tts_text"]),
            "units": [r["unit"]],
            "lessons": [r["lesson"]],
            "count": 1,
        }
    else:
        seen[key]["count"] += 1
        if r["unit"] not in seen[key]["units"]:
            seen[key]["units"].append(r["unit"])
        if r["lesson"] not in seen[key]["lessons"]:
            seen[key]["lessons"].append(r["lesson"])

used = Counter()
for item in seen.values():
    s = item["slug"]
    used[s] += 1
    if used[s] > 1:
        item["slug"] = f"{s}_{used[s]}"

json.dump(rows, open(os.path.join(OUT, "rows.json"), "w", encoding="utf-8"),
          ensure_ascii=False, indent=1)
json.dump(voice_rows, open(os.path.join(OUT, "voice_rows.json"), "w", encoding="utf-8"),
          ensure_ascii=False, indent=1)
json.dump(list(seen.values()),
          open(os.path.join(OUT, "voice_items.json"), "w", encoding="utf-8"),
          ensure_ascii=False, indent=1)

c = Counter(r["kind"] for r in rows)
print("Taqsimot:", dict(sorted(c.items())))
print("Jami row:", len(rows))
print("Ovoz kerak (D+E):", len(voice_rows), "| noyob:", len(seen))
print("  D:", sum(1 for r in voice_rows if r["kind"] == "D"),
      "| E:", sum(1 for r in voice_rows if r["kind"] == "E"))
print("O'tkazib yuborildi:", len(skipped), Counter(k for _, k in skipped))
for t, k in skipped:
    print("   -", k, "|", t[:60])
