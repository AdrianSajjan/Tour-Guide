package com.tourguide.ui.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun SecondaryButton(
    text:String
) {
    Row() {
        Box(
            Modifier.height(48.dp).border(BorderStroke(2.dp, MaterialTheme.colors.primary)).weight(1f).padding(horizontal = 18.dp),
            Alignment.CenterStart
        ) {
            Text(
                text,
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )
        }
        Box(
            Modifier.height(48.dp).width(48.dp).background(Color.White),
            Alignment.Center,
        ) {
            Icon(Icons.Filled.ArrowForward, contentDescription = "Arrow")
        }
    }
}