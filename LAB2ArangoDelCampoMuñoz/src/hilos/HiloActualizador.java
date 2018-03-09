package hilos;

import interfaz.InterfazParqueadero;
import mundo.ParkingManager;

public class HiloActualizador extends Thread{

	private InterfazParqueadero ppal;
	public HiloActualizador(InterfazParqueadero inter) {
		ppal = inter;
	}
	
	@Override
	public void run() {
		while(isAlive()){
			ppal.refresh();
			ppal.cambiarCasoDePrueba();
			try {
				sleep(ParkingManager.PAUSAESTANDAR);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
