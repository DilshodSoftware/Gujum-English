package com.example.gujumenglish.ui.grammar.practice

internal val lesson26Questions: List<Question> = listOf(
    Question.Choice(
        section = "1-mashq • Ma’nosiga mos ravishni toping",
        prompt = "Hech qachon: (never / always)",
        options = listOf("never", "always"),
        answer = "never",
        explanation = "Hech qachon: never."
    ),
    Question.Choice(
        section = "1-mashq • Ma’nosiga mos ravishni toping",
        prompt = "Kamdan-kam: (rarely / often)",
        options = listOf("rarely", "often"),
        answer = "rarely",
        explanation = "Kamdan-kam: rarely."
    ),
    Question.Choice(
        section = "1-mashq • Ma’nosiga mos ravishni toping",
        prompt = "Tez-tez: (often / never)",
        options = listOf("often", "never"),
        answer = "often",
        explanation = "Tez-tez: often."
    ),
    Question.Choice(
        section = "1-mashq • Ma’nosiga mos ravishni toping",
        prompt = "Odatda: (usually / sometimes)",
        options = listOf("usually", "sometimes"),
        answer = "usually",
        explanation = "Odatda: usually."
    ),
    Question.Choice(
        section = "1-mashq • Ma’nosiga mos ravishni toping",
        prompt = "Ba’zan: (always / sometimes)",
        options = listOf("always", "sometimes"),
        answer = "sometimes",
        explanation = "Ba’zan: sometimes."
    ),
    Question.Ordering(
        section = "2-mashq • Tez-tezlik tartibini tuzing",
        prompt = "Eng ko‘p takrorlanadigandan boshlab toza tartibda yozing.",
        words = listOf("never", "often", "always", "rarely", "usually", "sometimes"),
        answer = "always, usually, often, sometimes, rarely, never.",
        explanation = "To‘g‘ri tartib: always → usually → often → sometimes → rarely → never."
    ),
    Question.Ordering(
        section = "3-mashq • Ravishni to‘g‘ri joyga qo‘ying",
        prompt = "I / drink / always / water. — gapni tuzing.",
        words = listOf("I", "drink", "always", "water"),
        answer = "I always drink water.",
        explanation = "To‘g‘ri gap: I always drink water."
    ),
    Question.Ordering(
        section = "3-mashq • Ravishni to‘g‘ri joyga qo‘ying",
        prompt = "They / are / often / late. — gapni tuzing.",
        words = listOf("They", "are", "often", "late"),
        answer = "They are often late.",
        explanation = "To be dan keyin: They are often late."
    ),
    Question.Ordering(
        section = "3-mashq • Ravishni to‘g‘ri joyga qo‘ying",
        prompt = "My sister / usually / walks / to school. — gapni tuzing.",
        words = listOf("My sister", "usually", "walks", "to school"),
        answer = "My sister usually walks to school.",
        explanation = "To‘g‘ri gap: My sister usually walks to school."
    ),
    Question.Ordering(
        section = "3-mashq • Ravishni to‘g‘ri joyga qo‘ying",
        prompt = "He / is / never / angry. — gapni tuzing.",
        words = listOf("He", "is", "never", "angry"),
        answer = "He is never angry.",
        explanation = "To be dan keyin: He is never angry."
    ),
    Question.Ordering(
        section = "3-mashq • Ravishni to‘g‘ri joyga qo‘ying",
        prompt = "We / sometimes / watch / films. — gapni tuzing.",
        words = listOf("We", "sometimes", "watch", "films"),
        answer = "We sometimes watch films.",
        explanation = "To‘g‘ri gap: We sometimes watch films."
    ),
    Question.Choice(
        section = "4-mashq • Oddiy fe’lmi yoki To Be?",
        prompt = "«I always eat breakfast.» — ravish to‘g‘ri joylashganmi?",
        options = listOf("to‘g‘ri", "tuzatish kerak"),
        answer = "to‘g‘ri",
        explanation = "Oddiy fe’ldan oldin — to‘g‘ri."
    ),
    Question.Choice(
        section = "4-mashq • Oddiy fe’lmi yoki To Be?",
        prompt = "«She always is kind.» — ravish to‘g‘ri joylashganmi?",
        options = listOf("to‘g‘ri", "tuzatish kerak"),
        answer = "tuzatish kerak",
        explanation = "To be bilan ravish undan keyin keladi: She is always kind."
    ),
    Question.Choice(
        section = "4-mashq • Oddiy fe’lmi yoki To Be?",
        prompt = "«He is usually at home.» — ravish to‘g‘ri joylashganmi?",
        options = listOf("to‘g‘ri", "tuzatish kerak"),
        answer = "to‘g‘ri",
        explanation = "To be dan keyin — to‘g‘ri."
    ),
    Question.Choice(
        section = "4-mashq • Oddiy fe’lmi yoki To Be?",
        prompt = "«They play often football.» — ravish to‘g‘ri joylashganmi?",
        options = listOf("to‘g‘ri", "tuzatish kerak"),
        answer = "tuzatish kerak",
        explanation = "Ravish fe’ldan oldin keladi: They often play football."
    ),
    Question.Choice(
        section = "4-mashq • Oddiy fe’lmi yoki To Be?",
        prompt = "«We never are tired.» — ravish to‘g‘ri joylashganmi?",
        options = listOf("to‘g‘ri", "tuzatish kerak"),
        answer = "tuzatish kerak",
        explanation = "To be bilan: We are never tired."
    ),
    Question.Choice(
        section = "4-mashq • Oddiy fe’lmi yoki To Be?",
        prompt = "«Sara sometimes reads at night.» — ravish to‘g‘ri joylashganmi?",
        options = listOf("to‘g‘ri", "tuzatish kerak"),
        answer = "to‘g‘ri",
        explanation = "Oddiy fe’ldan oldin — to‘g‘ri."
    ),
    Question.Text(
        section = "5-mashq • Vaqt iborasini gap oxiriga qo‘ying",
        prompt = "I call my aunt. (once a week) — gapni to‘ldiring.",
        answers = setOf("I call my aunt once a week."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri gap: I call my aunt once a week."
    ),
    Question.Text(
        section = "5-mashq • Vaqt iborasini gap oxiriga qo‘ying",
        prompt = "We play football. (on Fridays) — gapni to‘ldiring.",
        answers = setOf("We play football on Fridays."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri gap: We play football on Fridays."
    ),
    Question.Text(
        section = "5-mashq • Vaqt iborasini gap oxiriga qo‘ying",
        prompt = "He visits the library. (every month) — gapni to‘ldiring.",
        answers = setOf("He visits the library every month."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri gap: He visits the library every month."
    ),
    Question.Ordering(
        section = "6-mashq • O‘zbekchadan inglizchaga",
        prompt = "«Men odatda ertalab choy ichaman.» — gapni tuzing.",
        words = listOf("I", "usually", "drink", "tea", "in the morning"),
        answer = "I usually drink tea in the morning.",
        explanation = "To‘g‘ri javob: I usually drink tea in the morning."
    ),
    Question.Ordering(
        section = "6-mashq • O‘zbekchadan inglizchaga",
        prompt = "«U (qiz) ba’zan kitob o‘qiydi.» — gapni tuzing.",
        words = listOf("She", "sometimes", "reads", "books"),
        answer = "She sometimes reads books.",
        explanation = "To‘g‘ri javob: She sometimes reads books."
    ),
    Question.Ordering(
        section = "6-mashq • O‘zbekchadan inglizchaga",
        prompt = "«Biz hech qachon kechikmaymiz.» — gapni tuzing.",
        words = listOf("We", "are", "never", "late"),
        answer = "We are never late.",
        explanation = "To‘g‘ri javob: We are never late."
    ),
    Question.Ordering(
        section = "6-mashq • O‘zbekchadan inglizchaga",
        prompt = "«Ular tez-tez parkda bo‘ladi.» — gapni tuzing.",
        words = listOf("They", "are", "often", "in the park"),
        answer = "They are often in the park.",
        explanation = "To‘g‘ri javob: They are often in the park."
    )
)