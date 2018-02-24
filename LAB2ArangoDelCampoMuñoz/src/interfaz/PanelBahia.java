package interfaz;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PanelBahia extends JPanel implements ActionListener{

	private static final String VER_SIGUIENTE = "Ver Siguiente";
	private static final String INGRESAR_DATOS = "IngresarDatos";
	private static final String VER_SIMULACION = "Ver Simulación";
	private static final String VER_VEHICULOS = "Vehiculos";
	
	private JButton butVerSimulacion;
	private JButton butIngresarDatos;
	private JButton butVerSiguiente;
	private JButton butVerVehiculos;
	private InterfazParqueadero ppal;
	
	public PanelBahia (InterfazParqueadero inter) {
		ppal = inter;
		butVerSiguiente = new JButton(VER_SIGUIENTE);
		butVerSiguiente.addActionListener(this);
		butVerSiguiente.setActionCommand(VER_SIGUIENTE);
		
		butIngresarDatos = new JButton(INGRESAR_DATOS);
		butIngresarDatos.addActionListener(this);
		butIngresarDatos.setActionCommand(INGRESAR_DATOS);
		butVerSimulacion = new JButton(VER_SIMULACION);
		butVerSimulacion.addActionListener(this);
		butVerSimulacion.setActionCommand(VER_SIMULACION);
		butVerVehiculos = new JButton(VER_VEHICULOS);
		butVerVehiculos.addActionListener(this);
		butVerVehiculos.setActionCommand(VER_VEHICULOS);
		setLayout(new BorderLayout());
		JLabel labBahia = new JLabel();
		ImageIcon img = new ImageIcon(Toolkit.getDefaultToolkit().getImage("Img/bahia.PNG"));
		labBahia.setIcon(img);
		add(butVerSimulacion, BorderLayout.NORTH);
		add(butIngresarDatos, BorderLayout.SOUTH);
		add(butVerSiguiente, BorderLayout.EAST);
		add(butVerVehiculos, BorderLayout.WEST);
		add(labBahia, BorderLayout.CENTER);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("Numero de carros", 60, 60);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}