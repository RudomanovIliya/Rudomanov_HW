package com.example.hw5.di


import com.example.hw5.data.repository.WeatherRepositoryImpl
import com.example.hw5.domain.repository.WeatherRepository
import org.koin.dsl.module

val dataModule = module {

    single<WeatherRepository> {
        WeatherRepositoryImpl(apiWeather = get())
    }

}

