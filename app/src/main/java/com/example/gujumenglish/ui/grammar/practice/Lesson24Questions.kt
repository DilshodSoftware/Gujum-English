package com.example.gujumenglish.ui.grammar.practice

internal val lesson24Questions: List<Question> = listOf(
    Question.Text(
        section = "1-mashq • Do yoki Does?",
        prompt = "___ your friends speak English?",
        answers = setOf("Do"),
        explanation = "Ko‘plik bilan do."
    ),
    Question.Text(
        section = "1-mashq • Do yoki Does?",
        prompt = "___ your mother drive?",
        answers = setOf("Does"),
        explanation = "Bitta ayol bilan does."
    ),
    Question.Text(
        section = "1-mashq • Do yoki Does?",
        prompt = "___ we start now?",
        answers = setOf("Do"),
        explanation = "We bilan do."
    ),
    Question.Text(
        section = "1-mashq • Do yoki Does?",
        prompt = "___ this bus go to the station?",
        answers = setOf("Does"),
        explanation = "Bitta narsa bilan does."
    ),
    Question.Text(
        section = "1-mashq • Do yoki Does?",
        prompt = "___ I need a coat?",
        answers = setOf("Do"),
        explanation = "I bilan do."
    ),
    Question.Ordering(
        section = "2-mashq • So‘zlarni savol tartibiga keltiring",
        prompt = "you / do / live / where / ? — savolni tuzing.",
        words = listOf("you", "do", "live", "where?"),
        answer = "Where do you live?",
        explanation = "Savol so‘zi boshda: Where do you live?"
    ),
    Question.Ordering(
        section = "2-mashq • So‘zlarni savol tartibiga keltiring",
        prompt = "does / what / she / cook / ? — savolni tuzing.",
        words = listOf("she", "does", "cook", "what?"),
        answer = "What does she cook?",
        explanation = "Savol so‘zi boshda: What does she cook?"
    ),
    Question.Ordering(
        section = "2-mashq • So‘zlarni savol tartibiga keltiring",
        prompt = "they / when / do / study / ? — savolni tuzing.",
        words = listOf("they", "when", "do", "study?"),
        answer = "When do they study?",
        explanation = "Savol so‘zi boshda: When do they study?"
    ),
    Question.Ordering(
        section = "2-mashq • So‘zlarni savol tartibiga keltiring",
        prompt = "why / he / does / run / ? — savolni tuzing.",
        words = listOf("he", "why", "does", "run?"),
        answer = "Why does he run?",
        explanation = "Savol so‘zi boshda: Why does he run?"
    ),
    Question.Ordering(
        section = "2-mashq • So‘zlarni savol tartibiga keltiring",
        prompt = "do / your friends / music / like / ? — savolni tuzing.",
        words = listOf("do", "your friends", "music", "like?"),
        answer = "Do your friends like music?",
        explanation = "Savol so‘zi yo‘q: Do your friends like music?"
    ),
    Question.Text(
        section = "3-mashq • Savol so‘zini tanlang",
        prompt = "___ do you live? (joy)",
        answers = setOf("Where"),
        explanation = "Joy haqida: Where."
    ),
    Question.Text(
        section = "3-mashq • Savol so‘zini tanlang",
        prompt = "___ does he have for breakfast? (narsa)",
        answers = setOf("What"),
        explanation = "Narsa haqida: What."
    ),
    Question.Text(
        section = "3-mashq • Savol so‘zini tanlang",
        prompt = "___ do you go to bed? (vaqt)",
        answers = setOf("When"),
        explanation = "Vaqt haqida: When."
    ),
    Question.Text(
        section = "3-mashq • Savol so‘zini tanlang",
        prompt = "___ does Sara walk to school? (sabab)",
        answers = setOf("Why"),
        explanation = "Sabab haqida: Why."
    ),
    Question.Text(
        section = "3-mashq • Savol so‘zini tanlang",
        prompt = "___ do they travel? (usul)",
        answers = setOf("How"),
        explanation = "Usul haqida: How."
    ),
    Question.Choice(
        section = "4-mashq • Oddiy fe’lmi yoki To Be?",
        prompt = "___ you tired?",
        options = listOf("Are", "Do"),
        answer = "Are",
        explanation = "To be bilan savol: Are you tired?"
    ),
    Question.Choice(
        section = "4-mashq • Oddiy fe’lmi yoki To Be?",
        prompt = "___ you like apples?",
        options = listOf("Are", "Do"),
        answer = "Do",
        explanation = "Oddiy fe’l bilan savol: Do you like apples?"
    ),
    Question.Choice(
        section = "4-mashq • Oddiy fe’lmi yoki To Be?",
        prompt = "Where ___ she?",
        options = listOf("is", "does"),
        answer = "is",
        explanation = "To be bilan: Where is she?"
    ),
    Question.Choice(
        section = "4-mashq • Oddiy fe’lmi yoki To Be?",
        prompt = "Where ___ she work?",
        options = listOf("is", "does"),
        answer = "does",
        explanation = "Oddiy fe’l bilan: Where does she work?"
    ),
    Question.Choice(
        section = "4-mashq • Oddiy fe’lmi yoki To Be?",
        prompt = "___ Ali a student?",
        options = listOf("Does", "Is"),
        answer = "Is",
        explanation = "To be bilan savol: Is Ali a student?"
    ),
    Question.Ordering(
        section = "5-mashq • Gapni savolga aylantiring",
        prompt = "They play chess. (ha/yo‘q savoli) — savolni tuzing.",
        words = listOf("Do", "they", "chess", "play"),
        answer = "Do they play chess?",
        explanation = "To‘g‘ri savol: Do they play chess?"
    ),
    Question.Ordering(
        section = "5-mashq • Gapni savolga aylantiring",
        prompt = "He works at a bank. (qayerda?) — savolni tuzing.",
        words = listOf("Where", "does", "he", "work"),
        answer = "Where does he work?",
        explanation = "To‘g‘ri savol: Where does he work?"
    ),
    Question.Ordering(
        section = "5-mashq • Gapni savolga aylantiring",
        prompt = "You eat lunch at twelve. (qachon?) — savolni tuzing.",
        words = listOf("When", "do", "you", "lunch", "eat"),
        answer = "When do you eat lunch?",
        explanation = "To‘g‘ri savol: When do you eat lunch?"
    ),
    Question.Ordering(
        section = "5-mashq • Gapni savolga aylantiring",
        prompt = "She likes this song. (ha/yo‘q savoli) — savolni tuzing.",
        words = listOf("Does", "she", "this song", "like"),
        answer = "Does she like this song?",
        explanation = "To‘g‘ri savol: Does she like this song?"
    ),
    Question.Choice(
        section = "6-mashq • Savolga mos javob turini belgilang",
        prompt = "Where do you live? — javob qaysi turga kiradi?",
        options = listOf("joy", "vaqt"),
        answer = "joy",
        explanation = "Where — joy haqida savol."
    ),
    Question.Choice(
        section = "6-mashq • Savolga mos javob turini belgilang",
        prompt = "Who is your teacher? — javob qaysi turga kiradi?",
        options = listOf("odam", "sabab"),
        answer = "odam",
        explanation = "Who — kim haqida savol."
    ),
    Question.Choice(
        section = "6-mashq • Savolga mos javob turini belgilang",
        prompt = "Why does he study? — javob qaysi turga kiradi?",
        options = listOf("sabab", "narsa"),
        answer = "sabab",
        explanation = "Why — nima uchun, sabab."
    ),
    Question.Choice(
        section = "6-mashq • Savolga mos javob turini belgilang",
        prompt = "Do you like tea? — javob qaysi turga kiradi?",
        options = listOf("ha/yo‘q", "joy"),
        answer = "ha/yo‘q",
        explanation = "Do — ha yoki yo‘q javobini talab qiladi."
    )
)