package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import world.GraphAlgorithm;
import world.GraphList;
import world.GraphMatrix;

class testGraphMatrix {
	
private GraphMatrix<String, Integer> gm;
	
	private void setUpEscenario1() {
		//value strimg
		//edge integer
		gm=new GraphMatrix<String, Integer>(true);
		gm.addEdge(1, "pepe", "juan");
		
		
		
	}
	
	@Test
	void testAddEdge() {
		setUpEscenario1();
		
		gm.addEdge(2, "santi", "jose");
		 
		assertTrue(gm.getNumberOfVertices()==4);
	}
	@Test
	void testExpand() {
		setUpEscenario1();
		gm.expandMatrix("elemento");
		
		assertTrue(gm.getNumberOfVertices()==3);
	}
	
	@Test
	void testGetValue(){
		setUpEscenario1();
		
			assertTrue(gm.getValue(0)=="pepe");
		
		
	}
	//TODO
	//help:NOT WORKING
	@Test
	void testGetEdgesArray(){
		setUpEscenario1();
		ArrayList[][] correcto=new ArrayList[1][1];
		
		correcto[0][0]=new ArrayList<Integer>();
		correcto[0][0].add(1);
		
		try {
			System.out.println(gm.getEdgesArray()[gm.getInteger("pepe")][gm.getInteger("juan")].get(0).toString());
		
		assertTrue(gm.getEdgesArray()[gm.getInteger("pepe")][gm.getInteger("juan")].get(0).equals(correcto[0][0].get(0)));
		
		} catch (Exception e) {
			fail("something is wrong with the matrix");
		}
		
	}
	
	@Test
	void testGetInteger(){
		setUpEscenario1();
		
		try {
			assertTrue(gm.getInteger("pepe")==0);
			assertTrue(gm.getInteger("juan")==1);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
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
		gm.expandMatrix("jajjajaja");
		assertTrue(gm.getNumberOfVertices()==3);
		
		
	}
	//TODO
	//help NOT WORKING
	@Test
    void testGetLabel(){
		setUpEscenario1();
		assertTrue(gm.getLabel("pepe","juan")==1);
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
