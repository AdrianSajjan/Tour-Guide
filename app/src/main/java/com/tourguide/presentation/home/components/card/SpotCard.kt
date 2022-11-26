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
import com.tourguide.core.common.Constants
import com.tourguide.domain.model.Tour
import com.tourguide.presentation.ui.components.typography.*

@Composable
fun SpotCard(
    tour:Tour,
    onClick: (String) -> Unit
) {
    var isPressed by remember { mutableStateOf(false) }
    val scale = animateFloatAsState(if(isPressed) 0.95f else 1f)

    Column(
        modifier = Modifier
            .width(intrinsicSize = IntrinsicSize.Max)
            .scale(scale.value)
            .pointerInput(Unit) {
                detectTapGestures(
                    onPress = {
                        try {
                            isPressed = true
                            awaitRelease()
                            onClick(tour.name)
                        } finally {
                            isPressed = false
                        }
                    }
                )
            }
            .background(
                color = MaterialTheme.colors.background,
                shape = MaterialTheme.shapes.large
            )
            .padding(start = 10.dp, top = 10.dp, bottom = 14.dp, end = 10.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(Constants.TourPicturesBaseUrl + tour.thumbnail)
                        .crossfade(true)
                        .build()
                ),
                contentScale = ContentScale.FillWidth,
                contentDescription = tour.name,
                modifier = Modifier
                    .height(140.dp)
                    .fillMaxWidth()
                    .clip(shape = MaterialTheme.shapes.medium)
                    .defaultMinSize(minWidth = 220.dp),
            )
            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 8.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colors.background,
                            shape = MaterialTheme.shapes.small
                        )
                        .padding(vertical = 4.dp, horizontal = 8.dp)
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
                        text = tour.startLocation.description,
                        color = MaterialTheme.colors.primary
                    )
                }
            }
        }

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Row(
            modifier = Modifier
                .padding(horizontal = 4.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Column {
                Heading(
                    text = tour.name,
                    headingVariant = HeadingVariant.Small,
                    fontWeight = FontWeight.Medium
                )
                Body(
                    text = "Duration - ${tour.duration} days",
                    bodyVariant = BodyVariant.Secondary,
                )
            }
            Spacer(modifier = Modifier.width(24.dp))
            Body(
                text = "INR ${String.format("%1$,.2f", tour.price)}",
                bodyVariant = BodyVariant.Secondary,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colors.primary
            )
        }
    }
}