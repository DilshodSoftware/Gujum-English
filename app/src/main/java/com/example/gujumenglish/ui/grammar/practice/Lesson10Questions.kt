package com.example.gujumenglish.ui.grammar.practice

internal val lesson10Questions: List<Question> = listOf(
    Question.Text(
        section = "1-mashq • Am, Is yoki Are?",
        prompt = "«I ___ from Uzbekistan.» — to‘g‘ri shaklni yozing.",
        answers = setOf("am"),
        explanation = "I olmoshi doim am bilan keladi."
    ),
    Question.Text(
        section = "1-mashq • Am, Is yoki Are?",
        prompt = "«My brother ___ twelve years old.» — to‘g‘ri shaklni yozing.",
        answers = setOf("is"),
        explanation = "My brother — birlik, shuning uchun is."
    ),
    Question.Text(
        section = "1-mashq • Am, Is yoki Are?",
        prompt = "«You ___ a good friend.» — to‘g‘ri shaklni yozing.",
        answers = setOf("are"),
        explanation = "You olmoshi doim are bilan keladi."
    ),
    Question.Text(
        section = "1-mashq • Am, Is yoki Are?",
        prompt = "«The books ___ on the desk.» — to‘g‘ri shaklni yozing.",
        answers = setOf("are"),
        explanation = "The books — ko‘plik, shuning uchun are."
    ),
    Question.Text(
        section = "1-mashq • Am, Is yoki Are?",
        prompt = "«It ___ a small dog.» — to‘g‘ri shaklni yozing.",
        answers = setOf("is"),
        explanation = "It olmoshi is bilan keladi."
    ),
    Question.Text(
        section = "1-mashq • Am, Is yoki Are?",
        prompt = "«Sara and I ___ classmates.» — to‘g‘ri shaklni yozing.",
        answers = setOf("are"),
        explanation = "Sara and I — ko‘plik, shuning uchun are."
    ),
    Question.Text(
        section = "1-mashq • Am, Is yoki Are?",
        prompt = "«The weather ___ nice today.» — to‘g‘ri shaklni yozing.",
        answers = setOf("is"),
        explanation = "The weather — birlik, shuning uchun is."
    ),
    Question.Text(
        section = "1-mashq • Am, Is yoki Are?",
        prompt = "«Ali ___ at home.» — to‘g‘ri shaklni yozing.",
        answers = setOf("is"),
        explanation = "Ali — birlik ism, shuning uchun is."
    ),
    Question.Text(
        section = "1-mashq • Am, Is yoki Are?",
        prompt = "«We ___ ready for the lesson.» — to‘g‘ri shaklni yozing.",
        answers = setOf("are"),
        explanation = "We olmoshi are bilan keladi."
    ),
    Question.Text(
        section = "1-mashq • Am, Is yoki Are?",
        prompt = "«My parents ___ teachers.» — to‘g‘ri shaklni yozing.",
        answers = setOf("are"),
        explanation = "My parents — ko‘plik, shuning uchun are."
    ),
    Question.Matching(
        section = "2-mashq • Ega va fe’lni juftlang",
        prompt = "Har bir ega uchun mos to be shaklini bog‘lang.",
        pairs = listOf(
            "I" to "am",
            "he" to "is",
            "we" to "are",
            "the cat" to "is",
            "you" to "are",
            "they" to "are",
            "my sisters" to "are"
        ),
        options = listOf("am", "is", "are"),
        explanation = "I → am, he/she/it va birlik → is, you/we/they va ko‘plik → are."
    ),
    Question.Ordering(
        section = "3-mashq • Gap bo‘laklarini tartiblang",
        prompt = "So‘zlardan to‘g‘ri gap tuzing: happy / am / I",
        words = listOf("happy", "am", "I"),
        answer = "I am happy.",
        explanation = "To‘g‘ri tartib: I am happy."
    ),
    Question.Ordering(
        section = "3-mashq • Gap bo‘laklarini tartiblang",
        prompt = "So‘zlardan to‘g‘ri gap tuzing: a doctor / is / She",
        words = listOf("a doctor", "is", "She"),
        answer = "She is a doctor.",
        explanation = "To‘g‘ri tartib: She is a doctor."
    ),
    Question.Ordering(
        section = "3-mashq • Gap bo‘laklarini tartiblang",
        prompt = "So‘zlardan to‘g‘ri gap tuzing: at school / are / They",
        words = listOf("at school", "are", "They"),
        answer = "They are at school.",
        explanation = "To‘g‘ri tartib: They are at school."
    ),
    Question.Ordering(
        section = "3-mashq • Gap bo‘laklarini tartiblang",
        prompt = "So‘zlardan to‘g‘ri gap tuzing: new / The phone / is",
        words = listOf("new", "The phone", "is"),
        answer = "The phone is new.",
        explanation = "To‘g‘ri tartib: The phone is new."
    ),
    Question.Ordering(
        section = "3-mashq • Gap bo‘laklarini tartiblang",
        prompt = "So‘zlardan to‘g‘ri gap tuzing: friends / We / are",
        words = listOf("friends", "We", "are"),
        answer = "We are friends.",
        explanation = "To‘g‘ri tartib: We are friends."
    ),
    Question.Ordering(
        section = "3-mashq • Gap bo‘laklarini tartiblang",
        prompt = "So‘zlardan to‘g‘ri gap tuzing: my teacher / You / are",
        words = listOf("my teacher", "You", "are"),
        answer = "You are my teacher.",
        explanation = "To‘g‘ri tartib: You are my teacher."
    ),
    Question.Text(
        section = "4-mashq • Xatoni topib tuzating",
        prompt = "Xatoni tuzating: «I is a student.»",
        answers = setOf("I am a student."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: I am a student."
    ),
    Question.Text(
        section = "4-mashq • Xatoni topib tuzating",
        prompt = "Xatoni tuzating: «They is at home.»",
        answers = setOf("They are at home."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: They are at home."
    ),
    Question.Text(
        section = "4-mashq • Xatoni topib tuzating",
        prompt = "Xatoni tuzating: «My mother are kind.»",
        answers = setOf("My mother is kind."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: My mother is kind."
    ),
    Question.Text(
        section = "4-mashq • Xatoni topib tuzating",
        prompt = "Xatoni tuzating: «We am happy.»",
        answers = setOf("We are happy."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: We are happy."
    ),
    Question.Text(
        section = "4-mashq • Xatoni topib tuzating",
        prompt = "Xatoni tuzating: «The dogs is small.»",
        answers = setOf("The dogs are small."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: The dogs are small."
    ),
    Question.Choice(
        section = "5-mashq • Kim? Qanday? Qayerda?",
        prompt = "«I am a student.» — gapdagi ma’lumot turi?",
        options = listOf("kim?", "qanday?", "qayerda?"),
        answer = "kim?",
        explanation = "a student — kimligini bildiradi."
    ),
    Question.Choice(
        section = "5-mashq • Kim? Qanday? Qayerda?",
        prompt = "«The soup is hot.» — gapdagi ma’lumot turi?",
        options = listOf("kim?", "qanday?", "qayerda?"),
        answer = "qanday?",
        explanation = "hot — qandayligini bildiradi."
    ),
    Question.Choice(
        section = "5-mashq • Kim? Qanday? Qayerda?",
        prompt = "«They are in the garden.» — gapdagi ma’lumot turi?",
        options = listOf("kim?", "qanday?", "qayerda?"),
        answer = "qayerda?",
        explanation = "in the garden — qayerdaligini bildiradi."
    ),
    Question.Choice(
        section = "5-mashq • Kim? Qanday? Qayerda?",
        prompt = "«He is a driver.» — gapdagi ma’lumot turi?",
        options = listOf("kim?", "qanday?", "qayerda?"),
        answer = "kim?",
        explanation = "a driver — kimligini bildiradi."
    ),
    Question.Choice(
        section = "5-mashq • Kim? Qanday? Qayerda?",
        prompt = "«We are tired.» — gapdagi ma’lumot turi?",
        options = listOf("kim?", "qanday?", "qayerda?"),
        answer = "qanday?",
        explanation = "tired — qandayligini bildiradi."
    ),
    Question.Ordering(
        section = "6-mashq • O‘zbekchadan inglizchaga",
        prompt = "«Men xursandman.» — so‘zlardan gap tuzing: happy / am / I",
        words = listOf("happy", "am", "I"),
        answer = "I am happy.",
        explanation = "To‘g‘ri tartib: I am happy."
    ),
    Question.Ordering(
        section = "6-mashq • O‘zbekchadan inglizchaga",
        prompt = "«U (qiz) uyda.» — so‘zlardan gap tuzing: at home / is / She",
        words = listOf("at home", "is", "She"),
        answer = "She is at home.",
        explanation = "To‘g‘ri tartib: She is at home."
    ),
    Question.Ordering(
        section = "6-mashq • O‘zbekchadan inglizchaga",
        prompt = "«Biz do‘stmiz.» — so‘zlardan gap tuzing: friends / are / We",
        words = listOf("friends", "are", "We"),
        answer = "We are friends.",
        explanation = "To‘g‘ri tartib: We are friends."
    ),
    Question.Ordering(
        section = "6-mashq • O‘zbekchadan inglizchaga",
        prompt = "«Mushuk kichkina.» — so‘zlardan gap tuzing: is / The cat / small",
        words = listOf("is", "The cat", "small"),
        answer = "The cat is small.",
        explanation = "To‘g‘ri tartib: The cat is small."
    ),
    Question.Ordering(
        section = "6-mashq • O‘zbekchadan inglizchaga",
        prompt = "«Siz tayyorsiz.» — so‘zlardan gap tuzing: ready / are / You",
        words = listOf("ready", "are", "You"),
        answer = "You are ready.",
        explanation = "To‘g‘ri tartib: You are ready."
    )
)
