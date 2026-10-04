package com.example.gujumenglish.ui.grammar.practice

internal val lesson8Questions: List<Question> = listOf(
    Question.Matching(
        section = "1-mashq • Singular yoki Plural?",
        prompt = "Har bir so‘zni to‘g‘ri turkum bilan bog‘lang.",
        pairs = listOf(
            "book" to "singular",
            "books" to "plural",
            "child" to "singular",
            "children" to "plural",
            "buses" to "plural",
            "baby" to "singular",
            "cities" to "plural",
            "women" to "plural"
        ),
        options = listOf("singular", "plural"),
        explanation = "Singular: book, child, baby. Plural: books, children, buses, cities, women."
    ),
    Question.Text(
        section = "2-mashq • Ko‘plik shaklini yozing",
        prompt = "«pen» so‘zining ko‘plik shaklini yozing.",
        answers = setOf("pens"),
        explanation = "pen → pens."
    ),
    Question.Text(
        section = "2-mashq • Ko‘plik shaklini yozing",
        prompt = "«car» so‘zining ko‘plik shaklini yozing.",
        answers = setOf("cars"),
        explanation = "car → cars."
    ),
    Question.Text(
        section = "2-mashq • Ko‘plik shaklini yozing",
        prompt = "«dog» so‘zining ko‘plik shaklini yozing.",
        answers = setOf("dogs"),
        explanation = "dog → dogs."
    ),
    Question.Text(
        section = "2-mashq • Ko‘plik shaklini yozing",
        prompt = "«teacher» so‘zining ko‘plik shaklini yozing.",
        answers = setOf("teachers"),
        explanation = "teacher → teachers."
    ),
    Question.Text(
        section = "3-mashq • -es qo‘shing",
        prompt = "«bus» so‘zining ko‘plik shaklini yozing.",
        answers = setOf("buses"),
        explanation = "bus → buses."
    ),
    Question.Text(
        section = "3-mashq • -es qo‘shing",
        prompt = "«box» so‘zining ko‘plik shaklini yozing.",
        answers = setOf("boxes"),
        explanation = "box → boxes."
    ),
    Question.Text(
        section = "3-mashq • -es qo‘shing",
        prompt = "«dish» so‘zining ko‘plik shaklini yozing.",
        answers = setOf("dishes"),
        explanation = "dish → dishes."
    ),
    Question.Text(
        section = "3-mashq • -es qo‘shing",
        prompt = "«watch» so‘zining ko‘plik shaklini yozing.",
        answers = setOf("watches"),
        explanation = "watch → watches."
    ),
    Question.Text(
        section = "4-mashq • -y bilan tugagan so‘zlar",
        prompt = "«baby» so‘zining ko‘plik shaklini yozing.",
        answers = setOf("babies"),
        explanation = "baby → babies."
    ),
    Question.Text(
        section = "4-mashq • -y bilan tugagan so‘zlar",
        prompt = "«city» so‘zining ko‘plik shaklini yozing.",
        answers = setOf("cities"),
        explanation = "city → cities."
    ),
    Question.Text(
        section = "4-mashq • -y bilan tugagan so‘zlar",
        prompt = "«boy» so‘zining ko‘plik shaklini yozing.",
        answers = setOf("boys"),
        explanation = "boy → boys (unli + y)."
    ),
    Question.Text(
        section = "4-mashq • -y bilan tugagan so‘zlar",
        prompt = "«toy» so‘zining ko‘plik shaklini yozing.",
        answers = setOf("toys"),
        explanation = "toy → toys (unli + y)."
    ),
    Question.Text(
        section = "5-mashq • Irregular plural",
        prompt = "«man» so‘zining ko‘plik shaklini yozing.",
        answers = setOf("men"),
        explanation = "man → men."
    ),
    Question.Text(
        section = "5-mashq • Irregular plural",
        prompt = "«woman» so‘zining ko‘plik shaklini yozing.",
        answers = setOf("women"),
        explanation = "woman → women."
    ),
    Question.Text(
        section = "5-mashq • Irregular plural",
        prompt = "«child» so‘zining ko‘plik shaklini yozing.",
        answers = setOf("children"),
        explanation = "child → children."
    ),
    Question.Text(
        section = "5-mashq • Irregular plural",
        prompt = "«person» so‘zining ko‘plik shaklini yozing.",
        answers = setOf("people"),
        explanation = "person → people."
    ),
    Question.Text(
        section = "5-mashq • Irregular plural",
        prompt = "«foot» so‘zining ko‘plik shaklini yozing.",
        answers = setOf("feet"),
        explanation = "foot → feet."
    ),
    Question.Text(
        section = "5-mashq • Irregular plural",
        prompt = "«tooth» so‘zining ko‘plik shaklini yozing.",
        answers = setOf("teeth"),
        explanation = "tooth → teeth."
    ),
    Question.Choice(
        section = "6-mashq • To‘g‘ri variantni tanlang",
        prompt = "one ___",
        options = listOf("book", "books"),
        answer = "book",
        explanation = "one — birlik, shuning uchun book."
    ),
    Question.Choice(
        section = "6-mashq • To‘g‘ri variantni tanlang",
        prompt = "three ___",
        options = listOf("box", "boxes"),
        answer = "boxes",
        explanation = "three — ko‘plik, shuning uchun boxes."
    ),
    Question.Choice(
        section = "6-mashq • To‘g‘ri variantni tanlang",
        prompt = "two ___",
        options = listOf("child", "children"),
        answer = "children",
        explanation = "two — ko‘plik, shuning uchun children."
    ),
    Question.Choice(
        section = "6-mashq • To‘g‘ri variantni tanlang",
        prompt = "one ___",
        options = listOf("apple", "apples"),
        answer = "apple",
        explanation = "one — birlik, shuning uchun apple."
    ),
    Question.Choice(
        section = "6-mashq • To‘g‘ri variantni tanlang",
        prompt = "five ___",
        options = listOf("student", "students"),
        answer = "students",
        explanation = "five — ko‘plik, shuning uchun students."
    ),
    Question.Choice(
        section = "7-mashq • A/An bilan ko‘plikni tekshiring",
        prompt = "Qaysi biri to‘g‘ri?",
        options = listOf("a book", "a books"),
        answer = "a book",
        explanation = "a faqat birlik ot bilan keladi: a book."
    ),
    Question.Choice(
        section = "7-mashq • A/An bilan ko‘plikni tekshiring",
        prompt = "Qaysi biri to‘g‘ri?",
        options = listOf("an apple", "an apples"),
        answer = "an apple",
        explanation = "an faqat birlik ot bilan keladi: an apple."
    ),
    Question.Text(
        section = "7-mashq • A/An bilan ko‘plikni tekshiring",
        prompt = "Xatoni tuzating: «two a cars».",
        answers = setOf("two cars"),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: two cars."
    ),
    Question.Choice(
        section = "7-mashq • A/An bilan ko‘plikni tekshiring",
        prompt = "Bitta olma: ___ apple.",
        options = listOf("an", "the", "a"),
        answer = "an",
        explanation = "Unli tovush oldidan an: an apple."
    ),
    Question.TrueFalse(
        section = "7-mashq • A/An bilan ko‘plikni tekshiring",
        prompt = "“apples” oldidan artikl ishlatish mumkin.",
        answer = true,
        explanation = "Bu gap to‘g‘ri: masalan the apples."
    ),
    Question.Text(
        section = "8-mashq • Xatoni toping",
        prompt = "Xatoni tuzating: «two book».",
        answers = setOf("two books"),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: two books."
    ),
    Question.Text(
        section = "8-mashq • Xatoni toping",
        prompt = "Xatoni tuzating: «three childs».",
        answers = setOf("three children"),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: three children."
    ),
    Question.Text(
        section = "8-mashq • Xatoni toping",
        prompt = "Xatoni tuzating: «four boxs».",
        answers = setOf("four boxes"),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: four boxes."
    ),
    Question.Text(
        section = "8-mashq • Xatoni toping",
        prompt = "Xatoni tuzating: «two babys».",
        answers = setOf("two babies"),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: two babies."
    ),
    Question.Text(
        section = "8-mashq • Xatoni toping",
        prompt = "Xatoni tuzating: «an books».",
        answers = setOf("books"),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: books (an olib tashlanadi)."
    ),
    Question.Text(
        section = "9-mashq • Gapni to‘ldiring",
        prompt = "«I have one pen and two ___ (book).» — to‘ldiring.",
        answers = setOf("books"),
        explanation = "two — ko‘plik: books."
    ),
    Question.Text(
        section = "9-mashq • Gapni to‘ldiring",
        prompt = "«She has three ___ (box).» — to‘ldiring.",
        answers = setOf("boxes"),
        explanation = "three — ko‘plik: boxes."
    ),
    Question.Text(
        section = "9-mashq • Gapni to‘ldiring",
        prompt = "«We see one ___ (child).» — to‘ldiring.",
        answers = setOf("child"),
        explanation = "one — birlik: child."
    ),
    Question.Text(
        section = "9-mashq • Gapni to‘ldiring",
        prompt = "«...and four ___ (child).» — to‘ldiring.",
        answers = setOf("children"),
        explanation = "four — ko‘plik: children."
    ),
    Question.Text(
        section = "9-mashq • Gapni to‘ldiring",
        prompt = "«He has a ___ (baby).» — to‘ldiring.",
        answers = setOf("baby"),
        explanation = "a — birlik: baby."
    ),
    Question.Text(
        section = "9-mashq • Gapni to‘ldiring",
        prompt = "«...and two ___ (toy).» — to‘ldiring.",
        answers = setOf("toys"),
        explanation = "two — ko‘plik: toys."
    )
)
