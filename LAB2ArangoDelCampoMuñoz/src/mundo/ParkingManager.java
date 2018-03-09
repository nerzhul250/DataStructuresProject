package mundo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

<<<<<<< HEAD
import pilas.PilaVaciaException;
import tablasHash.TablaHashEncadenada;

public class ParkingManager extends Thread{
=======
public class ParkingManager {
	Parqueadero[] parqueaderos;
>>>>>>> 29332202676395f937fe00c24b31cdb9e478c146
	
	public static final int PAUSAESTANDAR = 2000;
	private Parqueadero[] parqueaderos;
	private int casoActual;
	private String entrada;
	private boolean simulado;
	public ParkingManager(String input, boolean simulacion) throws InterruptedException  {
		entrada = input;
		simulado = simulacion;
		start();
	}
	@Override
	public void run() {	
		try {
			parqueaderos = reader(entrada, simulado);
			sacarLosResultadosDelProblemaMasPoderosoDeTodos();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (PilaVaciaException e) {
			e.printStackTrace();
		}
	}
	public Parqueadero[] reader(String input, boolean simulacion) throws InterruptedException {
		String[] entrada=input.split("\n");
		parqueaderos = new Parqueadero[Integer.parseInt(entrada[0])];
		int j=1;
		int i=0;
			while(parqueaderos[parqueaderos.length-1]==null){
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
				casoActual = i;
				parqueaderos[i]=nuevo;
				nuevo.llenarBahias(simulacion);
				i++;
				j=2*numVehiculosIngresan+j+1;	
			}
			return parqueaderos;
	}
	
<<<<<<< HEAD
	public String sacarLosResultadosDelProblemaMasPoderosoDeTodos() throws PilaVaciaException, InterruptedException{
=======
	public String sacarLosResultadosDelProblemaMasPoderosoDeTodos(){
>>>>>>> 29332202676395f937fe00c24b31cdb9e478c146
		String retorno="";
		for(int i=0;i<getParqueaderos().length;i++) {
			retorno+=getParqueaderos()[i].darResultado(simulado)+"\n";
		}
		return retorno;
	}

	public Parqueadero[] getParqueaderos() {
		return parqueaderos;
	}

	public void setParqueaderos(Parqueadero[] parqueaderos) {
		this.parqueaderos = parqueaderos;
	}
	
	public int getCasoActual() {
		return casoActual;
	}
}
