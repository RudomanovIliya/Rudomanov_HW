package com.example.hw5.data.model

import com.example.hw5.domain.model.MainWeather
import com.squareup.moshi.Json

data class ApiMainWeather(
    @Json(name = "temp") val temperature: Float?,
    @Json(name = "feels_like") val feelsLike: Float?,
    @Json(name = "temp_min") val tempMin: Float?,
    @Json(name = "temp_max") val tempMax: Float?,
    @Json(name = "pressure") val pressure: Int?,
    @Json(name = "humidity") val humidity: Int?,
)

fun ApiMainWeather.toModel(): MainWeather {
    return MainWeather(
        temperature = temperature ?: 0f,
        feelsLike = feelsLike ?: 0f,
        tempMin = tempMin ?: 0f,
        tempMax = tempMax ?: 0f,
        pressure = pressure ?: 0,
        humidity = humidity ?: 0
    )
}