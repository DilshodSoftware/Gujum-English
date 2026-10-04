package com.example.gujumenglish.ui.grammar.practice

internal val lesson58Questions: List<Question> = listOf(
    Question.Choice(
        section = "1-mashq • Vaziyatga mosini tanlang",
        prompt = "Rejam tayyor: I (am going to / will) visit my aunt on Saturday.",
        options = listOf("am going to", "will"),
        answer = "am going to",
        explanation = "Oldindan reja: going to."
    ),
    Question.Choice(
        section = "1-mashq • Vaziyatga mosini tanlang",
        prompt = "Telefon jiringlaydi: «Men javob beraman!» I (am going to / will) answer it.",
        options = listOf("am going to", "will"),
        answer = "will",
        explanation = "Ayni paytdagi qaror: will."
    ),
    Question.Choice(
        section = "1-mashq • Vaziyatga mosini tanlang",
        prompt = "Qora bulutlar ko‘rinib turibdi: It (is going to / will) rain.",
        options = listOf("is going to", "will"),
        answer = "is going to",
        explanation = "Ko‘rinib turgan belgi: going to."
    ),
    Question.Choice(
        section = "1-mashq • Vaziyatga mosini tanlang",
        prompt = "Va’da: I (am going to / will) help you tomorrow.",
        options = listOf("am going to", "will"),
        answer = "will",
        explanation = "Va’da uchun: will."
    ),
    Question.Choice(
        section = "1-mashq • Vaziyatga mosini tanlang",
        prompt = "Menimcha, jamoa yutadi: The team (is going to / will) win.",
        options = listOf("is going to", "will"),
        answer = "will",
        explanation = "Fikrga asoslangan taxmin: will."
    ),
    Question.Text(
        section = "2-mashq • Qolipni to‘ldiring",
        prompt = "She ___ going to study. (is / will)",
        answers = setOf("is"),
        explanation = "Bitta ayol: is going to."
    ),
    Question.Text(
        section = "2-mashq • Qolipni to‘ldiring",
        prompt = "They ___ going to move. (are / will)",
        answers = setOf("are"),
        explanation = "Ko‘plik: are going to."
    ),
    Question.Text(
        section = "2-mashq • Qolipni to‘ldiring",
        prompt = "I ___ call you later. (will / am)",
        answers = setOf("will"),
        explanation = "Will bilan: will call."
    ),
    Question.Text(
        section = "2-mashq • Qolipni to‘ldiring",
        prompt = "He is going to ___ dinner. (cook / cooking)",
        answers = setOf("cook"),
        explanation = "Going to dan keyin oddiy shakl: cook."
    ),
    Question.Text(
        section = "2-mashq • Qolipni to‘ldiring",
        prompt = "We will ___ them. (visit / visited)",
        answers = setOf("visit"),
        explanation = "Will dan keyin oddiy shakl: visit."
    ),
    Question.Text(
        section = "3-mashq • Inkor shaklini tanlang",
        prompt = "Oldindan reja: She ___ going to travel. (isn’t / won’t)",
        answers = setOf("isn’t"),
        explanation = "Going to inkori: isn’t going to."
    ),
    Question.Text(
        section = "3-mashq • Inkor shaklini tanlang",
        prompt = "Will inkori: They ___ come tonight. (aren’t / won’t)",
        answers = setOf("won’t"),
        explanation = "Will inkori: won’t."
    ),
    Question.Text(
        section = "3-mashq • Inkor shaklini tanlang",
        prompt = "Reja qilmaganman: I ___ going to buy a car. (am not / will not going)",
        answers = setOf("am not"),
        explanation = "To‘g‘ri shakl: am not going to."
    ),
    Question.Ordering(
        section = "4-mashq • Savolni tuzing",
        prompt = "Reja haqida: (you / travel / next week / going to) — savolni tuzing.",
        words = listOf("Are", "you", "going to travel", "next week"),
        answer = "Are you going to travel next week?",
        explanation = "To‘g‘ri savol: Are you going to travel next week?"
    ),
    Question.Ordering(
        section = "4-mashq • Savolni tuzing",
        prompt = "Will savoli: (she / call / tonight) — savolni tuzing.",
        words = listOf("Will", "she", "call", "tonight"),
        answer = "Will she call tonight?",
        explanation = "To‘g‘ri savol: Will she call tonight?"
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «I going to study tomorrow.»",
        answers = setOf("I am going to study tomorrow."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: I am going to study tomorrow."
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «She will goes shopping.»",
        answers = setOf("She will go shopping."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: She will go shopping."
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «They are going to played tennis.»",
        answers = setOf("They are going to play tennis."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: They are going to play tennis."
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «He is going to will call us.»",
        answers = setOf("He is going to call us.", "He will call us."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: He is going to call us / He will call us."
    ),
    Question.Choice(
        section = "6-mashq • Vaziyatlarni o‘zingiz belgilang",
        prompt = "Ertaga qilmoqchi bo‘lgan oldindan rejangiz — qaysi shakl?",
        options = listOf("going to", "will"),
        answer = "going to",
        explanation = "Oldindan reja: I’m going to study tomorrow."
    ),
    Question.Choice(
        section = "6-mashq • Vaziyatlarni o‘zingiz belgilang",
        prompt = "Do‘stingizga beradigan va’dangiz — qaysi shakl?",
        options = listOf("going to", "will"),
        answer = "will",
        explanation = "Va’da: I will help you."
    ),
    Question.Choice(
        section = "6-mashq • Vaziyatlarni o‘zingiz belgilang",
        prompt = "Hozir ko‘rayotgan osmoningizga qarab taxmin — qaysi shakl?",
        options = listOf("going to", "will"),
        answer = "going to",
        explanation = "Ko‘rinib turgan belgi: It is going to rain."
    )
)