package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import world.GraphList;
import world.GraphMatrix;
import world.Vertex;

class TestGraphList {
	
	
	private GraphList<String, Integer> gm;
	
	private void setUpScenario1() {
		gm=new GraphList<String, Integer>(true);
		gm.addEdge(1, "pepe", "juan");
	}
	@Test
	void testAddEdge() {
		setUpScenario1();	
		gm.addEdge(2, "santi", "jose");
		assertTrue(gm.getNumberOfVertices()==4);
	}
	@Test
    void testGetVertex(){
		setUpScenario1();
		Vertex<String, Integer> alpah=new Vertex<String, Integer>("pepe");
		assertTrue(gm.getVertex("pepe").getValue().equals(alpah.getValue()));
	}
	@Test
	void testGetValues(){
		setUpScenario1();
		ArrayList<String> correcto=new ArrayList<String> ();
		correcto.add("juan");
		correcto.add("pepe");
		assertTrue(correcto.equals(gm.getValues()));
	}
	@Test
    void testGetEdges(){
		setUpScenario1();
	}
	@Test
    void testAddVertex(){
		setUpScenario1();
		gm.addVertex("ja");
		assertTrue(gm.getVertex("ja")!=null);
	}
	@Test
    void testGetLabel(){
		setUpScenario1();
		assertTrue(gm.getLabel("juan","pepe")==1);
	}
	//TODO
	//help ONLY WORKS ON PEPE IF TRIED ON JUAN WILL FAIL
	@Test
    void testGetNeighbours(){
		setUpScenario1();
		assertTrue(gm.getNeighbors("pepe").get(0).equals("juan"));
	}
	//TODO
		//help ONLY WORKS ON PEPE IF TRIED ON JUAN WILL FAIL
	@Test
    void testIsThereEdge(){
		setUpScenario1();
		assertTrue(gm.isThereEdge("pepe","juan"));
	}
}