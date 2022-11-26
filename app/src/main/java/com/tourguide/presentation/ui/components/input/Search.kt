package com.tourguide.presentation.ui.components.input

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tourguide.R

@Composable
fun SearchBar(
    value:String,
    placeholder: String,
    onValueChange: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(color = MaterialTheme.colors.background, shape = MaterialTheme.shapes.large)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(
            imageVector = Icons.Rounded.Search,
            contentDescription = "Search",
            tint = MaterialTheme.colors.onBackground,
        )
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            modifier = Modifier.weight(1f),
            textStyle = MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.onSurface),
            decorationBox = { innerTextField ->
                Box {
                    if (value.isEmpty())
                        Text(text = placeholder, color = Color.Gray)
                    innerTextField()
                }
            }
        )
        IconButton(
            onClick = {},
            modifier = Modifier.size(48.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.tune),
                contentDescription = "Search",
                tint = MaterialTheme.colors.primary,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}