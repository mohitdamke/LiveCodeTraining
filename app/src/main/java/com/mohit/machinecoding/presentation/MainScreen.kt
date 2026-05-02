package com.mohit.machinecoding.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.mohit.machinecoding.data.remote.model.WeatherResponse
import com.mohit.machinecoding.data.state.WeatherUiState
import com.mohit.machinecoding.viewmodel.WeatherViewmodel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    weatherViewmodel: WeatherViewmodel = hiltViewModel()
) {

    val state = weatherViewmodel.state.collectAsState()

    var city by rememberSaveable { mutableStateOf("") }

    Column(modifier = modifier
        .fillMaxSize()
        .padding(10.dp)) {

        Spacer(modifier= Modifier.height(10.dp))

        OutlinedTextField(
            value = city,
            onValueChange = { city = it },
            label = { Text(text = "Enter a City") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
        )

        Button(onClick = {
            if (city.isNotEmpty()){
                weatherViewmodel.getWeather(city)
            }

        },modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)) {
            Text(text = "Submit")
        }

        Spacer(modifier= Modifier.height(10.dp))

        when (val result = state.value){
            is WeatherUiState.Loading -> {
                CircularProgressIndicator()
            }
            is WeatherUiState.Success -> {
                WeatherContent(result.data)
            }
            is WeatherUiState.Error -> {
                Text(text = "Error ${result.message}")
            }
            else -> {
                Text(text = "No Search Result")
            }
        }









    }

}


@SuppressLint("NewApi")
@Composable
fun WeatherContent(data : WeatherResponse) {

    val result = data.firstOrNull()

    if(result == null){
        Text(text = "No Data")
        return
    }
val weather = result.weather.firstOrNull()

    val rain = result.rain
    Text(text = result.city_name)
    Text(text = weather?.main ?: "Main N/A")
    Text(text = rain.`3h`.toString() ?: "00")
}









// Why impl viewmodel in constructor vs in file
// What is this onValueChange = {city = it}