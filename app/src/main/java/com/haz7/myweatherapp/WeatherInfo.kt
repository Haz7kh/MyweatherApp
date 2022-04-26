package com.haz7.myweatherapp

class WeatherInfo {
    private var weather: List<Weather>? = null
    private var main: Main? = null
    private var wind: Wind? = null
    private var dt: Long? = null
    private var name: String? = null

    fun getWeather(): List<Weather?>? {
        return weather
    }

    fun setWeather(weather: List<Weather?>?) {
        this.weather = weather as List<Weather>?
    }

    fun getMain(): Main? {
        return main
    }

    fun setMain(main: Main?) {
        this.main = main
    }

    fun getWind(): Wind? {
        return wind
    }

    fun setWind(wind: Wind?) {
        this.wind = wind
    }

    fun getDt(): Long? {
        return dt
    }

    fun setDt(dt: Long?) {
        this.dt = dt
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

}