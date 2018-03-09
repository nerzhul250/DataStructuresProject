package test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

import colas.ColaEnlazada;
import mundo.Automovil;
import mundo.ParkingManager;
import mundo.Parqueadero;

public class testParkingManager {
	private ParkingManager pm;
	private void setUpEscenario1 () {
	}
	@Test
	public void test() throws Exception {
		setUpEscenario1();
		for (int i = 1; i <= 10; i++) {
			BufferedReader br = new BufferedReader(new FileReader("./TestCases/case_"+i+".txt"));
			StringBuilder sb=new StringBuilder();
			String ka=br.readLine();
			while(ka!=null && !ka.isEmpty()){
				sb.append(ka+"\n");
				ka=br.readLine();
			}
			pm=new ParkingManager(sb.toString(), false);
			br = new BufferedReader(new FileReader("./TestCases/case_"+i+"_s.txt"));
			sb=new StringBuilder();
			ka=br.readLine();
			while(ka!=null && !ka.isEmpty()){
				sb.append(ka+"\n");
				ka=br.readLine();
			}
			assertTrue(pm.sacarLosResultadosDelProblemaMasPoderosoDeTodos().equals(sb.toString()));
		}
	}
}
