package com.example.gujumenglish.ui.grammar.practice

internal val lesson66Questions: List<Question> = listOf(
    Question.Matching(
        section = "1-bo‘lim • Gap qurilishi, olmosh va otlar",
        prompt = "«The girl reads a book.» — bo‘laklarni bog‘lang.",
        pairs = listOf(
            "the girl" to "subject",
            "reads" to "verb",
            "a book" to "object"
        ),
        options = listOf("subject", "verb", "object"),
        explanation = "the girl — subject; reads — verb; a book — object."
    ),
    Question.Ordering(
        section = "1-bo‘lim • Gap qurilishi, olmosh va otlar",
        prompt = "every day / I / English / study — gapni tuzing.",
        words = listOf("I", "study", "English", "every day."),
        answer = "I study English every day.",
        explanation = "To‘g‘ri gap: I study English every day."
    ),
    Question.Choice(
        section = "1-bo‘lim • Gap qurilishi, olmosh va otlar",
        prompt = "I see (he / him) at school.",
        options = listOf("he", "him"),
        answer = "him",
        explanation = "Object shakli: him."
    ),
    Question.Text(
        section = "1-bo‘lim • Gap qurilishi, olmosh va otlar",
        prompt = "We visit Ali and Sara. → We visit ___.",
        answers = setOf("them"),
        explanation = "Ko‘plik object: them."
    ),
    Question.Choice(
        section = "1-bo‘lim • Gap qurilushi, olmosh va otlar",
        prompt = "This is (my / mine) phone.",
        options = listOf("my", "mine"),
        answer = "my",
        explanation = "Ot oldida adjective: my phone."
    ),
    Question.Choice(
        section = "1-bo‘lim • Gap qurilushi, olmosh va otlar",
        prompt = "Yaqinda turgan bir nechta kalit: (This / These) are my keys.",
        options = listOf("This", "These"),
        answer = "These",
        explanation = "Bir nechta uchun: These."
    ),
    Question.Ordering(
        section = "1-bo‘lim • Gap qurilishi, olmosh va otlar",
        prompt = "a / red / car — birikmasi tuzing.",
        words = listOf("a", "red", "car"),
        answer = "a red car",
        explanation = "To‘g‘ri javob: a red car."
    ),
    Question.Text(
        section = "2-bo‘lim • To Be, There Is/Are va egalik",
        prompt = "I ___ tired now. (am / is / are)",
        answers = setOf("am"),
        explanation = "I bilan am."
    ),
    Question.Text(
        section = "2-bo‘lim • To Be, There Is/Are va egalik",
        prompt = "Inkor qiling: She is busy.",
        answers = setOf("She isn’t busy."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: She isn’t busy."
    ),
    Question.Ordering(
        section = "2-bo‘lim • To Be, There Is/Are va egalik",
        prompt = "Savol tuzing: You are at home.",
        words = listOf("Are", "you", "at home"),
        answer = "Are you at home?",
        explanation = "To‘g‘ri savol: Are you at home?"
    ),
    Question.Text(
        section = "2-bo‘lim • To Be, There Is/Are va egalik",
        prompt = "Are you ready? (ha, qisqa javob)",
        answers = setOf("Yes, I am."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: Yes, I am."
    ),
    Question.Text(
        section = "2-bo‘lim • To Be, There Is/Are va egalik",
        prompt = "My parents ___ at the park yesterday. (was / were)",
        answers = setOf("were"),
        explanation = "O‘tgan zamon, ko‘plik: were."
    ),
    Question.Text(
        section = "2-bo‘lim • To Be, There Is/Are va egalik",
        prompt = "There ___ two apples on the plate. (is / are)",
        answers = setOf("are"),
        explanation = "Bir nechta: are."
    ),
    Question.Text(
        section = "2-bo‘lim • To Be, There Is/Are va egalik",
        prompt = "«Qizning sumkasi»ni ’s bilan yozing.",
        answers = setOf("the girl’s bag"),
        explanation = "To‘g‘ri javob: the girl’s bag."
    ),
    Question.Text(
        section = "3-bo‘lim • Present Simple: darak, inkor va savol",
        prompt = "My sister ___ (study) every evening.",
        answers = setOf("studies"),
        explanation = "Bitta ayol: studies."
    ),
    Question.Text(
        section = "3-bo‘lim • Present Simple: darak, inkor va savol",
        prompt = "Inkor qiling: We drink coffee.",
        answers = setOf("We don’t drink coffee."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: We don’t drink coffee."
    ),
    Question.Choice(
        section = "3-bo‘lim • Present Simple: darak, inkor va savol",
        prompt = "Does he ___ (play / plays) tennis?",
        options = listOf("play", "plays"),
        answer = "play",
        explanation = "Does dan keyin oddiy shakl: play."
    ),
    Question.Choice(
        section = "3-bo‘lim • Present Simple: darak, inkor va savol",
        prompt = "Where ___ Anna live? (do / does)",
        options = listOf("do", "does"),
        answer = "does",
        explanation = "Bitta ayol bilan does."
    ),
    Question.Ordering(
        section = "3-bo‘lim • Present Simple: darak, inkor va savol",
        prompt = "I / get up / at seven — usually so‘zini qo‘ying.",
        words = listOf("I", "usually", "get up", "at seven."),
        answer = "I usually get up at seven.",
        explanation = "To‘g‘ri gap: I usually get up at seven."
    ),
    Question.Text(
        section = "3-bo‘lim • Present Simple: darak, inkor va savol",
        prompt = "Does your brother work here? (yo‘q, qisqa javob)",
        answers = setOf("No, he doesn’t."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: No, he doesn’t."
    ),
    Question.Choice(
        section = "3-bo‘lim • Present Simple: darak, inkor va savol",
        prompt = "He ___ a new bicycle. (have / has)",
        options = listOf("have", "has"),
        answer = "has",
        explanation = "Istisno: have → has."
    ),
    Question.Text(
        section = "4-bo‘lim • Present Continuous va odatni farqlash",
        prompt = "They ___ watching TV now. (am / is / are)",
        answers = setOf("are"),
        explanation = "Ko‘plik bilan are."
    ),
    Question.Text(
        section = "4-bo‘lim • Present Continuous va odatni farqlash",
        prompt = "make fe’liga -ing qo‘shing.",
        answers = setOf("making"),
        explanation = "Oxirgi e tushadi: making."
    ),
    Question.Text(
        section = "4-bo‘lim • Present Continuous va odatni farqlash",
        prompt = "Inkor qiling: He is sleeping.",
        answers = setOf("He isn’t sleeping."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: He isn’t sleeping."
    ),
    Question.Ordering(
        section = "4-bo‘lim • Present Continuous va odatni farqlash",
        prompt = "Savol tuzing: You are listening.",
        words = listOf("Are", "you", "listening"),
        answer = "Are you listening?",
        explanation = "To‘g‘ri savol: Are you listening?"
    ),
    Question.Choice(
        section = "4-bo‘lim • Present Continuous va odatni farqlash",
        prompt = "I (walk / am walking) to work every day.",
        options = listOf("walk", "am walking"),
        answer = "walk",
        explanation = "every day — odat: walk."
    ),
    Question.Choice(
        section = "4-bo‘lim • Present Continuous va odatni farqlash",
        prompt = "Look! The dog (runs / is running) after the ball.",
        options = listOf("runs", "is running"),
        answer = "is running",
        explanation = "Look! — ayni paytda: is running."
    ),
    Question.Text(
        section = "4-bo‘lim • Present Continuous va odatni farqlash",
        prompt = "Xatoni tuzating: She is know my name.",
        answers = setOf("She knows my name."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: She knows my name."
    ),
    Question.Text(
        section = "5-bo‘lim • Past Simple va Was/Were",
        prompt = "stop fe’lini Past Simple ga o‘tkazing.",
        answers = setOf("stopped"),
        explanation = "To‘g‘ri shakl: stopped."
    ),
    Question.Text(
        section = "5-bo‘lim • Past Simple va Was/Were",
        prompt = "go fe’lining Past Simple shaklini yozing.",
        answers = setOf("went"),
        explanation = "Irregular fe’l: went."
    ),
    Question.Text(
        section = "5-bo‘lim • Past Simple va Was/Were",
        prompt = "Inkor qiling: He went to school.",
        answers = setOf("He didn’t go to school."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: He didn’t go to school."
    ),
    Question.Ordering(
        section = "5-bo‘lim • Past Simple va Was/Were",
        prompt = "Savol tuzing: They saw the film.",
        words = listOf("Did", "they", "the film", "see"),
        answer = "Did they see the film?",
        explanation = "To‘g‘ri savol: Did they see the film?"
    ),
    Question.Text(
        section = "5-bo‘lim • Past Simple va Was/Were",
        prompt = "Did you call your friend? (ha, qisqa javob)",
        answers = setOf("Yes, I did."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: Yes, I did."
    ),
    Question.Text(
        section = "5-bo‘lim • Past Simple va Was/Were",
        prompt = "We ___ at home yesterday. (was / were)",
        answers = setOf("were"),
        explanation = "O‘tgan zamon, ko‘plik: were."
    ),
    Question.Text(
        section = "5-bo‘lim • Past Simple va Was/Were",
        prompt = "Xatoni tuzating: Did she went home?",
        answers = setOf("Did she go home?"),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: Did she go home?"
    ),
    Question.Text(
        section = "6-bo‘lim • Kelajak va Can",
        prompt = "I ___ going to study tonight. (am / are)",
        answers = setOf("am"),
        explanation = "I bilan am."
    ),
    Question.Choice(
        section = "6-bo‘lim • Kelajak va Can",
        prompt = "Going to dan keyin to‘g‘ri fe’lni tanlang: She is going to (cook / cooks).",
        options = listOf("cook", "cooks"),
        answer = "cook",
        explanation = "Going to dan keyin oddiy shakl: cook."
    ),
    Question.Choice(
        section = "6-bo‘lim • Kelajak va Can",
        prompt = "I think they ___ win tomorrow. (will / were)",
        options = listOf("will", "were"),
        answer = "will",
        explanation = "Kelajak — will."
    ),
    Question.Ordering(
        section = "6-bo‘lim • Kelajak va Can",
        prompt = "Savol tuzing: He will come later.",
        words = listOf("Will", "he", "come", "later"),
        answer = "Will he come later?",
        explanation = "To‘g‘ri savol: Will he come later?"
    ),
    Question.Choice(
        section = "6-bo‘lim • Kelajak va Can",
        prompt = "Oldindan reja uchun mosini belgilang.",
        options = listOf("going to", "will"),
        answer = "going to",
        explanation = "Oldindan reja — going to."
    ),
    Question.Choice(
        section = "6-bo‘lim • Kelajak va Can",
        prompt = "He ___ swim. (can / cans)",
        options = listOf("can", "cans"),
        answer = "can",
        explanation = "Can ga -s qo‘shilmaydi."
    ),
    Question.Ordering(
        section = "6-bo‘lim • Kelajak va Can",
        prompt = "«Yugurma!» deb buyruq bering — gapni tuzing.",
        words = listOf("Don’t", "run!"),
        answer = "Don’t run!",
        explanation = "To‘g‘ri javob: Don’t run!"
    ),
    Question.Choice(
        section = "7-bo‘lim • Savol so‘zlari va miqdor",
        prompt = "___ is your name? (What / Where)",
        options = listOf("What", "Where"),
        answer = "What",
        explanation = "Ma’lumot haqida: What."
    ),
    Question.Choice(
        section = "7-bo‘lim • Savol so‘zlari va miqdor",
        prompt = "___ is the library? (Who / Where)",
        options = listOf("Who", "Where"),
        answer = "Where",
        explanation = "Joy haqida: Where."
    ),
    Question.Text(
        section = "7-bo‘lim • Savol so‘zlari va miqdor",
        prompt = "___ lives next door? (Who subject bo‘lsa: do / yordamchisiz)",
        answers = setOf("Who"),
        explanation = "Who subject bo‘lsa, yordamchi fe’l shart emas: Who lives next door?"
    ),
    Question.Choice(
        section = "7-bo‘lim • Savol so‘zlari va miqdor",
        prompt = "___ old is your sister? (How / What)",
        options = listOf("How", "What"),
        answer = "How",
        explanation = "Yosh uchun: How old."
    ),
    Question.Choice(
        section = "7-bo‘lim • Savol so‘zlari va miqdor",
        prompt = "How ___ books do you have? (many / much)",
        options = listOf("many", "much"),
        answer = "many",
        explanation = "Ko‘plikdagi sanaladigan ot: many."
    ),
    Question.Text(
        section = "7-bo‘lim • Savol so‘zlari va miqdor",
        prompt = "___ ___ is this ticket? (narxni so‘rang)",
        answers = setOf("How much"),
        explanation = "Narx uchun: How much."
    ),
    Question.Choice(
        section = "7-bo‘lim • Savol so‘zlari va miqdor",
        prompt = "When ___ you study English? (do / are)",
        options = listOf("do", "are"),
        answer = "do",
        explanation = "Harakat fe’li bilan savol: do."
    ),
    Question.Choice(
        section = "8-bo‘lim • Artikllar, miqdor va predloglar",
        prompt = "I have ___ umbrella. (a / an)",
        options = listOf("a", "an"),
        answer = "an",
        explanation = "umbrella — unli tovush bilan: an."
    ),
    Question.Choice(
        section = "8-bo‘lim • Artikllar, miqdor va predloglar",
        prompt = "Darak gap: There is ___ milk in the fridge. (some / any)",
        options = listOf("some", "any"),
        answer = "some",
        explanation = "Darak gapda: some."
    ),
    Question.Choice(
        section = "8-bo‘lim • Artikllar, miqdor va predloglar",
        prompt = "We don’t have ___ eggs. (some / any)",
        options = listOf("some", "any"),
        answer = "any",
        explanation = "Inkor gapda: any."
    ),
    Question.Choice(
        section = "8-bo‘lim • Artikllar, miqdor va predloglar",
        prompt = "How ___ money do you need? (many / much)",
        options = listOf("many", "much"),
        answer = "much",
        explanation = "Sanalmaydigan ot: much."
    ),
    Question.Choice(
        section = "8-bo‘lim • Artikllar, miqdor va predloglar",
        prompt = "Countable yoki uncountable: rice?",
        options = listOf("countable", "uncountable"),
        answer = "uncountable",
        explanation = "rice — sanalmaydigan ot."
    ),
    Question.Choice(
        section = "8-bo‘lim • Artikllar, miqdor va predloglar",
        prompt = "The keys are ___ the bag. (in / on) — ichida.",
        options = listOf("in", "on"),
        answer = "in",
        explanation = "Ichida: in."
    ),
    Question.Choice(
        section = "8-bo‘lim • Artikllar, miqdor va predloglar",
        prompt = "The lesson starts ___ 8 o’clock. (at / on / in)",
        options = listOf("at", "on", "in"),
        answer = "at",
        explanation = "Aniq soat uchun: at."
    ),
    Question.Text(
        section = "9-bo‘lim • Sifatlar va bog‘lovchilar",
        prompt = "Superlative shakl: tall → ___",
        answers = setOf("the tallest"),
        explanation = "To‘g‘ri javob: the tallest."
    ),
    Question.Text(
        section = "9-bo‘lim • Sifatlar va bog‘lovchilar",
        prompt = "Comparative shakl: happy → ___",
        answers = setOf("happier"),
        explanation = "To‘g‘ri javob: happier."
    ),
    Question.Choice(
        section = "9-bo‘lim • Sifatlar va bog‘lovchilar",
        prompt = "To‘g‘ri yozuvni tanlang: two (small / smalls) cats.",
        options = listOf("small", "smalls"),
        answer = "small",
        explanation = "Sifatga -s qo‘shilmaydi: two small cats."
    ),
    Question.Choice(
        section = "9-bo‘lim • Sifatlar va bog‘lovchilar",
        prompt = "I was tired, ___ I went to bed. (because / so)",
        options = listOf("because", "so"),
        answer = "so",
        explanation = "Natija so bilan keladi."
    ),
    Question.Choice(
        section = "9-bo‘lim • Sifatlar va bog‘lovchilar",
        prompt = "I stayed home ___ I was sick. (because / so)",
        options = listOf("because", "so"),
        answer = "because",
        explanation = "Sabab because bilan keladi."
    ),
    Question.Choice(
        section = "9-bo‘lim • Sifatlar va bog‘lovchilar",
        prompt = "I like tea ___ coffee. (ikkalasi ham)",
        options = listOf("and", "but", "or"),
        answer = "and",
        explanation = "Qo‘shish: and."
    ),
    Question.Choice(
        section = "9-bo‘lim • Sifatlar va bog‘lovchilar",
        prompt = "«This is ___ most interesting book.» (a / the)",
        options = listOf("a", "the"),
        answer = "the",
        explanation = "Superlative oldidan the kerak."
    ),
    Question.Ordering(
        section = "10-bo‘lim • Would Like va yakuniy gaplar",
        prompt = "«Men biroz suv xohlardim.» — Would like bilan tarjima qiling.",
        words = listOf("I’d like", "some water."),
        answer = "I’d like some water.",
        explanation = "To‘g‘ri javob: I’d like some water."
    ),
    Question.TrueFalse(
        section = "10-bo‘lim • Would Like va yakuniy gaplar",
        prompt = "Would like dan keyin fe’l kelsa, to kerak.",
        answer = true,
        explanation = "Bu gap to‘g‘ri: I’d like to drink."
    ),
    Question.Ordering(
        section = "10-bo‘lim • Would Like va yakuniy gaplar",
        prompt = "Muloyim taklif tuzing: «Choy xohlaysizmi?»",
        words = listOf("Would you like", "some tea?"),
        answer = "Would you like some tea?",
        explanation = "To‘g‘ri javob: Would you like some tea?"
    ),
    Question.Ordering(
        section = "10-bo‘lim • Would Like va yakuniy gaplar",
        prompt = "yesterday / my friends / a film / watched — gapni tuzing.",
        words = listOf("My friends", "watched", "a film", "yesterday."),
        answer = "My friends watched a film yesterday.",
        explanation = "To‘g‘ri gap: My friends watched a film yesterday."
    ),
    Question.Ordering(
        section = "10-bo‘lim • Would Like va yakuniy gaplar",
        prompt = "because / I / stayed home / was tired — gapni tuzing.",
        words = listOf("I stayed home", "because", "I was tired."),
        answer = "I stayed home because I was tired.",
        explanation = "To‘g‘ri gap: I stayed home because I was tired."
    ),
    Question.Text(
        section = "10-bo‘lim • Would Like va yakuniy gaplar",
        prompt = "Xatoni tuzating: She would likes coffee.",
        answers = setOf("She would like coffee."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: She would like coffee."
    ),
    Question.Ordering(
        section = "10-bo‘lim • Would Like va yakuniy gaplar",
        prompt = "«Biz ertaga buvimiznikiga bormoqchimiz.» — tarjima qiling.",
        words = listOf("Are", "We", "going to visit", "our grandmother", "tomorrow"),
        answer = "We are going to visit our grandmother tomorrow.",
        explanation = "To‘g‘ri javob: We are going to visit our grandmother tomorrow."
    )
)