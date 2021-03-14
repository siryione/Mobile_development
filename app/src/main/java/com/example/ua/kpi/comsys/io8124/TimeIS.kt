package com.example.ua.kpi.comsys.io8124

import java.util.*

class TimeIS {
    var seconds = 0
    var minutes = 0
    var hours = 0

    constructor(hours: Int, minutes: Int, seconds: Int) {
        if (hours in 0..23 && minutes in 0..59 && seconds in 0..59) {
            this.seconds = seconds
            this.minutes = minutes
            this.hours = hours
        } else {
            throw IllegalArgumentException()
        }
    }

    constructor(date: Date) {
        this.seconds = date.seconds
        this.minutes = date.minutes
        this.hours = date.hours
    }

    override fun toString(): String {
        return "${hours%12}:$minutes:$seconds ${if (hours < 12){ "AM" } else { "PM" }}"
    }

    fun add(time: TimeIS): TimeIS {
        val date = Calendar.getInstance()
        date.set(0, 0, 0, this.hours, this.minutes, this.seconds)
        date.add(Calendar.HOUR, time.hours)
        date.add(Calendar.MINUTE, time.minutes)
        date.add(Calendar.SECOND, time.seconds)
        return TimeIS(date.time.hours, date.time.minutes, date.time.seconds)
    }

    fun sub(time: TimeIS): TimeIS {
        val date = Calendar.getInstance()
        date.set(0, 0, 0, this.hours, this.minutes, this.seconds)
        date.add(Calendar.HOUR, -time.hours)
        date.add(Calendar.MINUTE, -time.minutes)
        date.add(Calendar.SECOND, -time.seconds)
        return TimeIS(date.time.hours, date.time.minutes, date.time.seconds)
    }

    companion object{
        fun add(time1: TimeIS, time2: TimeIS) = time1.add(time2)
        fun sub(time1: TimeIS, time2: TimeIS) = time1.sub(time2)
    }
}