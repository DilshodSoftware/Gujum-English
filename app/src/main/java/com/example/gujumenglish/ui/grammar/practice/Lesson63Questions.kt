package com.example.gujumenglish.ui.grammar.practice

internal val lesson63Questions: List<Question> = listOf(
    Question.Text(
        section = "1-mashq • Because yoki So?",
        prompt = "I took a taxi ___ I was late. (sabab)",
        answers = setOf("because"),
        explanation = "Sabab because bilan keladi."
    ),
    Question.Text(
        section = "1-mashq • Because yoki So?",
        prompt = "It was cold, ___ we stayed inside. (natija)",
        answers = setOf("so"),
        explanation = "Natija so bilan keladi."
    ),
    Question.Text(
        section = "1-mashq • Because yoki So?",
        prompt = "She is smiling ___ she is happy. (sabab)",
        answers = setOf("because"),
        explanation = "Sabab because bilan keladi."
    ),
    Question.Text(
        section = "1-mashq • Because yoki So?",
        prompt = "He missed the bus, ___ he walked to work. (natija)",
        answers = setOf("so"),
        explanation = "Natija so bilan keladi."
    ),
    Question.Text(
        section = "1-mashq • Because yoki So?",
        prompt = "They went to bed early ___ they were tired. (sabab)",
        answers = setOf("because"),
        explanation = "Sabab because bilan keladi."
    ),
    Question.Choice(
        section = "2-mashq • Sabab va natijani ajrating",
        prompt = "«I was hungry, so I made a sandwich.» — qaysi qism sabab?",
        options = listOf("I was hungry", "I made a sandwich"),
        answer = "I was hungry",
        explanation = "Sabab: och edim; natija: sendvich tayyorladim."
    ),
    Question.Choice(
        section = "2-mashq • Sabab va natijani ajrating",
        prompt = "«We stayed home because it was raining.» — qaysi qism natija?",
        options = listOf("We stayed home", "it was raining"),
        answer = "We stayed home",
        explanation = "Sabab: yomg‘ir yog‘ayotgan edi; natija: uyda qoldik."
    ),
    Question.Choice(
        section = "2-mashq • Sabab va natijani ajrating",
        prompt = "«Because she was sick, she didn’t go to work.» — qaysi qism natija?",
        options = listOf("she was sick", "she didn’t go to work"),
        answer = "she didn’t go to work",
        explanation = "Sabab: kasal edi; natija: ishga bormadi."
    ),
    Question.Text(
        section = "3-mashq • Ikki gapni birlashtiring",
        prompt = "It was cold. I wore a coat. (so) — birlashtiring.",
        answers = setOf("It was cold, so I wore a coat."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: It was cold, so I wore a coat."
    ),
    Question.Text(
        section = "3-mashq • Ikki gapni birlashtiring",
        prompt = "I stayed home. I was tired. (because) — birlashtiring.",
        answers = setOf("I stayed home because I was tired."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: I stayed home because I was tired."
    ),
    Question.Text(
        section = "3-mashq • Ikki gapni birlashtiring",
        prompt = "The road was wet. We drove slowly. (so) — birlashtiring.",
        answers = setOf("The road was wet, so we drove slowly."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: The road was wet, so we drove slowly."
    ),
    Question.Text(
        section = "3-mashq • Ikki gapni birlashtiring",
        prompt = "He is happy. It is his birthday. (because) — birlashtiring.",
        answers = setOf("He is happy because it is his birthday."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: He is happy because it is his birthday."
    ),
    Question.Text(
        section = "4-mashq • Because bilan gapni boshidan boshlang",
        prompt = "I took an umbrella because it was raining. → Because… — qayta yozing.",
        answers = setOf("Because it was raining, I took an umbrella."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: Because it was raining, I took an umbrella."
    ),
    Question.Text(
        section = "4-mashq • Because bilan gapni boshidan boshlang",
        prompt = "She went to bed because she was tired. → Because… — qayta yozing.",
        answers = setOf("Because she was tired, she went to bed."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: Because she was tired, she went to bed."
    ),
    Question.Choice(
        section = "5-mashq • Ortiqcha bog‘lovchini olib tashlang",
        prompt = "«Because I was late, so I ran.» — qaysi bog‘lovchi ortiqcha?",
        options = listOf("because", "so"),
        answer = "so",
        explanation = "Ikkalasini birga ishlatib bo‘lmaydi."
    ),
    Question.Choice(
        section = "5-mashq • Ortiqcha bog‘lovchini olib tashlang",
        prompt = "«Because it was hot, so we drank water.» — qaysi bog‘lovchi ortiqcha?",
        options = listOf("because", "so"),
        answer = "so",
        explanation = "Ikkalasini birga ishlatib bo‘lmaydi."
    ),
    Question.Choice(
        section = "5-mashq • Ortiqcha bog‘lovchini olib tashlang",
        prompt = "«It was late, so we went home.» — bu gap to‘g‘rimi?",
        options = listOf("to‘g‘ri", "ortiqcha bog‘lovchi bor"),
        answer = "to‘g‘ri",
        explanation = "Faqat bitta bog‘lovchi ishlatilgan — to‘g‘ri."
    ),
    Question.Ordering(
        section = "6-mashq • O‘zingiz sabab-natija gap tuzing",
        prompt = "Because bilan bitta gap yozing.",
        words = listOf("I am happy", "because", "it is sunny."),
        answer = "I am happy because it is sunny.",
        explanation = "Namunaviy javob: I am happy because it is sunny."
    ),
    Question.Ordering(
        section = "6-mashq • O‘zingiz sabab-natija gap tuzing",
        prompt = "So bilan bitta gap yozing.",
        words = listOf("It is sunny,", "so", "we are going to the park."),
        answer = "It is sunny, so we are going to the park.",
        explanation = "Namunaviy javob: It is sunny, so we are going to the park."
    )
)