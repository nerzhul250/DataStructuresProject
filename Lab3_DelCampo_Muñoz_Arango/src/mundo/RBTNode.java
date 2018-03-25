package mundo;

enum Color{
	BLACK,RED
}
public class RBTNode<K extends Comparable<K>,V> implements Comparable<RBTNode<K,V>> {
	
	private RBTNode<K,V> clon;
	private Color color;
	private RBTNode<K,V> padre;
	private RBTNode<K,V> derecho;
	private RBTNode<K,V> izquierdo;
	private K key;
	private V valor;
	public RBTNode(K llave, V valor){
		clon=null;
		color=Color.RED;
		key=llave;
		this.valor=valor;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public RBTNode<K, V> getPadre() {
		return padre;
	}
	public void setPadre(RBTNode<K, V> padre) {
		this.padre = padre;
	}
	public RBTNode<K, V> getDerecho() {
		return derecho;
	}
	public void setDerecho(RBTNode<K, V> derecho) {
		this.derecho = derecho;
	}
	public RBTNode<K, V> getIzquierdo() {
		return izquierdo;
	}
	public void setIzquierdo(RBTNode<K, V> izquierdo) {
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
	public RBTNode<K, V> getClon() {
		return clon;
	}
	public void setClon(RBTNode<K, V> clon) {
		this.clon = clon;
	}
	@Override
	public int compareTo(RBTNode<K, V> o) {
		return key.compareTo(o.key);
	}
	public void recorrerSubArbol(String string, RBTNode<Integer, Integer> nil) {
		System.out.println(string+" "+key);
		if(izquierdo!=nil)
			izquierdo.recorrerSubArbol(string+"L",nil);
		if(derecho!=nil)
			derecho.recorrerSubArbol(string+"R",nil);
	}
}