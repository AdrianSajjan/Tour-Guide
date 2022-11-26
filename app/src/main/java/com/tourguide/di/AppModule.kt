package com.tourguide.di

import com.tourguide.core.common.Constants
import com.tourguide.data.api.AuthenticationApi
import com.tourguide.data.api.TourApi
import com.tourguide.data.repository.AuthenticationRepositoryImpl
import com.tourguide.data.repository.TourRepositoryImpl
import com.tourguide.domain.repository.AuthenticationRepository
import com.tourguide.domain.repository.TourRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private val httpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    private val okHttpClient = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BaseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient.build())
        .build()

    @Provides
    @Singleton
    fun provideAuthenticationApi(): AuthenticationApi {
        return retrofit.create((AuthenticationApi::class.java))
    }

    @Provides
    @Singleton
    fun provideTourApi(): TourApi {
        return retrofit.create((TourApi::class.java))
    }

    @Provides
    @Singleton
    fun provideAuthenticationRepository(api: AuthenticationApi): AuthenticationRepository {
        return AuthenticationRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideTourRepository(api: TourApi): TourRepository {
        return TourRepositoryImpl(api)
    }
}
