package mundo;

import javax.print.attribute.standard.MediaSize.NA;

public abstract class ABB<K extends Comparable, V> implements InterfazABB<K, V> {

	protected ABBNode<K, V> raiz;
	public ABBNode<K, V> nil;

	public ABB() {
		nil = null;
		raiz = nil;
	}

	protected void insertar(ABBNode<K, V> z) {
		ABBNode<K, V> y = null;
		if (nil != null)
			y = (ABBNode<K, V>) nil;
		ABBNode<K, V> x = raiz;
		while (x != nil) {
			y = x;
			if (x.compareTo(z) > 0) {           
				ABBNode<K, V> padre = x;
				x = x.getIzquierdo();
				if (x != nil && padre.altura == x.altura + 1)
					padre.altura++;
				if (padre.getDerecho() == nil && x == nil) {
					padre.altura++;
				}
			} else if (x.compareTo(z) < 0) {
				ABBNode<K, V> padre = x;
				x = x.getDerecho();
				if (x != nil && padre.altura == x.altura + 1)
					padre.altura++;
				if (padre.getIzquierdo() == nil && x == nil) {
					padre.altura++;
				}
			} else {
				ABBNode<K, V> w = x.getClon();
				while (w != null) {
					x = w;
					w = w.getClon();
				}
				x.setClon(z);
				ABBNode<K, V> p = null;
				if (nil != null)
					p = (ABBNode<K, V>) nil;
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
		ABBNode<K, V> p = null;
		if (nil != null)
			p = (ABBNode<K, V>) nil;
		z.setDerecho(p);
		z.setIzquierdo(p);
	}

	public ABBNode<K, V> consultar(K key) {
		if(key==null) {
			return null;
		}
		ABBNode<K, V> y = null;
		if (nil != null)
			y = (ABBNode<K, V>) nil;
		ABBNode<K, V> x = raiz;
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

	protected void leftRotate(ABBNode<K, V> x) {
		ABBNode<K, V> y = x.getDerecho();
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

	protected void rightRotate(ABBNode<K, V> x) {
		ABBNode<K, V> y = x.getIzquierdo();
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

	public ABBNode<K, V> getRaiz() {
		return raiz;
	}

	public void setRaiz(ABBNode<K, V> raiz) {
		this.raiz = raiz;
	}
	
	public abstract void insertar(K key, V value);
	
	public abstract ABBNode<K,V> eliminar(K key);

	private ABBNode<K, V> sucesor(ABBNode<K,V> x) {
		if(x.getDerecho()!=nil) {
			return minimo(x.getDerecho());
		}
		ABBNode<K,V> y=x.getPadre();
		while(y!=nil && x==y.getDerecho()) {
			x=y;
			y=y.getPadre();
		}
		return y;
	}

	private ABBNode<K, V> minimo(ABBNode<K, V> d) {
		ABBNode<K,V>actual=d;
		while(actual.getIzquierdo()!=nil) {
			actual=actual.getIzquierdo();
		}
		return actual;
	}
	protected ABBNode[] eliminar(ABBNode<K, V> z) {
		ABBNode<K,V> y=nil;
		if (z.getDerecho()==nil || z.getIzquierdo()==nil) {
			y=z;
		}else{
			y=sucesor(z);
		}
		ABBNode<K,V> x=nil;
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
		ABBNode<K,V>[]ans=new ABBNode[2];
		ans[0]=x;
		ans[1]=y;
		return ans;
	}
}