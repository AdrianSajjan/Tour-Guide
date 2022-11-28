package com.tourguide.presentation.details

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
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.tourguide.core.common.Constants
import com.tourguide.presentation.details.components.bottom_sheet.BottomSheet
import com.tourguide.presentation.details.components.description.Description
import com.tourguide.presentation.details.components.header.Header
import com.tourguide.presentation.ui.components.buttons.PrimaryButton
import com.tourguide.presentation.ui.components.network_image.NetworkImage
import com.tourguide.presentation.ui.components.typography.*

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TourDetailScreen(
    onNavigateToPrevious: () -> Unit,
    viewModel: DetailsViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value

    val systemUiController = rememberSystemUiController()

    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberBottomSheetState(
            initialValue = BottomSheetValue.Collapsed
        )
    )

    systemUiController.setStatusBarColor(Color.Transparent, true)

    if(state.tour != null) {
        BottomSheetScaffold(
            sheetContent = {
                BottomSheet(tour = state.tour)
            },
            scaffoldState = bottomSheetScaffoldState,
            sheetPeekHeight = 125.dp,
            sheetGesturesEnabled = true,
            sheetBackgroundColor = MaterialTheme.colors.surface,
            sheetElevation = 0.dp,
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = NetworkImage(path = state.tour.images[0], baseUrl = Constants.TourPicturesBaseUrl)
                    ),
                    contentDescription = "Details",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier.fillMaxHeight()
                )
                Header (
                    onNavigateToPrevious = onNavigateToPrevious
                )
            }
        }
    }
}