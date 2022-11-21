package com.tourguide.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen() {
    val top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding();

    Surface(modifier = Modifier.fillMaxSize().absolutePadding(top = top).background(color = MaterialTheme.colors.surface)) {

    }
}