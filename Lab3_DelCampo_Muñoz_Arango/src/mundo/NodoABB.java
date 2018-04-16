package mundo;

public abstract class NodoABB <K extends Comparable, V> implements Comparable{

	
	protected K key;
	protected V value;
	protected int altura;
	protected NodoABB<K,V> padre;
	protected NodoABB<K,V> derecho;
	protected NodoABB<K,V> izquierdo;
	protected NodoABB<K,V> clon;
	
	public NodoABB (K llave, V value) {
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

	public NodoABB<K, V> getPadre() {
		return padre;
	}

	public void setPadre(NodoABB<K, V> padre) {
		this.padre = padre;
	}

	public NodoABB<K, V> getDerecho() {
		return derecho;
	}

	public void setDerecho(NodoABB<K, V> derecho) {
		this.derecho = derecho;
	}

	public NodoABB<K, V> getIzquierdo() {
		return izquierdo;
	}

	public void setIzquierdo(NodoABB<K, V> izquierdo) {
		this.izquierdo = izquierdo;
	}

	public NodoABB<K, V> getClon() {
		return clon;
	}

	public void setClon(NodoABB<K, V> clon) {
		this.clon = clon;
	}
	public void recorrerSubArbol(String string, NodoABB<K,V> nil) {
		System.out.println(string+" "+key);
		if(izquierdo!=nil)
			izquierdo.recorrerSubArbol(string+"L",nil);
		if(derecho!=nil)
			derecho.recorrerSubArbol(string+"R",nil);
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
		return key.compareTo(((NodoABB)o).key);
	}
	
}