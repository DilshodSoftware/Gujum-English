package com.example.gujumenglish.ui.grammar.practice

internal val lesson9Questions: List<Question> = listOf(
    Question.Matching(
        section = "1-mashq • Olmoshlarni tarjimasi bilan bog‘lang",
        prompt = "Har bir olmoshni o‘zbekcha ma’nosi bilan bog‘lang.",
        pairs = listOf(
            "I" to "men",
            "you" to "sen / siz / sizlar",
            "he" to "u — erkak",
            "she" to "u — ayol",
            "it" to "u — narsa",
            "we" to "biz",
            "they" to "ular"
        ),
        options = listOf(
            "men",
            "sen / siz / sizlar",
            "u — erkak",
            "u — ayol",
            "u — narsa",
            "biz",
            "ular"
        ),
        explanation = "I—men, you—sen/siz/sizlar, he—u (erkak), she—u (ayol), it—u (narsa), we—biz, they—ular."
    ),
    Question.Choice(
        section = "2-mashq • Mos subject pronounni tanlang",
        prompt = "«Tom is a boy.» — qaysi olmosh?",
        options = listOf("He", "She"),
        answer = "He",
        explanation = "Tom — o‘g‘il bola ismi, shuning uchun He."
    ),
    Question.Choice(
        section = "2-mashq • Mos subject pronounni tanlang",
        prompt = "«Sara is my friend.» — qaysi olmosh?",
        options = listOf("He", "She"),
        answer = "She",
        explanation = "Sara — qiz ismi, shuning uchun She."
    ),
    Question.Choice(
        section = "2-mashq • Mos subject pronounni tanlang",
        prompt = "«The phone is new.» — qaysi olmosh?",
        options = listOf("It", "They"),
        answer = "It",
        explanation = "Bitta narsa uchun It."
    ),
    Question.Choice(
        section = "2-mashq • Mos subject pronounni tanlang",
        prompt = "«My parents are at home.» — qaysi olmosh?",
        options = listOf("We", "They"),
        answer = "They",
        explanation = "Gapirayotgan odam guruhda yo‘q: They."
    ),
    Question.Choice(
        section = "2-mashq • Mos subject pronounni tanlang",
        prompt = "«You and I are classmates.» — qaysi olmosh?",
        options = listOf("We", "They"),
        answer = "We",
        explanation = "Men guruh ichidaman: We."
    ),
    Question.Choice(
        section = "2-mashq • Mos subject pronounni tanlang",
        prompt = "«I am talking to you and your sister.» — qaysi olmosh bilan murojaat qilinadi?",
        options = listOf("You", "We"),
        answer = "You",
        explanation = "Murojaat qilinayotganlar — You o‘zgarishsiz qoladi."
    ),
    Question.Choice(
        section = "3-mashq • Ismni olmosh bilan almashtiring",
        prompt = "«Ali is a student. Ali is happy.» — ikkinchi gap?",
        options = listOf("He is happy.", "She is happy.", "It is happy."),
        answer = "He is happy.",
        explanation = "Ali uchun He: He is happy."
    ),
    Question.Choice(
        section = "3-mashq • Ismni olmosh bilan almashtiring",
        prompt = "«Malika is at home. Malika is tired.» — ikkinchi gap?",
        options = listOf("He is tired.", "She is tired.", "It is tired."),
        answer = "She is tired.",
        explanation = "Malika uchun She: She is tired."
    ),
    Question.Choice(
        section = "3-mashq • Ismni olmosh bilan almashtiring",
        prompt = "«The book is new. The book is on the table.» — ikkinchi gap?",
        options = listOf("He is on the table.", "She is on the table.", "It is on the table."),
        answer = "It is on the table.",
        explanation = "Kitob uchun It: It is on the table."
    ),
    Question.Choice(
        section = "3-mashq • Ismni olmosh bilan almashtiring",
        prompt = "«The boys are friends. The boys are here.» — ikkinchi gap?",
        options = listOf("We are here.", "They are here."),
        answer = "They are here.",
        explanation = "Ko‘plik uchun They: They are here."
    ),
    Question.Choice(
        section = "3-mashq • Ismni olmosh bilan almashtiring",
        prompt = "«My brother and I are students. My brother and I are ready.» — ikkinchi gap?",
        options = listOf("We are ready.", "They are ready."),
        answer = "We are ready.",
        explanation = "Men guruh ichidaman: We are ready."
    ),
    Question.Choice(
        section = "4-mashq • We yoki They?",
        prompt = "Ali and I = ...",
        options = listOf("we", "they"),
        answer = "we",
        explanation = "Ali and I — men bor, demak we."
    ),
    Question.Choice(
        section = "4-mashq • We yoki They?",
        prompt = "Ali and Madina (men ular bilan gaplashmayapman) = ...",
        options = listOf("we", "they"),
        answer = "they",
        explanation = "Men guruhda yo‘qman, demak they."
    ),
    Question.Choice(
        section = "4-mashq • We yoki They?",
        prompt = "My friends and I = ...",
        options = listOf("we", "they"),
        answer = "we",
        explanation = "Men guruh ichidaman, demak we."
    ),
    Question.Choice(
        section = "4-mashq • We yoki They?",
        prompt = "My friends (men boshqa joydaman) = ...",
        options = listOf("we", "they"),
        answer = "they",
        explanation = "Men guruhda yo‘qman, demak they."
    ),
    Question.Text(
        section = "5-mashq • I katta harf bilan yoziladimi?",
        prompt = "To‘g‘ri yozing: «my sister and i are friends.»",
        answers = setOf("My sister and I are friends."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri yozuv: My sister and I are friends."
    ),
    Question.Text(
        section = "5-mashq • I katta harf bilan yoziladimi?",
        prompt = "To‘g‘ri yozing: «i am from uzbekistan.»",
        answers = setOf("I am from Uzbekistan."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri yozuv: I am from Uzbekistan."
    ),
    Question.Text(
        section = "5-mashq • I katta harf bilan yoziladimi?",
        prompt = "To‘g‘ri yozing: «ali and i are students.»",
        answers = setOf("Ali and I are students."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri yozuv: Ali and I are students."
    ),
    Question.TrueFalse(
        section = "6-mashq • To‘g‘ri yoki noto‘g‘ri",
        prompt = "He odatda erkak yoki o‘g‘il bola haqida ishlatiladi.",
        answer = true,
        explanation = "Bu gap to‘g‘ri."
    ),
    Question.TrueFalse(
        section = "6-mashq • To‘g‘ri yoki noto‘g‘ri",
        prompt = "She odatda ayol yoki qiz haqida ishlatiladi.",
        answer = true,
        explanation = "Bu gap to‘g‘ri."
    ),
    Question.TrueFalse(
        section = "6-mashq • To‘g‘ri yoki noto‘g‘ri",
        prompt = "We gapirayotgan odamni o‘z ichiga oladi.",
        answer = true,
        explanation = "Bu gap to‘g‘ri: we — men + boshqalar."
    ),
    Question.TrueFalse(
        section = "6-mashq • To‘g‘ri yoki noto‘g‘ri",
        prompt = "They faqat narsalar uchun ishlatiladi.",
        answer = false,
        explanation = "Bu gap noto‘g‘ri: they odamlar va narsalar uchun ishlatiladi."
    )
)
