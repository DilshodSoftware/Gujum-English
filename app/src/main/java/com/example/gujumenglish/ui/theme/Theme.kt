package com.example.gujumenglish.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = SoftPurple,
    secondary = SoftTeal,
    tertiary = SoftCoral,
    surface = Color(0xFF1E1F26),
    surfaceContainerLowest = Color(0xFF18191F),
    surfaceContainerLow = Color(0xFF22242B),
    surfaceContainer = Color(0xFF282A32),
    surfaceContainerHighest = Color(0xFF30323B),
    onSurface = Color(0xFFE8E9ED),
    onSurfaceVariant = Color(0xFFB8BEC7),
    outline = Color(0xFF3A3D48),
    outlineVariant = Color(0xFF4A4D5A)
)

private val LightColorScheme = lightColorScheme(
    primary = SoftPurpleDark,
    secondary = SoftTealDark,
    tertiary = SoftCoralDark,
    surface = SurfaceWhite,
    surfaceContainerLowest = SurfaceSoft,
    surfaceContainerLow = SurfaceWhite,
    surfaceContainer = SurfaceCard,
    surfaceContainerHighest = SurfaceSoft,
    onSurface = TextPrimary,
    onSurfaceVariant = TextSecondary,
    outline = BorderMedium,
    outlineVariant = BorderLight
)

@Composable
fun GujumEnglishTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
