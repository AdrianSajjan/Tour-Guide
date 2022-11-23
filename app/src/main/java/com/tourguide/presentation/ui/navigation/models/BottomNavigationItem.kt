package com.tourguide.presentation.ui.navigation.models

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem (
    val label: String,
    val iconActive: ImageVector,
    val iconInactive: ImageVector,
    val route: String,
)