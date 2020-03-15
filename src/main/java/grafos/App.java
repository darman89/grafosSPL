package grafos;

import fabrica.entities.Nodo;
import fabrica.interfaces.Grafo;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            Grafo g = FabricaGrafo.getNewGraph();
            g.addNodo("A");
            g.addNodo("B");
            g.addNodo("C");

            g.addArco("A", "B", 1);
            g.addArco("B", "C", 1);
            g.addArco("A", "C", 2);

            List<Nodo> camino = g.buscarRuta("A", "C");

            if (camino == null) {
                System.out.println("Camino A -> C no encontrado");
            } else {
                System.out.println("Camino A -> C encontrado");
                for (Nodo nodo: camino) {
                    System.out.println(nodo.getNombre());
                }
            }
            System.out.println();


        } catch (Exception e) {
            // muestra mensajes de error
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
