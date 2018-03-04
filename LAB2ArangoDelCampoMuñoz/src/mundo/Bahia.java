package mundo;

import colas.ColaEnlazada;
import colas.ICola;
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
	
	public int movsParaSacarCarro(int a,Automovil b) throws PilaVaciaException{
		if(this.getPila().top().equals(b)) {
			return a;
		}else {
			this.getCola().queue(getPila().pop());
			return movsParaSacarCarro(a+1,b);
		}
	}
	
	public void deColaAPila(){
		while(getCola().isEmpty()!=true) {
			getPila().push(getCola().unQueue());
		}
		
	}

	
}
