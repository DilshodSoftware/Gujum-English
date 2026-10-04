package com.example.gujumenglish.ui.grammar.practice

internal val lesson36Questions: List<Question> = listOf(
    Question.Choice(
        section = "1-mashq • How old yoki How long?",
        prompt = "___ is your brother? (yosh)",
        options = listOf("How old", "How long"),
        answer = "How old",
        explanation = "Yoshni so‘ramoq: How old."
    ),
    Question.Choice(
        section = "1-mashq • How old yoki How long?",
        prompt = "___ is the film? (davomiyligi)",
        options = listOf("How old", "How long"),
        answer = "How long",
        explanation = "Davomiylikni so‘ramoq: How long."
    ),
    Question.Choice(
        section = "1-mashq • How old yoki How long?",
        prompt = "___ is this rope? (uzunligi)",
        options = listOf("How old", "How long"),
        answer = "How long",
        explanation = "Uzunlikni so‘ramoq: How long."
    ),
    Question.Choice(
        section = "1-mashq • How old yoki How long?",
        prompt = "___ do you wait for the bus? (vaqt)",
        options = listOf("How old", "How long"),
        answer = "How long",
        explanation = "Vaqtni so‘ramoq: How long."
    ),
    Question.Choice(
        section = "1-mashq • How old yoki How long?",
        prompt = "___ are the twins? (yoshi)",
        options = listOf("How old", "How long"),
        answer = "How old",
        explanation = "Yoshni so‘ramoq: How old."
    ),
    Question.Text(
        section = "2-mashq • Is/Are yoki Do/Does?",
        prompt = "How old ___ your sister?",
        answers = setOf("is"),
        explanation = "To be bilan savol: is."
    ),
    Question.Text(
        section = "2-mashq • Is/Are yoki Do/Does?",
        prompt = "How long ___ the bridge?",
        answers = setOf("is"),
        explanation = "To be bilan savol: is."
    ),
    Question.Text(
        section = "2-mashq • Is/Are yoki Do/Does?",
        prompt = "How long ___ you study every evening?",
        answers = setOf("do"),
        explanation = "Harakat fe’li: do."
    ),
    Question.Text(
        section = "2-mashq • Is/Are yoki Do/Does?",
        prompt = "How old ___ the children?",
        answers = setOf("are"),
        explanation = "Ko‘plik + to be: are."
    ),
    Question.Text(
        section = "2-mashq • Is/Are yoki Do/Does?",
        prompt = "How long ___ the lesson last?",
        answers = setOf("does"),
        explanation = "Harakat fe’li: does."
    ),
    Question.Ordering(
        section = "3-mashq • Savolni tuzing",
        prompt = "your father / how old / is / ? — savolni tuzing.",
        words = listOf("your father", "how old", "is?"),
        answer = "How old is your father?",
        explanation = "To‘g‘ri savol: How old is your father?"
    ),
    Question.Ordering(
        section = "3-mashq • Savolni tuzing",
        prompt = "does / how long / the trip / take / ? — savolni tuzing.",
        words = listOf("the trip", "take", "does?", "how long"),
        answer = "How long does the trip take?",
        explanation = "To‘g‘ri savol: How long does the trip take?"
    ),
    Question.Ordering(
        section = "3-mashq • Savolni tuzing",
        prompt = "the table / how long / is / ? — savolni tuzing.",
        words = listOf("the table", "how long", "is?"),
        answer = "How long is the table?",
        explanation = "To‘g‘ri savol: How long is the table?"
    ),
    Question.Ordering(
        section = "3-mashq • Savolni tuzing",
        prompt = "study / how long / do / you / ? — savolni tuzing.",
        words = listOf("you", "study", "how long", "do?"),
        answer = "How long do you study?",
        explanation = "To‘g‘ri savol: How long do you study?"
    ),
    Question.Text(
        section = "4-mashq • Yoshni inglizcha ayting",
        prompt = "I / 14 years old — gapni yozing.",
        answers = setOf("I am 14 years old."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri gap: I am 14 years old."
    ),
    Question.Text(
        section = "4-mashq • Yoshni inglizcha ayting",
        prompt = "My brother / 9 — gapni yozing.",
        answers = setOf("My brother is 9 years old."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri gap: My brother is 9 years old."
    ),
    Question.Text(
        section = "4-mashq • Yoshni inglizcha ayting",
        prompt = "The twins / 7 years old — gapni yozing.",
        answers = setOf("The twins are 7 years old."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri gap: The twins are 7 years old."
    ),
    Question.Choice(
        section = "5-mashq • Savolga mos javobni tanlang",
        prompt = "How old is Mina? — qaysi javob to‘g‘ri?",
        options = listOf("She is 12.", "For two hours."),
        answer = "She is 12.",
        explanation = "Yosh javobi: She is 12."
    ),
    Question.Choice(
        section = "5-mashq • Savolga mos javobni tanlang",
        prompt = "How long is the lesson? — qaysi javob to‘g‘ri?",
        options = listOf("It is 45 minutes.", "She is 12."),
        answer = "It is 45 minutes.",
        explanation = "Davomiylik javobi: It is 45 minutes."
    ),
    Question.Choice(
        section = "5-mashq • Savolga mos javobni tanlang",
        prompt = "How long is the road? — qaysi javob to‘g‘ri?",
        options = listOf("It is 3 km long.", "At five."),
        answer = "It is 3 km long.",
        explanation = "Uzunlik javobi: It is 3 km long."
    ),
    Question.Choice(
        section = "5-mashq • Savolga mos javobni tanlang",
        prompt = "When does the lesson start? — qaysi javob to‘g‘ri?",
        options = listOf("At nine.", "For one hour."),
        answer = "At nine.",
        explanation = "Vaqt javobi: At nine."
    ),
    Question.Choice(
        section = "6-mashq • Have yoki Be?",
        prompt = "She (is / has) 10 years old.",
        options = listOf("is", "has"),
        answer = "is",
        explanation = "Yosh bilan to be ishlatiladi: is."
    ),
    Question.Choice(
        section = "6-mashq • Have yoki Be?",
        prompt = "Qaysi savol to‘g‘ri?",
        options = listOf("How old are you?", "How old have you?"),
        answer = "How old are you?",
        explanation = "To be bilan savol: How old are you?"
    )
)