package com.tourguide.presentation.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = darkColors(
    primary = Orange500,
    onPrimary = Color.White,
    surface = Gray100,
    onSurface = Color.Black,
    background = White100,
    onBackground = Color.Gray,
)

private val DarkColorPalette = lightColors(
    primary = Orange500,
    onPrimary = Color.White,
    surface = Black700,
    onSurface = White100,
    background = Gray500,
    onBackground = Color.White,
)

@Composable
fun TourGuideTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = LightColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}