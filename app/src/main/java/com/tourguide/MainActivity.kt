package com.tourguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.tourguide.ui.screens.authentication.OnboardScreen
import com.tourguide.ui.screens.authentication.RegisterScreen
import com.tourguide.ui.screens.home.HomeScreen
import com.tourguide.ui.theme.TourGuideTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TourGuideTheme {
                HomeScreen()
            }
        }
    }
}

