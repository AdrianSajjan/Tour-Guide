package com.tourguide.data.dto

import com.tourguide.domain.model.Location
import com.tourguide.domain.model.Tour
import com.tourguide.domain.model.User
import java.util.*

data class TourDto(
    val difficulty: String,
    val duration: Int,
    val durationWeeks: Double,
    val guides: List<User>,
    val id: String,
    val imageCover: String,
    val images: List<String>,
    val locations: List<Location>,
    val maxGroupSize: Int,
    val description: String,
    val name: String,
    val price: Double,
    val rating: Double,
    val ratingsAverage: Double,
    val ratingsQuantity: Int,
    val secretTour: Boolean,
    val slug: String,
    val startDates: List<Date>,
    val startLocation: Location,
    val summary: String,
)

fun TourDto.toTour(): Tour {
    return Tour(
         id = id,
         slug = slug,
         name = name,
         duration = duration,
         maxGroupSize = maxGroupSize,
         difficulty = difficulty,
         averageRating = ratingsAverage,
         price = price,
         summary = summary,
         description = description,
         thumbnail = imageCover,
         images = images,
         startDates = startDates,
         startLocation = startLocation,
         locations = locations,
         guides = guides,
    )
}