package com.example.gujumenglish.ui.grammar.practice

internal val lesson3Questions: List<Question> = listOf(
    Question.MultiChoice(
        section = "1-mashq • Asosiy unlilarni belgilang",
        prompt = "Beshta asosiy unli harfni belgilang.",
        options = listOf("A", "B", "E", "G", "I", "M", "O", "R", "U", "T"),
        answers = setOf("A", "E", "I", "O", "U"),
        explanation = "Asosiy unlilar: A, E, I, O, U."
    ),
    Question.MultiChoice(
        section = "1-mashq • Asosiy unlilarni belgilang",
        prompt = "Undosh harflarni belgilang.",
        options = listOf("A", "B", "E", "G", "I", "M", "O", "R", "U", "T"),
        answers = setOf("B", "G", "M", "R", "T"),
        explanation = "Undoshlar: B, G, M, R, T."
    ),
    Question.Matching(
        section = "2-mashq • Harfni guruhi bilan moslang",
        prompt = "Har bir harfni to‘g‘ri guruh bilan bog‘lang.",
        pairs = listOf(
            "A" to "unli",
            "B" to "undosh",
            "O" to "unli",
            "T" to "undosh",
            "E" to "unli"
        ),
        options = listOf("unli", "undosh"),
        explanation = "Unli: A, O, E. Undosh: B, T."
    ),
    Question.MultiChoice(
        section = "3-mashq • Y harfini tasniflang",
        prompt = "Y undosh tovush beradigan so‘zlarni belgilang.",
        options = listOf("yellow", "yes", "gym", "happy", "my", "sky"),
        answers = setOf("yellow", "yes"),
        explanation = "Yellow va yes so‘zlarida Y undosh tovush beradi."
    ),
    Question.MultiChoice(
        section = "3-mashq • Y harfini tasniflang",
        prompt = "Y unli tovush vazifasida kelgan so‘zlarni belgilang.",
        options = listOf("yellow", "yes", "gym", "happy", "my", "sky"),
        answers = setOf("gym", "happy", "my", "sky"),
        explanation = "Gym, happy, my, sky so‘zlarida Y unli vazifasida."
    ),
    Question.TrueFalse(
        section = "4-mashq • To‘g‘ri yoki noto‘g‘ri?",
        prompt = "A, E, I, O, U asosiy unli harflardir.",
        answer = true,
        explanation = "Bu gap to‘g‘ri: bular beshta asosiy unli."
    ),
    Question.TrueFalse(
        section = "4-mashq • To‘g‘ri yoki noto‘g‘ri?",
        prompt = "Ingliz alifbosidagi boshqa barcha harflar asosiy unlilar hisoblanadi.",
        answer = false,
        explanation = "Bu gap noto‘g‘ri: qolgan harflar undosh hisoblanadi."
    ),
    Question.TrueFalse(
        section = "4-mashq • To‘g‘ri yoki noto‘g‘ri?",
        prompt = "Y ba’zi so‘zlarda unli tovush vazifasini bajaradi.",
        answer = true,
        explanation = "Bu gap to‘g‘ri: masalan gym, happy, my, sky."
    ),
    Question.TrueFalse(
        section = "4-mashq • To‘g‘ri yoki noto‘g‘ri?",
        prompt = "Yellow so‘zidagi Y odatda «y» undosh tovushiga yaqin.",
        answer = true,
        explanation = "Bu gap to‘g‘ri: yellow so‘z boshida Y undoshdir."
    ),
    Question.Text(
        section = "5-mashq • So‘zdan unli harfni toping",
        prompt = "cat so‘zidagi unli harfni yozing.",
        answers = setOf("a"),
        explanation = "cat so‘zidagi unli: a."
    ),
    Question.Text(
        section = "5-mashq • So‘zdan unli harfni toping",
        prompt = "pen so‘zidagi unli harfni yozing.",
        answers = setOf("e"),
        explanation = "pen so‘zidagi unli: e."
    ),
    Question.Text(
        section = "5-mashq • So‘zdan unli harfni toping",
        prompt = "dog so‘zidagi unli harfni yozing.",
        answers = setOf("o"),
        explanation = "dog so‘zidagi unli: o."
    ),
    Question.Text(
        section = "5-mashq • So‘zdan unli harfni toping",
        prompt = "fish so‘zidagi unli harfni yozing.",
        answers = setOf("i"),
        explanation = "fish so‘zidagi unli: i."
    ),
    Question.Matching(
        section = "6-mashq • Atamani ma’nosi bilan bog‘lang",
        prompt = "Atamani o‘zbekcha ma’nosi bilan bog‘lang.",
        pairs = listOf("vowel" to "unli", "consonant" to "undosh"),
        options = listOf("unli", "undosh"),
        explanation = "vowel — unli, consonant — undosh."
    )
)
