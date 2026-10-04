package com.example.gujumenglish.ui.grammar.practice

internal val lesson35Questions: List<Question> = listOf(
    Question.Text(
        section = "1-mashq • Are/Is yoki Do/Does?",
        prompt = "How ___ you today? (are / do)",
        answers = setOf("are"),
        explanation = "Ahvol haqida — to be: are."
    ),
    Question.Text(
        section = "1-mashq • Are/Is yoki Do/Does?",
        prompt = "How ___ your father travel to work? (does / is)",
        answers = setOf("does"),
        explanation = "Usul haqida — harakat fe’li: does."
    ),
    Question.Text(
        section = "1-mashq • Are/Is yoki Do/Does?",
        prompt = "How ___ the food? (is / does)",
        answers = setOf("is"),
        explanation = "Holat haqida — to be: is."
    ),
    Question.Text(
        section = "1-mashq • Are/Is yoki Do/Does?",
        prompt = "How ___ they learn new words? (do / are)",
        answers = setOf("do"),
        explanation = "Usul haqida — harakat fe’li: do."
    ),
    Question.Text(
        section = "1-mashq • Are/Is yoki Do/Does?",
        prompt = "How ___ your mother? (is / does)",
        answers = setOf("is"),
        explanation = "Ahvol haqida — to be: is."
    ),
    Question.Choice(
        section = "2-mashq • Savolga mos javobni tanlang",
        prompt = "How do you go to work? — qaysi javob to‘g‘ri?",
        options = listOf("By bus.", "At 8:00."),
        answer = "By bus.",
        explanation = "Usul javobi: By bus."
    ),
    Question.Choice(
        section = "2-mashq • Savolga mos javobni tanlang",
        prompt = "How are you? — qaysi javob to‘g‘ri?",
        options = listOf("I’m fine.", "I’m a doctor."),
        answer = "I’m fine.",
        explanation = "Ahvol javobi: I’m fine."
    ),
    Question.Choice(
        section = "2-mashq • Savolga mos javobni tanlang",
        prompt = "How does she travel? — qaysi javob to‘g‘ri?",
        options = listOf("By train.", "In Tashkent."),
        answer = "By train.",
        explanation = "Usul javobi: By train."
    ),
    Question.Choice(
        section = "2-mashq • Savolga mos javobni tanlang",
        prompt = "How do you spell “Mina”? — qaysi javob to‘g‘ri?",
        options = listOf("M-I-N-A.", "At school."),
        answer = "M-I-N-A.",
        explanation = "Yozish usuli: M-I-N-A."
    ),
    Question.Ordering(
        section = "3-mashq • So‘zlarni tartiblang",
        prompt = "are / how / you / ? — savolni tuzing.",
        words = listOf("are", "how", "you?"),
        answer = "How are you?",
        explanation = "To‘g‘ri savol: How are you?"
    ),
    Question.Ordering(
        section = "3-mashq • So‘zlarni tartiblang",
        prompt = "how / go / do / they / to school / ? — savolni tuzing.",
        words = listOf("Do", "how", "they", "to school", "go"),
        answer = "How do they go to school?",
        explanation = "To‘g‘ri savol: How do they go to school?"
    ),
    Question.Ordering(
        section = "3-mashq • So‘zlarni tartiblang",
        prompt = "your sister / how / is / ? — savolni tuzing.",
        words = listOf("your sister", "how", "is?"),
        answer = "How is your sister?",
        explanation = "To‘g‘ri savol: How is your sister?"
    ),
    Question.Ordering(
        section = "3-mashq • So‘zlarni tartiblang",
        prompt = "does / how / he / cook / rice / ? — savolni tuzing.",
        words = listOf("how", "he", "does", "cook", "rice?"),
        answer = "How does he cook rice?",
        explanation = "To‘g‘ri savol: How does he cook rice?"
    ),
    Question.Choice(
        section = "4-mashq • What yoki How?",
        prompt = "___ is your name? — My name is Lola.",
        options = listOf("What", "How"),
        answer = "What",
        explanation = "Ma’lumot haqida: What."
    ),
    Question.Choice(
        section = "4-mashq • What yoki How?",
        prompt = "___ are you? — I’m good.",
        options = listOf("What", "How"),
        answer = "How",
        explanation = "Ahvol haqida: How."
    ),
    Question.Choice(
        section = "4-mashq • What yoki How?",
        prompt = "___ do you travel? — By car.",
        options = listOf("What", "How"),
        answer = "How",
        explanation = "Usul haqida: How."
    ),
    Question.Choice(
        section = "4-mashq • What yoki How?",
        prompt = "___ is your favorite color? — Blue.",
        options = listOf("What", "How"),
        answer = "What",
        explanation = "Ma’lumot haqida: What."
    ),
    Question.Text(
        section = "5-mashq • Xatoni topib tuzating",
        prompt = "Xatoni tuzating: «How you go to school?»",
        answers = setOf("How do you go to school?"),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: How do you go to school?"
    ),
    Question.Text(
        section = "5-mashq • Xatoni topib tuzating",
        prompt = "Xatoni tuzating: «How does she travels?»",
        answers = setOf("How does she travel?"),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: How does she travel?"
    ),
    Question.Text(
        section = "5-mashq • Xatoni topib tuzating",
        prompt = "Xatoni tuzating: «How do you?» (ahvol so‘rash)",
        answers = setOf("How are you?"),
        mode = TextMode.SENTENCE,
        explanation = "Ahvol uchun to be kerak: How are you?"
    ),
    Question.Text(
        section = "5-mashq • Xatoni topib tuzating",
        prompt = "Xatoni tuzating: «How is your brother go to work?»",
        answers = setOf("How does your brother go to work?"),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: How does your brother go to work?"
    ),
    Question.Choice(
        section = "6-mashq • O‘zingiz haqida javob bering",
        prompt = "How are you today? — qanday javob beriladi?",
        options = listOf("ahvol bilan", "joy bilan"),
        answer = "ahvol bilan",
        explanation = "I’m fine, thank you."
    ),
    Question.Choice(
        section = "6-mashq • O‘zingiz haqida javob bering",
        prompt = "How do you come to school or work? — qanday javob beriladi?",
        options = listOf("usul bilan", "vaqt bilan"),
        answer = "usul bilan",
        explanation = "I come by bus."
    ),
    Question.Choice(
        section = "6-mashq • O‘zingiz haqida javob bering",
        prompt = "How do you spell your first name? — qanday javob beriladi?",
        options = listOf("harflar bilan", "joy bilan"),
        answer = "harflar bilan",
        explanation = "A-L-I."
    )
)