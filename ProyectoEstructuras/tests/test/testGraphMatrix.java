package test;

import static org.junit.jupiter.api.Assertions.*;

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
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	void testAddEdge() {
		setUpEscenario1();
		
		gm.addEdge(2, "pepe", "juan");
		
		assertTrue(gm.getNeighbors("pepe").equals("juan"));;
	}

}
