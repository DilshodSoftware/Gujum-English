package com.example.gujumenglish.ui.grammar.practice

internal val lesson62Questions: List<Question> = listOf(
    Question.Text(
        section = "1-mashq • And, But yoki Or?",
        prompt = "I like tea ___ coffee. (ikkalasi)",
        answers = setOf("and"),
        explanation = "Ma’lumot qo‘shish: and."
    ),
    Question.Text(
        section = "1-mashq • And, But yoki Or?",
        prompt = "The bag is small ___ heavy. (qarama-qarshi)",
        answers = setOf("but"),
        explanation = "Qarama-qarshilik: but."
    ),
    Question.Text(
        section = "1-mashq • And, But yoki Or?",
        prompt = "Would you like milk ___ juice? (tanlov)",
        answers = setOf("or"),
        explanation = "Tanlov: or."
    ),
    Question.Text(
        section = "1-mashq • And, But yoki Or?",
        prompt = "My brother can sing ___ dance. (ikkalasi)",
        answers = setOf("and"),
        explanation = "Ma’lumot qo‘shish: and."
    ),
    Question.Text(
        section = "1-mashq • And, But yoki Or?",
        prompt = "It is cold ___ sunny today. (qarama-qarshi)",
        answers = setOf("but"),
        explanation = "Qarama-qarshilik: but."
    ),
    Question.Choice(
        section = "2-mashq • Gapning ma’nosini belgilang",
        prompt = "She is young but very wise.",
        options = listOf("qo‘shish", "qarama-qarshilik", "tanlov"),
        answer = "qarama-qarshilik",
        explanation = "but bilan qarama-qarshilik ifodalanadi."
    ),
    Question.Choice(
        section = "2-mashq • Gapning ma’nosini belgilang",
        prompt = "We can walk or take a bus.",
        options = listOf("qo‘shish", "qarama-qarshilik", "tanlov"),
        answer = "tanlov",
        explanation = "or bilan tanlov ifodalanadi."
    ),
    Question.Choice(
        section = "2-mashq • Gapning ma’nosini belgilang",
        prompt = "Ali and Sara are classmates.",
        options = listOf("qo‘shish", "qarama-qarshilik", "tanlov"),
        answer = "qo‘shish",
        explanation = "and bilan qo‘shish ifodalanadi."
    ),
    Question.Text(
        section = "3-mashq • Ikki gapni birlashtiring",
        prompt = "I like apples. I like bananas. (and) — birlashtiring.",
        answers = setOf("I like apples and bananas."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: I like apples and bananas."
    ),
    Question.Text(
        section = "3-mashq • Ikki gapni birlashtiring",
        prompt = "The room is small. It is clean. (but) — birlashtiring.",
        answers = setOf("The room is small but clean."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: The room is small but clean."
    ),
    Question.Text(
        section = "3-mashq • Ikki gapni birlashtiring",
        prompt = "We can eat at home. We can eat at a café. (or) — birlashtiring.",
        answers = setOf("We can eat at home or at a café."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: We can eat at home or at a café."
    ),
    Question.Text(
        section = "3-mashq • Ikki gapni birlashtiring",
        prompt = "Tom can swim. Tom can ride a bike. (and) — birlashtiring.",
        answers = setOf("Tom can swim and ride a bike."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: Tom can swim and ride a bike."
    ),
    Question.Text(
        section = "4-mashq • Bo‘sh joyni to‘ldiring",
        prompt = "I have a sister ___ a brother.",
        answers = setOf("and"),
        explanation = "Qo‘shish: and."
    ),
    Question.Text(
        section = "4-mashq • Bo‘sh joyni to‘ldiring",
        prompt = "He is tired, ___ he is not sleepy.",
        answers = setOf("but"),
        explanation = "Qarama-qarshilik: but."
    ),
    Question.Text(
        section = "4-mashq • Bo‘sh joyni to‘ldiring",
        prompt = "Do you want the red pen ___ the blue pen?",
        answers = setOf("or"),
        explanation = "Tanlov: or."
    ),
    Question.Text(
        section = "5-mashq • Xatoni yoki noo‘rin bog‘lovchini tuzating",
        prompt = "«I like apples or bananas.» — ikkalasini ham yoqtiraman.",
        answers = setOf("I like apples and bananas."),
        mode = TextMode.SENTENCE,
        explanation = "Ikkalasini ham yoqtirish: and."
    ),
    Question.Text(
        section = "5-mashq • Xatoni yoki noo‘rin bog‘lovchini tuzating",
        prompt = "«Do you want tea but coffee?» — tanlov.",
        answers = setOf("Do you want tea or coffee?"),
        mode = TextMode.SENTENCE,
        explanation = "Tanlov: or."
    ),
    Question.Text(
        section = "5-mashq • Xatoni yoki noo‘rin bog‘lovchini tuzating",
        prompt = "«The house is big and expensive, but it has a large garden.» — qo‘shimcha fikr.",
        answers = setOf("The house is big and expensive, and it has a large garden."),
        mode = TextMode.SENTENCE,
        explanation = "Qo‘shimcha fikr uchun and."
    ),
    Question.Ordering(
        section = "6-mashq • O‘zingizdan misol yozing",
        prompt = "And bilan bitta gap yozing.",
        words = listOf("I like", "apples and", "oranges."),
        answer = "I like apples and oranges.",
        explanation = "Namunaviy javob: I like apples and oranges."
    ),
    Question.Ordering(
        section = "6-mashq • O‘zingizdan misol yozing",
        prompt = "But bilan bitta gap yozing.",
        words = listOf("It is", "old but", "comfortable."),
        answer = "It is old but comfortable.",
        explanation = "Namunaviy javob: It is old but comfortable."
    ),
    Question.Ordering(
        section = "6-mashq • O‘zingizdan misol yozing",
        prompt = "Or bilan bitta savol yozing.",
        words = listOf("Do you want", "tea or", "coffee?"),
        answer = "Do you want tea or coffee?",
        explanation = "Namunaviy javob: Do you want tea or coffee?"
    )
)