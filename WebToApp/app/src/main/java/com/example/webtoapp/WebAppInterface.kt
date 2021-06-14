package com.example.webtoapp

import android.content.Context
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.widget.Toast

class WebAppInterface constructor(val context: Context, val webView: WebView) {
    @JavascriptInterface
    fun showToast(message: String) = Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}