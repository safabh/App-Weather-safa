package com.example.sdk.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.sdk.data.model.CityModel

@Dao
interface CityDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(city :CityModel)

    @Query("Select * from cityTable order by id ASC")
    fun getAllCities(): LiveData<List<CityModel>>


}