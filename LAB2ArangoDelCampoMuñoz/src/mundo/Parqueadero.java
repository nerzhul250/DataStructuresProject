package mundo;

import java.util.ArrayList;

import colas.ColaEnlazada;

import colas.ICola;
import pilas.IPila;
import tablasHash.ITablaHash;
import tablasHash.TablaHashEncadenada;

public class Parqueadero  { 
	
	private Bahia[] bahias;
	private ICola<Automovil>filaEntrada;
	private ITablaHash<Automovil,Integer> tabla;
	private ICola<Automovil>filaSalida;
	
	int limiteVehiculos;
	int limiteVehiculosPorBahia;
	
	public Parqueadero(int numBahias,int totalCarrosIngresan, int capacidadBahia)  {
		limiteVehiculos=totalCarrosIngresan;
		limiteVehiculosPorBahia=capacidadBahia;
		bahias=crearBahias(capacidadBahia, numBahias);
		tabla=new TablaHashEncadenada<Automovil,Integer>(numBahias);
		filaEntrada=new ColaEnlazada<Automovil>();
		filaSalida=new ColaEnlazada<Automovil>();	
	}	

	public Bahia[] crearBahias(int capacidadPorBahia,int numeroDeBahias) {
		
		Bahia retorno[]=new Bahia[numeroDeBahias];
		
		for(int i=0;i<numeroDeBahias;i++) {
			Bahia nueva=new Bahia();
			retorno[i]=nueva;
		}
		return retorno;
	}
	

	
	public void llenarBahias(){
		boolean es=false;
		for(int i=0;i<getBahias().length && !es;i++){
			for(int j=0;j<limiteVehiculosPorBahia && !es;j++){
				Automovil beta=filaEntrada.deQueue();
				if(beta==null){
					es=true;
					break;
				}
			    getBahias()[i].getPila().push(beta);
			    tabla.insert(beta,i);}
			}		
		}	
	
	/*
	 * Descripcion:retorna la cantidad de movs necesarios para sacar un carro de esa joda
	 */
	public void sacarCarro(Automovil a){
		Integer b=tabla.find(a);
		Bahia actual=getBahias()[b];
		actual.movsParaSacarCarro(a);
		actual.deColaAPila();
	}
	public String darResultado(){
		String retorno="";
		while(getFilaSalida().isEmpty()!=true) {
			sacarCarro(getFilaSalida().deQueue());
		}
		for (int i = 0; i < bahias.length; i++) {
			if(i!=bahias.length-1){
				retorno+=bahias[i].getCarrosMovidos()+" ";				
			}else{
				retorno+=bahias[i].getCarrosMovidos();				
			}
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


	public ITablaHash<Automovil, Integer> getTabla() {
		return tabla;
	}


	public void setTabla(ITablaHash<Automovil, Integer> tabla) {
		this.tabla = tabla;
	}


	public ICola<Automovil> getFilaSalida() {
		return filaSalida;
	}


	public void setFilaSalida(ICola<Automovil> filaSalida) {
		this.filaSalida = filaSalida;
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
