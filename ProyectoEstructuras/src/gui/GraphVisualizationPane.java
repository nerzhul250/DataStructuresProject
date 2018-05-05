package gui;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import edu.uci.ics.jung.algorithms.layout.KKLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.*;
import edu.uci.ics.jung.visualization.*;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

public class GraphVisualizationPane extends JPanel{
	
	public static final int GRAPHWIDTH=3000;
	public static final int GRAPHHEIGHT=3000;
	
	private Graph<String, String> g;
	private BasicVisualizationServer<String,String> vv;
	
	public GraphVisualizationPane() {
		
		setBorder(new TitledBorder("THEGRAPH"));
		
        g = new SparseMultigraph<String, String>();
        for (int i = 0; i < 3; i++) {
        	g.addVertex(i+"");
		}
        g.addEdge("Edge-A", "1", "2");
        g.addEdge("Edge-B", "2", "1");
        g.addEdge("Edge-C", "2", "2");
        g.addEdge("Edge-D", "0", "1");
        g.addEdge("Edge-E", "0","2");
        g.addEdge("Edge-F", "1", "1");
        
        
		Layout<String, String> layout = new KKLayout(g);
		layout.setSize(new Dimension(GRAPHWIDTH,GRAPHHEIGHT));
		
		vv =new BasicVisualizationServer<String,String>(layout);
		vv.setPreferredSize(new Dimension(GRAPHWIDTH,GRAPHHEIGHT));
		vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
		
		add(vv);
	}
	
	public void remakeGraph(ArrayList<String>vertices,ArrayList<String[]>edges) {
		
		Iterator<String>it=g.getEdges().iterator();
		ArrayList<String>jas=new ArrayList<String>(); 
		while(it.hasNext()) {
			jas.add(it.next());
		}
		it=g.getVertices().iterator();
		for (int i = 0; i < jas.size(); i++) {
			g.removeEdge(jas.get(i));
		}
		
		jas=new ArrayList<String>();
		while(it.hasNext()) {
			jas.add(it.next());
		}
		it=null;
		for (int i = 0; i < jas.size(); i++) {
			g.removeVertex(jas.get(i));
		}		
		
		for (int i = 0; i < vertices.size(); i++) {
			g.addVertex(vertices.get(i));
		}
		for (int i = 0; i < edges.size(); i++) {
			String[] A=edges.get(i);
			int a=0;
			while(g.containsEdge(A[0]+"_"+a)) {
				a++;
			}
			g.addEdge(A[0]+"_"+a,A[1],A[2]);
		}
		vv.repaint();
		vv.revalidate();
	}

}

//KKLayout - The Kamada-Kawai algorithm for node layout
//FRLayout - The Fruchterman-Rheingold algorithm
//SpringLayout - A simple force-directed spring-embedder
//ISOMLayout - Meyer's "Self-Organizing Map" layout.
//CircleLayout - A simple layout places vertices randomly on a circle
