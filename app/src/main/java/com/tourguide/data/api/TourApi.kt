package com.tourguide.data.api

import com.tourguide.data.dto.TourDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TourApi {
    @GET("/api/v1/tour")
    suspend fun listOfTours(@Query("limit") limit: Int? = 5): List<TourDto>

    @GET("/api/v1/tour/{id}")
    suspend fun tourDetailsById(@Path("id") id:String): TourDto

    @GET("/api/v1/tour/top-5-cheap")
    suspend fun listOfBudgetTours(): List<TourDto>
}