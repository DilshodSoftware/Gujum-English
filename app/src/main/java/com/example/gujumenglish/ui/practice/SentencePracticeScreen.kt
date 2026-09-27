package com.example.gujumenglish.ui.practice

import android.widget.Toast

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.ImageLoader
import coil3.compose.AsyncImage
import com.example.gujumenglish.audio.SentenceAudioSpeed
import com.example.gujumenglish.data.Sentence
import com.example.gujumenglish.ui.PracticePhase
import com.example.gujumenglish.ui.PracticeUiState

@Composable
fun SentencePracticeScreen(
    state: PracticeUiState,
    imageLoader: ImageLoader,
    imageModelForSentence: (Int) -> Any?,
    isAudioPlaying: Boolean,
    onPlayAudio: (Int, SentenceAudioSpeed) -> Unit,
    onLearned: () -> Unit,
    isSpeakingEngineReady: Boolean,
    isSpeakingListening: Boolean,
    isSpeakingDecoding: Boolean,
    isSpeakingAnswerCorrect: Boolean,
    onSpeakingStart: () -> Unit,
    onSpeakingStop: () -> Unit,
    onSpeakingNext: () -> Unit,
    onTestAnswerSelected: (String) -> Unit,
    onTestNext: () -> Unit,
    hasStudentAudio: Boolean,
    isStudentAudioPlaying: Boolean,
    onPlayStudentAudio: () -> Unit,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val totalSteps = state.sentences.size * 3
    val phaseOffset = when (state.phase) {
        PracticePhase.LEARNING -> 0
        PracticePhase.SPEAKING -> state.sentences.size
        PracticePhase.TEST -> state.sentences.size * 2
    }
    val overallStep = phaseOffset + state.sentenceIndex + 1

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp, vertical = 12.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        if (state.sentences.isNotEmpty() && !state.isLoading && state.errorMessage == null) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBack) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.onSurface
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "$overallStep/$totalSteps",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        when {
            state.isLoading -> {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(420.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            state.errorMessage != null -> {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(420.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = state.errorMessage,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.error
                    )
                    TextButton(onClick = onBack) {
                        Text("Back")
                    }
                }
            }

            state.sentences.isNotEmpty() && state.phase == PracticePhase.SPEAKING -> {
                SpeakingPracticeContent(
                    sentence = state.sentences[state.sentenceIndex],
                    transcript = state.speakingTranscript,
                    status = state.speakingStatus,
                    isEngineReady = isSpeakingEngineReady,
                    isListening = isSpeakingListening,
                    isDecoding = isSpeakingDecoding,
                    isEnglishAudioPlaying = isAudioPlaying,
                    isAnswerCorrect = state.isSpeakingAnswerCorrect,
                    hasStudentAudio = hasStudentAudio,
                    isStudentAudioPlaying = isStudentAudioPlaying,
                    onStart = onSpeakingStart,
                    onStop = onSpeakingStop,
                    onNext = onSpeakingNext,
                    onPlayEnglishAudio = {
                        onPlayAudio(
                            state.sentences[state.sentenceIndex].id,
                            SentenceAudioSpeed.NORMAL
                        )
                    },
                    onPlayStudentAudio = onPlayStudentAudio
                )
            }

            state.sentences.isNotEmpty() && state.phase == PracticePhase.TEST -> {
                TestPracticeContent(
                    sentence = state.sentences[state.sentenceIndex],
                    imageLoader = imageLoader,
                    imageModel = imageModelForSentence(state.sentences[state.sentenceIndex].id),
                    options = state.testOptions,
                    selectedAnswer = state.selectedTestAnswer,
                    isAnswerCorrect = state.isTestAnswerCorrect,
                    onAnswerSelected = onTestAnswerSelected,
                    onNext = onTestNext
                )
            }

            state.sentences.isNotEmpty() && state.phase == PracticePhase.LEARNING -> {
                val sentence = state.sentences[state.sentenceIndex]
                val context = LocalContext.current
                val imageModel = imageModelForSentence(sentence.id)
                var selectedSpeed by remember(sentence.id) {
                    mutableStateOf(SentenceAudioSpeed.NORMAL)
                }
                var isTranslationRevealed by remember(sentence.id) {
                    mutableStateOf(false)
                }
                Column {
                    imageModel?.let { model ->
                            AsyncImage(
                                model = model,
                                imageLoader = imageLoader,
                                contentDescription = "Gap illustrationi",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .aspectRatio(1f),
                                contentScale = ContentScale.Fit
                            )
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    start = 20.dp,
                                    top = 20.dp,
                                    end = 20.dp,
                                    bottom = 28.dp
                                ),
                            verticalArrangement = Arrangement.spacedBy(18.dp)
                        ) {
                            Column {
                                Text(
                                    text = "English",
                                    style = MaterialTheme.typography.labelLarge,
                                    color = MaterialTheme.colorScheme.primary,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.height(6.dp))
                                Text(
                                    text = sentence.english,
                                    style = MaterialTheme.typography.headlineMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }

                            Column {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text(
                                        text = "O‘zbekcha",
                                        style = MaterialTheme.typography.labelLarge,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Spacer(modifier = Modifier.weight(1f))
                                    Box(
                                        modifier = Modifier.size(48.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        if (!isTranslationRevealed) {
                                            IconButton(
                                                onClick = { isTranslationRevealed = true },
                                                modifier = Modifier.semantics {
                                                    contentDescription =
                                                        "O‘zbekcha tarjimani ko‘rsatish"
                                                }
                                            ) {
                                                EyeIcon(
                                                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                                                )
                                            }
                                        }
                                    }
                                }
                                Spacer(modifier = Modifier.height(6.dp))
                                val spoilerColor = MaterialTheme.colorScheme.onSurface
                                    .copy(alpha = 0.08f)
                                val spoilerDotColor = MaterialTheme.colorScheme.onSurface
                                    .copy(alpha = 0.28f)
                                Text(
                                    text = sentence.uzbek,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clip(RoundedCornerShape(8.dp))
                                        .clickable(enabled = !isTranslationRevealed) {
                                            isTranslationRevealed = true
                                        }
                                        .drawWithContent {
                                            if (isTranslationRevealed) {
                                                drawContent()
                                            } else {
                                                drawRect(color = spoilerColor)
                                                val dotRadius = 1.5.dp.toPx()
                                                val columnStep = 10.dp.toPx()
                                                val rowStep = 9.dp.toPx()
                                                var row = 0
                                                var y = rowStep / 2f
                                                while (y < size.height) {
                                                    var column = 0
                                                    var x = if (row % 2 == 0) {
                                                        columnStep / 2f
                                                    } else {
                                                        0f
                                                    }
                                                    while (x < size.width) {
                                                        val seed = row * 31 + column * 17
                                                        val jitterX = ((seed % 5) - 2) * 0.8.dp.toPx()
                                                        val jitterY = (((seed / 5) % 5) - 2) * 0.5.dp.toPx()
                                                        drawCircle(
                                                            color = spoilerDotColor,
                                                            radius = dotRadius,
                                                            center = Offset(
                                                                x = (x + jitterX).coerceIn(
                                                                    dotRadius,
                                                                    size.width - dotRadius
                                                                ),
                                                                y = (y + jitterY).coerceIn(
                                                                    dotRadius,
                                                                    size.height - dotRadius
                                                                )
                                                            )
                                                        )
                                                        column += 1
                                                        x += columnStep
                                                    }
                                                    row += 1
                                                    y += rowStep
                                                }
                                            }
                                        }
                                        .padding(horizontal = 8.dp, vertical = 4.dp),
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = if (isTranslationRevealed) {
                                        MaterialTheme.colorScheme.onSurfaceVariant
                                    } else {
                                        Color.Transparent
                                    }
                                )
                            }
                        }
                }

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "English audio",
                                style = MaterialTheme.typography.labelLarge,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            if (isAudioPlaying) {
                                Text(
                                    text = "▁▃▅▃▁",
                                    style = MaterialTheme.typography.labelLarge,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                        Button(
                            onClick = {
                                onPlayAudio(sentence.id, selectedSpeed)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(52.dp),
                            shape = RoundedCornerShape(14.dp)
                        ) {
                            Text(
                                text = if (isAudioPlaying) "■" else "▶",
                                fontSize = 18.sp
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(if (isAudioPlaying) "Playing" else "Play audio")
                        }
                        SpeedSelector(
                            selectedSpeed = selectedSpeed,
                            onSpeedSelected = { selectedSpeed = it }
                        )
                    }
                }

                Button(
                    onClick = {
                        if (isTranslationRevealed) {
                            onLearned()
                        } else {
                            Toast.makeText(
                                context,
                                "O‘zbekchasini o‘rganmadingiz",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    },
                    enabled = !state.isActionInProgress,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(
                        text = if (state.sentenceIndex == state.sentences.lastIndex) {
                            "O‘rgandim"
                        } else {
                            "Next"
                        },
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
private fun TestPracticeContent(
    sentence: Sentence,
    imageLoader: ImageLoader,
    imageModel: Any?,
    options: List<String>,
    selectedAnswer: String?,
    isAnswerCorrect: Boolean?,
    onAnswerSelected: (String) -> Unit,
    onNext: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        imageModel?.let { model ->
            AsyncImage(
                model = model,
                imageLoader = imageLoader,
                contentDescription = "Gap rasmi",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Fit
            )
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "O‘zbekcha",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Text(
                    text = sentence.uzbek,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }

        if (options.size < 4) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                options.forEach { option ->
                    val isSelected = selectedAnswer == option
                    val optionColor = when {
                        isSelected && isAnswerCorrect == true -> MaterialTheme.colorScheme.primaryContainer
                        isSelected && isAnswerCorrect == false -> MaterialTheme.colorScheme.errorContainer
                        else -> MaterialTheme.colorScheme.surfaceVariant
                    }
                    val optionTextColor = when {
                        isSelected && isAnswerCorrect == true -> MaterialTheme.colorScheme.onPrimaryContainer
                        isSelected && isAnswerCorrect == false -> MaterialTheme.colorScheme.onErrorContainer
                        else -> MaterialTheme.colorScheme.onSurfaceVariant
                    }

                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .clickable(
                                enabled = isAnswerCorrect != true,
                                onClick = { onAnswerSelected(option) }
                            ),
                        shape = RoundedCornerShape(16.dp),
                        color = optionColor,
                        tonalElevation = 2.dp
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 18.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = option,
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.Bold,
                                color = optionTextColor
                            )
                        }
                    }
                }
            }
        }

        when (isAnswerCorrect) {
            true -> Text(
                text = "To‘g‘ri javob! Next tugmasini bosing.",
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold
            )
            false -> Text(
                text = "Noto‘g‘ri. Qayta tanlab ko‘ring.",
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold
            )
            null -> Unit
        }

        if (isAnswerCorrect == true) {
            Button(
                onClick = onNext,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = "Next",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
private fun SpeakingPracticeContent(
    sentence: Sentence,
    transcript: String,
    status: String,
    isEngineReady: Boolean,
    isListening: Boolean,
    isDecoding: Boolean,
    isEnglishAudioPlaying: Boolean,
    isAnswerCorrect: Boolean,
    hasStudentAudio: Boolean,
    isStudentAudioPlaying: Boolean,
    onStart: () -> Unit,
    onStop: () -> Unit,
    onNext: () -> Unit,
    onPlayEnglishAudio: () -> Unit,
    onPlayStudentAudio: () -> Unit
) {
    val canPress = isEngineReady && !isDecoding && !isEnglishAudioPlaying
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "Speaking repetition",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = sentence.english,
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Gapni aytish uchun pastdagi tugmani bosib turing.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            )
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "English audio",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Button(
                    onClick = onPlayEnglishAudio,
                    enabled = !isEnglishAudioPlaying,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Text(text = if (isEnglishAudioPlaying) "■" else "▶", fontSize = 18.sp)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(if (isEnglishAudioPlaying) "Playing..." else "Listen to English")
                }
            }
        }

        if (hasStudentAudio) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Text(
                        text = "Your recording",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Button(
                        onClick = onPlayStudentAudio,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp),
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Text(
                            text = if (isStudentAudioPlaying) "■" else "▶",
                            fontSize = 18.sp
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            if (isStudentAudioPlaying) "Playing your recording"
                            else "Listen to your recording"
                        )
                    }
                }
            }
        }

        if (status.isNotBlank()) {
            Text(
                text = status,
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        if (transcript.isNotBlank()) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Transcript",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = transcript,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }

        if (isAnswerCorrect) {
            Button(
                onClick = onNext,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = "Next",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(152.dp)
                .pointerInput(canPress) {
                    if (canPress) {
                        awaitEachGesture {
                            val down = awaitFirstDown(requireUnconsumed = false)
                            down.consume()
                            onStart()

                            var isPressed = true
                            while (isPressed) {
                                val event = awaitPointerEvent()
                                val change = event.changes.firstOrNull { it.id == down.id }
                                if (change == null || !change.pressed) {
                                    isPressed = false
                                } else {
                                    // Keep the gesture active while the finger moves,
                                    // including movement outside the visual circle.
                                    change.consume()
                                }
                            }
                            onStop()
                        }
                    }
                },
            contentAlignment = Alignment.Center
        ) {
            Surface(
                modifier = Modifier.size(136.dp),
                shape = CircleShape,
                color = if (isListening) {
                    MaterialTheme.colorScheme.errorContainer
                } else {
                    MaterialTheme.colorScheme.primary
                },
                tonalElevation = 3.dp
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(
                        text = when {
                            isEnglishAudioPlaying -> "Listen first"
                            isDecoding -> "Analyzing..."
                            isListening -> "Release"
                            !isEngineReady -> "Preparing..."
                            else -> "Hold to speak"
                        },
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        color = if (isListening) {
                            MaterialTheme.colorScheme.onErrorContainer
                        } else {
                            MaterialTheme.colorScheme.onPrimary
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun SpeedSelector(
    selectedSpeed: SentenceAudioSpeed,
    onSpeedSelected: (SentenceAudioSpeed) -> Unit
) {
    val shape = RoundedCornerShape(12.dp)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(44.dp)
            .background(MaterialTheme.colorScheme.surfaceVariant, shape)
            .clip(shape),
        verticalAlignment = Alignment.CenterVertically
    ) {
        SpeedSegment(
            speed = SentenceAudioSpeed.SLOW,
            selectedSpeed = selectedSpeed,
            label = "0.75×",
            onSpeedSelected = onSpeedSelected,
            modifier = Modifier.weight(1f)
        )
        SpeedSegment(
            speed = SentenceAudioSpeed.NORMAL,
            selectedSpeed = selectedSpeed,
            label = "1.0×",
            onSpeedSelected = onSpeedSelected,
            modifier = Modifier.weight(1f)
        )
        SpeedSegment(
            speed = SentenceAudioSpeed.FAST,
            selectedSpeed = selectedSpeed,
            label = "1.25×",
            onSpeedSelected = onSpeedSelected,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun SpeedSegment(
    speed: SentenceAudioSpeed,
    selectedSpeed: SentenceAudioSpeed,
    label: String,
    onSpeedSelected: (SentenceAudioSpeed) -> Unit,
    modifier: Modifier = Modifier
) {
    val selected = speed == selectedSpeed
    Box(
        modifier = modifier
            .fillMaxHeight()
            .background(
                if (selected) {
                    MaterialTheme.colorScheme.primaryContainer
                } else {
                    MaterialTheme.colorScheme.surfaceVariant
                }
            )
            .clickable { onSpeedSelected(speed) },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge,
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium,
            color = if (selected) {
                MaterialTheme.colorScheme.onPrimaryContainer
            } else {
                MaterialTheme.colorScheme.onSurfaceVariant
            }
        )
    }
}


@Composable
private fun EyeIcon(tint: Color) {
    Canvas(modifier = Modifier.size(24.dp)) {
        val eyeWidth = size.width * 0.76f
        val eyeHeight = size.height * 0.50f
        val strokeWidth = 1.8.dp.toPx()
        drawOval(
            color = tint,
            topLeft = Offset(
                x = (size.width - eyeWidth) / 2f,
                y = (size.height - eyeHeight) / 2f
            ),
            size = Size(eyeWidth, eyeHeight),
            style = Stroke(width = strokeWidth)
        )
        drawCircle(
            color = tint,
            radius = 3.dp.toPx(),
            center = Offset(size.width / 2f, size.height / 2f)
        )
    }
}
