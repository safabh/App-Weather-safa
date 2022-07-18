package com.example.myapplicationtest.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.myapplicationtest.R
import kotlinx.android.synthetic.main.activity_weather_details.*


class WeatherDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_details)

        var Intent1: Intent
        Intent1= getIntent()
        //Here first is key and 0 is default value
        namecity.text =  Intent1.getStringExtra("name");
        codeCity.text =  Intent1.getStringExtra("codeCity");
        temp.text     =  Intent1.getStringExtra("temp");
        wind.text     =  Intent1.getStringExtra("wind");
        humidity.text =  Intent1.getStringExtra("humidity");
        temp_max.text =  Intent1.getStringExtra("temp_max");
        temp_min.text =  Intent1.getStringExtra("temp_min");

        Glide.with(this)
            .load("https://openweathermap.org/img/wn/" + Intent1.getStringExtra("icon") + "@2x.png")
            .into(icon)

    }
}