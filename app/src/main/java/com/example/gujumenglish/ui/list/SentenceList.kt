package com.example.gujumenglish.ui.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.example.gujumenglish.data.Sentence
import kotlinx.coroutines.flow.Flow

@Composable
fun SentenceListScreen(
    sentencePagingFlow: Flow<PagingData<Sentence>>,
    learnedCount: Int,
    totalCount: Int,
    lastLearnedSentencePosition: Int,
    onStartLearning: (Int) -> Unit,
    onClearProgress: () -> Unit,
    modifier: Modifier = Modifier,
    showSentenceList: Boolean = false
) {
    val sentences = sentencePagingFlow.collectAsLazyPagingItems()
    val listState = rememberLazyListState()
    val refreshState = sentences.loadState.refresh
    var isInitialPositionReady by remember {
        mutableStateOf(lastLearnedSentencePosition <= 0)
    }

    LaunchedEffect(lastLearnedSentencePosition, refreshState) {
        if (refreshState !is LoadState.NotLoading) {
            isInitialPositionReady = false
            return@LaunchedEffect
        }
        if (lastLearnedSentencePosition <= 0) {
            if (sentences.itemCount > 0) {
                listState.scrollToItem(0)
            }
            isInitialPositionReady = true
            return@LaunchedEffect
        }
        if (sentences.itemCount == 0) {
            isInitialPositionReady = true
            return@LaunchedEffect
        }

        isInitialPositionReady = false
        val targetIndex = (lastLearnedSentencePosition - 1)
            .coerceIn(0, sentences.itemCount - 1)
        listState.scrollToItem(targetIndex)
        withFrameNanos { }

        val targetItem = listState.layoutInfo.visibleItemsInfo
            .firstOrNull { it.index == targetIndex }
        if (targetItem != null) {
            val viewportCenter = (
                listState.layoutInfo.viewportStartOffset +
                    listState.layoutInfo.viewportEndOffset
                ) / 2
            val itemCenter = targetItem.offset + targetItem.size / 2
            listState.scrollBy((itemCenter - viewportCenter).toFloat())
        }
        isInitialPositionReady = true
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        if (showSentenceList) {
            ListHeader(
                learnedCount = learnedCount,
                totalCount = totalCount
            )
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
        } else {
            Column(
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 18.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "Practice",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Yangi gaplarni o‘rganish uchun mashg‘ulotni tanlang.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        if (showSentenceList) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                when {
                    refreshState is LoadState.Loading && sentences.itemCount == 0 -> {
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                    }

                    refreshState is LoadState.Error && sentences.itemCount == 0 -> {
                        ListError(
                            error = refreshState.error,
                            onRetry = sentences::retry
                        )
                    }

                    else -> {
                        LazyColumn(
                            modifier = Modifier
                                .fillMaxSize()
                                .alpha(if (isInitialPositionReady) 1f else 0f),
                            state = listState,
                            reverseLayout = true,
                            contentPadding = PaddingValues(top = 20.dp, bottom = 28.dp),
                            verticalArrangement = Arrangement.spacedBy(2.dp)
                        ) {
                            items(
                                count = sentences.itemCount,
                                key = sentences.itemKey { sentence -> sentence.id },
                                contentType = sentences.itemContentType { "sentence" }
                            ) { index ->
                                sentences[index]?.let { sentence ->
                                    SentenceListItem(sentence = sentence)
                                } ?: SentenceListItemPlaceholder()
                            }

                            if (sentences.loadState.append is LoadState.Loading) {
                                item(
                                    key = "append-loader",
                                    contentType = "loader"
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(16.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        CircularProgressIndicator()
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            Spacer(modifier = Modifier.weight(1f))
        }

        LearningSessionSelector(
            onStartLearning = onStartLearning,
            onClearProgress = onClearProgress
        )
    }
}

@Composable
private fun ListHeader(
    learnedCount: Int,
    totalCount: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 18.dp),

        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            modifier = Modifier.size(48.dp),
            shape = CircleShape,
            color = MaterialTheme.colorScheme.primaryContainer
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(
                    text = "G",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 14.dp)
        ) {
            Text(
                text = "Gaplar ro‘yxati",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "10 000+ gap uchun tayyor",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Column(horizontalAlignment = Alignment.End) {
            Text(
                text = "$learnedCount/$totalCount",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = "o‘rganilgan",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
private fun LearningSessionSelector(
    onStartLearning: (Int) -> Unit,
    onClearProgress: () -> Unit
) {
    var showClearDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 10.dp)
    ) {
        Text(
            text = "Let's start the lesson.",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Bold
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            listOf(1, 3, 6, 9).forEach { count ->
                Surface(
                    modifier = Modifier
                        .size(58.dp)
                        .clickable { onStartLearning(count) },
                    shape = CircleShape,
                    color = MaterialTheme.colorScheme.primaryContainer,
                    tonalElevation = 3.dp
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(
                            text = count.toString(),
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            TextButton(onClick = { showClearDialog = true }) {
                Text("Clear")
            }
        }

        if (showClearDialog) {
            AlertDialog(
                onDismissRequest = { showClearDialog = false },
                title = { Text("Progressni tozalash") },
                text = {
                    Text("O‘rgangan gaplaringiz haqidagi barcha ma’lumotlar o‘chiriladi. Davom etasizmi?")
                },
                confirmButton = {
                    TextButton(
                        onClick = {
                            showClearDialog = false
                            onClearProgress()
                        }
                    ) {
                        Text("Clear")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showClearDialog = false }) {
                        Text("Bekor qilish")
                    }
                }
            )
        }
    }
}

@Composable
private fun SentenceListItemPlaceholder() {
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(58.dp)
    )
}

@Composable
private fun SentenceListItem(
    sentence: Sentence
) {
    val isLearned = sentence.acquaintance > 0
    val markerColor = if (isLearned) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.outlineVariant
    }
    val textColor = if (isLearned) {
        MaterialTheme.colorScheme.primary
    } else {
        MaterialTheme.colorScheme.onSurfaceVariant
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            modifier = Modifier.size(38.dp),
            shape = CircleShape,
            color = markerColor
        ) {
            Box(contentAlignment = Alignment.Center) {
                Text(
                    text = if (isLearned) "✓" else sentence.id.toString(),
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = if (isLearned) {
                        MaterialTheme.colorScheme.onPrimary
                    } else {
                        MaterialTheme.colorScheme.onSurfaceVariant
                    }
                )
            }
        }
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = sentence.english,
            modifier = Modifier.weight(1f),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = if (isLearned) FontWeight.Bold else FontWeight.Normal,
            color = textColor
        )
    }
}

@Composable
private fun ListError(
    error: Throwable,
    onRetry: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = error.message ?: "Gaplar yuklanmadi.",
            color = MaterialTheme.colorScheme.error
        )
        TextButton(onClick = onRetry) {
            Text("Qayta urinish")
        }
    }
}
