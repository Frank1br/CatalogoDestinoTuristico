package br.edu.fatecpg.catalogodestinoturistico

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ListaDestinosActivity : AppCompatActivity() {

    private lateinit var containerLista: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista_destinos)
        containerLista = findViewById(R.id.container_lista)
    }

    override fun onResume() {
        super.onResume()
        renderizarLista()
    }

    private fun renderizarLista() {
        containerLista.removeAllViews()

        for (i in DestinoRepository.lista.indices) {
            val destino = DestinoRepository.lista[i]
            val itemView = layoutInflater.inflate(R.layout.item_destino, containerLista, false)

            itemView.findViewById<TextView>(R.id.txv_nome_destino).text = destino.nome
            itemView.findViewById<TextView>(R.id.txv_local_destino).text = destino.local

            itemView.findViewById<Button>(R.id.btn_explorar).setOnClickListener {
                val intent = Intent(this, WebViewActivity::class.java)
                intent.putExtra("url", destino.url)
                startActivity(intent)
            }

            itemView.findViewById<Button>(R.id.btn_excluir).setOnClickListener {
                DestinoRepository.lista.removeAt(i)
                renderizarLista()
            }

            containerLista.addView(itemView)
        }
    }
}