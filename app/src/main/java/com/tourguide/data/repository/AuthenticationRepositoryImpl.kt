package com.tourguide.data.repository

import com.tourguide.data.api.AuthenticationApi
import com.tourguide.data.dto.TokensDto
import com.tourguide.data.dto.LoginDto
import com.tourguide.data.dto.RegistrationDto
import com.tourguide.domain.repository.AuthenticationRepository
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(
    private val api: AuthenticationApi
) : AuthenticationRepository {
    override suspend fun login(loginDto: LoginDto): TokensDto {
        return api.login(loginDto)
    }

    override suspend fun register(registrationDto: RegistrationDto): TokensDto {
        return api.register(registrationDto)
    }
}