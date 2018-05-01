package gui;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import edu.uci.ics.jung.algorithms.layout.KKLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

public class GraphVisualizationPane extends JPanel{
	
	public static final int WIDTH=1200;
	public static final int HEIGHT=650;
	
	private Graph<String, String> g;
	
	public GraphVisualizationPane() {
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
		layout.setSize(new Dimension(WIDTH,HEIGHT));
		
		BasicVisualizationServer<String,String> vv =new BasicVisualizationServer<String,String>(layout);
		vv.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		vv.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
		vv.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
		
		add(vv);
	}
	
	public void remakeGraph(ArrayList<String>vertices,ArrayList<String[]>edges) {
		Iterator<String>vers=g.getVertices().iterator();
		Iterator<String>edgs=g.getEdges().iterator();
		while(edgs.hasNext()) {
			g.removeEdge(edgs.next());
		}
		while(vers.hasNext()) {
			g.removeVertex(vers.next());
		}
		for (int i = 0; i < vertices.size(); i++) {
			g.addVertex(vertices.get(i));
		}
		for (int i = 0; i < edges.size(); i++) {
			String[] A=edges.get(i);
			g.addEdge(A[2],A[0],A[1]);
		}
	}

}

//KKLayout - The Kamada-Kawai algorithm for node layout
//FRLayout - The Fruchterman-Rheingold algorithm
//SpringLayout - A simple force-directed spring-embedder
//ISOMLayout - Meyer's "Self-Organizing Map" layout.
//CircleLayout - A simple layout places vertices randomly on a circle
