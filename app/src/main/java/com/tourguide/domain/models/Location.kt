package com.tourguide.domain.models

data class Location (
    val type: String,
    val address: String,
    val description: String,
    val coordinates: List<Double>
)