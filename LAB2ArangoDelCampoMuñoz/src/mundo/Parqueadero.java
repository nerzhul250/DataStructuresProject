package mundo;

import java.util.ArrayList;

import colas.ICola;

public class Parqueadero implements ICola<Automovil>{ 
	Bahia[] bahias;
	
	ArrayList<Automovil> filaEntrada;
	int limiteVehiculos;
	
	int limiteVehiculosPorBahia;
	
	
	public Parqueadero(int numBahias,int totalCarrosIngresan, int capacidadBahia) {
		
		limiteVehiculos=totalCarrosIngresan;
		limiteVehiculosPorBahia=capacidadBahia;
		Bahia[] bahias=crearBahias(capacidadBahia, numBahias);
		
		
		ArrayList<Automovil> filaEntrada=new ArrayList<Automovil>();
	}
	
	
	@Override
	public Automovil unQueue() {
		if(filaEntrada!=null&&filaEntrada.get(0)!=null) {
			Automovil entra=filaEntrada.get(0);
			for(int i=1;i<filaEntrada.size()-1;i++) {
				filaEntrada.set(i-1, filaEntrada.get(i));
			}
			filaEntrada.remove(filaEntrada.size()-1);
			return entra;	
		}else
			return null;
		}
	
	@Override
	public boolean queue(Automovil t) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean isEmpty() {
		if(filaEntrada!=null&&filaEntrada.get(0)!=null) {
			return false;
		}else 
			return true;
	}

	@Override
	public Automovil front() {
		if(filaEntrada!=null&&filaEntrada.get(0)!=null) {
		return filaEntrada.get(0);
		}else 
			return null;
	}
	
	public Bahia[] crearBahias(int capacidadPorBahia,int numeroDeBahias) {
		
		Bahia retorno[]=new Bahia[numeroDeBahias];
		
		for(int i=0;i<numeroDeBahias;i++) {
			Bahia nueva=new Bahia(capacidadPorBahia);
			retorno[i]=nueva;
		}
		
		return retorno;
	}
	



	public Bahia[] getBahias() {
		return bahias;
	}


	public void setBahias(Bahia[] bahias) {
		this.bahias = bahias;
	}


	public ArrayList<Automovil> getFilaEntrada() {
		return filaEntrada;
	}


	public void setFilaEntrada(ArrayList<Automovil> filaEntrada) {
		this.filaEntrada = filaEntrada;
	}


	public int getLimiteVehiculos() {
		return limiteVehiculos;
	}


	public void setLimiteVehiculos(int limiteVehiculos) {
		this.limiteVehiculos = limiteVehiculos;
	}


	public int getLimiteVehiculosPorBahia() {
		return limiteVehiculosPorBahia;
	}


	public void setLimiteVehiculosPorBahia(int limiteVehiculosPorBahia) {
		this.limiteVehiculosPorBahia = limiteVehiculosPorBahia;
	}



}
