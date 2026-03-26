package br.edu.fatecpg.catalogodestinoturistico

import android.os.Bundle
import android.webkit.WebView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_web_view)

        val webView = findViewById<WebView>(R.id.webView)
        val UrlStrind = "https://imgs.search.brave.com/CQyU3C2Q2ezdxf2qfnt3Akc14kEyHcxO-KVgEwyIkJo/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pLnJl/ZGQuaXQvMTlzdGJz/Nm5yMjVnMS5qcGVn"

        webView.apply {
            loadUrl(UrlStrind)
            settings.javaScriptEnabled = true
        }


    }
}