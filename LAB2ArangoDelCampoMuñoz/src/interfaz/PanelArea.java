package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PanelArea extends JPanel implements ActionListener{
	private static final String INGRESAR_DATOS = "Ingresar Datos";
	/**
	 * Área de texto para la entrada
	 */
	private JTextArea a;
	private JButton butIngresarDatos;
	private InterfazParqueadero in;
	public PanelArea(InterfazParqueadero i) {
		in=i;
		setLayout(new BorderLayout());
		a=new JTextArea("Ingresa el caso de prueba");
		butIngresarDatos = new JButton(INGRESAR_DATOS);
		butIngresarDatos.addActionListener(this);
		butIngresarDatos.setActionCommand(INGRESAR_DATOS);
		add(new JScrollPane(a),BorderLayout.CENTER);
		add(butIngresarDatos,BorderLayout.SOUTH);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		in.sendInfo(a.getText(), false);
	}
	public String pedirInfo() {
		return a.getText();
	}
}
