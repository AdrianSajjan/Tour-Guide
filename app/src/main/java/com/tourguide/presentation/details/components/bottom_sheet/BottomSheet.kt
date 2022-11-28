package com.tourguide.presentation.details.components.bottom_sheet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import coil.compose.rememberAsyncImagePainter
import com.tourguide.core.common.Constants
import com.tourguide.domain.model.Tour
import com.tourguide.presentation.details.components.description.Description
import com.tourguide.presentation.ui.components.buttons.PrimaryButton
import com.tourguide.presentation.ui.components.network_image.NetworkImage
import com.tourguide.presentation.ui.components.typography.Body
import com.tourguide.presentation.ui.components.typography.BodyVariant
import com.tourguide.presentation.ui.components.typography.Heading
import com.tourguide.presentation.ui.components.typography.HeadingVariant

@Composable
fun BottomSheet(
    tour: Tour,
) {

    var expanded by remember { mutableStateOf(false) }

    Column {
        Column(
            modifier = Modifier
                .padding(vertical = 12.dp, horizontal = 24.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .width(80.dp)
                        .height(4.dp)
                        .background(Color.LightGray, MaterialTheme.shapes.large)
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column {
                    Heading(text = tour.name, headingVariant = HeadingVariant.Medium)
                    Body(text = "Duration - ${tour.duration} days")
                }
                Row(
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Icons.Outlined.LocationOn,
                        contentDescription = "Location",
                        tint = MaterialTheme.colors.primary,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(
                        modifier = Modifier.width(2.dp)
                    )
                    Body(
                        text = tour.startLocation.description,
                        color = MaterialTheme.colors.primary,
                        bodyVariant = BodyVariant.Secondary
                    )
                }
            }
            Spacer(modifier = Modifier.height(36.dp))
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Body(
                    text = "Summary",
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colors.onSurface
                )
                Body(
                    text = tour.summary,
                    bodyVariant = BodyVariant.Secondary,
                    lineHeight = 1.6.em
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Body(
                    text = "Description",
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colors.onSurface
                )
                Description(
                    expanded = expanded,
                    description = tour.description,
                    onClick = {
                        expanded = !expanded
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 24.dp)
            ) {
                Body(
                    text = "Tour Guides",
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colors.onSurface
                )
            }
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                item {
                    Spacer(modifier = Modifier)
                }
                items(items = tour.guides, itemContent = { guide ->
                    Row(
                        modifier = Modifier
                            .background(
                                MaterialTheme.colors.background,
                                MaterialTheme.shapes.medium
                            )
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(
                                model = NetworkImage(
                                    path = guide.photo,
                                    baseUrl = Constants.UserPicturesBaseUrl
                                )
                            ),
                            contentDescription = "Profile Photo",
                            modifier = Modifier
                                .height(36.dp)
                                .width(36.dp)
                                .clip(MaterialTheme.shapes.small)
                        )
                        Body(text = guide.name, bodyVariant = BodyVariant.Secondary)
                        Spacer(modifier = Modifier)
                    }
                }
                )
                item {
                    Spacer(modifier = Modifier)
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier.padding(horizontal = 24.dp)
            ) {
                Body(
                    text = "Tour Locations",
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colors.onSurface
                )
            }
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                item {
                    Spacer(modifier = Modifier)
                }
                itemsIndexed(items = tour.locations) { index, location ->
                    Row(
                        modifier = Modifier
                            .background(
                                MaterialTheme.colors.background,
                                MaterialTheme.shapes.medium
                            )
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(
                                model = NetworkImage(
                                    path = if(index > tour.images.size - 1) tour.images[0] else tour.images[index],
                                    baseUrl = Constants.TourPicturesBaseUrl
                                )
                            ),
                            contentDescription = "Profile Photo",
                            contentScale = ContentScale.FillHeight,
                            modifier = Modifier
                                .height(36.dp)
                                .width(36.dp)
                                .clip(MaterialTheme.shapes.small)
                        )
                        Column() {
                            Body(
                                text = if(location.day != null) "Day ${location.day}" else "",
                                bodyVariant = BodyVariant.Secondary, fontWeight = FontWeight.Medium
                            )
                            Body(
                                text = location.description,
                                bodyVariant = BodyVariant.Secondary
                            )
                        }
                        Spacer(modifier = Modifier)
                    }
                }
                item {
                    Spacer(modifier = Modifier)
                }
            }
        }

        Spacer(modifier = Modifier.height(36.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.background)
                .padding(vertical = 16.dp, horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(36.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                Body(
                    text = "Tour Price",
                    color = MaterialTheme.colors.onSurface,
                    fontWeight = FontWeight.Medium
                )
                Heading(
                    text = "INR ${String.format("%1$,.2f", tour.price)}",
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colors.primary,
                    headingVariant = HeadingVariant.Small
                )
            }
            PrimaryButton(text = "Book Tour", onClick = {})
        }
    }
}
