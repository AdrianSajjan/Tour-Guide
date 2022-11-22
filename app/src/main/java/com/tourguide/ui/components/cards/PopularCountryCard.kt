package com.tourguide.ui.components.cards


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.tourguide.models.Country
import com.tourguide.ui.components.typography.Body


@Composable
fun PopularCountryCard(
    country: Country
) {
    Row(
        modifier = Modifier
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
                    .data(country.imageURL)
                    .crossfade(true)
                    .build()
            ),
            contentScale = ContentScale.FillWidth,
            contentDescription = country.name,
            modifier = Modifier
                .size(36.dp)
                .clip(shape = MaterialTheme.shapes.medium),
        )
        Body(
            text = country.name
        )
    }
}