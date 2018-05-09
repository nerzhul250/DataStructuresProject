package world;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class UnionFind{
	private int[] parent;
	public UnionFind(int numberVertices) {
		parent=new int[numberVertices];
		for (int i = 0; i < parent.length; i++) {
			parent[i]=i;
		}
	}
	public int find(int x) {
		if (parent[x] == x) {
			return x;
		} else {
			parent[x] = find(parent[x]);
			return parent[x];
		}
	}
	public void unite(int x, int y) {
		parent[find(x)] = find(y);
	}
}
class ObjComparator<E extends Comparable<E>> implements Comparator<Object[]>{
	@Override
	public int compare(Object[] o1, Object[] o2) {
		E a=(E)o1[0];
		E b=(E)o2[0];
		return a.compareTo(b);
	}
}
public class GraphAlgorithm<V,E extends Comparable<E>> {

	/**
	 * <pos>:g is unchanged
	 * @param g
	 * return an IGraph containing the vertices and edges from g with the ancestors formed by the BFS
	 */
	public IGraph<V,E> bfs(IGraph<V,E> g,V value) {
		GraphList<V,E> bfsTree=new GraphList<V,E>(true);
		ArrayList<Object[]> edges=g.getEdges();
		for (int i = 0; i < edges.size(); i++) {
			bfsTree.addEdge((E)edges.get(i)[0],(V)edges.get(i)[1],(V)edges.get(i)[2]);	
		}
		LinkedList<Vertex<V,E>>queue=new LinkedList<Vertex<V,E>>();
		Vertex<V,E> init=bfsTree.getVertex(value);
		init.setColor(1);
		queue.addFirst(init);
		while(!queue.isEmpty()) {
			Vertex<V,E> u=queue.removeLast();
			Iterator<Vertex<V,E>> it=u.neighborIterator();
			while(it.hasNext()) {
				Vertex<V,E> v=it.next();
				if(v.getColor()==0) {
					v.setAncestor(u);
					v.setColor(1);
					queue.addFirst(v);
				}
			}
		}
		return bfsTree;
	}
	/**
	 * <pos>:g is unchanged
	 * @param g
	 * return and IGraph containing the ancestors Formed by the dfs
	 */
	public IGraph<V,E> dfs(IGraph<V, E> g) {
		GraphList<V,E> dfsTree=new GraphList<V,E>(true);
		ArrayList<Object[]> edges=g.getEdges();
		for (int i = 0; i < edges.size(); i++) {
			dfsTree.addEdge((E)edges.get(i)[0],(V)edges.get(i)[1],(V)edges.get(i)[2]);	
		}
		Iterator<V>it=dfsTree.valuesIterator();
		while(it.hasNext()) {
			Vertex<V,E> init=dfsTree.getVertex(it.next());
			if(init.getColor()==0) {
				LinkedList<Vertex<V,E>>pile=new LinkedList<Vertex<V,E>>();
				init.setColor(1);
				pile.push(init);
				while(!pile.isEmpty()) {
					Vertex<V,E> u=pile.pop();
					Iterator<Vertex<V,E>> it2=u.neighborIterator();
					while(it.hasNext()) {
						Vertex<V,E> v=it2.next();
						if(v.getColor()==0) {
							v.setAncestor(u);
							v.setColor(1);
							pile.push(v);
						}
					}
				}
			}
		}
		return dfsTree;
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
	 * <pos>:g is unchanged
	 * @param g
	 * return the minimum spanning tree of g made by kruskal
	 */
	public IGraph<V,E> kruskal(IGraph<V, E> g) {
		GraphList<V,E>MSTKruskal=new GraphList<V,E>(true);
		ArrayList<Object[]> ed=g.getEdges();
		HashMap<V,Integer>valToInt=new HashMap<V,Integer>();
		Collections.sort(ed,new ObjComparator<E>());
		int actVal=0;
		UnionFind uf=new UnionFind(g.getNumberOfVertices());
		for (int i = 0; i < ed.size(); i++) {
			V a=(V) ed.get(i)[1];
			V b=(V) ed.get(i)[2];
			int aa=0;
			int bb=0;
			if(!valToInt.containsKey(a)) {
				valToInt.put(a,actVal);
				aa=actVal;
				actVal++;
			}else {
				aa=valToInt.get(a);
			}
			if(!valToInt.containsKey(b)) {
				valToInt.put(b,actVal);
				bb=actVal;
				actVal++;
			}else {
				bb=valToInt.get(b);
			}
			if(uf.find(aa)!=uf.find(bb)) {
				MSTKruskal.addEdge((E)ed.get(i)[0],(V)ed.get(i)[1],(V)ed.get(i)[2]);	
				uf.unite(aa,bb);
			}
		}
		return MSTKruskal;
	}

	/**
	 * <pos>: g is unchanged
	 * @param g
	 * return an IGraph representing the minimum spanning tree of g made by prim
	 */
	public IGraph<V,E> prim(IGraph<V, E> g) {
		// TODO - implement GraphAlgorithm.prim
		throw new UnsupportedOperationException();
	}

}