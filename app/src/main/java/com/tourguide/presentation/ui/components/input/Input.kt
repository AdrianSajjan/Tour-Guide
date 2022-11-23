package com.tourguide.presentation.ui.components.input

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Input(value:String, placeholder: String, onValueChange: (String) -> Unit) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        textStyle = MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.onSurface),
        decorationBox = {
            innerTextField -> Box(modifier = Modifier.fillMaxWidth().height(56.dp)
            .background(color = MaterialTheme.colors.background, shape = MaterialTheme.shapes.large)
            .absolutePadding(top = 18.dp, left = 24.dp, right = 24.dp),
        ) {
                if(value.isEmpty()) {
                    Text(text = placeholder, color = Color.Gray)
                }
                innerTextField()
            }
        }
    )
}