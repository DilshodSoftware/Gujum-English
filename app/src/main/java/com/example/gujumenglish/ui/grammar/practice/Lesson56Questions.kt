package com.example.gujumenglish.ui.grammar.practice

internal val lesson56Questions: List<Question> = listOf(
    Question.Text(
        section = "1-mashq • Am, Is yoki Are?",
        prompt = "I ___ going to read tonight.",
        answers = setOf("am"),
        explanation = "I bilan am."
    ),
    Question.Text(
        section = "1-mashq • Am, Is yoki Are?",
        prompt = "My friends ___ going to travel.",
        answers = setOf("are"),
        explanation = "Ko‘plik bilan are."
    ),
    Question.Text(
        section = "1-mashq • Am, Is yoki Are?",
        prompt = "She ___ going to make a cake.",
        answers = setOf("is"),
        explanation = "Bitta ayol bilan is."
    ),
    Question.Text(
        section = "1-mashq • Am, Is yoki Are?",
        prompt = "You ___ going to see the doctor.",
        answers = setOf("are"),
        explanation = "You bilan are."
    ),
    Question.Text(
        section = "1-mashq • Am, Is yoki Are?",
        prompt = "The dog ___ going to eat.",
        answers = setOf("is"),
        explanation = "Bitta narsa bilan is."
    ),
    Question.Choice(
        section = "2-mashq • Fe’lning oddiy shaklini tanlang",
        prompt = "We are going to (visit / visited) our aunt.",
        options = listOf("visit", "visited"),
        answer = "visit",
        explanation = "Going to dan keyin oddiy shakl: visit."
    ),
    Question.Choice(
        section = "2-mashq • Fe’lning oddiy shaklini tanlang",
        prompt = "He is going to (buys / buy) a phone.",
        options = listOf("buys", "buy"),
        answer = "buy",
        explanation = "Going to dan keyin oddiy shakl: buy."
    ),
    Question.Choice(
        section = "2-mashq • Fe’lning oddiy shaklini tanlang",
        prompt = "I am going to (study / studying) English.",
        options = listOf("study", "studying"),
        answer = "study",
        explanation = "Going to dan keyin oddiy shakl: study."
    ),
    Question.Choice(
        section = "2-mashq • Fe’lning oddiy shaklini tanlang",
        prompt = "They are going to (play / plays) football.",
        options = listOf("play", "plays"),
        answer = "play",
        explanation = "Going to dan keyin oddiy shakl: play."
    ),
    Question.Text(
        section = "3-mashq • Inkor shaklini tuzing",
        prompt = "I am going to work tomorrow. (inkor)",
        answers = setOf("I am not going to work tomorrow."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: I am not going to work tomorrow."
    ),
    Question.Text(
        section = "3-mashq • Inkor shaklini tuzing",
        prompt = "She is going to cook tonight. (inkor)",
        answers = setOf("She isn’t going to cook tonight."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: She isn’t going to cook tonight."
    ),
    Question.Text(
        section = "3-mashq • Inkor shaklini tuzing",
        prompt = "They are going to travel. (inkor)",
        answers = setOf("They aren’t going to travel."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: They aren’t going to travel."
    ),
    Question.Ordering(
        section = "4-mashq • Savol shakliga o‘tkazing",
        prompt = "You are going to study tonight. — savolga o‘tkazing.",
        words = listOf("Are", "you", "going to study", "tonight"),
        answer = "Are you going to study tonight?",
        explanation = "To‘g‘ri savol: Are you going to study tonight?"
    ),
    Question.Ordering(
        section = "4-mashq • Savol shakliga o‘tkazing",
        prompt = "Ali is going to buy a bike. — savolga o‘tkazing.",
        words = listOf("Is", "Ali", "going to buy", "a bike"),
        answer = "Is Ali going to buy a bike?",
        explanation = "To‘g‘ri savol: Is Ali going to buy a bike?"
    ),
    Question.Ordering(
        section = "4-mashq • Savol shakliga o‘tkazing",
        prompt = "They are going to move next year. — savolga o‘tkazing.",
        words = listOf("Are", "they", "going to move", "next year"),
        answer = "Are they going to move next year?",
        explanation = "To‘g‘ri savol: Are they going to move next year?"
    ),
    Question.Ordering(
        section = "5-mashq • Kelajak rejasini vaqt iborasi bilan yozing",
        prompt = "(I / visit / my friend / tomorrow) — gapni tuzing.",
        words = listOf("Am", "I", "going to visit", "my friend", "tomorrow"),
        answer = "I am going to visit my friend tomorrow.",
        explanation = "To‘g‘ri gap: I am going to visit my friend tomorrow."
    ),
    Question.Ordering(
        section = "5-mashq • Kelajak rejasini vaqt iborasi bilan yozing",
        prompt = "(We / travel / next week) — gapni tuzing.",
        words = listOf("Are", "We", "going to travel", "next week"),
        answer = "We are going to travel next week.",
        explanation = "To‘g‘ri gap: We are going to travel next week."
    ),
    Question.Ordering(
        section = "5-mashq • Kelajak rejasini vaqt iborasi bilan yozing",
        prompt = "(She / study / tonight) — gapni tuzing.",
        words = listOf("Is", "She", "going to study", "tonight"),
        answer = "She is going to study tonight.",
        explanation = "To‘g‘ri gap: She is going to study tonight."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «He going to play tennis.»",
        answers = setOf("He is going to play tennis."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: He is going to play tennis."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «They is going to cook.»",
        answers = setOf("They are going to cook."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: They are going to cook."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «Is she going to studies?»",
        answers = setOf("Is she going to study?"),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: Is she going to study?"
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «Are you going to went home?»",
        answers = setOf("Are you going to go home?"),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: Are you going to go home?"
    )
)