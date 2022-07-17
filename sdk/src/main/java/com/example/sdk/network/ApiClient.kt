package com.example.sdk.network

import com.example.sdk.data.model.WeatherDataResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiClient {

      @GET("weather/{q}/{id}")
      suspend fun findCityWeatherData(@Query("q") q: String?, @Query("appid") appid: String?): Call<WeatherDataResponse>

}