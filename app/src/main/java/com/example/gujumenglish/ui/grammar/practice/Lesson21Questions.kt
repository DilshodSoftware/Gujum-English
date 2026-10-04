package com.example.gujumenglish.ui.grammar.practice

internal val lesson21Questions: List<Question> = listOf(
    Question.Matching(
        section = "1-mashq • Fe’l shakllarini guruhlang",
        prompt = "Har bir fe’lni to‘g‘ri qoidaga bog‘lang.",
        pairs = listOf(
            "read" to "A. +s",
            "watch" to "B. +es",
            "study" to "C. undosh + y → ies",
            "play" to "A. +s",
            "go" to "B. +es",
            "have" to "D. alohida shakl"
        ),
        options = listOf("A. +s", "B. +es", "C. undosh + y → ies", "D. alohida shakl"),
        explanation = "read/play → +s; watch/go → +es; study → -ies; have → has."
    ),
    Question.Matching(
        section = "1-mashq • Fe’l shakllarini guruhlang",
        prompt = "Qolgan fe’llarni to‘g‘ri qoidaga bog‘lang.",
        pairs = listOf(
            "wash" to "B. +es",
            "enjoy" to "A. +s",
            "fix" to "B. +es",
            "cry" to "C. undosh + y → ies"
        ),
        options = listOf("A. +s", "B. +es", "C. undosh + y → ies", "D. alohida shakl"),
        explanation = "wash/fix → +es; enjoy → +s; cry → -ies."
    ),
    Question.TrueFalse(
        section = "1-mashq • Fe’l shakllarini guruhlang",
        prompt = "play va enjoy so‘zlari unli + y bilan tugagani uchun -ies emas, faqat -s oladi.",
        answer = true,
        explanation = "Bu gap to‘g‘ri: plays, enjoys."
    ),
    Question.Text(
        section = "2-mashq • Fe’lni he/she/it bilan o‘zgartiring",
        prompt = "work → he ___",
        answers = setOf("works"),
        explanation = "Oddiy fe’l + s: works."
    ),
    Question.Text(
        section = "2-mashq • Fe’lni he/she/it bilan o‘zgartiring",
        prompt = "wash → she ___",
        answers = setOf("washes"),
        explanation = "-sh bilan tugagan: washes."
    ),
    Question.Text(
        section = "2-mashq • Fe’lni he/she/it bilan o‘zgartiring",
        prompt = "study → my brother ___",
        answers = setOf("studies"),
        explanation = "undosh + y → -ies: studies."
    ),
    Question.Text(
        section = "2-mashq • Fe’lni he/she/it bilan o‘zgartiring",
        prompt = "play → the girl ___",
        answers = setOf("plays"),
        explanation = "unli + y → faqat -s: plays."
    ),
    Question.Text(
        section = "2-mashq • Fe’lni he/she/it bilan o‘zgartiring",
        prompt = "go → Tom ___",
        answers = setOf("goes"),
        explanation = "-o bilan tugagan: goes."
    ),
    Question.Text(
        section = "2-mashq • Fe’lni he/she/it bilan o‘zgartiring",
        prompt = "fix → it ___",
        answers = setOf("fixes"),
        explanation = "-x bilan tugagan: fixes."
    ),
    Question.Text(
        section = "2-mashq • Fe’lni he/she/it bilan o‘zgartiring",
        prompt = "have → Anna ___",
        answers = setOf("has"),
        explanation = "Istisno: have → has."
    ),
    Question.Text(
        section = "2-mashq • Fe’lni he/she/it bilan o‘zgartiring",
        prompt = "enjoy → he ___",
        answers = setOf("enjoys"),
        explanation = "unli + y → faqat -s: enjoys."
    ),
    Question.Choice(
        section = "3-mashq • Qaysi ega bilan fe’lga -s qo‘shiladi?",
        prompt = "my uncle",
        options = listOf("-s/-es/-ies shakli", "oddiy fe’l"),
        answer = "-s/-es/-ies shakli",
        explanation = "my uncle — bitta erkak: -s kerak."
    ),
    Question.Choice(
        section = "3-mashq • Qaysi ega bilan fe’lga -s qo‘shiladi?",
        prompt = "the children",
        options = listOf("-s/-es/-ies shakli", "oddiy fe’l"),
        answer = "oddiy fe’l",
        explanation = "the children — ko‘plik: oddiy fe’l."
    ),
    Question.Choice(
        section = "3-mashq • Qaysi ega bilan fe’lga -s qo‘shiladi?",
        prompt = "you",
        options = listOf("-s/-es/-ies shakli", "oddiy fe’l"),
        answer = "oddiy fe’l",
        explanation = "you bilan -s qo‘shilmaydi."
    ),
    Question.Choice(
        section = "3-mashq • Qaysi ega bilan fe’lga -s qo‘shiladi?",
        prompt = "the bus",
        options = listOf("-s/-es/-ies shakli", "oddiy fe’l"),
        answer = "-s/-es/-ies shakli",
        explanation = "the bus — bitta narsa: -s kerak."
    ),
    Question.Choice(
        section = "3-mashq • Qaysi ega bilan fe’lga -s qo‘shiladi?",
        prompt = "Ali and Sara",
        options = listOf("-s/-es/-ies shakli", "oddiy fe’l"),
        answer = "oddiy fe’l",
        explanation = "Ali and Sara — ko‘plik: oddiy fe’l."
    ),
    Question.Choice(
        section = "3-mashq • Qaysi ega bilan fe’lga -s qo‘shiladi?",
        prompt = "it",
        options = listOf("-s/-es/-ies shakli", "oddiy fe’l"),
        answer = "-s/-es/-ies shakli",
        explanation = "it — bitta narsa: -s kerak."
    ),
    Question.Text(
        section = "4-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «The baby crys at night.»",
        answers = setOf("The baby cries at night."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: The baby cries at night."
    ),
    Question.Text(
        section = "4-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «My father watch TV after dinner.»",
        answers = setOf("My father watches TV after dinner."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: My father watches TV after dinner."
    ),
    Question.Text(
        section = "4-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «She studys French.»",
        answers = setOf("She studies French."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: She studies French."
    ),
    Question.Text(
        section = "4-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «He play the piano.»",
        answers = setOf("He plays the piano."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: He plays the piano."
    ),
    Question.Text(
        section = "4-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «My friends goes to school by bus.»",
        answers = setOf("My friends go to school by bus."),
        mode = TextMode.SENTENCE,
        explanation = "Ko‘plik bilan -s yo‘q: My friends go to school by bus."
    ),
    Question.Choice(
        section = "5-mashq • To‘g‘ri shaklni tanlang",
        prompt = "The bus (pass / passes) our house.",
        options = listOf("pass", "passes"),
        answer = "passes",
        explanation = "Bitta ega: passes."
    ),
    Question.Choice(
        section = "5-mashq • To‘g‘ri shaklni tanlang",
        prompt = "My sister (enjoy / enjoys) drawing.",
        options = listOf("enjoy", "enjoys"),
        answer = "enjoys",
        explanation = "unli + y → faqat -s: enjoys."
    ),
    Question.Choice(
        section = "5-mashq • To‘g‘ri shaklni tanlang",
        prompt = "A bird (fly / flies) in the sky.",
        options = listOf("fly", "flies"),
        answer = "flies",
        explanation = "undosh + y → -ies: flies."
    ),
    Question.Choice(
        section = "5-mashq • To‘g‘ri shaklni tanlang",
        prompt = "They (watch / watches) cartoons.",
        options = listOf("watch", "watches"),
        answer = "watch",
        explanation = "Ko‘plik bilan -s yo‘q: watch."
    ),
    Question.Choice(
        section = "5-mashq • To‘g‘ri shaklni tanlang",
        prompt = "The dog (have / has) a long tail.",
        options = listOf("have", "has"),
        answer = "has",
        explanation = "Istisno: have → has."
    ),
    Question.Ordering(
        section = "6-mashq • Ism bilan gap tuzing",
        prompt = "(Malika / read / every evening) — gapni tuzing.",
        words = listOf("Malika", "every evening", "reads"),
        answer = "Malika reads every evening.",
        explanation = "To‘g‘ri gap: Malika reads every evening."
    ),
    Question.Ordering(
        section = "6-mashq • Ism bilan gap tuzing",
        prompt = "(my brother / fix / bicycles) — gapni tuzing.",
        words = listOf("my brother", "bicycles", "fixes"),
        answer = "My brother fixes bicycles.",
        explanation = "To‘g‘ri gap: My brother fixes bicycles."
    ),
    Question.Ordering(
        section = "6-mashq • Ism bilan gap tuzing",
        prompt = "(the cat / sleep / on the sofa) — gapni tuzing.",
        words = listOf("the cat", "on the sofa", "sleeps"),
        answer = "The cat sleeps on the sofa.",
        explanation = "To‘g‘ri gap: The cat sleeps on the sofa."
    )
)