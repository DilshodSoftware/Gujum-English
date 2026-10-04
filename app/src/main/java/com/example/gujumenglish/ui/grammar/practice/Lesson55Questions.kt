package com.example.gujumenglish.ui.grammar.practice

internal val lesson55Questions: List<Question> = listOf(
    Question.Text(
        section = "1-mashq • Did savoliga javob bering",
        prompt = "Did you call your friend? (ha) — javob bering.",
        answers = setOf("Yes, I did."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: Yes, I did."
    ),
    Question.Text(
        section = "1-mashq • Did savoliga javob bering",
        prompt = "Did he play football? (yo‘q) — javob bering.",
        answers = setOf("No, he didn’t."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: No, he didn’t."
    ),
    Question.Text(
        section = "1-mashq • Did savoliga javob bering",
        prompt = "Did they come early? (ha) — javob bering.",
        answers = setOf("Yes, they did."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: Yes, they did."
    ),
    Question.Text(
        section = "1-mashq • Did savoliga javob bering",
        prompt = "Did Sara buy a new bag? (yo‘q) — javob bering.",
        answers = setOf("No, she didn’t."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: No, she didn’t."
    ),
    Question.Text(
        section = "1-mashq • Did savoliga javob bering",
        prompt = "Did we finish the work? (ha) — javob bering.",
        answers = setOf("Yes, we did."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: Yes, we did."
    ),
    Question.Text(
        section = "2-mashq • Was/Were savoliga javob bering",
        prompt = "Were you tired? (ha) — javob bering.",
        answers = setOf("Yes, I was."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: Yes, I was."
    ),
    Question.Text(
        section = "2-mashq • Was/Were savoliga javob bering",
        prompt = "Was Ali at home? (yo‘q) — javob bering.",
        answers = setOf("No, he wasn’t."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: No, he wasn’t."
    ),
    Question.Text(
        section = "2-mashq • Was/Were savoliga javob bering",
        prompt = "Were the children happy? (ha) — javob bering.",
        answers = setOf("Yes, they were."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: Yes, they were."
    ),
    Question.Text(
        section = "2-mashq • Was/Were savoliga javob bering",
        prompt = "Was it cold yesterday? (yo‘q) — javob bering.",
        answers = setOf("No, it wasn’t."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: No, it wasn’t."
    ),
    Question.Choice(
        section = "3-mashq • Savolga mos yordamchini tanlang",
        prompt = "Did you work? — Yes, I (did / was).",
        options = listOf("did", "was"),
        answer = "did",
        explanation = "Did savoliga did bilan javob."
    ),
    Question.Choice(
        section = "3-mashq • Savolga mos yordamchini tanlang",
        prompt = "Were they late? — No, they (didn’t / weren’t).",
        options = listOf("didn’t", "weren’t"),
        answer = "weren’t",
        explanation = "Were savoliga weren’t bilan javob."
    ),
    Question.Choice(
        section = "3-mashq • Savolga mos yordamchini tanlang",
        prompt = "Was she busy? — Yes, she (did / was).",
        options = listOf("did", "was"),
        answer = "was",
        explanation = "Was savoliga was bilan javob."
    ),
    Question.Choice(
        section = "3-mashq • Savolga mos yordamchini tanlang",
        prompt = "Did he see you? — No, he (didn’t / wasn’t).",
        options = listOf("didn’t", "wasn’t"),
        answer = "didn’t",
        explanation = "Did savoliga didn’t bilan javob."
    ),
    Question.Text(
        section = "4-mashq • Ega olmoshini moslang",
        prompt = "Did you…? (men javob beraman) → Yes, ___ did.",
        answers = setOf("I"),
        explanation = "To‘g‘ri javob: Yes, I did."
    ),
    Question.Text(
        section = "4-mashq • Ega olmoshini moslang",
        prompt = "Did Anna…? → No, ___ didn’t.",
        answers = setOf("she"),
        explanation = "To‘g‘ri javob: No, she didn’t."
    ),
    Question.Text(
        section = "4-mashq • Ega olmoshini moslang",
        prompt = "Did the boys…? → Yes, ___ did.",
        answers = setOf("they"),
        explanation = "To‘g‘ri javob: Yes, they did."
    ),
    Question.Text(
        section = "4-mashq • Ega olmoshini moslang",
        prompt = "Was your father…? → Yes, ___ was.",
        answers = setOf("he"),
        explanation = "To‘g‘ri javob: Yes, he was."
    ),
    Question.Text(
        section = "5-mashq • To‘liq javobni qisqartiring",
        prompt = "Did you watch the film? — Yes, I watched the film. — qisqartiring.",
        answers = setOf("Yes, I did."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: Yes, I did."
    ),
    Question.Text(
        section = "5-mashq • To‘liq javobni qisqartiring",
        prompt = "Did she go to work? — No, she didn’t go to work. — qisqartiring.",
        answers = setOf("No, she didn’t."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: No, she didn’t."
    ),
    Question.Text(
        section = "5-mashq • To‘liq javobni qisqartiring",
        prompt = "Were they at school? — Yes, they were at school. — qisqartiring.",
        answers = setOf("Yes, they were."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: Yes, they were."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «Did you see Ali? — Yes, I was.»",
        answers = setOf("Yes, I did."),
        mode = TextMode.SENTENCE,
        explanation = "Did savoliga did bilan javob."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «Were you tired? — No, I didn’t.»",
        answers = setOf("No, I wasn’t."),
        mode = TextMode.SENTENCE,
        explanation = "Were savoliga wasn’t bilan javob."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «Did he call? — Yes, he do.»",
        answers = setOf("Yes, he did."),
        mode = TextMode.SENTENCE,
        explanation = "O‘tgan zamonda do emas: did."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «Was she at work? — No, she weren’t.»",
        answers = setOf("No, she wasn’t."),
        mode = TextMode.SENTENCE,
        explanation = "Was savoliga wasn’t bilan javob."
    )
)