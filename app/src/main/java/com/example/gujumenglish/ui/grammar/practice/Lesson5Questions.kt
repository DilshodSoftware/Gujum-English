package com.example.gujumenglish.ui.grammar.practice

internal val lesson5Questions: List<Question> = listOf(
    Question.Text(
        section = "1-mashq • Bo‘sh joyni to‘ldiring",
        prompt = "fi__ (baliq) — tushib qolgan birikmani yozing.",
        answers = setOf("sh"),
        explanation = "fish so‘zida sh birikmasi bor."
    ),
    Question.Text(
        section = "1-mashq • Bo‘sh joyni to‘ldiring",
        prompt = "__air (stul) — tushib qolgan birikmani yozing.",
        answers = setOf("ch"),
        explanation = "chair so‘zida ch birikmasi bor."
    ),
    Question.Text(
        section = "1-mashq • Bo‘sh joyni to‘ldiring",
        prompt = "__ink (o‘ylamoq) — tushib qolgan birikmani yozing.",
        answers = setOf("th"),
        explanation = "think so‘zida th birikmasi bor."
    ),
    Question.Text(
        section = "1-mashq • Bo‘sh joyni to‘ldiring",
        prompt = "__one (telefon) — tushib qolgan birikmani yozing.",
        answers = setOf("ph"),
        explanation = "phone so‘zida ph birikmasi bor."
    ),
    Question.Text(
        section = "1-mashq • Bo‘sh joyni to‘ldiring",
        prompt = "__at (nima) — tushib qolgan birikmani yozing.",
        answers = setOf("wh"),
        explanation = "what so‘zida wh birikmasi bor."
    ),
    Question.Text(
        section = "1-mashq • Bo‘sh joyni to‘ldiring",
        prompt = "clo__ (soat) — tushib qolgan birikmani yozing.",
        answers = setOf("ck"),
        explanation = "clock so‘zida ck birikmasi bor."
    ),
    Question.Text(
        section = "1-mashq • Bo‘sh joyni to‘ldiring",
        prompt = "si__ (kuylamoq) — tushib qolgan birikmani yozing.",
        answers = setOf("ng"),
        explanation = "sing so‘zida ng birikmasi bor."
    ),
    Question.Matching(
        section = "2-mashq • Birikmani ta’rif bilan moslang",
        prompt = "Har bir birikmani to‘g‘ri ta’rif bilan bog‘lang.",
        pairs = listOf(
            "sh" to "sh",
            "ph" to "ko‘pincha f",
            "ck" to "k ga yaqin",
            "th" to "maxsus inglizcha tovushlar"
        ),
        options = listOf("sh", "ko‘pincha f", "k ga yaqin", "maxsus inglizcha tovushlar"),
        explanation = "sh—sh, ph—f, ck—k, th—maxsus tovushlar."
    ),
    Question.Choice(
        section = "3-mashq • Qaysi so‘zda birikma boshqacha?",
        prompt = "Ko‘pincha “ch” tovushida qaysi so‘z aytiladi?",
        options = listOf("chair", "chef"),
        answer = "chair",
        explanation = "chair so‘zida ch odatdagi “ch” tovushini beradi."
    ),
    Question.Choice(
        section = "3-mashq • Qaysi so‘zda birikma boshqacha?",
        prompt = "“sh”ga yaqin ch tovushi qaysi so‘zda?",
        options = listOf("child", "chef"),
        answer = "chef",
        explanation = "chef so‘zidagi ch “sh”ga yaqin aytiladi."
    ),
    Question.Choice(
        section = "3-mashq • Qaysi so‘zda birikma boshqacha?",
        prompt = "“k”ga yaqin ch tovushi qaysi so‘zda?",
        options = listOf("chorus", "chair"),
        answer = "chorus",
        explanation = "chorus so‘zidagi ch “k”ga yaqin aytiladi."
    ),
    Question.Choice(
        section = "3-mashq • Qaysi so‘zda birikma boshqacha?",
        prompt = "phone so‘zidagi ph odatda qaysi tovushga yaqin?",
        options = listOf("p", "f", "h"),
        answer = "f",
        explanation = "phone so‘zida ph “f”ga yaqin aytiladi."
    ),
    Question.Choice(
        section = "4-mashq • TH jaranglimi yoki jarangsizmi?",
        prompt = "bath so‘zidagi th qaysi turga kiradi?",
        options = listOf("jarangsiz", "jarangli"),
        answer = "jarangsiz",
        explanation = "bath so‘zida th jarangsiz aytiladi."
    ),
    Question.Choice(
        section = "4-mashq • TH jaranglimi yoki jarangsizmi?",
        prompt = "mother so‘zidagi th qaysi turga kiradi?",
        options = listOf("jarangsiz", "jarangli"),
        answer = "jarangli",
        explanation = "mother so‘zida th jarangli aytiladi."
    ),
    Question.TrueFalse(
        section = "5-mashq • To‘g‘ri yoki noto‘g‘ri",
        prompt = "ship so‘zida sh ikki alohida tovush qilib o‘qiladi.",
        answer = false,
        explanation = "Bu gap noto‘g‘ri: sh bitta tovush bo‘lib o‘qiladi."
    ),
    Question.TrueFalse(
        section = "5-mashq • To‘g‘ri yoki noto‘g‘ri",
        prompt = "phone so‘zida ph “f”ga yaqin tovush beradi.",
        answer = true,
        explanation = "Bu gap to‘g‘ri: ph “f”ga yaqin aytiladi."
    ),
    Question.TrueFalse(
        section = "5-mashq • To‘g‘ri yoki noto‘g‘ri",
        prompt = "ch har doim bir xil o‘qiladi.",
        answer = false,
        explanation = "Bu gap noto‘g‘ri: chair, chef va chorus da turlicha o‘qiladi."
    ),
    Question.TrueFalse(
        section = "5-mashq • To‘g‘ri yoki noto‘g‘ri",
        prompt = "think va this so‘zlaridagi th bir xil tovushdir.",
        answer = false,
        explanation = "Bu gap noto‘g‘ri: bittasi jarangsiz, bittasi jarangli."
    ),
    Question.Matching(
        section = "6-mashq • So‘zdagi birikmani toping",
        prompt = "Har bir so‘zdagi ikki harfli birikmani bog‘lang.",
        pairs = listOf(
            "ship" to "sh",
            "chair" to "ch",
            "think" to "th",
            "photo" to "ph",
            "black" to "ck",
            "song" to "ng"
        ),
        options = listOf("sh", "ch", "th", "ph", "ck", "ng"),
        explanation = "ship—sh, chair—ch, think—th, photo—ph, black—ck, song—ng."
    )
)
