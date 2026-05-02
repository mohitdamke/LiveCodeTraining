package com.mohit.machinecoding.data.repository

import com.mohit.machinecoding.data.remote.WeatherApi
import com.mohit.machinecoding.data.remote.model.WeatherResponse

class WeatherRepository(private val api : WeatherApi) {

    suspend fun getWeather(city: String): WeatherResponse{

        return api.getWeather(city)

    }

}