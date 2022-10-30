package com.tourguide.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.tourguide.R
import com.tourguide.ui.components.buttons.PrimaryButton
import com.tourguide.ui.components.buttons.SecondaryButton

@Preview(showBackground = true)
@Composable
fun OnboardScreen() {
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(MaterialTheme.colors.primaryVariant)

    Box(Modifier.fillMaxSize()) {
        Image(painterResource(id = R.drawable.onboard_background), contentDescription = "Background", contentScale = ContentScale.FillHeight)
        Column(verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 36.dp)) {
            Text(text = "Xplore".uppercase(), color = Color.White, style = MaterialTheme.typography.body1, fontWeight = FontWeight.Medium)
            Column(verticalArrangement = Arrangement.spacedBy(18.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "Explore beauty of journey".uppercase(), color = Color.White, textAlign = TextAlign.Center, style = MaterialTheme.typography.h1, fontWeight = FontWeight.Bold, fontSize = 64.sp)
                Text(text = "Everything you can image is here".lowercase(), color = Color.White, textAlign = TextAlign.Center, style = MaterialTheme.typography.body1)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(18.dp)) {
                PrimaryButton(text = "Sign In")
                Row (horizontalArrangement = Arrangement.spacedBy(4.dp)){
                   Text(text = "Don't have an account?", color = Color.White)
                   Text(text = "Register", color = Color.White, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
