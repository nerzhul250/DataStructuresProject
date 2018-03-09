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
		the=new TablaHashEncadenada<>(4);
		the.insert("Automovil",2);
		the.insert("movil",46);
		the.insert("l",15);
		the.insert("li",10654);
		the.insert("sklfsmlmlkmlmlmlmlmmmmklmlkmlmlmlmlmlmlkmlmlkmlmklkmlkmklmlkmlkmlkmlkmlkmlkmklmlkmlmd",8);
	}
	@Test
	public void testInsertar() {
		setUpEscenario2();
		setUpEscenario1();
		the.insert("sdklfsd",2);
		the.insert("sklfsmlmlkmlmlmlmlmmmmklmlkmlmlmlmlmlmlkmlmlkmlmklkmlkmklmlkmlkmlkmlkmlkmlkmklmlkmlmd",8);
		assertTrue(the.getNumeroElementosEnTabla()==2);
		try{
			the.insert(null,46);			
			assertTrue(false);
		}catch(Exception e){
			assertTrue(true);
		}
	}
	@Test
	public void testFind() {
		setUpEscenario2();
		assertTrue(the.find("Automovil")==2);
		assertTrue(the.find("l")==15);
		assertTrue(the.find("li")==10654);
		assertTrue(the.find("movil")==46);
		assertTrue(the.find("ka")==null);
		assertTrue(the.getNumeroElementosEnTabla()==5);
	}
	@Test
	public void testDelete() {
		setUpEscenario2();
		the.delete("Automovil");
		assertTrue(the.find("Automovil")==null);
		assertTrue(the.getNumeroElementosEnTabla()==4);
		the.delete("sklfsmlmlkmlmlmlmlmmmmklmlkmlmlmlmlmlmlkmlmlkmlmklkmlkmklmlkmlkmlkmlkmlkmlkmklmlkmlmd");
		assertTrue(the.find("sklfsmlmlkmlmlmlmlmmmmklmlkmlmlmlmlmlmlkmlmlkmlmklkmlkmklmlkmlkmlkmlkmlkmlkmklmlkmlmd")==null);
		assertTrue(the.getNumeroElementosEnTabla()==3);
		try{
			the.delete(null);
			assertTrue(false);
		}catch(Exception e){
			assertTrue(true);
		}
	}	
}