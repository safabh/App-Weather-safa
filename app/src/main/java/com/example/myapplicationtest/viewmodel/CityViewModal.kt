package com.example.myapplicationtest.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.sdk.data.dao.CityDataBase
import com.example.sdk.data.model.CityModel
import com.example.sdk.data.repository.CityRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CityViewModal(application: Application) : AndroidViewModel(application) {
    val allCities: LiveData<List<CityModel>>
    val repository: CityRepository

    init {
        val dao = CityDataBase.getDatabase(application).getCitysDao()
        repository = CityRepository(dao)
        allCities = repository.allCities
    }

    fun addcity(city: CityModel) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(city)
    }
}