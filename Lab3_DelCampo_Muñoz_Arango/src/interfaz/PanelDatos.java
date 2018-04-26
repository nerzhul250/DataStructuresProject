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
		 tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		 JS=new JScrollPane(tabla,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		 add(JS);		
	}
	

}
