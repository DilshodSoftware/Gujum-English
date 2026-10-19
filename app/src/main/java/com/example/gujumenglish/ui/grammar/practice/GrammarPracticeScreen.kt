package com.example.gujumenglish.ui.grammar.practice

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gujumenglish.R

/**
 * Grammar amaliy test ekrani (Compose).
 *
 * Savollar `Lesson<N>Questions.kt` fayllarida saqlanadi, shakli
 * [Question] sealed klassi orqali ifodalanadi.
 */
@Composable
fun GrammarPracticeScreen(
    quiz: GrammarQuiz,
    fontScale: Float,
    onFontScaleChange: (Int) -> Unit,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    var index by rememberSaveable { mutableStateOf(0) }
    var showResult by rememberSaveable { mutableStateOf(false) }
    // Savol raqami -> to'g'ri/noto'g'ri (null = hali baholanmagan).
    val verdicts = rememberSaveable { mutableStateOf(arrayListOf<Boolean>()) }
    fun setVerdict(at: Int, correct: Boolean) {
        // Yangi list yaratamiz — mutableStateOf struktural tenglik bilan
        // solishtiradi, in-place o'zgartirish rekompozitsiyani tetiklamaydi.
        val list = verdicts.value.toMutableList()
        while (list.size <= at) list.add(false)
        list[at] = correct
        verdicts.value = ArrayList(list)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(PracticeColors.background)
    ) {
        PracticeHeader(
            title = quiz.title,
            progressLabel = if (showResult) null else "Savol ${index + 1}/${quiz.questions.size}",
            progress = if (showResult) 1f else (index + 1).toFloat() / quiz.questions.size,
            fontScale = fontScale,
            onBack = onBack,
            onFontScaleChange = onFontScaleChange
        )

        if (showResult) {
            PracticeResult(
                quiz = quiz,
                verdicts = verdicts.value,
                fontScale = fontScale,
                onRetry = {
                    index = 0
                    verdicts.value = arrayListOf()
                    showResult = false
                },
                onFinish = onBack,
                modifier = Modifier.weight(1f)
            )
        } else {
            val question = quiz.questions[index]
            PracticeQuestion(
                key = index,
                question = question,
                fontScale = fontScale,
                isLast = index == quiz.questions.lastIndex,
                onAnswered = { correct ->
                    setVerdict(index, correct)
                    if (index == quiz.questions.lastIndex) {
                        showResult = true
                    } else {
                        index++
                    }
                },
                modifier = Modifier.weight(1f)
            )
        }
    }
}

// ---------- Header ----------

@Composable
private fun PracticeHeader(
    title: String,
    progressLabel: String?,
    progress: Float,
    fontScale: Float,
    onBack: () -> Unit,
    onFontScaleChange: (Int) -> Unit
) {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack, modifier = Modifier.size(48.dp)) {
                Icon(
                    painter = androidx.compose.ui.res.painterResource(
                        R.drawable.ic_arrow_back_practice
                    ),
                    contentDescription = "Orqaga qaytish"
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            FontSizeButton("A-", -10, onFontScaleChange)
            Spacer(modifier = Modifier.width(4.dp))
            FontSizeButton("A+", 10, onFontScaleChange)
            Spacer(modifier = Modifier.width(8.dp))
            if (progressLabel != null) {
                Text(
                    text = progressLabel,
                    fontSize = 14.sp * fontScale,
                    fontWeight = FontWeight.Bold,
                    color = PracticeColors.muted
                )
            }
        }
        Text(
            text = title,
            fontSize = 22.sp * fontScale,
            fontWeight = FontWeight.Bold,
            color = PracticeColors.ink,
            modifier = Modifier.padding(top = 4.dp, bottom = 2.dp)
        )
        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 4.dp)
                .height(8.dp)
                .clip(RoundedCornerShape(4.dp)),
            color = PracticeColors.primary,
            trackColor = PracticeColors.progressTrack,
            drawStopIndicator = {}
        )
    }
}

@Composable
private fun FontSizeButton(
    label: String,
    delta: Int,
    onFontScaleChange: (Int) -> Unit
) {
    TextButton(
        onClick = { onFontScaleChange(delta) },
        modifier = Modifier.width(52.dp)
    ) {
        Text(
            text = label,
            fontSize = 17.sp,
            fontWeight = FontWeight.SemiBold,
            color = PracticeColors.ink
        )
    }
}

