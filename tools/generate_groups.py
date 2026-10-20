#!/usr/bin/env python3
"""Darslar bo'limlarini 4-darajali to'plamlarga guruhlash (Word + groups.json).

Usul:
  1) Bo'limlar qiyinlik bo'yicha kamayish tartibida saralanadi va
     "snake" usuli bilan to'plamlarga taqsimlanadi (sumalari tenglashadi).
  2) Mahalliy optimallashtirish: eng yomon to'plamlar bo'lim almashtirish
     orqali yaxshilanadi.
  Natija: HAR BIR to'plamning o'rtacha qiyinligi 4.0 ga yaqin (chek ~0.1).
  To'plam ichidagi bo'limlar o'quv tartibida saqlanadi, to'plamlar ham
  darslar tartibida joylashtiriladi.

Chiqish:
  - Darslar_Bolimlarini_Guruhlash_4_Daraja.docx  (hisobot)
  - app/src/main/assets/grammar/groups.json      (ilova uchun)
"""
import json
import os

from docx import Document
from docx.enum.text import WD_ALIGN_PARAGRAPH
from docx.enum.table import WD_TABLE_ALIGNMENT
from docx.shared import Pt, RGBColor, Cm

PROJ = "/home/dilshod/AndroidStudioProjects/GujumEnglish"
DIFF = f"{PROJ}/app/src/main/assets/grammar/difficulty.json"
GROUPS = f"{PROJ}/app/src/main/assets/grammar/groups.json"
OUT = f"{PROJ}/Darslar_Bolimlarini_Guruhlash_4_Daraja.docx"

TARGET = 4.0
K_GROUPS = 100


def set_cell_bg(cell, hexcolor):
    from docx.oxml.ns import qn
    from docx.oxml import OxmlElement
    tcPr = cell._tc.get_or_add_tcPr()
    shd = OxmlElement("w:shd")
    shd.set(qn("w:val"), "clear")
    shd.set(qn("w:color"), "auto")
    shd.set(qn("w:fill"), hexcolor)
    tcPr.append(shd)


def add_table(doc, headers, rows, widths=None, header_bg="2E7EA3", size=8.5):
    t = doc.add_table(rows=1, cols=len(headers))
    t.style = "Table Grid"
    t.alignment = WD_TABLE_ALIGNMENT.CENTER
    t.autofit = False
    hdr = t.rows[0].cells
    for i, h in enumerate(headers):
        hdr[i].text = ""
        run = hdr[i].paragraphs[0].add_run(h)
        run.bold = True
        run.font.size = Pt(size)
        run.font.color.rgb = RGBColor(0xFF, 0xFF, 0xFF)
        set_cell_bg(hdr[i], header_bg)
    for r in rows:
        cells = t.add_row().cells
        for i, v in enumerate(r):
            cells[i].text = ""
            run = cells[i].paragraphs[0].add_run(str(v))
            run.font.size = Pt(size)
    if widths:
        for row in t.rows:
            for i, w in enumerate(widths):
                row.cells[i].width = Cm(w)
        for i, col in enumerate(t.columns):
            col.width = Cm(widths[i])
    return t


def color_for(v):
    """Shkala 4.0 markazli (ilova va banner bilan bir xil)."""
    if v < 2.5: return "2E7D32"
    if v < 3.5: return "F9A825"
    if v < 5.0: return "2E7EA3"
    if v < 6.0: return "EF6C00"
    return "C62828"


def build(seq, k=K_GROUPS, target=TARGET):
    n = len(seq)
    # 1) snake
    srt = sorted(range(n), key=lambda i: -seq[i][2])
    groups = [[] for _ in range(k)]
    for pos, idx in enumerate(srt):
        cycle, off = divmod(pos, k)
        gi = off if cycle % 2 == 0 else k - 1 - off
        groups[gi].append(idx)
    means = [sum(seq[i][2] for i in g) / len(g) for g in groups]

    # 2) mahalliy optimallashtirish
    for _ in range(6000):
        w = max(range(k), key=lambda x: abs(means[x] - target))
        if abs(means[w] - target) < 0.02:
            break
        best = None
        for gi in range(k):
            if gi == w:
                continue
            for a in groups[w]:
                for b in groups[gi]:
                    na = means[w] + (seq[b][2] - seq[a][2]) / len(groups[w])
                    nb = means[gi] + (seq[a][2] - seq[b][2]) / len(groups[gi])
                    before = max(abs(means[w] - target), abs(means[gi] - target))
                    after = max(abs(na - target), abs(nb - target))
                    if after < before - 1e-9 and (best is None or after < best[0]):
                        best = (after, gi, a, b, na, nb)
        if best is None:
            break
        _, gi, a, b, na, nb = best
        groups[w][groups[w].index(a)] = b
        groups[gi][groups[gi].index(b)] = a
        means[w], means[gi] = na, nb

    # 3) to'plam ichida o'quv tartibi, to'plamlar darslar tartibida
    groups = [sorted(g) for g in groups]
    groups.sort(key=lambda g: g[0])
    return groups, means


