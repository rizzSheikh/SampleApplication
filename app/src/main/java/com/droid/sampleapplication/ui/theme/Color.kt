package com.droid.sampleapplication.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val PrimaryColor = Color(0xFFD0BCFF)
val PrimaryDarkColor = Color(0xFF6650a4) // Darker shade of the primary color
val acceptedStatusColor = Color(color = 0xFF4CAF50)
val inProgressStatusColor = Color(color = 0xFFFF9800)
val openStatusColor = Color(color = 0xFF03A9F4)
val onRouteStatusColor = Color(color = 0xFF9C27B0)
val closeStatusColor = Color(color = 0xFFF44336)
val AppBarColor = Color(color = 0xFF02191E)

// Define additional colors for light theme
val LightBackground = Color(0xFFFFFFFF)
val LightSurface = Color(0xFFFFFFFF)
val LightOnPrimary = Color(0xFFFFFFFF)
val LightOnBackground = Color(0xFF000000)

// Define additional colors for dark theme
val DarkBackground = Color(0xFF121212)
val DarkSurface = Color(0xFF1E1E1E)
val DarkOnPrimary = Color(0xFFFFFFFF)
val DarkOnBackground = Color(0xFFFFFFFF)

val LightCustomColorsPalette = CustomColorsPalette(
    grayColor = Color(0xFFC6C6C6),
)

val DarkCustomColorsPalette = CustomColorsPalette(
    grayColor = Color(0xFFC6C6C6),
)

val LocalCustomColorsPalette = staticCompositionLocalOf { CustomColorsPalette() }

@Immutable
data class CustomColorsPalette(
    val grayColor: Color = Color.Unspecified,
)

