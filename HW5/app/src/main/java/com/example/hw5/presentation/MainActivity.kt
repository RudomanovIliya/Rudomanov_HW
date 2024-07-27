package com.example.hw5.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ViewFlipper
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.hw5.databinding.ActivityMainBinding
import com.example.hw5.domain.model.LoadState
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    companion object {
        private const val LOADING_SCREEN = 0
        private const val SUCCESS_SCREEN = 1
        private const val ERROR_SCREEN = 2
    }

    private val binding by lazy { ActivityMainBinding.inflate(LayoutInflater.from(this)) }
    private val viewModel: MainActivityViewModel by viewModel<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val viewFlipper = binding.viewFlipper

        if (savedInstanceState == null) {
            viewModel.loadWeather()
        }
        observerWeather(viewFlipper)
        binding.buttonRepeat.setOnClickListener {
            viewModel.loadWeather()
            observerWeather(viewFlipper)
        }
    }

    private fun observerWeather(viewFlipper: ViewFlipper) {
        viewModel.weatherLiveData.observe(this) { state ->
            when (state) {
                is LoadState.Data -> {
                    viewFlipper.displayedChild = SUCCESS_SCREEN
                    binding.textViewCity.text = state.data.city
                    val stringBuilderTemp = StringBuilder()
                    stringBuilderTemp.append(state.data.mainWeather.temperature.toString()).append(
                        "\u2103\n" +
                                "Feels like "
                    ).append(state.data.mainWeather.feelsLike.toString()).append("\u2103, ")
                        .append(state.data.weather[0].description).append(".")
                    binding.textViewTemp.text = stringBuilderTemp
                    val stringBuilderMinMax = StringBuilder()
                    stringBuilderMinMax.append("min: ")
                        .append(state.data.mainWeather.tempMin.toString())
                        .append("\u2103, max: ").append(state.data.mainWeather.tempMax.toString())
                        .append("\u2103\npressure: ")
                        .append(state.data.mainWeather.pressure.toString())
                        .append(" hPa\nhumidity: ")
                        .append(state.data.mainWeather.humidity).append("%\nvisibility: ")
                        .append(state.data.visibility.toString()).append(" km\"")
                    binding.textViewMinMax.text = stringBuilderMinMax
                    binding.textViewWindGust.text =
                        "wind speed: ${state.data.wind.speed} m/s\ngust: ${state.data.wind.gust} m/s\ndirection: ${state.data.wind.degree}"
                }

                is LoadState.Error -> {
                    viewFlipper.displayedChild = ERROR_SCREEN
                    binding.textViewError.text = state.exception.message
                }

                is LoadState.Loading -> {
                    viewFlipper.displayedChild = LOADING_SCREEN
                }
            }
        }
    }
}