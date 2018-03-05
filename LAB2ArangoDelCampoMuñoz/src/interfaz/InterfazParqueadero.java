package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import colas.ColaVaciaException;
import pilas.PilaVaciaException;
import mundo.ParkingManager;

public class InterfazParqueadero extends JFrame {

	private PanelBahia bahia;
	private ParkingManager parking;
	private PanelArea a;
	public InterfazParqueadero ()  {
		setLayout(new BorderLayout());
		bahia = new PanelBahia(this);
		a=new PanelArea(this);
		a.setPreferredSize(new Dimension(200,0));
		add(bahia,BorderLayout.CENTER);
		add(a,BorderLayout.EAST);
		pack();
	}
	public static void main(String[] args) {
		InterfazParqueadero i = new InterfazParqueadero();
		i.setDefaultCloseOperation(EXIT_ON_CLOSE);
		i.setVisible(true);
	}
	public void sendInfo(String text) {
		try {
			parking=new ParkingManager(text);
			System.out.println(parking.sacarLosResultadosDelProblemaMasPoderosoDeTodos());
		} catch (PilaVaciaException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this,e.getMessage());
		} catch (ColaVaciaException a) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this,a.getMessage());
	}

	}
	}


