package br.edu.fatecpg.catalogodestinoturistico

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class CadastroDestinoActivity : AppCompatActivity() {

    private val destinoDao = DestinoDaoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cadastro_destino)

        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val edtLocal = findViewById<EditText>(R.id.edt_local)
        val edtUrl = findViewById<EditText>(R.id.edt_url)
        val btnSalvar = findViewById<Button>(R.id.btn_salvar)
        val txvLista = findViewById<TextView>(R.id.txv_ver_lista)

        btnSalvar.setOnClickListener {
            val nome = edtNome.text.toString().trim()
            val local = edtLocal.text.toString().trim()
            val url = edtUrl.text.toString().trim()

            if (nome.isEmpty() || local.isEmpty() || url.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            destinoDao.adicionarDestino(Destino(nome, local, url))
            edtNome.text.clear()
            edtLocal.text.clear()
            edtUrl.text.clear()
            Toast.makeText(this, "Destino salvo!", Toast.LENGTH_SHORT).show()
        }

        txvLista.setOnClickListener {
            val intent = Intent(this, ListaDestinosActivity::class.java)
            startActivity(intent)
        }
    }
}