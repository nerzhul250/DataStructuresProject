package mundo;

import javax.print.attribute.standard.MediaSize.NA;

public abstract class ABB<K extends Comparable, V> implements InterfazABB<K, V> {

	protected NodoABB<K, V> raiz;
	
	public ABB() {
		raiz=null;
	}
	
	protected void insertar(NodoABB<K,V> z,Object nil){
		NodoABB<K,V> y=null;
		if(nil!=null)
			y=(NodoABB<K, V>) nil;			
		NodoABB<K,V> x=raiz;
		while(x!=nil){
			y=x;
			if(x.compareTo(z)>0){
				x=x.getIzquierdo();
			}else if(x.compareTo(z)<0){
				x=x.getDerecho();
			}else{
				NodoABB<K,V> w=x.getClon();
				while(w!=null){
					x=w;
					w=w.getClon();
				}
				x.setClon(z);
				NodoABB<K, V> p=null;
				if(nil!=null) 
					p=(NodoABB<K, V>)nil;
				z.setDerecho(p);
				z.setIzquierdo(p);
				z.setPadre(p);
				return;
			}
		}
		z.setPadre(y);
		if(y==nil){
			raiz=z;
		}else if(y.compareTo(z)>0){
			y.setIzquierdo(z);
		}else{y.setDerecho(z);}
		NodoABB<K, V> p=null;
		if(nil!=null) 
			p=(NodoABB<K, V>)nil;
		z.setDerecho(p);
		z.setIzquierdo(p);
	}

	public NodoABB<K, V> consultar(K key,Object nil) {
		NodoABB<K,V> y=null;
		if(nil!=null)
			y=(NodoABB<K, V>) nil;
		NodoABB<K,V> x=raiz;
		while(x!=nil){
			y=x;
			if(x.getKey().compareTo(key)>0){
				x=x.getIzquierdo();
			}else if(x.getKey().compareTo(key)<0){
				x=x.getDerecho();
			}else{
				return x;
			}
		}
		return null;
	}
	protected void leftRotate(NodoABB<K, V> x,Object nil){
		NodoABB<K, V> y=x.getDerecho();
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
	protected void rightRotate(NodoABB<K, V> x,Object nil){
		NodoABB<K, V> y=x.getIzquierdo();
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
	public boolean estaVacio () {
		if(raiz == null)
			return true;
		return false;
	}
	public NodoABB<K, V> getRaiz() {
		return raiz;
	}

	public void setRaiz(NodoABB<K, V> raiz) {
		this.raiz = raiz;
	}
	public abstract void insertar(K key, V value);
	public abstract boolean eliminar(K key);
}