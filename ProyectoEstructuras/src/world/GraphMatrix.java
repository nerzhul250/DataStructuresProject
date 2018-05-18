package world;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphMatrix<V, E> implements IGraph<V,E> {
	
	boolean undirected;
	/**
	 * There are no nulls in edges.
	 */
	private ArrayList<E>[][] edges;
	private HashMap<Integer, V> intToValue;
	private HashMap<V, Integer> valueToint;

	public GraphMatrix(boolean un) {
		undirected=un;
		for (int i = 0; i < edges.length; i++) {
			for (int j = 0; j < edges.length; j++) {
				edges[i][j]=new ArrayList<E>();
			}
		}
	}
	@Override
	public boolean addEdge(Object e, Object v1, Object v2) {
		return false;
	}
	/**
	 * 
	 * @param v
	 */
	public V getValue(int v) {
		// TODO - implement GraphMatrix.getValue
		throw new UnsupportedOperationException();
	}

	public ArrayList<E>[][] getEdgesArray() {
		return this.edges;
	}

	/**
	 * 
	 * @param v
	 */
	public int getInteger(V v) {
		// TODO - implement GraphMatrix.getInteger
		throw new UnsupportedOperationException();
	}
	@Override
	public ArrayList<V> getValues() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Object[]> getEdges() {
		// TODO Auto-generated method stub
		return null;
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
		int i=valueToint.get(v1);
		int j=valueToint.get(v2);
		return !edges[i][j].isEmpty();
	}
	@Override
	public boolean isUndirected() {
		return undirected;
	}
	@Override
	public int getNumberOfVertices() {
		return edges.length;
	}

}