package com.example.gujumenglish.ui.grammar.practice

internal val lesson41Questions: List<Question> = listOf(
    Question.Text(
        section = "1-mashq • Buyruqni fe’l bilan boshlang",
        prompt = "___ the door, please. (open)",
        answers = setOf("Open"),
        explanation = "Buyruq fe’lning oddiy shakli bilan boshlanadi: Open."
    ),
    Question.Text(
        section = "1-mashq • Buyruqni fe’l bilan boshlang",
        prompt = "___ down. (sit)",
        answers = setOf("Sit"),
        explanation = "To‘g‘ri shakl: Sit down."
    ),
    Question.Text(
        section = "1-mashq • Buyruqni fe’l bilan boshlang",
        prompt = "___ carefully. (listen)",
        answers = setOf("Listen"),
        explanation = "To‘g‘ri shakl: Listen carefully."
    ),
    Question.Text(
        section = "1-mashq • Buyruqni fe’l bilan boshlang",
        prompt = "___ your name here. (write)",
        answers = setOf("Write"),
        explanation = "To‘g‘ri shakl: Write your name here."
    ),
    Question.Text(
        section = "1-mashq • Buyruqni fe’l bilan boshlang",
        prompt = "___ at the board. (look)",
        answers = setOf("Look"),
        explanation = "To‘g‘ri shakl: Look at the board."
    ),
    Question.Ordering(
        section = "2-mashq • Iltimosni tuzing",
        prompt = "(please / help me) — gapni tuzing.",
        words = listOf("Please", "help", "me."),
        answer = "Please help me.",
        explanation = "To‘g‘ri gap: Please help me."
    ),
    Question.Ordering(
        section = "2-mashq • Iltimosni tuzing",
        prompt = "(close the window / please) — gapni tuzing.",
        words = listOf("Close", "the window,", "please."),
        answer = "Close the window, please.",
        explanation = "To‘g‘ri gap: Close the window, please."
    ),
    Question.Ordering(
        section = "2-mashq • Iltimosni tuzing",
        prompt = "(please / repeat the word) — gapni tuzing.",
        words = listOf("Please", "repeat", "the word."),
        answer = "Please repeat the word.",
        explanation = "To‘g‘ri gap: Please repeat the word."
    ),
    Question.Ordering(
        section = "2-mashq • Iltimosni tuzing",
        prompt = "(come here / please) — gapni tuzing.",
        words = listOf("Come", "here,", "please."),
        answer = "Come here, please.",
        explanation = "To‘g‘ri gap: Come here, please."
    ),
    Question.Text(
        section = "3-mashq • Don’t bilan inkor buyruq qiling",
        prompt = "run → ___",
        answers = setOf("Don’t run."),
        explanation = "To‘g‘ri shakl: Don’t run."
    ),
    Question.Text(
        section = "3-mashq • Don’t bilan inkor buyruq qiling",
        prompt = "open the door → ___",
        answers = setOf("Don’t open the door."),
        explanation = "To‘g‘ri shakl: Don’t open the door."
    ),
    Question.Text(
        section = "3-mashq • Don’t bilan inkor buyruq qiling",
        prompt = "touch the screen → ___",
        answers = setOf("Don’t touch the screen."),
        explanation = "To‘g‘ri shakl: Don’t touch the screen."
    ),
    Question.Text(
        section = "3-mashq • Don’t bilan inkor buyruq qiling",
        prompt = "be late → ___",
        answers = setOf("Don’t be late."),
        explanation = "To‘g‘ri shakl: Don’t be late."
    ),
    Question.Text(
        section = "3-mashq • Don’t bilan inkor buyruq qiling",
        prompt = "sit here → ___",
        answers = setOf("Don’t sit here."),
        explanation = "To‘g‘ri shakl: Don’t sit here."
    ),
    Question.Choice(
        section = "4-mashq • Buyruqmi, darakmi?",
        prompt = "«Please stand up.» — bu qanaqa gap?",
        options = listOf("buyruq/iltimos", "darak gap"),
        answer = "buyruq/iltimos",
        explanation = "Buyruq/iltimos: fe’l bilan boshlanadi."
    ),
    Question.Choice(
        section = "4-mashq • Buyruqmi, darakmi?",
        prompt = "«You stand up every morning.» — bu qanaqa gap?",
        options = listOf("buyruq/iltimos", "darak gap"),
        answer = "darak gap",
        explanation = "Ega bor, undan keyin fe’l: darak gap."
    ),
    Question.Choice(
        section = "4-mashq • Buyruqmi, darakmi?",
        prompt = "«Don’t talk.» — bu qanaqa gap?",
        options = listOf("buyruq/iltimos", "darak gap"),
        answer = "buyruq/iltimos",
        explanation = "Don’t bilan inkor buyruq."
    ),
    Question.Choice(
        section = "4-mashq • Buyruqmi, darakmi?",
        prompt = "«She reads the sentence.» — bu qanaqa gap?",
        options = listOf("buyruq/iltimos", "darak gap"),
        answer = "darak gap",
        explanation = "Ega bor: darak gap."
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «You open the book!» (buyruq ma’nosida)",
        answers = setOf("Open the book!"),
        mode = TextMode.SENTENCE,
        explanation = "Buyruqda you aytilmaydi: Open the book!"
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «Don’t to run.»",
        answers = setOf("Don’t run."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: Don’t run."
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «Please you sit down.»",
        answers = setOf("Please sit down."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: Please sit down."
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «Don’t touches the picture.»",
        answers = setOf("Don’t touch the picture."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: Don’t touch the picture."
    ),
    Question.Choice(
        section = "6-mashq • Sinfdoshga ko‘rsatma bering",
        prompt = "«Kitobni oching» — inglizcha qanday?",
        options = listOf("Open the book.", "You open the book."),
        answer = "Open the book.",
        explanation = "Buyruq: Open the book."
    ),
    Question.Choice(
        section = "6-mashq • Sinfdoshga ko‘rsatma bering",
        prompt = "«Iltimos, o‘qing» — inglizcha qanday?",
        options = listOf("Please read.", "Don’t read."),
        answer = "Please read.",
        explanation = "Iltimos: Please read."
    ),
    Question.Choice(
        section = "6-mashq • Sinfdoshga ko‘rsatma bering",
        prompt = "«Shoshilmang» — inglizcha qanday?",
        options = listOf("Don’t hurry.", "Hurry!"),
        answer = "Don’t hurry.",
        explanation = "Inkor buyruq: Don’t hurry."
    ),
    Question.Choice(
        section = "6-mashq • Sinfdoshga ko‘rsatma bering",
        prompt = "«Derazani yopmang» — inglizcha qanday?",
        options = listOf("Don’t close the window.", "Close the window."),
        answer = "Don’t close the window.",
        explanation = "Inkor buyruq: Don’t close the window."
    )
)