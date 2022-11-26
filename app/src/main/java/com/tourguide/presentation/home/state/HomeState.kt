package com.tourguide.presentation.home.state

data class HomeState (
    var popularCountries: TourListState = TourListState(),
    var popularTours: TourListState = TourListState(),
    var cheapTours: TourListState = TourListState()
)
