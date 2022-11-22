package com.tourguide.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Star
import com.tourguide.models.BottomNavigationItem
import com.tourguide.models.BudgetTour
import com.tourguide.models.Country
import com.tourguide.models.Spot

object Constants {

    val Countries = listOf(
        Country(imageURL = "https://cdn.britannica.com/56/10256-050-7F90918D/immigrants-country-Statue-of-Liberty-glimpses-Upper.jpg", name = "USA"),
        Country(imageURL = "https://images.unsplash.com/photo-1537996194471-e657df975ab4", name = "Indonesia"),
        Country(imageURL = "https://i.natgeofe.com/k/c41b4f59-181c-4747-ad20-ef69987c8d59/eiffel-tower-night_2x3.jpg", name = "France"),
        Country(imageURL = "https://whc.unesco.org/uploads/thumbs/site_0252_0008-750-750-20151104113424.jpg", name = "India")
    )

    val Spots = listOf(
        Spot(imageURL = "https://whc.unesco.org/uploads/thumbs/site_0252_0008-750-750-20151104113424.jpg", name="Taj Mahal", price = "$24", location = "Agra, India", tourPackage = "3 days 2 nights"),
        Spot(imageURL = "https://whc.unesco.org/uploads/thumbs/site_0252_0008-750-750-20151104113424.jpg", name="Taj Mahal", price = "$24", location = "Agra, India", tourPackage = "3 days 2 nights"),
        Spot(imageURL = "https://whc.unesco.org/uploads/thumbs/site_0252_0008-750-750-20151104113424.jpg", name="Taj Mahal", price = "$24", location = "Agra, India", tourPackage = "3 days 2 nights"),
    )

    val OnBudgetTours = listOf(
        BudgetTour(imageURL = "https://images.unsplash.com/photo-1537996194471-e657df975ab4", name = "Indonesia Beaches", price = "$10", tourPackage = "4 days 3 nights", location = "Bali, Indonesia"),
        BudgetTour(imageURL = "https://images.unsplash.com/photo-1537996194471-e657df975ab4", name = "Indonesia Beaches", price = "$10", tourPackage = "4 days 3 nights", location = "Bali, Indonesia"),
        BudgetTour(imageURL = "https://images.unsplash.com/photo-1537996194471-e657df975ab4", name = "Indonesia Beaches", price = "$10", tourPackage = "4 days 3 nights", location = "Bali, Indonesia"),
        BudgetTour(imageURL = "https://images.unsplash.com/photo-1537996194471-e657df975ab4", name = "Indonesia Beaches", price = "$10", tourPackage = "4 days 3 nights", location = "Bali, Indonesia")
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
