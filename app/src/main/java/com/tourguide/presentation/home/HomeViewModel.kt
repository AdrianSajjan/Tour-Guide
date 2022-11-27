package com.tourguide.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tourguide.core.common.Resource
import com.tourguide.domain.use_case.get_budget_tours.GetBudgetToursUseCase
import com.tourguide.domain.use_case.get_tours.GetToursUseCase
import com.tourguide.presentation.home.state.TourListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getToursUseCase: GetToursUseCase,
    private val getBudgetToursUseCase: GetBudgetToursUseCase
): ViewModel() {

    private val _popularTourState = mutableStateOf(TourListState())
    private val _budgetTourState = mutableStateOf(TourListState())

    val popularTourState: State<TourListState> = _popularTourState;
    val budgetTourState: State<TourListState> = _budgetTourState;

    init {
        getPopularTours()
        getBudgetTours()
    }

    private fun getPopularTours() {
        getToursUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _popularTourState.value = TourListState(tours = result.data ?: emptyList(), isLoading = false)
                }
                is Resource.Error -> {
                    _popularTourState.value = TourListState(error = result.message ?: "An unexpected error occurred", isLoading = false)
                }
                is Resource.Loading -> {
                    _popularTourState.value = TourListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getBudgetTours() {
        getBudgetToursUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _budgetTourState.value = TourListState(tours = result.data ?: emptyList(), isLoading = false)
                }
                is Resource.Error -> {
                    _budgetTourState.value = TourListState(error = result.message ?: "An unexpected error occurred", isLoading = false)
                }
                is Resource.Loading -> {
                    _budgetTourState.value = TourListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}