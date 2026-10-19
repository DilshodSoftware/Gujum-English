package com.example.gujumenglish.ui.grammar.practice

internal val lesson1Questions: List<Question> = listOf(
    Question.Matching(
        section = "1-mashq • So‘zni ma’nosi bilan moslang",
        prompt = "Inglizcha so‘zni o‘zbekcha ma’nosi bilan bog‘lang.",
        pairs = listOf("apple" to "olma", "book" to "kitob", "cat" to "mushuk", "dog" to "it"),
        options = listOf("olma", "kitob", "mushuk", "it"),
        explanation = "apple — olma, book — kitob, cat — mushuk, dog — it."
    ),
    Question.Choice(
        section = "1-mashq • So‘zni ma’nosi bilan moslang",
        prompt = "«do‘st» qaysi so‘z?",
        options = listOf("friend", "water", "phone"),
        answer = "friend",
        explanation = "do‘st — friend."
    ),
    Question.Choice(
        section = "1-mashq • So‘zni ma’nosi bilan moslang",
        prompt = "«stul» qaysi so‘z?",
        options = listOf("chair", "school", "park"),
        answer = "chair",
        explanation = "stul — chair."
    ),
    Question.Matching(
        section = "1-mashq • So‘zni ma’nosi bilan moslang",
        prompt = "Qolgan so‘zlarni o‘zbekcha ma’nosi bilan bog‘lang.",
        pairs = listOf(
            "teacher" to "o‘qituvchi",
            "school" to "maktab",
            "water" to "suv",
            "friend" to "do‘st",
            "chair" to "stul",
            "phone" to "telefon"
        ),
        options = listOf("o‘qituvchi", "maktab", "suv", "do‘st", "stul", "telefon"),
        explanation = "teacher — o‘qituvchi, school — maktab, water — suv."
    ),
    Question.MultiChoice(
        section = "2-mashq • So‘zlarni guruhlarga ajrating",
        prompt = "Odamlarni bildiruvchi so‘zlarni belgilang.",
        options = listOf("mother", "cat", "school", "teacher"),
        answers = setOf("mother", "teacher"),
        explanation = "Odamlar: mother, teacher."
    ),
    Question.MultiChoice(
        section = "2-mashq • So‘zlarni guruhlarga ajrating",
        prompt = "Joylarni bildiruvchi so‘zlarni belgilang.",
        options = listOf("school", "pen", "park", "book"),
        answers = setOf("school", "park"),
        explanation = "Joylar: school, park."
    ),
    Question.MultiChoice(
        section = "2-mashq • So‘zlarni guruhlarga ajrating",
        prompt = "Hayvonlarni bildiruvchi so‘zlarni belgilang.",
        options = listOf("cat", "school", "dog", "pen"),
        answers = setOf("cat", "dog"),
        explanation = "Hayvonlar: cat, dog."
    ),
    Question.MultiChoice(
        section = "2-mashq • So‘zlarni guruhlarga ajrating",
        prompt = "Narsalarni bildiruvchi so‘zlarni belgilang.",
        options = listOf("pen", "teacher", "book", "park"),
        answers = setOf("pen", "book"),
        explanation = "Narsalar: pen, book."
    ),
    Question.Text(
        section = "3-mashq • O‘zbekchasini yozing",
        prompt = "sun = ...",
        answers = setOf("quyosh"),
        explanation = "sun — quyosh."
    ),
    Question.Text(
        section = "3-mashq • O‘zbekchasini yozing",
        prompt = "tree = ...",
        answers = setOf("daraxt"),
        explanation = "tree — daraxt."
    ),
    Question.Text(
        section = "3-mashq • O‘zbekchasini yozing",
        prompt = "rain = ...",
        answers = setOf("yomg'ir"),
        explanation = "rain — yomg‘ir."
    ),
    Question.Text(
        section = "3-mashq • O‘zbekchasini yozing",
        prompt = "house = ...",
        answers = setOf("uy"),
        explanation = "house — uy."
    ),
    Question.Text(
        section = "3-mashq • O‘zbekchasini yozing",
        prompt = "umbrella = ...",
        answers = setOf("soyabon"),
        explanation = "umbrella — soyabon."
    ),
    Question.Text(
        section = "3-mashq • O‘zbekchasini yozing",
        prompt = "yellow = ...",
        answers = setOf("sariq"),
        explanation = "yellow — sariq."
    ),
    Question.Text(
        section = "3-mashq • O‘zbekchasini yozing",
        prompt = "key = ...",
        answers = setOf("kalit"),
        explanation = "key — kalit."
    ),
    Question.Text(
        section = "3-mashq • O‘zbekchasini yozing",
        prompt = "queen = ...",
        answers = setOf("malika"),
        explanation = "queen — malika."
    ),
    Question.Choice(
        section = "4-mashq • Ta’rifga mos so‘zni tanlang",
        prompt = "«Oy» qaysi so‘z?",
        options = listOf("moon", "sun", "tree"),
        answer = "moon",
        explanation = "oy — moon."
    ),
    Question.Choice(
        section = "4-mashq • Ta’rifga mos so‘zni tanlang",
        prompt = "«Kitob» qaysi so‘z?",
        options = listOf("book", "box", "pen"),
        answer = "book",
        explanation = "kitob — book."
    ),
    Question.Choice(
        section = "4-mashq • Ta’rifga mos so‘zni tanlang",
        prompt = "«Suv» qaysi so‘z?",
        options = listOf("water", "rain", "juice"),
        answer = "water",
        explanation = "suv — water."
    ),
    Question.Choice(
        section = "4-mashq • Ta’rifga mos so‘zni tanlang",
        prompt = "«Qiz» qaysi so‘z?",
        options = listOf("girl", "boy", "teacher"),
        answer = "girl",
        explanation = "qiz — girl."
    ),
    Question.Choice(
        section = "4-mashq • Ta’rifga mos so‘zni tanlang",
        prompt = "«Maktab» qaysi so‘z?",
        options = listOf("school", "chair", "park"),
        answer = "school",
        explanation = "maktab — school."
    ),
    Question.Matching(
        section = "5-mashq • Iboralarni tushuning",
        prompt = "Inglizcha gapni o‘zbekcha tarjimasi bilan bog‘lang.",
        pairs = listOf(
            "I am a student." to "Men o‘quvchiman.",
            "Monday is my favorite day." to "Dushanba mening sevimli kunim.",
            "My teacher speaks English." to "O‘qituvchim ingliz tilida gapiradi."
        ),
        options = listOf(
            "Men o‘quvchiman.",
            "Dushanba mening sevimli kunim.",
            "O‘qituvchim ingliz tilida gapiradi."
        ),
        explanation = "I am a student. — Men o‘quvchiman."
    ),
    Question.Ordering(
        section = "5-mashq • So‘zlardan gap tuzing",
        prompt = "So‘zlardan to‘g‘ri gap tuzing: is / Monday / my / favorite / day",
        words = listOf("is", "Monday", "my", "favorite", "day"),
        answer = "Monday is my favorite day.",
        explanation = "To‘g‘ri tartib: Monday is my favorite day."
    )
)
