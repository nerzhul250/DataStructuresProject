package mundo;

public class AVLNode<K extends Comparable<K>,V> implements Comparable<AVLNode<K,V>> {
	
	private AVLNode<K,V> clon;
	private int balanceFactor;
	private AVLNode<K,V> padre;
	private AVLNode<K,V> derecho;
	private AVLNode<K,V> izquierdo;
	private K key;
	private V valor;
	public AVLNode(K llave, V valor){
		key=llave;
		this.valor=valor;
	}
	public AVLNode<K, V> getClon() {
		return clon;
	}
	public void setClon(AVLNode<K, V> clon) {
		this.clon = clon;
	}
	public AVLNode<K, V> getPadre() {
		return padre;
	}
	public void setPadre(AVLNode<K, V> padre) {
		this.padre = padre;
	}
	public AVLNode<K, V> getDerecho() {
		return derecho;
	}
	public void setDerecho(AVLNode<K, V> derecho) {
		this.derecho = derecho;
	}
	public AVLNode<K, V> getIzquierdo() {
		return izquierdo;
	}
	public void setIzquierdo(AVLNode<K, V> izquierdo) {
		this.izquierdo = izquierdo;
	}
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValor() {
		return valor;
	}
	public void setValor(V valor) {
		this.valor = valor;
	}
	@Override
	public int compareTo(AVLNode<K, V> o) {
		return key.compareTo(o.key);
	}
	public int balanceFactor() {
		return balanceFactor;
	}
	public void setBalanceFactor(int t){
		balanceFactor=t;
	}

}
