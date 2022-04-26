package com.haz7.myweatherapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HoursAdapter(
    var hour: ArrayList<String>,
    var temperature: ArrayList<String>,
    var hoursIcon: ArrayList<Int>,
     var context: Context): RecyclerView.Adapter<HoursAdapter.HoursViewHolder>() {

class HoursViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var hoursTextView:TextView = itemView.findViewById(R.id.timeOclock)
    var temperatureTextView:TextView = itemView.findViewById(R.id.temperatureHour)
    var iconHoursImgView:ImageView = itemView.findViewById(R.id.weatherIcon)

}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoursViewHolder {
        val view:View =LayoutInflater.from(parent.context).inflate(R.layout.hours_result,parent,false)

        return HoursViewHolder(view)

    }

    override fun onBindViewHolder(holder: HoursViewHolder, position: Int) {

        holder.hoursTextView.text = hour.get(position)
        holder.temperatureTextView.text=temperature.get(position)
        holder.iconHoursImgView.setImageResource(hoursIcon.get(position))

    }

    override fun getItemCount(): Int {
        return hour.size

    }


}