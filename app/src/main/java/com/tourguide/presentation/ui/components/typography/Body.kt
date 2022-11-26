package com.tourguide.presentation.ui.components.typography

import androidx.compose.ui.graphics.Color
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.em

enum class BodyVariant { Primary, Secondary }

@Composable
fun Body(text:String, fontWeight: FontWeight = FontWeight.Normal, color: Color = MaterialTheme.colors.onBackground, bodyVariant: BodyVariant = BodyVariant.Primary, textAlign: TextAlign = TextAlign.Left) {
    val style = if(bodyVariant == BodyVariant.Primary) MaterialTheme.typography.body1 else MaterialTheme.typography.body2

    Text(text = text, style = style, fontWeight = fontWeight, color = color, textAlign = textAlign, lineHeight = 1.5.em)
}