package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import world.GraphList;
import world.GraphMatrix;
import world.Vertex;

class TestGraphList {
	
	
	private GraphList<String, Integer> gm;
	
	private void setUpEscenario1() {
		//value strimg
		//edge integer
		gm=new GraphList<String, Integer>(true);
		gm.addEdge(1, "pepe", "juan");
		
	}

	//done
	@Test
	void testAddEdge() {
		setUpEscenario1();
		
		gm.addEdge(2, "santi", "jose");
		 
		assertTrue(gm.getNumberOfVertices()==4);
	}
	@Test
    void testGetVertex(){
		setUpEscenario1();
		Vertex<String, Integer> alpah=new Vertex<String, Integer>("pepe");
		assertTrue(gm.getVertex("pepe").getValue().equals(alpah.getValue()));
	}

	//done
	@Test
	void testGetValues(){
		setUpEscenario1();
		ArrayList<String> correcto=new ArrayList<String> ();
		correcto.add("pepe");
		correcto.add("juan");
	//	System.out.println(correcto.toString()+"\n");
		
		
		assertTrue(correcto.toString().equals(gm.getValues().toString()));
		
	}
	@Test
    void testGetEdges(){
		setUpEscenario1();
		
		
	}
	@Test
    void testAddVertex(){
		setUpEscenario1();
		gm.addVertex("jajajaj");
		assertTrue(gm.getNumberOfVertices()==3);
		
		
	}
	//TODO
	//help NOT WORKING
	@Test
    void testGetLabel(){
		setUpEscenario1();
		assertTrue(gm.getLabel("juan","pepe")==1);
	}
	//TODO
	//help ONLY WORKS ON PEPE IF TRIED ON JUAN WILL FAIL
	@Test
    void testGetNeighbours(){
		setUpEscenario1();
		
		assertTrue(gm.getNeighbors("pepe").toString().equals("[juan]"));
	}
	//TODO
		//help ONLY WORKS ON PEPE IF TRIED ON JUAN WILL FAIL
	@Test
    void testIsThereEdge(){
		setUpEscenario1();
		assertTrue(gm.isThereEdge( "pepe","juan"));
	}
	
	
	
	
	
	
	

}
