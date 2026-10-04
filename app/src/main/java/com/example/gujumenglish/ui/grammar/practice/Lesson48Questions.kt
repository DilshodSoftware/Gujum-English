package com.example.gujumenglish.ui.grammar.practice

internal val lesson48Questions: List<Question> = listOf(
    Question.Matching(
        section = "1-mashq • Qarama-qarshi ma’noni toping",
        prompt = "Har bir so‘zning qarama-qarshi so‘zini toping.",
        pairs = listOf(
            "big" to "small",
            "hot" to "cold",
            "good" to "bad",
            "happy" to "sad"
        ),
        options = listOf("small", "cold", "bad", "sad"),
        explanation = "big—small; hot—cold; good—bad; happy—sad."
    ),
    Question.Matching(
        section = "1-mashq • Qarama-qarshi ma’noni toping",
        prompt = "Qolgan so‘zlarning qarama-qarshi so‘zini toping.",
        pairs = listOf(
            "clean" to "dirty",
            "fast" to "slow"
        ),
        options = listOf("dirty", "slow"),
        explanation = "clean—dirty; fast—slow."
    ),
    Question.Text(
        section = "2-mashq • Ot oldiga sifat qo‘ying",
        prompt = "a ___ house (big)",
        answers = setOf("big"),
        explanation = "To‘g‘ri shakl: a big house."
    ),
    Question.Text(
        section = "2-mashq • Ot oldiga sifat qo‘ying",
        prompt = "a ___ apple (green)",
        answers = setOf("green"),
        explanation = "To‘g‘ri shakl: a green apple."
    ),
    Question.Text(
        section = "2-mashq • Ot oldiga sifat qo‘ying",
        prompt = "an ___ car (old)",
        answers = setOf("old"),
        explanation = "To‘g‘ri shakl: an old car."
    ),
    Question.Text(
        section = "2-mashq • Ot oldiga sifat qo‘ying",
        prompt = "a ___ child (happy)",
        answers = setOf("happy"),
        explanation = "To‘g‘ri shakl: a happy child."
    ),
    Question.Text(
        section = "2-mashq • Ot oldiga sifat qo‘ying",
        prompt = "___ shoes (clean, ko‘plik)",
        answers = setOf("clean"),
        explanation = "Sifat o‘zgarmaydi: clean shoes."
    ),
    Question.Text(
        section = "3-mashq • Am, Is yoki Are + sifat",
        prompt = "I ___ tired.",
        answers = setOf("am"),
        explanation = "I bilan am."
    ),
    Question.Text(
        section = "3-mashq • Am, Is yoki Are + sifat",
        prompt = "My brothers ___ tall.",
        answers = setOf("are"),
        explanation = "Ko‘plik bilan are."
    ),
    Question.Text(
        section = "3-mashq • Am, Is yoki Are + sifat",
        prompt = "The soup ___ hot.",
        answers = setOf("is"),
        explanation = "Bitta narsa bilan is."
    ),
    Question.Text(
        section = "3-mashq • Am, Is yoki Are + sifat",
        prompt = "You ___ very kind.",
        answers = setOf("are"),
        explanation = "You bilan are."
    ),
    Question.Text(
        section = "3-mashq • Am, Is yoki Are + sifat",
        prompt = "This room ___ clean.",
        answers = setOf("is"),
        explanation = "Bitta narsa bilan is."
    ),
    Question.Text(
        section = "4-mashq • Sifat ko‘plikda o‘zgaradimi?",
        prompt = "one small cat → two ___ cats",
        answers = setOf("small"),
        explanation = "Sifat o‘zgarmaydi: two small cats."
    ),
    Question.Text(
        section = "4-mashq • Sifat ko‘plikda o‘zgaradimi?",
        prompt = "a red apple → red ___",
        answers = setOf("apples"),
        explanation = "Faqat ot ko‘plikka o‘tadi: red apples."
    ),
    Question.Choice(
        section = "4-mashq • Sifat ko‘plikda o‘zgaradimi?",
        prompt = "The houses are (big / bigs).",
        options = listOf("big", "bigs"),
        answer = "big",
        explanation = "Sifatga -s qo‘shilmaydi: big."
    ),
    Question.Choice(
        section = "4-mashq • Sifat ko‘plikda o‘zgaradimi?",
        prompt = "They have (new / news) books.",
        options = listOf("new", "news"),
        answer = "new",
        explanation = "Sifat: new books."
    ),
    Question.Ordering(
        section = "5-mashq • So‘z tartibini tuzating",
        prompt = "a / dog / black — gapni tuzing.",
        words = listOf("a", "black", "dog"),
        answer = "A black dog.",
        explanation = "To‘g‘ri tartib: a black dog."
    ),
    Question.Ordering(
        section = "5-mashq • So‘z tartibini tuzating",
        prompt = "is / the weather / cold — gapni tuzing.",
        words = listOf("The weather", "is", "cold."),
        answer = "The weather is cold.",
        explanation = "To‘g‘ri gap: The weather is cold."
    ),
    Question.Ordering(
        section = "5-mashq • So‘z tartibini tuzating",
        prompt = "cars / fast / are / these — gapni tuzing.",
        words = listOf("These", "cars", "are", "fast."),
        answer = "These cars are fast.",
        explanation = "To‘g‘ri gap: These cars are fast."
    ),
    Question.Ordering(
        section = "5-mashq • So‘z tartibini tuzating",
        prompt = "an / old / house — gapni tuzing.",
        words = listOf("an", "old", "house"),
        answer = "An old house.",
        explanation = "To‘g‘ri tartib: an old house."
    ),
    Question.Choice(
        section = "6-mashq • Sifatning ma’nosini kontekstdan toping",
        prompt = "an old man — old nimani bildiradi?",
        options = listOf("yoshi katta/keksa", "eski"),
        answer = "yoshi katta/keksa",
        explanation = "Odamda old = yoshi katta."
    ),
    Question.Choice(
        section = "6-mashq • Sifatning ma’nosini kontekstdan toping",
        prompt = "an old phone — old nimani bildiradi?",
        options = listOf("yoshi katta/keksa", "eski"),
        answer = "eski",
        explanation = "Narsada old = eski."
    ),
    Question.Choice(
        section = "6-mashq • Sifatning ma’nosini kontekstdan toping",
        prompt = "a long road — long nimani bildiradi?",
        options = listOf("uzun", "qiyin"),
        answer = "uzun",
        explanation = "Yo‘l haqida: uzun."
    ),
    Question.Choice(
        section = "6-mashq • Sifatning ma’nosini kontekstdan toping",
        prompt = "a difficult test — difficult nimani bildiradi?",
        options = listOf("uzun", "qiyin"),
        answer = "qiyin",
        explanation = "Imtihon haqida: qiyin."
    )
)