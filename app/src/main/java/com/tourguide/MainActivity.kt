package com.tourguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.navigation.compose.rememberNavController
import com.tourguide.ui.navigation.BottomNavigationBar
import com.tourguide.ui.navigation.NavigationHostController
import com.tourguide.ui.theme.TourGuideTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            TourGuideTheme {
                val navigationController = rememberNavController()

                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            navigationController = navigationController
                        )
                    },
                    content = { padding ->
                        NavigationHostController(
                            navigationController = navigationController,
                            padding = padding
                        )
                    },
                    backgroundColor = MaterialTheme.colors.background,
                )
            }
        }
    }
}


