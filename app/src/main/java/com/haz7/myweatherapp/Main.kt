package com.haz7.myweatherapp

class Main {
    private var temp = 0.0
    private var tempMin = 0.0
    private var tempMax = 0.0
    private var pressure = 0.0
    private var humidity = 0.0

    fun getTemp(): Double {
        return temp
    }

    fun setTemp(temp: Double) {
        this.temp = temp
    }

    fun getTempMin(): Double {
        return tempMin
    }

    fun setTempMin(tempMin: Double) {
        this.tempMin = tempMin
    }

    fun getTempMax(): Double {
        return tempMax
    }

    fun setTempMax(tempMax: Double) {
        this.tempMax = tempMax
    }

    fun getPressure(): Double {
        return pressure
    }

    fun setPressure(pressure: Double) {
        this.pressure = pressure
    }

    fun getHumidity(): Double {
        return humidity
    }

    fun setHumidity(humidity: Double) {
        this.humidity = humidity
    }
}