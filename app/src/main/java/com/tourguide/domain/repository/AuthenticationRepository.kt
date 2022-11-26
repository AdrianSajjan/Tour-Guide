package com.tourguide.domain.repository

import com.tourguide.data.dto.TokensDto
import com.tourguide.data.dto.LoginDto
import com.tourguide.data.dto.RegistrationDto

interface AuthenticationRepository {
    suspend fun login(loginDto: LoginDto): TokensDto
    suspend fun register(registrationDto: RegistrationDto): TokensDto
}