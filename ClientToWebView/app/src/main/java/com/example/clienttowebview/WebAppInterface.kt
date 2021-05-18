package com.example.clienttowebview

import android.app.Activity
import android.content.Context
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.widget.Toast

class WebAppInterface constructor(val context: Context, val webview: WebView) {

    @JavascriptInterface
    fun showToast(message: String) = Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

    @JavascriptInterface
    fun closeActivity() = (context as Activity).finish()


    @JavascriptInterface
    fun onBackPress() {
        webview.post {
            (context as Activity).runOnUiThread {
                context.onBackPressed()
            }
        }
        // webview.post({ (context as Activity).runOnUiThread({  (context as Activity).onBackPressed()})})
    }

    @JavascriptInterface
    fun onForward() {
        webview.post {
            (context as Activity).runOnUiThread {
                if( webview.canGoForward() ) webview.goForward()
                else Toast.makeText(context, "다음 페이지가 없어요.", Toast.LENGTH_SHORT).show()
            }
        }
        // webview.post({ (context as Activity).runOnUiThread({
        //     if (webview.canGoForward()) {
        //         webview.goForward()
        //     } else {
        //         Toast.makeText(context, "다음 페이지가 없어요.", Toast.LENGTH_SHORT).show()
        //     }
        // })})
    }
}