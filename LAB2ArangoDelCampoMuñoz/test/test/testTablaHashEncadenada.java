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
		the.insert("sdklfsd",2);
		the.insert("sdlfsd",3);
		the.insert("sdfsd",10);
		the.insert("sdsd",41);
		the.insert("fsd",46);
		the.insert("sklfsd",8);
		the.insert("sfsd",9);
		the.insert("sfsd",14);
		the.insert("slfd",15);
		the.insert("slf",10654);
		assertTrue(the.getNumeroElementosEnTabla()==10);
		System.out.println(the.getNumeroDeColisiones());
		setUpEscenario2();
		the.insert("sdklfsd",2);
		the.insert("sdlfsd",3);
		the.insert("sdfsd",10);
		the.insert("sdsd",41);
		the.insert("fsd",46);
		the.insert("sklfsd",8);
		the.insert("sfsd",9);
		the.insert("sfsd",14);
		the.insert("slfd",15);
		the.insert("slf",10654);
		assertTrue(the.getNumeroElementosEnTabla()==10);
		System.out.println(the.getNumeroDeColisiones());
	}
	@Test
	public void testBuscar() {
		setUpEscenario1();
		the.insert("Automovil",2);
		the.insert("utomovil",3);
		the.insert("tomovil",10);
		the.insert("omovil",41);
		the.insert("movil",46);
		the.insert("ovil",8);
		the.insert("vil",9);
		the.insert("il",14);
		the.insert("l",15);
		the.insert("li",10654);
		assertTrue(the.find("Automovil")==2);
		assertTrue(the.find("l")==15);
		assertTrue(the.find("li")==10654);
		assertTrue(the.find("movil")==46);
		assertTrue(the.find("vil")==9);
		assertTrue(the.getNumeroElementosEnTabla()==10);
	}
}
