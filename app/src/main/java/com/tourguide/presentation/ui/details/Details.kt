package com.tourguide.presentation.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.tourguide.core.Constants
import com.tourguide.domain.models.Tour
import com.tourguide.presentation.ui.components.buttons.PrimaryButton
import com.tourguide.presentation.ui.components.typography.*
import com.tourguide.presentation.ui.details.components.description.Description

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TourDetailScreen(
    id: String,
    onNavigateToPrevious: () -> Unit
) {

    val tour = Constants.Tours.find { tour -> tour.name == id }

    val systemUiController = rememberSystemUiController()
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(
            initialValue = BottomSheetValue.Collapsed
        )
    )

    systemUiController.setStatusBarColor(Color.Transparent, true)

    if(tour != null) {
        BottomSheetScaffold(
            {
                Column(
                    modifier = Modifier.padding(
                        top = 12.dp,
                        bottom = 24.dp,
                        start = 24.dp,
                        end = 24.dp
                    )
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
                        Column() {
                            Heading(text = tour.name, headingVariant = HeadingVariant.Medium)
                            Body(text = tour.tourPackage)
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
                                text = String.format("%s, %s", tour.state, tour.country),
                                color = MaterialTheme.colors.primary,
                                bodyVariant = BodyVariant.Secondary
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(36.dp))
                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                    ) {
                        Body(
                            text = "Description",
                            fontWeight = FontWeight.Medium,
                            color = MaterialTheme.colors.onSurface
                        )
                        Description(description = tour.description)
                    }
                    Spacer(modifier = Modifier.height(48.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
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
                                text = "${tour.currencyDisplay} ${String.format("%1$,.2f",  tour.price)}",
                                fontWeight = FontWeight.Medium,
                                color = MaterialTheme.colors.primary,
                                headingVariant = HeadingVariant.Small
                            )
                        }
                        PrimaryButton(text = "Book Tour", onClick = {})
                    }
                }
            },
            scaffoldState = bottomSheetScaffoldState,
            sheetPeekHeight = 125.dp,
            sheetGesturesEnabled = true,
            sheetBackgroundColor = MaterialTheme.colors.background,
            sheetElevation = 0.dp,
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(tour.thumbnail)
                            .crossfade(true)
                            .build()
                    ),
                    contentDescription = "Details",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier.fillMaxHeight()
                )
                Row(
                    modifier = Modifier.statusBarsPadding().padding(vertical = 8.dp, horizontal = 24.dp)
                ) {
                    IconButton(onClick = onNavigateToPrevious, modifier = Modifier.background(MaterialTheme.colors.background, MaterialTheme.shapes.large)) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back", tint = MaterialTheme.colors.onSurface)
                    }
                }
            }
        }
    }
}