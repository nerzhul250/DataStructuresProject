package world;

import java.util.ArrayList;

public class GraphAlgorithm<V,E> {

	/**
	 * 
	 * @param g
	 */
	public IGraph<V,E> bfs(IGraph<V,E> g,V v) {
		//Igraph a GraphList
		GraphList<V,E> elGrafo=new GraphList<V,E>(true);
		ArrayList<Object[]> edges=g.getEdges();
		for (int i = 0; i < edges.size(); i++) {
			elGrafo.addEdge((E)edges.get(i)[0],(V)edges.get(i)[1],(V)edges.get(i)[2]);	
		}
		
		
		//BFS
		
		
		IGraph<V,E> retorno=elGrafo;
		return retorno;
	}

	/**
	 * 
	 * @param g
	 */
	public IGraph<V,E> dfs(IGraph<V, E> g) {
		// TODO - implement GraphAlgorithm.dfs
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param g
	 */
	public IGraph<V,E> dijkstra(IGraph<V, E> g) {
		// TODO - implement GraphAlgorithm.dijkstra
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param g
	 */
	public IGraph<V,E> floydWarshall(IGraph<V, E> g) {
		//Igraph a GraphList
		GraphMatrix<V,E> elGrafo=new GraphMatrix<V,E>(true);
		ArrayList<Object[]> edges=g.getEdges();
		for (int i = 0; i < edges.size(); i++) {
			elGrafo.addEdge((E)edges.get(i)[0],(V)edges.get(i)[1],(V)edges.get(i)[2]);	
		}
		
		
		//FLOYD
		
		IGraph<V,E> retorno=elGrafo;
		return retorno;
	}

	/**
	 * 
	 * @param g
	 */
	public IGraph<V,E> kruskal(IGraph<V, E> g) {
		// TODO - implement GraphAlgorithm.kruskal
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param g
	 */
	public IGraph<V,E> prim(IGraph<V, E> g) {
		// TODO - implement GraphAlgorithm.prim
		throw new UnsupportedOperationException();
	}

}