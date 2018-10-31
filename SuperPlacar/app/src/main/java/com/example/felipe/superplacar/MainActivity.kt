package com.example.felipe.superplacar

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.blankj.utilcode.util.NetworkUtils
import com.example.felipe.superplacar.domain.CustomWebViewClient
import com.example.felipe.superplacar.extra.JavaScriptConnect
import com.example.felipe.superplacar.extra.UrlUtil
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity() {

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        UrlUtil.clear()

        wv_no_internet.settings.javaScriptEnabled = true
        wv_no_internet.setBackgroundColor(android.R.color.transparent)
        wv_no_internet.addJavascriptInterface(
            JavaScriptConnect(WeakReference(this)),
            JavaScriptConnect.INTERFACE_NAME
        )

        wv_site.settings.javaScriptEnabled = true
        wv_site.setBackgroundColor(android.R.color.transparent)
        wv_site.webViewClient = CustomWebViewClient(this)

    }

    override fun onResume() {
        super.onResume()
        loadPage()
    }

    fun loadPage(){
        if( NetworkUtils.isConnected()){
            wv_no_internet.visibility = View.GONE
            wv_site.loadUrl(UrlUtil.getLastUrl())
            wv_site.visibility = View.VISIBLE
        }else{
            wv_site.visibility = View.GONE
            wv_no_internet.loadUrl(UrlUtil.URL_NO_INTERNET)
            wv_no_internet.visibility = View.VISIBLE
        }
    }

    override fun onBackPressed() {
        if(wv_site.visibility == View.VISIBLE && wv_site.canGoBack()){
            wv_site.goBack()
        }else {
            super.onBackPressed()
        }
    }
}
