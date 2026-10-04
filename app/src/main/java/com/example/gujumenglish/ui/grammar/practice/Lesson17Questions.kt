package com.example.gujumenglish.ui.grammar.practice

internal val lesson17Questions: List<Question> = listOf(
    Question.Text(
        section = "1-mashq • Have yoki Has?",
        prompt = "My friends ___ a new teacher.",
        answers = setOf("have"),
        explanation = "Ko‘plik ega: have."
    ),
    Question.Text(
        section = "1-mashq • Have yoki Has?",
        prompt = "My sister ___ a red bicycle.",
        answers = setOf("has"),
        explanation = "Bitta ega: has."
    ),
    Question.Text(
        section = "1-mashq • Have yoki Has?",
        prompt = "I ___ two brothers.",
        answers = setOf("have"),
        explanation = "I bilan have."
    ),
    Question.Text(
        section = "1-mashq • Have yoki Has?",
        prompt = "The house ___ three windows.",
        answers = setOf("has"),
        explanation = "Bitta ega: has."
    ),
    Question.Text(
        section = "1-mashq • Have yoki Has?",
        prompt = "You ___ a good idea.",
        answers = setOf("have"),
        explanation = "You bilan have."
    ),
    Question.Text(
        section = "1-mashq • Have yoki Has?",
        prompt = "Ali and I ___ English books.",
        answers = setOf("have"),
        explanation = "Ko‘plik: have."
    ),
    Question.Text(
        section = "1-mashq • Have yoki Has?",
        prompt = "The baby ___ blue eyes.",
        answers = setOf("has"),
        explanation = "Bitta ega: has."
    ),
    Question.Text(
        section = "1-mashq • Have yoki Has?",
        prompt = "Our parents ___ a small garden.",
        answers = setOf("have"),
        explanation = "Ko‘plik ega: have."
    ),
    Question.Matching(
        section = "1-mashq • Have yoki Has?",
        prompt = "Har bir ega uchun mos shaklni bog‘lang.",
        pairs = listOf(
            "I" to "have",
            "he" to "has",
            "they" to "have",
            "the cat" to "has",
            "we" to "have",
            "my sisters" to "have"
        ),
        options = listOf("have", "has"),
        explanation = "I/you/we/they → have; he/she/it va birlik → has."
    ),
    Question.Text(
        section = "2-mashq • Inkor shaklini yozing",
        prompt = "«I have a computer.» — inkor shaklini yozing.",
        answers = setOf("I don’t have a computer."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: I don’t have a computer."
    ),
    Question.Text(
        section = "2-mashq • Inkor shaklini yozing",
        prompt = "«He has a sister.» — inkor shaklini yozing.",
        answers = setOf("He doesn’t have a sister."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: He doesn’t have a sister."
    ),
    Question.Text(
        section = "2-mashq • Inkor shaklini yozing",
        prompt = "«They have a car.» — inkor shaklini yozing.",
        answers = setOf("They don’t have a car."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: They don’t have a car."
    ),
    Question.Text(
        section = "2-mashq • Inkor shaklini yozing",
        prompt = "«The dog has a long tail.» — inkor shaklini yozing.",
        answers = setOf("The dog doesn’t have a long tail."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: The dog doesn’t have a long tail."
    ),
    Question.Text(
        section = "2-mashq • Inkor shaklini yozing",
        prompt = "«We have a lot of time.» — inkor shaklini yozing.",
        answers = setOf("We don’t have a lot of time."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: We don’t have a lot of time."
    ),
    Question.Ordering(
        section = "3-mashq • Do yoki Does bilan savol tuzing",
        prompt = "you / have / a pencil? — savol tuzing.",
        words = listOf("Do", "you", "have", "a pencil"),
        answer = "Do you have a pencil?",
        explanation = "To‘g‘ri savol: Do you have a pencil?"
    ),
    Question.Ordering(
        section = "3-mashq • Do yoki Does bilan savol tuzing",
        prompt = "Sara / have / a phone? — savol tuzing.",
        words = listOf("Does", "Sara", "have", "a phone"),
        answer = "Does Sara have a phone?",
        explanation = "To‘g‘ri savol: Does Sara have a phone?"
    ),
    Question.Ordering(
        section = "3-mashq • Do yoki Does bilan savol tuzing",
        prompt = "your friends / have / bikes? — savol tuzing.",
        words = listOf("Do", "your friends", "have", "bikes"),
        answer = "Do your friends have bikes?",
        explanation = "To‘g‘ri savol: Do your friends have bikes?"
    ),
    Question.Ordering(
        section = "3-mashq • Do yoki Does bilan savol tuzing",
        prompt = "the cat / have / green eyes? — savol tuzing.",
        words = listOf("Does", "the cat", "have", "green eyes"),
        answer = "Does the cat have green eyes?",
        explanation = "To‘g‘ri savol: Does the cat have green eyes?"
    ),
    Question.Ordering(
        section = "3-mashq • Do yoki Does bilan savol tuzing",
        prompt = "we / have / homework? — savol tuzing.",
        words = listOf("Do", "we", "have", "homework"),
        answer = "Do we have homework?",
        explanation = "To‘g‘ri savol: Do we have homework?"
    ),
    Question.Text(
        section = "4-mashq • Qisqa javoblar",
        prompt = "«Do you have a pet? (ha)» — qisqa javob yozing.",
        answers = setOf("Yes, I do."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: Yes, I do."
    ),
    Question.Text(
        section = "4-mashq • Qisqa javoblar",
        prompt = "«Does Tom have a sister? (yo‘q)» — qisqa javob yozing.",
        answers = setOf("No, he doesn’t."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: No, he doesn’t."
    ),
    Question.Text(
        section = "4-mashq • Qisqa javoblar",
        prompt = "«Do they have a garden? (ha)» — qisqa javob yozing.",
        answers = setOf("Yes, they do."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: Yes, they do."
    ),
    Question.Text(
        section = "4-mashq • Qisqa javoblar",
        prompt = "«Does your phone have a camera? (yo‘q)» — qisqa javob yozing.",
        answers = setOf("No, it doesn’t."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: No, it doesn’t."
    ),
    Question.Choice(
        section = "5-mashq • Aralash test",
        prompt = "___ your brother have a bike?",
        options = listOf("Do", "Does"),
        answer = "Does",
        explanation = "Bitta ega: Does."
    ),
    Question.Choice(
        section = "5-mashq • Aralash test",
        prompt = "My sister ___ a blue bag.",
        options = listOf("have", "has"),
        answer = "has",
        explanation = "Sister — bitta: has."
    ),
    Question.Choice(
        section = "5-mashq • Aralash test",
        prompt = "They ___ a car.",
        options = listOf("don’t have", "doesn’t have"),
        answer = "don’t have",
        explanation = "They bilan don’t have."
    ),
    Question.Choice(
        section = "5-mashq • Aralash test",
        prompt = "Does Anna ___ a cat?",
        options = listOf("have", "has"),
        answer = "have",
        explanation = "Does qat’iy shaklda bo‘lsa, asosiy fe’l have bo‘ladi."
    ),
    Question.Choice(
        section = "5-mashq • Aralash test",
        prompt = "He doesn’t ___ a computer.",
        options = listOf("have", "has"),
        answer = "have",
        explanation = "Doesn’t bilan asosiy shakl: have."
    ),
    Question.Text(
        section = "6-mashq • Dialogni yakunlang",
        prompt = "A: ___ you have any brothers? — to‘ldiring.",
        answers = setOf("Do"),
        explanation = "Do you have any brothers?"
    ),
    Question.Text(
        section = "6-mashq • Dialogni yakunlang",
        prompt = "A: Do you have any brothers? B: Yes, I ___. — to‘ldiring.",
        answers = setOf("do"),
        explanation = "Yes, I do."
    ),
    Question.Text(
        section = "6-mashq • Dialogni yakunlang",
        prompt = "A: ___ he have a bike? — to‘ldiring.",
        answers = setOf("Does"),
        explanation = "Does he have a bike?"
    ),
    Question.Text(
        section = "6-mashq • Dialogni yakunlang",
        prompt = "B: No, he ___. — to‘ldiring.",
        answers = setOf("doesn’t"),
        explanation = "No, he doesn’t."
    ),
    Question.Text(
        section = "6-mashq • Dialogni yakunlang",
        prompt = "B: But he ___ a skateboard. — to‘ldiring.",
        answers = setOf("has"),
        explanation = "But he has a skateboard."
    ),
    Question.Text(
        section = "7-mashq • Xatolarni tuzating",
        prompt = "Xatoni tuzating: «Does she has a dog?»",
        answers = setOf("Does she have a dog?"),
        mode = TextMode.SENTENCE,
        explanation = "Does bilan asosiy shakl: have."
    ),
    Question.Text(
        section = "7-mashq • Xatolarni tuzating",
        prompt = "Xatoni tuzating: «He don’t have a watch.»",
        answers = setOf("He doesn’t have a watch."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: He doesn’t have a watch."
    ),
    Question.Text(
        section = "7-mashq • Xatolarni tuzating",
        prompt = "Xatoni tuzating: «They doesn’t have books.»",
        answers = setOf("They don’t have books."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: They don’t have books."
    ),
    Question.Text(
        section = "7-mashq • Xatolarni tuzating",
        prompt = "Xatoni tuzating: «Does your parents have a car?»",
        answers = setOf("Do your parents have a car?"),
        mode = TextMode.SENTENCE,
        explanation = "Ko‘plik bilan Do."
    ),
    Question.Text(
        section = "7-mashq • Xatolarni tuzating",
        prompt = "Xatoni tuzating: «She doesn’t has a sister.»",
        answers = setOf("She doesn’t have a sister."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: She doesn’t have a sister."
    )
)