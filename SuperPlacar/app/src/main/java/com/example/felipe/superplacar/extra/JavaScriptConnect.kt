package com.example.felipe.superplacar.extra

import android.webkit.JavascriptInterface
import com.example.felipe.superplacar.MainActivity
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import java.lang.ref.WeakReference

class JavaScriptConnect( val weakactivity: WeakReference<MainActivity>) {

    companion object {
        @JvmField val INTERFACE_NAME = "AndroidInstance"
    }

    @JavascriptInterface
    fun reloadPage(){
        async(UI) {
            weakactivity.get()?.loadPage()
        }
    }
}