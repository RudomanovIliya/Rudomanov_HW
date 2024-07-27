package com.example.hw5.data.model

import com.example.hw5.domain.model.Wind
import com.squareup.moshi.Json

data class ApiWind(
    @Json(name = "speed") val speed: Float?,
    @Json(name = "deg") val degree: Int?,
    @Json(name = "gust") val gust: Float?,
)

fun ApiWind.toModel(): Wind {
    return Wind(
        speed = speed ?: 0f,
        degree = degree ?: 0,
        gust = gust ?: 0f
    )
}
