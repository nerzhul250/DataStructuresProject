package test;

import java.math.BigInteger;

import org.junit.Test;

import algoritmo.Multiplicacion;
import algoritmo.OperacionBasica;
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
		setUpEscenario1();
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
	public void testKaratsuba(){
		setUpEscenario1();
		BigInteger one=null;
		BigInteger two=null;
		String A="73";
		String B="73";
		String result=multiplicacion.karatsuba(A, B);
		assertEquals("5329",result);
		A="2";
		B="10";
		result=multiplicacion.karatsuba(A, B);
		assertEquals("20",result);
		A="2456565";
		B="10456456456456";
		one=new BigInteger(A);
		two=new BigInteger(B);
		result=multiplicacion.karatsuba(A, B);
		assertEquals(one.multiply(two).toString(),result.trim());
		A="45645646564545645688219817111871145644614645624524624";
		B="564454546222546464564654654897978971321231313256415616";
		one=new BigInteger(A);
		two=new BigInteger(B);
		result=multiplicacion.karatsuba(A, B);
		assertEquals(one.multiply(two).toString(),result.trim());
		A="111111111111111111111111111111111111111111111111111111111111111111";
		B="454566565445645644465465187888888888888888888888888888888888888888";
		one=new BigInteger(A);
		two=new BigInteger(B);
		result=multiplicacion.karatsuba(A, B);
		assertEquals(one.multiply(two).toString(),result.trim());
		A="111111111111111111111111111111111111111111111111111111111111111111";
		B="2";
		one=new BigInteger(A);
		two=new BigInteger(B);
		result=multiplicacion.karatsuba(A, B);
		assertEquals(one.multiply(two).toString(),result.trim());
		A="111111111111111111111111111111111111111111111111111111111111111111";
		B="0";
		one=new BigInteger(A);
		two=new BigInteger(B);
		result=multiplicacion.karatsuba(A, B);
		assertEquals(one.multiply(two).toString(),result.trim());
	}
	
}
