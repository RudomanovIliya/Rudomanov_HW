package com.example.hw4.data.api

import com.example.hw4.data.model.CurrentWeather
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiWeather {
    @GET("weather?lat=51.56&lon=46.07&units=metric&appid=815442375fe68fce287f2db54f4872c3")
    suspend fun getWeather(): CurrentWeather
}
        //lat=51.56&lon=46.07