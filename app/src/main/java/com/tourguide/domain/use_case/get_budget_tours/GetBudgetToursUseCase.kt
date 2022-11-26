package com.tourguide.domain.use_case.get_budget_tours

import com.tourguide.core.common.Resource
import com.tourguide.data.dto.toTour
import com.tourguide.domain.model.Tour
import com.tourguide.domain.repository.TourRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetBudgetToursUseCase @Inject constructor(
    private val repository: TourRepository
) {
    operator fun invoke(): Flow<Resource<List<Tour>>> = flow {
        try {
            emit(Resource.Loading())
            val tours = repository.listOfBudgetTours().map { it.toTour() }
            emit(Resource.Success(tours))
        } catch (e : HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred."))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check you internet connection."))
        }
    }
}
