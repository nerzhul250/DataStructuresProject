package world;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphMatrix<V, E> implements IGraph<V,E> {

	private ArrayList<E>[][] edges;
	private HashMap<Integer, V> graph;
	private HashMap<V, Integer> aux;

	public GraphMatrix() {
		// TODO - implement GraphMatrix.GraphMatrix
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean addEdge(Object e, Object v1, Object v2) {
		// TODO Auto-generated method stub
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
	public ArrayList<V> getVertices() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ArrayList<Object[]> getEdges() {
		// TODO Auto-generated method stub
		return null;
	}

}