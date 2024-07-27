package com.example.hw5.domain.repository

import com.example.hw5.domain.model.CurrentWeather

interface WeatherRepository {
    suspend fun getWeather(): CurrentWeather
}