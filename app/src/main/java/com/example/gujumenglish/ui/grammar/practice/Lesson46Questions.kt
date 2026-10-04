package com.example.gujumenglish.ui.grammar.practice

internal val lesson46Questions: List<Question> = listOf(
    Question.Text(
        section = "1-mashq • Many yoki Much?",
        prompt = "How ___ people are there?",
        answers = setOf("many"),
        explanation = "Ko‘plikdagi sanaladigan ot: many."
    ),
    Question.Text(
        section = "1-mashq • Many yoki Much?",
        prompt = "How ___ coffee do you drink?",
        answers = setOf("much"),
        explanation = "Sanalmaydigan ot: much."
    ),
    Question.Text(
        section = "1-mashq • Many yoki Much?",
        prompt = "We don’t have ___ time.",
        answers = setOf("much"),
        explanation = "Sanalmaydigan ot: time: much."
    ),
    Question.Text(
        section = "1-mashq • Many yoki Much?",
        prompt = "How ___ bags does she have?",
        answers = setOf("many"),
        explanation = "Ko‘plikdagi sanaladigan ot: many."
    ),
    Question.Text(
        section = "1-mashq • Many yoki Much?",
        prompt = "There isn’t ___ sugar in the jar.",
        answers = setOf("much"),
        explanation = "Sanalmaydigan ot: much."
    ),
    Question.Text(
        section = "1-mashq • Many yoki Much?",
        prompt = "How ___ money do they need?",
        answers = setOf("much"),
        explanation = "Sanalmaydigan ot: money: much."
    ),
    Question.Text(
        section = "2-mashq • A lot of bilan gapni to‘ldiring",
        prompt = "We have ___ books. (ko‘p kitob)",
        answers = setOf("a lot of"),
        explanation = "Sanaladigan ot bilan ham mumkin: a lot of books."
    ),
    Question.Text(
        section = "2-mashq • A lot of bilan gapni to‘ldiring",
        prompt = "He drinks ___ water.",
        answers = setOf("a lot of"),
        explanation = "Sanalmaydigan ot bilan ham mumkin: a lot of water."
    ),
    Question.Text(
        section = "2-mashq • A lot of bilan gapni to‘ldiring",
        prompt = "They have ___ friends.",
        answers = setOf("a lot of"),
        explanation = "To‘g‘ri shakl: a lot of friends."
    ),
    Question.Text(
        section = "2-mashq • A lot of bilan gapni to‘ldiring",
        prompt = "There is ___ traffic today.",
        answers = setOf("a lot of"),
        explanation = "To‘g‘ri shakl: a lot of traffic."
    ),
    Question.Choice(
        section = "3-mashq • Gap turiga mosini tanlang",
        prompt = "Savolda «nechta olma?» — qaysi so‘z?",
        options = listOf("How many", "How much"),
        answer = "How many",
        explanation = "Sanaladigan ot uchun: How many."
    ),
    Question.Choice(
        section = "3-mashq • Gap turiga mosini tanlang",
        prompt = "Inkor gapda «ko‘p vaqt yo‘q» — qaysi so‘z?",
        options = listOf("much", "many"),
        answer = "much",
        explanation = "Sanalmaydigan ot: much."
    ),
    Question.Choice(
        section = "3-mashq • Gap turiga mosini tanlang",
        prompt = "Darak gapda «ko‘p do‘stim bor» — qaysi so‘z?",
        options = listOf("a lot of", "much"),
        answer = "a lot of",
        explanation = "Sanaladigan ot bilan: a lot of."
    ),
    Question.Choice(
        section = "3-mashq • Gap turiga mosini tanlang",
        prompt = "«Qancha sut?» — qaysi so‘z?",
        options = listOf("How many", "How much"),
        answer = "How much",
        explanation = "Sanalmaydigan ot: How much."
    ),
    Question.Ordering(
        section = "4-mashq • So‘zlarni tartiblang",
        prompt = "many / how / books / do / you / have / ? — savolni tuzing.",
        words = listOf("How many", "books", "do you have?"),
        answer = "How many books do you have?",
        explanation = "To‘g‘ri savol: How many books do you have?"
    ),
    Question.Ordering(
        section = "4-mashq • So‘zlarni tartiblang",
        prompt = "much / how / water / is / there / ? — savolni tuzing.",
        words = listOf("How much", "water", "is there?"),
        answer = "How much water is there?",
        explanation = "To‘g‘ri savol: How much water is there?"
    ),
    Question.Ordering(
        section = "4-mashq • So‘zlarni tartiblang",
        prompt = "has / a lot of / my brother / toys — gapni tuzing.",
        words = listOf("My brother", "has", "a lot of", "toys."),
        answer = "My brother has a lot of toys.",
        explanation = "To‘g‘ri gap: My brother has a lot of toys."
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «How much chairs are there?»",
        answers = setOf("How many chairs are there?"),
        mode = TextMode.SENTENCE,
        explanation = "Ko‘plikdagi sanaladigan ot: many."
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «She has many water.»",
        answers = setOf("She has a lot of water."),
        mode = TextMode.SENTENCE,
        explanation = "Sanalmaydigan ot bilan many emas: a lot of water."
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «I have a lot friends.»",
        answers = setOf("I have a lot of friends."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: a lot of friends."
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «How many money do you need?»",
        answers = setOf("How much money do you need?"),
        mode = TextMode.SENTENCE,
        explanation = "Sanalmaydigan ot: much."
    ),
    Question.Ordering(
        section = "6-mashq • A lot of bilan 2 ta gap tuzing",
        prompt = "Sanaladigan ko‘plikdagi ot bilan gap tuzing.",
        words = listOf("I", "have", "a lot of", "books."),
        answer = "I have a lot of books.",
        explanation = "To‘g‘ri gap: I have a lot of books."
    ),
    Question.Ordering(
        section = "6-mashq • A lot of bilan 2 ta gap tuzing",
        prompt = "Sanalmaydigan ot bilan gap tuzing.",
        words = listOf("There is", "a lot of", "water."),
        answer = "There is a lot of water.",
        explanation = "To‘g‘ri gap: There is a lot of water."
    )
)