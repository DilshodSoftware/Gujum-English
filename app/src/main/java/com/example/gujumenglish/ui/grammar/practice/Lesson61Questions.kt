package com.example.gujumenglish.ui.grammar.practice

internal val lesson61Questions: List<Question> = listOf(
    Question.Ordering(
        section = "1-mashq • So‘zlarni to‘g‘ri tartiblang",
        prompt = "house / a / big — gapni tuzing.",
        words = listOf("a", "big", "house"),
        answer = "A big house.",
        explanation = "To‘g‘ri tartib: a big house."
    ),
    Question.Ordering(
        section = "1-mashq • So‘zlarni to‘g‘ri tartiblang",
        prompt = "my / phone / new — gapni tuzing.",
        words = listOf("my", "new", "phone"),
        answer = "My new phone.",
        explanation = "To‘g‘ri tartib: my new phone."
    ),
    Question.Ordering(
        section = "1-mashq • So‘zlarni to‘g‘ri tartiblang",
        prompt = "red / the / car — gapni tuzing.",
        words = listOf("the", "red", "car"),
        answer = "The red car.",
        explanation = "To‘g‘ri tartib: the red car."
    ),
    Question.Ordering(
        section = "1-mashq • So‘zlarni to‘g‘ri tartiblang",
        prompt = "is / the book / interesting — gapni tuzing.",
        words = listOf("The book", "is", "interesting."),
        answer = "The book is interesting.",
        explanation = "To‘g‘ri gap: The book is interesting."
    ),
    Question.Ordering(
        section = "1-mashq • So‘zlarni to‘g‘ri tartiblang",
        prompt = "are / the flowers / beautiful — gapni tuzing.",
        words = listOf("The flowers", "are", "beautiful."),
        answer = "The flowers are beautiful.",
        explanation = "To‘g‘ri gap: The flowers are beautiful."
    ),
    Question.Text(
        section = "2-mashq • A yoki An?",
        prompt = "___ old house",
        answers = setOf("an"),
        explanation = "old — unli tovush bilan: an old house."
    ),
    Question.Text(
        section = "2-mashq • A yoki An?",
        prompt = "___ small orange",
        answers = setOf("a"),
        explanation = "small — undosh tovush bilan: a small orange."
    ),
    Question.Text(
        section = "2-mashq • A yoki An?",
        prompt = "___ red apple",
        answers = setOf("a"),
        explanation = "red — undosh tovush bilan: a red apple."
    ),
    Question.Text(
        section = "2-mashq • A yoki An?",
        prompt = "___ interesting film",
        answers = setOf("an"),
        explanation = "interesting — unli tovush bilan: an interesting film."
    ),
    Question.Choice(
        section = "3-mashq • Qavsdan to‘g‘ri variantni tanlang",
        prompt = "(My / Mine) blue bag is here.",
        options = listOf("My", "Mine"),
        answer = "My",
        explanation = "Ot oldida adjective: My blue bag."
    ),
    Question.Choice(
        section = "3-mashq • Qavsdan to‘g‘ri variantni tanlang",
        prompt = "(This / These) old book is interesting. (bitta)",
        options = listOf("This", "These"),
        answer = "This",
        explanation = "Bitta uchun: This old book."
    ),
    Question.Choice(
        section = "3-mashq • Qavsdan to‘g‘ri variantni tanlang",
        prompt = "She has (a / an) beautiful dress.",
        options = listOf("a", "an"),
        answer = "a",
        explanation = "beautiful — undosh tovush bilan: a beautiful dress."
    ),
    Question.Choice(
        section = "3-mashq • Qavsdan to‘g‘ri variantni tanlang",
        prompt = "They live in (a / an) small house.",
        options = listOf("a", "an"),
        answer = "a",
        explanation = "small — undosh tovush bilan: a small house."
    ),
    Question.Choice(
        section = "3-mashq • Qavsdan to‘g‘ri variantni tanlang",
        prompt = "He is (a / an) honest man. (h aytilmaydi)",
        options = listOf("a", "an"),
        answer = "an",
        explanation = "h aytilmagani uchun unli tovush: an honest man."
    ),
    Question.Choice(
        section = "4-mashq • Ot oldidami yoki To Be dan keyinmi?",
        prompt = "a beautiful garden — qaysi tuzilma?",
        options = listOf("sifat + ot birikmasi", "subject + be + sifat"),
        answer = "sifat + ot birikmasi",
        explanation = "Ot oldida sifat keladi."
    ),
    Question.Choice(
        section = "4-mashq • Ot oldidami yoki To Be dan keyinmi?",
        prompt = "The garden is beautiful. — qaysi tuzilma?",
        options = listOf("sifat + ot birikmasi", "subject + be + sifat"),
        answer = "subject + be + sifat",
        explanation = "To be dan keyin sifat keladi."
    ),
    Question.Choice(
        section = "4-mashq • Ot oldidami yoki To Be dan keyinmi?",
        prompt = "my old shoes — qaysi tuzilma?",
        options = listOf("sifat + ot birikmasi", "subject + be + sifat"),
        answer = "sifat + ot birikmasi",
        explanation = "Ot oldida sifat keladi."
    ),
    Question.Choice(
        section = "4-mashq • Ot oldidami yoki To Be dan keyinmi?",
        prompt = "The shoes are old. — qaysi tuzilma?",
        options = listOf("sifat + ot birikmasi", "subject + be + sifat"),
        answer = "subject + be + sifat",
        explanation = "To be dan keyin sifat keladi."
    ),
    Question.Text(
        section = "5-mashq • Sifatni ko‘plikka moslang",
        prompt = "one small dog → two ___ dogs",
        answers = setOf("small"),
        explanation = "Sifatga -s qo‘shilmaydi: two small dogs."
    ),
    Question.Text(
        section = "5-mashq • Sifatni ko‘plikka moslang",
        prompt = "a red apple → three ___ apples",
        answers = setOf("red"),
        explanation = "Sifatga -s qo‘shilmaydi: three red apples."
    ),
    Question.Choice(
        section = "5-mashq • Sifatni ko‘plikka moslang",
        prompt = "The houses are (big / bigs).",
        options = listOf("big", "bigs"),
        answer = "big",
        explanation = "Sifat: big."
    ),
    Question.Choice(
        section = "5-mashq • Sifatni ko‘plikka moslang",
        prompt = "Those are (new / news) books.",
        options = listOf("new", "news"),
        answer = "new",
        explanation = "Sifat: new books."
    ),
    Question.Ordering(
        section = "6-mashq • Ikki sifat bilan ot birikmasi tuzing",
        prompt = "katta, qizil, mashina — birikmasi tuzing.",
        words = listOf("a", "big", "red", "car"),
        answer = "a big red car",
        explanation = "To‘g‘ri javob: a big red car."
    ),
    Question.Ordering(
        section = "6-mashq • Ikki sifat bilan ot birikmasi tuzing",
        prompt = "kichik, qora, mushuk — birikmasi tuzing.",
        words = listOf("a", "small", "black", "cat"),
        answer = "a small black cat",
        explanation = "To‘g‘ri javob: a small black cat."
    ),
    Question.Ordering(
        section = "6-mashq • Ikki sifat bilan ot birikmasi tuzing",
        prompt = "eski, ko‘k, sumka — birikmasi tuzing.",
        words = listOf("an", "old", "blue", "bag"),
        answer = "an old blue bag",
        explanation = "To‘g‘ri javob: an old blue bag."
    )
)