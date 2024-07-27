package com.example.hw5.data.repository

import com.example.hw5.data.api.ApiWeather
import com.example.hw5.data.model.toModel
import com.example.hw5.domain.model.CurrentWeather
import com.example.hw5.domain.repository.WeatherRepository

class WeatherRepositoryImpl(
    private val apiWeather: ApiWeather,
) : WeatherRepository {
    override suspend fun getWeather(): CurrentWeather {
        return apiWeather.getWeather().toModel()
    }
}