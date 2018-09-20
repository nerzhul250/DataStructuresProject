package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hilos.HiloActualizador;
import mundo.ParkingManager;
import mundo.Parqueadero;
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

	public void sendInfo(String text, boolean simulacion) {
		try {
			parkingM = new ParkingManager(text, simulacion);
			Thread.sleep(ParkingManager.PAUSAESTANDAR);
			if (simulacion) {
				Parqueadero p =parkingM.getParqueaderos()[parkingM.getCasoActual()];
				panelBahia.actualizarTabla(p.getCantidadesBahias(), p.getBahias(), parkingM.getCasoActual()+1);	
				actualizador = new HiloActualizador(this, parkingM);
				actualizador.start();
			}
		} catch (Exception e) {
		}
	}

	public void verSimulacion() {
		String texto = panelAreaIngreso.pedirInfo();
		sendInfo(texto, true);
	}

	public void refresh() {
		panelBahia.actualizar();
	}
	public void seCambioCaso() {
		Parqueadero p =parkingM.getParqueaderos()[parkingM.getCasoActual()];
		panelBahia.actualizarTabla(p.getCantidadesBahias(), p.getBahias(), parkingM.getCasoActual()+1);			
	}
}
