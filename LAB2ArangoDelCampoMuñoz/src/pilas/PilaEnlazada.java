package pilas;

import nodos.Nodo;
import tablasHash.NodoHash;

public class PilaEnlazada<T> implements IPila<T> {
	
	private Nodo<T> tope;
	private int numeroElementos;
	
	public PilaEnlazada(){
		tope=null;
		numeroElementos=0;
	}
	@Override
	public T pop() throws PilaVaciaException {
		if(tope==null){
			throw new PilaVaciaException("VACIA");
		}
		Nodo<T>n=tope;
		tope=tope.getSgt();
		numeroElementos--;
		return n.getElemento();
	}

	@Override
	public boolean push(T t) {
		Nodo<T>nuevo=new Nodo<>(t);
		nuevo.setSgt(tope);
		tope=nuevo;
		numeroElementos++;
		return true;
	}

	@Override
	public boolean isEmpty() {
		return numeroElementos==0;
	}

	@Override
	public T top() {
		if(tope==null){
			return null;
		}else{
			return tope.getElemento();			
		}
	}

}
