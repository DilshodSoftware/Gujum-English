package com.example.gujumenglish.ui.grammar.practice

internal val lesson15Questions: List<Question> = listOf(
    Question.Choice(
        section = "1-mashq • Egasiga mos so‘zni tanlang",
        prompt = "I am Lola. This is (___) desk.",
        options = listOf("my", "her"),
        answer = "my",
        explanation = "Lola — men, shuning uchun my."
    ),
    Question.Choice(
        section = "1-mashq • Egasiga mos so‘zni tanlang",
        prompt = "Tom has a bike. (___) bike is blue.",
        options = listOf("His", "Her"),
        answer = "His",
        explanation = "Tom — erkak, shuning uchun his."
    ),
    Question.Choice(
        section = "1-mashq • Egasiga mos so‘zni tanlang",
        prompt = "Anna has a cat. (___) cat is small.",
        options = listOf("His", "Her"),
        answer = "Her",
        explanation = "Anna — ayol, shuning uchun her."
    ),
    Question.Choice(
        section = "1-mashq • Egasiga mos so‘zni tanlang",
        prompt = "We live here. This is (___) house.",
        options = listOf("our", "their"),
        answer = "our",
        explanation = "Biz — shuning uchun our."
    ),
    Question.Choice(
        section = "1-mashq • Egasiga mos so‘zni tanlang",
        prompt = "The boys have books. (___) books are new.",
        options = listOf("Their", "His"),
        answer = "Their",
        explanation = "Ko‘plik ega: their."
    ),
    Question.Choice(
        section = "1-mashq • Egasiga mos so‘zni tanlang",
        prompt = "You have a nice bag. Is this (___) bag?",
        options = listOf("your", "our"),
        answer = "your",
        explanation = "Siz — sizning: your."
    ),
    Question.Matching(
        section = "2-mashq • Subject pronoundan egalik so‘zini toping",
        prompt = "Har bir olmoshga mos possessive adjective bog‘lang.",
        pairs = listOf(
            "I" to "my",
            "you" to "your",
            "he" to "his",
            "she" to "her",
            "it" to "its",
            "we" to "our",
            "they" to "their"
        ),
        options = listOf("my", "your", "his", "her", "its", "our", "their"),
        explanation = "I—my, you—your, he—his, she—her, it—its, we—our, they—their."
    ),
    Question.Text(
        section = "3-mashq • Qisqa voqeani to‘ldiring",
        prompt = "I am Ben. ___ family is small.",
        answers = setOf("My"),
        explanation = "Men — my: My family is small."
    ),
    Question.Text(
        section = "3-mashq • Qisqa voqeani to‘ldiring",
        prompt = "My sister is Mia. ___ room is pink.",
        answers = setOf("Her"),
        explanation = "Mia — ayol: Her room is pink."
    ),
    Question.Text(
        section = "3-mashq • Qisqa voqeani to‘ldiring",
        prompt = "My brother is Leo. ___ room is blue.",
        answers = setOf("His"),
        explanation = "Leo — erkak: His room is blue."
    ),
    Question.Text(
        section = "3-mashq • Qisqa voqeani to‘ldiring",
        prompt = "We have a dog. ___ name is Max.",
        answers = setOf("Its"),
        explanation = "Narsa egasiga: Its name is Max."
    ),
    Question.Text(
        section = "3-mashq • Qisqa voqeani to‘ldiring",
        prompt = "We love ___ home.",
        answers = setOf("our"),
        explanation = "Biz — our: We love our home."
    ),
    Question.Text(
        section = "3-mashq • Qisqa voqeani to‘ldiring",
        prompt = "My parents have a car. ___ car is white.",
        answers = setOf("Their"),
        explanation = "Ota-onaning — their: Their car is white."
    ),
    Question.Choice(
        section = "4-mashq • Its yoki It’s?",
        prompt = "The cat is eating ___ food.",
        options = listOf("its", "it’s"),
        answer = "its",
        explanation = "Bu yerda egalik kerak: its food."
    ),
    Question.Choice(
        section = "4-mashq • Its yoki It’s?",
        prompt = "___ a very small kitten. (It is)",
        options = listOf("Its", "It’s"),
        answer = "It’s",
        explanation = "Bu yerda “it is” kerak: It’s a very small kitten."
    ),
    Question.Choice(
        section = "4-mashq • Its yoki It’s?",
        prompt = "The tree is old. ___ leaves are green.",
        options = listOf("its", "it’s"),
        answer = "its",
        explanation = "Bu yerda egalik kerak: Its leaves are green."
    ),
    Question.Choice(
        section = "4-mashq • Its yoki It’s?",
        prompt = "___ my new pencil. (It is)",
        options = listOf("Its", "It’s"),
        answer = "It’s",
        explanation = "Bu yerda “it is” kerak: It’s my new pencil."
    ),
    Question.Ordering(
        section = "5-mashq • Inglizchaga tarjima qiling",
        prompt = "«Mening ismim Sara.» — gapni tuzing.",
        words = listOf("Sara", "name", "My", "is"),
        answer = "My name is Sara.",
        explanation = "To‘g‘ri gap: My name is Sara."
    ),
    Question.Ordering(
        section = "5-mashq • Inglizchaga tarjima qiling",
        prompt = "«Uning (erkak) telefoni yangi.» — gapni tuzing.",
        words = listOf("phone", "His", "is", "new"),
        answer = "His phone is new.",
        explanation = "To‘g‘ri gap: His phone is new."
    ),
    Question.Ordering(
        section = "5-mashq • Inglizchaga tarjima qiling",
        prompt = "«Bizning o‘qituvchimiz mehribon.» — gapni tuzing.",
        words = listOf("Our", "kind", "teacher", "is"),
        answer = "Our teacher is kind.",
        explanation = "To‘g‘ri gap: Our teacher is kind."
    ),
    Question.Ordering(
        section = "5-mashq • Inglizchaga tarjima qiling",
        prompt = "«Ularning uyi katta.» — gapni tuzing.",
        words = listOf("big", "Their", "house", "is"),
        answer = "Their house is big.",
        explanation = "To‘g‘ri gap: Their house is big."
    ),
    Question.Ordering(
        section = "5-mashq • Inglizchaga tarjima qiling",
        prompt = "«Itning dumi uzun.» — gapni tuzing.",
        words = listOf("Its", "tail", "long", "is"),
        answer = "Its tail is long.",
        explanation = "To‘g‘ri gap: Its tail is long."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «Me book is here.»",
        answers = setOf("My book is here."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: My book is here."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «Tom is a boy. Her bag is black.»",
        answers = setOf("His bag is black."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: His bag is black."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «The dog has a ball. It’s ball is red.» (egalik)",
        answers = setOf("Its ball is red."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: Its ball is red."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «They classroom is large.»",
        answers = setOf("Their classroom is large."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: Their classroom is large."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «She name is Amina.»",
        answers = setOf("Her name is Amina."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: Her name is Amina."
    ),
    Question.Choice(
        section = "7-mashq • O‘zingiz haqingizda yozing",
        prompt = "Ismingizni aytish uchun qaysi boshlanish mos?",
        options = listOf("My name…", "Their name…", "His name…"),
        answer = "My name…",
        explanation = "O‘zingiz haqingizda: My name…"
    ),
    Question.Choice(
        section = "7-mashq • O‘zingiz haqingizda yozing",
        prompt = "Oilangiz haqida gap uchun qaysi boshlanish mos?",
        options = listOf("My name…", "My family…", "Its home…"),
        answer = "My family…",
        explanation = "Oila haqida: My family…"
    ),
    Question.Choice(
        section = "7-mashq • O‘zingiz haqingizda yozing",
        prompt = "Uyimiz haqida gap uchun qaysi boshlanish mos?",
        options = listOf("Our home…", "Their home…", "Your home…"),
        answer = "Our home…",
        explanation = "Bizning uy: Our home…"
    )
)