package colas;

import nodos.Nodo;

public class ColaEnlazada<T> implements ICola<T> {
	
	private Nodo<T> primero;
	private Nodo<T> ultimo;
	public int numeroElementos;
	
	public ColaEnlazada(){
		primero=null;
		ultimo=null;
		numeroElementos=0;
	}
	
	@Override
	public boolean queue(T t) {
		if(primero==null){
			primero=new Nodo<T>(t);
			ultimo=primero;
		}else{
			Nodo<T> nuevo=new Nodo<>(t);
			ultimo.setSgt(nuevo);
			ultimo=nuevo;
		}
		numeroElementos++;
		return true;
	}
	
	@Override
	public T unQueue(){
		if(primero==null){
			return null;
		}else{
			Nodo<T>aux=primero;
			primero=primero.getSgt();
			numeroElementos--;
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
