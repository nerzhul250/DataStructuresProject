package test;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

import algoritmo.Toom_Cook;

public class TestToom {

	@Test
	public void test0() {
		setUpEscenario1();
		BigInteger a=new BigInteger("1234567890123456789012");
		BigInteger b=new BigInteger("987654321987654321098");
		String A="1234567890123456789012";
		String B="987654321987654321098";
		String result=Toom_Cook.Toom(A, B);
		assertEquals(result,a.multiply(b)+"");

	}
	@Test
	public void test1(){
		setUpEscenario1();
		String A="530465363749138449373890157939465022685044973572107204312504422479971827762969763322312679873425157722797";
		String B="4615851605370090647734646571860905058023782384450612954248702774997692839451930196612294923100021043907528699182000461477682844908052488855538284227311794096842752614280112471065954197054163284285856036985015765493944024713089148538013758387350110354013114455348770175161386686091458507939643128561775929076980177791134770956904440077624219473024581329033436831939811746316420020353709897853141144745181484168592563031958509868922941672073070880163314426818846330790995530608079943927945645557957641572434410851566058766101780640296589223915028002021601601769466288368140815447854870327411894836846789367484433271218205444425285528362919853690245775465106670096290585263354374895999298099936119776840018539364723987166896898912251148561631500224348800763614332455392317469476298200019963348265995335305605453998189630268899932093991494437450962816239563575826674247574163271374867582603383495109414298787600127394925219837923365404231719094624039087990545791425603245237334976775517857342947608285918";
		BigInteger a=new BigInteger(A);
		BigInteger b=new BigInteger(B);
		String result=Toom_Cook.Toom(A, B);
		assertEquals(a.multiply(b)+"",result);
		
	}
	@Test
	public void test2(){
		setUpEscenario1();
		
		String A="978469326298321363664007918386246675085047889515575179694189219674268597846932629832136366400791838624667508504788951207880435657667225224215924789875723199713992551724851736488229167946679989818628161564145615479694558273223251239";
		String B="55751796941892196742685978469326298321363664007918386246675085047889512078804357136366400791838624667508504788951207880435792308115626597604";
		BigInteger a=new BigInteger(A);
		BigInteger b=new BigInteger(B);
		String result=Toom_Cook.Toom(A, B);
		assertEquals(a.multiply(b)+"",result);
		}
	@Test
	public void test3(){
		setUpEscenario1();
		String A="0";
		String B="987654321987654321987654321";
		BigInteger a=new BigInteger(A);
		BigInteger b=new BigInteger(B);
		String result=Toom_Cook.Toom(A, B);
		assertEquals(a.multiply(b)+"",result);
		
		}
	
	@Test
	public void test4(){
		setUpEscenario1();
		String A="-1";
		String B="987654321123456789876543212345678";
		BigInteger a=new BigInteger(A);
		BigInteger b=new BigInteger(B);
		String result=Toom_Cook.Toom(A, B);
		assertEquals(a.multiply(b)+"",result);
		
		
		}
	@Test
	public void test5(){
		setUpEscenario1();
		String A="1";
		String B="987654321987654321987654321";
		BigInteger a=new BigInteger(A);
		BigInteger b=new BigInteger(B);
		String result=Toom_Cook.Toom(A, B);
		assertEquals(a.multiply(b)+"",result);
		
		}
	@Test
	public void test6(){
		setUpEscenario1();
		String A="100000000000000000000000000000000000000000000000000";
		String B="23";
		BigInteger a=new BigInteger(A);
		BigInteger b=new BigInteger(B);
		String result=Toom_Cook.Toom(A, B);
		assertEquals(a.multiply(b)+"",result);
		
		}
	

	private void setUpEscenario1() {
		Toom_Cook toom=new Toom_Cook();
	
	}

}