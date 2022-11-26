package com.tourguide.data.api

import com.tourguide.data.dto.TourDto
import retrofit2.http.GET
import retrofit2.http.Path

interface TourApi {
    @GET("/tour/")
    suspend fun listOfTours(): List<TourDto>

    @GET("/tour/{id}")
    suspend fun tourDetailsById(@Path("id") id:String): TourDto
}