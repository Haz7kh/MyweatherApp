package com.haz7.myweatherapp

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


class SecondaryWeatherInfoFragment : Fragment() {
   lateinit var windIcon:ImageView
   lateinit var pressureIcon:ImageView
   lateinit var humidityIcon:ImageView

   lateinit var windText:TextView
   lateinit var pressureText:TextView
   lateinit var humidityText:TextView

   lateinit var windResult:TextView
   lateinit var pressureResult:TextView
   lateinit var humidityResult: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_secondary_weather_info, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var view : View? =  view

        windIcon =view!!.findViewById(R.id.windIcon)
        pressureIcon=view.findViewById(R.id.pressureIcon)
        humidityIcon=view.findViewById(R.id.humidityIcon)

        windText = view.findViewById(R.id.windTextView)
        pressureText =view.findViewById(R.id.pressureTextView)
        humidityText = view.findViewById(R.id.humidityTextview)


        windResult = view.findViewById(R.id.windSpeed)
        pressureResult = view.findViewById(R.id.pressureM)
        humidityResult = view.findViewById(R.id.humidityPercent)
        showSecondInfo()
    }

    fun showSecondInfo(){
        windIcon.setImageResource(R.drawable.ic_windy)
        pressureIcon.setImageResource(R.drawable.ic_pressure)
        humidityIcon.setImageResource(R.drawable.ic_humidity)

        windText.text=("Wind")
        pressureText.text=("Pressure")
        humidityText.text=("Humidity")


       windResult.text=("4km/h W")
        pressureResult.text=("1022hPa")
        humidityResult.text=("25%")


    }
}