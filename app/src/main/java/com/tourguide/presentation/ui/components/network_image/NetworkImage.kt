package com.tourguide.presentation.ui.components.network_image

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import coil.request.ImageRequest

@Composable
fun NetworkImage(
    path: String,
    baseUrl: String,
): ImageRequest {
    return ImageRequest.Builder(LocalContext.current).data(baseUrl + path).crossfade(true).build()
}