package com.example.webtoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wv_showToast.webViewClient = WebViewClient()
        wv_showToast.webChromeClient = WebChromeClient()

        val webSettings = wv_showToast.settings
        webSettings.javaScriptEnabled = true
//        webSettings.allowContentAccess = true

        wv_showToast.addJavascriptInterface(WebAppInterface(this, wv_showToast), "Interface")

        wv_showToast.loadUrl("file:///android_asset/webview.html") // file:/// !!! 역슬래쉬 3개
//        wv_showToast.loadUrl("https://www.naver.com") // --> 잘됨
    }
}