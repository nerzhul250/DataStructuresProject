package interfaz;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class PanelDatos extends JPanel{
	
	
	private JTable tabla;
	private JScrollPane JS;
	
	public  PanelDatos(String[][] a, String[]b) {
		 tabla=new JTable(a,b); 
		  JS=new JScrollPane(tabla);
		  JS.setPreferredSize(new Dimension(b[0].length()*275,150));
		 add(JS);
		
	}
	

}
