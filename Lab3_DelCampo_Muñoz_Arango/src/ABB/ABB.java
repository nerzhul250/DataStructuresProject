package ABB;

import javax.print.attribute.standard.MediaSize.NA;

public class ABB<K extends Comparable, V> implements InterfazABB<K, V> {

	private NodoABB<K, V> raiz;

	@Override
	public void agregar(K key, V value) {
		NodoABB<K, V> nuevo = new NodoABB<>(key, value);
		if (raiz == null)
			raiz = nuevo;
		else
			agregar(raiz, nuevo);
	}
	
	public boolean estaVacio () {
		if(raiz == null)
			return true;
		return false;
	}
	private void agregar(NodoABB nActual, NodoABB<K, V> niu) {
		int comparacion = nActual.getKey().compareTo(niu.getKey());
		if (comparacion < 0) {
			if (nActual.getDer() == null)
				nActual.setDer(niu);
			else
				agregar(nActual.getDer(), niu);
		} else if (comparacion > 0) {
			if (nActual.getIzq() == null)
				nActual.setIzq(niu);
			else
				agregar(nActual.getIzq(), niu);
		} else {
			niu.setIzq(nActual.getIzq());
			niu.setDer(nActual.getDer());
			if (nActual.getDaddy() == null)
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

	@Override
	public V buscar(K key) {
		V valorBuscado = null;
		int comparison = key.compareTo(raiz.getKey());
		if (comparison == 0)
			valorBuscado = raiz.getValue();
		else
			valorBuscado = buscar(key, raiz);
		return valorBuscado;
	}

	private V buscar(K key, NodoABB<K,V> nActual) {
		int comparison = key.compareTo(nActual.getKey());
		if (comparison == 0)
			return nActual.getValue();
		else if (comparison > 0) {
			if(nActual.getDer() != null)
				return (V) buscar(key, nActual.getDer());
		}
		else {
			if(nActual.getIzq() != null)
			return (V) buscar(key, nActual.getIzq());
		}
		return null;
	}

	@Override
	public boolean eliminar(K key) {
		// TODO Auto-generated method stub
		return false;
	}

}
