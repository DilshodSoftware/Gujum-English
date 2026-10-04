package com.example.gujumenglish.ui.grammar.practice

internal val lesson65Questions: List<Question> = listOf(
    Question.Choice(
        section = "1-qism • Zamonni aniqlang",
        prompt = "I walk to school every day.",
        options = listOf("Present Simple", "Present Continuous", "Past Simple", "Future"),
        answer = "Present Simple",
        explanation = "every day — odat: Present Simple."
    ),
    Question.Choice(
        section = "1-qism • Zamonni aniqlang",
        prompt = "My sister is cooking now.",
        options = listOf("Present Simple", "Present Continuous", "Past Simple", "Future"),
        answer = "Present Continuous",
        explanation = "now — ayni paytda: Present Continuous."
    ),
    Question.Choice(
        section = "1-qism • Zamonni aniqlang",
        prompt = "We visited Samarkand last year.",
        options = listOf("Present Simple", "Present Continuous", "Past Simple", "Future"),
        answer = "Past Simple",
        explanation = "last year — o‘tgan zamon."
    ),
    Question.Choice(
        section = "1-qism • Zamonni aniqlang",
        prompt = "They were at home yesterday.",
        options = listOf("Present Simple", "Present Continuous", "Past Simple", "Future"),
        answer = "Past Simple",
        explanation = "yesterday — o‘tgan zamon (Past of To Be)."
    ),
    Question.Choice(
        section = "1-qism • Zamonni aniqlang",
        prompt = "He is going to buy a new phone.",
        options = listOf("Present Simple", "Present Continuous", "Past Simple", "Future"),
        answer = "Future",
        explanation = "Kelajak — going to."
    ),
    Question.Choice(
        section = "1-qism • Zamonni aniqlang",
        prompt = "I think it will rain tonight.",
        options = listOf("Present Simple", "Present Continuous", "Past Simple", "Future"),
        answer = "Future",
        explanation = "Kelajak — will."
    ),
    Question.Choice(
        section = "2-qism • Present Simple yoki Present Continuous?",
        prompt = "She (works / is working) at a bank every day.",
        options = listOf("works", "is working"),
        answer = "works",
        explanation = "every day — odat: works."
    ),
    Question.Choice(
        section = "2-qism • Present Simple yoki Present Continuous?",
        prompt = "Look! The children (play / are playing) outside.",
        options = listOf("play", "are playing"),
        answer = "are playing",
        explanation = "Look! — ayni paytda."
    ),
    Question.Choice(
        section = "2-qism • Present Simple yoki Present Continuous?",
        prompt = "I (read / am reading) a book right now.",
        options = listOf("read", "am reading"),
        answer = "am reading",
        explanation = "right now — ayni paytda."
    ),
    Question.Choice(
        section = "2-qism • Present Simple yoki Present Continuous?",
        prompt = "My brother usually (walks / is walking) to work.",
        options = listOf("walks", "is walking"),
        answer = "walks",
        explanation = "usually — odat: walks."
    ),
    Question.Choice(
        section = "2-qism • Present Simple yoki Present Continuous?",
        prompt = "They (stay / are staying) with their aunt this week. (vaqtinchalik)",
        options = listOf("stay", "are staying"),
        answer = "are staying",
        explanation = "this week — vaqtinchalik holat."
    ),
    Question.Text(
        section = "3-qism • To Be: am/is/are, was/were",
        prompt = "I ___ tired today. (am / is)",
        answers = setOf("am"),
        explanation = "I bilan am."
    ),
    Question.Text(
        section = "3-qism • To Be: am/is/are, was/were",
        prompt = "The students ___ in the classroom now. (is / are)",
        answers = setOf("are"),
        explanation = "Ko‘plik bilan are."
    ),
    Question.Text(
        section = "3-qism • To Be: am/is/are, was/were",
        prompt = "We ___ at the museum yesterday. (was / were)",
        answers = setOf("were"),
        explanation = "O‘tgan zamon, ko‘plik: were."
    ),
    Question.Text(
        section = "3-qism • To Be: am/is/are, was/were",
        prompt = "My father ___ busy last night. (was / were)",
        answers = setOf("was"),
        explanation = "O‘tgan zamon, bitta ega: was."
    ),
    Question.Text(
        section = "3-qism • To Be: am/is/are, was/were",
        prompt = "Inkor qiling: She was at work.",
        answers = setOf("She wasn’t at work."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: She wasn’t at work."
    ),
    Question.Ordering(
        section = "3-qism • To Be: am/is/are, was/were",
        prompt = "Savol tuzing: They are ready.",
        words = listOf("Are", "they", "ready"),
        answer = "Are they ready?",
        explanation = "To‘g‘ri savol: Are they ready?"
    ),
    Question.Text(
        section = "4-qism • Present Simple: darak, inkor va savol",
        prompt = "My mother ___ (watch) TV in the evening.",
        answers = setOf("watches"),
        explanation = "Bitta ayol: watches."
    ),
    Question.Text(
        section = "4-qism • Present Simple: darak, inkor va savol",
        prompt = "The boys ___ (study) English after school.",
        answers = setOf("study"),
        explanation = "Ko‘plik bilan -s yo‘q: study."
    ),
    Question.Text(
        section = "4-qism • Present Simple: darak, inkor va savol",
        prompt = "Inkor qiling: He likes coffee.",
        answers = setOf("He doesn’t like coffee."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: He doesn’t like coffee."
    ),
    Question.Ordering(
        section = "4-qism • Present Simple: darak, inkor va savol",
        prompt = "Savol tuzing: Sara reads every night.",
        words = listOf("Does", "Sara", "every night", "read"),
        answer = "Does Sara read every night?",
        explanation = "To‘g‘ri savol: Does Sara read every night?"
    ),
    Question.Choice(
        section = "4-qism • Present Simple: darak, inkor va savol",
        prompt = "___ your friends live nearby? (Do / Does)",
        options = listOf("Do", "Does"),
        answer = "Do",
        explanation = "Ko‘plik bilan Do."
    ),
    Question.Text(
        section = "4-qism • Present Simple: darak, inkor va savol",
        prompt = "Does Tom ___ (go / goes) to school by bus?",
        answers = setOf("go"),
        explanation = "Does dan keyin oddiy shakl: go."
    ),
    Question.Text(
        section = "5-qism • O‘tgan harakat va Did",
        prompt = "clean → Past Simple: ___",
        answers = setOf("cleaned"),
        explanation = "Muntazam fe’l: cleaned."
    ),
    Question.Text(
        section = "5-qism • O‘tgan harakat va Did",
        prompt = "buy → Past Simple: ___",
        answers = setOf("bought"),
        explanation = "Irregular fe’l: bought."
    ),
    Question.Text(
        section = "5-qism • O‘tgan harakat va Did",
        prompt = "They ___ (go) to the park yesterday.",
        answers = setOf("went"),
        explanation = "Irregular fe’l: went."
    ),
    Question.Text(
        section = "5-qism • O‘tgan harakat va Did",
        prompt = "Inkor qiling: She saw the film.",
        answers = setOf("She didn’t see the film."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: She didn’t see the film."
    ),
    Question.Ordering(
        section = "5-qism • O‘tgan harakat va Did",
        prompt = "Savol tuzing: You worked last night.",
        words = listOf("Did", "you", "last night", "work"),
        answer = "Did you work last night?",
        explanation = "To‘g‘ri savol: Did you work last night?"
    ),
    Question.Choice(
        section = "5-qism • O‘tgan harakat va Did",
        prompt = "Did he ___ (eat / ate) breakfast?",
        options = listOf("eat", "ate"),
        answer = "eat",
        explanation = "Did dan keyin oddiy shakl: eat."
    ),
    Question.Choice(
        section = "6-qism • Kelajak: Going to yoki Will",
        prompt = "Oldindan reja: We ___ going to visit our cousins. (are / will)",
        options = listOf("are", "will"),
        answer = "are",
        explanation = "Ko‘plik + reja: are going to."
    ),
    Question.Choice(
        section = "6-qism • Kelajak: Going to yoki Will",
        prompt = "Going to dan keyin fe’lni tanlang: He is going to ___ (study / studies).",
        options = listOf("study", "studies"),
        answer = "study",
        explanation = "Going to dan keyin oddiy shakl: study."
    ),
    Question.Choice(
        section = "6-qism • Kelajak: Going to yoki Will",
        prompt = "Va’da: I ___ help you. (will / was)",
        options = listOf("will", "was"),
        answer = "will",
        explanation = "Va’da uchun: will."
    ),
    Question.Choice(
        section = "6-qism • Kelajak: Going to yoki Will",
        prompt = "Hozir qaror: «Eshikni men ochaman!» I ___ open the door. (will / am going)",
        options = listOf("will", "am going"),
        answer = "will",
        explanation = "Ayni paytdagi qaror: will."
    ),
    Question.Choice(
        section = "6-qism • Kelajak: Going to yoki Will",
        prompt = "Bulutlarni ko‘rib taxmin: It ___ going to rain. (is / will)",
        options = listOf("is", "will"),
        answer = "is",
        explanation = "Ko‘rinib turgan belgi: is going to."
    ),
    Question.Text(
        section = "7-qism • Xatoni tuzating",
        prompt = "Xatoni tuzating: «She is go to school every day.»",
        answers = setOf("She goes to school every day."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: She goes to school every day."
    ),
    Question.Text(
        section = "7-qism • Xatoni tuzating",
        prompt = "Xatoni tuzating: «He didn’t went home yesterday.»",
        answers = setOf("He didn’t go home yesterday."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: He didn’t go home yesterday."
    ),
    Question.Text(
        section = "7-qism • Xatoni tuzating",
        prompt = "Xatoni tuzating: «They was tired last night.»",
        answers = setOf("They were tired last night."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: They were tired last night."
    ),
    Question.Text(
        section = "7-qism • Xatoni tuzating",
        prompt = "Xatoni tuzating: «I am study English now.»",
        answers = setOf("I am studying English now."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: I am studying English now."
    ),
    Question.Ordering(
        section = "8-qism • Tarjima qiling",
        prompt = "«Men har kuni nonushta qilaman.» — gapni tuzing.",
        words = listOf("I", "have", "breakfast", "every day."),
        answer = "I have breakfast every day.",
        explanation = "Namunaviy javob: I have breakfast every day."
    ),
    Question.Ordering(
        section = "8-qism • Tarjima qiling",
        prompt = "«Ular hozir film tomosha qilyapti.» — gapni tuzing.",
        words = listOf("They", "are watching", "a film", "now."),
        answer = "They are watching a film now.",
        explanation = "Namunaviy javob: They are watching a film now."
    ),
    Question.Ordering(
        section = "8-qism • Tarjima qiling",
        prompt = "«Biz kecha bu yerda emas edik.» — gapni tuzing.",
        words = listOf("We", "weren’t", "here", "yesterday."),
        answer = "We weren’t here yesterday.",
        explanation = "Namunaviy javob: We weren’t here yesterday."
    ),
    Question.Ordering(
        section = "8-qism • Tarjima qiling",
        prompt = "«Men ertaga senga qo‘ng‘iroq qilmoqchiman.» (oldindan reja) — gapni tuzing.",
        words = listOf("Am", "I", "going to call", "you", "tomorrow"),
        answer = "I am going to call you tomorrow.",
        explanation = "Namunaviy javob: I am going to call you tomorrow."
    )
)