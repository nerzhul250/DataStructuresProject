package mundo;

import colas.ColaEnlazada;
import colas.ICola;
import pilas.IPila;
import pilas.PilaEnlazada;
import tablasHash.TablaHashEncadenada;

public class Bahia{
	
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
	
	public void movsParaSacarCarro(Automovil b, int[] cantidades, int identificador, boolean simulado) throws InterruptedException{
		while(!getPila().top().equals(b)){
			getCola().queue(getPila().pop());
			carrosMovidos++;
			int addForQueue = identificador + cantidades.length/2;
			cantidades[addForQueue] += 1;
			cantidades[identificador] -= 1;
			if(simulado)
				Thread.sleep(ParkingManager.PAUSAESTANDAR);
		}
		carrosMovidos++;
		getPila().pop();
		cantidades[identificador] = cantidades[identificador]-1;
		if(simulado)
			Thread.sleep(ParkingManager.PAUSAESTANDAR);
	}
	
	public void deColaAPila(int[]cantidades, int identificador, boolean simulado) throws InterruptedException{
		while(getCola().isEmpty()!=true) {
			int addForQueue = identificador + cantidades.length/2;
			cantidades[addForQueue] -= 1;
			getPila().push(getCola().deQueue());
			cantidades[identificador] +=1;
			if(simulado)
				Thread.sleep(ParkingManager.PAUSAESTANDAR);
		}
	}
	/**
	 * No se usa pa ni madres
	 */
	public void dePilaACola(){
		while(this.getPila().isEmpty()!=true) {
			this.getCola().queue(this.getPila().pop());
		}
		
	}

	
}
