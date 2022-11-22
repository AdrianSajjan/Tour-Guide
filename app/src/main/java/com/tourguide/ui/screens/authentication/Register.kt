package com.tourguide.ui.screens.authentication


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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
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
fun RegisterScreen(
    onNavigateToLogin: () -> Unit,
    onNavigateToHome: () -> Unit,
) {
    
    var name by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
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
                        text = "Welcome",
                        textAlign = TextAlign.Center,
                        headingVariant = HeadingVariant.Medium
                    )
                    Body(
                        text = "Create your account to continue",
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
                        value = name,
                        onValueChange = { name = it },
                        placeholder = "Full Name"
                    )
                    Input(
                        value = phoneNumber,
                        onValueChange = { phoneNumber = it },
                        placeholder = "Phone Number"
                    )
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
                        text = "Sign Up",
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
                        text = "Already have an account?"
                    )
                    TextButton(
                        text = "Sign In",
                        onClick = onNavigateToLogin
                    )
                }
            }
        }
    }
}