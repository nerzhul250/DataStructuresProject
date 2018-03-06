package mundo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


import pilas.PilaVaciaException;

public class ParkingManager {
	Parqueadero[] parqueaderos;
	
	public ParkingManager(String input)  {
		parqueaderos=this.reader(input);
	}
	
	public Parqueadero[] reader(String input) {
		String[] entrada=input.split("\n");
		Parqueadero[] casos=new Parqueadero[Integer.parseInt(entrada[0])];
		int j=1;
		int i=0;
		System.out.println(Arrays.deepToString(entrada)+"\n");
			while(casos[casos.length-1]==null){
				String[] B=entrada[j].split("\\s+");
				int cantBahias=Integer.parseInt(B[0]);
				int capacidadBahia=Integer.parseInt(B[1]);
				int numVehiculosIngresan=Integer.parseInt(B[2]);
				Parqueadero nuevo=new Parqueadero(cantBahias,numVehiculosIngresan,capacidadBahia);
				for(int x=j+1;x<=j+(numVehiculosIngresan*2);x++) {
					if(x<=numVehiculosIngresan+j) {
						nuevo.getFilaEntrada().queue(new Automovil(entrada[x]));
					}else {	
						nuevo.getFilaSalida().queue(new Automovil(entrada[x]));
					}
				}
				nuevo.llenarBahias();
				casos[i]=nuevo;
				i++;
				j=2*numVehiculosIngresan+j+1;	
			}
			return casos;
	}
	
	public String sacarLosResultadosDelProblemaMasPoderosoDeTodos() throws PilaVaciaException{
		String retorno="";
		for(int i=0;i<getParqueaderos().length;i++) {
			retorno+=getParqueaderos()[i].darResultado()+"\n";
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
