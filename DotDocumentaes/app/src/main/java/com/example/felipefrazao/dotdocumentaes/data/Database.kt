package com.example.felipefrazao.dotdocumentaes.data

import android.content.Context
import com.example.felipefrazao.dotdocumentaes.R
import com.example.felipefrazao.dotdocumentaes.domain.Doc

class Database {
    companion object {
        fun getDocs() = listOf(
                Doc("kotlin-docs.pdf",R.drawable.kotlin_bg,"Kotlin",194),
                Doc("java-docs.pdf",R.drawable.java_bg,"Java", 670),
                Doc("python-docs.pdf",R.drawable.python_bg,"Python",45),
                Doc("haskell-docs.pdf",R.drawable.haskell_bg,"Haskell",503),
                Doc("scala-docs.pdf",R.drawable.scala_bg,"Scala",547)
        )

        fun saveActualPageSP( context: Context, key:String, page:Int){
            context.getSharedPreferences("Pref",Context.MODE_PRIVATE)
                    .edit()
                    .putInt("$key-page",page)
                    .apply()
        }


        fun getActualPageSP( context: Context, key:String):Int{
           return context.getSharedPreferences("Pref",Context.MODE_PRIVATE)
                    .getInt("$key-page",0)
        }
    }
}