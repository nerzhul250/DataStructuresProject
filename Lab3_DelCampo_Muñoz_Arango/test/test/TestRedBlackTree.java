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
		rbt.insertar(new RBTNode<Integer,Integer>(1,1));
		rbt.insertar(new RBTNode<Integer,Integer>(2,2));
		rbt.insertar(new RBTNode<Integer,Integer>(3,3));
		rbt.insertar(new RBTNode<Integer,Integer>(4,4));
		rbt.insertar(new RBTNode<Integer,Integer>(5,5));
		rbt.insertar(new RBTNode<Integer,Integer>(6,6));
		rbt.insertar(new RBTNode<Integer,Integer>(7,7));
		rbt.insertar(new RBTNode<Integer,Integer>(8,8));
	}
	@Test
	public void testInsertar() {
		setUpEscenario1();
		rbt.insertar(new RBTNode<Integer,Integer>(5,3));
		rbt.insertar(new RBTNode<Integer,Integer>(6,2));
		assertTrue(rbt.consultar(5).getValor()==3);
	}
	@Test
	public void testBalanceo() {
		setUpEscenario2();
		rbt.getRaiz().recorrerSubArbol("",rbt.nil);
	}
}
