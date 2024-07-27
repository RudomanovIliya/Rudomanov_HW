package com.example.hw5.domain.model

data class CurrentWeather(
    val weather: List<Weather>,
    val mainWeather: MainWeather,
    val visibility: Int,
    val wind: Wind,
    val city: String,
)