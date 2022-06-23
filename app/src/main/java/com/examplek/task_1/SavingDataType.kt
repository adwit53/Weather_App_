package com.examplek.task_1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "SavingDataTypes"
)
data class SavingDataType(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val nameOfUser:String,
    val cityOfUser:String,
    val countryOfUser:String

)
