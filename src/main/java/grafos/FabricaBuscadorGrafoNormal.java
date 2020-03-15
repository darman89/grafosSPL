package grafos;


import fabrica.interfaces.BusquedaGrafoNormal;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class FabricaBuscadorGrafoNormal {

    private FabricaBuscadorGrafoNormal() {
        throw new IllegalStateException("Factory class");
    }

    public static BusquedaGrafoNormal getNewSearchStrategy() {
        SeContainer container = SeContainerInitializer.newInstance().initialize();
        BusquedaGrafoNormal buscador = container.select(BusquedaGrafoNormal.class).get();
        return buscador;
    }
}
