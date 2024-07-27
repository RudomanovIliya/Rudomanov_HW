package com.example.hw5.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw5.domain.model.CurrentWeather
import com.example.hw5.domain.model.LoadState
import com.example.hw5.domain.repository.WeatherRepository
import kotlinx.coroutines.launch

class MainActivityViewModel(
    private val repository: WeatherRepository
) : ViewModel() {

    private val _weatherLiveData = MutableLiveData<LoadState<CurrentWeather>>()
    val weatherLiveData: LiveData<LoadState<CurrentWeather>> = _weatherLiveData

    fun loadWeather() {
        viewModelScope.launch {
            _weatherLiveData.postValue(LoadState.Loading())
            try {
                val weather = repository.getWeather()
                _weatherLiveData.postValue(LoadState.Data(weather))
            } catch (e: Exception) {
                _weatherLiveData.postValue(LoadState.Error(e))
            }
        }
    }
}