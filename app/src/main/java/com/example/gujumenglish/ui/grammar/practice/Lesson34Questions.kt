package com.example.gujumenglish.ui.grammar.practice

internal val lesson34Questions: List<Question> = listOf(
    Question.Text(
        section = "1-mashq • To Be yoki Do/Does?",
        prompt = "Why ___ you happy? (are / do)",
        answers = setOf("are"),
        explanation = "To be bilan savol: are."
    ),
    Question.Text(
        section = "1-mashq • To Be yoki Do/Does?",
        prompt = "Why ___ he walk to school? (is / does)",
        answers = setOf("does"),
        explanation = "Harakat fe’li: does."
    ),
    Question.Text(
        section = "1-mashq • To Be yoki Do/Does?",
        prompt = "Why ___ the children at home? (are / do)",
        answers = setOf("are"),
        explanation = "To be bilan savol: are."
    ),
    Question.Text(
        section = "1-mashq • To Be yoki Do/Does?",
        prompt = "Why ___ Sara learn English? (does / is)",
        answers = setOf("does"),
        explanation = "Harakat fe’li: does."
    ),
    Question.Text(
        section = "1-mashq • To Be yoki Do/Does?",
        prompt = "Why ___ I late? (am / do)",
        answers = setOf("am"),
        explanation = "To be bilan I: am."
    ),
    Question.Ordering(
        section = "2-mashq • So‘zlardan Why savoli tuzing",
        prompt = "are / why / you / sad / ? — savolni tuzing.",
        words = listOf("are", "why", "you", "sad?"),
        answer = "Why are you sad?",
        explanation = "To‘g‘ri savol: Why are you sad?"
    ),
    Question.Ordering(
        section = "2-mashq • So‘zlardan Why savoli tuzing",
        prompt = "she / why / does / work / at night / ? — savolni tuzing.",
        words = listOf("she", "why", "does", "work", "at night?"),
        answer = "Why does she work at night?",
        explanation = "To‘g‘ri savol: Why does she work at night?"
    ),
    Question.Ordering(
        section = "2-mashq • So‘zlardan Why savoli tuzing",
        prompt = "they / why / are / late / ? — savolni tuzing.",
        words = listOf("they", "why", "are", "late?"),
        answer = "Why are they late?",
        explanation = "To‘g‘ri savol: Why are they late?"
    ),
    Question.Ordering(
        section = "2-mashq • So‘zlardan Why savoli tuzing",
        prompt = "does / why / he / study / English / ? — savolni tuzing.",
        words = listOf("he", "why", "does", "study", "English?"),
        answer = "Why does he study English?",
        explanation = "To‘g‘ri savol: Why does he study English?"
    ),
    Question.Text(
        section = "3-mashq • Because bilan sababni ulang",
        prompt = "Why are you happy? (it is my birthday) — javob bering.",
        answers = setOf("Because it is my birthday."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: Because it is my birthday."
    ),
    Question.Text(
        section = "3-mashq • Because bilan sababni ulang",
        prompt = "Why does he walk? (he likes walking) — javob bering.",
        answers = setOf("Because he likes walking."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: Because he likes walking."
    ),
    Question.Text(
        section = "3-mashq • Because bilan sababni ulang",
        prompt = "Why are they at home? (they are sick) — javob bering.",
        answers = setOf("Because they are sick."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: Because they are sick."
    ),
    Question.Text(
        section = "3-mashq • Because bilan sababni ulang",
        prompt = "Why do you study English? (I need it for work) — javob bering.",
        answers = setOf("Because I need it for work."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: Because I need it for work."
    ),
    Question.Choice(
        section = "4-mashq • What yoki Why?",
        prompt = "___ do you eat for breakfast? — Eggs.",
        options = listOf("What", "Why"),
        answer = "What",
        explanation = "Taom haqida: What."
    ),
    Question.Choice(
        section = "4-mashq • What yoki Why?",
        prompt = "___ do you eat breakfast early? — Because I go to work.",
        options = listOf("What", "Why"),
        answer = "Why",
        explanation = "Sabab haqida: Why."
    ),
    Question.Choice(
        section = "4-mashq • What yoki Why?",
        prompt = "___ is in the bag? — My book.",
        options = listOf("What", "Why"),
        answer = "What",
        explanation = "Narsa haqida: What."
    ),
    Question.Choice(
        section = "4-mashq • What yoki Why?",
        prompt = "___ is she at home? — Because she is sick.",
        options = listOf("What", "Why"),
        answer = "Why",
        explanation = "Sabab haqida: Why."
    ),
    Question.Text(
        section = "5-mashq • Fe’l shaklini tuzating",
        prompt = "Xatoni tuzating: «Why does he likes tea?»",
        answers = setOf("Why does he like tea?"),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: Why does he like tea?"
    ),
    Question.Text(
        section = "5-mashq • Fe’l shaklini tuzating",
        prompt = "Xatoni tuzating: «Why they are tired?»",
        answers = setOf("Why are they tired?"),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: Why are they tired?"
    ),
    Question.Text(
        section = "5-mashq • Fe’l shaklini tuzating",
        prompt = "Xatoni tuzating: «Why does Sara studies at night?»",
        answers = setOf("Why does Sara study at night?"),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: Why does Sara study at night?"
    ),
    Question.Text(
        section = "5-mashq • Fe’l shaklini tuzating",
        prompt = "Xatoni tuzating: «Why do you are here?»",
        answers = setOf("Why are you here?"),
        mode = TextMode.SENTENCE,
        explanation = "To be bilan: Why are you here?"
    ),
    Question.Choice(
        section = "6-mashq • Sababni o‘zingiz ayting",
        prompt = "Why are you learning English? — qanday javob berasiz?",
        options = listOf("Because ...", "What ...", "Where ..."),
        answer = "Because ...",
        explanation = "Sabab chunki beriladi: Because ..."
    ),
    Question.Choice(
        section = "6-mashq • Sababni o‘zingiz ayting",
        prompt = "Why do you get up in the morning? — qanday javob berasiz?",
        options = listOf("Because ...", "When ..."),
        answer = "Because ...",
        explanation = "Sabab chunki beriladi: Because ..."
    )
)