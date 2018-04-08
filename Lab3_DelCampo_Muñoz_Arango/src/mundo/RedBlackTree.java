package mundo;

import java.util.ArrayList;

public class RedBlackTree<K extends Comparable<K>,V> implements InterfazABB<K, V> {
	public RBTNode<K,V> nil;
	private RBTNode<K,V> raiz;
	
	public RedBlackTree(){
		nil=new RBTNode<>(null,null);
		nil.setPadre(nil);
		nil.setDerecho(nil);
		nil.setIzquierdo(nil);
		nil.setColor(Color.BLACK);
		raiz=nil;
	}
	@Override
	public void insertar(K key, V value) {
		insertar(new RBTNode<K,V>(key,value));
	}

	@Override
	public boolean eliminar(K key) {
		// TODO Auto-generated method stub
		return false;
	}
	private void insertar(RBTNode<K,V> z){
		RBTNode<K,V> y=nil;
		RBTNode<K,V> x=raiz;
		while(x!=nil){
			y=x;
			if(x.compareTo(z)>0){
				x=x.getIzquierdo();
			}else if(x.compareTo(z)<0){
				x=x.getDerecho();
			}else{
				RBTNode<K,V> w=x.getClon();
				while(w!=null){
					x=w;
					w=w.getClon();
				}
				x.setClon(z);
				z.setDerecho(nil);
				z.setIzquierdo(nil);
				z.setPadre(nil);
				return;
			}
		}
		z.setPadre(y);
		if(y==nil){
			raiz=z;
		}else if(y.compareTo(z)>0){
			y.setIzquierdo(z);
		}else{y.setDerecho(z);}
		z.setDerecho(nil);
		z.setIzquierdo(nil);
		insertFixeUp(z);
	}
	public RBTNode<K,V> consultar(K llave){
		RBTNode<K,V> y=nil;
		RBTNode<K,V> x=raiz;
		while(x!=nil){
			y=x;
			if(x.getKey().compareTo(llave)>0){
				x=x.getIzquierdo();
			}else if(x.getKey().compareTo(llave)<0){
				x=x.getDerecho();
			}else{
				return x;
			}
		}
		return null;
	}
	private void insertFixeUp(RBTNode<K, V> z) {
		while(z.getPadre().getColor()==Color.RED){
			if(z.getPadre()==z.getPadre().getPadre().getIzquierdo()){
				RBTNode<K,V> y =z.getPadre().getPadre().getDerecho();
				if(y.getColor()==Color.RED){
					z.getPadre().setColor(Color.BLACK);
					y.setColor(Color.BLACK);
					z.getPadre().getPadre().setColor(Color.RED);
					z=z.getPadre().getPadre();
				}else if(z==z.getPadre().getDerecho()){
					z=z.getPadre();
					leftRotate(z);
				}else{
					z.getPadre().setColor(Color.BLACK);
					z.getPadre().getPadre().setColor(Color.RED);
					rightRotate(z.getPadre().getPadre());
				}
			}else{
				RBTNode<K,V> y =z.getPadre().getPadre().getIzquierdo();
				if(y.getColor()==Color.RED){
					z.getPadre().setColor(Color.BLACK);
					y.setColor(Color.BLACK);
					z.getPadre().getPadre().setColor(Color.RED);
					z=z.getPadre().getPadre();
				}else if(z==z.getPadre().getIzquierdo()){
					z=z.getPadre();
					rightRotate(z);
				}else{
					z.getPadre().setColor(Color.BLACK);
					z.getPadre().getPadre().setColor(Color.RED);
					leftRotate(z.getPadre().getPadre());
				}
			}
		}
		raiz.setColor(Color.BLACK);
	}
	private void leftRotate(RBTNode<K, V> x){
		RBTNode<K, V> y=x.getDerecho();
		x.setDerecho(y.getIzquierdo());
		if(y.getIzquierdo()!=nil){
			y.getIzquierdo().setPadre(x);
		}
		y.setPadre(x.getPadre());
		if(x.getPadre()==nil){
			raiz=y;
		}else if(x==x.getPadre().getIzquierdo()){
			x.getPadre().setIzquierdo(y);
		}else{
			x.getPadre().setDerecho(y);
		}
		y.setIzquierdo(x);
		x.setPadre(y);
	}
	private void rightRotate(RBTNode<K, V> x){
		RBTNode<K, V> y=x.getIzquierdo();
		x.setIzquierdo(y.getDerecho());
		if(y.getDerecho()!=nil){
			y.getDerecho().setPadre(x);
		}
		y.setPadre(x.getPadre());
		if(x.getPadre()==nil){
			raiz=y;
		}else if(x==x.getPadre().getIzquierdo()){
			x.getPadre().setIzquierdo(y);
		}else{
			x.getPadre().setDerecho(y);
		}
		y.setDerecho(x);
		x.setPadre(y);
	}
	public RBTNode<K, V> getRaiz() {
		return raiz;
	}
	public void setRaiz(RBTNode<K, V> raiz) {
		this.raiz = raiz;
	}
}
