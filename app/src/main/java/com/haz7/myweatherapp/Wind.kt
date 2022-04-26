package com.haz7.myweatherapp

class Wind {
    private var speed = 0.0
    private var deg = 0.0

    fun getSpeed(): Double {
        return speed
    }

    fun setSpeed(speed: Double) {
        this.speed = speed
    }

    fun getDeg(): Double {
        return deg
    }

    fun setDeg(deg: Double) {
        this.deg = deg
    }
}