package test;
import static org.junit.Assert.*;
import mundo.RBTNode;
import mundo.RedBlackTree;

import org.junit.Test;


public class TestRedBlackTree {
	
	private RedBlackTree<Integer,Integer> rbt;
	
	private void setUpEscenario1(){
		rbt=new RedBlackTree<Integer,Integer>();
	}
	private void setUpEscenario2(){
		rbt=new RedBlackTree<Integer,Integer>();
		rbt.insertar(1,1);
		rbt.insertar(2,2);
		rbt.insertar(3,3);
		rbt.insertar(4,4);
		rbt.insertar(5,5);
		rbt.insertar(6,6);
		rbt.insertar(7,7);
		rbt.insertar(8,8);
	}
	@Test
	public void testInsertar() {
		setUpEscenario1();
		rbt.insertar(5,3);
		rbt.insertar(6,2);
		assertTrue(rbt.consultar(5).getValor()==3);
	}
	@Test
	public void testBalanceo() {
		setUpEscenario2();
		rbt.getRaiz().recorrerSubArbol("",rbt.nil);
	}
}
