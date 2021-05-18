package com.example.clienttowebview

import android.webkit.ConsoleMessage
import android.webkit.WebChromeClient

class MyWebChromeClient : WebChromeClient() {
    override fun onConsoleMessage(consoleMessage: ConsoleMessage?): Boolean {

        return super.onConsoleMessage(consoleMessage)
    }
}