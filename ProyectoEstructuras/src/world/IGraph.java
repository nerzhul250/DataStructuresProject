package world;

import java.util.ArrayList;

public interface IGraph<V, E> {

	/**
	 * 
	 * @param e edge's label
	 * @param v1 value of origin vertex
	 * @param v2 value of destine vertex
	 */
	public boolean addEdge(E e, V v1, V v2);
	/**
	 * 
	 * @param v value of vertex to ve added
	 * @return true if vertex with value v was added to the graph, false otherwise
	 */
	public boolean addVertex(V v);
	/**
	 * @return list containing all values representing vertices in the graph
	 */
	public ArrayList<V> getValues();
	/**
	 * 
	 * @return list of arrays of the following form
	 * Obj[] ={e,v1,v2}, where e is of type E, v1 and v2 are of type V
	 * each Obj[] represents an edge
	 */
	public ArrayList<Object[]> getEdges();
	/**
	 * 
	 * @param v1 vertex 1
	 * @param v2 vertex 2
	 * @return the object e of type E representing the label of an edge that connect vertices
	 * v1 and v2, null if the edge does not exist
	 */
	public E getLabel(V v1,V v2);
	/**
	 * 
	 * @param v
	 * @return list of values representing the neighbors of the vertex represented by v
	 */
	public ArrayList<V> getNeighbors(V v);
	/**
	 * 
	 * @param v1
	 * @param v2
	 * @return true if there is an edge between v1 and v2
	 */
	public boolean isThereEdge(V v1,V v2);
	/**
	 * 
	 * @return true if directed, false otherwise
	 */
	public boolean isUndirected();
	public int getNumberOfVertices();
	public IGraph<V,E> transformToMyOpposite();
}