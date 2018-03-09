package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

<<<<<<< HEAD
import hilos.HiloActualizador;
=======
>>>>>>> 29332202676395f937fe00c24b31cdb9e478c146
import mundo.ParkingManager;
import mundo.Parqueadero;
import pilas.PilaVaciaException;
import tablasHash.TablaHashEncadenada;

public class InterfazParqueadero extends JFrame {

	private PanelBahia panelBahia;
	private ParkingManager parkingM;
	private PanelArea panelAreaIngreso;
	private HiloActualizador actualizador;

	public InterfazParqueadero() {
		setLayout(new BorderLayout());
		panelBahia = new PanelBahia(this);
		panelAreaIngreso = new PanelArea(this);
		panelAreaIngreso.setPreferredSize(new Dimension(200, 0));
		add(panelBahia, BorderLayout.CENTER);
		add(panelAreaIngreso, BorderLayout.EAST);
		setSize(800, 400);
	}

	public static void main(String[] args) {
		InterfazParqueadero i = new InterfazParqueadero();
		i.setDefaultCloseOperation(EXIT_ON_CLOSE);
		i.setVisible(true);
	}
<<<<<<< HEAD

	public void sendInfo(String text, boolean simulacion) {
		try {
			parkingM = new ParkingManager(text, simulacion);
			Thread.sleep(ParkingManager.PAUSAESTANDAR);
			if (simulacion) {
				actualizador = new HiloActualizador(this);
				actualizador.start();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void verSimulacion() {
		String texto = panelAreaIngreso.pedirInfo();
		sendInfo(texto, true);
	}
=======
	public void sendInfo(String text) {
			parking=new ParkingManager(text);
			System.out.println(parking.sacarLosResultadosDelProblemaMasPoderosoDeTodos());

		}
	}

>>>>>>> 29332202676395f937fe00c24b31cdb9e478c146

	public void cambiarCasoDePrueba() {
		Parqueadero p =parkingM.getParqueaderos()[parkingM.getCasoActual()];
		panelBahia.actualizarTabla(p.getCantidadesBahias());		
	}
	public void refresh() {
		panelBahia.actualizar();
		System.out.println("Se actualiza inter");
	}
}
