package mundo;

import javax.print.attribute.standard.MediaSize.NA;

public class ABB<K extends Comparable<K>, V> implements InterfazABB<K, V> {

	private NodoABB<K, V> raiz;

	@Override
	public void insertar(K key, V value) {
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
			if (nActual.getderecho() == null)
				nActual.setderecho(niu);
			else
				agregar(nActual.getderecho(), niu);
		} else if (comparacion > 0) {
			if (nActual.getizquierdo() == null)
				nActual.setizquierdo(niu);
			else
				agregar(nActual.getizquierdo(), niu);
		} else {
			niu.setizquierdo(nActual.getizquierdo());
			niu.setderecho(nActual.getderecho());
			if (nActual.getDaddy() == null)
				raiz = niu;
			else {
				niu.setDaddy(nActual.getDaddy());
				if (nActual == nActual.getDaddy().getizquierdo())
					nActual.getDaddy().setizquierdo(niu);
				else
					nActual.getDaddy().setderecho(niu);
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

	private V buscar(K key, NodoABB<K,V> nActual) {
		int comparison = key.compareTo(nActual.getKey());
		if (comparison == 0)
			return nActual.getValue();
		else if (comparison > 0) {
			if(nActual.getderecho() != null)
				return (V) buscar(key, nActual.getderecho());
		}
		else {
			if(nActual.getizquierdo() != null)
			return (V) buscar(key, nActual.getizquierdo());
		}
		return null;
	}
	@Override
	public boolean eliminar(K key) {
		// TODO Auto-generated method stub
		return false;
	}

}
