package com.examplek.task_1.Api

import com.examplek.task_1.WeatherApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
   suspend fun getWeatherData(
        @Query("q")
        city: String,
        @Query("appid")
        apikey:String):Response<WeatherApiResponse>
}