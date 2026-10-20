#!/usr/bin/env python3
"""Darslar va ularning bo'limlari uchun qiyinlik baholari (0-10).

Kalibratsiya: ilovaning "oddiy darsi" 4-ballik darajada. Ya'ni:
  2 — alifbo, harf tovushlari, lug'at
  3 — ot/olmosh, to be, artikl, egalik (asosiy poydevor)
  4 — present simple, savollar, there is, can, predloglar (o'quv o'ragi)
  5 — past simple, kelajak zamani, taqqoslash, bog'lovchilar
  6 — murakkab grammatika (shartli, passiv, reported speech)

BARCHA bo'limlar (amaliyot mashqlari ham) baholanadi.

Chiqish: app/src/main/assets/grammar/difficulty.json
"""
import glob
import html
import json
import os
import re

PROJ = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
GR = f"{PROJ}/app/src/main/assets/grammar/UnitAllLessons"
OUT = f"{PROJ}/app/src/main/assets/grammar/difficulty.json"

# Dars raqami -> bazaviy qiyinlik (dars mavzusi bo'yicha)
LESSON_BASE = {
    # UNIT 0 — English Basics
    1: 2.0, 2: 2.0, 3: 2.5, 4: 2.5, 5: 2.5, 6: 2.5,
    # UNIT 1 — Foundation
    7: 3.0, 8: 3.0, 9: 3.0, 10: 3.0, 11: 3.5, 12: 3.5, 13: 3.5,
    14: 3.5, 15: 3.5, 16: 3.5, 17: 3.5, 18: 3.5,
    # UNIT 2 — Present
    19: 3.5, 20: 3.5, 21: 4.0, 22: 4.0, 23: 4.0, 24: 4.0, 25: 4.0,
    26: 4.0, 27: 4.0, 28: 4.5,
    # UNIT 3 — Questions
    29: 4.0, 30: 4.0, 31: 4.0, 32: 4.0, 33: 4.0, 34: 4.0, 35: 4.0,
    36: 4.0, 37: 4.0,
    # UNIT 4 — Everyday English
    38: 4.0, 39: 4.0, 40: 4.0, 41: 4.0, 42: 4.0, 43: 4.0, 44: 4.5,
    45: 4.5, 46: 4.5, 47: 4.5, 48: 4.5,
    # UNIT 5 — Past
    49: 4.5, 50: 4.5, 51: 5.0, 52: 5.0, 53: 5.0, 54: 5.0, 55: 5.0,
    # UNIT 6 — Future & Description
    56: 5.0, 57: 5.0, 58: 5.0, 59: 5.0, 60: 5.0, 61: 5.0, 62: 5.0,
    63: 5.0, 64: 5.0,
    # UNIT 7 — Review
    65: 6.0, 66: 6.5,
    # UNIT 8 — Survival Vocabulary
    67: 3.0,
}

# Bo'lim turi bo'yicha tuzatish
VOCAB_TITLE = re.compile(r"^(Dars lug|alifbo misollarida|Gaplarda ishlatiladigan)", re.I)
PRACTICE_TITLE = re.compile(
    r"(mashq|Mashqlar|O‘zingizni tekshiring|Eng (mu|qisqa)|"
    r"Juda qisqa eslab|Xatolarni tuzating|O‘zbekchadan inglizchaga)", re.I)
WORD_LIST = re.compile(r"^(Odamlar|Hayvonlar|Narsalar va joylar)$", re.I)

HEAD_RE = re.compile(r"<h([23])[^>]*>(.*?)</h\1>", re.S)
TAGS_RE = re.compile(r"<[^>]+>")


def plain(s):
    return re.sub(r"\s+", " ", TAGS_RE.sub("", s)).strip()


def section_difficulty(lesson, title, is_practice):
    base = LESSON_BASE.get(lesson, 4.0)
    t = title.strip()
    if WORD_LIST.match(t):
        return max(1.0, base - 1.5)          # "Odamlar/Hayvonlar" — ro'yxat, oson
    if VOCAB_TITLE.match(t):
        return max(1.0, base - 1.2)          # lug'at ro'yxati — grammatikadan oson
    if PRACTICE_TITLE.search(t):
        return min(10.0, base + 0.3)          # mashq — tushuntirishdan biroz qiyin
    return base


def main():
    lessons = []
    for u in range(0, 9):
        d = f"{GR}/unit_{u}"
        if not os.path.isdir(d):
            continue
        for f in sorted(os.listdir(d)):
            # Amaliyot fayli: "<N>_Practice_..." — boshqa nomdagi "Practice" so'zi
            # (66_A1_Grammar_Final_Practice.html — bu nazariya darsi) hisobga olinmaydi.
            if not f.endswith(".html") or re.match(r"\d+_Practice_", f):
                continue
            m = re.match(r"(\d+)_", f)
            if not m:
                continue
            lesson = int(m.group(1))
            is_practice = False
            raw = open(os.path.join(d, f), encoding="utf-8").read()
            secs = []
            for x in HEAD_RE.finditer(raw):
                title = plain(x.group(2))
                diff = section_difficulty(lesson, title, is_practice)
                secs.append({"title": title, "difficulty": diff})
            # Dars darajasidagi ball: bo'limlar o'rtachasi 60% + eng qiyin bo'lim 40%.
            # Shaklda bitta og'ir bo'lim darsni butunlay oson deb ko'rsatmaydi.
            if secs:
                avg = sum(s["difficulty"] for s in secs) / len(secs)
                worst = max(s["difficulty"] for s in secs)
                lesson_diff = round(avg * 0.6 + worst * 0.4, 1)
            else:
                lesson_diff = 0.0
            lessons.append({
                "lesson": lesson,
                "difficulty": lesson_diff,
                "sections": secs,
            })

    data = {"schemaVersion": 1, "scale": "0-10", "lessons": lessons}
    json.dump(data, open(OUT, "w", encoding="utf-8"), ensure_ascii=False, indent=2)

    alld = [s["difficulty"] for l in lessons for s in l["sections"]]
    ld = [sum(s["difficulty"] for s in l["sections"]) / len(l["sections"])
          for l in lessons]
    print(f"Yozildi: {OUT}")
    print(f"Darslar: {len(lessons)} | bo'limlar: {len(alld)}")
    print(f"Bo'limlar o'rtachasi: {sum(alld)/len(alld):.2f} | mediana: {sorted(alld)[len(alld)//2]}")
    print(f"Darslar o'rtachasi: {sum(ld)/len(ld):.2f}")
    from collections import Counter
    c = Counter(int(x) for x in alld)
    print("Taqsimot:", dict(sorted(c.items())))


if __name__ == "__main__":
    main()
