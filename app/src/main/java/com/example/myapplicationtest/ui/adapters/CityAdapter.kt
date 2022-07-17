package com.example.myapplicationtest.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationtest.R
import com.example.sdk.data.model.CityModel

class CityAdapter(
    val context: Context,
    val cityClickInterface: CityClickInterface
) :
    RecyclerView.Adapter<CityAdapter.ViewHolder>() {

    //on below line we are creating a variable for our all cities list.
    private val allcities = ArrayList<CityModel>()

    //on below line we are creating a view holder class.
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //on below line we are creating an initializing all our variables which we have added in layout file.
        val city = itemView.findViewById<TextView>(R.id.idCity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //inflating our layout file for each item of recycler view.
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.city_item,
            parent, false
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //on below line we are setting data to item of recycler view.
        holder.city.setText(allcities.get(position).cityTitle)
       // holder.dateTV.setText("Last Updated : "+allcities.get(position).timeStamp)
        //on below line we are adding click listner to our recycler view item.
        holder.itemView.setOnClickListener {
            //on below line we are calling a city click interface and we are passing a position to it.
            cityClickInterface.onCityClick(allcities.get(position))
        }
    }

    override fun getItemCount(): Int {
        //on below line we are returning our list size.
        return allcities.size
    }

    //below method is use to update our list of cities.
    fun updateList(newList: List<CityModel>) {
        //on below line we are clearing our cities array list/
        allcities.clear()
        //on below line we are adding a new list to our all cities list.
        allcities.addAll(newList)
        //on below line we are calling notify data change method to notify our adapter.
        notifyDataSetChanged()
    }

}


interface CityClickInterface {
    //creating a method for click action on recycler view item for updating it.
    fun onCityClick(city: CityModel)
}