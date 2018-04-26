package mundo;

import javax.print.attribute.standard.MediaSize.NA;

public abstract class ABB<K extends Comparable, V> implements InterfazABB<K, V> {

	protected NodoABB<K, V> raiz;
	public NodoABB<K, V> nil;

	public ABB() {
		nil = null;
		raiz = nil;
	}

	protected void insertar(NodoABB<K, V> z) {
		NodoABB<K, V> y = null;
		if (nil != null)
			y = (NodoABB<K, V>) nil;
		NodoABB<K, V> x = raiz;
		while (x != nil) {
			y = x;
			if (x.compareTo(z) > 0) {           
				NodoABB<K, V> padre = x;
				x = x.getIzquierdo();
				if (x != nil && padre.altura == x.altura + 1)
					padre.altura++;
				if (padre.getDerecho() == nil && x == nil) {
					padre.altura++;
				}
			} else if (x.compareTo(z) < 0) {
				NodoABB<K, V> padre = x;
				x = x.getDerecho();
				if (x != nil && padre.altura == x.altura + 1)
					padre.altura++;
				if (padre.getIzquierdo() == nil && x == nil) {
					padre.altura++;
				}
			} else {
				NodoABB<K, V> w = x.getClon();
				while (w != null) {
					x = w;
					w = w.getClon();
				}
				x.setClon(z);
				NodoABB<K, V> p = null;
				if (nil != null)
					p = (NodoABB<K, V>) nil;
				z.setDerecho(p);
				z.setIzquierdo(p);
				z.setPadre(p);
				return;
			}
		}
		z.setPadre(y);
		if (y == nil) {
			raiz = z;
		} else if (y.compareTo(z) > 0) {
			y.setIzquierdo(z);
		} else {
			y.setDerecho(z);
		}
		NodoABB<K, V> p = null;
		if (nil != null)
			p = (NodoABB<K, V>) nil;
		z.setDerecho(p);
		z.setIzquierdo(p);
	}

	public NodoABB<K, V> consultar(K key) {
		NodoABB<K, V> y = null;
		if (nil != null)
			y = (NodoABB<K, V>) nil;
		NodoABB<K, V> x = raiz;
		while (x != nil) {
			y = x;
			if (x.getKey().compareTo(key) > 0) {
				x = x.getIzquierdo();
			} else if (x.getKey().compareTo(key) < 0) {
				x = x.getDerecho();
			} else {
				return x;
			}
		}
		return null;
	}

	protected void leftRotate(NodoABB<K, V> x) {
		NodoABB<K, V> y = x.getDerecho();
		x.setDerecho(y.getIzquierdo());
		if (y.getIzquierdo() != nil) {
			y.getIzquierdo().setPadre(x);
		}
		y.setPadre(x.getPadre());
		if (x.getPadre() == nil) {
			raiz = y;
		} else if (x == x.getPadre().getIzquierdo()) {
			x.getPadre().setIzquierdo(y);
		} else {
			x.getPadre().setDerecho(y);
		}
		y.setIzquierdo(x);
		x.setPadre(y);
		x.actualizarAltura();
		y.actualizarAltura();
	}

	protected void rightRotate(NodoABB<K, V> x) {
		NodoABB<K, V> y = x.getIzquierdo();
		x.setIzquierdo(y.getDerecho());
		if (y.getDerecho() != nil) {
			y.getDerecho().setPadre(x);
		}
		y.setPadre(x.getPadre());
		if (x.getPadre() == nil) {
			raiz = y;
		} else if (x == x.getPadre().getIzquierdo()) {
			x.getPadre().setIzquierdo(y);
		} else {
			x.getPadre().setDerecho(y);
		}
		y.setDerecho(x);
		x.setPadre(y);
		x.actualizarAltura();
		y.actualizarAltura();
	}

	public boolean estaVacio() {
		if (raiz == null)
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
	
	public abstract NodoABB<K,V> eliminar(K key);

	private NodoABB<K, V> sucesor(NodoABB<K,V> x) {
		if(x.getDerecho()!=nil) {
			return minimo(x.getDerecho());
		}
		NodoABB<K,V> y=x.getPadre();
		while(y!=nil && x==y.getDerecho()) {
			x=y;
			y=y.getPadre();
		}
		return y;
	}

	private NodoABB<K, V> minimo(NodoABB<K, V> d) {
		NodoABB<K,V>actual=d;
		while(actual.getIzquierdo()!=nil) {
			actual=actual.getIzquierdo();
		}
		return actual;
	}
	protected NodoABB[] eliminar(NodoABB<K, V> z) {
		NodoABB<K,V> y=nil;
		if (z.getDerecho()==nil || z.getIzquierdo()==nil) {
			y=z;
		}else{
			y=sucesor(z);
		}
		NodoABB<K,V> x=nil;
		if(y.getIzquierdo()!=nil) {
			x=y.getIzquierdo();
		}else {
			x=y.getDerecho();
		}
		
		if(x!=null) {
			x.setPadre(y.getPadre());	
		}
		if(y.getPadre()==nil) {
			raiz=x;
		}else {
			if(y==y.getPadre().getIzquierdo()) {
				y.getPadre().setIzquierdo(x);
			}else {
				y.getPadre().setDerecho(x);
			}
		}
		if(nil==null && x==null) {
			x=y.getPadre();
		}
		
		if(y!=z) {
			z.setKey(y.getKey());
			z.setValue(y.getValue());
		}
		NodoABB<K,V>[]ans=new NodoABB[2];
		ans[0]=x;
		ans[1]=y;
		return ans;
	}
}