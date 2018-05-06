package world;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class GraphList<V, E> implements IGraph<V,E> {
	
	
	private boolean undirected;
	
	private HashMap<V,Vertex<V,E>>graph;
	private HashSet<Edge<V,E>>edges;
	
	public GraphList(boolean un) {
		graph=new HashMap<V,Vertex<V,E>>();
		edges=new HashSet<Edge<V,E>>();
		undirected=un;
	}
	
	@Override
	public boolean addEdge(E e, V v1, V v2) {
		Vertex<V,E> v11=null;
		Vertex<V,E> v22=null;
		if(graph.containsKey(v1)) {
			v11=graph.get(v1);
		}else {
			v11=new Vertex<V,E>(v1);
			graph.put(v1,v11);
		}
		if(graph.containsKey(v2)) {
			v22=graph.get(v2);
		}else {
			v22=new Vertex<V,E>(v2);	
			graph.put(v2,v22);
		}
		if(v11.containsEdge(e,v22)) {
			return false;
		}else {
			Edge<V,E> edge1=new Edge<V,E>(e,v11,v22);
			v11.addEdge(edge1,v22);
			edges.add(edge1);
			if(undirected) {
				Edge<V,E> edge2=new Edge<V,E>(e,v22,v11);
				v22.addEdge(edge2,v11);				
			}
			return true;
		}
	}

	public Iterator<V> valuesIterator() {
		return graph.keySet().iterator();
	}

	/**
	 * 
	 * @param v
	 */
	public Vertex<V, E> getVertex(V v) {
		return graph.get(v);
	}

	@Override
	public ArrayList<V> getVertices() {
		ArrayList<V>vers=new ArrayList<V>();
		Iterator<V>it=valuesIterator();
		while(it.hasNext()) {
			vers.add(it.next());
		}
		return vers;
	}

	@Override
	public ArrayList<Object[]> getEdges() {
		ArrayList<Object[]>A=new ArrayList<Object[]>(); 
		Iterator<Edge<V,E>>edgy=edges.iterator();
		while(edgy.hasNext()) {
			Edge<V,E> e=edgy.next();
			Object[] E=new Object[3];
			E[0]=e.getLabel();
			E[1]=e.getOrigin().getValue();
			E[2]=e.getEnding().getValue();
			A.add(E);
		}
		return A;
	}

	@Override
	public boolean addVertex(V v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E getLabel(V v1, V v2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<V> getNeighbors(V v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isThereEdge(V v1, V v2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDirected() {
		return !undirected;
	}

}