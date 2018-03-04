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
	
	public ParkingManager(String input) {
		parqueaderos=this.reader(input);
	}
	
	public Parqueadero[] reader(String input) {
		String[] entrada=input.split("\n");
		Parqueadero[] casos=new Parqueadero[Integer.parseInt(entrada[0])];
		int j=1;
		int i=0;
		System.out.println(Arrays.deepToString(entrada)+"\n");
			while(casos[casos.length-1]==null){
				
				int cantBahias=entrada[j].charAt(0);
				int numVehiculosIngresan=entrada[j].charAt(4);
				int capacidadBahia=entrada[j].charAt(2);
				Parqueadero nuevo=new Parqueadero(cantBahias,numVehiculosIngresan,capacidadBahia);
				
				for(int x=j+1;x<numVehiculosIngresan*2;x++) {
					if(x<numVehiculosIngresan) {
						Automovil pepeElCarroNuevo=new Automovil(entrada[x]);
						nuevo.getFilaEntrada().queue(pepeElCarroNuevo);
					}else {	
					Automovil pepeElCarroNuevo=new Automovil(entrada[x]);
					nuevo.getFilaSalida().queue(pepeElCarroNuevo);
						
					}
					
				}
				casos[i]=nuevo;
				i++;
				j=j*2+2;
			}
			return casos;
	}
	
	public String sacarLosResultadosDelProblemaMasPoderosoDeTodos() throws PilaVaciaException {
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
	public static void main(String[] args) throws IOException{
		
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	String s=br.readLine();
	ParkingManager a=new ParkingManager(s);
	
	bw.write(a.getParqueaderos()[1].getBahias()[1].getPila().top().getPlaca());
	
	
	bw.close();
	br.close();


	}

}
