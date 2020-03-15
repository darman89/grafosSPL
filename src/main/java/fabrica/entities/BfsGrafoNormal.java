package fabrica.entities;

import fabrica.interfaces.BusquedaGrafoNormal;

import javax.enterprise.inject.Alternative;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Alternative
public class BfsGrafoNormal implements BusquedaGrafoNormal {
    @Override
    public boolean buscarRuta(List<Nodo> nodosRuta, Nodo nodoOrigen, Nodo nodoDestino) {
        // origen y destino son el mismo ?
        if(nodoOrigen.getNombre().equals(nodoDestino.getNombre())){
            System.err.println("Nodo destino encontrado en el mismo nodo origen");
            nodosRuta.add(nodoOrigen);
            return true;
        }

        // si no son el mismo, revise las rutas usando una cola
        Queue<Nodo> queue = new LinkedList<>();
        ArrayList<Nodo> nodosVisitados = new ArrayList<>();

        queue.add(nodoOrigen);
        nodosVisitados.add(nodoOrigen);

        while(!queue.isEmpty()){

            Nodo actual = queue.remove();
            if(actual.equals(nodoDestino)) {
                nodosRuta.add(actual);
                return true;
            }
            else{
                if(actual.getNodosAdyacentes().isEmpty())
                    return false;
                else {
                    for (Nodo nodo: actual.getNodosAdyacentes()) {
                        if (!nodosVisitados.contains(nodo))
                            queue.add(nodo);
                    }
                }

            }
            if (!nodosRuta.contains(actual))
                nodosRuta.add(actual);
        }

        return false;
    }
}
