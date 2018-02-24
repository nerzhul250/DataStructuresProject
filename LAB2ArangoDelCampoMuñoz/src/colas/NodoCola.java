package colas;

public class NodoCola<T> {
	private T elemento;
	private NodoCola<T> sgt;
	public NodoCola(T e){
		elemento=e;
	}
	public T getElemento() {
		return elemento;
	}
	public void setElemento(T elemento) {
		this.elemento = elemento;
	}
	public NodoCola<T> getSgt() {
		return sgt;
	}
	public void setSgt(NodoCola<T> sgt) {
		this.sgt = sgt;
	}
}
