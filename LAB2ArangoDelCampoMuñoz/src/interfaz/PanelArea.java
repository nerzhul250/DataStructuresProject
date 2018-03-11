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

public class PanelArea extends JPanel{
	/**
	 * Área de texto para la entrada
	 */
	private JTextArea a;
	private InterfazParqueadero in;
	public PanelArea(InterfazParqueadero i) {
		in=i;
		setLayout(new BorderLayout());
		a=new JTextArea("Ingresa el caso de prueba");
		add(new JScrollPane(a),BorderLayout.CENTER);
	}

	public String pedirInfo() {
		return a.getText();
	}
}
