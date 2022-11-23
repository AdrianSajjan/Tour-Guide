package com.tourguide.domain.models

data class Tour(
    val thumbnail: String,
    val images: List<String>,
    val name: String,
    val price: Double,
    val country: String,
    val state: String,
    val currencyDisplay: String,
    val currencyName: String,
    val tourPackage: String,
)