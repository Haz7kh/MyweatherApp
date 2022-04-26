package com.haz7.myweatherapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DayAdapter:RecyclerView.Adapter<DayAdapter.DayViewHolder>() {

    private var weImg = arrayListOf<Int>(R.drawable.ic_clear_sky,R.drawable.ic_clear_sky,R.drawable.ic_clear_sky,R.drawable.ic_clear_sky)
    private var dayDataa= arrayListOf<String>("Today, April 03","Today, April 03","Today, April 03","Today, April 03")
    private var desArray = arrayListOf<String>("Sunny","Sunny","Sunny","Sunny")
    private var highTempe= arrayListOf<String>("19","19","19","19")
    private var lowtempe= arrayListOf<String>("10","10","10","10")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayAdapter.DayViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.day_result,parent,false)
        return DayViewHolder(v)
    }

    override fun onBindViewHolder(holder: DayAdapter.DayViewHolder, position: Int) {

        holder.wheatherIcon.setImageResource(weImg[position])
        holder.dayate.text=dayDataa[position]
        holder.descriptionDay.text=desArray[position]
        holder.highTemp.text=highTempe[position]
        holder.lowTemp.text=lowtempe[position]

    }

    override fun getItemCount(): Int {
       return desArray.size
    }

    class DayViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var wheatherIcon:ImageView
        var dayate:TextView
        var descriptionDay:TextView
        var highTemp:TextView
        var lowTemp:TextView
        init {
            wheatherIcon = itemView.findViewById(R.id.weather_icon)
            dayate = itemView.findViewById(R.id.dayDate)
            descriptionDay = itemView.findViewById(R.id.weather_description)
            highTemp = itemView.findViewById(R.id.high_temperature)
            lowTemp = itemView.findViewById(R.id.low_temperature)
        }

    }
}