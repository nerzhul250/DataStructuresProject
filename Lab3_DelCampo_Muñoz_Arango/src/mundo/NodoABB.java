package mundo;

public class NodoABB <K extends Comparable, V>{

	private K key;
	private V value;
	private NodoABB<K,V> daddy;
	private NodoABB<K,V> derecho;
	private NodoABB<K,V> izquierdo;
	
	public NodoABB (K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	public V getValue() {
		return value;
	}
	
	public NodoABB<K,V> getDaddy() {
		return daddy;
	}

	public void setDaddy(NodoABB<K,V> daddy) {
		this.daddy = daddy;
	}

	public NodoABB<K,V> getderecho() {
		return derecho;
	}

	public void setderecho(NodoABB<K,V> derecho) {
		this.derecho = derecho;
	}

	public NodoABB<K,V> getizquierdo() {
		return izquierdo;
	}

	public void setizquierdo(NodoABB<K,V> izquierdo) {
		this.izquierdo = izquierdo;
	}
	
}