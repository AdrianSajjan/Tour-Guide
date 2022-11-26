package com.tourguide.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.tourguide.domain.use_case.get_tours.GetToursUseCase
import com.tourguide.presentation.home.state.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getToursUseCase: GetToursUseCase
): ViewModel() {
    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state;
}