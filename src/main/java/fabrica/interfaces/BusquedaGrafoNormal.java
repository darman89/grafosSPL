package fabrica.interfaces;

import fabrica.entities.Nodo;

import java.util.List;

public interface BusquedaGrafoNormal {
    public boolean buscarRuta(List<Nodo> nodosRuta, Nodo nodoOrigen, Nodo nodoDestino);
}
