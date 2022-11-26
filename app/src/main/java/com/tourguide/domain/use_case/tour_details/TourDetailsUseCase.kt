package com.tourguide.domain.use_case.tour_details

import com.tourguide.core.common.Resource
import com.tourguide.data.dto.toTour
import com.tourguide.domain.model.Tour
import com.tourguide.domain.repository.TourRepository
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class TourDetailsUseCase @Inject constructor(
    private val repository: TourRepository
) {
    operator fun invoke(id: String): Flow<Resource<Tour>> = flow {
        try {
            emit(Resource.Loading())
            val tour = repository.tourDetailsById(id).toTour()
            emit(Resource.Success(tour))
        } catch (e : HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred."))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check you internet connection."))
        }
    }
}