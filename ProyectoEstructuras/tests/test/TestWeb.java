package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import world.Domain;
import world.GraphAlgorithm;
import world.GraphList;
import world.Web;

class TestWeb {

	private Web w;

	private void setUpEscenario1() {
		w = new Web();
		Domain d1 = new Domain("https://www.docs.google.com.co", "docs.google.com.co");
		Domain d2 = new Domain("https://alv.google.com", "alv.google.com");
		Domain d3 = new Domain("https://www.facenook.com", "facebook.com");
		Domain d4 = new Domain("https://www.apple.com", "apple.com");
		Domain d5 = new Domain("https://www.amazon.com", "amazon.com");
		Domain d6 = new Domain("https://www.icesi.edu.co", "icesi.edu.co");
		Domain d7 = new Domain("https://www.20minmail", "20minmail.com");
		w.getNet().addEdge("1", d1, d4);
		w.getNet().addEdge("2", d1, d3);
		w.getNet().addEdge("3", d2, d3);
		w.getNet().addEdge("4", d4, d5);
		w.getNet().addEdge("5", d3, d6);
		w.getNet().addEdge("6", d6, d5);
		w.getNet().addEdge("7", d5, d7);
	}

	@Test
	void testFindShortestPath() {
		setUpEscenario1();
		Domain d1 = new Domain("https://www.docs.google.com.co", "docs.google.com.co");
		Domain d7 = new Domain("https://www.20minmail", "20minmail.com");
		Domain d5 = new Domain("https://www.amazon.com", "amazon.com");
		Domain d4 = new Domain("https://www.apple.com", "apple.com");

		ArrayList<Domain> test = new ArrayList<Domain>();
		test.add(d7);
		test.add(d5);
		test.add(d4);
		test.add(d1);
		System.out.println(test.toString());
		System.out.println(w.findShortestPath(d1, d7).getValues());
		
		GraphList<Domain, String> newGraph = (GraphList<Domain, String>) w.findShortestPath(d1, d7);			
		for (int i = 0; i < newGraph.getNumberOfVertices(); i++) {
			assertTrue(test.contains(newGraph.getValues().get(i)));
		}

	}
	@Test
	void testFindCycles() {
		setUpEscenario1();
		Domain d1 = new Domain("https://www.docs.google.com.co", "docs.google.com.co");
		Domain d2 = new Domain("https://alv.google.com", "alv.google.com");
		Domain d3 = new Domain("https://www.facenook.com", "facebook.com");
		Domain d4 = new Domain("https://www.apple.com", "apple.com");
		Domain d5 = new Domain("https://www.amazon.com", "amazon.com");
		Domain d6 = new Domain("https://www.icesi.edu.co", "icesi.edu.co");
		Domain d7 = new Domain("https://www.20minmail", "20minmail.com");
//		System.out.println(w.getDomains());
		GraphList<Domain, String> newGraph = (GraphList<Domain, String>) w.cyclesOf(d5);
//		System.out.println(newGraph.getValues());
		assertTrue(newGraph.isThereEdge(d1, d4));
		assertTrue(newGraph.isThereEdge(d1, d3));
		assertTrue(newGraph.isThereEdge(d6, d3));
		assertTrue(newGraph.isThereEdge(d5, d4));
		assertTrue(newGraph.isThereEdge(d5, d6));
		assertFalse(newGraph.isThereEdge(d5, d7));
		assertFalse(newGraph.isThereEdge(d3, d2));
	}
}
