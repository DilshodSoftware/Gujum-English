package com.example.gujumenglish.ui.grammar.practice

internal val lesson4Questions: List<Question> = listOf(
    Question.Matching(
        section = "1-mashq • Harfmi yoki tovushmi?",
        prompt = "Har bir ta’rifga to‘g‘ri javobni bog‘lang.",
        pairs = listOf(
            "Yozamiz va ko‘z bilan ko‘ramiz" to "harf",
            "Aytamiz va quloq bilan eshitamiz" to "tovush",
            "C — yozuvdagi belgi" to "harf",
            "[k] — aytiladigan ovoz" to "tovush"
        ),
        options = listOf("harf", "tovush"),
        explanation = "Yozuv belgisi — harf, aytiladigan ovoz — tovush."
    ),
    Question.Choice(
        section = "2-mashq • C harfining tovushini tanlang",
        prompt = "cat so‘zidagi c «k»ga yaqinmi yoki «s»ga?",
        options = listOf("k", "s"),
        answer = "k",
        explanation = "cat so‘zida c «k»ga yaqin aytiladi."
    ),
    Question.Choice(
        section = "2-mashq • C harfining tovushini tanlang",
        prompt = "city so‘zidagi c «k»ga yaqinmi yoki «s»ga?",
        options = listOf("k", "s"),
        answer = "s",
        explanation = "city so‘zida c «s»ga yaqin aytiladi."
    ),
    Question.TrueFalse(
        section = "2-mashq • C harfining tovushini tanlang",
        prompt = "C harfining alifbodagi nomi bilan so‘z ichidagi tovushi doimo bir xil.",
        answer = false,
        explanation = "Bu gap noto‘g‘ri: cat da «k»ga, city da «s»ga yaqin."
    ),
    Question.Choice(
        section = "3-mashq • Boshqa talaffuz misollari",
        prompt = "go so‘zida g qanday aytiladi?",
        options = listOf("g ga yaqin", "j ga yaqin"),
        answer = "g ga yaqin",
        explanation = "go so‘zida g «g»ga yaqin aytiladi."
    ),
    Question.Choice(
        section = "3-mashq • Boshqa talaffuz misollari",
        prompt = "gym so‘zida g qanday aytiladi?",
        options = listOf("g ga yaqin", "j ga yaqin"),
        answer = "j ga yaqin",
        explanation = "gym so‘zida g «j»ga yaqin aytiladi."
    ),
    Question.TrueFalse(
        section = "3-mashq • Boshqa talaffuz misollari",
        prompt = "A harfining alifbodagi nomi «ey». cake so‘zidagi a ham «ey»ga yaqin.",
        answer = true,
        explanation = "Bu gap to‘g‘ri: cake so‘zida a «ey»ga yaqin."
    ),
    Question.Text(
        section = "4-mashq • Yozilgan, lekin aytilmaydigan harf",
        prompt = "listen so‘zida qaysi harf aytilmaydi?",
        answers = setOf("t"),
        explanation = "listen so‘zida t aytilmaydi."
    ),
    Question.Text(
        section = "4-mashq • Yozilgan, lekin aytilmaydigan harf",
        prompt = "know so‘zining boshida qaysi harf aytilmaydi?",
        answers = setOf("k"),
        explanation = "know so‘zida boshdagi k aytilmaydi."
    ),
    Question.Text(
        section = "4-mashq • Yozilgan, lekin aytilmaydigan harf",
        prompt = "lamb so‘zining oxirida qaysi harf aytilmaydi?",
        answers = setOf("b"),
        explanation = "lamb so‘zida oxirgi b aytilmaydi."
    ),
    Question.TrueFalse(
        section = "5-mashq • To‘g‘ri yoki noto‘g‘ri?",
        prompt = "Harf yozuvda ko‘rinadi.",
        answer = true,
        explanation = "Bu gap to‘g‘ri: harf yozuv belgisidir."
    ),
    Question.TrueFalse(
        section = "5-mashq • To‘g‘ri yoki noto‘g‘ri?",
        prompt = "Tovushni quloq bilan eshitamiz.",
        answer = true,
        explanation = "Bu gap to‘g‘ri: tovush eshitiladigan ovozdir."
    ),
    Question.TrueFalse(
        section = "5-mashq • To‘g‘ri yoki noto‘g‘ri?",
        prompt = "Har bir harf faqat bitta xil tovush beradi.",
        answer = false,
        explanation = "Bu gap noto‘g‘ri: bitta harf turli tovush berishi mumkin."
    ),
    Question.TrueFalse(
        section = "5-mashq • To‘g‘ri yoki noto‘g‘ri?",
        prompt = "Ba’zi yozilgan harflar so‘zda aytilmasligi mumkin.",
        answer = true,
        explanation = "Bu gap to‘g‘ri: bular silent letters deyiladi."
    ),
    Question.Choice(
        section = "6-mashq • So‘zni o‘rganish tartibini tanlang",
        prompt = "Yangi so‘zni o‘rganishda qaysi tartib foydaliroq?",
        options = listOf(
            "Faqat harflarga qarab taxmin qilish",
            "Yozilishini ko‘rish, talaffuzini tinglash, ovoz chiqarib takrorlash"
        ),
        answer = "Yozilishini ko‘rish, talaffuzini tinglash, ovoz chiqarib takrorlash",
        explanation = "To‘g‘ri javob: B. Harf nomi bilan tovush bir xil bo‘lmaydi."
    )
)
