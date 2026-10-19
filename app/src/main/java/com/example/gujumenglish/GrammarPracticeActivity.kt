package com.example.gujumenglish

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.setValue
import com.example.gujumenglish.ui.grammar.practice.GrammarPracticeScreen
import com.example.gujumenglish.ui.grammar.practice.grammarQuizForLesson
import com.example.gujumenglish.ui.theme.GujumEnglishTheme

/**
 * Grammar bo‘limidagi amaliy test. Savollar dars bo‘yicha
 * `ui/grammar/practice/Lesson<N>Questions.kt` fayllarida saqlanadi.
 */
class GrammarPracticeActivity : ComponentActivity() {
    private var fontScale by mutableFloatStateOf(1f)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fontScale =
            getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE)
                .getInt(FONT_SIZE_KEY, DEFAULT_FONT_SIZE_PERCENT) / 100f
        val requestedLesson = intent.getIntExtra(EXTRA_LESSON_NUMBER, DEFAULT_LESSON_NUMBER)
        val quiz = grammarQuizForLesson(requestedLesson)
        if (quiz == null || quiz.questions.isEmpty()) {
            finish()
            return
        }
        title = quiz.title
        setContent {
            GujumEnglishTheme {
                GrammarPracticeScreen(
                    quiz = quiz,
                    fontScale = fontScale,
                    onFontScaleChange = ::changeFontSize,
                    onBack = { finish() }
                )
            }
        }
    }

    /** HTML darslardagi umumiy shrift sozlamasiga mos masshtab (50–150%). */
    private fun changeFontSize(delta: Int) {
        val percent = ((fontScale * 100).toInt() + delta)
            .coerceIn(MIN_FONT_SIZE_PERCENT, MAX_FONT_SIZE_PERCENT)
        fontScale = percent / 100f
        getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE)
            .edit()
            .putInt(FONT_SIZE_KEY, percent)
            .apply()
    }

    companion object {
        private const val PREFERENCES_NAME = "grammar_preferences"
        private const val FONT_SIZE_KEY = "font_size_percent"
        private const val DEFAULT_FONT_SIZE_PERCENT = 100
        private const val MIN_FONT_SIZE_PERCENT = 50
        private const val MAX_FONT_SIZE_PERCENT = 150

        private const val LESSON_DICTIONARY = 1
        private const val DEFAULT_LESSON_NUMBER = LESSON_DICTIONARY

        /** Qaysi dars testi ochilishini ko‘rsatuvchi Intent extra kaliti. */
        const val EXTRA_LESSON_NUMBER = "grammar_practice_lesson_number"
    }
}
