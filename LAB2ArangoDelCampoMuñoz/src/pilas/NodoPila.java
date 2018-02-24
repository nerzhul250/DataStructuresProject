package pilas;

public class NodoPila<T> {
	private T elemento;
	private NodoPila<T> sgt;
	public NodoPila(T e){
		elemento=e;
	}
	public T getElemento() {
		return elemento;
	}
	public void setElemento(T elemento) {
		this.elemento = elemento;
	}
	public NodoPila<T> getSgt() {
		return sgt;
	}
	public void setSgt(NodoPila<T> sgt) {
		this.sgt = sgt;
	}
}
