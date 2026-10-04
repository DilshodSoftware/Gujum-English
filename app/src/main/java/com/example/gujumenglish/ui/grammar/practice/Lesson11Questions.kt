package com.example.gujumenglish.ui.grammar.practice

internal val lesson11Questions: List<Question> = listOf(
    Question.Text(
        section = "1-mashq • Inkorni to‘ldiring",
        prompt = "«I am cold. → I ___ cold.» — to‘ldiring.",
        answers = setOf("am not"),
        explanation = "I am not cold."
    ),
    Question.Text(
        section = "1-mashq • Inkorni to‘ldiring",
        prompt = "«He is a doctor. → He ___ a doctor.» — to‘ldiring.",
        answers = setOf("is not", "isn’t"),
        explanation = "He is not a doctor."
    ),
    Question.Text(
        section = "1-mashq • Inkorni to‘ldiring",
        prompt = "«You are late. → You ___ late.» — to‘ldiring.",
        answers = setOf("are not", "aren’t"),
        explanation = "You are not late."
    ),
    Question.Text(
        section = "1-mashq • Inkorni to‘ldiring",
        prompt = "«The room is clean. → The room ___ clean.» — to‘ldiring.",
        answers = setOf("is not", "isn’t"),
        explanation = "The room is not clean."
    ),
    Question.Text(
        section = "1-mashq • Inkorni to‘ldiring",
        prompt = "«We are at work. → We ___ at work.» — to‘ldiring.",
        answers = setOf("are not", "aren’t"),
        explanation = "We are not at work."
    ),
    Question.Text(
        section = "1-mashq • Inkorni to‘ldiring",
        prompt = "«They are hungry. → They ___ hungry.» — to‘ldiring.",
        answers = setOf("are not", "aren’t"),
        explanation = "They are not hungry."
    ),
    Question.Ordering(
        section = "2-mashq • Darak gapni savolga aylantiring",
        prompt = "So‘zlardan savol tuzing: a student / Are / you",
        words = listOf("a student", "Are", "you"),
        answer = "Are you a student?",
        explanation = "To‘g‘ri savol: Are you a student?"
    ),
    Question.Ordering(
        section = "2-mashq • Darak gapni savolga aylantiring",
        prompt = "So‘zlardan savol tuzing: your bag / Is / it",
        words = listOf("your bag", "Is", "it"),
        answer = "Is it your bag?",
        explanation = "To‘g‘ri savol: Is it your bag?"
    ),
    Question.Ordering(
        section = "2-mashq • Darak gapni savolga aylantiring",
        prompt = "So‘zlardan savol tuzing: at school / Is / Sam",
        words = listOf("at school", "Is", "Sam"),
        answer = "Is Sam at school?",
        explanation = "To‘g‘ri savol: Is Sam at school?"
    ),
    Question.Ordering(
        section = "2-mashq • Darak gapni savolga aylantiring",
        prompt = "So‘zlardan savol tuzing: happy / Are / the children",
        words = listOf("happy", "Are", "the children"),
        answer = "Are the children happy?",
        explanation = "To‘g‘ri savol: Are the children happy?"
    ),
    Question.Ordering(
        section = "2-mashq • Darak gapni savolga aylantiring",
        prompt = "So‘zlardan savol tuzing: early / I / Am",
        words = listOf("early", "I", "Am"),
        answer = "Am I early?",
        explanation = "To‘g‘ri savol: Am I early?"
    ),
    Question.Text(
        section = "3-mashq • Qisqa javobni tanlang",
        prompt = "«Are you tired? (ha)» — qisqa javob yozing.",
        answers = setOf("Yes, I am."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: Yes, I am."
    ),
    Question.Text(
        section = "3-mashq • Qisqa javobni tanlang",
        prompt = "«Is Anna a teacher? (yo‘q)» — qisqa javob yozing.",
        answers = setOf("No, she isn’t.", "No, she is not."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: No, she isn’t."
    ),
    Question.Text(
        section = "3-mashq • Qisqa javobni tanlang",
        prompt = "«Are the boys at home? (ha)» — qisqa javob yozing.",
        answers = setOf("Yes, they are."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: Yes, they are."
    ),
    Question.Text(
        section = "3-mashq • Qisqa javobni tanlang",
        prompt = "«Is it cold today? (yo‘q)» — qisqa javob yozing.",
        answers = setOf("No, it isn’t.", "No, it is not."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: No, it isn’t."
    ),
    Question.Text(
        section = "3-mashq • Qisqa javobni tanlang",
        prompt = "«Are we ready? (ha)» — qisqa javob yozing.",
        answers = setOf("Yes, we are."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: Yes, we are."
    ),
    Question.Choice(
        section = "4-mashq • To‘g‘ri variantni belgilang",
        prompt = "___ your sister at home?",
        options = listOf("Is", "Are"),
        answer = "Is",
        explanation = "your sister — birlik: Is."
    ),
    Question.Choice(
        section = "4-mashq • To‘g‘ri variantni belgilang",
        prompt = "___ I in the right room?",
        options = listOf("Am", "Are"),
        answer = "Am",
        explanation = "I bilan savolda Am."
    ),
    Question.Choice(
        section = "4-mashq • To‘g‘ri variantni belgilang",
        prompt = "They ___ busy.",
        options = listOf("isn’t", "aren’t"),
        answer = "aren’t",
        explanation = "They bilan aren’t."
    ),
    Question.Choice(
        section = "4-mashq • To‘g‘ri variantni belgilang",
        prompt = "___ you a new student?",
        options = listOf("Do", "Are"),
        answer = "Are",
        explanation = "To be bilan savolda Do ishlatilmaydi: Are."
    ),
    Question.Choice(
        section = "4-mashq • To‘g‘ri variantni belgilang",
        prompt = "My phone ___ old.",
        options = listOf("isn’t", "aren’t"),
        answer = "isn’t",
        explanation = "My phone — birlik: isn’t."
    ),
    Question.Choice(
        section = "4-mashq • To‘g‘ri variantni belgilang",
        prompt = "___ Ali and Vali brothers?",
        options = listOf("Is", "Are"),
        answer = "Are",
        explanation = "Ikkilik — ko‘plik: Are."
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «She not is my sister.»",
        answers = setOf("She is not my sister."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: She is not my sister."
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «Is they at the park?»",
        answers = setOf("Are they at the park?"),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: Are they at the park?"
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «Do you are happy?»",
        answers = setOf("Are you happy?"),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: Are you happy?"
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "«No, I am.» (savolga “yo‘q” deb javob) — to‘g‘rilang.",
        answers = setOf("No, I’m not.", "No, I am not."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: No, I’m not."
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «He aren’t at work.»",
        answers = setOf("He isn’t at work.", "He is not at work."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: He isn’t at work."
    ),
    Question.Text(
        section = "6-mashq • Mini-dialogni to‘ldiring",
        prompt = "A: ___ you new here? B: Yes, I ___. — birinchi bo‘sh joyni to‘ldiring.",
        answers = setOf("Are"),
        explanation = "Are you new here?"
    ),
    Question.Text(
        section = "6-mashq • Mini-dialogni to‘ldiring",
        prompt = "A: Are you new here? B: Yes, I ___. — to‘ldiring.",
        answers = setOf("am"),
        explanation = "Yes, I am."
    ),
    Question.Text(
        section = "6-mashq • Mini-dialogni to‘ldiring",
        prompt = "A: ___ your friends here too? — to‘ldiring.",
        answers = setOf("Are"),
        explanation = "Are your friends here too?"
    ),
    Question.Text(
        section = "6-mashq • Mini-dialogni to‘ldiring",
        prompt = "B: No, they ___. — to‘ldiring.",
        answers = setOf("aren’t", "are not"),
        explanation = "No, they aren’t."
    ),
    Question.Text(
        section = "6-mashq • Mini-dialogni to‘ldiring",
        prompt = "A: ___ your teacher kind? — to‘ldiring.",
        answers = setOf("Is"),
        explanation = "Is your teacher kind?"
    ),
    Question.Text(
        section = "6-mashq • Mini-dialogni to‘ldiring",
        prompt = "B: Yes, she ___. — to‘ldiring.",
        answers = setOf("is"),
        explanation = "Yes, she is."
    ),
    Question.Ordering(
        section = "7-mashq • Inglizchaga tarjima qiling",
        prompt = "«Ular band emas.» — so‘zlardan gap tuzing: aren’t / busy / They",
        words = listOf("aren’t", "busy", "They"),
        answer = "They aren’t busy.",
        explanation = "To‘g‘ri gap: They aren’t busy."
    ),
    Question.Ordering(
        section = "7-mashq • Inglizchaga tarjima qiling",
        prompt = "«Siz tayyormisiz?» — so‘zlardan gap tuzing: you / Are / ready",
        words = listOf("you", "Are", "ready"),
        answer = "Are you ready?",
        explanation = "To‘g‘ri gap: Are you ready?"
    ),
    Question.Ordering(
        section = "7-mashq • Inglizchaga tarjima qiling",
        prompt = "«Ha, men tayyorman.» — so‘zlardan gap tuzing: am / Yes, / I",
        words = listOf("am", "Yes,", "I"),
        answer = "Yes, I am.",
        explanation = "To‘g‘ri gap: Yes, I am."
    ),
    Question.Ordering(
        section = "7-mashq • Inglizchaga tarjima qiling",
        prompt = "«Akam shifokor emas.» — so‘zlardan gap tuzing: a doctor / My brother / isn’t",
        words = listOf("a doctor", "My brother", "isn’t"),
        answer = "My brother isn’t a doctor.",
        explanation = "To‘g‘ri gap: My brother isn’t a doctor."
    )
)
