package com.example.sdk.network

import com.example.sdk.data.constants.AppConstants.CLIENT_ID
import com.example.sdk.data.constants.AppConstants.END_POINT
import com.example.sdk.data.model.WeatherModel
import retrofit2.Response
import retrofit2.http.*


interface ApiClient {
    @GET(END_POINT)
    suspend fun findCityWeatherData(
        @Query("q") q: String, @Query("appid") appid: String = CLIENT_ID): Response<WeatherModel>
}