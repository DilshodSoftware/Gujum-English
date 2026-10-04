package com.example.gujumenglish.ui.grammar.practice

internal val lesson57Questions: List<Question> = listOf(
    Question.Text(
        section = "1-mashq • Will bilan fe’lni to‘ldiring",
        prompt = "I ___ (call) you tomorrow.",
        answers = setOf("will call"),
        explanation = "To‘g‘ri shakl: will call."
    ),
    Question.Text(
        section = "1-mashq • Will bilan fe’lni to‘ldiring",
        prompt = "He ___ (be) happy.",
        answers = setOf("will be"),
        explanation = "To‘g‘ri shakl: will be."
    ),
    Question.Text(
        section = "1-mashq • Will bilan fe’lni to‘ldiring",
        prompt = "We ___ (visit) our friends next week.",
        answers = setOf("will visit"),
        explanation = "To‘g‘ri shakl: will visit."
    ),
    Question.Text(
        section = "1-mashq • Will bilan fe’lni to‘ldiring",
        prompt = "They ___ (go) home later.",
        answers = setOf("will go"),
        explanation = "To‘g‘ri shakl: will go."
    ),
    Question.Text(
        section = "1-mashq • Will bilan fe’lni to‘ldiring",
        prompt = "Sara ___ (help) her mother.",
        answers = setOf("will help"),
        explanation = "To‘g‘ri shakl: will help."
    ),
    Question.Choice(
        section = "2-mashq • Qavsdan to‘g‘ri variantni tanlang",
        prompt = "She will (come / comes) later.",
        options = listOf("come", "comes"),
        answer = "come",
        explanation = "Will dan keyin oddiy shakl: come."
    ),
    Question.Choice(
        section = "2-mashq • Qavsdan to‘g‘ri variantni tanlang",
        prompt = "I will (to help / help) you.",
        options = listOf("to help", "help"),
        answer = "help",
        explanation = "Will dan keyin to qo‘shilmaydi."
    ),
    Question.Choice(
        section = "2-mashq • Qavsdan to‘g‘ri variantni tanlang",
        prompt = "They will (travel / travelled) next month.",
        options = listOf("travel", "travelled"),
        answer = "travel",
        explanation = "Will dan keyin oddiy shakl: travel."
    ),
    Question.Choice(
        section = "2-mashq • Qavsdan to‘g‘ri variantni tanlang",
        prompt = "He’ll (be / is) a good doctor.",
        options = listOf("be", "is"),
        answer = "be",
        explanation = "Qisqa shakl he’ll + be: he’ll be."
    ),
    Question.Text(
        section = "3-mashq • Inkor va savol tuzing",
        prompt = "We will go tomorrow. (inkor)",
        answers = setOf("We won’t go tomorrow."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: We won’t go tomorrow."
    ),
    Question.Ordering(
        section = "3-mashq • Inkor va savol tuzing",
        prompt = "She will call me. (savol) — savolga o‘tkazing.",
        words = listOf("Will", "she", "call", "me"),
        answer = "Will she call me?",
        explanation = "To‘g‘ri savol: Will she call me?"
    ),
    Question.Text(
        section = "3-mashq • Inkor va savol tuzing",
        prompt = "They will be late. (inkor)",
        answers = setOf("They won’t be late."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: They won’t be late."
    ),
    Question.Ordering(
        section = "3-mashq • Inkor va savol tuzing",
        prompt = "You will help us. (savol) — savolga o‘tkazing.",
        words = listOf("Will", "you", "help", "us"),
        answer = "Will you help us?",
        explanation = "To‘g‘ri savol: Will you help us?"
    ),
    Question.Text(
        section = "4-mashq • Qisqa shaklga o‘tkazing",
        prompt = "I will → ___",
        answers = setOf("I’ll"),
        explanation = "Qisqa shakl: I’ll."
    ),
    Question.Text(
        section = "4-mashq • Qisqa shaklga o‘tkazing",
        prompt = "you will → ___",
        answers = setOf("you’ll"),
        explanation = "Qisqa shakl: you’ll."
    ),
    Question.Text(
        section = "4-mashq • Qisqa shaklga o‘tkazing",
        prompt = "she will → ___",
        answers = setOf("she’ll"),
        explanation = "Qisqa shakl: she’ll."
    ),
    Question.Text(
        section = "4-mashq • Qisqa shaklga o‘tkazing",
        prompt = "they will → ___",
        answers = setOf("they’ll"),
        explanation = "Qisqa shakl: they’ll."
    ),
    Question.Ordering(
        section = "5-mashq • Vaziyatga mos gap tuzing",
        prompt = "Va’da: «Men senga yordam beraman.» — gapni tuzing.",
        words = listOf("I", "will help", "you."),
        answer = "I will help you.",
        explanation = "To‘g‘ri javob: I will help you."
    ),
    Question.Ordering(
        section = "5-mashq • Vaziyatga mos gap tuzing",
        prompt = "Hozir qaror: «Charchadim. Hozir dam olaman.» — gapni tuzing.",
        words = listOf("I’m tired.", "I’ll", "rest now."),
        answer = "I’m tired. I’ll rest now.",
        explanation = "To‘g‘ri javob: I’m tired. I’ll rest now."
    ),
    Question.Ordering(
        section = "5-mashq • Vaziyatga mos gap tuzing",
        prompt = "Taxmin: «Menimcha, ertaga yomg‘ir yog‘adi.» — gapni tuzing.",
        words = listOf("I think", "will rain", "tomorrow", "it"),
        answer = "I think it will rain tomorrow.",
        explanation = "To‘g‘ri javob: I think it will rain tomorrow."
    ),
    Question.Text(
        section = "6-mashq • Xatolarni tuzating",
        prompt = "Xatoni tuzating: «He will goes home.»",
        answers = setOf("He will go home."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: He will go home."
    ),
    Question.Text(
        section = "6-mashq • Xatolarni tuzating",
        prompt = "Xatoni tuzating: «I will to call you.»",
        answers = setOf("I will call you."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: I will call you."
    ),
    Question.Text(
        section = "6-mashq • Xatolarni tuzating",
        prompt = "Xatoni tuzating: «Will she comes tomorrow?»",
        answers = setOf("Will she come tomorrow?"),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: Will she come tomorrow?"
    ),
    Question.Text(
        section = "6-mashq • Xatolarni tuzating",
        prompt = "Xatoni tuzating: «They won’t be go there.»",
        answers = setOf("They won’t go there."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: They won’t go there."
    )
)