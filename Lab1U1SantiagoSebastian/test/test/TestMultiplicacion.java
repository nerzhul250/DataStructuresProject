package test;

import java.math.BigInteger;

import org.junit.Test;

import algoritmo.Fibonacci;
import algoritmo.Multiplicacion;
import algoritmo.OperacionBasica;
import junit.framework.TestCase;

public class TestMultiplicacion extends TestCase {
	
	private Multiplicacion multiplicacion;
	private Fibonacci fibo;
	private void setUpEscenario1(){
		multiplicacion=new Multiplicacion();
	}
	private void setupEscenario2 () {
		fibo = new Fibonacci();
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
	
	public void testFibonacci(){
		setupEscenario2();
		BigInteger x;
		BigInteger d;
		String A="73";
		String B="73";
		String result=fibo.multiplicacion(A, B);
		assertEquals("5329",result);
		A="2";
		B="10";
		result=fibo.multiplicacion(A, B);
		assertEquals("20",result);
		A="2456565";
		B="10456456456456";
		x=new BigInteger(A);
		d=new BigInteger(B);
		result=fibo.multiplicacion(A, B);
		assertEquals(x.multiply(d).toString(),result);
		A="45645646564545645688219817111871145644614645624524624";
		B="564454546222546464564654654897978971321231313256415616";
		x=new BigInteger(A);
		d=new BigInteger(B);
		result=fibo.multiplicacion(A, B);
		assertEquals(x.multiply(d).toString(),result);
		A="111111111111111111111111111111111111111111111111111111111111111111";
		B="454566565445645644465465187888888888888888888888888888888888888888";
		x=new BigInteger(A);
		d=new BigInteger(B);
		result=fibo.multiplicacion(A, B);
		assertEquals(x.multiply(d).toString(),result);
		A="111111111111111111111111111111111111111111111111111111111111111111";
		B="2";
		x=new BigInteger(A);
		d=new BigInteger(B);
		result=fibo.multiplicacion(A, B);
		assertEquals(x.multiply(d).toString(),result);
		A="111111111111111111111111111111111111111111111111111111111111111111";
		B="0";
		x=new BigInteger(A);
		d=new BigInteger(B);
		result=fibo.multiplicacion(A, B);
		assertEquals(x.multiply(d).toString(),result);
	}
}
