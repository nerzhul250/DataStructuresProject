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

	protected void leftRotate(NodoABB<K, V> x, Object nil) {
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

	protected void rightRotate(NodoABB<K, V> x, Object nil) {
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

	public boolean eliminar(K key) {
		if (raiz == nil)
			return false;
		return eliminar(key, raiz);
	}

	private NodoABB<K, V> mayor(NodoABB nodo) {
		NodoABB mayor = nodo;
		while (mayor.getDerecho() != nil)
			mayor = mayor.getDerecho();
		return mayor;
	}

	private boolean eliminar(K key, NodoABB<K, V> nActual) {
		NodoABB<K, V> padre = nActual.getPadre();
		NodoABB<K, V> izq = nActual.getIzquierdo();
		NodoABB<K, V> der = nActual.getDerecho();
		if (nActual.getKey().compareTo(key) == 0) {
			if (izq == nil) {
				if (nActual != raiz) {
					if (padre.getIzquierdo() == nActual)
						padre.setIzquierdo(der);
					else
						padre.setDerecho(der);
					if(der != nil)
						der.setPadre(padre);
				} else
					raiz = der;
			} else {
				NodoABB<K, V> mayorIzq = mayor(izq);
				eliminar(mayorIzq.getKey(), izq);
				if (nActual == raiz)
					raiz = mayorIzq;
				mayorIzq.setPadre(padre);
				if (padre != nil) {
					if (padre.getIzquierdo() == nActual)
						padre.setIzquierdo(mayorIzq);
					else
						padre.setDerecho(mayorIzq);
				}
				// se vuelve a escoger porque mayorIzq pudo ser Izq y se repite
				mayorIzq.setIzquierdo(nActual.getIzquierdo());
				mayorIzq.setDerecho(der);
			}
		} else if (nActual.getKey().compareTo(key) > 0) {
			if (izq == nil)
				return false;
			else
				eliminar(key, izq);
		} else {
			if (der == nil)
				return false;
			else
				eliminar(key, der);
		}
		return true;
	}
}