package com.mohit.machinecoding.data.remote.model

data class WeatherResponseItem(
    val city_name: String,
    val clouds: Clouds,
    val dt: Int,
    val dt_iso: String,
    val lat: Double,
    val lon: Double,
    val main: Main,
    val rain: Rain,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)