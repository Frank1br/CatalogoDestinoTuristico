package br.edu.fatecpg.catalogodestinoturistico

interface DestinoDao {
    fun adicionarDestino(destino: Destino)
    fun obterDestinos(): List<Destino>
    fun removerDestino(destino: Destino)
}