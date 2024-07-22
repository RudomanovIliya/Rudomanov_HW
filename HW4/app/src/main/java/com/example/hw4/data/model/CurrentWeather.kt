package com.example.hw4.data.model

data class CurrentWeather(
    val weather: List<Weather>,
    val main: MainWeather,
    val visibility: Int,
    val wind: Wind,
    val name: String,
)
