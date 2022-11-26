package com.tourguide.data.api

import com.tourguide.data.dto.TokensDto
import com.tourguide.data.dto.LoginDto
import com.tourguide.data.dto.RegistrationDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthenticationApi {
    @POST("/user/login")
    suspend fun login(@Body loginDto: LoginDto): TokensDto

    @POST("/user/register")
    suspend fun register(@Body registrationDto: RegistrationDto): TokensDto
}