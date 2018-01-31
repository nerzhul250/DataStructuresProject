package test;

import org.junit.Test;

import algoritmo.Multiplicacion;
import junit.framework.TestCase;

public class TestMultiplicacion extends TestCase {
	private Multiplicacion multiplicacion;
	
	private void setUpEscenario1(){
		multiplicacion=new Multiplicacion();
	}
	
	@Test
	public void testSum(){
		setUpEscenario1();
		String A="13";
		String B="14";
		String result=multiplicacion.sum(A, B);
		assertEquals("27",result);
		A="145";
		B="001";
		result=multiplicacion.sum(A, B);
		assertEquals("146",result);
		A="145";
		B="1";
		result=multiplicacion.sum(A, B);
		assertEquals("146",result);
		A="999";
		B="001";
		result=multiplicacion.sum(A, B);
		assertEquals("1000",result);
		A="1000000000000000000000000";
		B="1000000000000000000000001";
		result=multiplicacion.sum(A, B);
		assertEquals("2000000000000000000000001",result);
		A="0";
		B="0";
		result=multiplicacion.sum(A, B);
		assertEquals("0",result);
	}
	@Test
	public void testSubstract(){
		setUpEscenario1();
		String A="14";
		String B="13";
		String result=multiplicacion.substract(A, B);
		assertEquals("1",result);
		A="145";
		B="13";
		result=multiplicacion.substract(A, B);
		assertEquals("132",result);
		A="145456456564454646545645645645613";
		B="13";
		result=multiplicacion.substract(A, B);
		assertEquals("145456456564454646545645645645600",result);	
		A="14";
		B="1";
		result=multiplicacion.substract(A, B);
		assertEquals("13",result);
		A="14";
		B="001";
		result=multiplicacion.substract(A, B);
		assertEquals("13",result);
		A="02";
		B="001";
		result=multiplicacion.substract(A, B);
		assertEquals("1",result);
		A="00";
		B="00";
		result=multiplicacion.substract(A, B);
		assertEquals("0",result);
	}
	@Test
	public void testKaratsuba(){
		setUpEscenario1();
		String A="424";
		String B="424";
		String result=multiplicacion.karatsuba(A, B);
		System.out.println(result);
		assertEquals("",result);
	}
	
}
