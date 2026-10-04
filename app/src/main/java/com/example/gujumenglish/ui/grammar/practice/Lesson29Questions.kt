package com.example.gujumenglish.ui.grammar.practice

internal val lesson29Questions: List<Question> = listOf(
    Question.Matching(
        section = "1-mashq • Savol so‘zini javob turi bilan moslang",
        prompt = "Har bir savol so‘zini to‘g‘ri javob turi bilan bog‘lang.",
        pairs = listOf(
            "What" to "E — narsa/ma’lumot",
            "Where" to "F — joy",
            "Who" to "A — odam",
            "When" to "C — vaqt",
            "Why" to "D — sabab",
            "How" to "B — usul/holat"
        ),
        options = listOf(
            "A — odam",
            "B — usul/holat",
            "C — vaqt",
            "D — sabab",
            "E — narsa/ma’lumot",
            "F — joy"
        ),
        explanation = "What—narsa; Where—joy; Who—odam; When—vaqt; Why—sabab; How—usul."
    ),
    Question.Text(
        section = "2-mashq • Ma’nosiga mos savol so‘zini tanlang",
        prompt = "___ is your name? (narsa/ma’lumot)",
        answers = setOf("What"),
        explanation = "Ma’lumot uchun: What."
    ),
    Question.Text(
        section = "2-mashq • Ma’nosiga mos savol so‘zini tanlang",
        prompt = "___ are my shoes? (joy)",
        answers = setOf("Where"),
        explanation = "Joy uchun: Where."
    ),
    Question.Text(
        section = "2-mashq • Ma’nosiga mos savol so‘zini tanlang",
        prompt = "___ is your best friend? (odam)",
        answers = setOf("Who"),
        explanation = "Odam uchun: Who."
    ),
    Question.Text(
        section = "2-mashq • Ma’nosiga mos savol so‘zini tanlang",
        prompt = "___ do you get up? (vaqt)",
        answers = setOf("When"),
        explanation = "Vaqt uchun: When."
    ),
    Question.Text(
        section = "2-mashq • Ma’nosiga mos savol so‘zini tanlang",
        prompt = "___ are you laughing? (sabab)",
        answers = setOf("Why"),
        explanation = "Sabab uchun: Why."
    ),
    Question.Text(
        section = "2-mashq • Ma’nosiga mos savol so‘zini tanlang",
        prompt = "___ do you go to work? (usul)",
        answers = setOf("How"),
        explanation = "Usul uchun: How."
    ),
    Question.Choice(
        section = "3-mashq • Savolning ikkinchi qismini tanlang",
        prompt = "Where do you…? (live / name)",
        options = listOf("live", "name"),
        answer = "live",
        explanation = "Where — joy haqida: Where do you live?"
    ),
    Question.Choice(
        section = "3-mashq • Savolning ikkinchi qismini tanlang",
        prompt = "What does she…? (cook / at home)",
        options = listOf("cook", "at home"),
        answer = "cook",
        explanation = "What — narsa haqida: What does she cook?"
    ),
    Question.Choice(
        section = "3-mashq • Savolning ikkinchi qismini tanlang",
        prompt = "When do they…? (study / the library)",
        options = listOf("study", "the library"),
        answer = "study",
        explanation = "When — vaqt haqida: When do they study?"
    ),
    Question.Choice(
        section = "3-mashq • Savolning ikkinchi qismini tanlang",
        prompt = "Why does he…? (run / because he is late)",
        options = listOf("run", "because he is late"),
        answer = "run",
        explanation = "Why — sabab haqida: Why does he run?"
    ),
    Question.Choice(
        section = "3-mashq • Savolning ikkinchi qismini tanlang",
        prompt = "How do you…? (travel / Monday)",
        options = listOf("travel", "Monday"),
        answer = "travel",
        explanation = "How — usul haqida: How do you travel?"
    ),
    Question.Ordering(
        section = "4-mashq • So‘zlarni tartibga solib savol tuzing",
        prompt = "where / your parents / do / work / ? — savolni tuzing.",
        words = listOf("where", "your parents", "do", "work?"),
        answer = "Where do your parents work?",
        explanation = "To‘g‘ri savol: Where do your parents work?"
    ),
    Question.Ordering(
        section = "4-mashq • So‘zlarni tartibga solib savol tuzing",
        prompt = "who / is / that man / ? — savolni tuzing.",
        words = listOf("who", "is", "that man?"),
        answer = "Who is that man?",
        explanation = "To‘g‘ri savol: Who is that man?"
    ),
    Question.Ordering(
        section = "4-mashq • So‘zlarni tartibga solib savol tuzing",
        prompt = "when / the lesson / is / ? — savolni tuzing.",
        words = listOf("when", "the lesson", "is?"),
        answer = "When is the lesson?",
        explanation = "To‘g‘ri savol: When is the lesson?"
    ),
    Question.Ordering(
        section = "4-mashq • So‘zlarni tartibga solib savol tuzing",
        prompt = "what / you / do / eat / for breakfast / ? — savolni tuzing.",
        words = listOf("what", "you", "do", "eat", "for breakfast?"),
        answer = "What do you eat for breakfast?",
        explanation = "To‘g‘ri savol: What do you eat for breakfast?"
    ),
    Question.Ordering(
        section = "4-mashq • So‘zlarni tartibga solib savol tuzing",
        prompt = "how / she / does / come to school / ? — savolni tuzing.",
        words = listOf("how", "she", "does", "come to school?"),
        answer = "How does she come to school?",
        explanation = "To‘g‘ri savol: How does she come to school?"
    ),
    Question.Choice(
        section = "5-mashq • To Be yoki Do/Does?",
        prompt = "Where ___ your sister?",
        options = listOf("is", "does"),
        answer = "is",
        explanation = "Kim/qayerda bo‘lsa — to be: is."
    ),
    Question.Choice(
        section = "5-mashq • To Be yoki Do/Does?",
        prompt = "Where ___ your sister work?",
        options = listOf("is", "does"),
        answer = "does",
        explanation = "Harakat fe’li — do/does: does."
    ),
    Question.Choice(
        section = "5-mashq • To Be yoki Do/Does?",
        prompt = "Who ___ your teacher?",
        options = listOf("is", "does"),
        answer = "is",
        explanation = "Kim ekanini so‘rash — to be: is."
    ),
    Question.Choice(
        section = "5-mashq • To Be yoki Do/Does?",
        prompt = "What ___ you like?",
        options = listOf("are", "do"),
        answer = "do",
        explanation = "Harakat fe’li: do."
    ),
    Question.Choice(
        section = "5-mashq • To Be yoki Do/Does?",
        prompt = "Why ___ they at home?",
        options = listOf("are", "do"),
        answer = "are",
        explanation = "Holat — to be: are."
    ),
    Question.Choice(
        section = "6-mashq • Savolga qanday javob kerak?",
        prompt = "What is this? — qanday javob kerak?",
        options = listOf("buyum nomi", "joy"),
        answer = "buyum nomi",
        explanation = "What — narsa nomini so‘raydi."
    ),
    Question.Choice(
        section = "6-mashq • Savolga qanday javob kerak?",
        prompt = "When do you study? — qanday javob kerak?",
        options = listOf("kun yoki vaqt", "odam"),
        answer = "kun yoki vaqt",
        explanation = "When — vaqtni so‘raydi."
    ),
    Question.Choice(
        section = "6-mashq • Savolga qanday javob kerak?",
        prompt = "Why is she happy? — qanday javob kerak?",
        options = listOf("sabab", "usul"),
        answer = "sabab",
        explanation = "Why — sababni so‘raydi."
    ),
    Question.Choice(
        section = "6-mashq • Savolga qanday javob kerak?",
        prompt = "Who is your doctor? — qanday javob kerak?",
        options = listOf("odam", "narsa"),
        answer = "odam",
        explanation = "Who — odamni so‘raydi."
    ),
    Question.Choice(
        section = "6-mashq • Savolga qanday javob kerak?",
        prompt = "How do you travel? — qanday javob kerak?",
        options = listOf("usul", "vaqt"),
        answer = "usul",
        explanation = "How — usulni so‘raydi."
    ),
    Question.Choice(
        section = "7-mashq • O‘zingiz haqingizda javob bering",
        prompt = "«Where do you live?» — qanday javob berasiz?",
        options = listOf("joy haqida", "vaqt haqida"),
        answer = "joy haqida",
        explanation = "Where — joy haqida javob beriladi."
    ),
    Question.Choice(
        section = "7-mashq • O‘zingiz haqingizda javob bering",
        prompt = "«What do you like?» — qanday javob berasiz?",
        options = listOf("narsa haqida", "odam haqida"),
        answer = "narsa haqida",
        explanation = "What — narsa haqida javob beriladi."
    ),
    Question.Choice(
        section = "7-mashq • O‘zingiz haqingizda javob bering",
        prompt = "«When do you study English?» — qanday javob berasiz?",
        options = listOf("vaqt haqida", "joy haqida"),
        answer = "vaqt haqida",
        explanation = "When — vaqt haqida javob beriladi."
    ),
    Question.Choice(
        section = "7-mashq • O‘zingiz haqingizda javob bering",
        prompt = "«How do you come to school or work?» — qanday javob berasiz?",
        options = listOf("usul haqida", "sabab haqida"),
        answer = "usul haqida",
        explanation = "How — usul haqida javob beriladi."
    )
)