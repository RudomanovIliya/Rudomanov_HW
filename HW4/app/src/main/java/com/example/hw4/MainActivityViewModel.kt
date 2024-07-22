package com.example.hw4

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw4.data.api.ApiWeather
import com.example.hw4.data.model.CurrentWeather
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

private const val READ_TIMEOUT_IN_SECONDS = 10L
private const val CONNECTION_TIMEOUT_IN_SECONDS = 10L
private const val DEV_BASE_URL = "https://api.openweathermap.org/data/2.5/"

class MainActivityViewModel() : ViewModel() {

    private val _weatherLiveData = MutableLiveData<LoadState<CurrentWeather>>()
    val weatherLiveData: LiveData<LoadState<CurrentWeather>> = _weatherLiveData

    val moshiBuilder = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    val okHttpClient = OkHttpClient.Builder()
        .readTimeout(READ_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
        .connectTimeout(CONNECTION_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
        .build()

    val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(DEV_BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshiBuilder))
        .build()

    fun loadWeather() {
        viewModelScope.launch {
            _weatherLiveData.postValue(LoadState.Loading())
            try {
                val weather = retrofit.create(ApiWeather::class.java).getWeather()
                _weatherLiveData.postValue(LoadState.Data(weather))
            } catch (e: Exception) {
                _weatherLiveData.postValue(LoadState.Error(e))
            }
        }
    }
}