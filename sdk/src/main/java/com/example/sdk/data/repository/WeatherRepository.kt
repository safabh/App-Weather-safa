package com.example.sdk.data.repository

import com.example.sdk.data.constants.AppConstants
import com.example.sdk.data.model.WeatherModel
import com.example.sdk.network.ApiClient
import javax.inject.Inject

class WeatherRepository
@Inject
constructor(private val api: ApiClient) {

    suspend fun getCityWeather(cityname:String ) = api.findCityWeatherData(cityname)

}