#!/usr/bin/env python3
"""GujumEnglish — darslar statistikasi va qiyinlik baholari (Word hisoboti).

Shkala: 0-10, KONSEPTGA asoslangan (grammatik murakkablik), 4.0 markazli:
  4.0 = ilovaning "oddiy darsi" — asosiy o'quv darajasi.

Manbalar:
  - app/src/main/assets/grammar/difficulty.json   (baholar)
  - app/src/main/assets/grammar/groups.json        (to'plamlar)
  - UnitAllLessons HTML                            (so'z/gap/audio/mashq)
  - Lesson<N>Questions.kt                          (test savollari)

Chiqish: Statistika_va_Qiyinlik_Baholari.docx
"""
import json
import os
import re
from collections import Counter

from docx import Document
from docx.enum.text import WD_ALIGN_PARAGRAPH
from docx.enum.table import WD_TABLE_ALIGNMENT
from docx.shared import Pt, RGBColor, Cm

PROJ = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
GR = f"{PROJ}/app/src/main/assets/grammar/UnitAllLessons"
KT = f"{PROJ}/app/src/main/java/com/example/gujumenglish/ui/grammar/practice"
DIFF = f"{PROJ}/app/src/main/assets/grammar/difficulty.json"
GROUPS = f"{PROJ}/app/src/main/assets/grammar/groups.json"
OUT = f"{PROJ}/Statistika_va_Qiyinlik_Baholari.docx"

HEAD_RE = re.compile(r"<h([23])[^>]*>(.*?)</h\1>", re.S)
TAGS_RE = re.compile(r"<[^>]+>")
WORD_RE = re.compile(r'<span class="pair"><strong>([^<]{1,60})</strong>')
WORD2_RE = re.compile(r'<span class="w">([^<]{1,60})</span>')
SENT_RE = re.compile(r'<span class="en">(.*?)</span>', re.S)
EX_ITEM_RE = re.compile(r"<p>\s*(\d{1,2})[.)]\s+([^<]{2,120})</p>")
AUDIO_RE = re.compile(r"playOpus\('([^']+)'")

# ---------- shkala bandlari (ilova bilan bir xil) ----------

BANDS = [
    ("Oson", "< 2.5", 2.5, "2E7D32"),
    ("O'rtacha", "2.5 – 3.5", 3.5, "F9A825"),
    ("Standart", "3.5 – 5.0", 5.0, "2E7EA3"),
    ("Qiyin", "5.0 – 6.0", 6.0, "EF6C00"),
    ("Juda qiyin", "6.0 – 10", 99.0, "C62828"),
]


def band_of(v):
    for name, rng, hi, color in BANDS:
        if v < hi:
            return name, rng, color
    return BANDS[-1][0], BANDS[-1][1], BANDS[-1][3]


def plain(s):
    return re.sub(r"\s+", " ", TAGS_RE.sub("", s)).strip()


def collect():
    data = json.load(open(DIFF, encoding="utf-8"))
    diff = {l["lesson"]: l for l in data["lessons"]}

    def scan(practice):
        out = {}
        for u in range(0, 9):
            d = f"{GR}/unit_{u}"
            if not os.path.isdir(d):
                continue
            for f in sorted(os.listdir(d)):
                if not f.endswith(".html"):
                    continue
                is_pr = bool(re.match(r"\d+_Practice_", f))
                if is_pr != practice:
                    continue
                m = re.match(r"(\d+)_", f)
                if not m:
                    continue
                n = int(m.group(1))
                raw = open(os.path.join(d, f), encoding="utf-8").read()
                marks = [(x.start(), x.end(), plain(x.group(2)))
                         for x in HEAD_RE.finditer(raw)]
                secs = []
                for i, (s, e, title) in enumerate(marks):
                    end = marks[i + 1][0] if i + 1 < len(marks) else len(raw)
                    block = raw[e:end]
                    secs.append({
                        "title": title,
                        "words": len(WORD_RE.findall(block)) + len(WORD2_RE.findall(block)),
                        "gaps": sum(1 for x in SENT_RE.findall(block) if not WORD_RE.search(x)),
                        "items": len(EX_ITEM_RE.findall(block)),
                        "audio": len(AUDIO_RE.findall(block)),
                    })
                out[n] = {"file": f, "sections": secs}
        return out

    theory, practice = scan(False), scan(True)

    tests = {}
    for n in range(1, 68):
        p = f"{KT}/Lesson{n}Questions.kt"
        if not os.path.exists(p):
            continue
        raw = open(p, encoding="utf-8").read()
        c = Counter()
        for mm in re.finditer(r'section = "([^"]+)"', raw):
            c[mm.group(1).split("•")[0].strip()] += 1
        tests[n] = dict(c)

    groups = None
    if os.path.exists(GROUPS):
        groups = json.load(open(GROUPS, encoding="utf-8"))
    return diff, theory, practice, tests, groups


