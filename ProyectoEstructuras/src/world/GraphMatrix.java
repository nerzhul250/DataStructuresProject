package world;

import java.util.ArrayList;
import java.util.HashMap;

public class GraphMatrix<V, E> implements IGraph<V,E> {
	
	boolean undirected;
	/**
	 * There are no nulls in edges.
	 */
	private ArrayList[][] edges;
	private HashMap<Integer, V> intToValue;
	private HashMap<V, Integer> valueToint;

	public GraphMatrix(boolean un) {
		undirected=un;
		ArrayList[][] edges=new ArrayList[1][1];
		for (int i = 0; i < edges.length; i++) {
			for (int j = 0; j < edges.length; j++) {
				edges[i][j]=new ArrayList<E>();
			}
		}
	}
	@Override
	public boolean addEdge(E e, V v1, V v2) {
		if(!valueToint.containsKey(v1)||!valueToint.containsKey(v2)) {
			expandMatrix();
		}
	edges[valueToint.get(v1)][valueToint.get(v2)].add(e);
		
		return true;
	}
	
	/**
	 * expands matrix in one column
	 */
	public void expandMatrix() {
		ArrayList<E>[][] aux=new ArrayList[edges.length+1][edges.length+1] ;
		
		for (int i = 0; i < aux.length; i++) {
			for (int j = 0; j < aux.length; j++) {
				aux[i][j]=new ArrayList<E>();
			}
		}
		
		for (int i = 0; i < edges.length; i++) {
			for (int j = 0; j < edges.length; j++) {
				aux[i][j]=edges[i][j];
			}
		}
		edges=aux;	
	}
	/**
	 * 
	 * @param v
	 */
	public V getValue(int v) throws Exception{
		// TODO - implement GraphMatrix.getValue
		if(valueToint.containsKey(v)) {
			return intToValue.get(v);
		}throw new Exception("El valor no fue encontrado");
		
	}

	public ArrayList<E>[][] getEdgesArray() {
		return this.edges;
	}

	/**
	 * 
	 * @param v
	 */
	public int getInteger(V v) throws Exception{
		// TODO - implement GraphMatrix.getInteger
		if(valueToint.containsKey(v)) {
			return valueToint.get(v);
		}throw new Exception("El valor no fue encontrado");
			
	}
	@Override
	public ArrayList<V> getValues() {
		// TODO Auto-generated method stub
		ArrayList<V> hi=new ArrayList<V> ();
		for (int i = 0; i < edges.length; i++) {
				 hi.add(intToValue.get(i));
			
		}
		
		return hi;
	}
	@Override
	public ArrayList<Object[]> getEdges() {
		// TODO Auto-generated method stub
		ArrayList<Object[]> aux=new ArrayList<Object[]>();
		int elAux=0;
		for (int i = 0; i < edges.length; i++) {
			 for (int j = 0; j < edges.length; j++) {
				 aux.add(new Object[]{edges[i][j].get(0),intToValue.get(i),intToValue.get(j)});
				elAux++;
			}
			
		}
		return aux;
	}
	@Override
	public boolean addVertex(V v) {
		// TODO Auto-generated method stub
		if(!valueToint.containsKey(v)) {
			this.expandMatrix();
			return true;
		}else
		return false;
	}
	@Override
	public E getLabel(V v1, V v2) {
		
		// TODO Auto-generated method stub
		if(!valueToint.containsKey(v1)||!valueToint.containsKey(v2)) {
			return (E) edges[valueToint.get(v1)][valueToint.get(v2)].get(0);
		}else
			return null;
		
	}
	@Override
	public ArrayList<V> getNeighbors(V v) {
		// TODO Auto-generated method stub
		ArrayList<V>  aux=new ArrayList<V>();
		int a=valueToint.get(v);
		for (int i = 0; i < edges.length; i++) {
			if(edges[a][i].size()!=0) {
				aux.add(intToValue.get(i));
			}
		}
		
		return aux;
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