package com.example.android.trackmysleepquality.sleeptracker

import com.example.android.trackmysleepquality.database.SleepNight

sealed class DataItem {
    abstract val id:Long
    data class SleepNightItem(val sleepNight: SleepNight):DataItem(){
        override val id = sleepNight.nigthId
    }

    object Header: DataItem(){
        override val id = Long.MIN_VALUE
    }
}