package com.example.clienttowebview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    lateinit var webview: WebView
    lateinit var toast: Toast
    var isToastShowing: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        webview = WebView(this)
        webview.webChromeClient = MyWebChromeClient()
        webview.webViewClient = MyWebViewClient()

        val webSettings = webview.settings
        webSettings.javaScriptEnabled = true

        setContentView(webview)

        webview.addJavascriptInterface(WebAppInterface(this, webview), "Interface")

        webview.loadUrl("file:///android_asset/webview.html")
    }

    override fun onBackPressed() {
        if (!webview.canGoBack()) {
            if (isToastShowing) {
                super.onBackPressed()
            } else {
                toast = Toast.makeText(this, "한 번 더 클릭 시 앱이 종료됩니다.", Toast.LENGTH_LONG)
                toast.show()
                isToastShowing = false
                Handler(Looper.getMainLooper()).postDelayed({ isToastShowing = false}, 2000)
            }
        } else {
            webview.goBack()
        }
    }
}

