package br.edu.fatecpg.catalogodestinoturistico

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DestinoAdapter(
    private val destinos: List<Destino>,
    private val onExplorar: (Destino) -> Unit,
    private val onExcluir: (Destino, Int) -> Unit
) : RecyclerView.Adapter<DestinoAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txvNome: TextView = itemView.findViewById(R.id.txv_nome_destino)
        val txvLocal: TextView = itemView.findViewById(R.id.txv_local_destino)
        val btnExplorar: Button = itemView.findViewById(R.id.btn_explorar)
        val btnExcluir: Button = itemView.findViewById(R.id.btn_excluir)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_destino, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val destino = destinos[position]
        holder.txvNome.text = destino.nome
        holder.txvLocal.text = destino.local
        holder.btnExplorar.setOnClickListener { onExplorar(destino) }
        holder.btnExcluir.setOnClickListener { onExcluir(destino, holder.adapterPosition) }
    }

    override fun getItemCount(): Int {
        return destinos.size
    }
}