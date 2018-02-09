package algoritmo;

import java.math.BigInteger;
import java.util.ArrayList;

public class Fibonacci {

	private ArrayList<String> procedimiento;
	public Fibonacci (){
		procedimiento = new ArrayList<String>();
	}
	public String multiplicacion (String x, String d) {
		StringBuilder parla = new StringBuilder();
		
		parla.append(this.getClass().getSimpleName());
		parla.append('(');
		parla.append(x);
		parla.append(',');
		parla.append(d);
		parla .append(")\n");
		
		parla.append("Generamos una matriz del tamaño en filas y columnas equivalente a la cantidad de cifras de las dos entradas\n");
		byte matriz [][] = new byte [x.length()][d.length()];
		parla.append("tamaño de la nueva matriz: "+ x.length() + "filas *" + d.length() + " columnas\n");
		parla.append("Luego determinamos el tamaño máximo de cifras que puede tener la respuesta dada por la suma de las cifras de la entrada\n");
		int tamanio = x.length() + d.length();
		byte [] numerosResultado = new byte [tamanio];
		parla.append("cantidad de cifras máxima de la salida: " +tamanio + "\n");
		parla.append("Se llena la matriz con las multiplicaciones de cada dígito de los números, así:\n");
		for (int i = 0; i < d.length(); i++) {
			parla.append(d.charAt(i) + "\t");
		}
		parla.append("\n_________________________________________________________________________________\n");
		for (int i = 0; i < x.length(); i++) {
			parla.append("(" + i + ")\t");
			for (int j = 0; j < d.length(); j++) {
			matriz[i][j] = (byte) (Character.getNumericValue(x.charAt(i)) * Character.getNumericValue(d.charAt(j)));
			parla.append(matriz[i][j] + "\t");
			numerosResultado[i + j] += (byte) (matriz[i][j]/10);
				numerosResultado[i + j + 1] += (byte) (matriz[i][j]%10);
				sumarDecenas(numerosResultado, i + j);
			}
			parla.append("|" + x.charAt(i));
		}
		int sigDigito;
		for (int i = 0; i < d.length(); i++) {
			sigDigito = i + x.length();
			parla.append("(" + sigDigito + ")\t");
		}
		if(numerosResultado[numerosResultado.length-1]>=10)
			sumarDecenas(numerosResultado, numerosResultado.length-1);
		procedimiento.add(parla.toString());
		return concatenarValores(numerosResultado);
	}
	
	public String concatenarValores (byte[] arreglo) {
		String valor = "";
		int i = 0;
		while(arreglo[i] == 0 && i<arreglo.length-1)
			i ++;
		while (i < arreglo.length) {
			valor += arreglo[i];
			i++;
		}
		return valor;
	}
	public void sumarDecenas(byte[] numerosResultado, int anterior) {
		while(numerosResultado[anterior]>=10) {
			numerosResultado[anterior - 1] += 1;
			numerosResultado[anterior] -=10;
			anterior --;
	}
	}
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		String resultado = f.multiplicacion("999999999999999999999999", "99999999999999999999999");
		System.out.println(resultado);
		BigInteger a = new BigInteger("999999999999999999999999");
		BigInteger b = new BigInteger("99999999999999999999999");
		
		System.out.println(a.multiply(b));
	}
	
	public ArrayList<String> getProcedimiento() {
		return procedimiento;
	}
	public void setProcedimiento(ArrayList<String> procedimiento) {
		this.procedimiento = procedimiento;
	}
}
