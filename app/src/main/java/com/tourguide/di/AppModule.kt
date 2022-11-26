package com.tourguide.di

import com.tourguide.core.common.Constants
import com.tourguide.data.api.AuthenticationApi
import com.tourguide.data.repository.AuthenticationRepositoryImpl
import com.tourguide.domain.repository.AuthenticationRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideAuthenticationApi(): AuthenticationApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create((AuthenticationApi::class.java))
    }


    @Provides
    @Singleton
    fun provideAuthenticationRepository(api: AuthenticationApi): AuthenticationRepository {
        return AuthenticationRepositoryImpl(api);
    }
}
