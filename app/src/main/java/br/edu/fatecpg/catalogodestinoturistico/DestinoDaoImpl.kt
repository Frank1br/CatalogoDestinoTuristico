package br.edu.fatecpg.catalogodestinoturistico

class DestinoDaoImpl : DestinoDao {

    companion object {
        private val destinos = mutableListOf<Destino>()
    }

    override fun adicionarDestino(destino: Destino) {
        Companion.destinos.add(destino)
    }

    override fun obterDestinos(): List<Destino> {
        return Companion.destinos
    }

    override fun removerDestino(destino: Destino) {
        Companion.destinos.remove(destino)
    }
}