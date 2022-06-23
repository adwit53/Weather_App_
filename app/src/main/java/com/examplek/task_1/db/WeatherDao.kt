package com.examplek.task_1.db
import androidx.lifecycle.LiveData
import androidx.room.*
import com.examplek.task_1.SavingDataType

@Dao
interface WeatherDao {
    @Insert(onConflict=OnConflictStrategy.REPLACE)
    suspend fun upsert(savingDataType: SavingDataType):Long

    @Query("SELECT * FROM SavingDataTypes ORDER BY cityOfUser ASC")
    fun getAllDetails():LiveData<List<SavingDataType>>

    @Delete
    suspend fun deleteDetails(savingDataType: SavingDataType)
}