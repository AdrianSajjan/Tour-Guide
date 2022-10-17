package com.tourguide.ui.screens

import android.app.Activity
import android.view.WindowManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.tourguide.R
import com.tourguide.ui.components.buttons.PrimaryButton
import com.tourguide.ui.components.buttons.SecondaryButton
import com.tourguide.ui.components.typography.Heading

@Preview(showBackground = true)
@Composable
fun OnboardScreen() {
    Box(
        Modifier.fillMaxSize()
    ) {
        Image(
            painterResource(id = R.drawable.new_york),
            "New York",
            contentScale = ContentScale.FillHeight
        )
        Column(
            Modifier
                .padding(horizontal = 24.dp, vertical = 36.dp)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween,
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                Column {
                    Heading("Your Own")
                    Heading("Pocket")
                    Heading("Tourist Guide")
                }
                Row (verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Icon(Icons.Filled.LocationOn, "Location", tint = Color.White)
                    Text("New York", color = Color.White)
                }
            }
            Column (
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                PrimaryButton("Sign Up")
                SecondaryButton("Sign In")
            }
        }
    }
}
