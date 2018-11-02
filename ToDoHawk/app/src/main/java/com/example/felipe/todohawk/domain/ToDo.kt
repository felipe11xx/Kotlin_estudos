package com.example.felipe.todohawk.domain

import com.example.felipe.todohawk.R
import java.util.*

class ToDo(
    val date : Long,
    val task : String,
    val duration: Int,
    val priority: Int
) {
    fun getDateFormatterd():String{

        val calendar = Calendar.getInstance()
        calendar.timeInMillis = date

        var date=""""
                ${getNumDate(calendar.get(Calendar.DAY_OF_MONTH))}/
                ${getNumDate(calendar.get(Calendar.MONTH))}/
                ${getNumDate(calendar.get(Calendar.YEAR))}""""

        return date.replace("\n","").replace(" ", "").trim()
    }

    private fun getNumDate(num: Int)
        =if(num <10){
            "0$num"
        }else{
            "$num"
        }

        fun getPriorityIcon()
            =if( priority == 1 ){
            R.drawable.ic_priority_low
        }else if (priority == 2){
            R.drawable.ic_priority_medium
        }else{
            R.drawable.ic_priority_high
        }


}