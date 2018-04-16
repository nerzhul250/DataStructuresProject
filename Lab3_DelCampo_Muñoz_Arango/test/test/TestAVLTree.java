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
	public void testBalanceo() {
		setUpEscenario2();
		avl.getRaiz().recorrerSubArbol("",null);
	}
}
