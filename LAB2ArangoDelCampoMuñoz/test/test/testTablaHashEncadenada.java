package test;

import static org.junit.Assert.*;

import org.junit.Test;

import tablasHash.TablaHashEncadenada;

public class testTablaHashEncadenada {
	//PetaraConAlgunaUltraCadena?
	private TablaHashEncadenada<String,Integer> the;
	
	private void setUpEscenario1 () {
		the=new TablaHashEncadenada<>(11);
	}
	private void setUpEscenario2 () {
		the=new TablaHashEncadenada<>(12);
	}
	@Test
	public void testInsertar() {
		setUpEscenario1();
		the.insertar("sdklfsd",2);
		the.insertar("sdlfsd",3);
		the.insertar("sdfsd",10);
		the.insertar("sdsd",41);
		the.insertar("fsd",46);
		the.insertar("sklfsd",8);
		the.insertar("sfsd",9);
		the.insertar("sfsd",14);
		the.insertar("slfd",15);
		the.insertar("slf",10654);
		assertTrue(the.getNumeroElementosEnTabla()==10);
		System.out.println(the.getNumeroDeColisiones());
		setUpEscenario2();
		the.insertar("sdklfsd",2);
		the.insertar("sdlfsd",3);
		the.insertar("sdfsd",10);
		the.insertar("sdsd",41);
		the.insertar("fsd",46);
		the.insertar("sklfsd",8);
		the.insertar("sfsd",9);
		the.insertar("sfsd",14);
		the.insertar("slfd",15);
		the.insertar("slf",10654);
		assertTrue(the.getNumeroElementosEnTabla()==10);
		System.out.println(the.getNumeroDeColisiones());
	}
	@Test
	public void testBuscar() {
		setUpEscenario1();
		the.insertar("Automovil",2);
		the.insertar("utomovil",3);
		the.insertar("tomovil",10);
		the.insertar("omovil",41);
		the.insertar("movil",46);
		the.insertar("ovil",8);
		the.insertar("vil",9);
		the.insertar("il",14);
		the.insertar("l",15);
		the.insertar("li",10654);
		assertTrue(the.buscar("Automovil")==2);
		assertTrue(the.buscar("l")==15);
		assertTrue(the.buscar("li")==10654);
		assertTrue(the.buscar("movil")==46);
		assertTrue(the.buscar("vil")==9);
		assertTrue(the.getNumeroElementosEnTabla()==10);
	}
}
