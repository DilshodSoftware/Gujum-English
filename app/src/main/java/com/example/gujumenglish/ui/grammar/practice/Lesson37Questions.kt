package com.example.gujumenglish.ui.grammar.practice

internal val lesson37Questions: List<Question> = listOf(
    Question.Text(
        section = "1-mashq • Many yoki Much?",
        prompt = "How ___ pencils are in your bag?",
        answers = setOf("many"),
        explanation = "Ko‘plikdagi sanaladigan ot: many."
    ),
    Question.Text(
        section = "1-mashq • Many yoki Much?",
        prompt = "How ___ juice do you want?",
        answers = setOf("much"),
        explanation = "Sanalmaydigan ot: much."
    ),
    Question.Text(
        section = "1-mashq • Many yoki Much?",
        prompt = "How ___ money is in your wallet?",
        answers = setOf("much"),
        explanation = "Sanalmaydigan ot: money: much."
    ),
    Question.Text(
        section = "1-mashq • Many yoki Much?",
        prompt = "How ___ students are in the room?",
        answers = setOf("many"),
        explanation = "Ko‘plikdagi sanaladigan ot: many."
    ),
    Question.Text(
        section = "1-mashq • Many yoki Much?",
        prompt = "How ___ time do we have?",
        answers = setOf("much"),
        explanation = "Sanalmaydigan ot: time: much."
    ),
    Question.Text(
        section = "1-mashq • Many yoki Much?",
        prompt = "How ___ eggs do we need?",
        answers = setOf("many"),
        explanation = "Ko‘plikdagi sanaladigan ot: many."
    ),
    Question.Matching(
        section = "2-mashq • Otni sanash mumkinmi?",
        prompt = "Sanaladigan otlarni sanaladigan guruhga bog‘lang.",
        pairs = listOf(
            "apple" to "sanaladigan",
            "chair" to "sanaladigan",
            "book" to "sanaladigan",
            "student" to "sanaladigan"
        ),
        options = listOf("sanaladigan", "sanalmaydigan"),
        explanation = "apple, chair, book, student — sanaladigan."
    ),
    Question.Matching(
        section = "2-mashq • Otni sanash mumkinmi?",
        prompt = "Sanalmaydigan otlarni sanalmaydigan guruhga bog‘lang.",
        pairs = listOf(
            "rice" to "sanalmaydigan",
            "water" to "sanalmaydigan",
            "money" to "sanalmaydigan",
            "milk" to "sanalmaydigan",
            "time" to "sanalmaydigan"
        ),
        options = listOf("sanaladigan", "sanalmaydigan"),
        explanation = "rice, water, money, milk, time — sanalmaydigan."
    ),
    Question.Text(
        section = "3-mashq • Do yoki Does bilan savolni tugating",
        prompt = "How many books ___ you read?",
        answers = setOf("do"),
        explanation = "Ko‘p ega bilan: do."
    ),
    Question.Text(
        section = "3-mashq • Do yoki Does bilan savolni tugating",
        prompt = "How much milk ___ the baby drink?",
        answers = setOf("does"),
        explanation = "Bitta ega bilan: does."
    ),
    Question.Text(
        section = "3-mashq • Do yoki Does bilan savolni tugating",
        prompt = "How many sisters ___ Ali have?",
        answers = setOf("does"),
        explanation = "Bitta ega bilan: does."
    ),
    Question.Text(
        section = "3-mashq • Do yoki Does bilan savolni tugating",
        prompt = "How much rice ___ they eat?",
        answers = setOf("do"),
        explanation = "Ko‘p ega bilan: do."
    ),
    Question.Choice(
        section = "4-mashq • Narxni so‘rang",
        prompt = "How ___ is this sandwich? (qancha turadi?)",
        options = listOf("much", "many"),
        answer = "much",
        explanation = "Narx uchun: how much."
    ),
    Question.Choice(
        section = "4-mashq • Narxni so‘rang",
        prompt = "How ___ are these shoes?",
        options = listOf("much", "many"),
        answer = "much",
        explanation = "Narx uchun: how much."
    ),
    Question.Choice(
        section = "4-mashq • Narxni so‘rang",
        prompt = "How ___ is the ticket?",
        options = listOf("much", "many"),
        answer = "much",
        explanation = "Narx uchun: how much."
    ),
    Question.Text(
        section = "5-mashq • Xatolarni tuzating",
        prompt = "Xatoni tuzating: «How much chairs are there?»",
        answers = setOf("How many chairs are there?"),
        mode = TextMode.SENTENCE,
        explanation = "Ko‘plikdagi sanaladigan ot: many."
    ),
    Question.Text(
        section = "5-mashq • Xatolarni tuzating",
        prompt = "Xatoni tuzating: «How many water do you drink?»",
        answers = setOf("How much water do you drink?"),
        mode = TextMode.SENTENCE,
        explanation = "Sanalmaydigan ot: much."
    ),
    Question.Text(
        section = "5-mashq • Xatolarni tuzating",
        prompt = "Xatoni tuzating: «How many books does you have?»",
        answers = setOf("How many books do you have?"),
        mode = TextMode.SENTENCE,
        explanation = "Ko‘p ega bilan: do."
    ),
    Question.Text(
        section = "5-mashq • Xatolarni tuzating",
        prompt = "Xatoni tuzating: «How many money does he need?»",
        answers = setOf("How much money does he need?"),
        mode = TextMode.SENTENCE,
        explanation = "Sanalmaydigan ot: much."
    ),
    Question.Text(
        section = "5-mashq • Xatolarni tuzating",
        prompt = "Xatoni tuzating: «How much are this apples?» (narx)",
        answers = setOf("How much are these apples?"),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: How much are these apples?"
    ),
    Question.Matching(
        section = "6-mashq • Savol va javobni moslang",
        prompt = "Har bir savolni to‘g‘ri javob bilan bog‘lang.",
        pairs = listOf(
            "How many books do you have?" to "B. Five.",
            "How much water do you need?" to "A. Two litres.",
            "How much is the pen?" to "C. Three dollars."
        ),
        options = listOf("A. Two litres.", "B. Five.", "C. Three dollars."),
        explanation = "1—B; 2—A; 3—C."
    )
)