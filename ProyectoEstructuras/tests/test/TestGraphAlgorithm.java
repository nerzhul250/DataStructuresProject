package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import auxiliarDataStructures.CommutativePair;
import world.GraphAlgorithm;
import world.GraphList;
import world.Vertex;

class TestGraphAlgorithm {
	
	private GraphAlgorithm ga;
	
	private void setUpEscenario1() {
		ga=new GraphAlgorithm<Integer,Integer>();
	}
	private void setUpEscenario2() {
		ga=new GraphAlgorithm<String,Integer>();
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
		//GRAPHLIST UNDIRECTED, Cycle Testing
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
		Vertex<Integer,Integer>v=grafo.getVertex(1);
		int[] ans= {1,6,4,3,2};
		int i=0;
		Vertex<Integer,Integer> init=v.getCycleAncestors().get(0);
		assert(v.getValue()==ans[i]);
		i++;
		while(init!=v) {
			assert(init.getValue()==ans[i]);
			i++;
			init=init.getAncestor();
		}
	}
	@Test
	public void testFloydWarshall() {
		setUpEscenario1();
		//GRAPHLIST UNDIRECTED
		GraphList<Integer,Integer> grafo=new GraphList<>(true);
		grafo.addEdge(100,0,1);
		grafo.addEdge(200,0,2);
		grafo.addEdge(25,0,4);
		grafo.addEdge(96,0,3);
		grafo.addEdge(87,1,3);
		grafo.addEdge(78,1,2);
		grafo.addEdge(85,2,4);
		grafo.addEdge(312,3,4);
		HashMap<CommutativePair<Integer,Integer>,Double> matrix=ga.floydWarshall(grafo);
		double[][] matrixFloyd= {{0,100,110,96,25},{100,0,78,87,125},{110,78,0,165,85},{96,87,165,0,121},{25,125,85,121,0}};
		for (int i = 0; i < matrixFloyd.length; i++) {
			for (int j = 0; j < matrixFloyd.length; j++) {
				assert(matrixFloyd[i][j]==matrix.get(new CommutativePair<Integer,Integer>(i,j)));
			}
		}
	}
	@Test
	public void testDijkstra() {
		setUpEscenario1();
		//GRAPHLIST UNDIRECTED
		GraphList<Integer,Integer> grafo=new GraphList<>(true);
		grafo.addEdge(15,1,7);
		grafo.addEdge(14,1,3);
		grafo.addEdge(12,3,5);
		grafo.addEdge(3,1,5);
		grafo.addEdge(4,5,8);
		grafo.addEdge(3,5,2);
		grafo.addEdge(11,3,6);
		grafo.addEdge(10,6,2);
		grafo.addEdge(2,2,8);
		grafo.addEdge(9,6,4);
		grafo.addEdge(8,2,4);
		grafo.addEdge(1,8,4);
		grafo=(GraphList<Integer,Integer>)ga.dijkstra(grafo,1);
		Vertex<Integer,Integer>v=grafo.getVertex(4);
		int[] ans= {4,8,5,1};
		int i=0;
		while(v!=null) {
			assert(v.getValue()==ans[i]);
			i++;
			v=v.getAncestor();
		}
	}
	@Test
	public void testKruskal() {
		setUpEscenario2();
		//GRAPHLIST UNDIRECTED
		GraphList<String,Integer> grafo=new GraphList<>(true);
		grafo.addEdge(200,"A","C");
		grafo.addEdge(100,"A","E");
		grafo.addEdge(210,"A","F");
		grafo.addEdge(99,"A","H");
		grafo.addEdge(120,"C","B");
		grafo.addEdge(400,"C","D");
		grafo.addEdge(455,"C","E");
		grafo.addEdge(300,"C","F");
		grafo.addEdge(235,"E","B");
		grafo.addEdge(89,"E","H");
		grafo.addEdge(105,"E","G");
		grafo.addEdge(150,"F","D");
		grafo.addEdge(333,"F","H");
		grafo.addEdge(58,"F","I");
		grafo.addEdge(122,"G","H");
		grafo.addEdge(281,"H","I");
		grafo=(GraphList<String,Integer>)ga.bfs(ga.kruskal(grafo),"A");
		Vertex<String,Integer>v=grafo.getVertex("G");
		String[] ans= {"G","E","H","A"};
		int i=0;
		while(v!=null) {
			assert(v.getValue().equals(ans[i]));
			i++;
			v=v.getAncestor();
		}
	}
	@Test
	public void testPrim() {
		setUpEscenario2();
		//GRAPHLIST UNDIRECTED
		GraphList<String,Integer> grafo=new GraphList<>(true);
		grafo.addEdge(200,"A","C");
		grafo.addEdge(100,"A","E");
		grafo.addEdge(210,"A","F");
		grafo.addEdge(99,"A","H");
		grafo.addEdge(120,"C","B");
		grafo.addEdge(400,"C","D");
		grafo.addEdge(455,"C","E");
		grafo.addEdge(300,"C","F");
		grafo.addEdge(235,"E","B");
		grafo.addEdge(89,"E","H");
		grafo.addEdge(105,"E","G");
		grafo.addEdge(150,"F","D");
		grafo.addEdge(333,"F","H");
		grafo.addEdge(58,"F","I");
		grafo.addEdge(122,"G","H");
		grafo.addEdge(281,"H","I");
		grafo=(GraphList<String,Integer>)ga.prim(grafo,"B");
		Vertex<String,Integer>v=grafo.getVertex("G");
		String[] ans= {"G","E","H","A","C","B"};
		int i=0;
		while(v!=null) {
			assert(v.getValue().equals(ans[i]));
			i++;
			v=v.getAncestor();
		}
	}
}
