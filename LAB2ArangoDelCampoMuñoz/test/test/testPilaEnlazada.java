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
	private void setUpEscenario2 () {
		pe=new PilaEnlazada<>();
		pe.push(3);
		pe.push(1);
		pe.push(0);
		pe.push(10);
	}
	//de 150, 87 adults excelente calificaicon
	// adults calificacion
	//200, 123 said excelent
	//alpha=10%
	@Test
	public void testPush(){
		setUpEscenario1();
		assertTrue(pe.isEmpty());
		pe.push(60);
		assertFalse(pe.isEmpty());
		assertTrue(pe.top()==60);
		pe.push(456466464);
		assertTrue(pe.top()==456466464);
		pe.push(000);
		assertTrue(pe.top()==0);
	}
	@Test
	public void testPop(){
		setUpEscenario2();
		assertTrue(pe.pop()==10);
		assertTrue(pe.pop()==0);
		assertTrue(pe.pop()==1);
		assertTrue(pe.pop()==3);
		assertTrue(pe.pop()==null);	
	}
}