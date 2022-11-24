package com.tourguide.presentation.ui.home.components.card

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.tourguide.domain.models.Tour
import com.tourguide.presentation.ui.components.typography.Body

@Composable
fun CountryCard(
    tour: Tour,
    //onClick: () -> Unit
) {
    var isPressed by remember { mutableStateOf(false) }
    val scale = animateFloatAsState(if(isPressed) 0.95f else 1f)

    Row(
        modifier = Modifier
            .width(intrinsicSize = IntrinsicSize.Max)
            .scale(scale.value)
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        try {
                            isPressed = true
                            awaitRelease()
                        } finally {
                            isPressed = false
                            //onClick(tour.name)
                        }
                    }
                )
            }
            .background(
                color = MaterialTheme.colors.background,
                shape = MaterialTheme.shapes.large
            )
            .padding(start = 8.dp, top = 8.dp, bottom = 8.dp, end = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(tour.thumbnail)
                    .crossfade(true)
                    .build()
            ),
            contentScale = ContentScale.FillWidth,
            contentDescription = tour.name,
            modifier = Modifier
                .size(36.dp)
                .clip(shape = MaterialTheme.shapes.medium),
        )
        Body(
            text = tour.country
        )
    }
}