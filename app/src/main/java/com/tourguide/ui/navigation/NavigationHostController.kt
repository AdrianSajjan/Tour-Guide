package com.tourguide.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.tourguide.ui.screens.authentication.LoginScreen
import com.tourguide.ui.screens.authentication.OnboardScreen
import com.tourguide.ui.screens.authentication.RegisterScreen
import com.tourguide.ui.screens.home.HomeScreen

@Composable
fun NavigationHostController(
    navigationController: NavHostController,
    padding: PaddingValues
) {
    NavHost(
        navController = navigationController,
        startDestination = "Onboard",
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
        }
    )
}
