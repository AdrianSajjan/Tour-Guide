package com.tourguide.presentation.ui.home.components.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.tourguide.domain.models.Tour
import com.tourguide.presentation.ui.components.typography.*

@Composable
fun BudgetCard(
    tour:Tour
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colors.background,
                shape = MaterialTheme.shapes.large
            )
            .padding(all = 10.dp),
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
                    text = String.format("%s, %s", tour.state, tour.country),
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
            Body(
                text = tour.tourPackage,
                bodyVariant = BodyVariant.Secondary
            )
        }
        Box(
            modifier = Modifier.padding(end = 4.dp)
        ) {
            Body (
                text = String.format("%s %s", tour.currencyDisplay, String.format("%1$,.2f",  tour.price)),
                bodyVariant = BodyVariant.Secondary,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colors.primary
            )
        }
    }
}