package com.tourguide.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.tourguide.presentation.home.components.card.SpotCard
import com.tourguide.presentation.home.components.error.ErrorText
import com.tourguide.presentation.home.components.header.ScreenHeader
import com.tourguide.presentation.home.components.header.SectionHeader
import com.tourguide.presentation.home.components.spinner.Spinner
import com.tourguide.presentation.ui.components.input.SearchBar


@Composable
fun HomeScreen(
    onNavigateToDetails:(String) -> Unit,
    homeViewModel: HomeViewModel = hiltViewModel()
) {

    val popularTourState = homeViewModel.popularTourState.value
    val budgetTourState = homeViewModel.budgetTourState.value
    val systemUiController = rememberSystemUiController()
    var searchText by remember { mutableStateOf("") }

    systemUiController.setStatusBarColor(MaterialTheme.colors.surface, true)

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = rememberScrollState())
                .padding(vertical = 24.dp)
        ) {
            ScreenHeader()

            Spacer(modifier = Modifier.height(24.dp))

            Box(modifier = Modifier.padding(horizontal = 24.dp)) {
                SearchBar(value = searchText, placeholder = "Search Tourist Spot", onValueChange = { searchText = it })
            }

            Spacer(modifier = Modifier.height(36.dp))

            SectionHeader(title = "Popular Spots", onClick = {})
            Spacer(modifier = Modifier.height(16.dp))
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                state = rememberLazyListState(),
                horizontalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                item { Spacer(modifier = Modifier.width(0.dp)) }
                items(items = popularTourState.tours, itemContent = { tour ->
                    SpotCard(tour = tour, onClick = onNavigateToDetails)
                })
                item { Spacer(modifier = Modifier.width(0.dp)) }
            }
            ErrorText(error = popularTourState.error)
            Spinner(isLoading = popularTourState.isLoading)

            Spacer(modifier = Modifier.height(36.dp))

            SectionHeader(title = "On Budget Tour", onClick = {})
            Spacer(modifier = Modifier.height(16.dp))
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                state = rememberLazyListState()
            ) {
                item { Spacer(modifier = Modifier.width(0.dp)) }
                items(items = budgetTourState.tours, itemContent = { tour ->
                    SpotCard(tour = tour , onClick = onNavigateToDetails)
                })
                item { Spacer(modifier = Modifier.width(0.dp)) }
            }
            ErrorText(error = budgetTourState.error)
            Spinner(isLoading = budgetTourState.isLoading)
        }
    }
}

