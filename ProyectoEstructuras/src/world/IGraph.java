package world;

import java.util.ArrayList;

public interface IGraph<V, E> {

	/**
	 * 
	 * @param e
	 * @param v1
	 * @param v2
	 */
	boolean addEdge(E e, V v1, V v2);
	ArrayList<V> getVertices();
	ArrayList<Object[]> getEdges();
}