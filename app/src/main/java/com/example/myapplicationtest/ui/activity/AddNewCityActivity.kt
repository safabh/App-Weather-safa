package com.example.myapplicationtest.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.myapplicationtest.R
import com.example.sdk.data.model.CityModel
import com.example.sdk.data.viewmodel.CityViewModal
import java.text.SimpleDateFormat
import java.util.*


class AddNewCityActivity : AppCompatActivity() {
    //on below line we are creating variables for our UI components.
    lateinit var CityName: EditText
    lateinit var BtnCity: Button

    //on below line we are creating variable for viewmodal and and integer for our city id.
    lateinit var viewModalCity: CityViewModal
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_city)
        //on below line we are initlaiing our view modal.
        viewModalCity = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(CityViewModal::class.java)
        //on below line we are initializing all our variables.
        CityName = findViewById(R.id.CityName)
        BtnCity = findViewById(R.id.BtnCity)

        //on below line we are adding click listner to our save button.
        BtnCity.setOnClickListener {
            //on below line we are getting title and desc from edit text.
            val cityName = CityName.text.toString()
            if (cityName.isNotEmpty()) {
                val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
                val currentDateAndTime: String = sdf.format(Date())
                //if the string is not empty we are calling a add city method to add data to our room database.
                viewModalCity.addcity(CityModel(cityName,currentDateAndTime))
                Toast.makeText(this, "$cityName à été ajouter avec succés", Toast.LENGTH_LONG).show()
            }
            startActivity(Intent(applicationContext, MainActivity::class.java))
            this.finish()
        }
        //opening the new activity on below line

    }
}
