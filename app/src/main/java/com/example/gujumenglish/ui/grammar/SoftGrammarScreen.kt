package com.example.gujumenglish.ui.grammar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
internal fun SoftGrammarScreen(
    onOpenLesson: (assetName: String, title: String, testLesson: Int?) -> Unit,
    modifier: Modifier = Modifier
) {
    val units = remember { groupedGrammarUnits() }
    var expandedUnitLabels by remember { mutableStateOf(emptySet<String>()) }
    val sectionGroups = remember(units) {
        units
            .mapNotNull { unit -> grammarSectionFor(unit.label) }
            .distinct()
            .map { section ->
                section to units.filter { unit ->
                    grammarSectionFor(unit.label)?.label == section.label
                }
            }
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceContainerLowest),
        contentPadding = PaddingValues(start = 20.dp, end = 20.dp, top = 28.dp, bottom = 44.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp)
    ) {
        item(key = "grammar-intro", contentType = "grammar-intro") {
            SoftGrammarIntro()
        }
        itemsIndexed(
            items = sectionGroups,
            key = { _, item -> item.first.label },
            contentType = { _, _ -> "grammar-section" }
        ) { index, item ->
            val (section, sectionUnits) = item
            SoftGrammarSection(
                sectionIndex = index,
                section = section,
                sectionUnits = sectionUnits,
                expandedUnitLabels = expandedUnitLabels,
                onToggleUnit = { label ->
                    expandedUnitLabels = if (label in expandedUnitLabels) {
                        expandedUnitLabels - label
                    } else {
                        expandedUnitLabels + label
                    }
                },
                onOpenLesson = onOpenLesson
            )
        }
    }
}

@Composable
private fun SoftGrammarIntro() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "GRAMMAR",
            style = MaterialTheme.typography.labelLarge,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            letterSpacing = 1.8.sp
        )
        Text(
            text = "O‘rganishni boshlang",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )
        Text(
            text = "Qoidalarni kichik darslarga bo‘lib, o‘zingizga qulay tezlikda o‘rganing.",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Surface(
            shape = RoundedCornerShape(18.dp),
            color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.55f)
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "Darsni tanlang va davom eting",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }
    }
}

private data class SoftSectionAccent(
    val wash: Color,
    val strong: Color
)

@Composable
private fun softSectionAccent(index: Int): SoftSectionAccent {
    val scheme = MaterialTheme.colorScheme
    val accents = listOf(
        SoftSectionAccent(scheme.primaryContainer, scheme.primary),
        SoftSectionAccent(scheme.secondaryContainer, scheme.secondary),
        SoftSectionAccent(scheme.tertiaryContainer, scheme.tertiary)
    )
    return accents[index % accents.size]
}

@Composable
private fun SoftGrammarSection(
    sectionIndex: Int,
    section: GrammarListItem.SectionHeader,
    sectionUnits: List<GrammarUnit>,
    expandedUnitLabels: Set<String>,
    onToggleUnit: (String) -> Unit,
    onOpenLesson: (assetName: String, title: String, testLesson: Int?) -> Unit
) {
    val accent = softSectionAccent(sectionIndex)

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = section.label,
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = accent.strong
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = section.title,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
            Surface(
                shape = RoundedCornerShape(14.dp),
                color = accent.wash.copy(alpha = 0.65f)
            ) {
                Text(
                    text = "${sectionUnits.size} bo‘lim",
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 7.dp),
                    style = MaterialTheme.typography.labelSmall,
                    color = accent.strong
                )
            }
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            sectionUnits.forEach { unit ->
                if (unit.label.startsWith("UNIT")) {
                    unit.topics.forEach { topic ->
                        SoftGrammarLessonRow(accent, topic, onOpenLesson)
                    }
                } else {
                    SoftGrammarTopicGroup(
                        accent = accent,
                        unit = unit,
                        isExpanded = unit.label in expandedUnitLabels,
                        onToggle = { onToggleUnit(unit.label) },
                        onOpenLesson = onOpenLesson
                    )
                }
            }
        }
    }
}

@Composable
private fun SoftGrammarTopicGroup(
    accent: SoftSectionAccent,
    unit: GrammarUnit,
    isExpanded: Boolean,
    onToggle: () -> Unit,
    onOpenLesson: (assetName: String, title: String, testLesson: Int?) -> Unit
) {
    val rotation by animateFloatAsState(
        targetValue = if (isExpanded) 180f else 0f,
        animationSpec = tween(220),
        label = "topic-group-arrow"
    )

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onToggle),
        shape = RoundedCornerShape(22.dp),
        color = MaterialTheme.colorScheme.surface
    ) {
        Column {
            Row(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 15.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .background(accent.wash.copy(alpha = 0.7f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = unit.label.substringBefore("-"),
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = accent.strong
                    )
                }
                Spacer(modifier = Modifier.width(13.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = unit.title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurface,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = "${unit.topics.size} ta dars",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Icon(
                    imageVector = Icons.Outlined.ExpandMore,
                    contentDescription = if (isExpanded) "Bo‘limni yopish" else "Bo‘limni ochish",
                    modifier = Modifier.size(24.dp).rotate(rotation),
                    tint = accent.strong
                )
            }

            AnimatedVisibility(
                visible = isExpanded,
                enter = expandVertically(tween(220)) + fadeIn(tween(220)),
                exit = shrinkVertically(tween(180)) + fadeOut(tween(180))
            ) {
                Column(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 14.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    unit.topics.forEach { topic ->
                        SoftGrammarLessonRow(accent, topic, onOpenLesson)
                    }
                }
            }
        }
    }
}

@Composable
private fun SoftGrammarLessonRow(
    accent: SoftSectionAccent,
    topic: GrammarTopic,
    onOpenLesson: (assetName: String, title: String, testLesson: Int?) -> Unit
) {
    val available = topic.assetName != null
    val practice = topic.isPractice
    val test = topic.isTest

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(enabled = available) {
                topic.assetName?.let { assetName ->
                    onOpenLesson(assetName, topic.title, topic.testLesson)
                }
            },
        shape = RoundedCornerShape(17.dp),
        color = if (available) {
            MaterialTheme.colorScheme.surfaceContainerLow
        } else {
            MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.35f)
        }
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 13.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
                    .background(accent.wash.copy(alpha = if (available) 0.8f else 0.35f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = topic.number.substringAfterLast("."),
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = if (available) accent.strong else MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = topic.title,
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = if (practice || test) FontWeight.SemiBold else FontWeight.Normal,
                color = if (available) MaterialTheme.colorScheme.onSurface else MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            if (!available) {
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Tez orada",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
