package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mundo.DBMS;

public class FrameBase extends JFrame {
	private PanelBotones panelButones;
	private PanelDatos panelDatos;
	private DBMS mundo;
	
	
	public FrameBase(){
	mundo=new DBMS();
	setLayout(new BorderLayout());
	panelButones=new PanelBotones(this);

	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	add(panelButones,BorderLayout.SOUTH);
	pack();
}
	public String[] getTitulos() {
		return mundo.getCampos();
	}
	public void lectorArchivo(File a) {
		
		mundo.cargarTabla(a);
		try {
			panelDatos=new PanelDatos(theMatrixTimeHasCome(),getTitulos());
			add(panelDatos,BorderLayout.CENTER);
			pack();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "c mamo");
		}
	}
	public void definirArboles(int c1,int c2,int c3) throws IOException {
		mundo.definirCamposRapidos(c1,c2, c3);
	}
	public ArrayList<String[]> buscar(int columna,String llave) throws IOException {
		return mundo.consulta(columna, llave);
	}
	public static void main(String[] args) {
		FrameBase inter=new FrameBase();
		inter.setVisible(true);

	}
	public String[][] theMatrixTimeHasCome() throws IOException{
		return mundo.getMatrix();
	}

}
