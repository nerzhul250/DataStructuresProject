package tablasHash;

public class NodoHash<K,V>{
	private K llave;
	private V valor;
	private NodoHash<K,V> sgt;
	
	public NodoHash(K l, V v){
		llave=l;
		valor=v;
	}

	public K getLlave() {
		return llave;
	}

	public void setLlave(K llave) {
		this.llave = llave;
	}

	public V getValor() {
		return valor;
	}

	public void setValor(V valor) {
		this.valor = valor;
	}

	public NodoHash<K,V> getSgt() {
		return sgt;
	}

	public void setSgt(NodoHash<K,V> n) {
		sgt =  n;
	}
}
