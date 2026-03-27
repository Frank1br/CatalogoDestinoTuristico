package br.edu.fatecpg.catalogodestinoturistico

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_web_view)

        val webView = findViewById<WebView>(R.id.webView)
        val btnVoltar = findViewById<Button>(R.id.btn_voltar)
        val url = intent.getStringExtra("url") ?: "https://www.google.com/"

        webView.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            loadUrl(url)
        }

        btnVoltar.setOnClickListener {
            finish()
        }
    }
}