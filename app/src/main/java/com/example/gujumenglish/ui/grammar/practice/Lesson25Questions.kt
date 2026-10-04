package com.example.gujumenglish.ui.grammar.practice

internal val lesson25Questions: List<Question> = listOf(
    Question.Text(
        section = "1-mashq • Bo‘sh joyni to‘ldiring",
        prompt = "Do you like apples? (ha) — Yes, ___ ___.",
        answers = setOf("I do"),
        explanation = "You — I: Yes, I do."
    ),
    Question.Text(
        section = "1-mashq • Bo‘sh joyni to‘ldiring",
        prompt = "Does he work here? (yo‘q) — No, ___ ___.",
        answers = setOf("he doesn’t"),
        explanation = "Erkak — he: No, he doesn’t."
    ),
    Question.Text(
        section = "1-mashq • Bo‘sh joyni to‘ldiring",
        prompt = "Do they study English? (ha) — Yes, ___ ___.",
        answers = setOf("they do"),
        explanation = "Ko‘plik — they: Yes, they do."
    ),
    Question.Text(
        section = "1-mashq • Bo‘sh joyni to‘ldiring",
        prompt = "Does your sister drive? (yo‘q) — No, ___ ___.",
        answers = setOf("she doesn’t"),
        explanation = "Ayol — she: No, she doesn’t."
    ),
    Question.Text(
        section = "1-mashq • Bo‘sh joyni to‘ldiring",
        prompt = "Are you tired? (ha) — Yes, ___ ___.",
        answers = setOf("I am"),
        explanation = "To be bilan: Yes, I am."
    ),
    Question.Text(
        section = "1-mashq • Bo‘sh joyni to‘ldiring",
        prompt = "Is the shop open? (yo‘q) — No, ___ ___.",
        answers = setOf("it isn’t"),
        explanation = "To be bilan: No, it isn’t."
    ),
    Question.Text(
        section = "2-mashq • Savoldagi egani javobga moslang",
        prompt = "Do you live here? — o‘zingiz ha deb javob bering.",
        answers = setOf("Yes, I do."),
        mode = TextMode.SENTENCE,
        explanation = "You — I: Yes, I do."
    ),
    Question.Text(
        section = "2-mashq • Savoldagi egani javobga moslang",
        prompt = "Does Ali play football? — Ali haqida ha deb javob bering.",
        answers = setOf("Yes, he does."),
        mode = TextMode.SENTENCE,
        explanation = "Ali — erkak: Yes, he does."
    ),
    Question.Text(
        section = "2-mashq • Savoldagi egani javobga moslang",
        prompt = "Do Ali and Sam work together? — ular haqida ha deb javob bering.",
        answers = setOf("Yes, they do."),
        mode = TextMode.SENTENCE,
        explanation = "Ko‘plik — they: Yes, they do."
    ),
    Question.Text(
        section = "2-mashq • Savoldagi egani javobga moslang",
        prompt = "Does the cat sleep outside? — mushuk haqida ha deb javob bering.",
        answers = setOf("Yes, it does."),
        mode = TextMode.SENTENCE,
        explanation = "Narsa — it: Yes, it does."
    ),
    Question.Choice(
        section = "3-mashq • Qisqami yoki to‘liq javobmi?",
        prompt = "«Yes, I do.» — qanaqa javob?",
        options = listOf("qisqa", "to‘liq"),
        answer = "qisqa",
        explanation = "Faqat yordamchi fe’l takrorlangan — qisqa javob."
    ),
    Question.Choice(
        section = "3-mashq • Qisqami yoki to‘liq javobmi?",
        prompt = "«No, she doesn’t work at night.» — qanaqa javob?",
        options = listOf("qisqa", "to‘liq"),
        answer = "to‘liq",
        explanation = "Butun gap takrorlangan — to‘liq javob."
    ),
    Question.Choice(
        section = "3-mashq • Qisqami yoki to‘liq javobmi?",
        prompt = "«Yes, they are.» — qanaqa javob?",
        options = listOf("qisqa", "to‘liq"),
        answer = "qisqa",
        explanation = "Faqat yordamchi fe’l — qisqa javob."
    ),
    Question.Choice(
        section = "3-mashq • Qisqami yoki to‘liq javobmi?",
        prompt = "«No, he doesn’t.» — qanaqa javob?",
        options = listOf("qisqa", "to‘liq"),
        answer = "qisqa",
        explanation = "Faqat yordamchi fe’l — qisqa javob."
    ),
    Question.Text(
        section = "4-mashq • Do/Doesmi yoki Am/Is/Are?",
        prompt = "Do you play chess? — Yes, I ___.",
        answers = setOf("do"),
        explanation = "Do savoliga do bilan javob."
    ),
    Question.Text(
        section = "4-mashq • Do/Doesmi yoki Am/Is/Are?",
        prompt = "Are you a student? — Yes, I ___.",
        answers = setOf("am"),
        explanation = "To be savoliga am bilan javob."
    ),
    Question.Text(
        section = "4-mashq • Do/Doesmi yoki Am/Is/Are?",
        prompt = "Does she like tea? — No, she ___.",
        answers = setOf("doesn’t"),
        explanation = "Does savoliga doesn’t bilan javob."
    ),
    Question.Text(
        section = "4-mashq • Do/Doesmi yoki Am/Is/Are?",
        prompt = "Is he at school? — No, he ___.",
        answers = setOf("isn’t"),
        explanation = "To be savoliga isn’t bilan javob."
    ),
    Question.Text(
        section = "4-mashq • Do/Doesmi yoki Am/Is/Are?",
        prompt = "Do they work here? — No, they ___.",
        answers = setOf("don’t"),
        explanation = "Do savoliga don’t bilan javob."
    ),
    Question.Choice(
        section = "5-mashq • To‘g‘ri qisqa javobni tanlang",
        prompt = "Does Mina read? — qaysi javob to‘g‘ri?",
        options = listOf("Yes, she does.", "Yes, she do."),
        answer = "Yes, she does.",
        explanation = "Does savoliga does bilan javob beriladi."
    ),
    Question.Choice(
        section = "5-mashq • To‘g‘ri qisqa javobni tanlang",
        prompt = "Do you eat meat? — qaysi javob to‘g‘ri?",
        options = listOf("No, I don’t.", "No, you don’t."),
        answer = "No, I don’t.",
        explanation = "Savol egani — I: No, I don’t."
    ),
    Question.Choice(
        section = "5-mashq • To‘g‘ri qisqa javobni tanlang",
        prompt = "Is Tom ready? — qaysi javob to‘g‘ri?",
        options = listOf("Yes, he is.", "Yes, he does."),
        answer = "Yes, he is.",
        explanation = "To be savolida is ishlatiladi."
    ),
    Question.Choice(
        section = "5-mashq • To‘g‘ri qisqa javobni tanlang",
        prompt = "Are they at home? — qaysi javob to‘g‘ri?",
        options = listOf("No, they aren’t.", "No, they don’t."),
        answer = "No, they aren’t.",
        explanation = "To be savolida aren’t ishlatiladi."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «Does your dad work here? — Yes, he do.»",
        answers = setOf("Yes, he does."),
        mode = TextMode.SENTENCE,
        explanation = "Does savoliga does bilan javob: Yes, he does."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «Do you like tea? — Yes, you do.»",
        answers = setOf("Yes, I do."),
        mode = TextMode.SENTENCE,
        explanation = "Savol egani — I: Yes, I do."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «Are you happy? — Yes, I do.»",
        answers = setOf("Yes, I am."),
        mode = TextMode.SENTENCE,
        explanation = "To be savolida am: Yes, I am."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «Does Sara drive? — No, she don’t.»",
        answers = setOf("No, she doesn’t."),
        mode = TextMode.SENTENCE,
        explanation = "Does savoliga doesn’t: No, she doesn’t."
    ),
    Question.Choice(
        section = "7-mashq • O‘zingiz haqida javob",
        prompt = "«Do you read every day?» — o‘zingiz haqida qisqa javob bering.",
        options = listOf("Yes, I do.", "Yes, you do."),
        answer = "Yes, I do.",
        explanation = "Savol eganiga mos: Yes, I do."
    ),
    Question.Choice(
        section = "7-mashq • O‘zingiz haqida javob",
        prompt = "«Do you like music?» — o‘zingiz haqida qisqa javob bering.",
        options = listOf("Yes, I do.", "Yes, you do."),
        answer = "Yes, I do.",
        explanation = "Savol eganiga mos: Yes, I do."
    ),
    Question.Choice(
        section = "7-mashq • O‘zingiz haqida javob",
        prompt = "«Are you at home now?» — o‘zingiz haqida qisqa javob bering.",
        options = listOf("Yes, I am.", "Yes, you are."),
        answer = "Yes, I am.",
        explanation = "To be savoliga mos: Yes, I am."
    )
)