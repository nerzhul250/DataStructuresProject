package mundo;

public abstract class ABBNode <K extends Comparable, V> implements Comparable{

	
	protected K key;
	protected V value;
	protected int altura;
	protected ABBNode<K,V> padre;
	protected ABBNode<K,V> derecho;
	protected ABBNode<K,V> izquierdo;
	protected ABBNode<K,V> clon;
	
	public ABBNode (K llave, V value) {
		this.key = llave;
		this.value = value;
	}
	
	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public ABBNode<K, V> getPadre() {
		return padre;
	}

	public void setPadre(ABBNode<K, V> padre) {
		this.padre = padre;
	}

	public ABBNode<K, V> getDerecho() {
		return derecho;
	}

	public void setDerecho(ABBNode<K, V> derecho) {
		this.derecho = derecho;
	}

	public ABBNode<K, V> getIzquierdo() {
		return izquierdo;
	}

	public void setIzquierdo(ABBNode<K, V> izquierdo) {
		this.izquierdo = izquierdo;
	}

	public ABBNode<K, V> getClon() {
		return clon;
	}

	public void setClon(ABBNode<K, V> clon) {
		this.clon = clon;
	}
	public void actualizarAltura() {
		if(derecho==null && izquierdo==null) {
			altura=-1;
		}else if(derecho==null) {
			altura=izquierdo.altura;
		}else if(izquierdo==null) {
			altura=derecho.altura;
		}else {
			altura=Math.max(derecho.altura,izquierdo.altura);
		}
		altura++;
	}
	@Override
	public int compareTo(Object o) {
		return key.compareTo(((ABBNode)o).key);
	}
	
}