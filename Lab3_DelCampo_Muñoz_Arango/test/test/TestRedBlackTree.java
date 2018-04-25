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
	}
	@Test
	public void testConsultar() {
		setUpEscenario2();
		assertTrue(rbt.consultar(3).getValue()==3);
		assertTrue(rbt.consultar(2).getValue() == 2);
		assertTrue(rbt.consultar(7).getValue() == 7);
		assertTrue(rbt.consultar(8).getValue() == 8);
	}
	@Test
	public void testEliminar () {
		setUpEscenario2();
		assertTrue(rbt.consultar(2).getValue() == 2);
		rbt.eliminar(2);
		assertTrue(rbt.consultar(2) == null);
		assertTrue(rbt.consultar(1).getValue() == 1);
		rbt.eliminar(1);
		assertTrue(rbt.consultar(1) == null);
		assertTrue(rbt.consultar(5).getValue() == 5);
		rbt.eliminar(5);
		assertTrue(rbt.consultar(5) == null);
		assertTrue(rbt.consultar(3).getValue() == 3);
		rbt.eliminar(3);
		assertTrue(rbt.consultar(3) == null);
	}
}
