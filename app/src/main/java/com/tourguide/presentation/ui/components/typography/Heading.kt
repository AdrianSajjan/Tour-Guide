package com.tourguide.presentation.ui.components.typography

import androidx.compose.ui.graphics.Color
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

enum class HeadingVariant { Large, Medium, Small }

@Composable
fun Heading(
    text:String,
    fontWeight: FontWeight = FontWeight.Bold,
    color: Color = MaterialTheme.colors.onSurface,
    headingVariant: HeadingVariant = HeadingVariant.Large,
    textAlign: TextAlign = TextAlign.Left,
    modifier: Modifier = Modifier
) {
    val style = when(headingVariant) {
        HeadingVariant.Large -> MaterialTheme.typography.h1
        HeadingVariant.Medium -> MaterialTheme.typography.h2
        else -> MaterialTheme.typography.h3
    }

    Text(text = text, style = style, fontWeight = fontWeight, color = color, textAlign = textAlign, modifier = modifier)
}