package com.tourguide.presentation.home.state

import com.tourguide.domain.model.Tour

data class TourListState (
    val isLoading: Boolean = false,
    val tours: List<Tour> = emptyList(),
    val error: String = ""
)