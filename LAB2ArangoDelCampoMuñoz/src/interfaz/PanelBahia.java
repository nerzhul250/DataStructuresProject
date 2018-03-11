package interfaz;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DebugGraphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import mundo.Bahia;
import tablasHash.TablaHashEncadenada;

public class PanelBahia extends JPanel implements ActionListener{

	private static final String VER_SIMULACION = "Ver Simulación";
	private static final String VER_VEHICULOS = "Ver Vehículos por Bahía";
	
	private JButton butVerSimulacion;
	private JLabel[][] labBahias;
	private JButton butVerVehiculos;
	private InterfazParqueadero ppal;
	private int[] cantidadesBahia;
	private Bahia[] bahiasMoves;
	private int parqueaderoActual;
	
	public PanelBahia (InterfazParqueadero inter) {
		ppal = inter;
		butVerSimulacion = new JButton(VER_SIMULACION);
		butVerSimulacion.addActionListener(this);
		butVerSimulacion.setActionCommand(VER_SIMULACION);
		butVerVehiculos = new JButton(VER_VEHICULOS);
		butVerVehiculos.addActionListener(this);
		butVerVehiculos.setActionCommand(VER_VEHICULOS);
		cantidadesBahia = new int[2];
		add(butVerSimulacion, BorderLayout.NORTH);
		add(butVerVehiculos, BorderLayout.WEST);
		parqueaderoActual = 0;
	}
	public void mostrarDatosBahia() {
		removeAll();
		setLayout(new GridLayout(cantidadesBahia.length/2 + 2, 4));
		add(butVerSimulacion, BorderLayout.NORTH);
		add(butVerVehiculos, BorderLayout.WEST);
		add(new JLabel("En Observación:"));
		add(new JLabel(""+parqueaderoActual));
		labBahias = new JLabel[cantidadesBahia.length/2][4];
		add(new JLabel("Bahía #"));
		add(new JLabel("Estacionados"));
		add(new JLabel("En ovalo"));
		add(new JLabel("Movimientos"));
		for (int i = 1; i <= labBahias.length; i++) {
			for (int j = 0; j < labBahias[0].length; j++) {
				if(j == 0)
					labBahias[i-1][j] = new JLabel(""+i);
				else
					labBahias[i-1][j] = new JLabel(0 +"");
					add(labBahias[i-1][j]);
			}
		}
	}

	public void actualizar() {
		for (int j = 1; j < labBahias[0].length; j++) {
			for (int i = 0; i < labBahias.length; i++) {
				if(j==1)
				labBahias[i][j].setText(cantidadesBahia[i] + "");
				if(j==2)
					labBahias[i][j].setText(cantidadesBahia[i + labBahias.length] + "");
				if(j==3)
					labBahias[i][j].setText(bahiasMoves[i].getCarrosMovidos() + "");
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String c = e.getActionCommand();
		if(c.equals(VER_SIMULACION))
			ppal.verSimulacion();
	}
	public void actualizarTabla(int[]cantidadesBahias, Bahia[] bahias, int parqueadero) {
		cantidadesBahia = cantidadesBahias;
		bahiasMoves = bahias;
		parqueaderoActual = parqueadero;
		mostrarDatosBahia();
	}
	
}