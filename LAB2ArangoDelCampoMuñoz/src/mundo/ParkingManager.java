package mundo;

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
			while(casos[casos.length-1]==null){
				
				int cantBahias=entrada[j].charAt(0);
				int numVehiculosIngresan=entrada[j].charAt(4);
				int capacidadBahia=entrada[j].charAt(2);
				Parqueadero nuevo=new Parqueadero(cantBahias,numVehiculosIngresan,capacidadBahia);
				for(int x=j+1;x<numVehiculosIngresan;x++) {
					Automovil pepeElCarroNuevo=new Automovil(entrada[x]);
					nuevo.getFilaEntrada().queue(pepeElCarroNuevo);
				}
				casos[i]=nuevo;
				i++;
				j=j*2+2;
			}
			return casos;
	}

	public Parqueadero[] getParqueaderos() {
		return parqueaderos;
	}

	public void setParqueaderos(Parqueadero[] parqueaderos) {
		this.parqueaderos = parqueaderos;
	}
	

}
