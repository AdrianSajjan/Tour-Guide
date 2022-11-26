package com.tourguide.domain.repository

import com.tourguide.data.dto.TourDto

interface TourRepository {
    suspend fun listOfTours(): List<TourDto>
    suspend fun listOfBudgetTours(): List<TourDto>
    suspend fun tourDetailsById(id: String): TourDto
}