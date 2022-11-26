package com.tourguide.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.tourguide.presentation.navigation.components.BottomNavigationBar
import com.tourguide.presentation.navigation.NavigationHostController
import com.tourguide.presentation.ui.theme.TourGuideTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window,false)

        setContent {
            TourGuideTheme {
                val navigationController = rememberNavController()

                Scaffold(
                    bottomBar = {
                        //BottomNavigationBar(
                        //    navigationController = navigationController
                        //)
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


