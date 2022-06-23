package com.examplek.task_1.Repository

import com.examplek.task_1.SavingDataType
import com.examplek.task_1.db.WeatherDatabase

class WeatherRepository(
    val db:WeatherDatabase,
//    private val weatherDao: weather_Dao
) {
//    val readalldata:LiveData<List<SavingDataType>> = weatherDao.getAllDetails()
//    suspend fun addUser(savingDataType: SavingDataType)
//    {
//        weatherDao.upsert(savingDataType)
//    }
    suspend fun upsert(savingDataType: SavingDataType)=db.getWeatherDao().upsert(savingDataType)
    fun getSavedWeather()=db.getWeatherDao().getAllDetails()
    suspend fun deleteDetail(savingDataType: SavingDataType)=db.getWeatherDao().deleteDetails(savingDataType)
}