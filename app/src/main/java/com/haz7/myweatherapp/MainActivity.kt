package com.haz7.myweatherapp


import android.app.Application
import android.os.AsyncTask
import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.haz7.myweatherapp.network.NetworkUtils
import com.haz7.myweatherapp.network.NetworkUtils.getResponseFromHttpUrl
import com.haz7.myweatherapp.network.NetworkUtils.getWeatherUrl
import java.io.IOException
import java.net.URL


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    val url = "https://api.openweathermap.org/data/2.5/weather?q=Stockholm&appid=6b93bdd9a00318bf2e07e8f767f19a4f"



//hour arrays
    private lateinit var hoursRecyclerView: RecyclerView
    private var hour= ArrayList<String>()
    private var temperature= ArrayList<String>()
    private var hoursIcon = ArrayList<Int>()
    lateinit var dayRecyclerView:RecyclerView
   lateinit var dAdapter :DayAdapter
   lateinit var header:FrameLayout

    var flip:Boolean = true



    //hour adapter
private lateinit var adapter:HoursAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        

        
        
        //viewpager2

        val viewPager:ViewPager2 =findViewById(R.id.header)

        val fragments:ArrayList<Fragment> = arrayListOf(
        PrimaryWeatherInfoFragment(),
        SecondaryWeatherInfoFragment()
        )
        val vAdapter = ViewPagerAdapter(fragments,this)
        viewPager.adapter = vAdapter



        hoursRecyclerView = findViewById(R.id.rv_hours_forecast)

        hoursRecyclerView.setLayoutManager(LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false
            )
        )

        dayRecyclerView = findViewById(R.id.rv_days_forecast)
        dayRecyclerView.layoutManager= LinearLayoutManager(this@MainActivity)


//Hours info
        hour.add("12:00 Am")
        hour.add("12:00 Am")
        hour.add("12:00 Am")
        hour.add("12:00 Am")
        hour.add("12:00 Am")

        temperature.add("19°")
        temperature.add("19°")
        temperature.add("19°")
        temperature.add("19°")
        temperature.add("19°")


        hoursIcon.add(R.drawable.ic_clear_sky)
        hoursIcon.add(R.drawable.ic_clear_sky)
        hoursIcon.add(R.drawable.ic_clear_sky)
        hoursIcon.add(R.drawable.ic_clear_sky)
        hoursIcon.add(R.drawable.ic_clear_sky)

        adapter = HoursAdapter(hour,temperature,hoursIcon, this@MainActivity)

        hoursRecyclerView.adapter = adapter


       dAdapter = DayAdapter()
        dayRecyclerView.adapter =dAdapter

        requestWeatherInfo()


    }
    private fun requestWeatherInfo() {
        WeatherDataGetTask().execute()
    }

    class WeatherDataGetTask :
        AsyncTask<Void?, Int?, String?>() {


         override   fun doInBackground(vararg voids: Void?): String? {
                val weatherUrl: URL? = getWeatherUrl(context = this@MainActivity)
                var weatherJsonResponse: String? = null
                try {
                    weatherJsonResponse = getResponseFromHttpUrl(weatherUrl)
                } catch (e: IOException) {
                    e.printStackTrace()
                }
                return weatherJsonResponse
            }
            override fun onPostExecute(s: String?) {

            }

    }




    }



