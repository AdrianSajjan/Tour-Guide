package com.tourguide.ui.screens.authentication

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.tourguide.R
import com.tourguide.ui.components.buttons.PrimaryButton
import com.tourguide.ui.components.typography.Body
import com.tourguide.ui.components.typography.Heading

@Composable
fun OnboardScreen(
    onNavigateToLogin: () -> Unit
) {
    val systemUiController = rememberSystemUiController()
    val activity = LocalContext.current as Activity
    val window = activity.window
    val configuration = LocalConfiguration.current
    val imageHeight = configuration.screenHeightDp * 0.7

    WindowCompat.setDecorFitsSystemWindows(window,false)
    systemUiController.setStatusBarColor(Color.Transparent, false)

    Column(
        modifier = Modifier.verticalScroll(
            state = rememberScrollState()
        ),
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Box {
                Image(
                    painterResource(id = R.drawable.onboard_background),
                    contentDescription = "Background",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier.height(imageHeight.dp)
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(imageHeight.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        Color.Transparent,
                                        Color.White
                                    )
                                )
                            )
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.background)
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 24.dp)
                    .fillMaxSize()
            ) {
                Column {
                    Heading(
                        text = "Explore the world with your own pocket guide",
                        textAlign = TextAlign.Center
                    )
                    Spacer(
                        modifier = Modifier.height(8.dp)
                    )
                    Body(
                        text = "Touring has never been this easy. We are free of cost and won’t break your bank account",
                        textAlign = TextAlign.Center,
                    )
                }
                Spacer(
                    modifier = Modifier.height(48.dp)
                )
                PrimaryButton(
                    text = "Get Started",
                    onClick = onNavigateToLogin
                )
            }
        }
    }
}
