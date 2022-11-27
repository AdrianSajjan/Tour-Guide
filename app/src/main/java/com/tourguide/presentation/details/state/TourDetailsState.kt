package com.tourguide.presentation.details.state

import com.tourguide.domain.model.Tour

data class TourDetailsState(
    val isLoading: Boolean = false,
    val tour: Tour? = null,
    val error: String = ""
)
