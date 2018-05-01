package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import world.Domain;
import world.Web;

public class WebGUI extends JFrame {
	
	private GraphVisualizationPane gvp;
	private OptionPane op;
	private Web world;
	
	public WebGUI() {
		setTitle("WEBSCRAPPER");
		setLayout(new BorderLayout());
		
		world=new Web();
		gvp=new GraphVisualizationPane();
		op=new OptionPane(this);
		op.refreshDomainList(world.getDomains());
		
		add(new JScrollPane(gvp),BorderLayout.CENTER);
		add(op,BorderLayout.EAST);
		pack();
		refreshCompleteGraph();
	}
	    
	public static void main(String[] args) {
		WebGUI wg=new WebGUI();
		wg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wg.setVisible(true);
	}

	public void refreshCompleteGraph() {
		ArrayList<String> doms=new ArrayList<String>();
		ArrayList<String[]> links= new ArrayList<String[]>();
		ArrayList<Object[]> objs=world.getLinks();
		ArrayList<Domain> domains=world.getDomains();
		for (int i = 0; i < domains.size(); i++) {
			doms.add(domains.get(i).toString());
		}
		
		for (int i = 0; i < objs.size(); i++) {
			String[] A=new String[3];
			Object[] o=objs.get(i);
			A[0]=((String)o[0]);
			A[1]=((Domain)o[1]).toString();
			A[2]=((Domain)o[2]).toString();
			links.add(A);
		}
		gvp.remakeGraph(doms,links);
	}

	public void findShortestPath(Domain or, Domain des ) {
		// TODO Auto-generated method stub
		
	}

	public void findCycles(Domain start) {
		// TODO Auto-generated method stub
		
	}

	public void expandGraph(Domain start, int depth) {
		try {
			HashSet<String> hs=new HashSet<String>(); 
			int a=world.expandGraph(start,start.getURL(), depth,hs);
			JOptionPane.showMessageDialog(this,"Se han agregado "+a+" Nuevas conexiones");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		op.refreshDomainList(world.getDomains());
		refreshCompleteGraph();
	}

	public void changeGraphImplementation() {
		world.changeGraphImplementation();
	}

	public void refreshGraphOf(Domain selectedValue) {
		// TODO Auto-generated method stub
		
	}

}