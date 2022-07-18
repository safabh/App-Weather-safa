package com.example.sdk.data.repository

import androidx.lifecycle.LiveData
import com.example.sdk.data.dao.CityDao
import com.example.sdk.data.model.CityModel

class CityRepository(private val cityDao: CityDao) {
    val allCities: LiveData<List<CityModel>> = cityDao.getAllCities()

    suspend fun insert(city: CityModel) {
        cityDao.insert(city)
    }
}