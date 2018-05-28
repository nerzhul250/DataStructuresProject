package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import org.jsoup.HttpStatusException;

import world.Domain;
import world.GraphList;
import world.IGraph;
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
		drawGraph(world.getGraph());
	}
	    
	public static void main(String[] args) {
		WebGUI wg=new WebGUI();
		wg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		wg.setVisible(true);
	}

	public void drawGraph(IGraph<Domain,String> g) {
		
		ArrayList<String> doms=new ArrayList<String>();
		ArrayList<String[]> links= new ArrayList<String[]>();
		ArrayList<Object[]> objs=g.getEdges();
		ArrayList<Domain> domains=g.getValues();
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
		IGraph<Domain, String> shortest=world.findShortestPath(or, des);
		ArrayList<Domain> route =  shortest.getValues();
		op.refreshDomainList(shortest.getValues());
		drawGraph(shortest);
		JOptionPane.showMessageDialog(this, "el camino de "+or.getName()+" hasta "+des.getName()+" es "+"\n"+world.organizador(route.toString()));
	}

	public void findCycles(Domain start) {
		GraphList<Domain, String> cycleDomains = (GraphList<Domain, String>) world.cyclesOf(start);
		op.refreshDomainList(cycleDomains.getValues());
		drawGraph(cycleDomains);
		JOptionPane.showMessageDialog(this, "Los Dominios con los que " + start.getName() + " forma ciclos, son: " + cycleDomains.getNumberOfVertices());
	}

	public void expandGraph(Domain start, int depth) {
		try {
			HashSet<String> hs=new HashSet<String>(); 
			int a=world.expandGraph(start,start.getURL(), depth,hs);
			JOptionPane.showMessageDialog(this,"Se han agregado "+a+" Nuevas conexiones");
		}  catch (MalformedURLException e) {
		JOptionPane.showMessageDialog(this, "No se pudo agregar algun(os) de los URL porque no tienen el protocolo http o https", "Se encontraron URL mal formados", JOptionPane.ERROR_MESSAGE);
		} catch (HttpStatusException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
			catch (IOException e1) {
			e1.printStackTrace();
		}
		op.refreshDomainList(world.getDomains());
		drawGraph(world.getGraph());
	}

	public void changeGraphImplementation() {
		String message=world.changeGraphImplementation();
		JOptionPane.showMessageDialog(this, message);
	}

	public void updateList() {
		ArrayList<Domain>dom=world.getDomains();
		System.out.println(dom.size());
		op.refreshDomainList(dom);
	}

}