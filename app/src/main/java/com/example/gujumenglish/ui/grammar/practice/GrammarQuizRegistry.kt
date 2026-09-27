package com.example.gujumenglish.ui.grammar.practice

/**
 * Dars raqami -> savollar to‘plami.
 *
 * Hozircha 1-dars (Boshlang‘ich lug‘at), 2-dars (English Alphabet),
 * 3-dars (Vowels and Consonants) va 4-dars (Letters vs Sounds) testi bor.
 * Yangi darsning savollari tayyor bo‘lganda shu ro‘yxatga bitta qator qo‘shiladi
 * (masalan `5 to { lesson5Questions }`). Savollar faqat test ochilganda yaratiladi.
 */
private val lessonQuestionBanks: Map<Int, () -> List<Question>> = mapOf(
    1 to { lesson1Questions },
    2 to { lesson2Questions },
    3 to { lesson3Questions },
    4 to { lesson4Questions }
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
