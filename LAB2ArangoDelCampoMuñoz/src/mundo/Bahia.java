package mundo;

import colas.ColaEnlazada;
import colas.ICola;
import pilas.IPila;
import pilas.PilaEnlazada;
import pilas.PilaVaciaException;

public class Bahia  {
	
	private IPila<Automovil> pila;
	private ICola<Automovil> cola;
	private int carrosMovidos;
	
	public int getCarrosMovidos() {
		return carrosMovidos;
	}
	public void setCarrosMovidos(int carrosMovidos) {
		this.carrosMovidos = carrosMovidos;
	}
	public Bahia() {
		carrosMovidos=0;
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
	
	public void movsParaSacarCarro(Automovil b) throws PilaVaciaException{
		while(!getPila().top().equals(b)){
			getCola().queue(getPila().pop());			
			carrosMovidos++;
		}
		carrosMovidos++;
		getPila().pop();
	}
	
	public void deColaAPila() {
		while(getCola().isEmpty()!=true) {
			getPila().push(getCola().deQueue());
		}
		
	}
	public void dePilaACola() throws PilaVaciaException {
		while(this.getPila().isEmpty()!=true) {
			this.getCola().queue(this.getPila().pop());
		}
		
	}

	
}
