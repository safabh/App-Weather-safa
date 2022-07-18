package com.example.sdk.data.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import com.example.sdk.data.model.WeatherModel
import com.example.sdk.data.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val repository: WeatherRepository) : ViewModel(), LifecycleObserver {

    private val _response: MutableLiveData<WeatherModel> = MutableLiveData()
    val response: LiveData<WeatherModel> get()  = _response

    fun getWeatherCityData(cityTitle: String) {
        getWeatherCity(cityTitle)
    }

    private fun getWeatherCity(cityTitle: String) = viewModelScope.launch {

        repository.getCityWeather(cityTitle).let { response ->

            if (response.isSuccessful) {
                _response.postValue(response.body())
            }else{

            }

        }

    }
}


