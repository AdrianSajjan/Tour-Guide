package com.tourguide.domain.use_case.login


import com.tourguide.core.common.Resource
import com.tourguide.data.dto.LoginDto
import com.tourguide.data.dto.toTokens
import com.tourguide.domain.model.Tokens
import com.tourguide.domain.repository.AuthenticationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthenticationRepository
) {
    operator fun invoke(loginDto: LoginDto): Flow<Resource<Tokens>> = flow {
        try {
            emit(Resource.Loading())
            val tokens = repository.login(loginDto).toTokens()
            emit(Resource.Success(tokens))
        } catch (e : HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred."))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check you internet connection."))
        }
    }
}