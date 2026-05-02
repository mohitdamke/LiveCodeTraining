package com.mohit.machinecoding.data.state

import com.mohit.machinecoding.data.remote.model.WeatherResponse

sealed class WeatherUiState {
    object Loading : WeatherUiState()
    data class Success(val data: WeatherResponse) : WeatherUiState()
    data class Error(val message: String) : WeatherUiState()
}

// Why object for loading
// Why data class for Success, error
// Why sealed class not normal class