	package test;

import static org.junit.Assert.*;

import org.junit.Test;

import colas.ColaEnlazada;
import pilas.PilaEnlazada;

public class testColaEnlazada {
	private ColaEnlazada<Integer> ce;
	private void setUpEscenario1 () {
		ce=new ColaEnlazada<>();
	}
	private void setUpEscenario2() {
		ce=new ColaEnlazada<>();
		ce.queue(2);
		ce.queue(1);
		ce.queue(10);
		ce.queue(3);
	}
	@Test
	public void testQueue() {
		setUpEscenario1();
		assertTrue(ce.isEmpty());
		ce.queue(2);
		assertFalse(ce.isEmpty());
		assertTrue(ce.front()==2);
		ce.deQueue();
		ce.queue(2000000000);
		assertTrue(ce.front()==2000000000);
		ce.deQueue();
		ce.queue(null);
		assertTrue(ce.front()==null);
		assertTrue(ce.getNumeroElementos()==1);
	}
	@Test
	public void testDequeue() {
		setUpEscenario2();
		assertTrue(ce.deQueue()==2);
		assertTrue(ce.deQueue()==1);
		assertTrue(ce.deQueue()==10);
		assertTrue(ce.deQueue()==3);
		assertTrue(ce.deQueue()==null);
	}
}