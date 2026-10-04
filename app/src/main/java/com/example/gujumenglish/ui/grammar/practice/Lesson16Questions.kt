package com.example.gujumenglish.ui.grammar.practice

internal val lesson16Questions: List<Question> = listOf(
    Question.Text(
        section = "1-mashq • Egalik birikmasini tuzing",
        prompt = "the book / Ali — egalik birikmasini yozing.",
        answers = setOf("Ali’s book", "the book of Ali"),
        explanation = "To‘g‘ri shakl: Ali’s book."
    ),
    Question.Text(
        section = "1-mashq • Egalik birikmasini tuzing",
        prompt = "the bag / the girl — egalik birikmasini yozing.",
        answers = setOf("the girl’s bag"),
        explanation = "To‘g‘ri shakl: the girl’s bag."
    ),
    Question.Text(
        section = "1-mashq • Egalik birikmasini tuzing",
        prompt = "the car / my father — egalik birikmasini yozing.",
        answers = setOf("my father’s car"),
        explanation = "To‘g‘ri shakl: my father’s car."
    ),
    Question.Text(
        section = "1-mashq • Egalik birikmasini tuzing",
        prompt = "the tail / the cat — egalik birikmasini yozing.",
        answers = setOf("the cat’s tail"),
        explanation = "To‘g‘ri shakl: the cat’s tail."
    ),
    Question.Text(
        section = "1-mashq • Egalik birikmasini tuzing",
        prompt = "the room / the teacher — egalik birikmasini yozing.",
        answers = setOf("the teacher’s room"),
        explanation = "To‘g‘ri shakl: the teacher’s room."
    ),
    Question.Text(
        section = "2-mashq • ’s yoki faqat apostrof?",
        prompt = "the boy___ bicycle (bitta bola) — to‘ldiring.",
        answers = setOf("boy’s"),
        explanation = "Birlik ega: boy’s bicycle."
    ),
    Question.Text(
        section = "2-mashq • ’s yoki faqat apostrof?",
        prompt = "the boys___ bicycles (bir nechta o‘g‘il bola) — to‘ldiring.",
        answers = setOf("boys’"),
        explanation = "Ko‘plik ega: faqat apostrof — boys’."
    ),
    Question.Text(
        section = "2-mashq • ’s yoki faqat apostrof?",
        prompt = "the students___ books — to‘ldiring.",
        answers = setOf("students’"),
        explanation = "students allaqachon -s bilan tugaydi: faqat apostrof."
    ),
    Question.Text(
        section = "2-mashq • ’s yoki faqat apostrof?",
        prompt = "the children___ toys — to‘ldiring.",
        answers = setOf("children’s"),
        explanation = "children -s bilan tugamaydi: to‘liq ’s qo‘shiladi."
    ),
    Question.Text(
        section = "2-mashq • ’s yoki faqat apostrof?",
        prompt = "the woman___ hat (bitta ayol) — to‘ldiring.",
        answers = setOf("woman’s"),
        explanation = "Birlik ega: woman’s hat."
    ),
    Question.Text(
        section = "2-mashq • ’s yoki faqat apostrof?",
        prompt = "the women___ bags (bir nechta ayol) — to‘ldiring.",
        answers = setOf("women’s"),
        explanation = "women -s bilan tugamaydi: women’s bags."
    ),
    Question.Matching(
        section = "3-mashq • Ma’no juftini toping",
        prompt = "Har bir birikmani to‘g‘ri ma’no bilan bog‘lang.",
        pairs = listOf(
            "the boy’s book" to "B — bitta bolaning kitobi",
            "the boys’ book" to "A — bir nechta bolaning kitobi",
            "the teacher’s room" to "D — bitta o‘qituvchining xonasi",
            "the teachers’ room" to "C — bir nechta o‘qituvchining xonasi"
        ),
        options = listOf(
            "A — bir nechta bolaning kitobi",
            "B — bitta bolaning kitobi",
            "C — bir nechta o‘qituvchining xonasi",
            "D — bitta o‘qituvchining xonasi"
        ),
        explanation = "Bitta ega → ’s, ko‘p ega → ’."
    ),
    Question.Ordering(
        section = "4-mashq • So‘zlarni to‘g‘ri tartiblang",
        prompt = "phone / Sara / the — egalik birikmasini tuzing.",
        words = listOf("phone", "sara's"),
        answer = "Sara’s phone.",
        explanation = "To‘g‘ri tartib: Sara’s phone."
    ),
    Question.Ordering(
        section = "4-mashq • So‘zlarni to‘g‘ri tartiblang",
        prompt = "toys / children / the — egalik birikmasini tuzing.",
        words = listOf("toys", "the", "children's"),
        answer = "the children’s toys.",
        explanation = "To‘g‘ri tartib: the children’s toys."
    ),
    Question.Ordering(
        section = "4-mashq • So‘zlarni to‘g‘ri tartiblang",
        prompt = "house / my parents / the — egalik birikmasini tuzing.",
        words = listOf("house", "parents'", "my"),
        answer = "my parents’ house.",
        explanation = "To‘g‘ri tartib: my parents’ house."
    ),
    Question.Ordering(
        section = "4-mashq • So‘zlarni to‘g‘ri tartiblang",
        prompt = "classroom / students / the — egalik birikmasini tuzing.",
        words = listOf("classroom", "the", "students'"),
        answer = "the students’ classroom.",
        explanation = "To‘g‘ri tartib: the students’ classroom."
    ),
    Question.Ordering(
        section = "5-mashq • Inglizchaga tarjima qiling",
        prompt = "«Alining ruchkasi» — gapni tuzing.",
        words = listOf("Ali’s", "pen"),
        answer = "Ali’s pen.",
        explanation = "To‘g‘ri javob: Ali’s pen."
    ),
    Question.Ordering(
        section = "5-mashq • Inglizchaga tarjima qiling",
        prompt = "«qizning velosipedi» — gapni tuzing.",
        words = listOf("bicycle", "the girl’s"),
        answer = "the girl’s bicycle.",
        explanation = "To‘g‘ri javob: the girl’s bicycle."
    ),
    Question.Ordering(
        section = "5-mashq • Inglizchaga tarjima qiling",
        prompt = "«o‘quvchilarning kitoblari» — gapni tuzing.",
        words = listOf("books", "the students’"),
        answer = "the students’ books.",
        explanation = "To‘g‘ri javob: the students’ books."
    ),
    Question.Ordering(
        section = "5-mashq • Inglizchaga tarjima qiling",
        prompt = "«bolalarning o‘yinchoqlari» — gapni tuzing.",
        words = listOf("the children’s", "toys"),
        answer = "the children’s toys.",
        explanation = "To‘g‘ri javob: the children’s toys."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «This is the girls bag.» (bitta qiz)",
        answers = setOf("This is the girl’s bag."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: This is the girl’s bag."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «My parents’s house is big.»",
        answers = setOf("My parents’ house is big."),
        mode = TextMode.SENTENCE,
        explanation = "Ko‘plik egada faqat apostrof: My parents’ house is big."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «The childrens’ toys are here.»",
        answers = setOf("The children’s toys are here."),
        mode = TextMode.SENTENCE,
        explanation = "children -s bilan tugamaydi: children’s toys."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Apostrofni narsa keyin qo‘ying: «the bag’s Sara.» — tuzatilgan shaklni yozing.",
        answers = setOf("Sara’s bag."),
        mode = TextMode.SENTENCE,
        explanation = "Ega oldinga keladi: Sara’s bag."
    ),
    Question.Choice(
        section = "7-mashq • Atrofingizdan misol yozing",
        prompt = "Bir kishiga tegishli narsa uchun qaysi shakl mos?",
        options = listOf("my brother’s phone", "my brothers phone"),
        answer = "my brother’s phone",
        explanation = "Birlik egada ’s kerak: my brother’s phone."
    ),
    Question.Choice(
        section = "7-mashq • Atrofingizdan misol yozing",
        prompt = "Ko‘plikdagi egalar tegishli narsa uchun qaysi shakl mos?",
        options = listOf("my friends classroom", "my friends’ classroom"),
        answer = "my friends’ classroom",
        explanation = "Ko‘plik egada faqat apostrof: my friends’ classroom."
    )
)