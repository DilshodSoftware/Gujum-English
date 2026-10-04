package com.example.gujumenglish.ui.grammar.practice

/**
 * Dars raqami -> savollar to‘plami.
 *
 * 1-dars (Boshlang‘ich lug‘at) dan 67-dars (Numbers 1–100) gacha testlar bor.
 * Yangi darsning savollari tayyor bo‘lganda shu ro‘yxatga bitta qator qo‘shiladi
 * (masalan `68 to { lesson68Questions }`).
 * Savollar faqat test ochilganda yaratiladi.
 */
private val lessonQuestionBanks: Map<Int, () -> List<Question>> = mapOf(
    1 to { lesson1Questions },
    2 to { lesson2Questions },
    3 to { lesson3Questions },
    4 to { lesson4Questions },
    5 to { lesson5Questions },
    6 to { lesson6Questions },
    7 to { lesson7Questions },
    8 to { lesson8Questions },
    9 to { lesson9Questions },
    10 to { lesson10Questions },
    11 to { lesson11Questions },
    12 to { lesson12Questions },
    13 to { lesson13Questions },
    14 to { lesson14Questions },
    15 to { lesson15Questions },
    16 to { lesson16Questions },
    17 to { lesson17Questions },
    18 to { lesson18Questions },
    19 to { lesson19Questions },
    20 to { lesson20Questions },
    21 to { lesson21Questions },
    22 to { lesson22Questions },
    23 to { lesson23Questions },
    24 to { lesson24Questions },
    25 to { lesson25Questions },
    26 to { lesson26Questions },
    27 to { lesson27Questions },
    28 to { lesson28Questions },
    29 to { lesson29Questions },
    30 to { lesson30Questions },
    31 to { lesson31Questions },
    32 to { lesson32Questions },
    33 to { lesson33Questions },
    34 to { lesson34Questions },
    35 to { lesson35Questions },
    36 to { lesson36Questions },
    37 to { lesson37Questions },
    38 to { lesson38Questions },
    39 to { lesson39Questions },
    40 to { lesson40Questions },
    41 to { lesson41Questions },
    42 to { lesson42Questions },
    43 to { lesson43Questions },
    44 to { lesson44Questions },
    45 to { lesson45Questions },
    46 to { lesson46Questions },
    47 to { lesson47Questions },
    48 to { lesson48Questions },
    49 to { lesson49Questions },
    50 to { lesson50Questions },
    51 to { lesson51Questions },
    52 to { lesson52Questions },
    53 to { lesson53Questions },
    54 to { lesson54Questions },
    55 to { lesson55Questions },
    56 to { lesson56Questions },
    57 to { lesson57Questions },
    58 to { lesson58Questions },
    59 to { lesson59Questions },
    60 to { lesson60Questions },
    61 to { lesson61Questions },
    62 to { lesson62Questions },
    63 to { lesson63Questions },
    64 to { lesson64Questions },
    65 to { lesson65Questions },
    66 to { lesson66Questions },
    67 to { lesson67Questions },
)

/**
 * Test bandi uchun ochiladigan test darsi.
 * Test hali tayyor bo‘lmasa `null` qaytadi va band HTML dars sifatida ochiladi.
 */
fun practiceLessonFor(lessonNumber: Int?): Int? =
    lessonNumber?.takeIf { lessonQuestionBanks.containsKey(it) }

/** Dars testini qaytaradi; test tayyor bo‘lmasa `null`. */
fun grammarQuizForLesson(lessonNumber: Int): GrammarQuiz? {
    val bank = lessonQuestionBanks[lessonNumber] ?: return null
    return GrammarQuiz(
        lessonNumber = lessonNumber,
        title = "$lessonNumber-dars: Amaliy test",
        questions = bank()
    )
}
