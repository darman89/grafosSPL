package fabrica.entities;

public class Arco {

	protected Nodo origen;
	
	protected Nodo destino;
	
	public Arco() {	}
	
	public Nodo getOrigen() {
		return origen;
	}
	public void setOrigen(Nodo origen) {
		this.origen = origen;
	}
	
	public Nodo getDestino() {
		return destino;
	}
	public void setDestino(Nodo destino) {
		this.destino = destino;
	}
	
}
