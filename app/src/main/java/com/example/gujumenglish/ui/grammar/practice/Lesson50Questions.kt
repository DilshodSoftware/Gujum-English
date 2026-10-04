package com.example.gujumenglish.ui.grammar.practice

internal val lesson50Questions: List<Question> = listOf(
    Question.Text(
        section = "1-mashq • Fe’lning o‘tgan shaklini yozing",
        prompt = "work → ___",
        answers = setOf("worked"),
        explanation = "Oddiy -ed: worked."
    ),
    Question.Text(
        section = "1-mashq • Fe’lning o‘tgan shaklini yozing",
        prompt = "help → ___",
        answers = setOf("helped"),
        explanation = "Oddiy -ed: helped."
    ),
    Question.Text(
        section = "1-mashq • Fe’lning o‘tgan shaklini yozing",
        prompt = "live → ___",
        answers = setOf("lived"),
        explanation = "Oddiy -ed: lived."
    ),
    Question.Text(
        section = "1-mashq • Fe’lning o‘tgan shaklini yozing",
        prompt = "study → ___",
        answers = setOf("studied"),
        explanation = "undosh + y → -ied: studied."
    ),
    Question.Text(
        section = "1-mashq • Fe’lning o‘tgan shaklini yozing",
        prompt = "play → ___",
        answers = setOf("played"),
        explanation = "unli + y → -ed: played."
    ),
    Question.Text(
        section = "1-mashq • Fe’lning o‘tgan shaklini yozing",
        prompt = "stop → ___",
        answers = setOf("stopped"),
        explanation = "p dan keyin -ed ikkilanadi: stopped."
    ),
    Question.Text(
        section = "1-mashq • Fe’lning o‘tgan shaklini yozing",
        prompt = "watch → ___",
        answers = setOf("watched"),
        explanation = "Oddiy -ed: watched."
    ),
    Question.Text(
        section = "1-mashq • Fe’lning o‘tgan shaklini yozing",
        prompt = "enjoy → ___",
        answers = setOf("enjoyed"),
        explanation = "unli + y → -ed: enjoyed."
    ),
    Question.Choice(
        section = "2-mashq • Imlo qoidasini aniqlang",
        prompt = "like → liked — qaysi qoida?",
        options = listOf("e bilan tugaydi, faqat -d", "y o‘zgaradi"),
        answer = "e bilan tugaydi, faqat -d",
        explanation = "e bilan tugagan fe’lga faqat -d qo‘shiladi: liked."
    ),
    Question.Choice(
        section = "2-mashq • Imlo qoidasini aniqlang",
        prompt = "carry → carried — qaysi qoida?",
        options = listOf("undosh+y", "unli+y"),
        answer = "undosh+y",
        explanation = "undosh + y: y → i + ed: carried."
    ),
    Question.Choice(
        section = "2-mashq • Imlo qoidasini aniqlang",
        prompt = "play → played — qaysi qoida?",
        options = listOf("undosh+y", "unli+y"),
        answer = "unli+y",
        explanation = "unli + y: faqat -ed: played."
    ),
    Question.Choice(
        section = "2-mashq • Imlo qoidasini aniqlang",
        prompt = "plan → planned — qaysi qoida?",
        options = listOf(
            "qisqa fe’l, oxirgi undosh ikki marta yoziladi",
            "oddiy -ed"
        ),
        answer = "qisqa fe’l, oxirgi undosh ikki marta yoziladi",
        explanation = "Qisqa fe’lda -ed ikkilanadi: planned."
    ),
    Question.Text(
        section = "3-mashq • Gapni Past Simple bilan to‘ldiring",
        prompt = "We ___ the room yesterday. (clean)",
        answers = setOf("cleaned"),
        explanation = "To‘g‘ri shakl: cleaned."
    ),
    Question.Text(
        section = "3-mashq • Gapni Past Simple bilan to‘ldiring",
        prompt = "He ___ his aunt last week. (visit)",
        answers = setOf("visited"),
        explanation = "To‘g‘ri shakl: visited."
    ),
    Question.Text(
        section = "3-mashq • Gapni Past Simple bilan to‘ldiring",
        prompt = "I ___ the door an hour ago. (open)",
        answers = setOf("opened"),
        explanation = "To‘g‘ri shakl: opened."
    ),
    Question.Text(
        section = "3-mashq • Gapni Past Simple bilan to‘ldiring",
        prompt = "Sara ___ English yesterday. (study)",
        answers = setOf("studied"),
        explanation = "To‘g‘ri shakl: studied."
    ),
    Question.Text(
        section = "3-mashq • Gapni Past Simple bilan to‘ldiring",
        prompt = "The bus ___ near the school. (stop)",
        answers = setOf("stopped"),
        explanation = "To‘g‘ri shakl: stopped."
    ),
    Question.Choice(
        section = "4-mashq • Vaqt iborasini gapga moslang",
        prompt = "We watched a film ___.",
        options = listOf("last night", "yesterday", "two days ago", "every day"),
        answer = "last night",
        explanation = "Namunaviy javob: last night."
    ),
    Question.Choice(
        section = "4-mashq • Vaqt iborasini gapga moslang",
        prompt = "I visit my grandmother ___ . (o‘tgan zamon)",
        options = listOf("two days ago", "every day"),
        answer = "two days ago",
        explanation = "O‘tgan zamon belgisi: two days ago."
    ),
    Question.Choice(
        section = "4-mashq • Vaqt iborasini gapga moslang",
        prompt = "She called me ___.",
        options = listOf("yesterday", "every day"),
        answer = "yesterday",
        explanation = "To‘g‘ri shakl: yesterday."
    ),
    Question.Choice(
        section = "4-mashq • Vaqt iborasini gapga moslang",
        prompt = "«Har kuni» qaysi ibora?",
        options = listOf("yesterday", "every day"),
        answer = "every day",
        explanation = "Har kuni — every day (odat, Past Simple emas)."
    ),
    Question.Choice(
        section = "5-mashq • -ED talaffuzini tasniflang",
        prompt = "worked — qanday talaffuz qilinadi?",
        options = listOf("“t”ga yaqin", "“d”ga yaqin", "alohida “id”"),
        answer = "“t”ga yaqin",
        explanation = "k dan keyin -ed “t”ga yaqin bo‘ladi."
    ),
    Question.Choice(
        section = "5-mashq • -ED talaffuzini tasniflang",
        prompt = "played — qanday talaffuz qilinadi?",
        options = listOf("“t”ga yaqin", "“d”ga yaqin", "alohida “id”"),
        answer = "“d”ga yaqin",
        explanation = "l dan keyin -ed “d”ga yaqin bo‘ladi."
    ),
    Question.Choice(
        section = "5-mashq • -ED talaffuzini tasniflang",
        prompt = "wanted — qanday talaffuz qilinadi?",
        options = listOf("“t”ga yaqin", "“d”ga yaqin", "alohida “id”"),
        answer = "alohida “id”",
        explanation = "t dan keyin -ed alohida “id” bo‘g‘ini beradi."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «She studyed yesterday.»",
        answers = setOf("She studied yesterday."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: She studied yesterday."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «We stoped at the shop.»",
        answers = setOf("We stopped at the shop."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: We stopped at the shop."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «They liveed in a small town.»",
        answers = setOf("They lived in a small town."),
        mode = TextMode.SENTENCE,
        explanation = "e bilan tugagan fe’lga faqat -d: lived."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «He plaied football last Sunday.»",
        answers = setOf("He played football last Sunday."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: He played football last Sunday."
    ),
    Question.TrueFalse(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Past Simple muntazam fe’li barcha egalar bilan bir xil shaklda o‘zgaradi.",
        answer = true,
        explanation = "Bu gap to‘g‘ri: I worked, she worked."
    )
)