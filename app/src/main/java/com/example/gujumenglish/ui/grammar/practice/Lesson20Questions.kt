package com.example.gujumenglish.ui.grammar.practice

internal val lesson20Questions: List<Question> = listOf(
    Question.Choice(
        section = "1-mashq • Odatmi yoki ayni hozirgi ishmi?",
        prompt = "«I walk to school every day.» — qaysi vaqt?",
        options = listOf("Present Simple", "Present Continuous"),
        answer = "Present Simple",
        explanation = "every day — odat: Present Simple."
    ),
    Question.Choice(
        section = "1-mashq • Odatmi yoki ayni hozirgi ishmi?",
        prompt = "«She is cooking now.» — qaysi vaqt?",
        options = listOf("Present Simple", "Present Continuous"),
        answer = "Present Continuous",
        explanation = "now — ayni vaqtda: is cooking."
    ),
    Question.Choice(
        section = "1-mashq • Odatmi yoki ayni hozirgi ishmi?",
        prompt = "«Birds fly.» — qaysi vaqt?",
        options = listOf("Present Simple", "Present Continuous"),
        answer = "Present Simple",
        explanation = "Umumiy haqiqat: Present Simple."
    ),
    Question.Choice(
        section = "1-mashq • Odatmi yoki ayni hozirgi ishmi?",
        prompt = "«We visit Grandma on Sundays.» — qaysi vaqt?",
        options = listOf("Present Simple", "Present Continuous"),
        answer = "Present Simple",
        explanation = "on Sundays — muntazam odat."
    ),
    Question.Choice(
        section = "1-mashq • Odatmi yoki ayni hozirgi ishmi?",
        prompt = "«They are playing at the moment.» — qaysi vaqt?",
        options = listOf("Present Simple", "Present Continuous"),
        answer = "Present Continuous",
        explanation = "at the moment — ayni vaqtda."
    ),
    Question.Choice(
        section = "1-mashq • Odatmi yoki ayni hozirgi ishmi?",
        prompt = "«The sun rises in the east.» — qaysi vaqt?",
        options = listOf("Present Simple", "Present Continuous"),
        answer = "Present Simple",
        explanation = "Tabiiy umumiy haqiqat: Present Simple."
    ),
    Question.Choice(
        section = "2-mashq • To‘g‘ri fe’l shaklini tanlang",
        prompt = "I (read / reads) before bed.",
        options = listOf("read", "reads"),
        answer = "read",
        explanation = "I bilan -s qo‘shilmaydi: I read."
    ),
    Question.Choice(
        section = "2-mashq • To‘g‘ri fe’l shaklini tanlang",
        prompt = "My parents (work / works) in a school.",
        options = listOf("work", "works"),
        answer = "work",
        explanation = "Ko‘plik ega bilan -s yo‘q: work."
    ),
    Question.Choice(
        section = "2-mashq • To‘g‘ri fe’l shaklini tanlang",
        prompt = "The bus (stop / stops) here.",
        options = listOf("stop", "stops"),
        answer = "stops",
        explanation = "Bitta ega: he/she/it bilan -s."
    ),
    Question.Choice(
        section = "2-mashq • To‘g‘ri fe’l shaklini tanlang",
        prompt = "You (like / likes) music.",
        options = listOf("like", "likes"),
        answer = "like",
        explanation = "You bilan -s qo‘shilmaydi."
    ),
    Question.Choice(
        section = "2-mashq • To‘g‘ri fe’l shaklini tanlang",
        prompt = "My friends (go / goes) swimming on Fridays.",
        options = listOf("go", "goes"),
        answer = "go",
        explanation = "Ko‘plik ega bilan -s yo‘q: go."
    ),
    Question.Choice(
        section = "2-mashq • To‘g‘ri fe’l shaklini tanlang",
        prompt = "The shop (open / opens) at nine.",
        options = listOf("open", "opens"),
        answer = "opens",
        explanation = "Bitta ega: it bilan -s."
    ),
    Question.Text(
        section = "3-mashq • Qavsdagi fe’lni yozing",
        prompt = "We ___ English at school. (study)",
        answers = setOf("study"),
        explanation = "Ko‘plik ega: study."
    ),
    Question.Text(
        section = "3-mashq • Qavsdagi fe’lni yozing",
        prompt = "My father ___ a car. (drive)",
        answers = setOf("drives"),
        explanation = "Bitta erkak ega: drives."
    ),
    Question.Text(
        section = "3-mashq • Qavsdagi fe’lni yozing",
        prompt = "They ___ in Samarkand. (live)",
        answers = setOf("live"),
        explanation = "Ko‘plik ega: live."
    ),
    Question.Text(
        section = "3-mashq • Qavsdagi fe’lni yozing",
        prompt = "A baby ___ a lot. (sleep)",
        answers = setOf("sleeps"),
        explanation = "Bitta ega: sleeps."
    ),
    Question.Text(
        section = "3-mashq • Qavsdagi fe’lni yozing",
        prompt = "I ___ my room every Saturday. (clean)",
        answers = setOf("clean"),
        explanation = "I bilan -s yo‘q: clean."
    ),
    Question.Ordering(
        section = "4-mashq • So‘zlarni gap tartibiga qo‘ying",
        prompt = "every morning / tea / drink / I — gapni tuzing.",
        words = listOf("every morning", "tea", "drink", "I"),
        answer = "I drink tea every morning.",
        explanation = "To‘g‘ri tartib: I drink tea every morning."
    ),
    Question.Ordering(
        section = "4-mashq • So‘zlarni gap tartibiga qo‘ying",
        prompt = "English / studies / Sara / at home — gapni tuzing.",
        words = listOf("English", "studies", "Sara", "at home"),
        answer = "Sara studies English at home.",
        explanation = "To‘g‘ri tartib: Sara studies English at home."
    ),
    Question.Ordering(
        section = "4-mashq • So‘zlarni gap tartibiga qo‘ying",
        prompt = "play / on Sundays / they / football — gapni tuzing.",
        words = listOf("play", "on Sundays", "they", "football"),
        answer = "They play football on Sundays.",
        explanation = "To‘g‘ri tartib: They play football on Sundays."
    ),
    Question.Ordering(
        section = "4-mashq • So‘zlarni gap tartibiga qo‘ying",
        prompt = "water / plants / need — gapni tuzing.",
        words = listOf("water", "plants", "need"),
        answer = "Plants need water.",
        explanation = "To‘g‘ri tartib: Plants need water."
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «He play tennis every week.»",
        answers = setOf("He plays tennis every week."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: He plays tennis every week."
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «I goes to work by bus.»",
        answers = setOf("I go to work by bus."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: I go to work by bus."
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «My sisters likes music.»",
        answers = setOf("My sisters like music."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: My sisters like music."
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «A dog chase cats.»",
        answers = setOf("A dog chases cats."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: A dog chases cats."
    ),
    Question.Text(
        section = "5-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «She studys English.»",
        answers = setOf("She studies English."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: She studies English."
    ),
    Question.Ordering(
        section = "6-mashq • Tarjima qiling",
        prompt = "«Men har kuni kitob o‘qiyman.» — gapni tuzing.",
        words = listOf("I", "read", "a book", "every day"),
        answer = "I read a book every day.",
        explanation = "To‘g‘ri javob: I read a book every day."
    ),
    Question.Ordering(
        section = "6-mashq • Tarjima qiling",
        prompt = "«Akam yakshanba kunlari futbol o‘ynaydi.» — gapni tuzing.",
        words = listOf("My brother", "plays", "football", "on Sundays"),
        answer = "My brother plays football on Sundays.",
        explanation = "To‘g‘ri javob: My brother plays football on Sundays."
    ),
    Question.Ordering(
        section = "6-mashq • Tarjima qiling",
        prompt = "«Biz maktab yaqinida yashaymiz.» — gapni tuzing.",
        words = listOf("We", "live", "near the school"),
        answer = "We live near the school.",
        explanation = "To‘g‘ri javob: We live near the school."
    ),
    Question.Ordering(
        section = "6-mashq • Tarjima qiling",
        prompt = "«Mushuklar sut ichadi.» — gapni tuzing.",
        words = listOf("Cats", "drink", "milk"),
        answer = "Cats drink milk.",
        explanation = "To‘g‘ri javob: Cats drink milk."
    ),
    Question.TrueFalse(
        section = "6-mashq • Tarjima qiling",
        prompt = "Present Simple da ega he/she/it yoki bitta ism bo‘lsa, fe’l oxiriga -s qo‘shiladi.",
        answer = true,
        explanation = "Bu gap to‘g‘ri: He plays, She studies."
    ),
    Question.TrueFalse(
        section = "6-mashq • Tarjima qiling",
        prompt = "Present Simple da I va you bilan fe’l oxiriga -s qo‘shiladi.",
        answer = false,
        explanation = "Bu gap noto‘g‘ri: I read, You like."
    )
)