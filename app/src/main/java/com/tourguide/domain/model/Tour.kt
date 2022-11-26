package com.tourguide.domain.model

import java.util.Date

data class Tour (
    val id: String,
    val slug: String,
    val name: String,
    val duration: Int,
    val maxGroupSize: Int,
    val difficulty: String,
    val averageRating: Double,
    val price: Double,
    val summary: String,
    val thumbnail: String,
    val images: List<String>,
    val startDates: List<Date>,
    val startLocation: Location,
    val locations: List<Location>,
)


