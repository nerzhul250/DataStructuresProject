package test;

import static org.junit.Assert.*;

import org.junit.Test;

import pilas.PilaEnlazada;
import pilas.PilaVaciaException;
import tablasHash.TablaHashEncadenada;

public class testPilaEnlazada {
	private PilaEnlazada<Integer> pe;
	
	private void setUpEscenario1 () {
		pe=new PilaEnlazada<>();
	}
	@Test
	public void testPop() throws PilaVaciaException {
		setUpEscenario1();
		pe.push(3);
		pe.push(1);
		pe.push(0);
		pe.push(10);
		assertTrue(pe.pop()==10);
		assertTrue(pe.pop()==0);
		assertTrue(pe.pop()==1);
		assertTrue(pe.pop()==3);
		try {
			pe.pop();
			assertTrue(false);
		} catch (PilaVaciaException e) {
			assertTrue(true);
		}
	}

}
