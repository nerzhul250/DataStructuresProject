package hilos;

import interfaz.InterfazParqueadero;
import mundo.ParkingManager;

public class HiloActualizador extends Thread {

	private InterfazParqueadero ppal;
	private ParkingManager enProceso;
	private int miActual;

	public HiloActualizador(InterfazParqueadero inter, ParkingManager manager) {
		ppal = inter;
		enProceso = manager;
		miActual = enProceso.getCasoActual();
	}

	@Override
	public void run() {
		while (enProceso.isAlive()) {
			ppal.refresh();
			if (enProceso.getCasoActual() != miActual){
				ppal.seCambioCaso();
				miActual = enProceso.getCasoActual();
			}
			try {
				sleep(ParkingManager.PAUSAESTANDAR-600);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
