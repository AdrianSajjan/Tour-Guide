package com.tourguide.domain.models

import java.util.Date

data class ProdTour (
    val id: String,
    val slug: String,
    val name: String,
    val duration: Int,
    val maxGroupSize: Int,
    val difficulty: String,
    val averageRating: Double,
    val price: Double,
    val summary: String,
    val description: String,
    val thumbnail: String,
    val images: List<String>,
    val createdAt: Date,
    val startDates: List<Date>,
    val startLocation: Location,
    val locations: List<Location>,
)


data class Tour(
    val thumbnail: String,
    val images: List<String>,
    val name: String,
    val price: Double,
    val country: String,
    val state: String,
    val description: String,
    val currencyDisplay: String,
    val currencyName: String,
    val tourPackage: String,
)