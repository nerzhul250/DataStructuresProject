package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import mundo.DBMS;

public class FrameBase extends JFrame {
	PanelBotones panelButones;
	PanelDatos panelDatos;
	DBMS mundo;
	
	public FrameBase(){
	mundo=new DBMS();
	setLayout(new BorderLayout());
	panelButones=new PanelBotones(this);
	panelDatos=new PanelDatos();
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	add(panelDatos,BorderLayout.CENTER);
	add(panelButones,BorderLayout.SOUTH);
	pack();
}
	
	public void lectorArchivo(File a) {
		mundo.cargarTabla(a);	
	}
	public void definirArboles(int c1,int c2,int c3) throws IOException {
		mundo.definirCamposRapidos(c1,c2, c3);
	}
	public static void main(String[] args) {
		FrameBase inter=new FrameBase();
		inter.setVisible(true);

	}

}
