package com.tourguide.presentation.details.components.header

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Header(
    onNavigateToPrevious: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(vertical = 12.dp, horizontal = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        IconButton(onClick = onNavigateToPrevious, modifier = Modifier.background(MaterialTheme.colors.background, MaterialTheme.shapes.large)) {
            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back", tint = MaterialTheme.colors.onSurface)
        }
        IconButton(onClick = onNavigateToPrevious, modifier = Modifier.background(MaterialTheme.colors.background, MaterialTheme.shapes.large)) {
            Icon(imageVector = Icons.Filled.FavoriteBorder, contentDescription = "Back", tint = MaterialTheme.colors.onSurface)
        }
    }
}