package com.example.webviewtoclient

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    lateinit var tvText: TextView
//    lateinit var btnClick: Button
//    lateinit var etText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        webView = findViewById(R.id.wv_header)
//        tvText = findViewById(R.id.tv_text)
//        btnClick = findViewById(R.id.btn_click)
//        etText = findViewById(R.id.et_text)


        val websetting = wv_header.settings
        websetting.javaScriptEnabled = true

        wv_header.addJavascriptInterface(WebInterface(), "Interface")
        wv_header.loadUrl("file:///android_asset/sample.html")

        btn_click.setOnClickListener { wv_header.loadUrl("javascript:exam_script.plus_num(" + et_text.text + ")") }


    }

    inner class WebInterface {
        @JavascriptInterface
        fun getDoubleNum(result: Int) {
            tv_text.text = result.toString()
        }
    }

}