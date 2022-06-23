package com.examplek.task_1
import com.examplek.task_1.Main
import com.google.gson.annotations.SerializedName

data class WeatherApiResponse(
    @SerializedName("main")
    val main: Main
)