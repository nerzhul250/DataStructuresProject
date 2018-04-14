package mundo;

public class ABBNode <K extends Comparable, V>{

	private K key;
	private V value;
	private ABBNode daddy;
	private ABBNode der;
	private ABBNode izq;
	
	public ABBNode (K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}
	public V getValue() {
		return value;
	}
	
	public ABBNode getDaddy() {
		return daddy;
	}

	public void setDaddy(ABBNode daddy) {
		this.daddy = daddy;
	}

	public ABBNode getDer() {
		return der;
	}

	public void setDer(ABBNode der) {
		this.der = der;
	}

	public ABBNode getIzq() {
		return izq;
	}

	public void setIzq(ABBNode izq) {
		this.izq = izq;
	}
	
}
