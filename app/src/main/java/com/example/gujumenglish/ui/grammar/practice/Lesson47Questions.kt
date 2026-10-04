package com.example.gujumenglish.ui.grammar.practice

internal val lesson47Questions: List<Question> = listOf(
    Question.Matching(
        section = "1-mashq • Subject dan Object shaklini toping",
        prompt = "Har bir subject olmoshiga mos object olmoshini bog‘lang.",
        pairs = listOf(
            "I" to "me",
            "you" to "you",
            "he" to "him",
            "she" to "her",
            "it" to "it",
            "we" to "us",
            "they" to "them"
        ),
        options = listOf("me", "you", "him", "her", "it", "us", "them"),
        explanation = "I—me, you—you, he—him, she—her, it—it, we—us, they—them."
    ),
    Question.Choice(
        section = "2-mashq • Fe’ldan keyin to‘g‘ri olmoshni tanlang",
        prompt = "I know (he / him).",
        options = listOf("he", "him"),
        answer = "him",
        explanation = "Object shakli: him."
    ),
    Question.Choice(
        section = "2-mashq • Fe’ldan keyin to‘g‘ri olmoshni tanlang",
        prompt = "She helps (we / us).",
        options = listOf("we", "us"),
        answer = "us",
        explanation = "Object shakli: us."
    ),
    Question.Choice(
        section = "2-mashq • Fe’ldan keyin to‘g‘ri olmoshni tanlang",
        prompt = "They visit (she / her).",
        options = listOf("she", "her"),
        answer = "her",
        explanation = "Object shakli: her."
    ),
    Question.Choice(
        section = "2-mashq • Fe’ldan keyin to‘g‘ri olmoshni tanlang",
        prompt = "The teacher sees (they / them).",
        options = listOf("they", "them"),
        answer = "them",
        explanation = "Object shakli: them."
    ),
    Question.Choice(
        section = "2-mashq • Fe’ldan keyin to‘g‘ri olmoshni tanlang",
        prompt = "Do you like (I / me)?",
        options = listOf("I", "me"),
        answer = "me",
        explanation = "Object shakli: me."
    ),
    Question.Choice(
        section = "2-mashq • Fe’ldan keyin to‘g‘ri olmoshni tanlang",
        prompt = "We call (he / him) every week.",
        options = listOf("he", "him"),
        answer = "him",
        explanation = "Object shakli: him."
    ),
    Question.Text(
        section = "3-mashq • Ismni object pronoun bilan almashtiring",
        prompt = "I see Sara. → I see ___.",
        answers = setOf("her"),
        explanation = "Sara — ayol: her."
    ),
    Question.Text(
        section = "3-mashq • Ismni object pronoun bilan almashtiring",
        prompt = "He knows Ali. → He knows ___.",
        answers = setOf("him"),
        explanation = "Ali — erkak: him."
    ),
    Question.Text(
        section = "3-mashq • Ismni object pronoun bilan almashtiring",
        prompt = "They help my sister and me. → They help ___.",
        answers = setOf("us"),
        explanation = "Men guruh ichidaman: us."
    ),
    Question.Text(
        section = "3-mashq • Ismni object pronoun bilan almashtiring",
        prompt = "We visit the children. → We visit ___.",
        answers = setOf("them"),
        explanation = "Bolalar — ko‘plik: them."
    ),
    Question.Text(
        section = "4-mashq • Object olmoshi bilan gapni qayta yozing",
        prompt = "I call my parents. — qayta yozing.",
        answers = setOf("I call them."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: I call them."
    ),
    Question.Choice(
        section = "4-mashq • Object olmoshi bilan gapni qayta yozing",
        prompt = "She listens to the teacher. — qaysi olmosh?",
        options = listOf("him / her", "them"),
        answer = "him / her",
        explanation = "Teacher — erkak yoki ayol bo‘lishi mumkin: him/her."
    ),
    Question.Text(
        section = "4-mashq • Object olmoshi bilan gapni qayta yozing",
        prompt = "He sits next to Sara. — qayta yozing.",
        answers = setOf("He sits next to her."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: He sits next to her."
    ),
    Question.Text(
        section = "4-mashq • Object olmoshi bilan gapni qayta yozing",
        prompt = "They look at the picture. — qayta yozing.",
        answers = setOf("They look at it."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: They look at it."
    ),
    Question.Choice(
        section = "5-mashq • Subject yoki Object?",
        prompt = "«He likes me.» — birinchi olmosh qaysi bo‘lak?",
        options = listOf("subject", "object"),
        answer = "subject",
        explanation = "Gap boshida — subject: He."
    ),
    Question.Choice(
        section = "5-mashq • Subject yoki Object?",
        prompt = "«He likes me.» — ikkinchi olmosh qaysi bo‘lak?",
        options = listOf("subject", "object"),
        answer = "object",
        explanation = "Fe’ldan keyin — object: me."
    ),
    Question.Choice(
        section = "5-mashq • Subject yoki Object?",
        prompt = "«They help her.» — «her» qaysi bo‘lak?",
        options = listOf("subject", "object"),
        answer = "object",
        explanation = "Fe’ldan keyin — object: her."
    ),
    Question.Choice(
        section = "5-mashq • Subject yoki Object?",
        prompt = "«We see them.» — «them» qaysi bo‘lak?",
        options = listOf("subject", "object"),
        answer = "object",
        explanation = "Fe’ldan keyin — object: them."
    ),
    Question.Choice(
        section = "5-mashq • Subject yoki Object?",
        prompt = "«She knows us.» — «us» qaysi bo‘lak?",
        options = listOf("subject", "object"),
        answer = "object",
        explanation = "Fe’ldan keyin — object: us."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «Him likes I.»",
        answers = setOf("He likes me."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: He likes me."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «She helps they.»",
        answers = setOf("She helps them."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: She helps them."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «Come with I.»",
        answers = setOf("Come with me."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: Come with me."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «We know she.»",
        answers = setOf("We know her."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: We know her."
    )
)