package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import algoritmo.Multiplicacion;

public class InterfazMultiplicacion extends JFrame{
	
	private Multiplicacion mundo;
	
	private PanelVisualizacion pv;
	private PanelOpcion po;
	
	public InterfazMultiplicacion(){
		setTitle("MultiPliDynamic");
		setLayout(new BorderLayout());
		
		mundo=new Multiplicacion();
		po=new PanelOpcion();
		pv=new PanelVisualizacion();
		
		
		JScrollPane scroll=new JScrollPane(pv);
		scroll.setPreferredSize(new Dimension(1150,600));
		
		add(scroll,BorderLayout.NORTH);
		add(po,BorderLayout.SOUTH);
		pack();
	}
	
	public static void main(String[] args) {
		InterfazMultiplicacion mg=new InterfazMultiplicacion();
		mg.setVisible(true);
		mg.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
