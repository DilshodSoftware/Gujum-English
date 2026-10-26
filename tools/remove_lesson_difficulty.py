#!/usr/bin/env python3
"""Nazariya dars HTML sahifalaridan qiyinlik banneri va unga tegishli CSS ni olib tashlash."""
import glob
import re

ROOT = "/home/dilshod/AndroidStudioProjects/GujumEnglish"
FILES = glob.glob(f"{ROOT}/app/src/main/assets/grammar/**/*.html", recursive=True)

CSS_RE = re.compile(
    r"\n\s*\.difficulty-banner \{.*?\.difficulty-meter i \{[^}]*\}\n",
    re.S,
)

changed = banners = css_removed = 0
for path in FILES:
    text = open(path, encoding="utf-8").read()
    if "difficulty" not in text:
        continue

    lines = text.splitlines(keepends=True)
    kept = [line for line in lines if 'class="difficulty-banner"' not in line]
    new = "".join(kept)
    if len(kept) != len(lines):
        banners += 1

    new, n = CSS_RE.subn("\n", new)
    if n:
        css_removed += 1

    if new != text:
        with open(path, "w", encoding="utf-8", newline="") as fh:
            fh.write(new)
        changed += 1

print(f"o'zgartirildi: {changed} | banner olib tashlandi: {banners} | CSS olib tashlandi: {css_removed}")

# tekshiruv
left = [p for p in FILES if "difficulty" in open(p, encoding="utf-8").read().lower()]
print(f"qolgan 'difficulty' fayllar: {len(left)}")
for p in left[:5]:
    print("  ", p)
