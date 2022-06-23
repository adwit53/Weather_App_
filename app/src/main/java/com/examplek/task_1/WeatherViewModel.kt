package com.examplek.task_1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.examplek.task_1.Repository.WeatherRepository
import kotlinx.coroutines.launch

class WeatherViewModel(
    val weatherRepository: WeatherRepository
):ViewModel() {
    fun saveWeatherdetails(savingDataType: SavingDataType)=viewModelScope.launch {
        weatherRepository.upsert(savingDataType)
    }
    fun getSavedDetails()=weatherRepository.getSavedWeather()
    fun deleteWeatherDetails(savingDataType: SavingDataType)=viewModelScope.launch {
        weatherRepository.deleteDetail(savingDataType)
    }
}