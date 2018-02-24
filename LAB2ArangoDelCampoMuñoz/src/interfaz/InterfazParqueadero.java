package interfaz;

import javax.swing.JFrame;

import mundo.Parqueadero;

public class InterfazParqueadero extends JFrame {

	private PanelBahia bahia;
	private Parqueadero parking;
	public InterfazParqueadero ()  {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		bahia = new PanelBahia(this);
		add(bahia);
		pack();
//		setSize(500, 500);
	}
	public static void main(String[] args) {
		InterfazParqueadero i = new InterfazParqueadero();
		i.setVisible(true);
	}

}
