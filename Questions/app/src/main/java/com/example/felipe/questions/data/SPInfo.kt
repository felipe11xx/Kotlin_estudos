package com.example.felipe.questions.data

import android.content.Context

class SPInfo(
    val context: Context
) {

    fun updateIntroStatus(status : Boolean){
        context.getSharedPreferences("PREF", Context.MODE_PRIVATE)
            .edit()
            .putBoolean("status", status)
            .apply()
    }

    fun isIntroActivityShown() = context
        .getSharedPreferences("PREF",Context.MODE_PRIVATE)
        .getBoolean("status", false)
}