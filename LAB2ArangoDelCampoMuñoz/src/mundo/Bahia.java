package mundo;

import colas.ColaEnlazada;
import colas.ICola;
import pilas.IPila;
import pilas.PilaEnlazada;
<<<<<<< HEAD
import pilas.PilaVaciaException;
import tablasHash.TablaHashEncadenada;
=======
>>>>>>> 29332202676395f937fe00c24b31cdb9e478c146

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
	
<<<<<<< HEAD
	public void movsParaSacarCarro(Automovil b, int[] cantidades, int identificador, boolean simulado) throws PilaVaciaException, InterruptedException{
=======
	public void movsParaSacarCarro(Automovil b){
>>>>>>> 29332202676395f937fe00c24b31cdb9e478c146
		while(!getPila().top().equals(b)){
			getCola().queue(getPila().pop());
			carrosMovidos++;
			if(simulado)
			Thread.sleep(ParkingManager.PAUSAESTANDAR);
			int addForQueue = identificador + cantidades.length;
			cantidades[addForQueue] = cantidades[addForQueue]+1;
			cantidades[identificador] = cantidades[identificador]-1;
		}
		carrosMovidos++;
		getPila().pop();
		cantidades[identificador] = cantidades[identificador]-1;
	}
	
	public void deColaAPila(int[]cantidades, int identificador) throws InterruptedException {
		while(getCola().isEmpty()!=true) {
			Thread.sleep(ParkingManager.PAUSAESTANDAR);
			int addForQueue = identificador + cantidades.length;
			cantidades[addForQueue] = cantidades[addForQueue]-1;
			getPila().push(getCola().deQueue());
			cantidades[identificador] = cantidades[identificador]+1;
		}
		
	}
	public void dePilaACola(){
		while(this.getPila().isEmpty()!=true) {
			this.getCola().queue(this.getPila().pop());
		}
		
	}

	
}
