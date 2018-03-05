package mundo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

import colas.ColaVaciaException;
import pilas.PilaVaciaException;

public class ParkingManager {
	Parqueadero[] parqueaderos;
	
	public ParkingManager(String input) throws ColaVaciaException {
		parqueaderos=this.reader(input);
	}
	
	public Parqueadero[] reader(String input) throws ColaVaciaException {
		String[] entrada=input.split("\n");
		Parqueadero[] casos=new Parqueadero[Integer.parseInt(entrada[0])];
		int j=1;
		int i=0;
		System.out.println(Arrays.deepToString(entrada)+"\n");
			while(casos[casos.length-1]==null){
				int cantBahias=Integer.parseInt(entrada[j].charAt(0)+"");
				
				int numVehiculosIngresan=Integer.parseInt(entrada[j].charAt(4)+"");
				
				int capacidadBahia=Integer.parseInt(entrada[j].charAt(2)+"");
				
	
				
								
				Parqueadero nuevo=new Parqueadero(cantBahias,numVehiculosIngresan,capacidadBahia);
				
				for(int x=j+1;x<=j+numVehiculosIngresan*2;x++) {
					if(x<=numVehiculosIngresan+j) {
						Automovil pepeElCarroNuevo=new Automovil(entrada[x]);
						nuevo.getFilaEntrada().queue(pepeElCarroNuevo);
						
					}else {	
					Automovil pepeElCarroNuevo=new Automovil(entrada[x]);
					nuevo.getFilaSalida().queue(pepeElCarroNuevo);
					}
					
				}
				
				casos[i]=nuevo;
				casos[i].llenarBahias(casos[i].getFilaEntrada());
				i++;
				j=2*numVehiculosIngresan+2;
				
			}
			
			return casos;
	}
	
	public String sacarLosResultadosDelProblemaMasPoderosoDeTodos() throws PilaVaciaException, ColaVaciaException {
		String retorno="";
		for(int i=0;i<this.getParqueaderos().length-1;i++) {
			retorno+=""+this.getParqueaderos()[i].darResultado()+"\n";
		}
		return retorno;
	}

	public Parqueadero[] getParqueaderos() {
		return parqueaderos;
	}

	public void setParqueaderos(Parqueadero[] parqueaderos) {
		this.parqueaderos = parqueaderos;
	}
	

}
