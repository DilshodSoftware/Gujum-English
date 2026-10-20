#!/usr/bin/env python3
"""Nazariya dars HTML lariga qiyinlik bannerini qo'shadi.

difficulty.json dan olinadigan ma'lumot:
  - dars darajasidagi qiyinlik balli (0-10)
  - bo'limlar bo'yicha qiyinlik (jadval ko'rinishida)

Banner: <h1> dan keyingi <div class="subhead"> dan keyin qo'yiladi.
CSS: <style> ichiga .difficulty-banner stillari qo'shiladi.
"""
import json
import os
import re

PROJ = "/home/dilshod/AndroidStudioProjects/GujumEnglish"
GR = f"{PROJ}/app/src/main/assets/grammar/UnitAllLessons"
DIFF = f"{PROJ}/app/src/main/assets/grammar/difficulty.json"

STYLE = """
    .difficulty-banner { display: flex; flex-wrap: wrap; align-items: center;
      gap: 10px; margin: 12px 0 4px; padding: 10px 12px;
      background: #eef4fa; border: 1px solid #d3e2ef; border-radius: 12px; }
    .difficulty-badge { display: inline-flex; align-items: center; gap: 6px;
      font-size: .8rem; font-weight: 700; }
    .difficulty-dot { width: 10px; height: 10px; border-radius: 50%; }
    .difficulty-label { color: #174a6b; }
    .difficulty-sections { display: flex; flex-wrap: wrap; gap: 6px;
      margin-top: 6px; width: 100%; }
    .difficulty-chip { display: inline-flex; align-items: center; gap: 5px;
      font-size: .72rem; color: #2e7ea3; background: #fff;
      border: 1px solid #d3e2ef; border-radius: 20px; padding: 3px 9px; }
    .difficulty-chip .difficulty-dot { width: 7px; height: 7px; }
    .difficulty-meter { display: flex; gap: 3px; align-items: center; }
    .difficulty-meter i { width: 12px; height: 6px; border-radius: 2px;
      background: #d8e4ee; display: inline-block; }
"""


def color(level):
    if level < 3: return "#2E7D32"
    if level < 3.5: return "#8BC34A"
    if level < 4.5: return "#EF6C00"
    if level < 5.5: return "#F9A825"
    return "#C62828"


def label(level):
    if level < 3: return "Oson"
    if level < 3.5: return "Oson"
    if level < 4.5: return "O'rtacha"
    if level < 5.5: return "Qiyin"
    return "Juda qiyin"


def meter(level):
    filled = int(round(level))
    return "".join(
        f'<i style="background:{color(level) if i < filled else "#d8e4ee"}"></i>'
        for i in range(10)
    )


def main():
    data = json.load(open(DIFF, encoding="utf-8"))
    lessons = {l["lesson"]: l for l in data["lessons"]}
    total = 0
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
            n = int(m.group(1))
            info = lessons.get(n)
            if not info:
                continue
            path = os.path.join(d, f)
            raw = open(path, encoding="utf-8").read()
            if "difficulty-banner" in raw:
                continue
            lv = (sum(s["difficulty"] for s in info["sections"]) / len(info["sections"]))
            chips = "".join(
                f'<span class="difficulty-chip">'
                f'<span class="difficulty-dot" style="background:{color(s["difficulty"])}"></span>'
                f'{s["title"][:34]} {s["difficulty"]:.1f}</span>'
                for s in sorted(info["sections"], key=lambda x: -x["difficulty"])[:8]
            )
            banner = (
                f'\n    <div class="difficulty-banner">'
                f'<span class="difficulty-badge">'
                f'<span class="difficulty-dot" style="background:{color(lv)}"></span>'
                f'<span class="difficulty-label">Qiyinlik: {lv:.1f}/10 — {label(lv)}</span></span>'
                f'<span class="difficulty-meter">{meter(lv)}</span>'
                f'<div class="difficulty-sections">{chips}</div>'
                f'</div>\n'
            )
            # <div class="subhead">...</div> dan keyin qo'yamiz
            sm = re.search(r'(<div class="subhead">.*?</div>\s*)', raw, re.S)
            if sm:
                raw = raw[:sm.end(1)] + banner + raw[sm.end(1):]
            else:
                hm = re.search(r"(<h1>.*?</h1>\s*)", raw, re.S)
                if not hm:
                    print(f"  {f}: h1 topilmadi, o'tkazildi")
                    continue
                raw = raw[:hm.end(1)] + banner + raw[hm.end(1):]
            # CSS
            if ".difficulty-banner {" not in raw:
                cm = re.search(r"(\s*</style>)", raw)
                raw = raw[:cm.start(1)] + STYLE + raw[cm.start(1):]
            open(path, "w", encoding="utf-8").write(raw)
            total += 1
    print(f"Banner qo'shildi: {total} nazariya dars")


if __name__ == "__main__":
    main()
