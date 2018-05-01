package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import world.Domain;
public class WebGUI extends JFrame {
	
	private GraphVisualizationPane gvp;
	private OptionPane op;
	
	public WebGUI() {
		setTitle("WEBSCRAPPER");
		setLayout(new BorderLayout());
		gvp=new GraphVisualizationPane();
		op=new OptionPane(this);
		
		add(gvp,BorderLayout.CENTER);
		add(op,BorderLayout.EAST);
		pack();
	}
	    
	public static void main(String[] args) {
		WebGUI wg=new WebGUI();
		wg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wg.setVisible(true);
	}

	public void refreshGraph(Domain selectedValue) {
		// TODO Auto-generated method stub
		
	}

	public void findShortestPath(Domain selectedValue, String text) {
		// TODO Auto-generated method stub
		
	}

	public void findCycles(Domain selectedValue) {
		// TODO Auto-generated method stub
		
	}

}