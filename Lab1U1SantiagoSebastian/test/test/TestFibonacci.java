package test;

import java.math.BigInteger;

import algoritmo.Fibonacci;
import junit.framework.TestCase;

public class TestFibonacci extends TestCase{
	
	private Fibonacci fibo;
	
	private void setupEscenario1 () {
		fibo = new Fibonacci();
	}
	
	public void testFibonacci(){
		setupEscenario1();
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
		B="0010456456456456";
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
		A="000";
		B="454566565445645644465465187888888888888888888888888888888888888888";
		x=new BigInteger(A);
		d=new BigInteger(B);
		result=fibo.multiplicacion(A, B);
		assertEquals(x.multiply(d).toString(),result);
		A="1234437466811111111135675645433424211148467111";
		B="19";
		x=new BigInteger(A);
		d=new BigInteger(B);
		result=fibo.multiplicacion(A, B);
		assertEquals(x.multiply(d).toString(),result);
		A="111";
		B="0";
		x=new BigInteger(A);
		d=new BigInteger(B);
		result=fibo.multiplicacion(A, B);
		assertEquals(x.multiply(d).toString(),result);
		A="-123443746681111154855234424211148467111";
		B="19";
		x=new BigInteger(A);
		d=new BigInteger(B);
		result=fibo.multiplicacion(A, B);
		assertEquals(x.multiply(d).toString(),result);
		A="-123443746643298769015675645433424211148467111";
		B="-121345678766776435325623646369";
		x=new BigInteger(A);
		d=new BigInteger(B);
		result=fibo.multiplicacion(A, B);
		assertEquals(x.multiply(d).toString(),result);
		A="123443746643298769015675645433424211148467111";
		B="-1213456787667764353256264763313646369";
		x=new BigInteger(A);
		d=new BigInteger(B);
		result=fibo.multiplicacion(A, B);
		assertEquals(x.multiply(d).toString(),result);
	}
}
