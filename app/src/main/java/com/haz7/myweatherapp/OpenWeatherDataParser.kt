package com.haz7.myweatherapp


import com.haz7.myweatherapp.Main
import com.haz7.myweatherapp.Weather
import com.haz7.myweatherapp.WeatherInfo
import com.haz7.myweatherapp.Wind
import org.json.JSONException
import org.json.JSONObject

object OpenWeatherDataParse {
    //vars that save the keys of the values that we need  from json file
    private const val OWM_MESSAGE_CODE = "cod"
    private const val OWM_CITY = "city"
    private const val OWM_CITY_NAME = "name"
    private const val OWM_LIST = "list"
    private const val OWM_DATE = "dt"
    private const val OWM_DATE_TEXT = "dt_txt"
    private const val OWM_WIND = "wind"
    private const val OWM_WINDSPEED = "speed"
    private const val OWM_WIND_DIRECTION = "deg"
    private const val OWM_MAIN = "main"
    private const val OWM_TEMPERATURE = "temp"
    private const val OWM_MAX = "temp_max"
    private const val OWM_MIN = "temp_min"
    private const val OWM_PRESSURE = "pressure"
    private const val OWM_HUMIDITY = "humidity"
    private const val OWM_WEATHER = "weather"
    private const val OWM_WEATHER_DESCRIPTION = "description"
    private const val OWM_WEATHER_ICON = "icon"
    @Throws(JSONException::class)
    fun getWeatherInfoObjectsFromJson(weatherInfoJsonString: String?): WeatherInfo {
        val jsonObject = JSONObject(weatherInfoJsonString)
        val weatherJsonObject = jsonObject.getJSONArray(OWM_WEATHER).getJSONObject(0)
        val mainJsonObject = jsonObject.getJSONObject(OWM_MAIN)
        val windJsonObject = jsonObject.getJSONObject(OWM_WIND)
        val weatherInfo = WeatherInfo()
        weatherInfo.setDt(jsonObject.getLong(OWM_DATE))
        val main = Main()

        main.setTemp(mainJsonObject.getDouble(OWM_TEMPERATURE))
        main.setTempMin(mainJsonObject.getDouble(OWM_MIN))
        main.setTempMax(mainJsonObject.getDouble(OWM_MAX))
        main.setPressure(mainJsonObject.getDouble(OWM_PRESSURE))
        main.setHumidity(mainJsonObject.getDouble(OWM_HUMIDITY))
        weatherInfo.setMain(main)
        val wind = Wind()
        wind.setSpeed(windJsonObject.getDouble(OWM_WINDSPEED))
        wind.setDeg(windJsonObject.getDouble(OWM_WIND_DIRECTION))
        weatherInfo.setWind(wind)
        val weatherList: MutableList<Weather> = ArrayList<Weather>()
        val weather = Weather()
        weather.setDescription(weatherJsonObject.getString(OWM_WEATHER_DESCRIPTION))
        weather.setIcon(weatherJsonObject.getString(OWM_WEATHER_ICON))
        weatherList.add(weather)
        weatherInfo.setWeather(weatherList)
        weatherInfo.setName(if (jsonObject.has(OWM_CITY_NAME)) jsonObject.getString(OWM_CITY_NAME) else "")
        return weatherInfo
    }
}