package com.tourguide.core.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Star
import com.tourguide.presentation.navigation.models.BottomNavigationItem

object Constants {
    const val BaseUrl = "http://192.168.0.107:3000/"

    const val TourPicturesBaseUrl = "http://192.168.0.107:3000/img/tours/"
    const val UserPicturesBaseUrl = "http://192.168.0.107:3000/img/users/"

    const val ParamTourId = "tourId"

    val BottomNavigationItems = listOf(
        BottomNavigationItem(
            label = "Home",
            iconActive = Icons.Filled.Home,
            iconInactive = Icons.Outlined.Home,
            route = "Home",
        ),
        BottomNavigationItem(
            label = "Timeline",
            iconActive = Icons.Filled.List,
            iconInactive = Icons.Outlined.List,
            route = "Timeline",
        ),
        BottomNavigationItem(
            label = "Wishlist",
            iconActive = Icons.Filled.Star,
            iconInactive = Icons.Outlined.Star,
            route = "Wishlist",
        ),
        BottomNavigationItem(
            label = "Profile",
            iconActive = Icons.Filled.AccountCircle,
            iconInactive = Icons.Outlined.AccountCircle,
            route = "Profile",
        )
    )
}
