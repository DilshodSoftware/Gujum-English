package com.example.gujumenglish.ui.grammar.practice

internal val lesson14Questions: List<Question> = listOf(
    Question.Choice(
        section = "1-mashq • Vaziyatga mos so‘zni tanlang",
        prompt = "«___ is my pen.» (qo‘limda bitta ruchka)",
        options = listOf("This", "That", "These", "Those"),
        answer = "This",
        explanation = "Yaqin va bitta: This is my pen."
    ),
    Question.Choice(
        section = "1-mashq • Vaziyatga mos so‘zni tanlang",
        prompt = "«___ are tall trees.» (uzoqda bir nechta)",
        options = listOf("This", "That", "These", "Those"),
        answer = "Those",
        explanation = "Uzoq va ko‘p: Those are tall trees."
    ),
    Question.Choice(
        section = "1-mashq • Vaziyatga mos so‘zni tanlang",
        prompt = "«___ are my keys.» (yonimda bir nechta)",
        options = listOf("This", "That", "These", "Those"),
        answer = "These",
        explanation = "Yaqin va ko‘p: These are my keys."
    ),
    Question.Choice(
        section = "1-mashq • Vaziyatga mos so‘zni tanlang",
        prompt = "«___ is our school.» (uzoqda bitta)",
        options = listOf("This", "That", "These", "Those"),
        answer = "That",
        explanation = "Uzoq va bitta: That is our school."
    ),
    Question.Choice(
        section = "1-mashq • Vaziyatga mos so‘zni tanlang",
        prompt = "«___ apples are sweet.» (yaqin, ko‘p)",
        options = listOf("This", "That", "These", "Those"),
        answer = "These",
        explanation = "Yaqin va ko‘p: These apples are sweet."
    ),
    Question.Choice(
        section = "1-mashq • Vaziyatga mos so‘zni tanlang",
        prompt = "«___ bird is very small.» (uzoqda bitta)",
        options = listOf("This", "That", "These", "Those"),
        answer = "That",
        explanation = "Uzoq va bitta: That bird is very small."
    ),
    Question.Matching(
        section = "1-mashq • Vaziyatga mos so‘zni tanlang",
        prompt = "Har bir ko‘rsatish so‘zini vaziyat bilan bog‘lang.",
        pairs = listOf(
            "this" to "yaqin, bitta",
            "that" to "uzoq, bitta",
            "these" to "yaqin, ko‘p",
            "those" to "uzoq, ko‘p"
        ),
        options = listOf("yaqin, bitta", "uzoq, bitta", "yaqin, ko‘p", "uzoq, ko‘p"),
        explanation = "this—yaqin, bitta; that—uzoq, bitta; these—yaqin, ko‘p; those—uzoq, ko‘p."
    ),
    Question.Text(
        section = "2-mashq • Is yoki Are?",
        prompt = "«This ___ a new phone.» — to‘ldiring.",
        answers = setOf("is"),
        explanation = "This — bitta, shuning uchun is."
    ),
    Question.Text(
        section = "2-mashq • Is yoki Are?",
        prompt = "«Those ___ my cousins.» — to‘ldiring.",
        answers = setOf("are"),
        explanation = "Those — ko‘p, shuning uchun are."
    ),
    Question.Text(
        section = "2-mashq • Is yoki Are?",
        prompt = "«That ___ an old house.» — to‘ldiring.",
        answers = setOf("is"),
        explanation = "That — bitta, shuning uchun is."
    ),
    Question.Text(
        section = "2-mashq • Is yoki Are?",
        prompt = "«These ___ red flowers.» — to‘ldiring.",
        answers = setOf("are"),
        explanation = "These — ko‘p, shuning uchun are."
    ),
    Question.Text(
        section = "2-mashq • Is yoki Are?",
        prompt = "«This book ___ interesting.» — to‘ldiring.",
        answers = setOf("is"),
        explanation = "Bu yerda ko‘rsatish so‘zi emas, bitta ot turibdi: is."
    ),
    Question.Text(
        section = "2-mashq • Is yoki Are?",
        prompt = "«Those shoes ___ clean.» — to‘ldiring.",
        answers = setOf("are"),
        explanation = "shoes — ko‘p, shuning uchun are."
    ),
    Question.Matching(
        section = "3-mashq • Yaqin / uzoq va birlik / ko‘plik",
        prompt = "Har bir so‘zni ikkala xususiyat bilan bog‘lang.",
        pairs = listOf(
            "this" to "yaqin, bitta",
            "that" to "uzoq, bitta",
            "these" to "yaqin, ko‘p",
            "those" to "uzoq, ko‘p"
        ),
        options = listOf("yaqin, bitta", "uzoq, bitta", "yaqin, ko‘p", "uzoq, ko‘p"),
        explanation = "this—yaqin, bitta; that—uzoq, bitta; these—yaqin, ko‘p; those—uzoq, ko‘p."
    ),
    Question.Text(
        section = "4-mashq • Birlik va ko‘plikni moslang",
        prompt = "«This is a book.» — yaqin, bir nechta. To‘g‘ri gapni yozing.",
        answers = setOf("These are books."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri gap: These are books."
    ),
    Question.Text(
        section = "4-mashq • Birlik va ko‘plikni moslang",
        prompt = "«That is a chair.» — uzoq, bir nechta. To‘g‘ri gapni yozing.",
        answers = setOf("Those are chairs."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri gap: Those are chairs."
    ),
    Question.Text(
        section = "4-mashq • Birlik va ko‘plikni moslang",
        prompt = "«These are apples.» — yaqin, bitta. To‘g‘ri gapni yozing.",
        answers = setOf("This is an apple."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri gap: This is an apple."
    ),
    Question.Text(
        section = "4-mashq • Birlik va ko‘plikni moslang",
        prompt = "«Those are dogs.» — uzoq, bitta. To‘g‘ri gapni yozing.",
        answers = setOf("That is a dog."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri gap: That is a dog."
    ),
    Question.Choice(
        section = "5-mashq • To‘g‘ri gapni toping",
        prompt = "Qaysi gap to‘g‘ri?",
        options = listOf("These is a bag.", "This is a bag."),
        answer = "This is a bag.",
        explanation = "Bir narsa uchun this + is."
    ),
    Question.Choice(
        section = "5-mashq • To‘g‘ri gapni toping",
        prompt = "Qaysi gap to‘g‘ri?",
        options = listOf("Those are my friends.", "That are my friends."),
        answer = "Those are my friends.",
        explanation = "Ko‘p uchun those + are."
    ),
    Question.Choice(
        section = "5-mashq • To‘g‘ri gapni toping",
        prompt = "Qaysi gap to‘g‘ri?",
        options = listOf("These books are new.", "This books are new."),
        answer = "These books are new.",
        explanation = "this bitta bilan keladi, ko‘plikda these."
    ),
    Question.Choice(
        section = "5-mashq • To‘g‘ri gapni toping",
        prompt = "Qaysi gap to‘g‘ri?",
        options = listOf("That is my parents.", "Those are my parents."),
        answer = "Those are my parents.",
        explanation = "Ko‘plik uchun those + are."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «These is my pencils.»",
        answers = setOf("These are my pencils."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: These are my pencils."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «That are a bird.»",
        answers = setOf("That is a bird."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: That is a bird."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «This are my parents.»",
        answers = setOf("These are my parents."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: These are my parents."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «Those is a bus.»",
        answers = setOf("Those are buses."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: Those are buses."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «These is an orange.» (yaqin, bitta)",
        answers = setOf("This is an orange."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: This is an orange."
    ),
    Question.Choice(
        section = "7-mashq • Ko‘rsatib gapiring",
        prompt = "Yaqin bitta narsa haqida gapiring.",
        options = listOf("This is my cup.", "That is my cup."),
        answer = "This is my cup.",
        explanation = "Yaqin bitta: this."
    ),
    Question.Choice(
        section = "7-mashq • Ko‘rsatib gapiring",
        prompt = "Uzoq bitta narsa haqida gapiring.",
        options = listOf("This is that door.", "That is the door."),
        answer = "That is the door.",
        explanation = "Uzoq bitta: that."
    ),
    Question.Choice(
        section = "7-mashq • Ko‘rsatib gapiring",
        prompt = "Yaqin bir nechta narsa haqida gapiring.",
        options = listOf("These are my books.", "Those are my books."),
        answer = "These are my books.",
        explanation = "Yaqin ko‘p: these."
    ),
    Question.Choice(
        section = "7-mashq • Ko‘rsatib gapiring",
        prompt = "Uzoq bir nechta narsa haqida gapiring.",
        options = listOf("These are those cars.", "Those are cars."),
        answer = "Those are cars.",
        explanation = "Uzoq ko‘p: those."
    )
)