// ---------- Savol ----------

/**
 * Joriy savolning javob holati. Bloklar uni to'ldiradi,
 * "Tekshirish" tugmasi undan foydalanadi.
 */
private class AnswerHolder {
    var isEmpty: Boolean by mutableStateOf(true)
    var isCorrect: Boolean by mutableStateOf(false)
}

@Composable
private fun PracticeQuestion(
    key: Int,
    question: Question,
    fontScale: Float,
    isLast: Boolean,
    onAnswered: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val holder = remember(key) { AnswerHolder() }
    var warning by remember(key) { mutableStateOf(false) }

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 8.dp, vertical = 10.dp)
    ) {
        // Savol matni
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(modifier = Modifier.padding(18.dp)) {
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = PracticeColors.chipBackground
                ) {
                    Text(
                        text = sectionTitle(question.section),
                        fontSize = 13.sp * fontScale,
                        fontWeight = FontWeight.Bold,
                        color = PracticeColors.sectionBlue,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                    )
                }
                Text(
                    text = question.prompt,
                    fontSize = 20.sp * fontScale,
                    fontWeight = FontWeight.Bold,
                    color = PracticeColors.ink,
                    lineHeight = 26.sp * fontScale,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        when (question) {
            is Question.Choice -> ChoiceBlock(key, question, fontScale, holder)
            is Question.MultiChoice -> MultiChoiceBlock(key, question, fontScale, holder)
            is Question.TrueFalse -> TrueFalseBlock(key, question, fontScale, holder)
            is Question.Text -> TextBlock(key, question, fontScale, holder)
            is Question.Matching -> MatchingBlock(key, question, fontScale, holder)
            is Question.Ordering -> OrderingBlock(key, question, fontScale, holder)
        }

        Spacer(modifier = Modifier.height(10.dp))

        if (warning) {
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = PracticeColors.feedbackBadBackground,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = emptyMessageFor(question),
                    fontSize = 15.sp * fontScale,
                    fontWeight = FontWeight.Bold,
                    color = PracticeColors.feedbackBadText,
                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
        }

        Button(
            onClick = {
                if (holder.isEmpty) {
                    warning = true
                } else {
                    warning = false
                    onAnswered(holder.isCorrect)
                }
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            contentPadding = PaddingValues(horizontal = 14.dp, vertical = 14.dp)
        ) {
            Text(
                text = if (isLast) "Natijani ko'rish" else "Keyingi savol →",
                fontSize = 17.sp * fontScale
            )
        }
    }
}

// ---------- Savol bloklari ----------

@Composable
private fun ChoiceBlock(
    key: Int,
    question: Question.Choice,
    fontScale: Float,
    holder: AnswerHolder
) {
    var selected by remember(key) { mutableStateOf<String?>(null) }
    OptionCard {
        question.options.forEachIndexed { i, option ->
            OptionRow(
                text = option,
                fontScale = fontScale,
                selected = selected == option,
                onClick = {
                    selected = option
                    holder.isEmpty = false
                    holder.isCorrect = option == question.answer
                }
            )
            if (i < question.options.lastIndex) Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
private fun MultiChoiceBlock(
    key: Int,
    question: Question.MultiChoice,
    fontScale: Float,
    holder: AnswerHolder
) {
    var selected by remember(key) { mutableStateOf(setOf<String>()) }
    fun sync() {
        holder.isEmpty = selected.isEmpty()
        holder.isCorrect = selected == question.answers
    }
    OptionCard {
        question.options.forEachIndexed { i, option ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(PracticeColors.optionBackground)
                    .clickable {
                        selected = if (option in selected) selected - option else selected + option
                        sync()
                    }
                    .padding(start = 8.dp, end = 14.dp, top = 4.dp, bottom = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = option in selected,
                    onCheckedChange = { checked ->
                        selected = if (checked) selected + option else selected - option
                        sync()
                    }
                )
                Text(
                    text = option,
                    fontSize = 17.sp * fontScale,
                    color = PracticeColors.ink
                )
            }
            if (i < question.options.lastIndex) Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
private fun TrueFalseBlock(
    key: Int,
    question: Question.TrueFalse,
    fontScale: Float,
    holder: AnswerHolder
) {
    var selected by remember(key) { mutableStateOf<Boolean?>(null) }
    OptionCard {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf("To'g'ri" to true, "Noto'g'ri" to false).forEach { (label, value) ->
                OptionRow(
                    text = label,
                    fontScale = fontScale,
                    selected = selected == value,
                    onClick = {
                        selected = value
                        holder.isEmpty = false
                        holder.isCorrect = value == question.answer
                    },
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
private fun TextBlock(
    key: Int,
    question: Question.Text,
    fontScale: Float,
    holder: AnswerHolder
) {
    var text by remember(key) { mutableStateOf("") }
    fun sync() {
        val answer = normalizeAnswer(text, question.mode)
        val accepted = question.answers.map { normalizeAnswer(it, question.mode) }
        holder.isEmpty = text.isBlank()
        holder.isCorrect = accepted.contains(answer)
    }
    OptionCard {
        OutlinedTextField(
            value = text,
            onValueChange = {
                text = it
                sync()
            },
            placeholder = { Text("Javobingizni yozing", fontSize = 16.sp * fontScale) },
            textStyle = TextStyle(fontSize = 18.sp * fontScale, color = PracticeColors.ink),
            singleLine = true,
            shape = RoundedCornerShape(14.dp),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
private fun MatchingBlock(
    key: Int,
    question: Question.Matching,
    fontScale: Float,
    holder: AnswerHolder
) {
    val selections = remember(key) { mutableStateOf(mapOf<String, String>()) }
    fun sync() {
        val current = selections.value
        holder.isEmpty = question.pairs.any { (left, _) -> current[left] == null }
        holder.isCorrect = question.pairs.all { (left, correct) -> current[left] == correct }
    }
    OptionCard {
        question.pairs.forEachIndexed { i, (left, _) ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(PracticeColors.optionBackground)
                    .padding(horizontal = 14.dp, vertical = 12.dp)
            ) {
                Text(
                    text = left,
                    fontSize = 18.sp * fontScale,
                    fontWeight = FontWeight.Bold,
                    color = PracticeColors.ink
                )
                Spacer(modifier = Modifier.height(8.dp))
                question.options.forEach { option ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                selections.value = selections.value + (left to option)
                                sync()
                            }
                            .padding(vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selections.value[left] == option,
                            onClick = {
                                selections.value = selections.value + (left to option)
                                sync()
                            }
                        )
                        Text(
                            text = option,
                            fontSize = 16.sp * fontScale,
                            color = PracticeColors.ink
                        )
                    }
                }
            }
            if (i < question.pairs.lastIndex) Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
private fun OrderingBlock(
    key: Int,
    question: Question.Ordering,
    fontScale: Float,
    holder: AnswerHolder
) {
    val chosen = remember(key) { mutableStateListOf<String>() }
    val pool = remember(key) { mutableStateListOf<String>().apply { addAll(question.words) } }

    fun sync() {
        holder.isEmpty = chosen.isEmpty()
        holder.isCorrect = normalizeAnswer(chosen.joinToString(" "), TextMode.SENTENCE) ==
            normalizeAnswer(question.answer, TextMode.SENTENCE)
    }

    OptionCard {
        Surface(
            shape = RoundedCornerShape(14.dp),
            color = PracticeColors.selectionBackground,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = if (chosen.isEmpty()) "…" else chosen.joinToString(" "),
                fontSize = 19.sp * fontScale,
                color = PracticeColors.ink,
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 56.dp)
                    .padding(14.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {
            pool.forEachIndexed { poolIndex, word ->
                Surface(
                    shape = RoundedCornerShape(18.dp),
                    color = PracticeColors.chipBackground,
                    border = BorderStroke(1.dp, PracticeColors.border),
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .heightIn(min = 48.dp)
                        .clickable {
                            chosen.add(word)
                            pool.removeAt(poolIndex)
                            sync()
                        }
                ) {
                    Text(
                        text = word,
                        fontSize = 16.sp * fontScale,
                        fontWeight = FontWeight.Bold,
                        color = PracticeColors.sectionBlue,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(horizontal = 18.dp, vertical = 12.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(4.dp))

        Row(
            modifier = Modifier.padding(top = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            OutlinedButton(
                onClick = {
                    if (chosen.isNotEmpty()) {
                        pool.add(chosen.removeAt(chosen.lastIndex))
                        sync()
                    }
                },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(14.dp)
            ) {
                Text("‹ O'chirish", fontSize = 16.sp * fontScale, color = PracticeColors.ink)
            }
            OutlinedButton(
                onClick = {
                    chosen.clear()
                    pool.clear()
                    pool.addAll(question.words)
                    sync()
                },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(14.dp)
            ) {
                Text("Tozalash", fontSize = 16.sp * fontScale, color = PracticeColors.ink)
            }
        }
    }
}

// ---------- Umumiy qismlar ----------

@Composable
private fun OptionCard(content: @Composable () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(modifier = Modifier.padding(12.dp)) { content() }
    }
}

@Composable
private fun OptionRow(
    text: String,
    fontScale: Float,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(14.dp))
            .background(PracticeColors.optionBackground)
            .border(
                width = 1.dp,
                color = if (selected) PracticeColors.primary else PracticeColors.border,
                shape = RoundedCornerShape(14.dp)
            )
            .clickable(onClick = onClick)
            .padding(horizontal = 14.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = selected, onClick = onClick)
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text,
            fontSize = 17.sp * fontScale,
            color = PracticeColors.ink
        )
    }
}

// ---------- Natija ekrani ----------

@Composable
private fun PracticeResult(
    quiz: GrammarQuiz,
    verdicts: List<Boolean>,
    fontScale: Float,
    onRetry: () -> Unit,
    onFinish: () -> Unit,
    modifier: Modifier = Modifier
) {
    val correctCount = verdicts.count { it }
    val wrongCount = quiz.questions.size - correctCount

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 8.dp, vertical = 10.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "🎉", fontSize = 44.sp)
                Text(
                    text = "Natijangiz",
                    fontSize = 24.sp * fontScale,
                    fontWeight = FontWeight.Bold,
                    color = PracticeColors.ink
                )
                Spacer(modifier = Modifier.height(12.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = PracticeColors.feedbackOkBackground
                    ) {
                        Text(
                            text = "✓ $correctCount to'g'ri",
                            fontSize = 17.sp * fontScale,
                            fontWeight = FontWeight.Bold,
                            color = PracticeColors.feedbackOkText,
                            modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)
                        )
                    }
                    Surface(
                        shape = RoundedCornerShape(12.dp),
                        color = PracticeColors.feedbackBadBackground
                    ) {
                        Text(
                            text = "✗ $wrongCount noto'g'ri",
                            fontSize = 17.sp * fontScale,
                            fontWeight = FontWeight.Bold,
                            color = PracticeColors.feedbackBadText,
                            modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        quiz.questions.forEachIndexed { index, question ->
            val ok = verdicts.getOrNull(index) == true
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = if (ok) PracticeColors.feedbackOkBackground else PracticeColors.feedbackBadBackground,
                border = BorderStroke(
                    1.dp,
                    if (ok) PracticeColors.feedbackOkBorder else PracticeColors.feedbackBadBorder
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = (if (ok) "✓ " else "✗ ") + sectionTitle(question.section),
                        fontSize = 16.sp * fontScale,
                        fontWeight = FontWeight.Bold,
                        color = if (ok) PracticeColors.feedbackOkText else PracticeColors.feedbackBadText
                    )
                    Text(
                        text = question.prompt,
                        fontSize = 15.sp * fontScale,
                        color = PracticeColors.ink,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                    Text(
                        text = question.explanation,
                        fontSize = 14.sp * fontScale,
                        color = PracticeColors.muted,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = onRetry,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            contentPadding = PaddingValues(horizontal = 14.dp, vertical = 14.dp)
        ) {
            Text("Qayta ishlash", fontSize = 17.sp * fontScale)
        }
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedButton(
            onClick = onFinish,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp)
        ) {
            Text("Yakunlash", fontSize = 17.sp * fontScale, color = PracticeColors.ink)
        }
    }
}

// ---------- Yordamchilar ----------

/** "1-mashq • So'zni moslang" ko'rinishidagi sarlavhadan faqat mashq nomini qoldiradi. */
private fun sectionTitle(section: String): String =
    section.substringAfter("•", section).trim().ifEmpty { section }

private fun emptyMessageFor(question: Question): String = when (question) {
    is Question.Matching -> "Barcha qatorlarga javob tanlang."
    is Question.Ordering -> "Avval so'zlardan gap tuzing."
    is Question.Text -> "Avval javobingizni yozing."
    else -> "Avval javobni tanlang."
}
