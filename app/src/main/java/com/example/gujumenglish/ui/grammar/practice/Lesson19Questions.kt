package com.example.gujumenglish.ui.grammar.practice

internal val lesson19Questions: List<Question> = listOf(
    Question.Matching(
        section = "1-mashq • Gap bo‘laklarini ajrating",
        prompt = "«The boy eats an apple.» — bo‘laklarni bog‘lang.",
        pairs = listOf(
            "the boy" to "Subject",
            "eats" to "Verb",
            "an apple" to "Object"
        ),
        options = listOf("Subject", "Verb", "Object"),
        explanation = "the boy — Subject, eats — Verb, an apple — Object."
    ),
    Question.Matching(
        section = "1-mashq • Gap bo‘laklarini ajrating",
        prompt = "«We play football.» — bo‘laklarni bog‘lang.",
        pairs = listOf(
            "We" to "Subject",
            "play" to "Verb",
            "football" to "Object"
        ),
        options = listOf("Subject", "Verb", "Object"),
        explanation = "We — Subject, play — Verb, football — Object."
    ),
    Question.Matching(
        section = "1-mashq • Gap bo‘laklarini ajrating",
        prompt = "«My mother reads a story.» — bo‘laklarni bog‘lang.",
        pairs = listOf(
            "My mother" to "Subject",
            "reads" to "Verb",
            "a story" to "Object"
        ),
        options = listOf("Subject", "Verb", "Object"),
        explanation = "My mother — Subject, reads — Verb, a story — Object."
    ),
    Question.Choice(
        section = "1-mashq • Gap bo‘laklarini ajrating",
        prompt = "«Birds fly.» — bu gapda object bormi?",
        options = listOf("ha, bor", "yo‘q, object kerak emas"),
        answer = "yo‘q, object kerak emas",
        explanation = "Bu gap to‘liq, object shart emas."
    ),
    Question.Matching(
        section = "1-mashq • Gap bo‘laklarini ajrating",
        prompt = "«They see the teacher.» — bo‘laklarni bog‘lang.",
        pairs = listOf(
            "They" to "Subject",
            "see" to "Verb",
            "the teacher" to "Object"
        ),
        options = listOf("Subject", "Verb", "Object"),
        explanation = "They — Subject, see — Verb, the teacher — Object."
    ),
    Question.Ordering(
        section = "2-mashq • So‘zlarni to‘g‘ri tartiblang",
        prompt = "apples / eat / I — gapni tuzing.",
        words = listOf("apples", "eat", "I"),
        answer = "I eat apples.",
        explanation = "To‘g‘ri tartib: I eat apples."
    ),
    Question.Ordering(
        section = "2-mashq • So‘zlarni to‘g‘ri tartiblang",
        prompt = "a book / reads / Sara — gapni tuzing.",
        words = listOf("a book", "reads", "Sara"),
        answer = "Sara reads a book.",
        explanation = "To‘g‘ri tartib: Sara reads a book."
    ),
    Question.Ordering(
        section = "2-mashq • So‘zlarni to‘g‘ri tartiblang",
        prompt = "the dog / they / see — gapni tuzing.",
        words = listOf("the dog", "they", "see"),
        answer = "They see the dog.",
        explanation = "To‘g‘ri tartib: They see the dog."
    ),
    Question.Ordering(
        section = "2-mashq • So‘zlarni to‘g‘ri tartiblang",
        prompt = "music / likes / my brother — gapni tuzing.",
        words = listOf("music", "likes", "my brother"),
        answer = "My brother likes music.",
        explanation = "To‘g‘ri tartib: My brother likes music."
    ),
    Question.Ordering(
        section = "2-mashq • So‘zlarni to‘g‘ri tartiblang",
        prompt = "sleep / the babies — gapni tuzing.",
        words = listOf("sleep", "the babies"),
        answer = "The babies sleep.",
        explanation = "To‘g‘ri tartib: The babies sleep."
    ),
    Question.Ordering(
        section = "2-mashq • So‘zlarni to‘g‘ri tartiblang",
        prompt = "helps / us / our teacher — gapni tuzing.",
        words = listOf("helps", "us", "our teacher"),
        answer = "Our teacher helps us.",
        explanation = "To‘g‘ri tartib: Our teacher helps us."
    ),
    Question.Choice(
        section = "3-mashq • Subjectmi yoki Objectmi?",
        prompt = "«___ knows me.» — qalin so‘z qaysi bo‘lak?",
        options = listOf("Subject", "Object"),
        answer = "Subject",
        explanation = "Gapni boshlagan so‘z — Subject."
    ),
    Question.Choice(
        section = "3-mashq • Subjectmi yoki Objectmi?",
        prompt = "«I know ___.» — qalin so‘z qaysi bo‘lak?",
        options = listOf("Subject", "Object"),
        answer = "Object",
        explanation = "Fe’ldan keyingi narsa — Object."
    ),
    Question.Choice(
        section = "3-mashq • Subjectmi yoki Objectmi?",
        prompt = "«___ help us.» — qalin so‘z qaysi bo‘lak?",
        options = listOf("Subject", "Object"),
        answer = "Subject",
        explanation = "Gapni boshlagan so‘z — Subject."
    ),
    Question.Choice(
        section = "3-mashq • Subjectmi yoki Objectmi?",
        prompt = "«We see ___.» — qalin so‘z qaysi bo‘lak?",
        options = listOf("Subject", "Object"),
        answer = "Object",
        explanation = "Fe’ldan keyingi narsa — Object."
    ),
    Question.Choice(
        section = "3-mashq • Subjectmi yoki Objectmi?",
        prompt = "«My father calls Ali.» — qaysi so‘z Object?",
        options = listOf("My father", "Ali"),
        answer = "Ali",
        explanation = "Ali — harakat qaratilgan: Object."
    ),
    Question.Choice(
        section = "3-mashq • Subjectmi yoki Objectmi?",
        prompt = "«Sara likes her.» — qaysi so‘z Object?",
        options = listOf("Sara", "her"),
        answer = "her",
        explanation = "her — harakat qaratilgan: Object."
    ),
    Question.Choice(
        section = "4-mashq • Object olmoshini tanlang",
        prompt = "I see (he / him).",
        options = listOf("he", "him"),
        answer = "him",
        explanation = "Object bilan -m: him."
    ),
    Question.Choice(
        section = "4-mashq • Object olmoshini tanlang",
        prompt = "(They / Them) know my sister.",
        options = listOf("They", "Them"),
        answer = "They",
        explanation = "Gap boshida — Subject: They."
    ),
    Question.Choice(
        section = "4-mashq • Object olmoshini tanlang",
        prompt = "The teacher helps (we / us).",
        options = listOf("we", "us"),
        answer = "us",
        explanation = "Object bilan -m: us."
    ),
    Question.Choice(
        section = "4-mashq • Object olmoshini tanlang",
        prompt = "(She / Her) likes Tom.",
        options = listOf("She", "Her"),
        answer = "She",
        explanation = "Gap boshida — Subject: She."
    ),
    Question.Choice(
        section = "4-mashq • Object olmoshini tanlang",
        prompt = "We visit (they / them).",
        options = listOf("they", "them"),
        answer = "them",
        explanation = "Object bilan -m: them."
    ),
    Question.Choice(
        section = "4-mashq • Object olmoshini tanlang",
        prompt = "Ali calls (I / me).",
        options = listOf("I", "me"),
        answer = "me",
        explanation = "Object bilan -m: me."
    ),
    Question.Choice(
        section = "5-mashq • Kerak bo‘lsa Object qo‘shing",
        prompt = "«Birds fly.» — object kerakmi?",
        options = listOf("object kerak emas", "object kerak"),
        answer = "object kerak emas",
        explanation = "Gap o‘zi tugallanadi, object shart emas."
    ),
    Question.Text(
        section = "5-mashq • Kerak bo‘lsa Object qo‘shing",
        prompt = "«I read ___.» (a magazine) — bo‘sh joyni to‘ldiring.",
        answers = setOf("a magazine"),
        explanation = "To‘g‘ri shakl: I read a magazine."
    ),
    Question.Choice(
        section = "5-mashq • Kerak bo‘lsa Object qo‘shing",
        prompt = "«The baby sleeps.» — object kerakmi?",
        options = listOf("object kerak emas", "object kerak"),
        answer = "object kerak emas",
        explanation = "Gap o‘zi tugallanadi, object shart emas."
    ),
    Question.Text(
        section = "5-mashq • Kerak bo‘lsa Object qo‘shing",
        prompt = "«We like ___.» (our school) — bo‘sh joyni to‘ldiring.",
        answers = setOf("our school"),
        explanation = "To‘g‘ri shakl: We like our school."
    ),
    Question.Ordering(
        section = "6-mashq • Gap tuzish poyezdi",
        prompt = "Subject: The children · Verb: watch · Object: a film — gapni tuzing.",
        words = listOf("The children", "watch", "a film"),
        answer = "The children watch a film.",
        explanation = "To‘g‘ri gap: The children watch a film."
    ),
    Question.Ordering(
        section = "6-mashq • Gap tuzish poyezdi",
        prompt = "Subject: My friend · Verb: likes · Object: chocolate — gapni tuzing.",
        words = listOf("My friend", "likes", "chocolate"),
        answer = "My friend likes chocolate.",
        explanation = "To‘g‘ri gap: My friend likes chocolate."
    ),
    Question.Ordering(
        section = "6-mashq • Gap tuzish poyezdi",
        prompt = "Subject: Cats · Verb: sleep — gapni tuzing.",
        words = listOf("Cats", "sleep"),
        answer = "Cats sleep.",
        explanation = "Object yo‘q: Cats sleep."
    ),
    Question.Ordering(
        section = "6-mashq • Gap tuzish poyezdi",
        prompt = "Subject: We · Verb: visit · Object: our grandmother — gapni tuzing.",
        words = listOf("We", "visit", "our grandmother"),
        answer = "We visit our grandmother.",
        explanation = "To‘g‘ri gap: We visit our grandmother."
    ),
    Question.Text(
        section = "7-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «She the book reads.»",
        answers = setOf("She reads the book."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: She reads the book."
    ),
    Question.Text(
        section = "7-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «Likes Ali music.»",
        answers = setOf("Ali likes music."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: Ali likes music."
    ),
    Question.Text(
        section = "7-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «Him sees I.»",
        answers = setOf("I see him."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: I see him."
    ),
    Question.Text(
        section = "7-mashq • Xatoni tuzating",
        prompt = "Xatoni tuzating: «They the teacher help.»",
        answers = setOf("They help the teacher."),
        mode = TextMode.SENTENCE,
        explanation = "To‘g‘ri shakl: They help the teacher."
    ),
    Question.TrueFalse(
        section = "8-mashq • O‘zingiz 3 ta gap tuzing",
        prompt = "Inglizcha darak gapda subject odatda gap boshida turadi.",
        answer = true,
        explanation = "Bu gap to‘g‘ri: Subject + Verb + Object tartibi."
    ),
    Question.TrueFalse(
        section = "8-mashq • O‘zingiz 3 ta gap tuzing",
        prompt = "Barcha gaplarda object bo‘lishi shart.",
        answer = false,
        explanation = "Bu gap noto‘g‘ri: Birds fly kabi gaplarda object kerak bo‘lmaydi."
    ),
    Question.Choice(
        section = "8-mashq • O‘zingiz 3 ta gap tuzing",
        prompt = "Uchinchi gapda qaysi shakl ishlatiladi?",
        options = listOf("subject olmoshi", "object olmoshi"),
        answer = "object olmoshi",
        explanation = "Masalan: I know her."
    )
)