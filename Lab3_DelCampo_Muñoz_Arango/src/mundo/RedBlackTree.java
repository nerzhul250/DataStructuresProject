package mundo;

import java.util.ArrayList;

public class RedBlackTree<K extends Comparable,V> extends ABB<K,V> {
	public RBTNode<K,V> nil;
	
	public RedBlackTree(){
		super();
		nil=new RBTNode<>(null,null);
		nil.setPadre(nil);
		nil.setDerecho(nil);
		nil.setIzquierdo(nil);
		nil.setColor(Color.BLACK);
		raiz=nil;
	}
	@Override
	public void insertar(K key, V value) {
		RBTNode<K,V> z =new RBTNode<K,V>(key,value);
		insertar(z,nil);
		insertFixeUp(z);
	}
	@Override
	public boolean eliminar(K key) {
		// TODO Auto-generated method stub
		return false;
	}
	private void insertFixeUp(RBTNode<K, V> z) {
		while(((RBTNode<K, V>) z.getPadre()).getColor()==Color.RED){
			if(z.getPadre()==z.getPadre().getPadre().getIzquierdo()){
				RBTNode<K,V> y =(RBTNode<K, V>) z.getPadre().getPadre().getDerecho();
				if(y.getColor()==Color.RED){
					((RBTNode<K, V>) z.getPadre()).setColor(Color.BLACK);
					y.setColor(Color.BLACK);
					((RBTNode<K, V>) z.getPadre().getPadre()).setColor(Color.RED);
					z=(RBTNode<K, V>) z.getPadre().getPadre();
				}else if(z==z.getPadre().getDerecho()){
					z=(RBTNode<K, V>) z.getPadre();
					leftRotate(z,nil);
				}else{
					((RBTNode<K, V>) z.getPadre()).setColor(Color.BLACK);
					((RBTNode<K, V>) z.getPadre().getPadre()).setColor(Color.RED);
					rightRotate(z.getPadre().getPadre(),nil);
				}
			}else{
				RBTNode<K,V> y =(RBTNode<K, V>) z.getPadre().getPadre().getIzquierdo();
				if(y.getColor()==Color.RED){
					((RBTNode<K, V>) z.getPadre()).setColor(Color.BLACK);
					y.setColor(Color.BLACK);
					((RBTNode<K, V>) z.getPadre().getPadre()).setColor(Color.RED);
					z=(RBTNode<K, V>) z.getPadre().getPadre();
				}else if(z==z.getPadre().getIzquierdo()){
					z=(RBTNode<K, V>) z.getPadre();
					rightRotate(z,nil);
				}else{
					((RBTNode<K, V>) z.getPadre()).setColor(Color.BLACK);
					((RBTNode<K, V>) z.getPadre().getPadre()).setColor(Color.RED);
					leftRotate(z.getPadre().getPadre(),nil);
				}
			}
		}
		((RBTNode<K, V>) raiz).setColor(Color.BLACK);
	}
}
