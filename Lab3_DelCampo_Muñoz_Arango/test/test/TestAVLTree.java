package test;

import static org.junit.Assert.*;

import org.junit.Test;

import mundo.AVLTree;
import mundo.RedBlackTree;

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
	}
	
	@Test
	public void testEliminar () {
		setUpEscenario2();
		assertTrue(avl.consultar("h").getValue() == 456);
		assertTrue(avl.eliminar("h"));
		assertTrue(avl.consultar("h") == null);
		assertTrue(avl.consultar("b").getValue() == 36);
		assertTrue(avl.eliminar("b"));
		assertTrue(avl.consultar("b") == null);
		assertTrue(avl.consultar("a").getValue() == 3);
		assertTrue(avl.eliminar("a"));
		assertTrue(avl.consultar("a") == null);
		assertTrue(avl.consultar("m").getValue() == 465);
		assertTrue(avl.eliminar("m"));
		assertTrue(avl.consultar("m") == null);
	}
	
	
}
