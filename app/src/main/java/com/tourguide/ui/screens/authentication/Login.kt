package com.tourguide.ui.screens.authentication


import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.tourguide.R
import com.tourguide.ui.components.buttons.PrimaryButton
import com.tourguide.ui.components.buttons.TextButton
import com.tourguide.ui.components.input.Input
import com.tourguide.ui.components.typography.Body
import com.tourguide.ui.components.typography.Heading
import com.tourguide.ui.components.typography.HeadingVariant
import com.tourguide.ui.theme.FacebookTint
import com.tourguide.ui.theme.GoogleTint
import com.tourguide.ui.theme.TwitterTint

@Composable
fun LoginScreen(
    onNavigateToHome: () -> Unit,
    onNavigateToRegister: () -> Unit,
) {
    val systemUiController = rememberSystemUiController()
    val activity = LocalContext.current as Activity
    val window = activity.window

    WindowCompat.setDecorFitsSystemWindows(window, true)
    systemUiController.setStatusBarColor(MaterialTheme.colors.surface, true)

    var emailAddress by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 32.dp),
        ) {
            Column {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Heading(
                        text = "Welcome Back",
                        textAlign = TextAlign.Center,
                        headingVariant = HeadingVariant.Medium
                    )
                    Body(
                        text = "Please sign in to your account",
                        textAlign = TextAlign.Center,
                        color = Color.Gray
                    )
                }
                Spacer(
                    modifier = Modifier.height(32.dp)
                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Input(
                        value = emailAddress,
                        onValueChange = { emailAddress = it },
                        placeholder = "Email"
                    )
                    Input(
                        value = password,
                        onValueChange = { password = it },
                        placeholder = "Password"
                    )
                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        TextButton(
                            text = "Forgot Password?",
                            color = MaterialTheme.colors.onBackground,
                            onClick = {}
                        )
                    }
                }
                Spacer(
                    modifier = Modifier.height(36.dp)
                )
                Column (
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    PrimaryButton(
                        text = "Sign In",
                        onClick = onNavigateToHome
                    )
                    Body(
                        text = "Or continue with",
                        textAlign = TextAlign.Center
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(24.dp)
                    ) {
                        IconButton(

                            modifier = Modifier.background(color = GoogleTint, shape = MaterialTheme.shapes.medium),
                            onClick = {}
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.google),
                                modifier = Modifier.size(20.dp),
                                tint = Color.White,
                                contentDescription = "Google"
                            )
                        }
                        IconButton(
                            modifier = Modifier.background(color = TwitterTint, shape = MaterialTheme.shapes.medium),
                            onClick = {}
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.twitter),
                                modifier = Modifier.size(20.dp),
                                tint = Color.White,
                                contentDescription = "Twitter"
                            )
                        }
                        IconButton(
                            modifier = Modifier.background(color = FacebookTint, shape = MaterialTheme.shapes.medium),
                            onClick = {}
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.facebook),
                                modifier = Modifier.size(20.dp),
                                tint = Color.White,
                                contentDescription = "Facebook"
                            )
                        }
                    }
                }
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Body(
                        text = "Don't have an account?"
                    )
                    TextButton(
                        text = "Sign Up",
                        onClick = onNavigateToRegister
                    )
                }
            }
        }
    }
}