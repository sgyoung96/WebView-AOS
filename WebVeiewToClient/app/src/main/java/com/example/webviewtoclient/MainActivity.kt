package com.example.webviewtoclient

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var webView: WebView
    lateinit var tvText: TextView
    lateinit var btnClick: Button
    lateinit var etText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.wv_header)
        tvText = findViewById(R.id.tv_text)
        btnClick = findViewById(R.id.btn_click)
        etText = findViewById(R.id.et_text)

        val websetting = webView.settings
        websetting.javaScriptEnabled = true

        webView.addJavascriptInterface(WebViewInterface(this, webView), "Interface")
        webView.loadUrl("file:///android_asset/sample.html")

        btnClick.setOnClickListener { webView.loadUrl("javascript:exam_script.plus_num(" + etText.text + ")") }
    }
}