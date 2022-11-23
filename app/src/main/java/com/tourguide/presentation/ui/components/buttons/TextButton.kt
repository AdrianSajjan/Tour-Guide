package com.tourguide.presentation.ui.components.buttons

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration

@Composable
fun TextButton(
    text:String,
    color:Color = MaterialTheme.colors.primary,
    textDecoration: TextDecoration = TextDecoration.None,
    fontWeight: FontWeight = FontWeight.Medium,
    style: TextStyle = MaterialTheme.typography.body1,
    onClick: () -> Unit,
) {
    var isPressed by remember { mutableStateOf(false) }
    val scale = animateFloatAsState(if(isPressed) 0.9f else 1f)

    Box (
        modifier = Modifier
            .scale(scale.value)
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        try {
                            isPressed = true
                            awaitRelease()
                        } finally {
                            isPressed = false
                            onClick()
                        }
                    }
                )
            }
    ) {
        Text(
            text = text,
            color = color,
            style = style,
            fontWeight = fontWeight,
            textDecoration = textDecoration
        )
    }
}
