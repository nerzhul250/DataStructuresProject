package mundo;

import colas.ICola;
import pilas.IPila;

public class Bahia implements ICola,IPila{
	public int capacidadBahia;
	public String[] pila;
	public String[] cola;
	
	public Bahia(int capacidad) {
		capacidadBahia=capacidad;
		String[] pila=new String[capacidadBahia];
		String[] cola=new String [capacidadBahia];
	}

	public Object pop() {
		// TODO Auto-generated method stub
		return null;
	}

	public void push(String x) {
		// TODO Auto-generated method stub
		
	}

	public Object unQueue() {
		// TODO Auto-generated method stub
		return null;
	}

	public void queue(String x) {
		// TODO Auto-generated method stub
		
	}


	


}
