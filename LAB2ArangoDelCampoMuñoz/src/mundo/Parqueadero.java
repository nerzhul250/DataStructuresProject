package mundo;

import colas.ICola;

public class Parqueadero implements ICola{
	Bahia[] bahias;
	
	String[] colaLlegadaParqueadero;
	
	
	public Parqueadero(int numBahias,int totalCarrosIngresan) {
		Bahia[] bahias=new Bahia[numBahias];
		String[] colaLlegadaParqueadero=new String[totalCarrosIngresan];
	}


	public Object unQueue() {
		// TODO Auto-generated method stub
		return null;
	}


	public void queue(String x) {
		// TODO Auto-generated method stub
		
	}

}
