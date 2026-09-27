package com.example.gujumenglish.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.BarChart
import androidx.compose.material.icons.outlined.MenuBook
import androidx.compose.material.icons.outlined.RecordVoiceOver
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

enum class MainSection {
    GRAMMAR,
    PRACTICE,
    STATISTICS
}

private data class NavigationItem(
    val section: MainSection,
    val label: String,
    val icon: ImageVector
)

@Composable
fun MainBottomNavigation(
    selectedSection: MainSection,
    onSectionSelected: (MainSection) -> Unit
) {
    val items = listOf(
        NavigationItem(MainSection.GRAMMAR, "Grammar", Icons.Outlined.MenuBook),
        NavigationItem(MainSection.PRACTICE, "Practice", Icons.Outlined.RecordVoiceOver),
        NavigationItem(MainSection.STATISTICS, "Statistics", Icons.Outlined.BarChart)
    )
    val navigationColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.45f)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(navigationColor)
    ) {
        NavigationBar(
            modifier = Modifier.fillMaxWidth(),
            containerColor = navigationColor,
            tonalElevation = 0.dp,
            windowInsets = WindowInsets(0, 0, 0, 0)
        ) {
            items.forEach { item ->
                NavigationBarItem(
                    selected = selectedSection == item.section,
                    onClick = { onSectionSelected(item.section) },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.label
                        )
                    },
                    label = { Text(item.label) }
                )
            }
        }
    }
}
