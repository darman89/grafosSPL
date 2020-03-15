package fabrica.entities;

import fabrica.interfaces.BusquedaGrafoNormal;
import fabrica.interfaces.Grafo;
import grafos.FabricaBuscadorGrafoNormal;

import javax.enterprise.inject.Alternative;
import java.util.ArrayList;
import java.util.List;

@Alternative
public class GrafoNormal implements Grafo {
    BusquedaGrafoNormal bgf;
    List<Nodo> nodos = new ArrayList<>();
    List<Arco> arcos = new ArrayList<>();

    public GrafoNormal() {
        bgf = FabricaBuscadorGrafoNormal.getNewSearchStrategy();
    }

    public void addNodo(String nombre) {
        Nodo nodo = new Nodo();
        nodo.setNombre(nombre);
        nodos.add(nodo);
    }

    public void addArco(String origen, String destino) throws Exception {

        Nodo nodoOrigen = buscarNodo(origen);
        Nodo nodoDestino = buscarNodo(destino);

        // Origen o destino no encontrado
        if (nodoOrigen == null) {
            throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
        }
        if (nodoDestino == null) {
            throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
        }

        addArco(nodoOrigen, nodoDestino);
    }

    public void addArco(String origen, String destino, int peso) {
        throw new IllegalStateException("Forbidden  Parameter Setup");
    }

    public void addArco(Nodo nodoOrigen, Nodo nodoDestino) {
        Arco arco = new Arco();
        arco.setOrigen(nodoOrigen);
        arco.setDestino(nodoDestino);
        arcos.add(arco);
        nodoOrigen.agregarArco(arco);

        arco = new Arco();
        arco.setOrigen(nodoDestino);
        arco.setDestino(nodoOrigen);
        arcos.add(arco);
        nodoDestino.agregarArco(arco);
    }

    public Nodo buscarNodo(String nombre) {
        for (Nodo nodo : nodos) {
            if (nodo.getNombre().equals(nombre)) {
                return nodo;
            }
        }
        return null;
    }

    public boolean existeRuta(String origen, String destino) throws Exception {
        if (buscarRuta(origen, destino) != null) {
            return true;
        }
        return false;
    }

    public List<Nodo> buscarRuta(String origen, String destino) throws Exception {

        Nodo nodoOrigen = buscarNodo(origen);
        Nodo nodoDestino = buscarNodo(destino);
        List<Nodo> nodosRuta = new ArrayList<>();

        // Origen o destino no encontrado
        if (nodoOrigen == null) {
            throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
        }
        if (nodoDestino == null) {
            throw new RuntimeException("Error en la Búsqueda: NodoDestino no encontrado");
        }
        if (bgf.buscarRuta(nodosRuta, nodoOrigen, nodoDestino)) {
            return nodosRuta;
        } else {
            return null;
        }
    }
}
