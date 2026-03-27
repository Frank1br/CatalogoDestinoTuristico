package br.edu.fatecpg.catalogodestinoturistico

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaDestinosActivity : AppCompatActivity() {

    private val destinoDao = DestinoDaoImpl()
    private lateinit var adapter: DestinoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista_destinos)

        val destinos = destinoDao.obterDestinos()

        adapter = DestinoAdapter(
            destinos = destinos,
            onExplorar = { destino ->
                val intent = Intent(this, WebViewActivity::class.java)
                intent.putExtra("url", destino.url)
                startActivity(intent)
            },
            onExcluir = { destino, position ->
                destinoDao.removerDestino(destino)
                adapter.notifyItemRemoved(position)
            }
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_destinos)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }
}