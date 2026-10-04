package com.example.gujumenglish.ui.grammar.practice

internal val lesson42Questions: List<Question> = listOf(
    Question.Matching(
        section = "1-mashq • Predlogni ma’nosi bilan moslang",
        prompt = "Har bir predlogni to‘g‘ri ma’nosi bilan bog‘lang.",
        pairs = listOf(
            "in" to "ichida",
            "on" to "ustida",
            "under" to "tagida",
            "next to" to "yonida"
        ),
        options = listOf("ichida", "ustida", "tagida", "yonida"),
        explanation = "in—ichida; on—ustida; under—tagida; next to—yonida."
    ),
    Question.Matching(
        section = "1-mashq • Predlogni ma’nosi bilan moslang",
        prompt = "Qolgan predloglarni to‘g‘ri ma’nosi bilan bog‘lang.",
        pairs = listOf(
            "behind" to "orqasida",
            "in front of" to "oldida",
            "between" to "orasida",
            "near" to "yaqinida"
        ),
        options = listOf("orqasida", "oldida", "orasida", "yaqinida"),
        explanation = "behind—orqasida; in front of—oldida; between—orasida; near—yaqinida."
    ),
    Question.Choice(
        section = "2-mashq • Vaziyatga mos predlogni tanlang",
        prompt = "The keys are (in / on) the bag. — sumkaning ichida",
        options = listOf("in", "on"),
        answer = "in",
        explanation = "Ichida: in."
    ),
    Question.Choice(
        section = "2-mashq • Vaziyatga mos predlogni tanlang",
        prompt = "The picture is (on / under) the wall.",
        options = listOf("on", "under"),
        answer = "on",
        explanation = "Devorda: on the wall."
    ),
    Question.Choice(
        section = "2-mashq • Vaziyatga mos predlogni tanlang",
        prompt = "The cat is (under / between) the chair.",
        options = listOf("under", "between"),
        answer = "under",
        explanation = "Stul tagida: under the chair."
    ),
    Question.Choice(
        section = "2-mashq • Vaziyatga mos predlogni tanlang",
        prompt = "The bank is (next to / in) the shop. — yonida",
        options = listOf("next to", "in"),
        answer = "next to",
        explanation = "Yonida: next to."
    ),
    Question.Choice(
        section = "2-mashq • Vaziyatga mos predlogni tanlang",
        prompt = "The school is (between / behind) the park and the café.",
        options = listOf("between", "behind"),
        answer = "between",
        explanation = "Ikki joy orasida: between."
    ),
    Question.Choice(
        section = "2-mashq • Vaziyatga mos predlogni tanlang",
        prompt = "The car is (in front of / in) the house.",
        options = listOf("in front of", "in"),
        answer = "in front of",
        explanation = "Uy oldida: in front of."
    ),
    Question.Text(
        section = "3-mashq • Am, Is yoki Are bilan to‘ldiring",
        prompt = "The book ___ on the desk.",
        answers = setOf("is"),
        explanation = "Bitta narsa: is."
    ),
    Question.Text(
        section = "3-mashq • Am, Is yoki Are bilan to‘ldiring",
        prompt = "The shoes ___ under the bed.",
        answers = setOf("are"),
        explanation = "Ko‘plik: are."
    ),
    Question.Text(
        section = "3-mashq • Am, Is yoki Are bilan to‘ldiring",
        prompt = "My school ___ near the park.",
        answers = setOf("is"),
        explanation = "Bitta ega: is."
    ),
    Question.Text(
        section = "3-mashq • Am, Is yoki Are bilan to‘ldiring",
        prompt = "The café ___ between the bank and the shop.",
        answers = setOf("is"),
        explanation = "Bitta ega: is."
    ),
    Question.Ordering(
        section = "4-mashq • Rasmni tasavvur qiling va gap tuzing",
        prompt = "(the book / on / the table) — gapni tuzing.",
        words = listOf("Is", "The book", "on", "the table"),
        answer = "The book is on the table.",
        explanation = "To‘g‘ri gap: The book is on the table."
    ),
    Question.Ordering(
        section = "4-mashq • Rasmni tasavvur qiling va gap tuzing",
        prompt = "(the cat / behind / the door) — gapni tuzing.",
        words = listOf("Is", "The cat", "behind", "the door"),
        answer = "The cat is behind the door.",
        explanation = "To‘g‘ri gap: The cat is behind the door."
    ),
    Question.Ordering(
        section = "4-mashq • Rasmni tasavvur qiling va gap tuzing",
        prompt = "(the garden / next to / the house) — gapni tuzing.",
        words = listOf("Is", "The garden", "next to", "the house"),
        answer = "The garden is next to the house.",
        explanation = "To‘g‘ri gap: The garden is next to the house."
    ),
    Question.Ordering(
        section = "4-mashq • Rasmni tasavvur qiling va gap tuzing",
        prompt = "(the pharmacy / between / the bank and the café) — gapni tuzing.",
        words = listOf("Is", "The pharmacy", "between", "the bank", "and the café"),
        answer = "The pharmacy is between the bank and the café.",
        explanation = "To‘g‘ri gap: The pharmacy is between the bank and the café."
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «The cat under the chair.»",
        answers = setOf("The cat is under the chair."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: The cat is under the chair."
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «The book is in the table.» (stol ustida)",
        answers = setOf("The book is on the table."),
        mode = TextMode.SENTENCE,
        explanation = "Ustida — on the table."
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «The bank are near the school.»",
        answers = setOf("The bank is near the school."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: The bank is near the school."
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «The café is between the bank.» (bank va do‘kon orasida)",
        answers = setOf("The café is between the bank and the shop."),
        mode = TextMode.SENTENCE,
        explanation = "Between ikki joyni oladi: between A and B."
    ),
    Question.Text(
        section = "6-mashq • Where bilan javob bering",
        prompt = "Where is the phone? (on the desk) — javob bering.",
        answers = setOf("It is on the desk."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: It is on the desk."
    ),
    Question.Text(
        section = "6-mashq • Where bilan javob bering",
        prompt = "Where are the children? (in the park) — javob bering.",
        answers = setOf("They are in the park."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: They are in the park."
    )
)