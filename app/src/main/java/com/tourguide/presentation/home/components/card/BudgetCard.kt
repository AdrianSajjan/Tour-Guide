package com.tourguide.presentation.home.components.card

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.tourguide.domain.model.Tour
import com.tourguide.presentation.ui.components.typography.*

@Composable
fun BudgetCard(
    tour:Tour,
    onClick: (String) -> Unit
) {
    var isPressed by remember { mutableStateOf(false) }
    val scale = animateFloatAsState(if(isPressed) 0.95f else 1f)

    Row(
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
                            onClick(tour.name)
                        }
                    }
                )
            }
            .background(
                color = MaterialTheme.colors.background,
                shape = MaterialTheme.shapes.large
            )
            .padding(all = 10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
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
                .height(70.dp)
                .width(80.dp)
                .clip(shape = MaterialTheme.shapes.medium),
        )

        Spacer(
            modifier = Modifier.width(16.dp)
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = Icons.Outlined.LocationOn,
                    contentDescription = "Location",
                    tint = MaterialTheme.colors.primary,
                    modifier = Modifier.size(12.dp)
                )
                Spacer(
                    modifier = Modifier.width(2.dp)
                )
                Caption(
                    text = tour.startLocation.address,
                    color = MaterialTheme.colors.primary
                )
            }
            Spacer(
                modifier = Modifier.height(8.dp)
            )
            Heading(
                text = tour.name,
                headingVariant = HeadingVariant.Small,
                fontWeight = FontWeight.Medium
            )
        }
        Box(
            modifier = Modifier.padding(end = 4.dp)
        ) {
            Body (
                text = "INR ${String.format("%1$,.2f",  tour.price)}",
                bodyVariant = BodyVariant.Secondary,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colors.primary
            )
        }
    }
}