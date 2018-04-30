package world;

public interface IGraph<V, E> {

	/**
	 * 
	 * @param e
	 * @param v1
	 * @param v2
	 */
	boolean addEdge(E e, V v1, V v2);

}