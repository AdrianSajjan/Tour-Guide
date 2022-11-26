package com.tourguide.presentation.ui.components.buttons

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun SecondaryButton(text:String, onClick: () -> Unit) {
    var isPressed by remember { mutableStateOf(false)}
    val scale = animateFloatAsState(if(isPressed) 0.95f else 1f)

    Box (
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth()
            .scale(scale.value)
            .clip(MaterialTheme.shapes.large)
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        try {
                            isPressed = true
                            awaitRelease()
                            onClick()
                        } finally {
                            isPressed = false
                        }
                    }
                )
            }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    BorderStroke(1.dp, Color.LightGray),
                    shape = MaterialTheme.shapes.large
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                color = Color.Black,
                style = MaterialTheme.typography.button,
                fontWeight = FontWeight.Medium)
        }
    }
}