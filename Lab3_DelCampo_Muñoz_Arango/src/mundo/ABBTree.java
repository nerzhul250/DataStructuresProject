package mundo;

import javax.print.attribute.standard.MediaSize.NA;

public class ABBTree<K extends Comparable<K>, V> implements InterfazABB<K, V> {

	private ABBNode<K, V> raiz;
	private ABBNode<K,V> nil;
	
	public ABBTree() {
		nil = null;
		raiz = nil;
	}
	@Override
	public void insertar(K key, V value) {
		ABBNode<K, V> nuevo = new ABBNode<>(key, value);
		if (raiz == nil)
			raiz = nuevo;
		else
			agregar(raiz, nuevo);
	}
	
	public boolean estaVacio () {
		if(raiz == nil)
			return true;
		return false;
	}
	private void agregar(ABBNode nActual, ABBNode<K, V> niu) {
		int comparacion = nActual.getKey().compareTo(niu.getKey());
		if (comparacion < 0) {
			if (nActual.getDer() == nil)
				nActual.setDer(niu);
			else
				agregar(nActual.getDer(), niu);
		} else if (comparacion > 0) {
			if (nActual.getIzq() == nil)
				nActual.setIzq(niu);
			else
				agregar(nActual.getIzq(), niu);
		} else {
			niu.setIzq(nActual.getIzq());
			niu.setDer(nActual.getDer());
			if (nActual.getDaddy() == nil)
				raiz = niu;
			else {
				niu.setDaddy(nActual.getDaddy());
				if (nActual == nActual.getDaddy().getIzq())
					nActual.getDaddy().setIzq(niu);
				else
					nActual.getDaddy().setDer(niu);
			}
		}
	}

	public V buscar(K key) {
		V valorBuscado = null;
		int comparison = key.compareTo(raiz.getKey());
		if (comparison == 0)
			valorBuscado = raiz.getValue();
		else
			valorBuscado = buscar(key, raiz);
		return valorBuscado;
	}

	private V buscar(K key, ABBNode<K,V> nActual) {
		int comparison = key.compareTo(nActual.getKey());
		if (comparison == 0)
			return nActual.getValue();
		else if (comparison > 0) {
			if(nActual.getDer() != nil)
				return (V) buscar(key, nActual.getDer());
		}
		else {
			if(nActual.getIzq() != nil)
			return (V) buscar(key, nActual.getIzq());
		}
		return null;
	}

	@Override
	public boolean eliminar(K key) {
		if(raiz == nil)
		return false;
		else if(raiz.getKey().compareTo(key) == 0) {
			ABBNode<K, V> izq = raiz.getIzq();
			ABBNode<K, V> der = raiz.getDer();
			ABBNode<K, V> mayorIzq = mayor(raiz.getIzq());
			raiz = mayorIzq;
			eliminar(mayorIzq.getKey(), mayorIzq);
			raiz.setIzq(izq);
			raiz.setDer(der);
		}
			return eliminar(key, raiz);
	}

	private ABBNode<K,V> mayor(ABBNode nodo) {
		ABBNode mayor = nodo;
		while (mayor.getDer() != nil)
			mayor = mayor.getDer();
		return mayor;
	}

	private boolean eliminar(K key, ABBNode<K, V> nActual) {
		if(nActual.getDer().getKey().compareTo(key) == 0) {
			if(nActual.getIzq() == nil) {
				
				if(nActual.getDer() == nil) {
					if(nActual == nActual.getDaddy().getIzq())
					nActual.getDaddy().setIzq(nil);
					else
						nActual.getDaddy().setDer(nil);
				}
				else {
//					if (nActual.getDaddy().get)
//						nActual.getDaddy()
				}
			}
		}
		return true;
	}

}
