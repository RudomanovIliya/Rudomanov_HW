package com.example.hw5.di

import com.example.hw5.data.api.ApiWeather
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

private const val READ_TIMEOUT_IN_SECONDS = 10L
private const val CONNECTION_TIMEOUT_IN_SECONDS = 10L
private const val DEV_BASE_URL = "https://api.openweathermap.org/data/2.5/"

val networkModule = module {
    single { provideMoshi() }
    single { provideOkHttpClient() }
    single { provideRetrofit(get(), get()) }
    single { provideApi(get()) }
}

fun provideMoshi(): Moshi {
    return Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .readTimeout(READ_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
        .connectTimeout(CONNECTION_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
        .build()
}

fun provideRetrofit(
    okHttpClient: OkHttpClient,
    moshi: Moshi
): Retrofit {
    return Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(DEV_BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
}

fun provideApi(
    retrofit: Retrofit
): ApiWeather {
    return retrofit.create(ApiWeather::class.java)
}

//val moshiBuilder = Moshi.Builder()
//    .addLast(KotlinJsonAdapterFactory())
//    .build()

//val okHttpClient = OkHttpClient.Builder()
//    .readTimeout(READ_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
//    .connectTimeout(CONNECTION_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
//    .build()
//
//val retrofit = Retrofit.Builder()
//    .client(okHttpClient)
//    .baseUrl(DEV_BASE_URL)
//    .addConverterFactory(MoshiConverterFactory.create(moshiBuilder))
//    .build()
//retrofit.create(ApiWeather::class.java).getWeather()