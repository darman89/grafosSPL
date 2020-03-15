package grafos;


import fabrica.interfaces.Grafo;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class FabricaGrafo {

    private FabricaGrafo() {
        throw new IllegalStateException("Factory class");
    }

    public static Grafo getNewGraph() {
        SeContainer container = SeContainerInitializer.newInstance().initialize();
        Grafo grafo = container.select(Grafo.class).get();
        return grafo;
    }
}
