package com.tourguide.presentation.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tourguide.core.Constants
import com.tourguide.presentation.ui.components.input.SearchBar
import com.tourguide.presentation.ui.home.components.card.BudgetCard
import com.tourguide.presentation.ui.home.components.card.CountryCard
import com.tourguide.presentation.ui.home.components.card.SpotCard
import com.tourguide.presentation.ui.home.components.header.ScreenHeader
import com.tourguide.presentation.ui.home.components.header.SectionHeader

@Preview
@Composable
fun HomeScreen() {
    var searchText by remember { mutableStateOf("") }

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

            Spacer(modifier = Modifier.height(32.dp))

            SectionHeader(title = "Popular Countries", onClick = {})

            Spacer(modifier = Modifier.height(16.dp))

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                state = rememberLazyListState(),
                horizontalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                item { Spacer(modifier = Modifier.width(0.dp)) }
                items(items = Constants.Tours, itemContent = { tour ->
                        CountryCard(tour = tour)
                    }
                )
                item { Spacer(modifier = Modifier.width(0.dp)) }
            }

            Spacer(modifier = Modifier.height(24.dp))

            SectionHeader(title = "Popular Spots", onClick = {})

            Spacer(modifier = Modifier.height(16.dp))

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                state = rememberLazyListState(),
                horizontalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                item { Spacer(modifier = Modifier.width(0.dp)) }
                items(items = Constants.Tours, itemContent = { tour ->
                    SpotCard(tour = tour)
                })
                item { Spacer(modifier = Modifier.width(0.dp)) }
            }

            Spacer(modifier = Modifier.height(24.dp))

            SectionHeader(title = "On Budget Tour", onClick = {})

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Constants.Tours.forEach { tour ->
                    BudgetCard(tour = tour)
                }
            }
        }
    }
}

