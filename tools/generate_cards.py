#!/usr/bin/env python3
"""Barcha darslar (1..67) uchun cardlar generatsiya qiladi.

Ishlatish:  python3 tools/generate_cards.py

Manba: assets/grammar/UnitAllLessons/unit_N/[N]_<Dars>.html — "Mashq" savollari
va "Javoblar" qismi; unit_N_dictionary_txt/unit_N_sentence.txt — gap matnlari.
Chiqish: app/src/main/assets/cards_content.json

Kartalar:
  - rule    : darsning Mashq savollari (javoblar bilan)
  - grammar : gaplardan avtomatik bo'shliqlar (to'be, a/an, can, prep, he/she/it)
"""
import html
import json
import os
import re
import shutil

PROJ = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
GR = f"{PROJ}/app/src/main/assets/grammar/UnitAllLessons"
OUT = f"{PROJ}/app/src/main/assets/cards_content.json"

BE = {"am", "is", "are"}
PREPS = {"in", "on", "at", "to", "for", "with", "from", "by"}


# ---------------------------------------------------------------- HTML parsing

def strip_html(raw):
    t = re.sub(r"<script.*?</script>", " ", raw, flags=re.S)
    t = re.sub(r"<style.*?</style>", " ", t, flags=re.S)
    t = re.sub(r"<[^>]+>", " ", t)
    t = html.unescape(t)
    return re.sub(r"\s+", " ", t).strip()


def lesson_html_files():
    """{dars raqami: (fayl yo'li, text)} — amaliyot fayllarini chiqarib tashlaydi."""
    out = {}
    for u in range(0, 9):
        d = f"{GR}/unit_{u}"
        if not os.path.isdir(d):
            continue
        for f in sorted(os.listdir(d)):
            if not f.endswith(".html") or "Practice" in f:
                continue
            m = re.match(r"(\d+)_", f)
            if not m:
                continue
            num = int(m.group(1))
            if num in out:
                continue
            raw = open(os.path.join(d, f), encoding="utf-8").read()
            out[num] = (f"unit_{u}/{f}", strip_html(raw))
    return out


def extract_mashq(text):
    """'Mashq N — Sarlavha' qismlaridan savol-javob juftliklarini chiqaradi.

    Shakl: "Mashq 1 — Sarlavha 1. Savol 2. Savol ... Javoblar: 1. Javob"
    Bir necha Mashq bo'lishi mumkin — hammasi yig'iladi.
    """
    out = []
    # Har bir "Mashq <n> — <sarlavha>" blokini ajratamiz
    blocks = list(re.finditer(r"Mashq\s+\d+\s*[—–-]\s*", text))
    for bi, bm in enumerate(blocks):
        start = bm.end()
        end = blocks[bi + 1].start() if bi + 1 < len(blocks) else len(text)
        body = text[start:end]
        jm = re.search(r"Javoblar\s*:?\s*", body)
        if not jm:
            continue
        q_part = body[:jm.start()]
        a_part = body[jm.end():]

        def numbered(part):
            items = []
            for mm in re.finditer(
                r"(?:^|\s)(\d{1,2})[.)]\s*([^0-9]{3,400}?)(?=(?:\s\d{1,2}[.)]\s)|$)",
                part
            ):
                items.append((int(mm.group(1)), mm.group(2).strip()))
            return items

        qs = numbered(q_part)
        ans = dict(numbered(a_part))
        for n, q in qs:
            a = ans.get(n)
            if not a:
                continue
            q = re.sub(r"\s+", " ", q).strip(" .—–-")
            a = re.sub(r"\s+", " ", a).strip(" .—–-")
            if len(q) < 4 or len(a) < 1:
                continue
            out.append((q, a))
    return out


# ---------------------------------------------------------------- sentence blanks

def load_sentences(unit):
    p = f"{GR}/unit_{unit}/unit_{unit}_dictionary_txt/unit_{unit}_sentence.txt"
    if not os.path.exists(p):
        return []
    out = []
    for i, line in enumerate(open(p, encoding="utf-8").read().split("\n"), 1):
        line = line.strip()
        if not line or "|" not in line:
            continue
        en, uz = (x.strip() for x in line.split("|", 1))
        out.append((i, en, uz))
    return out


def be_blank(en):
    toks = en.split()
    for i, t in enumerate(toks[:6]):
        core = t.strip('.,?!"()').lower()
        if core in BE:
            nt = toks.copy()
            nt[i] = "___"
            return " ".join(nt) + " (am/is/are)", t.strip('.,?!"()')
    return None


def aan_blank(en):
    for m in re.finditer(r"\b(a|an)\b\s+([A-Za-z]{2,})", en):
        if m.start() == 0:
            continue
        if en[m.end():].startswith(","):
            continue
        art = m.group(1)
        prompt = en[:m.start()] + "___ " + en[m.start() + len(art) + 1:] + " (a/an)"
        return prompt, art
    return None


