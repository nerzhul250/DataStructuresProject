package test;

import static org.junit.Assert.*;

import org.junit.Test;

import mundo.AVLTree;
import mundo.RedBlackTree;
import mundo.AVLNode;

public class TestAVLTree {
	
	private AVLTree<String,Integer> avl;
	private void setUpEscenario1(){
		avl=new AVLTree<>();
	}
	private void setUpEscenario2() {
		avl=new AVLTree<>();
		avl.insertar("h",456);
		avl.insertar("i",7);
		avl.insertar("j",78);
		avl.insertar("k",236);
		avl.insertar("l",489);
		avl.insertar("m",465);
		avl.insertar("n",498);
		avl.insertar("b",36);
		avl.insertar("c",2);
		avl.insertar("d",8);
		avl.insertar("e",75);
		avl.insertar("f",3);
		avl.insertar("g",2);
		avl.insertar("a",3);
		avl.insertar("o",96);
	}
	@Test
	public void testInsertar() {
		setUpEscenario1();
		avl.insertar("a",3);
		avl.insertar("HOLA",2);
		assertTrue(avl.consultar("a").getValue()==3);
		assertTrue(avl.consultar("HOLA").getValue()==2);
		try {
			avl.insertar(null,null);			
		}catch(Exception e) {assertTrue(false);}
		avl.insertar("hhhhhhhhhhhhhhhhhhhhhhffdssassdfgjmnbvgfr",240245904);
	}
	
	public void testConsultar() {
		setUpEscenario2();
		assertTrue(avl.consultar("e").getValue() == 75);
		assertTrue(avl.consultar("l").getValue() == 489);
		assertTrue(avl.consultar(null) ==null);
		assertTrue(avl.consultar("hlbb")==null);
	}
	
	@Test
	public void testEliminar () {
		setUpEscenario2();
		
		((AVLNode)avl.getRaiz()).recorrerSubArbol("",null);
		System.out.println("PARTICION");
		
		assertTrue(avl.consultar("h").getValue() == 456);
		avl.eliminar("h");
		assertTrue(avl.consultar("h") == null);
		
		((AVLNode)avl.getRaiz()).recorrerSubArbol("",null);
		System.out.println("PARTICION");
		
		assertTrue(avl.consultar("b").getValue() == 36);
		avl.eliminar("b");
		assertTrue(avl.consultar("b") == null);
		
		((AVLNode)avl.getRaiz()).recorrerSubArbol("",null);
		System.out.println("PARTICION");
		
		assertTrue(avl.consultar("a").getValue() == 3);
		avl.eliminar("a");
		assertTrue(avl.consultar("a") == null);
		
		((AVLNode)avl.getRaiz()).recorrerSubArbol("",null);
		System.out.println("PARTICION");
		
		assertTrue(avl.consultar("m").getValue() == 465);
		avl.eliminar("m");
		assertTrue(avl.consultar("m") == null);
		
		((AVLNode)avl.getRaiz()).recorrerSubArbol("",null);
		System.out.println("PARTICION");
		
		assertTrue(avl.eliminar(null)==null);
	}
	
	
}
