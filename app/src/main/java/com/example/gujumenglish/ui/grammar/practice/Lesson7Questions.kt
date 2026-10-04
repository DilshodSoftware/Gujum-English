package com.example.gujumenglish.ui.grammar.practice

internal val lesson7Questions: List<Question> = listOf(
    Question.Matching(
        section = "1-mashq • Nounmi yoki Pronounmi?",
        prompt = "Har bir so‘zni to‘g‘ri turkum bilan bog‘lang.",
        pairs = listOf(
            "teacher" to "noun",
            "she" to "pronoun",
            "Tashkent" to "noun",
            "they" to "pronoun",
            "book" to "noun",
            "we" to "pronoun",
            "cat" to "noun",
            "I" to "pronoun",
            "school" to "noun"
        ),
        options = listOf("noun", "pronoun"),
        explanation = "Otlar: teacher, Tashkent, book, cat, school. Olmoshlar: she, they, we, I."
    ),
    Question.Choice(
        section = "2-mashq • Olmoshni ismga moslang",
        prompt = "Ali → qaysi olmosh?",
        options = listOf("he", "she"),
        answer = "he",
        explanation = "Ali erkak ismi, shuning uchun he."
    ),
    Question.Choice(
        section = "2-mashq • Olmoshni ismga moslang",
        prompt = "Madina → qaysi olmosh?",
        options = listOf("he", "she"),
        answer = "she",
        explanation = "Madina ayol ismi, shuning uchun she."
    ),
    Question.Choice(
        section = "2-mashq • Olmoshni ismga moslang",
        prompt = "a book → qaysi olmosh?",
        options = listOf("it", "they"),
        answer = "it",
        explanation = "Bitta narsa uchun it ishlatiladi."
    ),
    Question.Choice(
        section = "2-mashq • Olmoshni ismga moslang",
        prompt = "Ali and I → qaysi olmosh?",
        options = listOf("we", "they"),
        answer = "we",
        explanation = "Men guruh ichidaman, shuning uchun we."
    ),
    Question.Choice(
        section = "2-mashq • Olmoshni ismga moslang",
        prompt = "Ali and Sam → qaysi olmosh?",
        options = listOf("we", "they"),
        answer = "they",
        explanation = "Men guruhda yo‘qman, shuning uchun they."
    ),
    Question.Choice(
        section = "2-mashq • Olmoshni ismga moslang",
        prompt = "you and your friends → qaysi olmosh?",
        options = listOf("you", "we"),
        answer = "you",
        explanation = "Murojaat qilinayotgan guruh — you o‘zgarishsiz qoladi."
    ),
    Question.Choice(
        section = "3-mashq • Takrorlangan ismni almashtiring",
        prompt = "«Ali is a student. Ali is happy.» — ikkinchi gapda qaysi olmosh?",
        options = listOf("he", "she", "it", "they"),
        answer = "he",
        explanation = "Ali uchun he: He is happy."
    ),
    Question.Choice(
        section = "3-mashq • Takrorlangan ismni almashtiring",
        prompt = "«Sara is at home. Sara is tired.» — ikkinchi gapda qaysi olmosh?",
        options = listOf("he", "she", "it", "they"),
        answer = "she",
        explanation = "Sara uchun she: She is tired."
    ),
    Question.Choice(
        section = "3-mashq • Takrorlangan ismni almashtiring",
        prompt = "«The book is new. The book is red.» — ikkinchi gapda qaysi olmosh?",
        options = listOf("he", "she", "it", "they"),
        answer = "it",
        explanation = "Kitob uchun it: It is red."
    ),
    Question.Choice(
        section = "3-mashq • Takrorlangan ismni almashtiring",
        prompt = "«Ali and Madina are friends. Ali and Madina are students.» — qaysi olmosh?",
        options = listOf("we", "they"),
        answer = "they",
        explanation = "Ikki kishi uchun they: They are students."
    ),
    Question.Choice(
        section = "3-mashq • Takrorlangan ismni almashtiring",
        prompt = "«My sister and I are here. My sister and I are ready.» — qaysi olmosh?",
        options = listOf("we", "they"),
        answer = "we",
        explanation = "Men guruh ichidaman: We are ready."
    ),
    Question.Text(
        section = "4-mashq • Gapdagi subjectni aniqlang",
        prompt = "«She is a teacher.» — subjectni yozing.",
        answers = setOf("She"),
        mode = TextMode.SENTENCE,
        explanation = "Bu gapning egasi: She."
    ),
    Question.Text(
        section = "4-mashq • Gapdagi subjectni aniqlang",
        prompt = "«The dog is small.» — subjectni yozing.",
        answers = setOf("The dog"),
        mode = TextMode.SENTENCE,
        explanation = "Bu gapning egasi: The dog."
    ),
    Question.Text(
        section = "4-mashq • Gapdagi subjectni aniqlang",
        prompt = "«They are at school.» — subjectni yozing.",
        answers = setOf("They"),
        mode = TextMode.SENTENCE,
        explanation = "Bu gapning egasi: They."
    ),
    Question.Text(
        section = "4-mashq • Gapdagi subjectni aniqlang",
        prompt = "«My brother and I are friends.» — subjectni yozing.",
        answers = setOf("My brother and I"),
        mode = TextMode.SENTENCE,
        explanation = "Bu gapning egasi: My brother and I."
    ),
    Question.Text(
        section = "5-mashq • Atoqli otlarni yozing",
        prompt = "«ali, madina, tashkent, uzbekistan» — to‘g‘ri yozing.",
        answers = setOf("Ali, Madina, Tashkent, Uzbekistan."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri yozuv: Ali, Madina, Tashkent, Uzbekistan."
    ),
    Question.TrueFalse(
        section = "6-mashq • To‘g‘ri yoki noto‘g‘ri",
        prompt = "book — noun.",
        answer = true,
        explanation = "Bu gap to‘g‘ri: book — ot."
    ),
    Question.TrueFalse(
        section = "6-mashq • To‘g‘ri yoki noto‘g‘ri",
        prompt = "they — pronoun.",
        answer = true,
        explanation = "Bu gap to‘g‘ri: they — olmosh."
    ),
    Question.TrueFalse(
        section = "6-mashq • To‘g‘ri yoki noto‘g‘ri",
        prompt = "Ali and I o‘rniga they ishlatamiz.",
        answer = false,
        explanation = "Bu gap noto‘g‘ri: Ali and I o‘rniga we ishlatiladi."
    ),
    Question.TrueFalse(
        section = "6-mashq • To‘g‘ri yoki noto‘g‘ri",
        prompt = "I har doim katta harf bilan yoziladi.",
        answer = true,
        explanation = "Bu gap to‘g‘ri: I olmoshi doim katta yoziladi."
    )
)
