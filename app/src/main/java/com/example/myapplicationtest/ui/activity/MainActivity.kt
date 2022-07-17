package com.example.myapplicationtest.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationtest.R
import com.example.myapplicationtest.ui.adapters.CityAdapter
import com.example.myapplicationtest.ui.adapters.CityClickInterface
import com.example.sdk.data.model.CityModel
import com.example.sdk.data.viewmodel.CityViewModal
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), CityClickInterface {
    //on below line we are creating a variable for our recycler view, exit text, button and viewmodal.
    lateinit var viewModal: CityViewModal
    lateinit var CityList: RecyclerView
    lateinit var AddCity: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
        viewModal = ViewModelProvider(
            this,
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
            this.finish()
        }
    }

    override fun onCityClick(city: CityModel) {
        Toast.makeText(this, "hello i am here ", Toast.LENGTH_LONG).show()

//        //opening a new intent and passing a data to it.
//        val intent = Intent(this@MainActivity, AddNewCityActivity::class.java)
//        startActivity(intent)
//        this.finish()
    }


}