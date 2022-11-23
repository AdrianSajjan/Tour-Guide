package com.tourguide.presentation.ui.navigation.components


import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.tourguide.core.Constants


@Composable
fun BottomNavigationBar(
    navigationController: NavHostController,
) {
    var showBottomBar by rememberSaveable { mutableStateOf(true) }
    val navBackEntry by navigationController.currentBackStackEntryAsState()
    val currentRoute = navBackEntry?.destination?.route

    showBottomBar = when(currentRoute) {
        "Login" -> false
        "Register" -> false
        "Onboard" -> false
        "Details" -> false
        else -> true
    }

    if(showBottomBar) {
        BottomNavigation(
            backgroundColor = MaterialTheme.colors.background,
        ) {
            Constants.BottomNavigationItems.forEach { item ->

                val selected = currentRoute == item.route


                BottomNavigationItem(
                    selected = selected,
                    onClick = {
                        navigationController.navigate(item.route)
                    },
                    icon = {
                        Icon(
                            imageVector = if (selected) item.iconActive else item.iconInactive,
                            contentDescription = item.label,
                            tint = if(selected) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground
                        )
                    },
                )
            }
        }
    }
}