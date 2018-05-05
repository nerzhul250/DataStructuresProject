package world;

import java.util.ArrayList;

public interface IGraph<V, E> {

	/**
	 * 
	 * @param e
	 * @param v1
	 * @param v2
	 */
	public boolean addEdge(E e, V v1, V v2);
	public boolean addVertex(V v);
	public ArrayList<V> getVertices();
	public ArrayList<Object[]> getEdges();
	public E getLabel(V v1,V v2);
	public ArrayList<V> getNeighbors(V v);
	public boolean isThereEdge(V v1,V v2);
	public boolean isDirected();
}