package com.example.gujumenglish.ui.grammar.practice

/**
 * Grammar amaliy testlarida ishlatiladigan savol turlari.
 *
 * Har bir darsning savollari alohida faylda saqlanadi: `Lesson<N>Questions.kt`.
 * Testni ochish uchun dars raqami `GrammarPracticeActivity`ga yuboriladi.
 */
enum class TextMode {
    DEFAULT,
    UPPER_ALPHABET,
    LOWER_ALPHABET,
    ORDER,
    SPELLING,
    SENTENCE
}

sealed class Question(
    val section: String,
    val prompt: String,
    val explanation: String
) {
    class Choice(
        section: String,
        prompt: String,
        val options: List<String>,
        val answer: String,
        explanation: String
    ) : Question(section, prompt, explanation)

    class MultiChoice(
        section: String,
        prompt: String,
        val options: List<String>,
        val answers: Set<String>,
        explanation: String
    ) : Question(section, prompt, explanation)

    class TrueFalse(
        section: String,
        prompt: String,
        val answer: Boolean,
        explanation: String
    ) : Question(section, prompt, explanation)

    class Text(
        section: String,
        prompt: String,
        val answers: Set<String>,
        val mode: TextMode = TextMode.DEFAULT,
        explanation: String
    ) : Question(section, prompt, explanation)

    class Matching(
        section: String,
        prompt: String,
        val pairs: List<Pair<String, String>>,
        val options: List<String>,
        explanation: String
    ) : Question(section, prompt, explanation)

    class Ordering(
        section: String,
        prompt: String,
        val words: List<String>,
        val answer: String,
        explanation: String
    ) : Question(section, prompt, explanation)
}

data class GrammarQuiz(
    val lessonNumber: Int,
    val title: String,
    val questions: List<Question>
)

private val apostropheVariants = Regex("[‘’ʻʼ`´']")

/**
 * Yozilgan javobni solishtirish uchun normallashtiradi.
 * Har bir `TextMode` javobning qaysi belgilariga e'tibor berilishini belgilaydi.
 */
fun normalizeAnswer(value: String, mode: TextMode): String = when (mode) {
    TextMode.UPPER_ALPHABET -> value.filter { it in 'A'..'Z' }
    TextMode.LOWER_ALPHABET -> value.filter { it in 'a'..'z' }
    TextMode.ORDER -> value.uppercase().filter { it in 'A'..'Z' }
    TextMode.SPELLING -> value.uppercase().filter { it in 'A'..'Z' }
    TextMode.SENTENCE -> value
        .trim()
        .lowercase()
        .replace(apostropheVariants, "'")
        .replace(Regex("[^a-z0-9' ]"), " ")
        .replace(Regex("\\s+"), " ")
        .trim()
    TextMode.DEFAULT -> value
        .trim()
        .lowercase()
        .replace(apostropheVariants, "'")
        .replace(Regex("\\s+"), " ")
}
