package com.example.gujumenglish.ui.grammar.practice

internal val lesson44Questions: List<Question> = listOf(
    Question.Matching(
        section = "1-mashq • Countable yoki Uncountable?",
        prompt = "Har bir so‘zni to‘g‘ri guruhga bog‘lang.",
        pairs = listOf(
            "orange" to "countable",
            "chair" to "countable",
            "student" to "countable",
            "box" to "countable"
        ),
        options = listOf("countable", "uncountable"),
        explanation = "orange, chair, student, box — countable."
    ),
    Question.Matching(
        section = "1-mashq • Countable yoki Uncountable?",
        prompt = "Qolgan so‘zlarni to‘g‘ri guruhga bog‘lang.",
        pairs = listOf(
            "bread" to "uncountable",
            "milk" to "uncountable",
            "time" to "uncountable",
            "rice" to "uncountable"
        ),
        options = listOf("countable", "uncountable"),
        explanation = "bread, milk, time, rice — uncountable."
    ),
    Question.Text(
        section = "2-mashq • Birlikmi yoki ko‘plikmi?",
        prompt = "one ___ (apple / apples)",
        answers = setOf("apple"),
        explanation = "one — birlik: apple."
    ),
    Question.Text(
        section = "2-mashq • Birlikmi yoki ko‘plikmi?",
        prompt = "four ___ (box / boxes)",
        answers = setOf("boxes"),
        explanation = "four — ko‘plik: boxes."
    ),
    Question.Text(
        section = "2-mashq • Birlikmi yoki ko‘plikmi?",
        prompt = "a ___ (student / students)",
        answers = setOf("student"),
        explanation = "a — birlik: student."
    ),
    Question.Text(
        section = "2-mashq • Birlikmi yoki ko‘plikmi?",
        prompt = "three ___ (baby / babies)",
        answers = setOf("babies"),
        explanation = "three — ko‘plik: babies."
    ),
    Question.Text(
        section = "2-mashq • Birlikmi yoki ko‘plikmi?",
        prompt = "some ___ (water / waters) — ichimlik suvi",
        answers = setOf("water"),
        explanation = "Sanalmaydigan ot: water."
    ),
    Question.Text(
        section = "3-mashq • A/An, ko‘plik yoki sanalmaydigan shakl?",
        prompt = "I have ___ pen. (a/an)",
        answers = setOf("a"),
        explanation = "pen — undosh tovush bilan: a pen."
    ),
    Question.Text(
        section = "3-mashq • A/An, ko‘plik yoki sanalmaydigan shakl?",
        prompt = "She has two ___. (book/books)",
        answers = setOf("books"),
        explanation = "two — ko‘plik: books."
    ),
    Question.Text(
        section = "3-mashq • A/An, ko‘plik yoki sanalmaydigan shakl?",
        prompt = "We need ___ rice. (a/some)",
        answers = setOf("some"),
        explanation = "rice — sanalmaydigan: some rice."
    ),
    Question.Text(
        section = "3-mashq • A/An, ko‘plik yoki sanalmaydigan shakl?",
        prompt = "He eats ___ apple. (a/an)",
        answers = setOf("an"),
        explanation = "apple — unli tovush bilan: an apple."
    ),
    Question.Text(
        section = "3-mashq • A/An, ko‘plik yoki sanalmaydigan shakl?",
        prompt = "They have three ___. (child/children)",
        answers = setOf("children"),
        explanation = "three — ko‘plik: children."
    ),
    Question.Text(
        section = "4-mashq • Sanalmaydigan narsani o‘lchov bilan ayting",
        prompt = "one glass ___ water",
        answers = setOf("of"),
        explanation = "To‘g‘ri shakl: a glass of water."
    ),
    Question.Text(
        section = "4-mashq • Sanalmaydigan narsani o‘lchov bilan ayting",
        prompt = "two bottles ___ milk",
        answers = setOf("of"),
        explanation = "To‘g‘ri shakl: two bottles of milk."
    ),
    Question.Text(
        section = "4-mashq • Sanalmaydigan narsani o‘lchov bilan ayting",
        prompt = "a piece ___ bread",
        answers = setOf("of"),
        explanation = "To‘g‘ri shakl: a piece of bread."
    ),
    Question.Text(
        section = "4-mashq • Sanalmaydigan narsani o‘lchov bilan ayting",
        prompt = "three cups ___ tea",
        answers = setOf("of"),
        explanation = "To‘g‘ri shakl: three cups of tea."
    ),
    Question.Text(
        section = "5-mashq • Gapdagi xatoni tuzating",
        prompt = "Xatoni tuzating: «I have a books.»",
        answers = setOf("I have a book.", "I have books."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: I have a book / I have books."
    ),
    Question.Text(
        section = "5-mashq • Gapdagi xatoni tuzating",
        prompt = "Xatoni tuzating: «She needs a milk.»",
        answers = setOf("She needs some milk."),
        mode = TextMode.SENTENCE,
        explanation = "Sanalmaydigan ot oldidan some: some milk."
    ),
    Question.Text(
        section = "5-mashq • Gapdagi xatoni tuzating",
        prompt = "Xatoni tuzating: «There are two rice in the bowl.»",
        answers = setOf("There is some rice in the bowl."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: There is some rice in the bowl."
    ),
    Question.Text(
        section = "5-mashq • Gapdagi xatoni tuzating",
        prompt = "Xatoni tuzating: «He buys three bread.»",
        answers = setOf(
            "He buys three loaves of bread.",
            "He buys three pieces of bread."
        ),
        mode = TextMode.SENTENCE,
        explanation = "Non uchun o‘lchov kerak: three loaves/pieces of bread."
    ),
    Question.Choice(
        section = "6-mashq • Chicken so‘zining ma’nosini aniqlang",
        prompt = "some chicken — qanday ma’no?",
        options = listOf("tovuq go‘shti (uncountable)", "bitta tovuq (countable)"),
        answer = "tovuq go‘shti (uncountable)",
        explanation = "some chicken — go‘sht, sanalmaydi."
    ),
    Question.Choice(
        section = "6-mashq • Chicken so‘zining ma’nosini aniqlang",
        prompt = "a chicken — qanday ma’no?",
        options = listOf("tovuq go‘shti (uncountable)", "bitta tovuq (countable)"),
        answer = "bitta tovuq (countable)",
        explanation = "a chicken — bitta hayvon, sanaladi."
    )
)