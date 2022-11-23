package com.tourguide.core

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Star
import com.tourguide.presentation.ui.navigation.models.BottomNavigationItem
import com.tourguide.domain.models.Tour

object Constants {

    val Tours = listOf(
        Tour(
            thumbnail = "https://cdn.britannica.com/56/10256-050-7F90918D/immigrants-country-Statue-of-Liberty-glimpses-Upper.jpg",
            name = "Statue Of Liberty",
            country = "USA",
            state = "New York",
            price = 12500.0,
            currencyDisplay = "₹",
            currencyName = "INR",
            tourPackage = "3 days 2 nights",
            images = listOf("")
        ),
        Tour(
            thumbnail = "https://images.unsplash.com/photo-1537996194471-e657df975ab4",
            name = "Bali Beaches",
            images = listOf(""),
            tourPackage = "4 days 3 nights",
            country = "Indonesia",
            state = "Bali",
            price = 44000.0,
            currencyDisplay = "₹",
            currencyName = "INR",
        ),
        Tour(
            thumbnail = "https://i.natgeofe.com/k/c41b4f59-181c-4747-ad20-ef69987c8d59/eiffel-tower-night_2x3.jpg",
            name = "Eiffel Tower",
            currencyDisplay = "₹",
            currencyName = "INR",
            images = listOf(""),
            price = 56000.0,
            state = "Paris",
            country = "France",
            tourPackage = "6 days 5 nights"
        ),
        Tour(
            thumbnail = "https://whc.unesco.org/uploads/thumbs/site_0252_0008-750-750-20151104113424.jpg",
            name = "Taj Mahal",
            currencyDisplay = "₹",
            currencyName = "INR",
            images = listOf(""),
            tourPackage = "3 days 2 nights",
            country = "India",
            state = "Agra",
            price = 7000.0
        )
    )

    val BottomNavigationItems = listOf(
        BottomNavigationItem(
            label = "Home",
            iconActive = Icons.Filled.Home,
            iconInactive = Icons.Outlined.Home,
            route = "Home",
        ),
        BottomNavigationItem(
            label = "Details",
            iconActive = Icons.Filled.List,
            iconInactive = Icons.Outlined.List,
            route = "Details",
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
