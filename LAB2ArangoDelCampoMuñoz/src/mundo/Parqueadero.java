package mundo;

import java.util.ArrayList;

import colas.ColaEnlazada;
import colas.ICola;
import pilas.IPila;

public class Parqueadero  { 
	
	Bahia[] bahias;
	
	ICola<Automovil>filaEntrada;
	
	int limiteVehiculos;
	
	int limiteVehiculosPorBahia;
	
	
	public Parqueadero(int numBahias,int totalCarrosIngresan, int capacidadBahia) {
		
		limiteVehiculos=totalCarrosIngresan;
		limiteVehiculosPorBahia=capacidadBahia;
		Bahia[] bahias=crearBahias(capacidadBahia, numBahias);
		filaEntrada=new ColaEnlazada<Automovil>();
		llenarBahias(filaEntrada);
		
	}
	

	public Bahia[] crearBahias(int capacidadPorBahia,int numeroDeBahias) {
		
		Bahia retorno[]=new Bahia[numeroDeBahias];
		
		for(int i=0;i<numeroDeBahias;i++) {
			Bahia nueva=new Bahia();
			retorno[i]=nueva;
		}
		
		return retorno;
	}
	
	public void llenarBahias(ICola<Automovil> filaEntrada) {
		
		for(int i=0;i<getBahias().length-1;i++){
			
			for(int j=0;j<this.limiteVehiculosPorBahia;j++){
				
			getBahias()[i].getPila().push(filaEntrada.unQueue());
			}	
		
		}
		
	}


	public Bahia[] getBahias() {
		return bahias;
	}


	public void setBahias(Bahia[] bahias) {
		this.bahias = bahias;
	}


	public ICola<Automovil> getFilaEntrada() {
		return filaEntrada;
	}


	public void setFilaEntrada(ICola<Automovil> filaEntrada) {
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
