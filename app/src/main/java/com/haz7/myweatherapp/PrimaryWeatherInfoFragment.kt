package com.haz7.myweatherapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


class PrimaryWeatherInfoFragment : Fragment() {

    lateinit var icon : ImageView
    lateinit var city: TextView
    lateinit var dateView: TextView
    lateinit var descriptionView: TextView
    lateinit var temperatureView: TextView
    lateinit var highLowTemp: TextView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_primary_waether_info,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var mainView : View? =  view

        icon = mainView!!.findViewById(R.id.weather_icon)
        city = mainView.findViewById(R.id.city)
        dateView = mainView.findViewById(R.id.dayDate)
        descriptionView=mainView.findViewById(R.id.weather_description)
        temperatureView= mainView.findViewById(R.id.temperature)
        highLowTemp = mainView.findViewById(R.id.high_low_temperature)
        showInfo()
    }

    fun showInfo(){
        icon.setImageResource(R.drawable.ic_clear_sky)
        city.setText("Stockholm")
        dateView.setText("Today, April 03")
        descriptionView.setText("Cloudy")
        temperatureView.setText("19°")
        highLowTemp.setText("19°/10°")

    }


    }




