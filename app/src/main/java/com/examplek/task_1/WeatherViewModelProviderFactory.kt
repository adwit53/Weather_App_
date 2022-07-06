package com.examplek.task_1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.examplek.task_1.Repository.WeatherRepository

class WeatherViewModelProviderFactory (
    private val weatherRepository: WeatherRepository
        ):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return WeatherViewModel(weatherRepository) as T
    }

}