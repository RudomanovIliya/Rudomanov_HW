package com.example.hw5.data.api

import com.example.hw5.data.model.ApiCurrentWeather
import retrofit2.http.GET


interface ApiWeather {
    @GET("weather?lat=51.56&lon=46.07&units=metric&appid=815442375fe68fce287f2db54f4872c3")
    suspend fun getWeather(): ApiCurrentWeather
}
