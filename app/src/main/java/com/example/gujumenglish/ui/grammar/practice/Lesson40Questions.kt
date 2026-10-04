package com.example.gujumenglish.ui.grammar.practice

internal val lesson40Questions: List<Question> = listOf(
    Question.Ordering(
        section = "1-mashq • So‘zlarni savol tartibiga qo‘ying",
        prompt = "you / can / cook / ? — savolni tuzing.",
        words = listOf("you", "can", "cook?"),
        answer = "Can you cook?",
        explanation = "To‘g‘ri savol: Can you cook?"
    ),
    Question.Ordering(
        section = "1-mashq • So‘zlarni savol tartibiga qo‘ying",
        prompt = "can / your sister / swim / ? — savolni tuzing.",
        words = listOf("your sister", "can", "swim?"),
        answer = "Can your sister swim?",
        explanation = "To‘g‘ri savol: Can your sister swim?"
    ),
    Question.Ordering(
        section = "1-mashq • So‘zlarni savol tartibiga qo‘ying",
        prompt = "I / can / use your phone / ? — savolni tuzing.",
        words = listOf("I", "can", "use your phone?"),
        answer = "Can I use your phone?",
        explanation = "To‘g‘ri savol: Can I use your phone?"
    ),
    Question.Ordering(
        section = "1-mashq • So‘zlarni savol tartibiga qo‘ying",
        prompt = "help / can / they / us / ? — savolni tuzing.",
        words = listOf("they", "can", "help", "us?"),
        answer = "Can they help us?",
        explanation = "To‘g‘ri savol: Can they help us?"
    ),
    Question.Choice(
        section = "2-mashq • Qobiliyat, iltimos yoki ruxsat?",
        prompt = "Can you speak English? — nima so‘ralyapti?",
        options = listOf("qobiliyat", "iltimos"),
        answer = "qobiliyat",
        explanation = "Nimani bilishini so‘rash — qobiliyat."
    ),
    Question.Choice(
        section = "2-mashq • Qobiliyat, iltimos yoki ruxsat?",
        prompt = "Can you open the window, please? — nima so‘ralyapti?",
        options = listOf("qobiliyat", "iltimos"),
        answer = "iltimos",
        explanation = "Biror narsa qilishni so‘rash — iltimos."
    ),
    Question.Choice(
        section = "2-mashq • Qobiliyat, iltimos yoki ruxsat?",
        prompt = "Can I sit here? — nima so‘ralyapti?",
        options = listOf("ruxsat", "qobiliyat"),
        answer = "ruxsat",
        explanation = "Ruxsat so‘ralyapti."
    ),
    Question.Choice(
        section = "2-mashq • Qobiliyat, iltimos yoki ruxsat?",
        prompt = "Can your brother drive? — nima so‘ralyapti?",
        options = listOf("qobiliyat", "ruxsat"),
        answer = "qobiliyat",
        explanation = "Nimani bilishini so‘rash — qobiliyat."
    ),
    Question.Text(
        section = "3-mashq • Qisqa javobni to‘ldiring",
        prompt = "Can you swim? (ha) — Yes, ___ ___.",
        answers = setOf("I can"),
        explanation = "To‘g‘ri javob: Yes, I can."
    ),
    Question.Text(
        section = "3-mashq • Qisqa javobni to‘ldiring",
        prompt = "Can he cook? (yo‘q) — No, ___ ___.",
        answers = setOf("he can’t"),
        explanation = "To‘g‘ri javob: No, he can’t."
    ),
    Question.Text(
        section = "3-mashq • Qisqa javobni to‘ldiring",
        prompt = "Can your friends come? (ha) — Yes, ___ ___.",
        answers = setOf("they can"),
        explanation = "To‘g‘ri javob: Yes, they can."
    ),
    Question.Text(
        section = "3-mashq • Qisqa javobni to‘ldiring",
        prompt = "Can I use your pen? (ha, ruxsat) — Yes, you ___.",
        answers = setOf("can"),
        explanation = "To‘g‘ri javob: Yes, you can."
    ),
    Question.Choice(
        section = "4-mashq • Muloyim iltimosni tanlang",
        prompt = "Yordam so‘rash uchun qaysi gap?",
        options = listOf("Can you help me?", "You can help me?"),
        answer = "Can you help me?",
        explanation = "Savol shakli: Can you help me?"
    ),
    Question.Choice(
        section = "4-mashq • Muloyim iltimosni tanlang",
        prompt = "Iltimosni muloyim qilish uchun qaysi so‘zni qo‘shamiz?",
        options = listOf("please", "yesterday"),
        answer = "please",
        explanation = "Iltimos so‘zi: please."
    ),
    Question.Choice(
        section = "4-mashq • Muloyim iltimosni tanlang",
        prompt = "«Iltimos, takrorlang» — Can you ___ that, please?",
        options = listOf("repeat", "repeats"),
        answer = "repeat",
        explanation = "Can dan keyin oddiy shakl: repeat."
    ),
    Question.Text(
        section = "5-mashq • Can yoki Can’t?",
        prompt = "___ I come in? (ruxsat so‘rash)",
        answers = setOf("Can"),
        explanation = "Ruxsat so‘rash: Can."
    ),
    Question.Text(
        section = "5-mashq • Can yoki Can’t?",
        prompt = "Sorry, you ___ use my pen now. (mumkin emas)",
        answers = setOf("can’t"),
        explanation = "Mumkin emas: can’t."
    ),
    Question.Text(
        section = "5-mashq • Can yoki Can’t?",
        prompt = "___ you repeat the answer, please? (iltimos)",
        answers = setOf("Can"),
        explanation = "Iltimos: Can."
    ),
    Question.Text(
        section = "6-mashq • Xatolarni tuzating",
        prompt = "Xatoni tuzating: «Can she sings?»",
        answers = setOf("Can she sing?"),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: Can she sing?"
    ),
    Question.Text(
        section = "6-mashq • Xatolarni tuzating",
        prompt = "Xatoni tuzating: «Do you can drive?»",
        answers = setOf("Can you drive?"),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: Can you drive?"
    ),
    Question.Text(
        section = "6-mashq • Xatolarni tuzating",
        prompt = "Xatoni tuzating: «Can I to come in?»",
        answers = setOf("Can I come in?"),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: Can I come in?"
    ),
    Question.Text(
        section = "6-mashq • Xatolarni tuzating",
        prompt = "Xatoni tuzating: «Can you opens the door, please?»",
        answers = setOf("Can you open the door, please?"),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: Can you open the door, please?"
    )
)