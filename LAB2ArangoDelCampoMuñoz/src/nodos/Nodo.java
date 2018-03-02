package nodos;

public class Nodo<T> {
	private T elemento;
	private Nodo<T> sgt;
	public Nodo(T e){
		elemento=e;
	}
	public T getElemento() {
		return elemento;
	}
	public void setElemento(T elemento) {
		this.elemento = elemento;
	}
	public Nodo<T> getSgt() {
		return sgt;
	}
	public void setSgt(Nodo<T> sgt) {
		this.sgt = sgt;
	}
}
