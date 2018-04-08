package test;

import static org.junit.Assert.*;

import org.junit.Test;

import ABB.ABB;

public class ABBTest {
	private ABB <String,Integer> arbolito;
	
	private void setupEscenario1 () {
		arbolito = new ABB<>();
	}
	private void setupEscenario2 () {
		arbolito = new ABB<>();
		arbolito.agregar("juicio", 1);
		arbolito.agregar("castro", 2);
		arbolito.agregar("xd", 3);
		arbolito.agregar("infe", 4);
	}
	private void setupEscenario3 () {
		arbolito = new ABB<>();
		arbolito.agregar("gonzalez", 1);
		arbolito.agregar("kase", 2);
		arbolito.agregar("sapito", 3);
		arbolito.agregar("astucia", 4);
		arbolito.agregar("alv", 5);
	}
	@Test
	public void testEstaVacio1() {
		setupEscenario1();
		assertTrue(arbolito.estaVacio());
	}
	@Test
	public void testEstaVacio2() {
		setupEscenario2();
		assertFalse(arbolito.estaVacio());
	}
	@Test
	public void testBuscar1() {
		setupEscenario2();
		assertTrue(2 == arbolito.buscar("castro"));
		assertTrue(4 == arbolito.buscar("infe"));
		assertTrue(1 == arbolito.buscar("juicio"));
		assertTrue(3 == arbolito.buscar("xd"));
	}
	@Test
	public void testBuscar2() {
		setupEscenario3();
		assertTrue(2 == arbolito.buscar("kase"));
		assertTrue(4 == arbolito.buscar("astucia"));
		assertTrue(1 == arbolito.buscar("gonzalez"));
		assertTrue(3 == arbolito.buscar("sapito"));
		assertTrue(5 == arbolito.buscar("alv"));
	}
	
}
