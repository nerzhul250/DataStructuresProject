package test;

import static org.junit.Assert.*;

import org.junit.Test;

import algoritmo.OperacionBasica;

public class TestOperacionBasica {

	@Test
	public void testSum(){
		String A="13";
		String B="14";
		String result=OperacionBasica.sum(A, B);
		assertEquals("27",result);
		A="145";
		B="001";
		result=OperacionBasica.sum(A, B);
		assertEquals("146",result);
		A="145";
		B="1";
		result=OperacionBasica.sum(A, B);
		assertEquals("146",result);
		A="999";
		B="001";
		result=OperacionBasica.sum(A, B);
		assertEquals("1000",result);
		A="1000000000000000000000000";
		B="1000000000000000000000001";
		result=OperacionBasica.sum(A, B);
		assertEquals("2000000000000000000000001",result);
		A="0";
		B="0";
		result=OperacionBasica.sum(A, B);
		assertEquals("0",result);
	}
	@Test
	public void testSubstract(){
		String A="14";
		String B="13";
		String result=OperacionBasica.substract(A, B);
		assertEquals("1",result);
		A="145";
		B="13";
		result=OperacionBasica.substract(A, B);
		assertEquals("132",result);
		A="145456456564454646545645645645613";
		B="13";
		result=OperacionBasica.substract(A, B);
		assertEquals("145456456564454646545645645645600",result);	
		A="14";
		B="1";
		result=OperacionBasica.substract(A, B);
		assertEquals("13",result);
		A="14";
		B="001";
		result=OperacionBasica.substract(A, B);
		assertEquals("13",result);
		A="02";
		B="001";
		result=OperacionBasica.substract(A, B);
		assertEquals("1",result);
		A="00";
		B="00";
		result=OperacionBasica.substract(A, B);
		assertEquals("0",result);
		A="100";
		B="1";
		result=OperacionBasica.substract(A, B);
		assertEquals("99",result);
	}
	@Test
	public void testDivisionByN(){
		String A="156";
		String respuesta=OperacionBasica.divisionByN(A,2);
		assertEquals("78",respuesta);
		A="12";
		respuesta=OperacionBasica.divisionByN(A,3);
		assertEquals("4",respuesta);
	}
}
