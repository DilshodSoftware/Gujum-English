package com.example.gujumenglish.ui.grammar.practice

internal val lesson6Questions: List<Question> = listOf(
    Question.Text(
        section = "1-mashq • Jim harfni toping",
        prompt = "name — oxiridagi qaysi harf aytilmaydi?",
        answers = setOf("e"),
        explanation = "name so‘zida oxirgi e aytilmaydi."
    ),
    Question.Text(
        section = "1-mashq • Jim harfni toping",
        prompt = "lamb — oxiridagi qaysi harf aytilmaydi?",
        answers = setOf("b"),
        explanation = "lamb so‘zida oxirgi b aytilmaydi."
    ),
    Question.Text(
        section = "1-mashq • Jim harfni toping",
        prompt = "listen — qaysi harf aytilmaydi?",
        answers = setOf("t"),
        explanation = "listen so‘zida t aytilmaydi."
    ),
    Question.Text(
        section = "1-mashq • Jim harfni toping",
        prompt = "know — boshidagi qaysi harf aytilmaydi?",
        answers = setOf("k"),
        explanation = "know so‘zida boshdagi k aytilmaydi."
    ),
    Question.Text(
        section = "1-mashq • Jim harfni toping",
        prompt = "write — boshidagi qaysi harf aytilmaydi?",
        answers = setOf("w"),
        explanation = "write so‘zida boshdagi w aytilmaydi."
    ),
    Question.Text(
        section = "1-mashq • Jim harfni toping",
        prompt = "could — qaysi harf aytilmaydi?",
        answers = setOf("l"),
        explanation = "could so‘zida l aytilmaydi."
    ),
    Question.Text(
        section = "1-mashq • Jim harfni toping",
        prompt = "autumn — oxiridagi qaysi harf aytilmaydi?",
        answers = setOf("n"),
        explanation = "autumn so‘zida oxirgi n aytilmaydi."
    ),
    Question.Text(
        section = "1-mashq • Jim harfni toping",
        prompt = "night — qaysi harf birikmasi alohida tovush bermaydi?",
        answers = setOf("gh"),
        explanation = "night so‘zida gh alohida tovush bermaydi."
    ),
    Question.Text(
        section = "1-mashq • Jim harfni toping",
        prompt = "ballet — oxiridagi qaysi harf odatda aytilmaydi?",
        answers = setOf("t"),
        explanation = "ballet so‘zida oxirgi t odatda aytilmaydi."
    ),
    Question.Matching(
        section = "2-mashq • So‘zni jim harf bilan moslang",
        prompt = "Har bir so‘zni undagi jim harf bilan bog‘lang.",
        pairs = listOf(
            "comb" to "b",
            "knee" to "k",
            "wrong" to "w",
            "thumb" to "b",
            "column" to "n"
        ),
        options = listOf("b", "k", "w", "n"),
        explanation = "comb—b, knee—k, wrong—w, thumb—b, column—n."
    ),
    Question.TrueFalse(
        section = "3-mashq • GH qachon jim?",
        prompt = "night so‘zida gh jim turadi.",
        answer = true,
        explanation = "Bu gap to‘g‘ri: night da gh alohida tovush bermaydi."
    ),
    Question.Choice(
        section = "3-mashq • GH qachon jim?",
        prompt = "laugh so‘zida gh jim turadimi yoki tovush beradimi?",
        options = listOf("jim turadi", "f ga yaqin tovush beradi"),
        answer = "f ga yaqin tovush beradi",
        explanation = "laugh so‘zida gh “f”ga yaqin tovush beradi."
    ),
    Question.Choice(
        section = "3-mashq • GH qachon jim?",
        prompt = "Qaysi so‘zda gh “f”ga yaqin tovush beradi?",
        options = listOf("high", "cough", "though"),
        answer = "cough",
        explanation = "cough so‘zida gh “f”ga yaqin aytiladi."
    ),
    Question.TrueFalse(
        section = "4-mashq • To‘g‘ri yoki noto‘g‘ri",
        prompt = "Jim harf talaffuzda aytilmaydi, lekin yozuvda qoladi.",
        answer = true,
        explanation = "Bu gap to‘g‘ri: silent letter shunday ta’riflanadi."
    ),
    Question.TrueFalse(
        section = "4-mashq • To‘g‘ri yoki noto‘g‘ri",
        prompt = "Oxiridagi e har bir inglizcha so‘zda jim bo‘ladi.",
        answer = false,
        explanation = "Bu gap noto‘g‘ri: hamma so‘zda ham shunday emas."
    ),
    Question.TrueFalse(
        section = "4-mashq • To‘g‘ri yoki noto‘g‘ri",
        prompt = "write so‘zidagi w yoziladi, lekin aytilmaydi.",
        answer = true,
        explanation = "Bu gap to‘g‘ri: write da boshdagi w jim."
    ),
    Question.TrueFalse(
        section = "4-mashq • To‘g‘ri yoki noto‘g‘ri",
        prompt = "laugh so‘zidagi gh jim.",
        answer = false,
        explanation = "Bu gap noto‘g‘ri: laugh da gh “f”ga yaqin tovush beradi."
    ),
    Question.TrueFalse(
        section = "4-mashq • To‘g‘ri yoki noto‘g‘ri",
        prompt = "Har qanday gh birikmasi doimo bir xil talaffuz qilinadi.",
        answer = false,
        explanation = "Bu gap noto‘g‘ri: night, laugh va though da turlicha."
    ),
    Question.Matching(
        section = "5-mashq • So‘zlarni jim harfiga qarab guruhlang",
        prompt = "Har bir so‘zni undagi jim harf bilan bog‘lang.",
        pairs = listOf(
            "name" to "e",
            "lamb" to "b",
            "listen" to "t",
            "knee" to "k",
            "write" to "w"
        ),
        options = listOf("e", "b", "t", "k", "w"),
        explanation = "name—e, lamb—b, listen—t, knee—k, write—w."
    ),
    Question.MultiChoice(
        section = "6-mashq • Talaffuzni qanday tekshiramiz?",
        prompt = "Yangi so‘z uchradi. Qaysi ishlar yordam beradi?",
        options = listOf(
            "Faqat harflarni taxminan o‘qish",
            "Audio talaffuzini tinglash",
            "So‘zni ovoz chiqarib takrorlash",
            "Jim harfni ham albatta aytish"
        ),
        answers = setOf("Audio talaffuzini tinglash", "So‘zni ovoz chiqarib takrorlash"),
        explanation = "To‘g‘ri javob: b va c."
    )
)
