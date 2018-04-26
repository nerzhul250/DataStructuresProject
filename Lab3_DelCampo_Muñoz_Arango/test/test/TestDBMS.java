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
	private void setupEscenario2() {
		baseDatos=new DBMS();
		File f=new File("./DatosEnCSV/EjecucionPresupuestoImpuestosAlcaldiaVistaHermosa.csv");
		baseDatos.cargarTabla(f);
		try {
			baseDatos.definirCamposRapidos(2,0,1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
	@Test
	public void testCargaDatos() {
		setUpEscenario1();
		//PROBANDO CARGA
		File f=new File("./DatosEnCSV/EjecucionPresupuestoImpuestosAlcaldiaVistaHermosa.csv");
		baseDatos.cargarTabla(f);
		try {
			//PROBANDO QUE CARGÓ
			baseDatos.definirCamposRapidos(2,0,1);
			ArrayList<String[]> re=baseDatos.consulta(2,"$3165050864.00");
			if(re.size()==0)throw new Exception("FUCK");
			for (int i = 0; i < re.size(); i++) {
				for (int j = 0; j < re.get(i).length; j++) {
					System.out.print(re.get(i)[j]+" ");
				}
				System.out.println();
			}
		} catch (Exception e) {
			fail();
		}
		
	}
	@Test
	public void testConsultaDatos() {
		setupEscenario2();
		ArrayList<String[]> re;
		try {
			re = baseDatos.consulta(1,"$31650");
			if(re!=null) throw new Exception("FUCK");
			re=baseDatos.consulta(1,"INGRESOS ADMINISTRACION CENTRAL");
			if(re==null) throw new Exception("FUCK");
			re=baseDatos.consulta(3,"$2825005520.00");
			if(re==null) throw new Exception("FUCK");
		} catch (Exception e) {
			fail();
		}
	
	}
}
