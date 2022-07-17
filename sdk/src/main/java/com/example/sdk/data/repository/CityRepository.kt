package com.example.sdk.data.repository

import androidx.lifecycle.LiveData
import com.example.sdk.data.dao.CityDao
import com.example.sdk.data.model.CityModel
import com.example.sdk.network.ApiClient

class CityRepository(private val cityDao: CityDao) {

    private var apiclient:ApiClient?=null

    val allCities: LiveData<List<CityModel>> = cityDao.getAllCities()

    suspend fun insert(city: CityModel) {
        cityDao.insert(city)
    }

   //suspend fun findCityWeather(cityName: String): WeatherDataResponse = apiRequest {
     //   apiclient.findCityWeatherData(cityName)
  //  }


}