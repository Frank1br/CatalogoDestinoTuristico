package br.edu.fatecpg.catalogodestinoturistico

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CadastroDestinoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cadastro_destino)
        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val edtLocal = findViewById<EditText>(R.id.edt_local)
        val edtUrl = findViewById<EditText>(R.id.edt_url)
        val btnSalvar = findViewById<Button>(R.id.btn_salvar)
//        val txvLista = findViewById<EditText>(R.id.txv_ver_lista)

        btnSalvar.setOnClickListener {

            val nome = edtNome.text.toString()
            val local = edtLocal.text.toString()
            val url = edtUrl.text.toString()
        }

//        txvLista.setOnClickListener{
//            val intent = Intent(this, ListaActivity::class.java)
//            startActivity(intent)
    }
}