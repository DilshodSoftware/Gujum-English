package com.example.gujumenglish

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.HorizontalScrollView
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.ScrollView
import android.widget.Space
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.gujumenglish.ui.grammar.practice.Question
import com.example.gujumenglish.ui.grammar.practice.TextMode
import com.example.gujumenglish.ui.grammar.practice.grammarQuizForLesson
import com.example.gujumenglish.ui.grammar.practice.normalizeAnswer

/**
 * Grammar bo‘limidagi amaliy test. Savollar dars bo‘yicha
 * `ui/grammar/practice/Lesson<N>Questions.kt` fayllarida saqlanadi.
 */
class GrammarPracticeActivity : ComponentActivity() {
    private var lessonNumber = DEFAULT_LESSON_NUMBER
    private var quizTitle = ""
    private var questions: List<Question> = emptyList()
    private var index = 0
    private var answered = false
    private val verdicts = mutableMapOf<Int, Boolean>()
    private lateinit var content: LinearLayout
    private lateinit var progressLabel: TextView
    private lateinit var progressBar: ProgressBar
    private var fontScale = 1f

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
        lessonNumber = quiz.lessonNumber
        quizTitle = quiz.title
        questions = quiz.questions
        title = quiz.title
        index = savedInstanceState?.getInt(KEY_INDEX, 0) ?: 0
        showQuestion()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(KEY_INDEX, index)
        super.onSaveInstanceState(outState)
    }

    // ---------- Dizayn yordamchilari ----------

    private fun rounded(color: Int, radiusDp: Int, strokeDp: Int = 0, strokeColor: Int = 0): GradientDrawable =
        GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = dp(radiusDp).toFloat()
            setColor(color)
            if (strokeDp > 0) setStroke(dp(strokeDp), strokeColor)
        }

    private fun card(): LinearLayout = LinearLayout(this).apply {
        orientation = LinearLayout.VERTICAL
        background = rounded(Color.WHITE, 20)
        elevation = dp(4).toFloat()
        setPadding(dp(18), dp(18), dp(18), dp(18))
    }

    private fun addCard(view: View, bottomMarginDp: Int = 12) {
        content.addView(
            view,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply { bottomMargin = dp(bottomMarginDp) }
        )
    }

    private fun primaryButton(label: String): Button = Button(this).apply {
        text = label
        textSize = sp(17)
        isAllCaps = false
        setTextColor(Color.WHITE)
        background = rounded(PRIMARY, 14)
        setPadding(dp(14), dp(12), dp(14), dp(12))
    }

    private fun secondaryButton(label: String): Button = Button(this).apply {
        text = label
        textSize = sp(16)
        isAllCaps = false
        setTextColor(INK)
        background = rounded(Color.WHITE, 14, 1, BORDER)
        setPadding(dp(14), dp(14), dp(14), dp(14))
    }

    private fun optionBackground(): GradientDrawable =
        rounded(OPTION_BG, 14, 1, BORDER)

    // ---------- Ekranlar ----------

    private fun showQuestion() {
        answered = false
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(0, dp(8), 0, dp(12))
            setBackgroundColor(BG)
        }

        val header = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(16), 0, dp(16), 0)
        }
        root.addView(
            header,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        )

        val toolbar = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
        }
        toolbar.addView(
            ImageButton(this).apply {
                setImageResource(R.drawable.ic_arrow_back_practice)
                contentDescription = "Orqaga qaytish"
                setBackgroundColor(Color.TRANSPARENT)
                setPadding(dp(8), dp(8), dp(8), dp(8))
                setOnClickListener { finish() }
            },
            LinearLayout.LayoutParams(dp(48), dp(48))
        )
        toolbar.addView(
            Space(this),
            LinearLayout.LayoutParams(0, dp(48), 1f)
        )
        toolbar.addView(fontButton("A-", -FONT_SIZE_STEP),
            LinearLayout.LayoutParams(dp(52), dp(48)).apply { rightMargin = dp(4) })
        toolbar.addView(fontButton("A+", FONT_SIZE_STEP),
            LinearLayout.LayoutParams(dp(52), dp(48)).apply { rightMargin = dp(8) })
        progressLabel = TextView(this).apply {
            textSize = sp(14)
            setTypeface(typeface, android.graphics.Typeface.BOLD)
            setTextColor(MUTED)
        }
        toolbar.addView(progressLabel)
        header.addView(toolbar)

        header.addView(TextView(this).apply {
            text = quizTitle
            textSize = sp(22)
            setTypeface(typeface, android.graphics.Typeface.BOLD)
            setTextColor(INK)
            setPadding(0, dp(4), 0, dp(2))
        })

        progressBar = ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal).apply {
            max = questions.size
            progressTintList = ColorStateList.valueOf(PRIMARY)
            progressBackgroundTintList = ColorStateList.valueOf(PROGRESS_TRACK)
        }
        header.addView(
            progressBar,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                dp(8)
            ).apply {
                topMargin = dp(8)
                bottomMargin = dp(4)
            }
        )

        val scroll = ScrollView(this).apply {
            isFillViewport = true
            clipToPadding = false
            clipChildren = false
        }
        content = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            clipToPadding = false
            clipChildren = false
            setPadding(dp(8), dp(10), dp(8), dp(24))
        }
        scroll.addView(
            content,
            ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        )
        root.addView(
            scroll,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
        )
        setContentView(root)
        renderCurrentQuestion()
    }

    private fun renderCurrentQuestion() {
        content.removeAllViews()
        progressLabel.visibility = View.VISIBLE
        progressLabel.text = "Savol ${index + 1}/${questions.size}"
        progressBar.progress = index + 1
        val question = questions[index]

        val header = card().apply {
            addView(TextView(this@GrammarPracticeActivity).apply {
                text = sectionTitle(question.section)
                textSize = sp(13)
                setTypeface(typeface, android.graphics.Typeface.BOLD)
                setTextColor(SECTION_BLUE)
                background = rounded(CHIP_BG, 12)
                setPadding(dp(10), dp(5), dp(10), dp(5))
            })
            addView(TextView(this@GrammarPracticeActivity).apply {
                text = question.prompt
                textSize = sp(20)
                setTypeface(typeface, android.graphics.Typeface.BOLD)
                setTextColor(INK)
                setPadding(0, dp(10), 0, 0)
                setLineSpacing(dp(4).toFloat(), 1f)
            })
        }
        addCard(header)

        when (question) {
            is Question.Choice -> renderChoice(question)
            is Question.MultiChoice -> renderMultiChoice(question)
            is Question.TrueFalse -> renderTrueFalse(question)
            is Question.Text -> renderText(question)
            is Question.Matching -> renderMatching(question)
            is Question.Ordering -> renderOrdering(question)
        }
    }

    private fun optionsCard(): LinearLayout = card().apply {
        clipToPadding = false
        clipChildren = false
    }

    private fun renderChoice(question: Question.Choice) {
        val box = optionsCard()
        val group = RadioGroup(this).apply { orientation = RadioGroup.VERTICAL }
        question.options.forEachIndexed { i, option ->
            group.addView(RadioButton(this).apply {
                text = option
                textSize = sp(17)
                setTextColor(INK)
                background = optionBackground()
                setPadding(dp(14), dp(12), dp(14), dp(12))
            }, RadioGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                if (i < question.options.lastIndex) bottomMargin = dp(8)
            })
        }
        box.addView(group)
        addCard(box)
        addCheckButton(
            isEmpty = { group.checkedRadioButtonId == -1 },
            emptyMessage = "Avval javobni tanlang."
        ) {
            group.checkedRadioButtonId.takeIf { it != -1 }?.let {
                group.findViewById<RadioButton>(it).text.toString() == question.answer
            } ?: false
        }
    }

    private fun renderMultiChoice(question: Question.MultiChoice) {
        val box = optionsCard()
        val selected = mutableSetOf<String>()
        question.options.forEachIndexed { i, option ->
            val row = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER_VERTICAL
                background = optionBackground()
                setPadding(dp(8), dp(12), dp(14), dp(12))
            }
            row.addView(Space(this),
                LinearLayout.LayoutParams(dp(8), ViewGroup.LayoutParams.WRAP_CONTENT))
            row.addView(CheckBox(this).apply {
                text = option
                textSize = sp(17)
                setTextColor(INK)
                background = null
                setPadding(0, 0, 0, 0)
                setOnCheckedChangeListener { _, checked ->
                    if (checked) selected.add(option) else selected.remove(option)
                }
            }, LinearLayout.LayoutParams(
                0,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                1f
            ))
            box.addView(row, LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                if (i < question.options.lastIndex) bottomMargin = dp(8)
            })
        }
        addCard(box)
        addCheckButton(
            isEmpty = { selected.isEmpty() },
            emptyMessage = "Avval javobni tanlang."
        ) { selected == question.answers }
    }

    private fun renderTrueFalse(question: Question.TrueFalse) {
        val box = optionsCard()
        val group = RadioGroup(this).apply {
            orientation = RadioGroup.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
        }
        listOf("To‘g‘ri" to true, "Noto‘g‘ri" to false).forEachIndexed { i, (label, value) ->
            group.addView(RadioButton(this).apply {
                text = label
                tag = value
                textSize = sp(17)
                setTextColor(INK)
                background = optionBackground()
                setPadding(dp(14), dp(12), dp(14), dp(12))
            }, RadioGroup.LayoutParams(
                0,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                1f
            ).apply {
                if (i == 0) rightMargin = dp(8)
            })
        }
        box.addView(group)
        addCard(box)
        addCheckButton(
            isEmpty = { group.checkedRadioButtonId == -1 },
            emptyMessage = "Avval javobni tanlang."
        ) {
            group.checkedRadioButtonId.takeIf { it != -1 }?.let {
                group.findViewById<RadioButton>(it).tag == question.answer
            } ?: false
        }
    }

    private fun renderText(question: Question.Text) {
        val box = optionsCard()
        val input = EditText(this).apply {
            hint = "Javobingizni yozing"
            textSize = sp(18)
            setTextColor(INK)
            setSingleLine(true)
            background = rounded(OPTION_BG, 14, 1, BORDER)
            setPadding(dp(16), dp(14), dp(16), dp(14))
        }
        box.addView(input)
        addCard(box)
        addCheckButton(
            isEmpty = { input.text.isBlank() },
            emptyMessage = "Avval javobingizni yozing."
        ) {
            val answer = normalizeAnswer(input.text.toString(), question.mode)
            question.answers.map { normalizeAnswer(it, question.mode) }.contains(answer)
        }
    }

    private fun renderMatching(question: Question.Matching) {
        val box = optionsCard()
        val selections = mutableMapOf<String, String>()
        question.pairs.forEachIndexed { i, (left, correct) ->
            val row = LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                background = optionBackground()
                setPadding(dp(14), dp(12), dp(14), dp(12))
            }
            row.addView(TextView(this).apply {
                text = left
                textSize = sp(18)
                setTypeface(typeface, android.graphics.Typeface.BOLD)
                setTextColor(INK)
            }, LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply { bottomMargin = dp(8) })
            val group = RadioGroup(this).apply { orientation = RadioGroup.VERTICAL }
            question.options.forEachIndexed { j, option ->
                group.addView(RadioButton(this).apply {
                    text = option
                    textSize = sp(16)
                    setTextColor(INK)
                    setPadding(dp(8), dp(8), dp(8), dp(8))
                }, RadioGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                ).apply {
                    if (j < question.options.lastIndex) bottomMargin = dp(4)
                })
            }
            group.setOnCheckedChangeListener { _, checkedId ->
                if (checkedId != -1) {
                    selections[left] =
                        group.findViewById<RadioButton>(checkedId).text.toString()
                }
            }
            row.addView(
                group,
                LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            )
            box.addView(
                row,
                LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                ).apply {
                    if (i < question.pairs.lastIndex) bottomMargin = dp(8)
                }
            )
        }
        addCard(box)
        addCheckButton(
            isEmpty = { question.pairs.any { (left, _) -> selections[left] == null } },
            emptyMessage = "Barcha qatorlarga javob tanlang."
        ) {
            question.pairs.all { (left, correct) -> selections[left] == correct }
        }
    }

    private fun renderOrdering(question: Question.Ordering) {
        val chosen = mutableListOf<String>()
        val pool = question.words.toMutableList()

        val box = optionsCard()
        val selection = TextView(this).apply {
            text = ORDERING_PLACEHOLDER
            textSize = sp(19)
            setTextColor(INK)
            background = rounded(SELECTION_BG, 14)
            setPadding(dp(14), dp(14), dp(14), dp(14))
            minHeight = dp(56)
            gravity = Gravity.CENTER_VERTICAL
        }
        box.addView(
            selection,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply { bottomMargin = dp(10) }
        )

        val poolRow = LinearLayout(this).apply { orientation = LinearLayout.HORIZONTAL }
        box.addView(
            HorizontalScrollView(this).apply {
                isHorizontalScrollBarEnabled = false
                clipToPadding = false
                clipChildren = false
                addView(
                    poolRow,
                    LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                )
            },
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply { bottomMargin = dp(4) }
        )

        val controls = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            setPadding(dp(2), dp(10), dp(2), dp(2))
        }

        fun refresh() {
            selection.text = if (chosen.isEmpty()) ORDERING_PLACEHOLDER else chosen.joinToString(" ")
            poolRow.removeAllViews()
            pool.forEachIndexed { poolIndex, word ->
                poolRow.addView(
                    TextView(this).apply {
                        text = word
                        textSize = sp(16)
                        setTypeface(typeface, android.graphics.Typeface.BOLD)
                        setTextColor(SECTION_BLUE)
                        gravity = Gravity.CENTER
                        background = rounded(CHIP_BG, 18, 1, BORDER)
                        setPadding(dp(18), dp(12), dp(18), dp(12))
                        minHeight = dp(48)
                        isClickable = true
                        isFocusable = true
                        setOnClickListener {
                            chosen.add(word)
                            pool.removeAt(poolIndex)
                            refresh()
                        }
                    },
                    LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    ).apply { rightMargin = dp(8) }
                )
            }
        }

        controls.addView(secondaryButton("‹ O‘chirish").apply {
            setOnClickListener {
                if (chosen.isNotEmpty()) {
                    pool.add(chosen.removeAt(chosen.lastIndex))
                    refresh()
                }
            }
        }, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f).apply {
            rightMargin = dp(10)
        })
        controls.addView(secondaryButton("Tozalash").apply {
            setOnClickListener {
                chosen.clear()
                pool.clear()
                pool.addAll(question.words)
                refresh()
            }
        }, LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f))
        box.addView(controls)
        addCard(box)

        refresh()

        addCheckButton(
            isEmpty = { chosen.isEmpty() },
            emptyMessage = "Avval so‘zlardan gap tuzing."
        ) {
            normalizeAnswer(chosen.joinToString(" "), TextMode.SENTENCE) ==
                normalizeAnswer(question.answer, TextMode.SENTENCE)
        }
    }

    private fun addCheckButton(isEmpty: () -> Boolean, emptyMessage: String, check: () -> Boolean) {
        val warning = TextView(this).apply {
            text = emptyMessage
            textSize = sp(15)
            setTypeface(typeface, android.graphics.Typeface.BOLD)
            setTextColor(FEEDBACK_BAD_TEXT)
            background = rounded(FEEDBACK_BAD_BG, 12)
            setPadding(dp(14), dp(10), dp(14), dp(10))
            visibility = View.GONE
        }
        content.addView(
            warning,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply { bottomMargin = dp(10) }
        )
        val button = primaryButton(
            if (index == questions.lastIndex) "Natijani ko‘rish" else "Keyingi savol →"
        ).apply {
            setOnClickListener {
                if (answered) return@setOnClickListener
                if (isEmpty()) {
                    warning.visibility = View.VISIBLE
                } else {
                    warning.visibility = View.GONE
                    checkAnswer(check())
                }
            }
        }
        content.addView(
            button,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply { bottomMargin = dp(12) }
        )
    }

    /** "1-mashq • So‘zni moslang" ko‘rinishidagi sarlavhadan faqat mashq nomini qoldiradi. */
    private fun sectionTitle(section: String): String =
        section.substringAfter("•", section).trim().ifEmpty { section }

    private fun checkAnswer(correct: Boolean) {
        answered = true
        verdicts[index] = correct
        if (index == questions.lastIndex) showResult()
        else {
            index++
            showQuestion()
        }
    }

    private fun showResult() {
        content.removeAllViews()
        progressLabel.visibility = View.GONE
        progressBar.progress = questions.size
        val correctCount = questions.indices.count { verdicts[it] == true }
        val wrongCount = questions.size - correctCount
        val box = card()
        box.addView(TextView(this).apply {
            text = "🎉"
            textSize = sp(44)
            gravity = Gravity.CENTER
            setPadding(0, dp(8), 0, dp(8))
        })
        box.addView(TextView(this).apply {
            text = "Natijangiz"
            textSize = sp(24)
            setTypeface(typeface, android.graphics.Typeface.BOLD)
            setTextColor(INK)
            gravity = Gravity.CENTER
        })
        val summary = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER
            setPadding(0, dp(12), 0, 0)
        }
        summary.addView(TextView(this).apply {
            text = "✓ $correctCount to‘g‘ri"
            textSize = sp(17)
            setTypeface(typeface, android.graphics.Typeface.BOLD)
            setTextColor(FEEDBACK_OK_TEXT)
            background = rounded(FEEDBACK_OK_BG, 12)
            setPadding(dp(14), dp(8), dp(14), dp(8))
        }, LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        ).apply { rightMargin = dp(8) })
        summary.addView(TextView(this).apply {
            text = "✗ $wrongCount noto‘g‘ri"
            textSize = sp(17)
            setTypeface(typeface, android.graphics.Typeface.BOLD)
            setTextColor(FEEDBACK_BAD_TEXT)
            background = rounded(FEEDBACK_BAD_BG, 12)
            setPadding(dp(14), dp(8), dp(14), dp(8))
        })
        box.addView(summary)
        addCard(box)
        questions.forEachIndexed { i, question ->
            val ok = verdicts[i] == true
            val row = LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                background = rounded(
                    if (ok) FEEDBACK_OK_BG else FEEDBACK_BAD_BG,
                    16,
                    1,
                    if (ok) FEEDBACK_OK_BORDER else FEEDBACK_BAD_BORDER
                )
                setPadding(dp(16), dp(12), dp(16), dp(12))
            }
            row.addView(TextView(this).apply {
                text = (if (ok) "✓ " else "✗ ") + sectionTitle(question.section)
                textSize = sp(16)
                setTypeface(typeface, android.graphics.Typeface.BOLD)
                setTextColor(if (ok) FEEDBACK_OK_TEXT else FEEDBACK_BAD_TEXT)
            })
            row.addView(TextView(this).apply {
                text = question.prompt
                textSize = sp(15)
                setTextColor(INK)
                setPadding(0, dp(4), 0, 0)
            })
            row.addView(TextView(this).apply {
                text = question.explanation
                textSize = sp(14)
                setTextColor(MUTED)
                setPadding(0, dp(4), 0, 0)
            })
            addCard(row)
        }
        val retry = primaryButton("Qayta ishlash").apply {
            setOnClickListener {
                index = 0
                verdicts.clear()
                showQuestion()
            }
        }
        content.addView(
            retry,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply { bottomMargin = dp(10) }
        )
        val finish = secondaryButton("Yakunlash").apply {
            setOnClickListener { finish() }
        }
        content.addView(
            finish,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        )
    }

    private fun dp(value: Int): Int = (value * resources.displayMetrics.density).toInt()

    /** HTML darslardagi umumiy shrift sozlamasiga mos masshtab (50–150%). */
    private fun sp(base: Int): Float = base * fontScale

    private fun fontButton(label: String, delta: Int): Button = Button(this).apply {
        text = label
        textSize = 17f
        isAllCaps = false
        minWidth = 0
        minimumWidth = 0
        minHeight = 0
        minimumHeight = 0
        setPadding(0, dp(8), 0, dp(8))
        gravity = Gravity.CENTER
        setOnClickListener { changeFontSize(delta) }
    }

    private fun changeFontSize(delta: Int) {
        val percent = ((fontScale * 100).toInt() + delta)
            .coerceIn(MIN_FONT_SIZE_PERCENT, MAX_FONT_SIZE_PERCENT)
        fontScale = percent / 100f
        getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE)
            .edit()
            .putInt(FONT_SIZE_KEY, percent)
            .apply()
        showQuestion()
    }

    companion object {
        private const val KEY_INDEX = "grammar_practice_index"

        private const val ORDERING_PLACEHOLDER = "…"

        private const val LESSON_DICTIONARY = 1
        private const val DEFAULT_LESSON_NUMBER = LESSON_DICTIONARY

        private const val PREFERENCES_NAME = "grammar_preferences"
        private const val FONT_SIZE_KEY = "font_size_percent"
        private const val DEFAULT_FONT_SIZE_PERCENT = 100
        private const val MIN_FONT_SIZE_PERCENT = 50
        private const val MAX_FONT_SIZE_PERCENT = 150
        private const val FONT_SIZE_STEP = 10

        private val BG = Color.rgb(245, 247, 250)
        private val INK = Color.rgb(15, 43, 61)
        private val MUTED = Color.rgb(74, 106, 133)
        private val PRIMARY = Color.rgb(29, 111, 165)
        private val SECTION_BLUE = Color.rgb(23, 74, 107)
        private val CHIP_BG = Color.rgb(234, 243, 251)
        private val OPTION_BG = Color.rgb(247, 250, 253)
        private val SELECTION_BG = Color.rgb(234, 241, 253)
        private val BORDER = Color.rgb(214, 230, 242)
        private val PROGRESS_TRACK = Color.rgb(220, 231, 240)
        private val FEEDBACK_OK_BG = Color.rgb(232, 244, 234)
        private val FEEDBACK_OK_BORDER = Color.rgb(46, 139, 87)
        private val FEEDBACK_OK_TEXT = Color.rgb(26, 74, 42)
        private val FEEDBACK_BAD_BG = Color.rgb(253, 236, 234)
        private val FEEDBACK_BAD_BORDER = Color.rgb(196, 62, 76)
        private val FEEDBACK_BAD_TEXT = Color.rgb(140, 40, 40)

        /** Qaysi dars testi ochilishini ko‘rsatuvchi Intent extra kaliti. */
        const val EXTRA_LESSON_NUMBER = "grammar_practice_lesson_number"
    }
}
