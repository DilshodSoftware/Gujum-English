package com.example.gujumenglish.ui.grammar.practice

internal val lesson23Questions: List<Question> = listOf(
    Question.Text(
        section = "1-mashq • Egasiga mos Do yoki Does",
        prompt = "___ you speak English?",
        answers = setOf("Do"),
        explanation = "You bilan do."
    ),
    Question.Text(
        section = "1-mashq • Egasiga mos Do yoki Does",
        prompt = "___ your sister work here?",
        answers = setOf("Does"),
        explanation = "Bitta ayol bilan does."
    ),
    Question.Text(
        section = "1-mashq • Egasiga mos Do yoki Does",
        prompt = "___ the children need help?",
        answers = setOf("Do"),
        explanation = "Ko‘plik bilan do."
    ),
    Question.Text(
        section = "1-mashq • Egasiga mos Do yoki Does",
        prompt = "___ the bus stop near the school?",
        answers = setOf("Does"),
        explanation = "Bitta narsa bilan does."
    ),
    Question.Text(
        section = "1-mashq • Egasiga mos Do yoki Does",
        prompt = "___ we have enough time?",
        answers = setOf("Do"),
        explanation = "We bilan do."
    ),
    Question.Text(
        section = "1-mashq • Egasiga mos Do yoki Does",
        prompt = "___ Ali and Sam play tennis?",
        answers = setOf("Do"),
        explanation = "Ko‘plik bilan do."
    ),
    Question.Ordering(
        section = "2-mashq • Savolni to‘liq tuzing",
        prompt = "___ he ___ (like) pizza? — savolni tuzing.",
        words = listOf("Does", "he", "like", "pizza"),
        answer = "Does he like pizza?",
        explanation = "To‘g‘ri savol: Does he like pizza?"
    ),
    Question.Ordering(
        section = "2-mashq • Savolni to‘liq tuzing",
        prompt = "___ they ___ (watch) films? — savolni tuzing.",
        words = listOf("Do", "they", "watch", "films"),
        answer = "Do they watch films?",
        explanation = "To‘g‘ri savol: Do they watch films?"
    ),
    Question.Ordering(
        section = "2-mashq • Savolni to‘liq tuzing",
        prompt = "___ Sara ___ (study) English? — savolni tuzing.",
        words = listOf("Does", "Sara", "study", "English"),
        answer = "Does Sara study English?",
        explanation = "To‘g‘ri savol: Does Sara study English?"
    ),
    Question.Ordering(
        section = "2-mashq • Savolni to‘liq tuzing",
        prompt = "___ your parents ___ (work) here? — savolni tuzing.",
        words = listOf("Do", "your parents", "work", "here"),
        answer = "Do your parents work here?",
        explanation = "To‘g‘ri savol: Do your parents work here?"
    ),
    Question.Choice(
        section = "3-mashq • Asosiy “Do” va yordamchi “Do”",
        prompt = "«Do you like music?» — bu do qanday?",
        options = listOf("yordamchi", "“qilmoq” asosiy fe’li"),
        answer = "yordamchi",
        explanation = "Savolda — yordamchi fe’l."
    ),
    Question.Choice(
        section = "3-mashq • Asosiy “Do” va yordamchi “Do”",
        prompt = "«I do my homework after school.» — bu do qanday?",
        options = listOf("yordamchi", "“qilmoq” asosiy fe’li"),
        answer = "“qilmoq” asosiy fe’li",
        explanation = "Bu yerda do — ma’no beruvchi fe’l."
    ),
    Question.Choice(
        section = "3-mashq • Asosiy “Do” va yordamchi “Do”",
        prompt = "«Does he do the dishes?» — birinchi do qanday?",
        options = listOf("yordamchi", "“qilmoq” asosiy fe’li"),
        answer = "yordamchi",
        explanation = "Does — yordamchi fe’l."
    ),
    Question.Choice(
        section = "3-mashq • Asosiy “Do” va yordamchi “Do”",
        prompt = "«They do exercise every morning.» — bu do qanday?",
        options = listOf("yordamchi", "“qilmoq” asosiy fe’li"),
        answer = "“qilmoq” asosiy fe’li",
        explanation = "Bu yerda do — asosiy fe’l."
    ),
    Question.Text(
        section = "4-mashq • Savolmi, inkormi yoki to be gapimi?",
        prompt = "___ you play chess? (savol)",
        answers = setOf("Do"),
        explanation = "Savol: Do."
    ),
    Question.Text(
        section = "4-mashq • Savolmi, inkormi yoki to be gapimi?",
        prompt = "He ___ not like tea. (inkor)",
        answers = setOf("does"),
        explanation = "Bitta erkak, inkor: doesn’t."
    ),
    Question.Text(
        section = "4-mashq • Savolmi, inkormi yoki to be gapimi?",
        prompt = "___ she happy? (to be bilan savol)",
        answers = setOf("Is"),
        explanation = "To be bilan savol: Is."
    ),
    Question.Text(
        section = "4-mashq • Savolmi, inkormi yoki to be gapimi?",
        prompt = "They ___ not work here. (inkor)",
        answers = setOf("do"),
        explanation = "Ko‘plik, inkor: don’t."
    ),
    Question.Text(
        section = "4-mashq • Savolmi, inkormi yoki to be gapimi?",
        prompt = "My brother ___ a doctor. (to be bilan tasdiq)",
        answers = setOf("is"),
        explanation = "To be bilan: is."
    ),
    Question.Text(
        section = "5-mashq • Xatoni toping",
        prompt = "Xatoni tuzating: «Does she likes cats?»",
        answers = setOf("Does she like cats?"),
        mode = TextMode.SENTENCE,
        explanation = "Does dan keyin oddiy shakl: like."
    ),
    Question.Text(
        section = "5-mashq • Xatoni toping",
        prompt = "Xatoni tuzating: «Do your father work here?»",
        answers = setOf("Does your father work here?"),
        mode = TextMode.SENTENCE,
        explanation = "Bitta erkak bilan Does."
    ),
    Question.Text(
        section = "5-mashq • Xatoni toping",
        prompt = "Xatoni tuzating: «Does he be tired?»",
        answers = setOf("Is he tired?"),
        mode = TextMode.SENTENCE,
        explanation = "To be bilan: Is."
    ),
    Question.Text(
        section = "5-mashq • Xatoni toping",
        prompt = "Xatoni tuzating: «Do they plays football?»",
        answers = setOf("Do they play football?"),
        mode = TextMode.SENTENCE,
        explanation = "Do dan keyin oddiy shakl: play."
    ),
    Question.TrueFalse(
        section = "5-mashq • Xatoni toping",
        prompt = "«Does Anna do her homework?» — bu gap to‘g‘ri.",
        answer = true,
        explanation = "Bu gap to‘g‘ri: Does — yordamchi, ikkinchi do — asosiy fe’l."
    ),
    Question.Text(
        section = "6-mashq • Darakni inkorga va savolga o‘tkazing",
        prompt = "«They live here.» — inkor shaklini yozing.",
        answers = setOf("They don’t live here."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: They don’t live here."
    ),
    Question.Text(
        section = "6-mashq • Darakni inkorga va savolga o‘tkazing",
        prompt = "«He plays tennis.» — inkor shaklini yozing.",
        answers = setOf("He doesn’t play tennis."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: He doesn’t play tennis."
    ),
    Question.Ordering(
        section = "6-mashq • Darakni inkorga va savolga o‘tkazing",
        prompt = "«You need a pen.» — savol shaklini tuzing.",
        words = listOf("Do", "you", "a pen", "need"),
        answer = "Do you need a pen?",
        explanation = "To‘g‘ri savol: Do you need a pen?"
    ),
    Question.Ordering(
        section = "6-mashq • Darakni inkorga va savolga o‘tkazing",
        prompt = "«Sara reads at night.» — savol shaklini tuzing.",
        words = listOf("Does", "Sara", "at night", "read"),
        answer = "Does Sara read at night?",
        explanation = "To‘g‘ri savol: Does Sara read at night?"
    )
)