# ---------- Word yordamchilari ----------

def set_cell_bg(cell, hexcolor):
    from docx.oxml.ns import qn
    from docx.oxml import OxmlElement
    tcPr = cell._tc.get_or_add_tcPr()
    shd = OxmlElement("w:shd")
    shd.set(qn("w:val"), "clear")
    shd.set(qn("w:color"), "auto")
    shd.set(qn("w:fill"), hexcolor)
    tcPr.append(shd)


def add_table(doc, headers, rows, widths=None, header_bg="2E7EA3", size=9):
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


def sub(doc, text, size=8.5, color="4A6A85"):
    p = doc.add_paragraph()
    r = p.add_run(text)
    r.font.size = Pt(size)
    r.font.color.rgb = RGBColor.from_string(color)
    return p


def main():
    diff, theory, practice, tests, groups = collect()
    doc = Document()

    h = doc.add_heading("GujumEnglish — Darslar statistikasi va qiyinlik baholari", level=0)
    h.alignment = WD_ALIGN_PARAGRAPH.CENTER
    p = doc.add_paragraph()
    p.alignment = WD_ALIGN_PARAGRAPH.CENTER
    r = p.add_run(f"{len(diff)} ta nazariya dars • 0 dan 10 gacha qiyinlik baholari • "
                  f"4.0 = oddiy dars darajasi")
    r.italic = True
    r.font.size = Pt(10)
    r.font.color.rgb = RGBColor.from_string("4A6A85")

    # ================= 1. Shkala =================
    doc.add_heading("1. Baholash shkalasi (0–10)", level=1)
    doc.add_paragraph(
        "Har bir dars va uning bo'limlari bitta mezon bo'yicha baholandi: 0 dan 10 gacha. "
        "0 — umuman qiyin emas, 10 — juda qiyin."
    )
    doc.add_paragraph(
        "Baholashda grammatik konseptning murakkabligi asosiy o'lchov bo'ldi: qoidalar "
        "soni va ularning o'zaro bog'liqligi, shakllarning farqlanishi (masalan, "
        "to be / do / does), vaqt tizimlarining kombinatsiyasi. Lug'at hajmi va matn "
        "uzunligi hisobga olinmadi — aksincha, katta lug'atli lekin sodda dars qiyin "
        "bo'lib baholanmasligi kerak deb yondoshildi."
    )
    doc.add_paragraph(
        "Shkala kalibrlangan: ilovaning «oddiy darsi» 4.0 ballga teng. Shu sababli "
        "darslarning o'rtacha bahosi 4.0 atrofida turadi va 4.0 atrofidagi to'plamlar "
        "bitta qiyinlik darajasini ifodalaydi."
    )
    add_table(doc, ["Ball oralig'i", "Daraja", "Tushunishi"], [
        ["0 – 2.5", "Oson", "alifbo, tovushlar, lug'at ro'yxatlari"],
        ["2.5 – 3.5", "O'rtacha", "asosiy poydevor: ot/olmosh, egalik, predloglar"],
        ["3.5 – 5.0", "Standart", "o'shay o'rganish: present simple, savollar, there is"],
        ["5.0 – 6.0", "Qiyin", "past simple, kelajak, taqqoslash, bog'lovchilar"],
        ["6.0 – 10", "Juda qiyin", "shartli, passiv, reported speech, aralash topshiriq"],
    ], widths=[2.8, 3.0, 9.2])
    p = doc.add_paragraph()
    p.add_run("Dars darajasidagi ball: ").bold = True
    p.add_run("bo'limlar o'rtachasi × 60% + eng qiyin bo'lim × 40%. "
              "Shaklda bitta og'ir bo'lim darsni butunlay oson deb ko'rsatmaydi.")

    # ================= 2. Umumiy statistika =================
    doc.add_page_break()
    doc.add_heading("2. Umumiy statistika", level=1)

    all_sections = [(n, s) for n, info in theory.items() for s in info["sections"]]
    sec_diff = [s["difficulty"] for l in diff.values() for s in l["sections"]]
    les_diff = [l["difficulty"] for l in diff.values()]

    total_words = sum(s["words"] for _, s in all_sections)
    total_gaps = sum(s["gaps"] for _, s in all_sections)
    total_audio = sum(s["audio"] for _, s in all_sections)
    prac_items = sum(s["items"] for info in practice.values() for s in info["sections"])
    test_q = sum(sum(c.values()) for c in tests.values())

    add_table(doc, ["Ko'rsatkich", "Qiymat"], [
        ["Nazariya darslar", len(diff)],
        ["Nazariya bo'limlari", len(all_sections)],
        ["Amaliyot darslari", len(practice)],
        ["Testli darslar", len(tests)],
        ["Jami lug'at so'zlari", total_words],
        ["Jami namuna gaplari", total_gaps],
        ["Jami mashq elementi (amaliyotda)", prac_items],
        ["Jami test savoli", test_q],
        ["🔊 audio havolalari (nazariyada)", total_audio],
    ], widths=[9.0, 6.0])

    doc.add_paragraph()
    doc.add_heading("2.1. Darslar baholari taqsimoti", level=2)
    b1 = Counter(band_of(v)[0] for v in les_diff)
    t = add_table(doc, ["Darslar darajasi", "Soni", "Foiz"], [
        [name, b1.get(name, 0), f"{b1.get(name, 0) * 100 // len(les_diff)}%"]
        for name, _rng, _hi, _color in BANDS
    ], widths=[6.0, 3.0, 3.0])
    for name, _rng, _hi, color in BANDS:
        for row in t.rows[1:]:
            if row.cells[0].text == name:
                set_cell_bg(row.cells[0], color)
                for c in row.cells:
                    for p in c.paragraphs:
                        for r in p.runs:
                            r.font.color.rgb = RGBColor.from_string("1A1D21")

    doc.add_paragraph()
    doc.add_heading("2.2. Bo'limlar baholari taqsimoti", level=2)
    b2 = Counter()
    for v in sec_diff:
        b2[int(v)] += 1
    add_table(doc, ["Bo'limlar darajasi", "Soni", "Foiz"], [
        [f"{k} ball", v, f"{v * 100 // len(sec_diff)}%"]
        for k, v in sorted(b2.items())
    ], widths=[6.0, 3.0, 3.0])

    doc.add_paragraph()
    doc.add_heading("2.3. Reyting", level=2)
    add_table(doc, ["Reyting", "Darslar", "Bo'limlar"], [
        ["Minimal", f"{min(les_diff):.1f}", f"{min(sec_diff):.1f}"],
        ["Mediana", f"{sorted(les_diff)[len(les_diff) // 2]:.1f}",
         f"{sorted(sec_diff)[len(sec_diff) // 2]:.1f}"],
        ["Maksimal", f"{max(les_diff):.1f}", f"{max(sec_diff):.1f}"],
        ["O'rtacha", f"{sum(les_diff) / len(les_diff):.2f}",
         f"{sum(sec_diff) / len(sec_diff):.2f}"],
    ], widths=[5.0, 5.0, 5.0])

    # ================= 3. Darslar reytingi =================
    doc.add_page_break()
    doc.add_heading("3. Darslar reytingi (qiyinlik bo'yicha)", level=1)
    rows = []
    for n, l in sorted(diff.items(), key=lambda x: -x[1]["difficulty"]):
        t = theory.get(n, {})
        s_cnt = len(t.get("sections", []))
        w = sum(s["words"] for s in t.get("sections", []))
        worst = max(l["sections"], key=lambda x: x["difficulty"]) if l["sections"] else None
        rows.append([
            n, f"{l['difficulty']:.1f}", band_of(l["difficulty"])[0], s_cnt, w,
            worst["title"][:40] if worst else "-",
            f"{worst['difficulty']:.1f}" if worst else "-",
        ])
    t = add_table(doc,
                  ["Dars", "Ball", "Daraja", "Bo'lim", "So'z",
                   "Eng qiyin bo'lim", "Ball"],
                  rows, widths=[1.2, 1.2, 2.0, 1.4, 1.2, 6.4, 1.2])
    for row in t.rows[1:]:
        set_cell_bg(row.cells[1], band_of(float(row.cells[1].text))[2])
        for c in row.cells[2:]:
            for p in c.paragraphs:
                for r in p.runs:
                    r.font.color.rgb = RGBColor.from_string("1A1D21")

    # ================= 4. Eng qiyin / eng oson =================
    doc.add_page_break()
    doc.add_heading("4. Eng qiyin va eng oson bo'limlar", level=1)
    allb = sorted(
        ((s["difficulty"], n, s["title"]) for n, l in diff.items() for s in l["sections"]),
        key=lambda x: -x[0])

    doc.add_heading("4.1. Eng qiyin 25 bo'lim", level=2)
    t = add_table(doc, ["Ball", "Dars", "Bo'lim"], [
        [f"{sc:.1f}", n, title[:52]] for sc, n, title in allb[:25]
    ], widths=[1.4, 1.4, 12.2])
    for row in t.rows[1:]:
        set_cell_bg(row.cells[0], band_of(float(row.cells[0].text))[2])

    doc.add_paragraph()
    doc.add_heading("4.2. Eng oson 25 bo'lim", level=2)
    t = add_table(doc, ["Ball", "Dars", "Bo'lim"], [
        [f"{sc:.1f}", n, title[:52]] for sc, n, title in allb[-25:][::-1]
    ], widths=[1.4, 1.4, 12.2])
    for row in t.rows[1:]:
        set_cell_bg(row.cells[0], band_of(float(row.cells[0].text))[2])

    # ================= 5. Barcha darslar =================
    doc.add_page_break()
    doc.add_heading("5. Barcha darslar bo'limlari (batafsil)", level=1)
    for n in sorted(diff):
        l = diff[n]
        t = theory.get(n, {})
        p = practice.get(n, {})
        q = tests.get(n, {})
        doc.add_heading(
            f"{n}-dars — {l['difficulty']:.1f} ball ({band_of(l['difficulty'])[0]})", level=2)
        meta = (f"Nazariya: {len(t.get('sections', []))} bo'lim • "
                f"{sum(x['words'] for x in t.get('sections', []))} so'z • "
                f"{sum(x['gaps'] for x in t.get('sections', []))} gap • "
                f"{sum(x['audio'] for x in t.get('sections', []))} audio")
        if p:
            meta += (f"  |  Amaliyot: {len(p.get('sections', []))} mashq, "
                     f"{sum(x['items'] for x in p.get('sections', []))} element")
        if q:
            meta += f"  |  Test: {sum(q.values())} savol"
        sub(doc, meta)

        rows = []
        for s in sorted(l["sections"], key=lambda x: -x["difficulty"]):
            ts = next((x for x in t.get("sections", []) if x["title"] == s["title"]), None)
            rows.append([
                f"{s['difficulty']:.1f}", s["title"][:50],
                ts["words"] if ts else "-", ts["gaps"] if ts else "-",
                ts["audio"] if ts else "-",
            ])
        tb = add_table(doc, ["Ball", "Bo'lim", "So'z", "Gap", "Audio"],
                       rows, widths=[1.4, 9.0, 1.6, 1.6, 1.8])
        for row in tb.rows[1:]:
            set_cell_bg(row.cells[0], band_of(float(row.cells[0].text))[2])

    # ================= 6. To'plamlar =================
    if groups:
        doc.add_page_break()
        doc.add_heading("6. To'plamlarga guruhlash", level=1)
        gs = groups["groups"]
        devs = [abs(g["difficulty"] - 4.0) for g in gs]
        sizes = [len(g["sections"]) for g in gs]
        doc.add_paragraph(
            f"Darslar bo'limlari {len(gs)} ta to'plamga guruhlangan. "
            f"Har bir to'plamning o'rtacha qiyinligi 4.0 ga yaqin: eng katta farq "
            f"{max(devs):.3f} ball."
        )
        add_table(doc, ["Ko'rsatkich", "Qiymat"], [
            ["To'plamlar soni", len(gs)],
            ["To'plamdagi bo'limlar (min–max)", f"{min(sizes)}–{max(sizes)}"],
            ["O'rtacha qiyinlik", f"{sum(g['difficulty'] for g in gs) / len(gs):.2f}"],
            ["4.0 dan eng katta farq", f"{max(devs):.3f}"],
            ["4 ± 0.1 da bo'lgan to'plamlar",
             f"{sum(1 for x in devs if x <= 0.1)} / {len(gs)}"],
            ["Jami bo'lim", f"{sum(sizes)} / {len(all_sections)}"],
        ], widths=[9.0, 6.0])
        sub(doc, "To'plamlar ro'yxati: Darslar_Bolimlarini_Guruhlash_4_Daraja.docx faylida.")

    # ================= 7. Xulosa =================
    doc.add_page_break()
    doc.add_heading("7. Xulosa", level=1)
    hard = sorted(n for n, l in diff.items() if l["difficulty"] >= 5.0)
    easy = sorted(n for n, l in diff.items() if l["difficulty"] < 3.5)
    doc.add_paragraph(
        f"• Eng qiyin darslar ({', '.join(map(str, hard))}): murakkab grammatika "
        f"birlashtirilgan (taqqoslash, qisqa sifatlar, to'g'ri shakl tanlash, "
        f"aralash topshiriqlar). Bu darslarga ko'proq vaqt va takrorlash tavsiya etiladi."
    )
    doc.add_paragraph(
        f"• Eng oson darslar ({', '.join(map(str, easy))}): asosan lug'at, alifbo va "
        f"mavzu bo'limlari — o'z-o'zidan tez o'zlashtiriladi."
    )
    doc.add_paragraph(
        "• Darslar orasidagi farq 1.9 dan 6.6 gacha. Bu grammatik konseptning "
        "haqiqiy farqini ifodalaydi: o'quv darsi (present simple) bilan yakuniy "
        "aralash topshiriq darsi bir darajada emas."
    )
    doc.add_paragraph(
        "• Test savollari soni barcha darslarda deyarli bir xil. Bu yaxshi tenglik: "
        "dars oson bo'lsa ham, mustaqil test shu qiyinlikni o'lchaydi."
    )
    if groups:
        doc.add_paragraph(
            "• To'plamlar aralash qiyinlikda tuzilgan: har bir to'plamda oson va "
            "qiyin bo'limlar muvozanatlanadi, shuning uchun barcha to'plamlar bir xil "
            "(4.0) darajada o'qiladi."
        )

    doc.save(OUT)
    print(f"Yozildi: {OUT} ({os.path.getsize(OUT) // 1024} KB)")
    print(f"Darslar: {len(diff)} | bo'limlar: {len(all_sections)} | "
          f"dars o'rtacha {sum(les_diff) / len(les_diff):.2f} | "
          f"bo'lim o'rtacha {sum(sec_diff) / len(sec_diff):.2f}")


if __name__ == "__main__":
    main()
