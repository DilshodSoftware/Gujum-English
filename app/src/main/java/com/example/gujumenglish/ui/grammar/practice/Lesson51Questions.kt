package com.example.gujumenglish.ui.grammar.practice

internal val lesson51Questions: List<Question> = listOf(
    Question.Matching(
        section = "1-mashq • Juft shakllarni moslang",
        prompt = "Har bir fe’lni to‘g‘ri o‘tgan shakl bilan bog‘lang.",
        pairs = listOf(
            "go" to "C. went",
            "come" to "D. came",
            "see" to "B. saw"
        ),
        options = listOf("A. drank", "B. saw", "C. went", "D. came", "E. ate"),
        explanation = "go—went; come—came; see—saw."
    ),
    Question.Matching(
        section = "1-mashq • Juft shakllarni moslang",
        prompt = "Qolgan fe’llarni to‘g‘ri o‘tgan shakl bilan bog‘lang.",
        pairs = listOf(
            "eat" to "E. ate",
            "drink" to "A. drank"
        ),
        options = listOf("A. drank", "B. saw", "C. went", "D. came", "E. ate"),
        explanation = "eat—ate; drink—drank."
    ),
    Question.Text(
        section = "2-mashq • Past shaklini yozing",
        prompt = "have → ___",
        answers = setOf("had"),
        explanation = "Irregular: had."
    ),
    Question.Text(
        section = "2-mashq • Past shaklini yozing",
        prompt = "do → ___",
        answers = setOf("did"),
        explanation = "Irregular: did."
    ),
    Question.Text(
        section = "2-mashq • Past shaklini yozing",
        prompt = "buy → ___",
        answers = setOf("bought"),
        explanation = "Irregular: bought."
    ),
    Question.Text(
        section = "2-mashq • Past shaklini yozing",
        prompt = "make → ___",
        answers = setOf("made"),
        explanation = "Irregular: made."
    ),
    Question.Text(
        section = "2-mashq • Past shaklini yozing",
        prompt = "take → ___",
        answers = setOf("took"),
        explanation = "Irregular: took."
    ),
    Question.Text(
        section = "2-mashq • Past shaklini yozing",
        prompt = "give → ___",
        answers = setOf("gave"),
        explanation = "Irregular: gave."
    ),
    Question.Text(
        section = "2-mashq • Past shaklini yozing",
        prompt = "find → ___",
        answers = setOf("found"),
        explanation = "Irregular: found."
    ),
    Question.Text(
        section = "2-mashq • Past shaklini yozing",
        prompt = "think → ___",
        answers = setOf("thought"),
        explanation = "Irregular: thought."
    ),
    Question.Text(
        section = "2-mashq • Past shaklini yozing",
        prompt = "read → ___",
        answers = setOf("read"),
        explanation = "Irregular: read (talaffuzi “red”)."
    ),
    Question.Text(
        section = "3-mashq • Gapni Past Simple bilan to‘ldiring",
        prompt = "We ___ to the park yesterday. (go)",
        answers = setOf("went"),
        explanation = "Irregular: went."
    ),
    Question.Text(
        section = "3-mashq • Gapni Past Simple bilan to‘ldiring",
        prompt = "She ___ a sandwich for lunch. (eat)",
        answers = setOf("ate"),
        explanation = "Irregular: ate."
    ),
    Question.Text(
        section = "3-mashq • Gapni Past Simple bilan to‘ldiring",
        prompt = "I ___ my friend at the shop. (see)",
        answers = setOf("saw"),
        explanation = "Irregular: saw."
    ),
    Question.Text(
        section = "3-mashq • Gapni Past Simple bilan to‘ldiring",
        prompt = "They ___ a new table last month. (buy)",
        answers = setOf("bought"),
        explanation = "Irregular: bought."
    ),
    Question.Text(
        section = "3-mashq • Gapni Past Simple bilan to‘ldiring",
        prompt = "He ___ a letter last night. (write)",
        answers = setOf("wrote"),
        explanation = "Irregular: wrote."
    ),
    Question.Matching(
        section = "4-mashq • Muntazammi yoki irregular?",
        prompt = "Har bir shaklni to‘g‘ri guruhga bog‘lang.",
        pairs = listOf(
            "wanted" to "muntazam (-ed)",
            "cleaned" to "muntazam (-ed)",
            "visited" to "muntazam (-ed)"
        ),
        options = listOf("muntazam (-ed)", "irregular"),
        explanation = "wanted, cleaned, visited — muntazam."
    ),
    Question.Matching(
        section = "4-mashq • Muntazammi yoki irregular?",
        prompt = "Har bir shaklni to‘g‘ri guruhga bog‘lang.",
        pairs = listOf(
            "went" to "irregular",
            "bought" to "irregular",
            "saw" to "irregular"
        ),
        options = listOf("muntazam (-ed)", "irregular"),
        explanation = "went, bought, saw — irregular."
    ),
    Question.Choice(
        section = "5-mashq • Mos fe’lni tanlang",
        prompt = "I (goed / went) home early.",
        options = listOf("goed", "went"),
        answer = "went",
        explanation = "Irregular fe’l: went."
    ),
    Question.Choice(
        section = "5-mashq • Mos fe’lni tanlang",
        prompt = "She (eated / ate) an orange.",
        options = listOf("eated", "ate"),
        answer = "ate",
        explanation = "Irregular fe’l: ate."
    ),
    Question.Choice(
        section = "5-mashq • Mos fe’lni tanlang",
        prompt = "We (saw / seed) a bird.",
        options = listOf("saw", "seed"),
        answer = "saw",
        explanation = "Irregular fe’l: saw."
    ),
    Question.Choice(
        section = "5-mashq • Mos fe’lni tanlang",
        prompt = "Tom (buyed / bought) a book.",
        options = listOf("buyed", "bought"),
        answer = "bought",
        explanation = "Irregular fe’l: bought."
    ),
    Question.Choice(
        section = "5-mashq • Mos fe’lni tanlang",
        prompt = "They (comed / came) late.",
        options = listOf("comed", "came"),
        answer = "came",
        explanation = "Irregular fe’l: came."
    ),
    Question.Ordering(
        section = "6-mashq • O‘tgan kun haqida gap tuzing",
        prompt = "(I / go / to the market / yesterday) — gapni tuzing.",
        words = listOf("I", "to the market", "yesterday", "went"),
        answer = "I went to the market yesterday.",
        explanation = "To‘g‘ri gap: I went to the market yesterday."
    ),
    Question.Ordering(
        section = "6-mashq • O‘tgan kun haqida gap tuzing",
        prompt = "(My sister / make / a cake / last night) — gapni tuzing.",
        words = listOf("My sister", "a cake", "last night", "made"),
        answer = "My sister made a cake last night.",
        explanation = "To‘g‘ri gap: My sister made a cake last night."
    ),
    Question.Ordering(
        section = "6-mashq • O‘tgan kun haqida gap tuzing",
        prompt = "(We / see / our teacher / two days ago) — gapni tuzing.",
        words = listOf("We", "our teacher", "two days ago", "saw"),
        answer = "We saw our teacher two days ago.",
        explanation = "To‘g‘ri gap: We saw our teacher two days ago."
    )
)