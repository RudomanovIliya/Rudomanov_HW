package com.example.hw4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.hw4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(LayoutInflater.from(this)) }
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            viewModel.loadWeather()
        }
        observerWeather()
        binding.buttonRepeat.setOnClickListener {
            viewModel.loadWeather()
            observerWeather()
        }
    }

    private fun observerWeather() {
        viewModel.weatherLiveData.observe(this) { state ->
            when (state) {
                is LoadState.Data -> {
                    binding.progressBar.isVisible = false
                    binding.buttonRepeat.isVisible = false
                    binding.textViewError.visibility = View.INVISIBLE
                    binding.textViewCity.text = state.data.name
                    val stringBuilderTemp = StringBuilder()
                    stringBuilderTemp.append(state.data.main.temp.toString()).append(
                        "\u2103\n" +
                                "Feels like "
                    ).append(state.data.main.feels_like.toString()).append("\u2103, ")
                        .append(state.data.weather[0].description).append(".")
                    binding.textViewTemp.text = stringBuilderTemp
                    val stringBuilderMinMax = StringBuilder()
                    stringBuilderMinMax.append("min: ")
                        .append(state.data.main.temp_min.toString())
                        .append("\u2103, max: ").append(state.data.main.temp_max.toString())
                        .append("\u2103\npressure: ")
                        .append(state.data.main.pressure.toString()).append(" hPa\nhumidity: ")
                        .append(state.data.main.humidity).append("%\nvisibility: ")
                        .append(state.data.visibility.toString()).append(" km\"")
                    binding.textViewMinMax.text = stringBuilderMinMax
                    binding.textViewWindGust.text =
                        "wind speed: ${state.data.wind.speed} m/s\ngust: ${state.data.wind.gust} m/s\ndirection: ${state.data.wind.deg}"
                }

                is LoadState.Error -> {
                    binding.progressBar.isVisible = false
                    binding.buttonRepeat.isVisible = true
                    binding.textViewError.visibility = View.VISIBLE
                    binding.textViewError.text = state.exception.message
                }

                is LoadState.Loading -> {
                    binding.progressBar.isVisible = true
                    binding.buttonRepeat.isVisible = false
                    binding.textViewError.visibility = View.INVISIBLE
                }
            }
        }
    }
}