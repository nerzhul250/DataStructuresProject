package mundo;

import colas.ColaEnlazada;
import colas.ICola;
import colas.NodoCola;
import pilas.IPila;
import pilas.PilaEnlazada;
import pilas.PilaVaciaException;

public class Bahia  {
	
	public IPila<Automovil> pila;
	public ICola<Automovil> cola;
	
	
	public Bahia() {
		
		pila=new PilaEnlazada<Automovil>();
		cola=new ColaEnlazada <Automovil>();
	}




	public IPila<Automovil> getPila() {
		return pila;
	}


	public void setPila(IPila<Automovil> pila) {
		this.pila = pila;
	}


	public ICola<Automovil> getCola() {
		return cola;
	}


	public void setCola(ICola<Automovil> cola) {
		this.cola = cola;
	}
	

	
}
