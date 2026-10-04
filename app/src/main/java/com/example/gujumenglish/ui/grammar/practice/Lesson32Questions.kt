package com.example.gujumenglish.ui.grammar.practice

internal val lesson32Questions: List<Question> = listOf(
    Question.Choice(
        section = "1-mashq • Who yoki What?",
        prompt = "___ is that woman? (odam)",
        options = listOf("Who", "What"),
        answer = "Who",
        explanation = "Odam haqida: Who."
    ),
    Question.Choice(
        section = "1-mashq • Who yoki What?",
        prompt = "___ is in the box? (narsa)",
        options = listOf("Who", "What"),
        answer = "What",
        explanation = "Narsa haqida: What."
    ),
    Question.Choice(
        section = "1-mashq • Who yoki What?",
        prompt = "___ is your doctor? (odam)",
        options = listOf("Who", "What"),
        answer = "Who",
        explanation = "Odam haqida: Who."
    ),
    Question.Choice(
        section = "1-mashq • Who yoki What?",
        prompt = "___ do you eat for lunch? (narsa/taom)",
        options = listOf("Who", "What"),
        answer = "What",
        explanation = "Taom haqida: What."
    ),
    Question.Text(
        section = "2-mashq • Who is yoki Who are?",
        prompt = "Who ___ your English teacher?",
        answers = setOf("is"),
        explanation = "Bitta ega: is."
    ),
    Question.Text(
        section = "2-mashq • Who is yoki Who are?",
        prompt = "Who ___ those people?",
        answers = setOf("are"),
        explanation = "Ko‘plik: are."
    ),
    Question.Text(
        section = "2-mashq • Who is yoki Who are?",
        prompt = "Who ___ she?",
        answers = setOf("is"),
        explanation = "Bitta ega: is."
    ),
    Question.Text(
        section = "2-mashq • Who is yoki Who are?",
        prompt = "Who ___ your friends?",
        answers = setOf("are"),
        explanation = "Ko‘plik: are."
    ),
    Question.Choice(
        section = "3-mashq • Who gapning egasimi yoki objectmi?",
        prompt = "«Who calls you?» — kim qo‘ng‘iroq qilyapti?",
        options = listOf("Who — ega (subject)", "Who — object"),
        answer = "Who — ega (subject)",
        explanation = "Kim qo‘ng‘iroq qilayotgani — subject, do/does kerak emas."
    ),
    Question.Choice(
        section = "3-mashq • Who gapning egasimi yoki objectmi?",
        prompt = "«Who do you call?» — siz kimga qo‘ng‘iroq qilasiz?",
        options = listOf("Who — ega (subject)", "Who — object"),
        answer = "Who — object",
        explanation = "Siz qo‘ng‘iroq qilayotgan odam — object: do kerak."
    ),
    Question.Choice(
        section = "3-mashq • Who gapning egasimi yoki objectmi?",
        prompt = "«Who works at the shop?» — kim ishlaydi?",
        options = listOf("Who — ega (subject)", "Who — object"),
        answer = "Who — ega (subject)",
        explanation = "Ishni bajaruvchi — subject, do/does kerak emas."
    ),
    Question.Choice(
        section = "3-mashq • Who gapning egasimi yoki objectmi?",
        prompt = "«Who does Anna visit?» — Anna kimni ziyorat qiladi?",
        options = listOf("Who — ega (subject)", "Who — object"),
        answer = "Who — object",
        explanation = "Ziyorat qilinadigan odam — object: does kerak."
    ),
    Question.Text(
        section = "4-mashq • Do, Does yoki bo‘sh joy?",
        prompt = "Who ___ you help?",
        answers = setOf("do"),
        explanation = "Who — object: do."
    ),
    Question.Text(
        section = "4-mashq • Do, Does yoki bo‘sh joy?",
        prompt = "Who ___ lives next door?",
        answers = setOf(""),
        explanation = "Who — subject, yordamchi fe’l kerak emas."
    ),
    Question.Text(
        section = "4-mashq • Do, Does yoki bo‘sh joy?",
        prompt = "Who ___ he visit?",
        answers = setOf("does"),
        explanation = "Who — object, bitta ega: does."
    ),
    Question.Text(
        section = "4-mashq • Do, Does yoki bo‘sh joy?",
        prompt = "Who ___ wants some tea?",
        answers = setOf(""),
        explanation = "Who — subject: yordamchi fe’l kerak emas."
    ),
    Question.Text(
        section = "4-mashq • Do, Does yoki bo‘sh joy?",
        prompt = "Who ___ they call?",
        answers = setOf("do"),
        explanation = "Who — object, ko‘plik: do."
    ),
    Question.Ordering(
        section = "5-mashq • So‘zlarni tartibga soling",
        prompt = "your teacher / who / is / ? — savolni tuzing.",
        words = listOf("your teacher", "who", "is?"),
        answer = "Who is your teacher?",
        explanation = "To‘g‘ri savol: Who is your teacher?"
    ),
    Question.Ordering(
        section = "5-mashq • So‘zlarni tartibga soling",
        prompt = "who / here / works / ? — savolni tuzing.",
        words = listOf("who", "here", "works?"),
        answer = "Who works here?",
        explanation = "To‘g‘ri savol: Who works here?"
    ),
    Question.Ordering(
        section = "5-mashq • So‘zlarni tartibga soling",
        prompt = "does / who / she / call / ? — savolni tuzing.",
        words = listOf("does", "who", "she", "call?"),
        answer = "Who does she call?",
        explanation = "To‘g‘ri savol: Who does she call?"
    ),
    Question.Ordering(
        section = "5-mashq • So‘zlarni tartibga soling",
        prompt = "who / they / visit / do / ? — savolni tuzing.",
        words = listOf("who", "they", "visit", "do?"),
        answer = "Who do they visit?",
        explanation = "To‘g‘ri savol: Who do they visit?"
    ),
    Question.Choice(
        section = "6-mashq • Javobdan savol tuzing",
        prompt = "Javob: He is my brother. — Savolni tanlang.",
        options = listOf("Who is he?", "What is he?"),
        answer = "Who is he?",
        explanation = "Odam haqida: Who."
    ),
    Question.Choice(
        section = "6-mashq • Javobdan savol tuzing",
        prompt = "Javob: I visit my grandmother. — Savolni tanlang.",
        options = listOf("Who do you visit?", "What do you visit?"),
        answer = "Who do you visit?",
        explanation = "Odamni ziyorat qilish: Who."
    ),
    Question.Choice(
        section = "6-mashq • Javobdan savol tuzing",
        prompt = "Javob: Sara works here. — Savolni tanlang.",
        options = listOf("Who works here?", "What works here?"),
        answer = "Who works here?",
        explanation = "Ishlayotgan odam: Who."
    )
)