package com.example.gujumenglish.ui.grammar.practice

internal val lesson45Questions: List<Question> = listOf(
    Question.Text(
        section = "1-mashq • Some yoki Any?",
        prompt = "There are ___ apples in the bowl.",
        answers = setOf("some"),
        explanation = "Darak gapda: some."
    ),
    Question.Text(
        section = "1-mashq • Some yoki Any?",
        prompt = "I don’t have ___ brothers.",
        answers = setOf("any"),
        explanation = "Inkor gapda: any."
    ),
    Question.Text(
        section = "1-mashq • Some yoki Any?",
        prompt = "Is there ___ milk?",
        answers = setOf("any"),
        explanation = "Betaraf savolda: any."
    ),
    Question.Text(
        section = "1-mashq • Some yoki Any?",
        prompt = "She has ___ books in her bag.",
        answers = setOf("some"),
        explanation = "Darak gapda: some."
    ),
    Question.Text(
        section = "1-mashq • Some yoki Any?",
        prompt = "We need ___ bread.",
        answers = setOf("some"),
        explanation = "Darak gapda: some."
    ),
    Question.Text(
        section = "1-mashq • Some yoki Any?",
        prompt = "They don’t have ___ water.",
        answers = setOf("any"),
        explanation = "Inkor gapda: any."
    ),
    Question.Ordering(
        section = "2-mashq • Savol turini aniqlang va tanlang",
        prompt = "___ you have ___ questions? (betaraf savol) — bo‘sh joylarni to‘ldiring.",
        words = listOf("Do", "any", "questions", "you", "have"),
        answer = "Do you have any questions?",
        explanation = "Betaraf savol: Do ... any."
    ),
    Question.Ordering(
        section = "2-mashq • Savol turini aniqlang va tanlang",
        prompt = "Would you like ___ tea? (taklif) — gapni tuzing.",
        words = listOf("Would you like", "tea", "some"),
        answer = "Would you like some tea?",
        explanation = "Taklifda ham some ishlatiladi: some tea."
    ),
    Question.Ordering(
        section = "2-mashq • Savol turini aniqlang va tanlang",
        prompt = "Can I have ___ water, please? (iltimos) — gapni tuzing.",
        words = listOf("Can I have", "water, please", "some"),
        answer = "Can I have some water, please?",
        explanation = "Iltimosda some: some water."
    ),
    Question.Ordering(
        section = "2-mashq • Savol turini aniqlang va tanlang",
        prompt = "Are there ___ chairs? (oddiy savol) — gapni tuzing.",
        words = listOf("Are there", "chairs", "any"),
        answer = "Are there any chairs?",
        explanation = "Oddiy savolda: any."
    ),
    Question.Choice(
        section = "3-mashq • Sanaladigan/sanalmaydigan ot bilan ishlating",
        prompt = "___ oranges (ko‘plikdagi sanaladigan, darak gapda)",
        options = listOf("some", "any"),
        answer = "some",
        explanation = "Darak gapda: some oranges."
    ),
    Question.Choice(
        section = "3-mashq • Sanaladigan/sanalmaydigan ot bilan ishlating",
        prompt = "___ juice (sanalmaydigan, darak gapda)",
        options = listOf("some", "any"),
        answer = "some",
        explanation = "Darak gapda: some juice."
    ),
    Question.Choice(
        section = "3-mashq • Sanaladigan/sanalmaydigan ot bilan ishlating",
        prompt = "___ students (ko‘plikdagi sanaladigan, savolda)",
        options = listOf("some", "any"),
        answer = "any",
        explanation = "Savolda: any students."
    ),
    Question.Choice(
        section = "3-mashq • Sanaladigan/sanalmaydigan ot bilan ishlating",
        prompt = "___ rice (sanalmaydigan, inkor gapda)",
        options = listOf("some", "any"),
        answer = "any",
        explanation = "Inkor gapda: any rice."
    ),
    Question.Text(
        section = "4-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «I don’t have some money.»",
        answers = setOf("I don’t have any money."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: I don’t have any money."
    ),
    Question.Text(
        section = "4-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «Does she have some sisters?» (oddiy, betaraf savol)",
        answers = setOf("Does she have any sisters?"),
        mode = TextMode.SENTENCE,
        explanation = "Savolda: any."
    ),
    Question.Text(
        section = "4-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «There is any juice in the glass.» (darak)",
        answers = setOf("There is some juice in the glass."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: There is some juice in the glass."
    ),
    Question.Text(
        section = "4-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «Would you like any coffee?» (taklif)",
        answers = setOf("Would you like some coffee?"),
        mode = TextMode.SENTENCE,
        explanation = "Taklifda: some coffee."
    ),
    Question.Choice(
        section = "5-mashq • Some, Any yoki artiklsizmi?",
        prompt = "I like ___ dogs. (umumdan itlarni yoqtiraman)",
        options = listOf("some", "any", "artiklsiz"),
        answer = "artiklsiz",
        explanation = "Umumiy ko‘plik: artiklsiz."
    ),
    Question.Choice(
        section = "5-mashq • Some, Any yoki artiklsizmi?",
        prompt = "I have ___ dogs. (bir nechta itim bor)",
        options = listOf("some", "any", "artiklsiz"),
        answer = "some",
        explanation = "Darak gapda: some dogs."
    ),
    Question.Choice(
        section = "5-mashq • Some, Any yoki artiklsizmi?",
        prompt = "I don’t have ___ dog. (hech qanday itim yo‘q)",
        options = listOf("some", "any", "artiklsiz"),
        answer = "any",
        explanation = "Inkor gapda: any dog."
    ),
    Question.Choice(
        section = "5-mashq • Some, Any yoki artiklsizmi?",
        prompt = "___ water is important. (suv umumiy ma’noda)",
        options = listOf("some", "any", "artiklsiz"),
        answer = "artiklsiz",
        explanation = "Umumiy ma’no: artiklsiz."
    ),
    Question.Text(
        section = "6-mashq • Qisqa dialogni yakunlang",
        prompt = "A: Do you have ___ apples? — to‘ldiring.",
        answers = setOf("any"),
        explanation = "Savolda: any."
    ),
    Question.Text(
        section = "6-mashq • Qisqa dialogni yakunlang",
        prompt = "B: Yes, I have ___ apples. — to‘ldiring.",
        answers = setOf("some"),
        explanation = "Javobda darak: some."
    ),
    Question.Text(
        section = "6-mashq • Qisqa dialogni yakunlang",
        prompt = "B: Would you like ___? — to‘ldiring.",
        answers = setOf("some"),
        explanation = "Taklifda: some."
    ),
    Question.Text(
        section = "6-mashq • Qisqa dialogni yakunlang",
        prompt = "A: Can I have ___ water too? — to‘ldiring.",
        answers = setOf("some"),
        explanation = "Iltimosda: some water."
    )
)