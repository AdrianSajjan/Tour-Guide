package com.tourguide.data.repository

import com.tourguide.data.api.TourApi
import com.tourguide.data.dto.TourDto
import com.tourguide.domain.repository.TourRepository
import javax.inject.Inject

class TourRepositoryImpl @Inject constructor(
    private val api: TourApi
): TourRepository {
    override suspend fun listOfTours(): List<TourDto> {
        return api.listOfTours()
    }

    override suspend fun listOfBudgetTours(): List<TourDto> {
        return api.listOfBudgetTours()
    }

    override suspend fun tourDetailsById(id: String): TourDto {
        return api.tourDetailsById(id)
    }
}