def main():
    data = json.load(open(DIFF, encoding="utf-8"))
    seq = []
    for l in sorted(data["lessons"], key=lambda x: x["lesson"]):
        for s in l["sections"]:
            seq.append((l["lesson"], s["title"], s["difficulty"]))
    groups, means = build(seq)

    assert sum(len(g) for g in groups) == len(seq)

    # --- ilova uchun JSON ---
    gjson = {
        "schemaVersion": 1,
        "target": TARGET,
        "groups": [
            {
                "group": i + 1,
                "difficulty": round(means[i], 2),
                "sections": [
                    {"lesson": seq[j][0], "title": seq[j][1], "difficulty": seq[j][2]}
                    for j in g
                ],
            }
            for i, g in enumerate(groups)
        ],
    }
    json.dump(gjson, open(GROUPS, "w", encoding="utf-8"), ensure_ascii=False, indent=2)

    # --- Word ---
    doc = Document()
    h = doc.add_heading("Darslar bo‘limlarini 4-darajali to‘plamlarga guruhlash", level=0)
    h.alignment = WD_ALIGN_PARAGRAPH.CENTER
    p = doc.add_paragraph()
    p.alignment = WD_ALIGN_PARAGRAPH.CENTER
    r = p.add_run(
        f"{len(groups)} ta to‘plam • {len(seq)} ta bo‘lim • "
        f"har bir to‘plamning o‘rtacha qiyinligi 4.0 ga yaqin (0–10 shkalasi)"
    )
    r.italic = True
    r.font.size = Pt(10)
    r.font.color.rgb = RGBColor(0x4A, 0x6A, 0x85)

    for i, g in enumerate(groups, 1):
        secs = [seq[j] for j in g]
        lns = sorted(set(x[0] for x in secs))
        span = f"{lns[0]}–{lns[-1]}-dars" if len(lns) > 1 else f"{lns[0]}-dars"
        p = doc.add_paragraph()
        p.add_run(f"To‘plam {i}: ").bold = True
        r = p.add_run(f"{len(secs)} ta bo‘lim • {span} • o‘rtacha {means[i - 1]:.2f}")
        r.font.size = Pt(9)
        r.font.color.rgb = RGBColor(0x4A, 0x6A, 0x85)
        rows = [[f"{d:.1f}", f"{ln}-dars", title[:60]] for ln, title, d in secs]
        tb = add_table(doc, ["Ball", "Dars", "Bo‘lim"], rows,
                       widths=[1.6, 1.8, 11.6], size=8)
        for row in tb.rows[1:]:
            set_cell_bg(row.cells[0], color_for(float(row.cells[0].text)))

    doc.save(OUT)

    dev = [abs(m - TARGET) for m in means]
    spans = [max(x[0] for x in [seq[j] for j in g]) -
             min(x[0] for x in [seq[j] for j in g]) for g in groups]
    print(f"Yozildi: {OUT} ({os.path.getsize(OUT) // 1024} KB)")
    print(f"        {GROUPS}")
    print(f"To‘plamlar: {len(groups)} | o‘rtacha {sum(means)/len(means):.3f} | "
          f"max |farq| {max(dev):.3f} | 4±0.1: {sum(1 for x in dev if x<=0.1)}/{len(groups)} | "
          f"bo'lim band: {sum(len(g) for g in groups)}/{len(seq)}")
    print(f"To‘plamdagi dars oralig‘i: o‘rtacha {sum(spans)/len(spans):.1f}, max {max(spans)}")


if __name__ == "__main__":
    main()
