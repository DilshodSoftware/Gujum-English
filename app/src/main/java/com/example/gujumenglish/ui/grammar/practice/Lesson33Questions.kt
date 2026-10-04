package com.example.gujumenglish.ui.grammar.practice

internal val lesson33Questions: List<Question> = listOf(
    Question.Text(
        section = "1-mashq • To Be, Do yoki Does?",
        prompt = "When ___ your birthday? (is / does)",
        answers = setOf("is"),
        explanation = "To be bilan savol: is."
    ),
    Question.Text(
        section = "1-mashq • To Be, Do yoki Does?",
        prompt = "When ___ the children go to bed? (do / are)",
        answers = setOf("do"),
        explanation = "Ko‘plik + harakat: do."
    ),
    Question.Text(
        section = "1-mashq • To Be, Do yoki Does?",
        prompt = "When ___ Sara finish work? (do / does)",
        answers = setOf("does"),
        explanation = "Bitta ayol + harakat: does."
    ),
    Question.Text(
        section = "1-mashq • To Be, Do yoki Does?",
        prompt = "When ___ your holidays? (are / do)",
        answers = setOf("are"),
        explanation = "Ko‘plik + to be: are."
    ),
    Question.Text(
        section = "1-mashq • To Be, Do yoki Does?",
        prompt = "When ___ the bus arrive? (does / is)",
        answers = setOf("does"),
        explanation = "Bitta narsa + harakat: does."
    ),
    Question.Ordering(
        section = "2-mashq • Savolni so‘zlardan tuzing",
        prompt = "you / when / get up / do / ? — savolni tuzing.",
        words = listOf("you", "when", "get up", "do?"),
        answer = "When do you get up?",
        explanation = "To‘g‘ri savol: When do you get up?"
    ),
    Question.Ordering(
        section = "2-mashq • Savolni so‘zlardan tuzing",
        prompt = "when / is / the meeting / ? — savolni tuzing.",
        words = listOf("when", "the meeting", "is?"),
        answer = "When is the meeting?",
        explanation = "To‘g‘ri savol: When is the meeting?"
    ),
    Question.Ordering(
        section = "2-mashq • Savolni so‘zlardan tuzing",
        prompt = "does / when / the shop / open / ? — savolni tuzing.",
        words = listOf("when", "the shop", "open", "does?"),
        answer = "When does the shop open?",
        explanation = "To‘g‘ri savol: When does the shop open?"
    ),
    Question.Ordering(
        section = "2-mashq • Savolni so‘zlardan tuzing",
        prompt = "are / when / they / free / ? — savolni tuzing.",
        words = listOf("when", "they", "free", "are?"),
        answer = "When are they free?",
        explanation = "To‘g‘ri savol: When are they free?"
    ),
    Question.Choice(
        section = "3-mashq • Vaqtga mos javobni tanlang",
        prompt = "When does school start? — qaysi javob to‘g‘ri?",
        options = listOf("At eight.", "At the library."),
        answer = "At eight.",
        explanation = "Vaqt javobi: At eight."
    ),
    Question.Choice(
        section = "3-mashq • Vaqtga mos javobni tanlang",
        prompt = "When is your birthday? — qaysi javob to‘g‘ri?",
        options = listOf("In July.", "In the kitchen."),
        answer = "In July.",
        explanation = "Vaqt javobi: In July."
    ),
    Question.Choice(
        section = "3-mashq • Vaqtga mos javobni tanlang",
        prompt = "When do you study? — qaysi javob to‘g‘ri?",
        options = listOf("In the evening.", "By bus."),
        answer = "In the evening.",
        explanation = "Vaqt javobi: In the evening."
    ),
    Question.Choice(
        section = "3-mashq • Vaqtga mos javobni tanlang",
        prompt = "When are your classes? — qaysi javob to‘g‘ri?",
        options = listOf("On Monday.", "Near my house."),
        answer = "On Monday.",
        explanation = "Kun javobi: On Monday."
    ),
    Question.Choice(
        section = "4-mashq • When yoki Where?",
        prompt = "___ is the bus stop? — Near the bank.",
        options = listOf("When", "Where"),
        answer = "Where",
        explanation = "Javob joy bilan: Where."
    ),
    Question.Choice(
        section = "4-mashq • When yoki Where?",
        prompt = "___ does the film begin? — At six.",
        options = listOf("When", "Where"),
        answer = "When",
        explanation = "Javob vaqt bilan: When."
    ),
    Question.Choice(
        section = "4-mashq • When yoki Where?",
        prompt = "___ are my glasses? — On the desk.",
        options = listOf("When", "Where"),
        answer = "Where",
        explanation = "Javob joy bilan: Where."
    ),
    Question.Choice(
        section = "4-mashq • When yoki Where?",
        prompt = "___ do you visit your aunt? — Every weekend.",
        options = listOf("When", "Where"),
        answer = "When",
        explanation = "Javob vaqt bilan: When."
    ),
    Question.Text(
        section = "5-mashq • Xatoni to‘g‘rilang",
        prompt = "Xatoni tuzating: «When you go to work?»",
        answers = setOf("When do you go to work?"),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: When do you go to work?"
    ),
    Question.Text(
        section = "5-mashq • Xatoni to‘g‘rilang",
        prompt = "Xatoni tuzating: «When does the train arrives?»",
        answers = setOf("When does the train arrive?"),
        mode = TextMode.SENTENCE,
        explanation = "Does dan keyin oddiy shakl: arrive."
    ),
    Question.Text(
        section = "5-mashq • Xatoni to‘g‘rilang",
        prompt = "Xatoni tuzating: «When the party is?»",
        answers = setOf("When is the party?"),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: When is the party?"
    ),
    Question.Text(
        section = "5-mashq • Xatoni to‘g‘rilang",
        prompt = "Xatoni tuzating: «When do Sara eat dinner?»",
        answers = setOf("When does Sara eat dinner?"),
        mode = TextMode.SENTENCE,
        explanation = "Bitta ayol bilan: does."
    ),
    Question.Text(
        section = "6-mashq • Vaqt bilan javob bering",
        prompt = "When do you wake up? (at seven) — javob bering.",
        answers = setOf("I wake up at seven."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: I wake up at seven."
    ),
    Question.Text(
        section = "6-mashq • Vaqt bilan javob bering",
        prompt = "When is the English lesson? (on Tuesday) — javob bering.",
        answers = setOf("It is on Tuesday."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: It is on Tuesday."
    ),
    Question.Text(
        section = "6-mashq • Vaqt bilan javob bering",
        prompt = "When does your father come home? (in the evening) — javob bering.",
        answers = setOf("He comes home in the evening."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: He comes home in the evening."
    )
)