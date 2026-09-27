package com.example.gujumenglish.ui.statistics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.gujumenglish.data.Sentence
import kotlinx.coroutines.flow.Flow
import kotlin.math.roundToInt

@Composable
fun StatisticsScreen(
    learnedSentencePagingFlow: Flow<PagingData<Sentence>>,
    unlearnedSentencePagingFlow: Flow<PagingData<Sentence>>,
    learnedCount: Int,
    totalCount: Int,
    modifier: Modifier = Modifier
) {
    val learnedSentences = learnedSentencePagingFlow.collectAsLazyPagingItems()
    val unlearnedSentences = unlearnedSentencePagingFlow.collectAsLazyPagingItems()
    val remainingCount = (totalCount - learnedCount).coerceAtLeast(0)
    val progress = if (totalCount > 0) {
        (learnedCount.toFloat() / totalCount.toFloat()).coerceIn(0f, 1f)
    } else {
        0f
    }
    val progressPercent = (progress * 100).roundToInt()

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item(key = "statistics-title") {
            Text(
                text = "Statistics",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = "O‘rganilgan va hali o‘rganilmagan gaplaringizni kuzatib boring.",
                modifier = Modifier.padding(top = 4.dp),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        item(key = "overall-progress") {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(
                        text = "Overall progress",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "$learnedCount / $totalCount gap",
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                        Text(
                            text = "$progressPercent%",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                    LinearProgressIndicator(
                        progress = { progress },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp),
                        color = MaterialTheme.colorScheme.primary,
                        trackColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.55f)
                    )
                }
            }
        }

        item(key = "statistics-counts") {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                StatisticCard(
                    title = "Learned",
                    value = learnedCount.toString(),
                    modifier = Modifier.weight(1f)
                )
                StatisticCard(
                    title = "Remaining",
                    value = remainingCount.toString(),
                    modifier = Modifier.weight(1f)
                )
            }
        }

        item(key = "learned-header") {
            StatisticsSectionHeader(
                title = "O‘rganilgan gaplar",
            )
        }
        if (learnedSentences.itemCount == 0) {
            item(key = "learned-empty") {
                PagingStatus(
                    loadState = learnedSentences.loadState.refresh,
                    emptyText = "Hali o‘rganilgan gaplar yo‘q."
                )
            }
        } else {
            items(
                count = learnedSentences.itemCount,
                key = { index -> "learned-${learnedSentences[index]?.id ?: index}" },
                contentType = { "learned-sentence" }
            ) { index ->
                learnedSentences[index]?.let { sentence ->
                    StatisticsSentenceRow(sentence = sentence)
                }
            }
        }

        item(key = "unlearned-header") {
            StatisticsSectionHeader(
                title = "Hali o‘rganilmagan gaplar",
            )
        }
        if (unlearnedSentences.itemCount == 0) {
            item(key = "unlearned-empty") {
                PagingStatus(
                    loadState = unlearnedSentences.loadState.refresh,
                    emptyText = "Barcha gaplar o‘rganilgan."
                )
            }
        } else {
            items(
                count = unlearnedSentences.itemCount,
                key = { index -> "unlearned-${unlearnedSentences[index]?.id ?: index}" },
                contentType = { "unlearned-sentence" }
            ) { index ->
                unlearnedSentences[index]?.let { sentence ->
                    StatisticsSentenceRow(sentence = sentence)
                }
            }
        }
    }
}

@Composable
private fun StatisticsSectionHeader(
    title: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}

@Composable
private fun StatisticsSentenceRow(
    sentence: Sentence
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = sentence.english,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = sentence.uzbek,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun PagingStatus(
    loadState: LoadState,
    emptyText: String
) {
    when (loadState) {
        LoadState.Loading -> {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        is LoadState.Error -> {
            Text(
                text = "Gaplarni yuklab bo‘lmadi.",
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 12.dp),
                color = MaterialTheme.colorScheme.error
            )
        }
        is LoadState.NotLoading -> {
            Text(
                text = emptyText,
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 12.dp),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun StatisticCard(
    title: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = value,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}
