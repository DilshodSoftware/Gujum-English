package com.example.gujumenglish.ui.grammar.practice

internal val lesson31Questions: List<Question> = listOf(
    Question.Text(
        section = "1-mashq • Be yoki Do/Does?",
        prompt = "Where ___ your keys? (are / do)",
        answers = setOf("are"),
        explanation = "Ko‘plik + to be: are."
    ),
    Question.Text(
        section = "1-mashq • Be yoki Do/Does?",
        prompt = "Where ___ she work? (is / does)",
        answers = setOf("does"),
        explanation = "Harakat fe’li: does."
    ),
    Question.Text(
        section = "1-mashq • Be yoki Do/Does?",
        prompt = "Where ___ the children? (are / do)",
        answers = setOf("are"),
        explanation = "Ko‘plik + to be: are."
    ),
    Question.Text(
        section = "1-mashq • Be yoki Do/Does?",
        prompt = "Where ___ you go after school? (are / do)",
        answers = setOf("do"),
        explanation = "Harakat fe’li: do."
    ),
    Question.Text(
        section = "1-mashq • Be yoki Do/Does?",
        prompt = "Where ___ the bus stop? (is / does)",
        answers = setOf("is"),
        explanation = "Bitta narsa + to be: is."
    ),
    Question.Text(
        section = "2-mashq • Joy predlogini tanlang",
        prompt = "The students are ___ school.",
        answers = setOf("at"),
        explanation = "at school — aniq ifoda bilan: at."
    ),
    Question.Text(
        section = "2-mashq • Joy predlogini tanlang",
        prompt = "My phone is ___ the table.",
        answers = setOf("on"),
        explanation = "Ustida: on the table."
    ),
    Question.Text(
        section = "2-mashq • Joy predlogini tanlang",
        prompt = "We live ___ Tashkent.",
        answers = setOf("in"),
        explanation = "Shaharda: in Tashkent."
    ),
    Question.Text(
        section = "2-mashq • Joy predlogini tanlang",
        prompt = "The children are ___ the room.",
        answers = setOf("in"),
        explanation = "Xona ichida: in the room."
    ),
    Question.Text(
        section = "2-mashq • Joy predlogini tanlang",
        prompt = "My father is ___ home.",
        answers = setOf("at"),
        explanation = "Uyda: at home."
    ),
    Question.Ordering(
        section = "3-mashq • So‘zlarni joyiga qo‘ying",
        prompt = "you / where / live / do / ? — savolni tuzing.",
        words = listOf("you", "where", "live", "do?"),
        answer = "Where do you live?",
        explanation = "To‘g‘ri savol: Where do you live?"
    ),
    Question.Ordering(
        section = "3-mashq • So‘zlarni joyiga qo‘ying",
        prompt = "the cat / where / is / ? — savolni tuzing.",
        words = listOf("the cat", "where", "is?"),
        answer = "Where is the cat?",
        explanation = "To‘g‘ri savol: Where is the cat?"
    ),
    Question.Ordering(
        section = "3-mashq • So‘zlarni joyiga qo‘ying",
        prompt = "your parents / where / work / do / ? — savolni tuzing.",
        words = listOf("your parents", "where", "work", "do?"),
        answer = "Where do your parents work?",
        explanation = "To‘g‘ri savol: Where do your parents work?"
    ),
    Question.Ordering(
        section = "3-mashq • So‘zlarni joyiga qo‘ying",
        prompt = "where / the children / are / ? — savolni tuzing.",
        words = listOf("where", "the children", "are?"),
        answer = "Where are the children?",
        explanation = "To‘g‘ri savol: Where are the children?"
    ),
    Question.Text(
        section = "4-mashq • Where savoliga javob yozing",
        prompt = "Where is your book? (in my bag) — javob bering.",
        answers = setOf("It is in my bag."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: It is in my bag."
    ),
    Question.Text(
        section = "4-mashq • Where savoliga javob yozing",
        prompt = "Where do you live? (in Bukhara) — javob bering.",
        answers = setOf("I live in Bukhara."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: I live in Bukhara."
    ),
    Question.Text(
        section = "4-mashq • Where savoliga javob yozing",
        prompt = "Where does your mother work? (at a hospital) — javob bering.",
        answers = setOf("She works at a hospital."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: She works at a hospital."
    ),
    Question.Text(
        section = "4-mashq • Where savoliga javob yozing",
        prompt = "Where are the children? (at school) — javob bering.",
        answers = setOf("They are at school."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: They are at school."
    ),
    Question.Choice(
        section = "5-mashq • Where yoki When?",
        prompt = "___ do you study? — At the library.",
        options = listOf("Where", "When"),
        answer = "Where",
        explanation = "Javob joy bilan: Where."
    ),
    Question.Choice(
        section = "5-mashq • Where yoki When?",
        prompt = "___ does the lesson start? — At nine.",
        options = listOf("Where", "When"),
        answer = "When",
        explanation = "Javob vaqt bilan: When."
    ),
    Question.Choice(
        section = "5-mashq • Where yoki When?",
        prompt = "___ is your bag? — Under the chair.",
        options = listOf("Where", "When"),
        answer = "Where",
        explanation = "Javob joy bilan: Where."
    ),
    Question.Choice(
        section = "5-mashq • Where yoki When?",
        prompt = "___ do they visit their aunt? — On Sundays.",
        options = listOf("Where", "When"),
        answer = "When",
        explanation = "Javob vaqt bilan: When."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «Where you live?»",
        answers = setOf("Where do you live?"),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: Where do you live?"
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «Where does he works?»",
        answers = setOf("Where does he work?"),
        mode = TextMode.SENTENCE,
        explanation = "Does dan keyin oddiy shakl: work."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «Where is live your sister?»",
        answers = setOf("Where does your sister live?"),
        mode = TextMode.SENTENCE,
        explanation = "Harakat fe’li: does ... live."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «Where do the keys?»",
        answers = setOf("Where are the keys?"),
        mode = TextMode.SENTENCE,
        explanation = "Joylashuv — to be: are."
    )
)