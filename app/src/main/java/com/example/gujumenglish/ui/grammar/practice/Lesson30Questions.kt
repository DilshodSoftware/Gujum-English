package com.example.gujumenglish.ui.grammar.practice

internal val lesson30Questions: List<Question> = listOf(
    Question.Choice(
        section = "1-mashq • What savoliga javob turini toping",
        prompt = "What is this? — qanday javob kerak?",
        options = listOf("narsa", "joy"),
        answer = "narsa",
        explanation = "What — narsani so‘raydi."
    ),
    Question.Choice(
        section = "1-mashq • What savoliga javob turini toping",
        prompt = "What is your name? — qanday javob kerak?",
        options = listOf("ism", "sabab"),
        answer = "ism",
        explanation = "What — ismni so‘raydi."
    ),
    Question.Choice(
        section = "1-mashq • What savoliga javob turini toping",
        prompt = "What do you eat? — qanday javob kerak?",
        options = listOf("taom", "vaqt"),
        answer = "taom",
        explanation = "What — taomni so‘raydi."
    ),
    Question.Choice(
        section = "1-mashq • What savoliga javob turini toping",
        prompt = "What color is the bag? — qanday javob kerak?",
        options = listOf("rang", "odam"),
        answer = "rang",
        explanation = "What — rangni so‘raydi."
    ),
    Question.Text(
        section = "2-mashq • Is, Are, Do yoki Does?",
        prompt = "What ___ these? (are / do)",
        answers = setOf("are"),
        explanation = "Ko‘plik + to be: are."
    ),
    Question.Text(
        section = "2-mashq • Is, Are, Do yoki Does?",
        prompt = "What ___ your favorite food? (is / does)",
        answers = setOf("is"),
        explanation = "To be bilan savol: is."
    ),
    Question.Text(
        section = "2-mashq • Is, Are, Do yoki Does?",
        prompt = "What ___ you do after school? (do / are)",
        answers = setOf("do"),
        explanation = "Harakat fe’li: do."
    ),
    Question.Text(
        section = "2-mashq • Is, Are, Do yoki Does?",
        prompt = "What ___ Sara read? (does / is)",
        answers = setOf("does"),
        explanation = "Bitta ayol bilan harakat: does."
    ),
    Question.Text(
        section = "2-mashq • Is, Are, Do yoki Does?",
        prompt = "What ___ in the box? (is / does)",
        answers = setOf("is"),
        explanation = "To be bilan savol: is."
    ),
    Question.Ordering(
        section = "3-mashq • Savolni to‘g‘ri tartibda yozing",
        prompt = "your name / what / is / ? — savolni tuzing.",
        words = listOf("your name", "what", "is?"),
        answer = "What is your name?",
        explanation = "To‘g‘ri savol: What is your name?"
    ),
    Question.Ordering(
        section = "3-mashq • Savolni to‘g‘ri tartibda yozing",
        prompt = "do / what / they / study / ? — savolni tuzing.",
        words = listOf("do", "what", "they", "study?"),
        answer = "What do they study?",
        explanation = "To‘g‘ri savol: What do they study?"
    ),
    Question.Ordering(
        section = "3-mashq • Savolni to‘g‘ri tartibda yozing",
        prompt = "she / what / does / want / ? — savolni tuzing.",
        words = listOf("she", "what", "does", "want?"),
        answer = "What does she want?",
        explanation = "To‘g‘ri savol: What does she want?"
    ),
    Question.Ordering(
        section = "3-mashq • Savolni to‘g‘ri tartibda yozing",
        prompt = "is / what / in the bag / ? — savolni tuzing.",
        words = listOf("is", "what", "in the bag?"),
        answer = "What is in the bag?",
        explanation = "To‘g‘ri savol: What is in the bag?"
    ),
    Question.Choice(
        section = "4-mashq • What yoki Where?",
        prompt = "___ is your phone? — On the table.",
        options = listOf("What", "Where"),
        answer = "Where",
        explanation = "Javob joy bilan: Where."
    ),
    Question.Choice(
        section = "4-mashq • What yoki Where?",
        prompt = "___ is your phone? — It is a new model.",
        options = listOf("What", "Where"),
        answer = "What",
        explanation = "Javob narsa bilan: What."
    ),
    Question.Choice(
        section = "4-mashq • What yoki Where?",
        prompt = "___ do you eat for breakfast? — Eggs.",
        options = listOf("What", "Where"),
        answer = "What",
        explanation = "Javob taom bilan: What."
    ),
    Question.Choice(
        section = "4-mashq • What yoki Where?",
        prompt = "___ do you study? — At home.",
        options = listOf("What", "Where"),
        answer = "Where",
        explanation = "Javob joy bilan: Where."
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «What you want?»",
        answers = setOf("What do you want?"),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: What do you want?"
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «What does he likes?»",
        answers = setOf("What does he like?"),
        mode = TextMode.SENTENCE,
        explanation = "Does dan keyin oddiy shakl: like."
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «What this is?»",
        answers = setOf("What is this?"),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: What is this?"
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «What are your name?»",
        answers = setOf("What is your name?"),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: What is your name?"
    ),
    Question.Text(
        section = "6-mashq • Savolga mos javob yozing",
        prompt = "What is this? (a pencil) — javob bering.",
        answers = setOf("It is a pencil."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: It is a pencil."
    ),
    Question.Text(
        section = "6-mashq • Savolga mos javob yozing",
        prompt = "What do you like? (music) — javob bering.",
        answers = setOf("I like music."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: I like music."
    ),
    Question.Text(
        section = "6-mashq • Savolga mos javob yozing",
        prompt = "What does Ali eat? (rice) — javob bering.",
        answers = setOf("Ali eats rice."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: Ali eats rice."
    )
)