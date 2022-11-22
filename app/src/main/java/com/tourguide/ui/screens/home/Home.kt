package com.tourguide.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.tourguide.ui.components.buttons.TextButton
import com.tourguide.ui.components.cards.PopularCountryCard
import com.tourguide.ui.components.input.SearchBar
import com.tourguide.ui.components.typography.*
import com.tourguide.utils.Constants

@Composable
fun HomeScreen() {
    var searchText by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = rememberScrollState())
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
                    style = MaterialTheme.typography.body2,
                    onClick = {}
                )
            }

            Spacer(
                modifier = Modifier.height(16.dp)
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
                items(items = Constants.Countries, itemContent = { country ->
                        PopularCountryCard(country = country)
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
                    style = MaterialTheme.typography.body2,
                    onClick = {}
                )
            }

            Spacer(
                modifier = Modifier.height(16.dp),
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
                items(items = Constants.Spots, itemContent = { spot ->
                    Column(
                        modifier = Modifier
                            .background(
                                color = MaterialTheme.colors.background,
                                shape = MaterialTheme.shapes.large
                            )
                            .padding(start = 10.dp, top = 10.dp, bottom = 14.dp, end = 10.dp),
                    ) {
                        Box {
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
                                    .width(200.dp)
                                    .clip(shape = MaterialTheme.shapes.medium),
                            )
                            Row (
                                horizontalArrangement = Arrangement.End,
                                modifier = Modifier
                                    .width(200.dp)
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
                                        text = spot.location,
                                        color = MaterialTheme.colors.primary
                                    )
                                }
                            }
                        }

                        Spacer(
                            modifier = Modifier.height(8.dp)
                        )

                        Row (
                            modifier = Modifier
                                .width(200.dp)
                                .padding(horizontal = 4.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            Column(
                                verticalArrangement = Arrangement.spacedBy((-2).dp)
                            ) {
                                Heading(
                                    text = spot.name,
                                    headingVariant = HeadingVariant.Small,
                                    fontWeight = FontWeight.Medium
                                )
                                Body(
                                    text = spot.tourPackage,
                                    bodyVariant = BodyVariant.Secondary
                                )
                            }
                            Heading(
                                text = spot.price,
                                headingVariant = HeadingVariant.Small,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colors.primary
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
                    text = "On Budget Tour",
                    headingVariant = HeadingVariant.Small,
                    fontWeight = FontWeight.Medium
                )
                TextButton(
                    text = "See All",
                    color = MaterialTheme.colors.onBackground,
                    fontWeight = FontWeight.Normal,
                    style = MaterialTheme.typography.body2,
                    onClick = {}
                )
            }

            Spacer(
                modifier = Modifier.height(16.dp),
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                Constants.OnBudgetTours.forEach { spot ->
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
                                    .data(spot.imageURL)
                                    .crossfade(true)
                                    .build()
                            ),
                            contentScale = ContentScale.FillWidth,
                            contentDescription = spot.name,
                            modifier = Modifier
                                .height(70.dp)
                                .width(80.dp)
                                .clip(shape = MaterialTheme.shapes.medium),
                        )

                        Spacer(
                            modifier = Modifier.width(16.dp)
                        )

                        Column(
                            modifier = Modifier.weight(1f).fillMaxHeight(),
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
                                    text = spot.location,
                                    color = MaterialTheme.colors.primary
                                )
                            }
                            Spacer(
                                modifier = Modifier.height(8.dp)
                            )
                            Heading(
                                text = spot.name,
                                headingVariant = HeadingVariant.Small,
                                fontWeight = FontWeight.Medium
                            )
                            Body(
                                text = spot.tourPackage,
                                bodyVariant = BodyVariant.Secondary
                            )
                        }
                        Box(
                            modifier = Modifier.padding(end = 4.dp)
                        ) {
                            Heading(
                                text = spot.price,
                                headingVariant = HeadingVariant.Small,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colors.primary
                            )
                        }
                    }
                }
            }
        }
    }
}

