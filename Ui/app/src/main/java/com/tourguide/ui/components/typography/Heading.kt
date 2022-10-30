package com.tourguide.ui.components.typography

import android.graphics.Color
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight

@Composable
fun Heading(text:String, fontWeight: FontWeight?, color: Color?) {
    val weight = if(fontWeight !== null) fontWeight else FontWeight.Bold
    Text(text = text, style = MaterialTheme.typography.h1, fontWeight = weight)
}