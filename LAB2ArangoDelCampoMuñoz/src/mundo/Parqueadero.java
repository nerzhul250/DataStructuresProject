package mundo;

import java.util.ArrayList;

import colas.ColaEnlazada;
import colas.ICola;
import pilas.IPila;
import pilas.PilaVaciaException;
import tablasHash.ITablaHash;
import tablasHash.TablaHashEncadenada;

public class Parqueadero  { 
	
	Bahia[] bahias;
	ICola<Automovil>filaEntrada;
	ITablaHash<Automovil,Integer> tabla;
	ICola<Automovil>filaSalida;
	
	int limiteVehiculos;
	
	int limiteVehiculosPorBahia;
	
	
	public Parqueadero(int numBahias,int totalCarrosIngresan, int capacidadBahia) {
		
		limiteVehiculos=totalCarrosIngresan;
		limiteVehiculosPorBahia=capacidadBahia;
		Bahia[] bahias=crearBahias(capacidadBahia, numBahias);
		tabla=new TablaHashEncadenada<Automovil,Integer>(numBahias);
		filaEntrada=new ColaEnlazada<Automovil>();
		filaSalida=new ColaEnlazada<Automovil>();
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
		
		for(int i=0;i<getBahias().length;i++){
		
			for(int j=0;j<this.limiteVehiculosPorBahia;j++){
			getBahias()[i].getPila().push(filaEntrada.front());
			tabla.insert(filaEntrada.unQueue(),i);
			}	
		}
		
	}
	/*
	 * Descripcion:retorna la cantidad de movs necesarios para sacr un carro de esa joda
	 */
	public int sacarCarro(Automovil a) throws PilaVaciaException {
		int retorno=0;
		int b=tabla.find(a);
		
		Bahia actual=this.getBahias()[b];
		
		
		retorno=	actual.movsParaSacarCarro(0, a);
		actual.deColaAPila();
		
		return retorno;
	}
	public String darResultado() throws PilaVaciaException {
		String retorno="";
		while(this.getFilaSalida().isEmpty()!=true) {
			retorno+=" "+this.sacarCarro(this.getFilaSalida().unQueue());
		}
		
		return retorno;
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
	
	public ICola<Automovil> getFilaSalida() {
		return filaSalida;
	}


	public void setFilaSalida(ICola<Automovil> filaSalida) {
		this.filaSalida = filaSalida;
	}




}
