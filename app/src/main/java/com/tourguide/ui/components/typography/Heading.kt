package com.tourguide.ui.components.typography

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun Heading(
    text:String,
    color:Color = Color.White,
) {
    Text(text, fontWeight = FontWeight.Bold, fontSize = 42.sp ,color = color)
}