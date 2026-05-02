package com.mohit.machinecoding.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohit.machinecoding.data.repository.WeatherRepository
import com.mohit.machinecoding.data.state.WeatherUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewmodel @Inject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

    private val _state = MutableStateFlow<WeatherUiState>(WeatherUiState.Loading)
    val state: StateFlow<WeatherUiState> = _state

    fun getWeather(city: String) {

        viewModelScope.launch {
            _state.value = WeatherUiState.Loading
            try {
                val result = repository.getWeather(city)
                _state.value = WeatherUiState.Success(result)
            } catch (e: Exception) {
                _state.value = WeatherUiState.Error(e.message ?: "Something Went Wrong")
            }
        }
    }
}

// Why Inject
// Why state flow not shared flow hot/cold