package com.mohit.machinecoding.data.remote.model

data class Main(
    val dew_point: Double,
    val feels_like: Double,
    val humidity: Int,
    val pressure: Int,
    val temp: Double,
    val temp_max: Double,
    val temp_min: Double
)