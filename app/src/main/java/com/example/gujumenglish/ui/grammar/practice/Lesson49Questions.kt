package com.example.gujumenglish.ui.grammar.practice

internal val lesson49Questions: List<Question> = listOf(
    Question.Text(
        section = "1-mashq • Was yoki Were?",
        prompt = "I ___ at home last night.",
        answers = setOf("was"),
        explanation = "I bilan was."
    ),
    Question.Text(
        section = "1-mashq • Was yoki Were?",
        prompt = "My friends ___ tired yesterday.",
        answers = setOf("were"),
        explanation = "Ko‘plik bilan were."
    ),
    Question.Text(
        section = "1-mashq • Was yoki Were?",
        prompt = "The weather ___ cold.",
        answers = setOf("was"),
        explanation = "Bitta narsa bilan was."
    ),
    Question.Text(
        section = "1-mashq • Was yoki Were?",
        prompt = "You ___ very kind.",
        answers = setOf("were"),
        explanation = "You bilan were."
    ),
    Question.Text(
        section = "1-mashq • Was yoki Were?",
        prompt = "Ali and Sara ___ at the park.",
        answers = setOf("were"),
        explanation = "Ko‘plik bilan were."
    ),
    Question.Text(
        section = "1-mashq • Was yoki Were?",
        prompt = "The book ___ on the desk.",
        answers = setOf("was"),
        explanation = "Bitta narsa bilan was."
    ),
    Question.Matching(
        section = "1-mashq • Was yoki Were?",
        prompt = "Har bir ega uchun mos shaklni bog‘lang.",
        pairs = listOf(
            "I" to "was",
            "he" to "was",
            "she" to "was",
            "it" to "was",
            "we" to "were",
            "they" to "were",
            "the book" to "was",
            "my friends" to "were"
        ),
        options = listOf("was", "were"),
        explanation = "I/he/she/it va bitta ega → was; you/we/they va ko‘plik → were."
    ),
    Question.Text(
        section = "2-mashq • Inkor shakliga o‘tkazing",
        prompt = "She was busy yesterday. — inkor shaklini yozing.",
        answers = setOf("She wasn’t busy yesterday."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: She wasn’t busy yesterday."
    ),
    Question.Text(
        section = "2-mashq • Inkor shakliga o‘tkazing",
        prompt = "We were at school. — inkor shaklini yozing.",
        answers = setOf("We weren’t at school."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: We weren’t at school."
    ),
    Question.Text(
        section = "2-mashq • Inkor shakliga o‘tkazing",
        prompt = "The film was interesting. — inkor shaklini yozing.",
        answers = setOf("The film wasn’t interesting."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: The film wasn’t interesting."
    ),
    Question.Text(
        section = "2-mashq • Inkor shakliga o‘tkazing",
        prompt = "They were late. — inkor shaklini yozing.",
        answers = setOf("They weren’t late."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: They weren’t late."
    ),
    Question.Ordering(
        section = "3-mashq • Gapni savolga aylantiring",
        prompt = "He was at work. — savolga aylantiring.",
        words = listOf("Was", "he", "at work"),
        answer = "Was he at work?",
        explanation = "To‘g‘ri savol: Was he at work?"
    ),
    Question.Ordering(
        section = "3-mashq • Gapni savolga aylantiring",
        prompt = "You were happy. — savolga aylantiring.",
        words = listOf("Were", "you", "happy"),
        answer = "Were you happy?",
        explanation = "To‘g‘ri savol: Were you happy?"
    ),
    Question.Ordering(
        section = "3-mashq • Gapni savolga aylantiring",
        prompt = "The children were hungry. — savolga aylantiring.",
        words = listOf("Were", "the children", "hungry"),
        answer = "Were the children hungry?",
        explanation = "To‘g‘ri savol: Were the children hungry?"
    ),
    Question.Ordering(
        section = "3-mashq • Gapni savolga aylantiring",
        prompt = "It was sunny yesterday. — savolga aylantiring.",
        words = listOf("Was", "it", "sunny yesterday"),
        answer = "Was it sunny yesterday?",
        explanation = "To‘g‘ri savol: Was it sunny yesterday?"
    ),
    Question.Text(
        section = "4-mashq • Qisqa javob yozing",
        prompt = "Were you at home? (ha, o‘zingiz haqingizda) — javob bering.",
        answers = setOf("Yes, I was."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: Yes, I was."
    ),
    Question.Text(
        section = "4-mashq • Qisqa javob yozing",
        prompt = "Was Sara tired? (yo‘q) — javob bering.",
        answers = setOf("No, she wasn’t."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: No, she wasn’t."
    ),
    Question.Text(
        section = "4-mashq • Qisqa javob yozing",
        prompt = "Were they friends? (ha) — javob bering.",
        answers = setOf("Yes, they were."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: Yes, they were."
    ),
    Question.Text(
        section = "4-mashq • Qisqa javob yozing",
        prompt = "Was the shop open? (yo‘q) — javob bering.",
        answers = setOf("No, it wasn’t."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri javob: No, it wasn’t."
    ),
    Question.Text(
        section = "5-mashq • Yesterday, Last yoki Ago bilan to‘ldiring",
        prompt = "I was at the cinema ___ night.",
        answers = setOf("last"),
        explanation = "To‘g‘ri shakl: last night."
    ),
    Question.Text(
        section = "5-mashq • Yesterday, Last yoki Ago bilan to‘ldiring",
        prompt = "They were in Bukhara ___ week.",
        answers = setOf("last"),
        explanation = "To‘g‘ri shakl: last week."
    ),
    Question.Text(
        section = "5-mashq • Yesterday, Last yoki Ago bilan to‘ldiring",
        prompt = "He was sick two days ___.",
        answers = setOf("ago"),
        explanation = "To‘g‘ri shakl: two days ago."
    ),
    Question.Text(
        section = "5-mashq • Yesterday, Last yoki Ago bilan to‘ldiring",
        prompt = "We were busy ___.",
        answers = setOf("yesterday"),
        explanation = "To‘g‘ri shakl: yesterday."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «They was happy.»",
        answers = setOf("They were happy."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: They were happy."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «Did she was at school?»",
        answers = setOf("Was she at school?"),
        mode = TextMode.SENTENCE,
        explanation = "Was savolda did kerak emas."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «I were tired.»",
        answers = setOf("I was tired."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: I was tired."
    ),
    Question.Text(
        section = "6-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «He didn’t was at home.»",
        answers = setOf("He wasn’t at home."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: He wasn’t at home."
    )
)