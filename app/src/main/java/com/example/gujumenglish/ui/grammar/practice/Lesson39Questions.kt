package com.example.gujumenglish.ui.grammar.practice

internal val lesson39Questions: List<Question> = listOf(
    Question.Text(
        section = "1-mashq • Can yoki Can’t?",
        prompt = "A bird ___ fly.",
        answers = setOf("can"),
        explanation = "Qush uchadi: can."
    ),
    Question.Text(
        section = "1-mashq • Can yoki Can’t?",
        prompt = "A fish ___ climb a tree.",
        answers = setOf("can’t"),
        explanation = "Baliq daraxtga chiqmaydi: can’t."
    ),
    Question.Text(
        section = "1-mashq • Can yoki Can’t?",
        prompt = "A baby ___ speak three languages.",
        answers = setOf("can’t"),
        explanation = "Chaqaloq uch til bilmaydi: can’t."
    ),
    Question.Text(
        section = "1-mashq • Can yoki Can’t?",
        prompt = "A horse ___ run.",
        answers = setOf("can"),
        explanation = "Ot yug‘uradi: can."
    ),
    Question.Text(
        section = "1-mashq • Can yoki Can’t?",
        prompt = "A person with no wings ___ fly like a bird.",
        answers = setOf("can’t"),
        explanation = "Qanot yo‘q odam qushdek uchmaydi: can’t."
    ),
    Question.Text(
        section = "2-mashq • Fe’lni to‘g‘ri shaklda yozing",
        prompt = "He can ___ (swim).",
        answers = setOf("swim"),
        explanation = "Can dan keyin oddiy shakl: swim."
    ),
    Question.Text(
        section = "2-mashq • Fe’lni to‘g‘ri shaklda yozing",
        prompt = "They can ___ (speak) English.",
        answers = setOf("speak"),
        explanation = "Can dan keyin oddiy shakl: speak."
    ),
    Question.Text(
        section = "2-mashq • Fe’lni to‘g‘ri shaklda yozing",
        prompt = "My sister can ___ (cook).",
        answers = setOf("cook"),
        explanation = "Can dan keyin oddiy shakl: cook."
    ),
    Question.Text(
        section = "2-mashq • Fe’lni to‘g‘ri shaklda yozing",
        prompt = "I can ___ (ride) a bike.",
        answers = setOf("ride"),
        explanation = "Can dan keyin oddiy shakl: ride."
    ),
    Question.Text(
        section = "2-mashq • Fe’lni to‘g‘ri shaklda yozing",
        prompt = "A cat can ___ (climb) a tree.",
        answers = setOf("climb"),
        explanation = "Can dan keyin oddiy shakl: climb."
    ),
    Question.Text(
        section = "3-mashq • Gaplarni inkor shakliga o‘tkazing",
        prompt = "I can drive. — inkor shaklini yozing.",
        answers = setOf("I can’t drive."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: I can’t drive."
    ),
    Question.Text(
        section = "3-mashq • Gaplarni inkor shakliga o‘tkazing",
        prompt = "She can sing. — inkor shaklini yozing.",
        answers = setOf("She can’t sing."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: She can’t sing."
    ),
    Question.Text(
        section = "3-mashq • Gaplarni inkor shakliga o‘tkazing",
        prompt = "They can come today. — inkor shaklini yozing.",
        answers = setOf("They can’t come today."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: They can’t come today."
    ),
    Question.Text(
        section = "3-mashq • Gaplarni inkor shakliga o‘tkazing",
        prompt = "A baby can read. — inkor shaklini yozing.",
        answers = setOf("A baby can’t read."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: A baby can’t read."
    ),
    Question.Choice(
        section = "4-mashq • To‘g‘ri gapni tanlang",
        prompt = "Qaysi gap to‘g‘ri?",
        options = listOf("She can dances.", "She can dance."),
        answer = "She can dance.",
        explanation = "Can dan keyin oddiy shakl: dance."
    ),
    Question.Choice(
        section = "4-mashq • To‘g‘ri gapni tanlang",
        prompt = "Qaysi gap to‘g‘ri?",
        options = listOf("He cans cook.", "He can cook."),
        answer = "He can cook.",
        explanation = "Can ga -s qo‘shilmaydi."
    ),
    Question.Choice(
        section = "4-mashq • To‘g‘ri gapni tanlang",
        prompt = "Qaysi gap to‘g‘ri?",
        options = listOf("We can to help.", "We can help."),
        answer = "We can help.",
        explanation = "Can dan keyin to qo‘shilmaydi."
    ),
    Question.Choice(
        section = "4-mashq • To‘g‘ri gapni tanlang",
        prompt = "Qaysi gap to‘g‘ri?",
        options = listOf("They can’t swim.", "They don’t can swim."),
        answer = "They can’t swim.",
        explanation = "Inkor shakli: can’t."
    ),
    Question.Matching(
        section = "5-mashq • Qobiliyat va harakatni juftlang",
        prompt = "Har bir gapni to‘g‘ri tarjimasi bilan bog‘lang.",
        pairs = listOf(
            "I can draw." to "B. Men rasm chiza olaman.",
            "He can swim." to "A. U suza oladi.",
            "We can speak English." to "C. Biz inglizcha gapira olamiz."
        ),
        options = listOf(
            "A. U suza oladi.",
            "B. Men rasm chiza olaman.",
            "C. Biz inglizcha gapira olamiz."
        ),
        explanation = "1—B; 2—A; 3—C."
    ),
    Question.Choice(
        section = "6-mashq • O‘zingiz haqingizda gapiring",
        prompt = "Qila olasiz — qaysi shaklda yozasiz?",
        options = listOf("I can ...", "I can’t ..."),
        answer = "I can ...",
        explanation = "Masalan: I can cook."
    ),
    Question.Choice(
        section = "6-mashq • O‘zingiz haqingizda gapiring",
        prompt = "Qila olmaysiz — qaysi shaklda yozasiz?",
        options = listOf("I can ...", "I can’t ..."),
        answer = "I can’t ...",
        explanation = "Masalan: I can’t drive a bus."
    ),
    Question.TrueFalse(
        section = "6-mashq • O‘zingiz haqingizda gapiring",
        prompt = "Can barcha egalar bilan bir xil ishlatiladi: he, she, they uchun ham can.",
        answer = true,
        explanation = "Bu gap to‘g‘ri: can he/she/it/they uchun o‘zgarmaydi."
    )
)