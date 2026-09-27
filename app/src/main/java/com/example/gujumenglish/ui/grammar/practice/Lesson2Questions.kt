package com.example.gujumenglish.ui.grammar.practice

internal val lesson2Questions: List<Question> = listOf(
    Question.Choice(
        section = "1-mashq • Alifboni eslab yozing",
        prompt = "Ingliz alifbosida nechta harf bor?",
        options = listOf("24", "26", "28"),
        answer = "26",
        explanation = "Ingliz alifbosida 26 ta harf bor."
    ),
    Question.Text(
        section = "1-mashq • Alifboni eslab yozing",
        prompt = "Katta harflarni A dan Z gacha tartibda yozing.",
        answers = setOf("ABCDEFGHIJKLMNOPQRSTUVWXYZ"),
        mode = TextMode.UPPER_ALPHABET,
        explanation = "To‘g‘ri ketma-ketlik: A dan Z gacha 26 ta katta harf."
    ),
    Question.Text(
        section = "1-mashq • Alifboni eslab yozing",
        prompt = "Kichik harflarni a dan z gacha tartibda yozing.",
        answers = setOf("abcdefghijklmnopqrstuvwxyz"),
        mode = TextMode.LOWER_ALPHABET,
        explanation = "To‘g‘ri ketma-ketlik: a dan z gacha 26 ta kichik harf."
    ),
    Question.Text(
        section = "2-mashq • Yetishmayotgan harfni toping",
        prompt = "A, B, ___, D, E — tushib qolgan harfni yozing.",
        answers = setOf("c"),
        explanation = "To‘g‘ri javob: C."
    ),
    Question.Text(
        section = "2-mashq • Yetishmayotgan harfni toping",
        prompt = "G, H, ___, J — tushib qolgan harfni yozing.",
        answers = setOf("i"),
        explanation = "To‘g‘ri javob: I."
    ),
    Question.Text(
        section = "2-mashq • Yetishmayotgan harfni toping",
        prompt = "M, N, ___, P — tushib qolgan harfni yozing.",
        answers = setOf("o"),
        explanation = "To‘g‘ri javob: O."
    ),
    Question.Text(
        section = "2-mashq • Yetishmayotgan harfni toping",
        prompt = "R, S, ___, U — tushib qolgan harfni yozing.",
        answers = setOf("t"),
        explanation = "To‘g‘ri javob: T."
    ),
    Question.Text(
        section = "2-mashq • Yetishmayotgan harfni toping",
        prompt = "W, ___, Y, Z — tushib qolgan harfni yozing.",
        answers = setOf("x"),
        explanation = "To‘g‘ri javob: X."
    ),
    Question.Text(
        section = "2-mashq • Yetishmayotgan harfni toping",
        prompt = "a, b, c, ___, e — tushib qolgan harfni yozing.",
        answers = setOf("d"),
        explanation = "To‘g‘ri javob: d."
    ),
    Question.Matching(
        section = "3-mashq • Katta harfni kichik harfga moslang",
        prompt = "Katta harfni kichik shakli bilan bog‘lang.",
        pairs = listOf("B" to "b", "D" to "d", "G" to "g", "M" to "m", "R" to "r", "Y" to "y"),
        options = listOf("b", "d", "g", "m", "r", "y"),
        explanation = "B → b, D → d, G → g, M → m, R → r, Y → y."
    ),
    Question.Choice(
        section = "3-mashq • Katta harfni kichik harfga moslang",
        prompt = "Kichik «c» ning katta shakli qaysi?",
        options = listOf("A", "C", "E"),
        answer = "C",
        explanation = "Kichik c ning katta shakli: C."
    ),
    Question.Choice(
        section = "4-mashq • Qaysi harf oldin keladi?",
        prompt = "Qaysi harf oldin keladi: C yoki E?",
        options = listOf("C", "E"),
        answer = "C",
        explanation = "Alifboda C harfi E dan oldin keladi."
    ),
    Question.Choice(
        section = "4-mashq • Qaysi harf oldin keladi?",
        prompt = "Qaysi harf oldin keladi: J yoki H?",
        options = listOf("J", "H"),
        answer = "H",
        explanation = "Alifboda H harfi J dan oldin keladi."
    ),
    Question.Choice(
        section = "4-mashq • Qaysi harf oldin keladi?",
        prompt = "Qaysi harf oldin keladi: P yoki R?",
        options = listOf("P", "R"),
        answer = "P",
        explanation = "Alifboda P harfi R dan oldin keladi."
    ),
    Question.Choice(
        section = "4-mashq • Qaysi harf oldin keladi?",
        prompt = "Qaysi harf oldin keladi: V yoki X?",
        options = listOf("V", "X"),
        answer = "V",
        explanation = "Alifboda V harfi X dan oldin keladi."
    ),
    Question.Text(
        section = "4-mashq • Qaysi harf oldin keladi?",
        prompt = "W, X, Y, Z harflarini alifbo tartibida yozing.",
        answers = setOf("WXYZ"),
        mode = TextMode.ORDER,
        explanation = "To‘g‘ri tartib: W, X, Y, Z."
    ),
    Question.Text(
        section = "5-mashq • Harf nomini eslang",
        prompt = "A harfining nomini yozing.",
        answers = setOf("ey"),
        explanation = "A harfi «ey» deb aytiladi."
    ),
    Question.Text(
        section = "5-mashq • Harf nomini eslang",
        prompt = "B harfining nomini yozing.",
        answers = setOf("bi"),
        explanation = "B harfi «bi» deb aytiladi."
    ),
    Question.Text(
        section = "5-mashq • Harf nomini eslang",
        prompt = "E harfining nomini yozing.",
        answers = setOf("i"),
        explanation = "E harfi «i» deb aytiladi."
    ),
    Question.Text(
        section = "5-mashq • Harf nomini eslang",
        prompt = "I harfining nomini yozing.",
        answers = setOf("ay"),
        explanation = "I harfi «ay» deb aytiladi."
    ),
    Question.Text(
        section = "5-mashq • Harf nomini eslang",
        prompt = "O harfining nomini yozing.",
        answers = setOf("ou"),
        explanation = "O harfi «ou» deb aytiladi."
    ),
    Question.Text(
        section = "5-mashq • Harf nomini eslang",
        prompt = "U harfining nomini yozing.",
        answers = setOf("yu"),
        explanation = "U harfi «yu» deb aytiladi."
    ),
    Question.Text(
        section = "5-mashq • Harf nomini eslang",
        prompt = "Z harfining ikki nomini yozing.",
        answers = setOf("zed va zi", "zed, zi"),
        explanation = "Z harfi «zed» va «zi» deb aytiladi."
    ),
    Question.Text(
        section = "6-mashq • So‘zni harflab ayting",
        prompt = "CAT so‘zini harflab yozing.",
        answers = setOf("CAT"),
        mode = TextMode.SPELLING,
        explanation = "To‘g‘ri yozuv: C–A–T."
    ),
    Question.Text(
        section = "6-mashq • So‘zni harflab ayting",
        prompt = "PEN so‘zini harflab yozing.",
        answers = setOf("PEN"),
        mode = TextMode.SPELLING,
        explanation = "To‘g‘ri yozuv: P–E–N."
    ),
    Question.Text(
        section = "6-mashq • So‘zni harflab ayting",
        prompt = "BOX so‘zini harflab yozing.",
        answers = setOf("BOX"),
        mode = TextMode.SPELLING,
        explanation = "To‘g‘ri yozuv: B–O–X."
    ),
    Question.TrueFalse(
        section = "1-mashq • Alifboni eslab yozing",
        prompt = "Ingliz alifbosida 26 ta harf bor.",
        answer = true,
        explanation = "Bu gap to‘g‘ri: ingliz alifbosida 26 ta harf bor."
    ),
    Question.TrueFalse(
        section = "5-mashq • Harf nomini eslang",
        prompt = "Z harfi faqat bitta nomga ega.",
        answer = false,
        explanation = "Bu gap noto‘g‘ri: Z harfi «zed» va «zi» deb aytiladi."
    ),
    Question.Text(
        section = "7-mashq • Katta harflarni to‘g‘rilang",
        prompt = "«i am ali.» gapini to‘g‘rilab yozing.",
        answers = setOf("I am Ali."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri yozuv: I am Ali."
    ),
    Question.Text(
        section = "7-mashq • Katta harflarni to‘g‘rilang",
        prompt = "«my friend lives in tashkent.» gapini to‘g‘rilab yozing.",
        answers = setOf("My friend lives in Tashkent."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri yozuv: My friend lives in Tashkent."
    ),
    Question.Text(
        section = "7-mashq • Katta harflarni to‘g‘rilang",
        prompt = "«we study english on monday.» gapini to‘g‘rilab yozing.",
        answers = setOf("We study English on Monday."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri yozuv: We study English on Monday."
    )
)
