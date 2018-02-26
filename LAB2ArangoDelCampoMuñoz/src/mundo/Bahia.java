package mundo;

import colas.ICola;
import pilas.IPila;
import pilas.PilaVaciaException;

public class Bahia implements ICola<Automovil>,IPila<Automovil>{
	public int capacidadBahia;
	public Automovil[] pila;
	public Automovil[] cola;
	
	public Bahia(int capacidad) {
		capacidadBahia=capacidad;
		Automovil[] pila=new Automovil[capacidadBahia];
		Automovil[] cola=new Automovil [capacidadBahia];
	}

	@Override
	public Automovil unQueue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean queue(Automovil t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Automovil front() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Automovil pop() throws PilaVaciaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean push(Automovil t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Automovil top() {
		// TODO Auto-generated method stub
		return null;
	}


}
