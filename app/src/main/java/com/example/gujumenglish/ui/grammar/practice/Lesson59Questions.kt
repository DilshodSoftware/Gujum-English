package com.example.gujumenglish.ui.grammar.practice

internal val lesson59Questions: List<Question> = listOf(
    Question.Text(
        section = "1-mashq • Sifatning qiyosiy shaklini yozing",
        prompt = "tall → ___",
        answers = setOf("taller"),
        explanation = "Qisqa sifat + er: taller."
    ),
    Question.Text(
        section = "1-mashq • Sifatning qiyosiy shaklini yozing",
        prompt = "nice → ___",
        answers = setOf("nicer"),
        explanation = "Qisqa sifat + er: nicer."
    ),
    Question.Text(
        section = "1-mashq • Sifatning qiyosiy shaklini yozing",
        prompt = "happy → ___",
        answers = setOf("happier"),
        explanation = "y → ier: happier."
    ),
    Question.Text(
        section = "1-mashq • Sifatning qiyosiy shaklini yozing",
        prompt = "big → ___",
        answers = setOf("bigger"),
        explanation = "Qisqa sifat + er: bigger."
    ),
    Question.Text(
        section = "1-mashq • Sifatning qiyosiy shaklini yozing",
        prompt = "expensive → ___",
        answers = setOf("more expensive"),
        explanation = "Uzun sifat + more: more expensive."
    ),
    Question.Text(
        section = "1-mashq • Sifatning qiyosiy shaklini yozing",
        prompt = "good → ___",
        answers = setOf("better"),
        explanation = "Istisno: better."
    ),
    Question.Text(
        section = "1-mashq • Sifatning qiyosiy shaklini yozing",
        prompt = "bad → ___",
        answers = setOf("worse"),
        explanation = "Istisno: worse."
    ),
    Question.Text(
        section = "1-mashq • Sifatning qiyosiy shaklini yozing",
        prompt = "easy → ___",
        answers = setOf("easier"),
        explanation = "y → ier: easier."
    ),
    Question.Text(
        section = "2-mashq • Qiyoslash gapini to‘ldiring",
        prompt = "A train is ___ (fast) than a bicycle.",
        answers = setOf("faster"),
        explanation = "To‘g‘ri shakl: faster."
    ),
    Question.Text(
        section = "2-mashq • Qiyoslash gapini to‘ldiring",
        prompt = "This box is ___ (heavy) than that box.",
        answers = setOf("heavier"),
        explanation = "To‘g‘ri shakl: heavier."
    ),
    Question.Text(
        section = "2-mashq • Qiyoslash gapini to‘ldiring",
        prompt = "My room is ___ (small) than yours.",
        answers = setOf("smaller"),
        explanation = "To‘g‘ri shakl: smaller."
    ),
    Question.Text(
        section = "2-mashq • Qiyoslash gapini to‘ldiring",
        prompt = "This story is ___ (interesting) than the film.",
        answers = setOf("more interesting"),
        explanation = "Uzun sifat: more interesting."
    ),
    Question.Text(
        section = "2-mashq • Qiyoslash gapini to‘ldiring",
        prompt = "Today is ___ (good) than yesterday.",
        answers = setOf("better"),
        explanation = "Istisno: better."
    ),
    Question.Choice(
        section = "3-mashq • Qaysi qoida ishlaydi?",
        prompt = "large → larger — qaysi qoida?",
        options = listOf("e bilan tugaydi", "y o‘zgaradi"),
        answer = "e bilan tugaydi",
        explanation = "e bilan tugagan sifat + r: larger."
    ),
    Question.Choice(
        section = "3-mashq • Qaysi qoida ishlaydi?",
        prompt = "busy → busier — qaysi qoida?",
        options = listOf("undosh+y", "unli+y"),
        answer = "undosh+y",
        explanation = "undosh + y: y → ier: busier."
    ),
    Question.Choice(
        section = "3-mashq • Qaysi qoida ishlaydi?",
        prompt = "hot → hotter — qaysi qoida?",
        options = listOf("oxirgi undosh ikkilanadi", "more ishlatiladi"),
        answer = "oxirgi undosh ikkilanadi",
        explanation = "t ikkilanadi: hotter."
    ),
    Question.Choice(
        section = "3-mashq • Qaysi qoida ishlaydi?",
        prompt = "beautiful → more beautiful — qaysi qoida?",
        options = listOf("-er", "more"),
        answer = "more",
        explanation = "Uzun sifat: more."
    ),
    Question.Ordering(
        section = "4-mashq • Than bilan gapni to‘g‘ri tartiblang",
        prompt = "than / A car / faster / a bicycle / is — gapni tuzing.",
        words = listOf("A car", "is", "faster", "than", "a bicycle."),
        answer = "A car is faster than a bicycle.",
        explanation = "To‘g‘ri gap: A car is faster than a bicycle."
    ),
    Question.Ordering(
        section = "4-mashq • Than bilan gapni to‘g‘ri tartiblang",
        prompt = "is / this bag / than / heavier / mine — gapni tuzing.",
        words = listOf("This bag", "is", "heavier", "than", "mine."),
        answer = "This bag is heavier than mine.",
        explanation = "To‘g‘ri gap: This bag is heavier than mine."
    ),
    Question.Ordering(
        section = "4-mashq • Than bilan gapni to‘g‘ri tartiblang",
        prompt = "than / more beautiful / this flower / that one / is — gapni tuzing.",
        words = listOf("This flower", "is", "more beautiful", "than", "that one."),
        answer = "This flower is more beautiful than that one.",
        explanation = "To‘g‘ri gap: This flower is more beautiful than that one."
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «My house is more bigger than yours.»",
        answers = setOf("My house is bigger than yours."),
        mode = TextMode.SENTENCE,
        explanation = "Bir sifatda ham -er, ham more ishlatilmaydi."
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «This test is easyer.»",
        answers = setOf("This test is easier."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: easier."
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «She is beautifuller than her sister.»",
        answers = setOf("She is more beautiful than her sister."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: more beautiful."
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «Today is more better.»",
        answers = setOf("Today is better."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: better."
    ),
    Question.Ordering(
        section = "6-mashq • O‘zingiz taqqoslang",
        prompt = "Ikki narsani hajm bo‘yicha taqqoslang (katta/kichik).",
        words = listOf("A bus", "is", "bigger", "than", "a car."),
        answer = "A bus is bigger than a car.",
        explanation = "Namunaviy javob: A bus is bigger than a car."
    ),
    Question.Ordering(
        section = "6-mashq • O‘zingiz taqqoslang",
        prompt = "Ikki kitobni qiziqarli bo‘lishi bo‘yicha taqqoslang.",
        words = listOf("This book", "is", "more interesting", "than", "that book."),
        answer = "This book is more interesting than that book.",
        explanation = "Namunaviy javob: This book is more interesting than that book."
    )
)