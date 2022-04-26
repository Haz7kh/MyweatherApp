package com.haz7.myweatherapp.network

import android.content.Context
import android.net.Uri
import android.util.Log
import com.haz7.myweatherapp.MainActivity
import com.haz7.myweatherapp.R
import java.io.IOException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.util.*

object NetworkUtils {
    //vars help to make the (buildUrl)
     val BASE_URL = "https://api.openweathermap.org/data/2.5/"
     val WEATHER_ENDPOINT = "weather"
    val FORECAST_ENDPOINT = "forecast"
     val QUERY_PARAM = "q"
     val FORMAT_PARAM = "mode"
     val UNITS_PARAM = "units"
    val LANG_PARAM = "lang"
     val APP_ID_PARAM = "appid"
     val FORMAT = "json"
     val METRIC = "metric"
     val IMPERIAL = "imperial"
   val TAG: String? = null

    //fun to get the data of now weather
    fun getWeatherUrl(context: Context): URL? {
        return buildUrl(context, WEATHER_ENDPOINT)
    }

    // GUSSING THE WEATHER
    fun getForecastUrl(context: Context): URL? {
        return buildUrl(context, FORECAST_ENDPOINT)
    }

    private fun buildUrl(context: Context, endPint: String): URL? {
        val uriBuilder = Uri.parse(BASE_URL + endPint).buildUpon()
        val uri = uriBuilder
            .appendQueryParameter(QUERY_PARAM, context.getString(R.string.pref_location_default))
            .appendQueryParameter(FORMAT_PARAM, FORMAT)
            .appendQueryParameter(UNITS_PARAM, METRIC)
            .appendQueryParameter(LANG_PARAM, Locale.getDefault().language)
            .appendQueryParameter(APP_ID_PARAM, context.getString(R.string.api_key))
            .build()
        return try {
            val url = URL(uri.toString())
            Log.d(TAG, "URL$url")
            url
        } catch (e: MalformedURLException) {
            e.printStackTrace()
            null
        }
    }

    // to make a connection to the internet
    @Throws(IOException::class)
    fun getResponseFromHttpUrl(url: URL?): String? {
        val httpURLConnection = url?.openConnection() as HttpURLConnection
        httpURLConnection.requestMethod = "GET"
        httpURLConnection.connect()
        return try {
            val inputStream = httpURLConnection.inputStream
            //read the data
            val scanner = Scanner(inputStream)
            scanner.useDelimiter("\\A")
            val hasInput = scanner.hasNext()
            var response: String? = null
            if (hasInput) {
                response = scanner.next()
            }
            scanner.close()
            response
        } finally {
            httpURLConnection.disconnect()
        }
    }
}