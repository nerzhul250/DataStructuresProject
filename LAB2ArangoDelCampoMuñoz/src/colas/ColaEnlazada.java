package colas;

import pilas.NodoPila;

public class ColaEnlazada<T> implements ICola<T> {
	
	private NodoCola<T> primero;
	private NodoCola<T> ultimo;
	private int numeroElementos;
	
	public ColaEnlazada(){
		primero=null;
		ultimo=null;
		numeroElementos=0;
	}
	
	@Override
	public boolean queue(T t) {
		if(primero==null){
			primero=new NodoCola<T>(t);
			ultimo=primero;
		}else{
			NodoCola<T> nuevo=new NodoCola<>(t);
			ultimo.setSgt(nuevo);
			ultimo=nuevo;
		}
		numeroElementos++;
		return true;
	}
	
	@Override
	public T unQueue() {
		if(primero==null){
			return null;
		}else{
			NodoCola<T>aux=primero;
			primero=primero.getSgt();
			return aux.getElemento();
		}
	}

	@Override
	public T front() {
		return primero.getElemento();
	}

	@Override
	public boolean isEmpty() {
		return numeroElementos==0;
	}
	
}
