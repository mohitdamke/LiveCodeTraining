package com.mohit.machinecoding.data.remote

import com.mohit.machinecoding.data.remote.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("data/2.5/weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String = "ff7b1f6d7d8e0af8e0d194c4e32a6d40"
    ): WeatherResponse
}

// What are else @ annotation
// Why the fuck we are calling it in interface why can't directly in repository