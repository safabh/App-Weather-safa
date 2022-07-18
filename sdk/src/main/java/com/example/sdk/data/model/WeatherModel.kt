package com.example.sdk.data.model

data class WeatherModel(
    val id: Int,
    val main: Main,
    val name: String,
    val weather: List<Weather>,
    val wind: Wind,
    val sys: Sys,
    ) {

}