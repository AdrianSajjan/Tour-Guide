package com.tourguide.presentation.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tourguide.presentation.ui.details.TourDetailScreen
import com.tourguide.presentation.ui.login.LoginScreen
import com.tourguide.presentation.ui.onboard.OnboardScreen
import com.tourguide.presentation.ui.register.RegisterScreen
import com.tourguide.presentation.ui.home.HomeScreen

@Composable
fun NavigationHostController(
    navigationController: NavHostController,
    padding: PaddingValues
) {
    NavHost(
        navController = navigationController,
        startDestination = "Details",
        modifier = Modifier.padding(padding),
        builder = {
            composable("Onboard") {
                OnboardScreen (
                    onNavigateToLogin = {
                        navigationController.navigate("Login")
                    }
                )
            }
            composable("Login") {
                LoginScreen(
                    onNavigateToHome = {
                        navigationController.navigate("Home")
                    },
                    onNavigateToRegister = {
                        navigationController.navigate("Register")
                    }
                )
            }
            composable("Register") {
                RegisterScreen(
                    onNavigateToHome = {
                        navigationController.navigate("Home")
                    },
                    onNavigateToLogin = {
                        navigationController.navigate("Login")
                    }
                )
            }
            composable("Home") {
                HomeScreen()
            }
            composable("Details") {
                TourDetailScreen()
            }
        }
    )
}
