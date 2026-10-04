package com.example.gujumenglish.ui.grammar.practice

internal val lesson43Questions: List<Question> = listOf(
    Question.Text(
        section = "1-mashq • At, On yoki In?",
        prompt = "___ 6:30",
        answers = setOf("at"),
        explanation = "Aniq soat uchun: at."
    ),
    Question.Text(
        section = "1-mashq • At, On yoki In?",
        prompt = "___ Friday",
        answers = setOf("on"),
        explanation = "Hafta kuni uchun: on."
    ),
    Question.Text(
        section = "1-mashq • At, On yoki In?",
        prompt = "___ April",
        answers = setOf("in"),
        explanation = "Oy uchun: in."
    ),
    Question.Text(
        section = "1-mashq • At, On yoki In?",
        prompt = "___ the morning",
        answers = setOf("in"),
        explanation = "Kunning qismi uchun: in the morning."
    ),
    Question.Text(
        section = "1-mashq • At, On yoki In?",
        prompt = "___ night",
        answers = setOf("at"),
        explanation = "at night — alohida ifoda."
    ),
    Question.Text(
        section = "1-mashq • At, On yoki In?",
        prompt = "___ 2024",
        answers = setOf("in"),
        explanation = "Yil uchun: in."
    ),
    Question.Text(
        section = "1-mashq • At, On yoki In?",
        prompt = "___ 12 June",
        answers = setOf("on"),
        explanation = "Aniq sana uchun: on."
    ),
    Question.Text(
        section = "1-mashq • At, On yoki In?",
        prompt = "___ winter",
        answers = setOf("in"),
        explanation = "Fasl uchun: in."
    ),
    Question.Matching(
        section = "2-mashq • Vaqt turiga qarab guruhlang",
        prompt = "Har bir vaqt iborasini to‘g‘ri predlog bilan bog‘lang.",
        pairs = listOf(
            "noon" to "at",
            "8 o’clock" to "at",
            "night" to "at",
            "Monday" to "on",
            "Saturday morning" to "on",
            "September" to "in",
            "2030" to "in",
            "the afternoon" to "in"
        ),
        options = listOf("at", "on", "in"),
        explanation = "at: noon, 8 o’clock, night; on: Monday, Saturday morning; in: September, 2030, the afternoon."
    ),
    Question.Text(
        section = "3-mashq • Gaplarni to‘ldiring",
        prompt = "We have a test ___ Tuesday.",
        answers = setOf("on"),
        explanation = "Hafta kuni: on Tuesday."
    ),
    Question.Text(
        section = "3-mashq • Gaplarni to‘ldiring",
        prompt = "The film starts ___ 7:15.",
        answers = setOf("at"),
        explanation = "Aniq soat: at 7:15."
    ),
    Question.Text(
        section = "3-mashq • Gaplarni to‘ldiring",
        prompt = "My birthday is ___ December.",
        answers = setOf("in"),
        explanation = "Oy: in December."
    ),
    Question.Text(
        section = "3-mashq • Gaplarni to‘ldiring",
        prompt = "I do my homework ___ the evening.",
        answers = setOf("in"),
        explanation = "Kun qismi: in the evening."
    ),
    Question.Text(
        section = "3-mashq • Gaplarni to‘ldiring",
        prompt = "They visit us ___ summer.",
        answers = setOf("in"),
        explanation = "Fasl: in summer."
    ),
    Question.Choice(
        section = "4-mashq • Predlog kerakmi?",
        prompt = "___ Monday (on / —)",
        options = listOf("on", "—"),
        answer = "on",
        explanation = "Oddiy hafta kuni uchun on qo‘yiladi."
    ),
    Question.Choice(
        section = "4-mashq • Predlog kerakmi?",
        prompt = "___ next Monday (on / —)",
        options = listOf("on", "—"),
        answer = "—",
        explanation = "next/this/every bilan predlog qo‘yilmaydi."
    ),
    Question.Choice(
        section = "4-mashq • Predlog kerakmi?",
        prompt = "___ every Friday (on / —)",
        options = listOf("on", "—"),
        answer = "—",
        explanation = "every bilan predlog qo‘yilmaydi."
    ),
    Question.Choice(
        section = "4-mashq • Predlog kerakmi?",
        prompt = "___ this weekend (on / —)",
        options = listOf("on", "—"),
        answer = "—",
        explanation = "this bilan predlog qo‘yilmaydi."
    ),
    Question.Text(
        section = "5-mashq • Xatoni to‘g‘rilang",
        prompt = "Xatoni tuzating: «My class starts on 9 o’clock.»",
        answers = setOf("My class starts at 9 o’clock."),
        mode = TextMode.SENTENCE,
        explanation = "Soat uchun: at 9 o’clock."
    ),
    Question.Text(
        section = "5-mashq • Xatoni to‘g‘rilang",
        prompt = "Xatoni tuzating: «We travel at July.»",
        answers = setOf("We travel in July."),
        mode = TextMode.SENTENCE,
        explanation = "Oy uchun: in July."
    ),
    Question.Text(
        section = "5-mashq • Xatoni to‘g‘rilang",
        prompt = "Xatoni tuzating: «I play football in Monday.»",
        answers = setOf("I play football on Monday."),
        mode = TextMode.SENTENCE,
        explanation = "Hafta kuni uchun: on Monday."
    ),
    Question.Text(
        section = "5-mashq • Xatoni to‘g‘rilang",
        prompt = "Xatoni tuzating: «She visits us on every Sunday.»",
        answers = setOf("She visits us every Sunday."),
        mode = TextMode.SENTENCE,
        explanation = "every bilan predlog qo‘yilmaydi."
    ),
    Question.Text(
        section = "5-mashq • Xatoni to‘g‘rilang",
        prompt = "Xatoni tuzating: «He reads on the evening.»",
        answers = setOf("He reads in the evening."),
        mode = TextMode.SENTENCE,
        explanation = "Kun qismi uchun: in the evening."
    ),
    Question.Text(
        section = "6-mashq • O‘zingiz haqingizda yozing",
        prompt = "I wake up ___ 7. — gapni to‘ldiring.",
        answers = setOf("at"),
        explanation = "To‘g‘ri shakl: I wake up at 7."
    ),
    Question.Text(
        section = "6-mashq • O‘zingiz haqingizda yozing",
        prompt = "I study English ___ Monday. — gapni to‘ldiring.",
        answers = setOf("on"),
        explanation = "To‘g‘ri shakl: I study English on Monday."
    ),
    Question.Text(
        section = "6-mashq • O‘zingiz haqingizda yozing",
        prompt = "My birthday is ___ (oy). — gapni to‘ldiring.",
        answers = setOf("in"),
        explanation = "To‘g‘ri shakl: My birthday is in May."
    )
)