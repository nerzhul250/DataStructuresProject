package mundo;

public class NodoABB <K extends Comparable, V>{

	private K key;
	private V value;
	private NodoABB daddy;
	private NodoABB der;
	private NodoABB izq;
	
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
	
	public NodoABB getDaddy() {
		return daddy;
	}

	public void setDaddy(NodoABB daddy) {
		this.daddy = daddy;
	}

	public NodoABB getDer() {
		return der;
	}

	public void setDer(NodoABB der) {
		this.der = der;
	}

	public NodoABB getIzq() {
		return izq;
	}

	public void setIzq(NodoABB izq) {
		this.izq = izq;
	}
	
}
