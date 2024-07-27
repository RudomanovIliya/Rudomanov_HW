package com.example.hw5.data.model

import com.example.hw5.domain.model.Weather
import com.squareup.moshi.Json

data class ApiWeather(
    @Json(name = "description") val description: String?,
)

fun ApiWeather.toModel(): Weather {
    return Weather(
        description = description.orEmpty()
    )
}
