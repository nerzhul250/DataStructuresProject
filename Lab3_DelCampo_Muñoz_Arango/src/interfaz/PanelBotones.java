package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PanelBotones extends JPanel implements ActionListener{
	
	public final static String CARGAR="cargar";
	public final static String CONSULTAR="CONSULTAR";
	public final static String NUEVA_CONSULTA="consulta nueva";
	
	JButton butonCrgar;
	FrameBase frame;
	JTextField opc1;
	JTextField opc2;
	JTextField opc3;
	JPanel aux;
	
	JPanel panelBusqueda;
	JTextField txtBuscar;
	JButton btbBuscar;
	
	public PanelBotones(FrameBase frame) {
		setLayout(new BorderLayout());
		panelCargar();	
	}


	


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(CARGAR)) {
			 JFileChooser chooser = new JFileChooser();
			    FileNameExtensionFilter filter = new FileNameExtensionFilter("XLS or cvs only","XLSX", "XLS", "csv");
			    chooser.setFileFilter(filter);
			    int returnVal = chooser.showOpenDialog(getParent());
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			       JOptionPane.showMessageDialog(this, "You chose to open this file: " +
			            chooser.getSelectedFile().getName());
			       
			       try {
					frame.definirArboles(Integer.parseInt(opc1.getText()), Integer.parseInt(opc2.getText()), Integer.parseInt(opc3.getText()));
					frame.lectorArchivo(chooser.getSelectedFile());
					 panelBuscar();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Debe indicar el NUMERO de una columna valida ", "Error al digitar los datos", JOptionPane.ERROR_MESSAGE, null);
					panelCargar();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Debe indicar el NUMERO de una columna valida ", "Error al digitar los datos", JOptionPane.ERROR_MESSAGE, null);
					panelCargar();
				}catch(Exception e10 ) {
					JOptionPane.showMessageDialog(null,"Un error fatal ha ocurrido"+"\n"+" tenemos un grupo de simios trabajando para solucionaro"+"\n"+"si los ves muestrales esto вѣдиглагольживѣтекраткойюсъ большой іотированныйюсъ малый іотированный", "Error al digitar los datos", JOptionPane.ERROR_MESSAGE, null);
					panelCargar();
			      }
			      
			       
			    }
			    
			    
			    
		}else if(e.getActionCommand().equals(CONSULTAR)){
			
			
			
			
			
		}else if(e.getActionCommand().equals(NUEVA_CONSULTA)) {
			panelCargar();
		}
		
	}
	public void panelBuscar() {
		this.removeAll();
		JButton cargarnew=new JButton("Cargar Nuevo Archivo");
		cargarnew.addActionListener(this);
		cargarnew.setActionCommand(NUEVA_CONSULTA);
		
		 panelBusqueda=new JPanel();
		 txtBuscar=new JTextField();
		 
		 btbBuscar=new JButton("Buscar");
		 btbBuscar.addActionListener(this);
		 btbBuscar.setActionCommand(CONSULTAR);
		 
		 panelBusqueda.setLayout(new GridLayout(1,3));
		 panelBusqueda.add(btbBuscar);
		 panelBusqueda.add(txtBuscar);
		 panelBusqueda.add(cargarnew);
		 add(panelBusqueda,BorderLayout.CENTER);
		 repaint();
		 revalidate();
		 
	}
	public void panelCargar() {
		this.removeAll();
		aux=new JPanel();
		aux.setLayout(new GridLayout(2,3));
		opc1=new JTextField("1");
		opc2=new JTextField("2");
		opc3=new JTextField("3");
		 
		JLabel aux1=new JLabel("llamado rapido 1");
		JLabel aux2=new JLabel("llamado rapido 2");
		JLabel aux3=new JLabel("llamado rapido 3");
		
		
		butonCrgar=new JButton("Cargar");
		aux.add(aux1);
		aux.add(aux2);
		aux.add(aux3);
		aux.add(opc1);
		aux.add(opc2);
		aux.add(opc3);
		
		
		
		butonCrgar.addActionListener(this);
		butonCrgar.setActionCommand(CARGAR);
		
		setLayout(new GridLayout(1,3));
		add(butonCrgar,BorderLayout.EAST);
		add(aux,BorderLayout.CENTER);
		repaint();
		revalidate();
		
		
	}

}
