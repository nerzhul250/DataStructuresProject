package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import mundo.DBMS;

import org.junit.Test;

public class TestDBMS {
	private DBMS baseDatos;
	private void setUpEscenario1(){
		baseDatos=new DBMS();
	}
	@Test
	public void testCargaDatos() {
		setUpEscenario1();
		File f=new File("./DatosEnCSV/EjecucionPresupuestoImpuestosAlcaldiaVistaHermosa.csv");
		baseDatos.cargarTabla(f);
		try {
			baseDatos.definirCamposRapidos(2,0,1);
			ArrayList<String[]> re=baseDatos.consulta(2,"$3165050864.00");
			for (int i = 0; i < re.size(); i++) {
				for (int j = 0; j < re.get(i).length; j++) {
					System.out.print(re.get(i)[j]+" ");
				}
				System.out.println();
			}
		} catch (IOException e) {
			System.out.println("FUCK");
		}
		
	}

}