def can_blank(en):
    m = re.search(r"\bcan\b(?!')", en)
    if not m:
        return None
    return en[:m.start()] + "___" + en[m.end():] + " (can/can't)", "can"


def prep_blank(en):
    m = re.search(r"\b(" + "|".join(sorted(PREPS)) + r")\b", en)
    if not m:
        return None
    return en[:m.start()] + "___" + en[m.end():] + " (in/on/at/to/for)", m.group(1)


def he_she_blank(en):
    """Uzbek tilida jins yo'q: he/she/it tanlash mashqi."""
    m = re.search(r"\b(he|she|it)\b", en, re.I)
    if not m:
        return None
    return en[:m.start()] + "___" + en[m.end():] + " (he/she/it)", m.group(1).lower()


# ---------------------------------------------------------------- audio

def audio_path(unit, line_no):
    """unit_0/s002_075.opus -> grammar/UnitAllLessons/unit_0/unit_0_sentence_opus/s002_075.opus"""
    p = f"{GR}/unit_{unit}/unit_{unit}_sentence_opus/s{line_no:03d}_075.opus"
    if os.path.exists(p):
        return p.replace(f"{PROJ}/app/src/main/assets/", "")
    return None


# ---------------------------------------------------------------- main

def main():
    htmls = lesson_html_files()
    print(f"dars HTML: {len(htmls)}")

    cards = []
    seen = set()

    def add(lesson, typ, prompt, answer, audio=None, example="", tags=None, uz=False):
        key = (typ, prompt.lower().strip(), answer.lower().strip())
        if key in seen:
            return
        seen.add(key)
        c = {
            "id": "",  # keyinroq to'ldiriladi
            "lessonId": lesson,
            "type": typ,
            "prompt": prompt,
            "answer": answer,
            "audioFile": audio,
            "example": example,
            "tags": json.dumps(tags or [], ensure_ascii=False),
        }
        if uz:
            c["uzInterference"] = True
        cards.append(c)

    # 1) rule kartalar — har darsning Mashq savollari
    rule_total = 0
    for num in sorted(htmls):
        _, text = htmls[num]
        for q, a in extract_mashq(text):
            add(num, "rule", q, a, tags=["rule", f"lesson{num}"])
            rule_total += 1
    print(f"rule kartalar: {rule_total}")

    # 2) grammar kartalar — gaplardan bo'shliqlar
    gram_total = 0
    for unit in range(0, 9):
        for line_no, en, uz in load_sentences(unit):
            # Darsni topish: unit_0 = 1..6, unit_1 = 7..18, unit_2 = 19..28 ...
            lesson = unit_to_lesson(unit, line_no)
            au = audio_path(unit, line_no)
            for fn, tag in (
                (be_blank, "verb_to_be"),
                (aan_blank, "article"),
                (can_blank, "modal"),
                (prep_blank, "preposition"),
                (he_she_blank, "pronoun"),
            ):
                r = fn(en)
                if not r:
                    continue
                prompt, ans = r
                add(lesson, "grammar", prompt, ans, audio=au, example=en,
                    tags=["grammar", tag], uz=(tag in ("verb_to_be", "article", "pronoun")))
                gram_total += 1
    print(f"grammar kartalar: {gram_total}")

    # id raqamlash
    per_lesson = {}
    for c in cards:
        per_lesson.setdefault(c["lessonId"], 0)
        per_lesson[c["lessonId"]] += 1
        c["id"] = f"L{c['lessonId']:02d}-C{per_lesson[c['lessonId']]:02d}"

    shutil.copy2(OUT, f"{PROJ}/tools/cards_content.bak.json")
    json.dump(cards, open(OUT, "w", encoding="utf-8"), ensure_ascii=False, indent=2)
    print(f"JAMI: {len(cards)} karta, {len(per_lesson)} dars")
    print("darslar:", dict(sorted(per_lesson.items())))


def unit_to_lesson(unit, line_no):
    """unit_0 gaplari -> dars 1..6, unit_1 -> 7..15, unit_2 -> 19..28, ..."""
    if unit == 0:
        if line_no <= 24:
            return 1
        if line_no <= 50:
            return 2
        if line_no <= 84:
            return 3
        if line_no <= 103:
            return 4
        if line_no <= 131:
            return 5
        return 6
    if unit == 1:
        return 7 + min(8, (line_no - 1) // 20)
    if unit == 2:
        return 19 + min(9, (line_no - 1) // 18)
    if unit == 3:
        return 29 + min(8, (line_no - 1) // 20)
    if unit == 4:
        return 38 + min(10, (line_no - 1) // 18)
    if unit == 5:
        return 49 + min(5, (line_no - 1) // 20)
    if unit == 6:
        return 56 + min(7, (line_no - 1) // 26)
    if unit == 7:
        return 65
    return 67


if __name__ == "__main__":
    main()
