package test;

import static org.junit.Assert.*;

import org.junit.Test;

import colas.ColaEnlazada;
import colas.ColaVaciaException;
import pilas.PilaEnlazada;

public class testColaEnlazada {
	
	private ColaEnlazada<Integer> ce;
	
	private void setUpEscenario1 () {
		ce=new ColaEnlazada<>();
	}
	@Test
	public void test() {
		setUpEscenario1();
		ce.queue(2);
		ce.queue(1);
		ce.queue(10);
		ce.queue(3);
			assertTrue(ce.unQueue()==1);
			assertTrue(ce.unQueue()==10);
			assertTrue(ce.unQueue()==3);	
			assertTrue(ce.unQueue()==2);
	}

}
