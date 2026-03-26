package br.edu.fatecpg.catalogodestinoturistico

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnProxTela = findViewById<Button>(R.id.button)

//        btnProxTela.setOnClickListener {
//            val intent = Intent(this, WebViewActivity::class.java)
//            startActivity(intent)
//        }
    }
}