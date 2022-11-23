package com.tourguide.presentation.ui.components.typography



import androidx.compose.ui.graphics.Color
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign


@Composable
fun Caption(
    text:String,
    fontWeight: FontWeight = FontWeight.Normal,
    color: Color = MaterialTheme.colors.onBackground,
    textAlign: TextAlign = TextAlign.Left
) {
    Text(
        text = text,
        style = MaterialTheme.typography.caption,
        fontWeight = fontWeight,
        color = color,
        textAlign = textAlign
    )
}