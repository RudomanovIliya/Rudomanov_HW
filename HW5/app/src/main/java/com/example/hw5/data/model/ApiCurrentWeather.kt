package com.example.hw5.data.model

import com.example.hw5.domain.model.CurrentWeather
import com.example.hw5.domain.model.Weather
import com.squareup.moshi.Json

data class ApiCurrentWeather(
    @Json(name = "weather") val weather: List<ApiWeather>?,
    @Json(name = "main") val mainWeather: ApiMainWeather,
    @Json(name = "visibility") val visibility: Int?,
    @Json(name = "wind") val wind: ApiWind,
    @Json(name = "name") val city: String?,
)

fun ApiCurrentWeather.toModel(): CurrentWeather {
    return CurrentWeather(
        weather = weather?.map { it.toModel() } ?: listOf(),
        mainWeather = mainWeather.toModel(),
        visibility = visibility ?: 0,
        wind = wind.toModel(),
        city = city.orEmpty()
    )
}
