package com.example.gujumenglish.ui.grammar.practice

internal val lesson64Questions: List<Question> = listOf(
    Question.Text(
        section = "1-mashq • Ot yoki to + fe’l?",
        prompt = "I would like ___ (a glass of water).",
        answers = setOf("a glass of water"),
        explanation = "Ot bilan: a glass of water."
    ),
    Question.Text(
        section = "1-mashq • Ot yoki to + fe’l?",
        prompt = "She would like ___ (order dinner).",
        answers = setOf("to order dinner"),
        explanation = "Fe’l bilan: to order dinner."
    ),
    Question.Text(
        section = "1-mashq • Ot yoki to + fe’l?",
        prompt = "They would like ___ (some tea).",
        answers = setOf("some tea"),
        explanation = "Ot bilan: some tea."
    ),
    Question.Text(
        section = "1-mashq • Ot yoki to + fe’l?",
        prompt = "He would like ___ (learn English).",
        answers = setOf("to learn English"),
        explanation = "Fe’l bilan: to learn English."
    ),
    Question.Text(
        section = "1-mashq • Ot yoki to + fe’l?",
        prompt = "We would like ___ (a table by the window).",
        answers = setOf("a table by the window"),
        explanation = "Ot bilan: a table by the window."
    ),
    Question.Choice(
        section = "2-mashq • Would like barcha egalar bilan bir xil",
        prompt = "He (would like / would likes) a coffee.",
        options = listOf("would like", "would likes"),
        answer = "would like",
        explanation = "Barcha egalar bilan bir xil: would like."
    ),
    Question.Choice(
        section = "2-mashq • Would like barcha egalar bilan bir xil",
        prompt = "I (would like / would likes) to go home.",
        options = listOf("would like", "would likes"),
        answer = "would like",
        explanation = "Barcha egalar bilan bir xil: would like."
    ),
    Question.Choice(
        section = "2-mashq • Would like barcha egalar bilan bir xil",
        prompt = "They (would like / would likes) some soup.",
        options = listOf("would like", "would likes"),
        answer = "would like",
        explanation = "Barcha egalar bilan bir xil: would like."
    ),
    Question.Choice(
        section = "2-mashq • Would like barcha egalar bilan bir xil",
        prompt = "Sara (would like / would likes) to sit down.",
        options = listOf("would like", "would likes"),
        answer = "would like",
        explanation = "Barcha egalar bilan bir xil: would like."
    ),
    Question.Text(
        section = "3-mashq • Qisqa shaklga o‘tkazing",
        prompt = "I would like → ___",
        answers = setOf("I’d like"),
        explanation = "Qisqa shakl: I’d like."
    ),
    Question.Text(
        section = "3-mashq • Qisqa shaklga o‘tkazing",
        prompt = "You would like → ___",
        answers = setOf("you’d like"),
        explanation = "Qisqa shakl: you’d like."
    ),
    Question.Text(
        section = "3-mashq • Qisqa shaklga o‘tkazing",
        prompt = "He would like → ___",
        answers = setOf("he’d like"),
        explanation = "Qisqa shakl: he’d like."
    ),
    Question.Text(
        section = "3-mashq • Qisqa shaklga o‘tkazing",
        prompt = "They would like → ___",
        answers = setOf("they’d like"),
        explanation = "Qisqa shakl: they’d like."
    ),
    Question.Ordering(
        section = "4-mashq • Would you like…? bilan taklif qiling",
        prompt = "Do‘stingizga choy taklif qiling.",
        words = listOf("Would you like", "tea", "some"),
        answer = "Would you like some tea?",
        explanation = "Namunaviy javob: Would you like some tea?"
    ),
    Question.Ordering(
        section = "4-mashq • Would you like…? bilan taklif qiling",
        prompt = "Mehmoningizga o‘tirishni taklif qiling.",
        words = listOf("Would you like", "down", "to", "sit"),
        answer = "Would you like to sit down?",
        explanation = "Namunaviy javob: Would you like to sit down?"
    ),
    Question.Ordering(
        section = "4-mashq • Would you like…? bilan taklif qiling",
        prompt = "Birovga sendvich taklif qiling.",
        words = listOf("Would you like", "a sandwich?"),
        answer = "Would you like a sandwich?",
        explanation = "Namunaviy javob: Would you like a sandwich?"
    ),
    Question.Text(
        section = "5-mashq • Taklifga muloyim javob yozing",
        prompt = "Would you like some water? (ha, qabul qiling)",
        answers = setOf("Yes, please."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: Yes, please."
    ),
    Question.Text(
        section = "5-mashq • Taklifga muloyim javob yozing",
        prompt = "Would you like a coffee? (yo‘q, muloyim rad eting)",
        answers = setOf("No, thank you."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: No, thank you."
    ),
    Question.Text(
        section = "5-mashq • Taklifga muloyim javob yozing",
        prompt = "Would you like to come with us? (bajonidil rozi bo‘ling)",
        answers = setOf("I’d love to."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: I’d love to."
    ),
    Question.Text(
        section = "6-mashq • Xatolarni tuzating",
        prompt = "Xatoni tuzating: «She would likes a sandwich.»",
        answers = setOf("She would like a sandwich."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: She would like a sandwich."
    ),
    Question.Text(
        section = "6-mashq • Xatolarni tuzating",
        prompt = "Xatoni tuzating: «I’d like drink some water.»",
        answers = setOf("I’d like to drink some water."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: I’d like to drink some water."
    ),
    Question.Text(
        section = "6-mashq • Xatolarni tuzating",
        prompt = "Xatoni tuzating: «Do you would like tea?»",
        answers = setOf("Would you like tea?"),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: Would you like tea?"
    ),
    Question.Text(
        section = "6-mashq • Xatolarni tuzating",
        prompt = "Xatoni tuzating: «He would like to going home.»",
        answers = setOf("He would like to go home."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: He would like to go home."
    ),
    Question.Text(
        section = "7-mashq • Kafedagi dialogni to‘ldiring",
        prompt = "Server: ___ you like some tea? — to‘ldiring.",
        answers = setOf("Would"),
        explanation = "Taklif: Would you like some tea?"
    ),
    Question.Text(
        section = "7-mashq • Kafedagi dialogni to‘ldiring",
        prompt = "Guest: Yes, please. I’d ___ some tea. — to‘ldiring.",
        answers = setOf("like"),
        explanation = "I’d like some tea."
    ),
    Question.Text(
        section = "7-mashq • Kafedagi dialogni to‘ldiring",
        prompt = "Guest: I’d also like ___ order a sandwich. — to‘ldiring.",
        answers = setOf("to"),
        explanation = "Fe’l bilan: to order."
    )
)