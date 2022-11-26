package com.tourguide.domain.use_case.register

import com.tourguide.core.common.Resource
import com.tourguide.data.dto.RegistrationDto
import com.tourguide.data.dto.toTokens
import com.tourguide.domain.model.Tokens
import com.tourguide.domain.repository.AuthenticationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val repository: AuthenticationRepository
) {
    operator fun invoke(registrationDto: RegistrationDto): Flow<Resource<Tokens>> = flow {
        try {
            emit(Resource.Loading())
            val tokens = repository.register(registrationDto).toTokens()
            emit(Resource.Success(tokens))
        } catch (e : HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred."))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check you internet connection."))
        }
    }
}