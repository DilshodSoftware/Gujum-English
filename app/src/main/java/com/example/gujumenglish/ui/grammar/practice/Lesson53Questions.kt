package com.example.gujumenglish.ui.grammar.practice

internal val lesson53Questions: List<Question> = listOf(
    Question.Choice(
        section = "1-mashq • Did ning vazifasini aniqlang",
        prompt = "«Did you call your friend?» — did qanday?",
        options = listOf("yordamchi", "asosiy “qilmoq” fe’li"),
        answer = "yordamchi",
        explanation = "Savolda — yordamchi fe’l."
    ),
    Question.Choice(
        section = "1-mashq • Did ning vazifasini aniqlang",
        prompt = "«She did her homework yesterday.» — did qanday?",
        options = listOf("yordamchi", "asosiy “qilmoq” fe’li"),
        answer = "asosiy “qilmoq” fe’li",
        explanation = "Bu yerda did — ma’no beruvchi fe’l."
    ),
    Question.Choice(
        section = "1-mashq • Did ning vazifasini aniqlang",
        prompt = "«We didn’t clean the kitchen.» — didn’t qanday?",
        options = listOf("yordamchi", "asosiy “qilmoq” fe’li"),
        answer = "yordamchi",
        explanation = "Inkor gapda — yordamchi fe’l."
    ),
    Question.Choice(
        section = "1-mashq • Did ning vazifasini aniqlang",
        prompt = "«They did the exercise last night.» — did qanday?",
        options = listOf("yordamchi", "asosiy “qilmoq” fe’li"),
        answer = "asosiy “qilmoq” fe’li",
        explanation = "Bu yerda did — asosiy fe’l."
    ),
    Question.Text(
        section = "2-mashq • Did yoki Didn’t dan keyin fe’lni tanlang",
        prompt = "Did she (go / went) home?",
        answers = setOf("go"),
        explanation = "Did dan keyin oddiy shakl: go."
    ),
    Question.Text(
        section = "2-mashq • Did yoki Didn’t dan keyin fe’lni tanlang",
        prompt = "They didn’t (saw / see) the dog.",
        answers = setOf("see"),
        explanation = "Didn’t dan keyin oddiy shakl: see."
    ),
    Question.Text(
        section = "2-mashq • Did yoki Didn’t dan keyin fe’lni tanlang",
        prompt = "Did he (do / did) the dishes?",
        answers = setOf("do"),
        explanation = "Bu yerda do — asosiy fe’l bilan ma’no beradi."
    ),
    Question.Text(
        section = "2-mashq • Did yoki Didn’t dan keyin fe’lni tanlang",
        prompt = "I didn’t (bought / buy) anything.",
        answers = setOf("buy"),
        explanation = "Didn’t dan keyin oddiy shakl: buy."
    ),
    Question.Text(
        section = "2-mashq • Did yoki Didn’t dan keyin fe’lni tanlang",
        prompt = "Did you (played / play) chess?",
        answers = setOf("play"),
        explanation = "Did dan keyin oddiy shakl: play."
    ),
    Question.Text(
        section = "3-mashq • “Do” asosiy fe’l bo‘lganda",
        prompt = "I ___ my homework yesterday. (did / do)",
        answers = setOf("did"),
        explanation = "O‘tgan zamonda asosiy fe’l: did."
    ),
    Question.Ordering(
        section = "3-mashq • “Do” asosiy fe’l bo‘lganda",
        prompt = "___ you ___ your homework last night? — gapni tuzing.",
        words = listOf("Did", "you", "do", "your homework", "last night?"),
        answer = "Did you do your homework last night?",
        explanation = "To‘g‘ri savol: Did you do your homework last night?"
    ),
    Question.Text(
        section = "3-mashq • “Do” asosiy fe’l bo‘lganda",
        prompt = "He ___ the work yesterday. (did / does)",
        answers = setOf("did"),
        explanation = "O‘tgan zamonda: did."
    ),
    Question.Text(
        section = "3-mashq • “Do” asosiy fe’l bo‘lganda",
        prompt = "They didn’t ___ the dishes. (did / do)",
        answers = setOf("do"),
        explanation = "Asosiy fe’l oddiy shaklda: do."
    ),
    Question.Ordering(
        section = "4-mashq • Do/Does ni Did ga o‘zgartiring",
        prompt = "Do you play football? — o‘tgan zamonga o‘tkazing.",
        words = listOf("Did", "you", "football", "play"),
        answer = "Did you play football?",
        explanation = "To‘g‘ri shakl: Did you play football?"
    ),
    Question.Ordering(
        section = "4-mashq • Do/Does ni Did ga o‘zgartiring",
        prompt = "Does she work here? — o‘tgan zamonga o‘tkazing.",
        words = listOf("Did", "she", "here", "work"),
        answer = "Did she work here?",
        explanation = "To‘g‘ri shakl: Did she work here?"
    ),
    Question.Ordering(
        section = "4-mashq • Do/Does ni Did ga o‘zgartiring",
        prompt = "He doesn’t eat meat. — o‘tgan zamonga o‘tkazing.",
        words = listOf("He", "meat", "didn’t", "eat"),
        answer = "He didn’t eat meat.",
        explanation = "To‘g‘ri shakl: He didn’t eat meat."
    ),
    Question.Text(
        section = "5-mashq • Was/Were yoki Did/Didn’t?",
        prompt = "___ he at home yesterday? (to be savoli)",
        answers = setOf("Was"),
        explanation = "To be savoli: Was."
    ),
    Question.Text(
        section = "5-mashq • Was/Were yoki Did/Didn’t?",
        prompt = "___ he go home yesterday? (harakat savoli)",
        answers = setOf("Did"),
        explanation = "Harakat savoli: Did."
    ),
    Question.Text(
        section = "5-mashq • Was/Were yoki Did/Didn’t?",
        prompt = "They ___ not ready. (to be inkori)",
        answers = setOf("were"),
        explanation = "To be inkori: weren’t."
    ),
    Question.Text(
        section = "5-mashq • Was/Were yoki Did/Didn’t?",
        prompt = "They ___ not finish the work. (harakat inkori)",
        answers = setOf("did"),
        explanation = "Harakat inkori: didn’t."
    ),
    Question.Text(
        section = "6-mashq • Xatolarni tuzating",
        prompt = "Xatoni tuzating: «Did she did her homework?»",
        answers = setOf("Did she do her homework?"),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: Did she do her homework?"
    ),
    Question.Text(
        section = "6-mashq • Xatolarni tuzating",
        prompt = "Xatoni tuzating: «I didn’t did the dishes.»",
        answers = setOf("I didn’t do the dishes."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: I didn’t do the dishes."
    ),
    Question.Text(
        section = "6-mashq • Xatolarni tuzating",
        prompt = "Xatoni tuzating: «Did he went to school?»",
        answers = setOf("Did he go to school?"),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: Did he go to school?"
    ),
    Question.Text(
        section = "6-mashq • Xatolarni tuzating",
        prompt = "Xatoni tuzating: «Did they were tired?»",
        answers = setOf("Were they tired?"),
        mode = TextMode.SENTENCE,
        explanation = "To be savolida Did emas: Were."
    )
)