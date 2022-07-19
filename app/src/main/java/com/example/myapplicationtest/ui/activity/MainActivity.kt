package com.example.myapplicationtest.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationtest.R
import com.example.myapplicationtest.databinding.ActivityMainBinding
import com.example.myapplicationtest.ui.adapters.CityAdapter
import com.example.myapplicationtest.ui.adapters.CityClickInterface
import com.example.myapplicationtest.viewmodel.CityViewModal
import com.example.myapplicationtest.viewmodel.WeatherViewModel
import com.example.sdk.data.model.CityModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), CityClickInterface {
    //on below line we are creating a variable for our recycler view, exit text, button and viewmodal.
    lateinit var viewModal: CityViewModal
    lateinit var CityList: RecyclerView
    lateinit var AddCity: FloatingActionButton
    private lateinit var binding: ActivityMainBinding
    val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //on below line we are initializing all our variables.
        CityList = findViewById(R.id.CityList)
        AddCity = findViewById(R.id.AddCity)
        //on below line we are setting layout manager to our recycler view.
        CityList.layoutManager = LinearLayoutManager(this)
        //on below line we are initializing our adapter class.
        val cityAdaoter = CityAdapter(this,  this)
        //on below line we are setting adapter to our recycler view.
        CityList.adapter = cityAdaoter
        //on below line we are initializing our view modal.
        viewModal = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(CityViewModal::class.java)
        //on below line we are calling all cities methof from our view modal class to observer the changes on list.
        viewModal.allCities.observe(this, Observer { list -> list?.let {
                //on below line we are updating our list.
            cityAdaoter.updateList(it)
            }
        })
        AddCity.setOnClickListener {
            //adding a click listner for fab button and opening a new intent to add a new city.
            val intent = Intent(this@MainActivity, AddNewCityActivity::class.java)
            startActivity(intent)
        }
    }


    private fun getWeatherCityData(cityTitle: String) {

        viewModel.getWeatherCityData(cityTitle)

        viewModel.response.observe(this, { response ->

            if (response != null) {
                val intent = Intent(this@MainActivity, WeatherDetailsActivity::class.java)
                intent.putExtra("name", response.name)
                intent.putExtra("codeCity", response.sys.country)
                intent.putExtra("temp", (response.main.temp- 273.15).toInt().toString() + "°C")
                intent.putExtra("humidity", response.main.humidity.toString() + "%")
                intent.putExtra("temp_max", (response.main.temp_max - 273.15).toInt().toString()  + "°C")
                intent.putExtra("temp_min", (response.main.temp_min- 273.15).toInt().toString()  + "°C")
                intent.putExtra("wind", response.wind.speed.toString())
                intent.putExtra("icon", response.weather.get(0).icon)
                startActivity(intent)
            }else {
                Toast.makeText(this, "No Data", Toast.LENGTH_LONG).show()
            }
        })

    }
    override fun onCityClick(city: CityModel) {
        getWeatherCityData(city.cityTitle)
    }

    override fun onBackPressed() {
        moveTaskToBack(true)
    }


}