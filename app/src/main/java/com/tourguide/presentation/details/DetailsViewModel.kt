package com.tourguide.presentation.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tourguide.core.common.Constants
import com.tourguide.core.common.Resource
import com.tourguide.domain.use_case.tour_details.TourDetailsUseCase
import com.tourguide.presentation.details.state.TourDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val tourDetailsUseCase: TourDetailsUseCase,
    savedStateHandle: SavedStateHandle,
): ViewModel() {

    private val _state = mutableStateOf(TourDetailsState())
    val state: State<TourDetailsState> = _state;

    init {
        savedStateHandle.get<String>(Constants.ParamTourId)?.let { id -> 
            getTourDetailsById(id)
        }
    }

    private fun getTourDetailsById(id: String) {
        tourDetailsUseCase(id).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = TourDetailsState(tour = result.data ?: null, isLoading = false)
                }
                is Resource.Error -> {
                    _state.value = TourDetailsState(error = result.message ?: "An unexpected error occurred", isLoading = false)
                }
                is Resource.Loading -> {
                    _state.value = TourDetailsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}