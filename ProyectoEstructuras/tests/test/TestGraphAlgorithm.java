package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import world.GraphAlgorithm;
import world.GraphList;
import world.Vertex;

class TestGraphAlgorithm {
	
	private GraphAlgorithm ga;
	
	private void setUpEscenario1() {
		ga=new GraphAlgorithm<Integer,Integer>();
	}
	
	@Test
	public void testBFS() {
		setUpEscenario1();
		//GRAPHLIST UNDIRECTED
		GraphList<Integer,Integer> grafo=new GraphList<>(true);
		grafo.addEdge(1,1,2);
		grafo.addEdge(1,3,2);
		grafo.addEdge(1,4,3);
		grafo.addEdge(1,4,5);
		grafo.addEdge(1,4,6);
		grafo.addEdge(1,5,6);
		grafo.addEdge(1,6,1);
		grafo.addEdge(1,6,7);
		grafo.addEdge(1,6,8);
		grafo.addEdge(1,7,8);
		grafo.addEdge(1,1,8);
		grafo=(GraphList<Integer, Integer>) ga.bfs(grafo,2);
		Vertex<Integer,Integer>v=grafo.getVertex(7);
		int[] ans= {7,8,1,2};
		int i=0;
		while(v!=null) {
			assert(v.getValue()==ans[i]);
			v=v.getAncestor();
			i++;
		}
	}
	
	@Test
	public void testDFS() {
		setUpEscenario1();
		//GRAPHLIST UNDIRECTED
		GraphList<Integer,Integer> grafo=new GraphList<>(true);
		grafo.addEdge(1,1,2);
		grafo.addEdge(1,3,2);
		grafo.addEdge(1,4,3);
		grafo.addEdge(1,4,5);
		grafo.addEdge(1,4,6);
		grafo.addEdge(1,5,6);
		grafo.addEdge(1,6,1);
		grafo.addEdge(1,6,7);
		grafo.addEdge(1,6,8);
		grafo.addEdge(1,7,8);
		grafo.addEdge(1,1,8);
		grafo=(GraphList<Integer, Integer>) ga.dfs(grafo);
		Vertex<Integer,Integer>v=grafo.getVertex(5);
		int[] ans= {7,8,1,2};
		int i=0;
		while(v!=null) {
			System.out.println(v.getValue());
			v=v.getAncestor();
			i++;
		}
	}

}
