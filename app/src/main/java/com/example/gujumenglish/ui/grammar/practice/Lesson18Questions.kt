package com.example.gujumenglish.ui.grammar.practice

internal val lesson18Questions: List<Question> = listOf(
    Question.Choice(
        section = "1-mashq • To‘g‘ri egalik shaklini tanlang",
        prompt = "This is (___) pencil.",
        options = listOf("my", "mine"),
        answer = "my",
        explanation = "Ot oldida egalik adjective: my pencil."
    ),
    Question.Choice(
        section = "1-mashq • To‘g‘ri egalik shaklini tanlang",
        prompt = "The pencil is (___).",
        options = listOf("my", "mine"),
        answer = "mine",
        explanation = "Ot yo‘q joyda egalik olmoshi: mine."
    ),
    Question.Choice(
        section = "1-mashq • To‘g‘ri egalik shaklini tanlang",
        prompt = "Is that (___) coat?",
        options = listOf("your", "yours"),
        answer = "your",
        explanation = "Ot oldida: your coat."
    ),
    Question.Choice(
        section = "1-mashq • To‘g‘ri egalik shaklini tanlang",
        prompt = "That coat is (___).",
        options = listOf("your", "yours"),
        answer = "yours",
        explanation = "Ot yo‘q: yours."
    ),
    Question.Choice(
        section = "1-mashq • To‘g‘ri egalik shaklini tanlang",
        prompt = "These are (___) shoes.",
        options = listOf("their", "theirs"),
        answer = "their",
        explanation = "Ot oldida: their shoes."
    ),
    Question.Choice(
        section = "1-mashq • To‘g‘ri egalik shaklini tanlang",
        prompt = "These shoes are (___).",
        options = listOf("their", "theirs"),
        answer = "theirs",
        explanation = "Ot yo‘q: theirs."
    ),
    Question.Choice(
        section = "1-mashq • To‘g‘ri egalik shaklini tanlang",
        prompt = "The red bag is (___).",
        options = listOf("her", "hers"),
        answer = "hers",
        explanation = "Ot yo‘q joyda: hers."
    ),
    Question.Matching(
        section = "2-mashq • Egasiga mos egalik olmoshini yozing",
        prompt = "Har bir egalik olmoshini egasiga bog‘lang.",
        pairs = listOf(
            "mine" to "I",
            "yours" to "you",
            "his" to "he",
            "hers" to "she",
            "ours" to "we",
            "theirs" to "they"
        ),
        options = listOf("I", "you", "he", "she", "we", "they"),
        explanation = "I—mine, you—yours, he—his, she—hers, we—ours, they—theirs."
    ),
    Question.Text(
        section = "2-mashq • Egasiga mos egalik olmoshini yozing",
        prompt = "I own this book. It is ___.",
        answers = setOf("mine"),
        explanation = "Meniki: mine."
    ),
    Question.Text(
        section = "2-mashq • Egasiga mos egalik olmoshini yozing",
        prompt = "You own this seat. It is ___.",
        answers = setOf("yours"),
        explanation = "Sizniki: yours."
    ),
    Question.Text(
        section = "2-mashq • Egasiga mos egalik olmoshini yozing",
        prompt = "He owns this bicycle. It is ___.",
        answers = setOf("his"),
        explanation = "Uniki (erkak): his."
    ),
    Question.Text(
        section = "2-mashq • Egasiga mos egalik olmoshini yozing",
        prompt = "She owns this phone. It is ___.",
        answers = setOf("hers"),
        explanation = "Uniki (ayol): hers."
    ),
    Question.Text(
        section = "2-mashq • Egasiga mos egalik olmoshini yozing",
        prompt = "We own this classroom. It is ___.",
        answers = setOf("ours"),
        explanation = "Bizniki: ours."
    ),
    Question.Text(
        section = "2-mashq • Egasiga mos egalik olmoshini yozing",
        prompt = "They own these bags. They are ___.",
        answers = setOf("theirs"),
        explanation = "Ularniki: theirs."
    ),
    Question.Text(
        section = "3-mashq • Ikki gapni takrorlamasdan birlashtiring",
        prompt = "«This is my pen. That is your pen.» — takrorlamasdan yozing.",
        answers = setOf("This is my pen. That is yours."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: This is my pen. That is yours."
    ),
    Question.Text(
        section = "3-mashq • Ikki gapni takrorlamasdan birlashtiring",
        prompt = "«This is her bag. That is his bag.» — takrorlamasdan yozing.",
        answers = setOf("This is her bag. That is his."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: This is her bag. That is his."
    ),
    Question.Text(
        section = "3-mashq • Ikki gapni takrorlamasdan birlashtiring",
        prompt = "«These are our books. Those are their books.» — takrorlamasdan yozing.",
        answers = setOf("These are our books. Those are theirs."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: These are our books. Those are theirs."
    ),
    Question.Text(
        section = "4-mashq • Whose savollariga javob bering",
        prompt = "Whose book is this? (I) — javob bering.",
        answers = setOf("It is mine."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: It is mine."
    ),
    Question.Text(
        section = "4-mashq • Whose savollariga javob bering",
        prompt = "Whose phone is that? (she) — javob bering.",
        answers = setOf("It is hers."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: It is hers."
    ),
    Question.Text(
        section = "4-mashq • Whose savollariga javob bering",
        prompt = "Whose bags are these? (they) — javob bering.",
        answers = setOf("They are theirs."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: They are theirs."
    ),
    Question.Text(
        section = "4-mashq • Whose savollariga javob bering",
        prompt = "Whose classroom is this? (we) — javob bering.",
        answers = setOf("It is ours."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: It is ours."
    ),
    Question.Choice(
        section = "5-mashq • Adjective yoki pronoun?",
        prompt = "This is ___ house.",
        options = listOf("our", "ours"),
        answer = "our",
        explanation = "Ot oldida adjective: our house."
    ),
    Question.Choice(
        section = "5-mashq • Adjective yoki pronoun?",
        prompt = "This house is ___.",
        options = listOf("our", "ours"),
        answer = "ours",
        explanation = "Ot yo‘q joyda pronoun: ours."
    ),
    Question.Choice(
        section = "5-mashq • Adjective yoki pronoun?",
        prompt = "___ name is Malika.",
        options = listOf("Her", "Hers"),
        answer = "Her",
        explanation = "Ot oldida adjective: Her name."
    ),
    Question.Choice(
        section = "5-mashq • Adjective yoki pronoun?",
        prompt = "The blue notebook is ___.",
        options = listOf("his", "he"),
        answer = "his",
        explanation = "Ot yo‘q joyda pronoun: his."
    ),
    Question.Choice(
        section = "5-mashq • Adjective yoki pronoun?",
        prompt = "Are these ___ keys?",
        options = listOf("their", "theirs"),
        answer = "their",
        explanation = "Ot oldida adjective: their keys."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «This is mine book.»",
        answers = setOf("This is my book."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: This is my book."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «The red bicycle is her.»",
        answers = setOf("The red bicycle is hers."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: The red bicycle is hers."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «Is this bag your’s?»",
        answers = setOf("Is this bag yours?"),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: Is this bag yours?"
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «That classroom is their.»",
        answers = setOf("That classroom is theirs."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: That classroom is theirs."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «The coat is my.»",
        answers = setOf("The coat is mine."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: The coat is mine."
    ),
    Question.Text(
        section = "7-mashq • Mini-dialog",
        prompt = "A: Is this your notebook? B: No, it isn’t ___. — to‘ldiring.",
        answers = setOf("mine"),
        explanation = "Bu yerda meniki: mine."
    ),
    Question.Text(
        section = "7-mashq • Mini-dialog",
        prompt = "B: …It’s Sara’s. It’s ___. (daftar Sara’ning) — to‘ldiring.",
        answers = setOf("hers"),
        explanation = "Sara ayol: hers."
    ),
    Question.Text(
        section = "7-mashq • Mini-dialog",
        prompt = "A: And is that our classroom? B: Yes, it’s ___. — to‘ldiring.",
        answers = setOf("ours"),
        explanation = "Bizniki: ours."
    )
)