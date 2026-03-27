package br.edu.fatecpg.catalogodestinoturistico

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val usuarioFixo = "admin"
    private val senhaFixa = "1234"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val edtUsuario = findViewById<EditText>(R.id.editTextText2)
        val edtSenha = findViewById<EditText>(R.id.editTextText3)
        val btnEntrar = findViewById<Button>(R.id.button)
        val txvCadastreSe = findViewById<TextView>(R.id.txv_cadastre_se)

        btnEntrar.setOnClickListener {
            val usuario = edtUsuario.text.toString()
            val senha = edtSenha.text.toString()

            if (usuario == usuarioFixo && senha == senhaFixa) {
                val intent = Intent(this, CadastroDestinoActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show()
            }
        }

        txvCadastreSe.setOnClickListener {
            val intent = Intent(this, CadastroDestinoActivity::class.java)
            startActivity(intent)
        }
    }
}