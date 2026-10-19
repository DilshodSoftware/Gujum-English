package com.example.gujumenglish.ui.cardlesson

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.gujumenglish.data.local.CardEntity
import com.example.gujumenglish.data.local.CardLearningService
import kotlinx.coroutines.launch

@Composable
fun CardLessonScreen(
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val service = remember { CardLearningService(context) }
    val scope = rememberCoroutineScope()
    val allCards by service.getAllCards().collectAsState(initial = emptyList())

    var dailyCap by remember { mutableStateOf(service.getDailyCap()) }
    var queueInfo by remember { mutableStateOf<CardLearningService.QueueResult?>(null) }
    var started by remember { mutableStateOf(false) }
    val queue = remember { mutableStateListOf<CardEntity>() }

    var index by remember { mutableStateOf(0) }
    var revealed by remember { mutableStateOf(false) }
    var reviewed by remember { mutableStateOf(0) }
    var grading by remember { mutableStateOf(false) }
    var shownTime by remember { mutableStateOf(0L) }
    var gradeCounts by remember { mutableStateOf(IntArray(5)) }

    // Retrieval time is measured from the moment the prompt appears.
    LaunchedEffect(started, index) {
        if (started) shownTime = System.currentTimeMillis()
    }

    // Rebuild the daily queue when content or cap change (before start).
    LaunchedEffect(allCards, dailyCap) {
        if (!started && allCards.isNotEmpty()) {
            queueInfo = service.buildDailyQueue()
        }
    }

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Card Lesson",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(12.dp))

        if (allCards.isEmpty()) {
            Text(
                text = "Kartalar yuklanmoqda...",
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = onBack) { Text("Orqaga qaytish") }
            return@Column
        }

        // ---------- start screen ----------
        if (!started) {
            val info = queueInfo
            if (info == null) {
                Text("Navbat tayyorlanmoqda...")
            } else {
                if (info.isComeback) {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.secondaryContainer
                        )
                    ) {
                        Text(
                            text = "Xush kelibsiz! ${info.overdueDays} kun bo'lmadingiz — " +
                                    "keling, qisqa diagnostik test bilan yangilab olamiz.",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                }
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Bugungi navbat: ${info.cards.size} ta karta",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Muddati o'tgan: ${info.dueCount}  •  Yangi: ${info.newCount}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
                // Daily cap setting
                Text(
                    text = "Kunlik limit: $dailyCap",
                    style = MaterialTheme.typography.labelLarge
                )
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedButton(
                        onClick = {
                            dailyCap = (dailyCap - 10).coerceAtLeast(20)
                            service.setDailyCap(dailyCap)
                        }
                    ) { Text("−10") }
                    OutlinedButton(
                        onClick = {
                            dailyCap = (dailyCap + 10).coerceAtMost(100)
                            service.setDailyCap(dailyCap)
                        }
                    ) { Text("+10") }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        queue.clear()
                        queue.addAll(info.cards)
                        index = 0
                        reviewed = 0
                        revealed = false
                        started = true
                    },
                    enabled = info.cards.isNotEmpty(),
                    modifier = Modifier.fillMaxWidth()
                ) { Text(if (info.isComeback) "Diagnostikani boshlash" else "Boshlash (${info.cards.size} ta)") }
            }
            Spacer(modifier = Modifier.weight(1f))
            OutlinedButton(onClick = onBack, modifier = Modifier.fillMaxWidth()) {
                Text("Orqaga qaytish")
            }
            return@Column
        }

        // ---------- summary ----------
        if (index >= queue.size) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "🎉 Sessiya tugadi!",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Ko'rib chiqildi: $reviewed",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Eslolmadim: ${gradeCounts[1]}  •  Qiynalib: ${gradeCounts[2]}  •  " +
                                "Esladim: ${gradeCounts[3]}  •  Darrov: ${gradeCounts[4]}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center
                    )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            Button(
                onClick = {
                    scope.launch {
                        val info = service.buildDailyQueue()
                        queueInfo = info
                        queue.clear()
                        queue.addAll(info.cards)
                        index = 0
                        reviewed = 0
                        revealed = false
                        started = info.cards.isNotEmpty()
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) { Text("Keyingi navbat") }
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedButton(onClick = onBack, modifier = Modifier.fillMaxWidth()) {
                Text("Orqaga qaytish")
            }
            return@Column
        }

        // ---------- review ----------
        val card = queue[index]

        Text(
            text = "${index + 1} / ${queue.size}  •  Ko'rib chiqildi: $reviewed",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(8.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(modifier = Modifier.padding(24.dp)) {
                Text(
                    text = card.type.uppercase(),
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = card.prompt,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth()
                )
                if (revealed) {
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = card.answer,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    if (!card.example.isNullOrBlank()) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = card.example,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        if (!revealed) {
            Button(
                onClick = { revealed = true },
                modifier = Modifier.fillMaxWidth()
            ) { Text("Javobni ko'rsatish") }
        } else {
            Text(
                text = "Qanday esladingiz?",
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(8.dp))
            val grades = listOf(
                Triple(1, "Eslolmadim", Color(0xFFD32F2F)),
                Triple(2, "Qiynalib esladim", Color(0xFFF9A825)),
                Triple(3, "Esladim", Color(0xFF1976D2)),
                Triple(4, "Darrov esladim", Color(0xFF388E3C))
            )
            grades.chunked(2).forEach { row ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    row.forEach { (grade, label, color) ->
                        Button(
                            onClick = {
                                if (grading) return@Button
                                grading = true
                                scope.launch {
                                    try {
                                        service.submitReview(
                                            cardId = card.id,
                                            grade = grade,
                                            responseTimeMs = System.currentTimeMillis() - shownTime
                                        )
                                        gradeCounts = gradeCounts.copyOf().also { it[grade]++ }
                                        // Lapse: repeat at the end of this session.
                                        if (grade == 1) queue.add(card)
                                    } finally {
                                        reviewed++
                                        index++
                                        revealed = false
                                        grading = false
                                    }
                                }
                            },
                            enabled = !grading,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = color,
                                // Yellow needs dark text to stay readable.
                                contentColor = if (grade == 2) Color.Black else Color.White
                            ),
                            modifier = Modifier.weight(1f)
                        ) { Text(label) }
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        Spacer(modifier = Modifier.weight(1f))
        OutlinedButton(onClick = onBack, modifier = Modifier.fillMaxWidth()) {
            Text("Orqaga qaytish")
        }
    }
}
