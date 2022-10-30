package com.tourguide.ui.components.buttons

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun SecondaryButton(text:String) {
    val isPressed = remember { mutableStateOf(false)}
    val scale = animateFloatAsState(if(isPressed.value) 0.95f else 1f)

    Box (
        modifier = Modifier
            .height(48.dp)
            .fillMaxWidth()
            .scale(scale.value)
            .clip(MaterialTheme.shapes.medium)
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        try {
                            isPressed.value = true;
                            awaitRelease();
                        } finally {
                            isPressed.value = false;
                        }
                    }
                )
            }
    ) {
        Box(modifier = Modifier.background(color = MaterialTheme.colors.primary).fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = text, color = Color.White, style = MaterialTheme.typography.button, fontWeight = FontWeight.Medium)
        }
    }
}