package fabrica.interfaces;

import fabrica.entities.Nodo;

import java.util.List;

public interface Grafo {
    public void addNodo(String nombre);
    public void addArco(String origen, String destino) throws Exception;
    public void addArco(String origen, String destino, int peso) throws Exception;
    public Nodo buscarNodo(String nombre);
    public List<Nodo> buscarRuta(String origen, String destino) throws Exception;
    public boolean existeRuta(String origen, String destino) throws Exception;

}
