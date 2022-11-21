package com.tourguide.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.tourguide.models.Country
import com.tourguide.models.Spot
import com.tourguide.ui.components.buttons.TextButton
import com.tourguide.ui.components.input.SearchBar
import com.tourguide.ui.components.typography.Body
import com.tourguide.ui.components.typography.Heading
import com.tourguide.ui.components.typography.HeadingVariant

@Composable
fun HomeScreen() {

    var searchText by remember { mutableStateOf("") }

    val countries = listOf<Country>(
        Country(imageURL = "https://cdn.britannica.com/56/10256-050-7F90918D/immigrants-country-Statue-of-Liberty-glimpses-Upper.jpg", name = "USA"),
        Country(imageURL = "https://images.unsplash.com/photo-1537996194471-e657df975ab4", name = "Indonesia"),
        Country(imageURL = "https://i.natgeofe.com/k/c41b4f59-181c-4747-ad20-ef69987c8d59/eiffel-tower-night_2x3.jpg", name = "France"),
        Country(imageURL = "https://whc.unesco.org/uploads/thumbs/site_0252_0008-750-750-20151104113424.jpg", name = "India")
    )

    val spots = listOf<Spot> (
        Spot(imageURL = "https://whc.unesco.org/uploads/thumbs/site_0252_0008-750-750-20151104113424.jpg", name="Taj Mahal", price = "$24", location = "Agra, India", tourPackage = "3 days 2 nights"),
        Spot(imageURL = "https://whc.unesco.org/uploads/thumbs/site_0252_0008-750-750-20151104113424.jpg", name="Taj Mahal", price = "$24", location = "Agra, India", tourPackage = "3 days 2 nights"),
        Spot(imageURL = "https://whc.unesco.org/uploads/thumbs/site_0252_0008-750-750-20151104113424.jpg", name="Taj Mahal", price = "$24", location = "Agra, India", tourPackage = "3 days 2 nights"),
    )


    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 16.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data("https://www.fairtravel4u.org/wp-content/uploads/2018/06/sample-profile-pic.png")
                            .crossfade(true)
                            .build()
                    ),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(36.dp)
                        .clip(shape = RoundedCornerShape(36.dp)),
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Body(
                        text="Kolkata, India",
                    )
                    Icon(
                        imageVector = Icons.Outlined.LocationOn,
                        contentDescription = "Location",
                        tint = MaterialTheme.colors.primary,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            Column(
                verticalArrangement = Arrangement.spacedBy((-4).dp),
                modifier = Modifier.padding(horizontal = 24.dp)
            ) {
                Body(
                    text = "Welcome Back,"
                )
                Heading(
                    text = "Adrian Sajjan",
                    fontWeight = FontWeight.Medium
                )
            }

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            Box(
                modifier = Modifier.padding(horizontal = 24.dp)
            ) {
                SearchBar(
                    value = searchText,
                    placeholder = "Search Tourist Spot",
                    onValueChange = { searchText = it }
                )
            }

            Spacer(
                modifier = Modifier.height(32.dp)
            )

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Heading(
                    text = "Popular Countries",
                    headingVariant = HeadingVariant.Small,
                    fontWeight = FontWeight.Medium
                )
                TextButton(
                    text = "See All",
                    color = MaterialTheme.colors.onBackground,
                    fontWeight = FontWeight.Normal,
                    style = MaterialTheme.typography.body2
                )
            }

            Spacer(
                modifier = Modifier.height(12.dp)
            )

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                state = rememberLazyListState(),
                horizontalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                item {
                    Spacer(
                        modifier = Modifier.width(0.dp)
                    )
                }
                items(items = countries, itemContent = { country ->
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
                )
                item {
                    Spacer(
                        modifier = Modifier.width(0.dp)
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(24.dp),
            )

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Heading(
                    text = "Popular Spots",
                    headingVariant = HeadingVariant.Small,
                    fontWeight = FontWeight.Medium
                )
                TextButton(
                    text = "See All",
                    color = MaterialTheme.colors.onBackground,
                    fontWeight = FontWeight.Normal,
                    style = MaterialTheme.typography.body2
                )
            }

            Spacer(
                modifier = Modifier.height(12.dp),
            )

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                state = rememberLazyListState(),
                horizontalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                item {
                    Spacer(
                        modifier = Modifier.width(0.dp)
                    )
                }
                items(items = spots, itemContent = { spot ->
                    Column(
                        modifier = Modifier
                            .background(
                                color = MaterialTheme.colors.background,
                                shape = MaterialTheme.shapes.large
                            )
                            .padding(start = 10.dp, top = 10.dp, bottom = 18.dp, end = 10.dp),
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(
                                model = ImageRequest.Builder(LocalContext.current)
                                    .data(spot.imageURL)
                                    .crossfade(true)
                                    .build()
                            ),
                            contentScale = ContentScale.FillWidth,
                            contentDescription = spot.name,
                            modifier = Modifier
                                .height(140.dp)
                                .width(180.dp)
                                .clip(shape = MaterialTheme.shapes.medium),
                        )

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Column {
                            Heading(
                                text = spot.name,
                                headingVariant = HeadingVariant.Small,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                })
                item {
                    Spacer(
                        modifier = Modifier.width(0.dp)
                    )
                }
            }
        }
    }
}

