package com.tourguide.presentation.home.state

data class HomeState (
    val popularCountriesState: TourListState = TourListState(),
    val popularToursState: TourListState = TourListState(),
    val cheapToursState: TourListState = TourListState()
)
