package algoritmo;

import java.math.BigInteger;
import java.util.ArrayList;

public class Fibonacci {

	private ArrayList<String> procedimiento;

	public Fibonacci() {
		procedimiento = new ArrayList<String>();
	}

	public String multiplicacion(String x, String d) {
		StringBuilder parla = new StringBuilder();

		parla.append(this.getClass().getSimpleName());
		parla.append('(');
		parla.append(x);
		parla.append(',');
		parla.append(d);
		parla.append(")\n");

		parla.append(
				"Generamos una matriz del tamaño en filas y columnas equivalente a la cantidad de cifras de las dos entradas\n");
		byte matriz[][] = new byte[x.length()][d.length()];
		parla.append("tamaño de la nueva matriz: " + x.length() + " filas * " + d.length() + " columnas\n");
		parla.append(
				"Luego determinamos el tamaño máximo de cifras que puede tener la respuesta dada por la suma de las cifras de la entrada\n");
		int tamanio = x.length() + d.length();
		byte[] numerosResultado = new byte[tamanio];
		parla.append("cantidad de cifras máxima de la salida: " + tamanio + "\n");
		boolean negativo = false;
		int i = 0;
		int j = 0;
		if (x.startsWith("-") || d.startsWith("-")) {
			negativo = true;
			if (x.startsWith("-") && d.startsWith("-")) {
				negativo = false;
				i = 1;
				j = 1;
			} else if (x.startsWith("-"))
				i = 1;
			else if (d.startsWith("-"))
				j = 1;
		}
		parla.append("Se aplica la regla de signos básica y almacenamos su carga, la cual es ");
		if (negativo)
			parla.append("negativa para este caso\n");
		else
			parla.append("positiva para este caso\n");
		parla.append("Se llena la matriz con las multiplicaciones de cada dígito de los números, así:\n   ");
		for (; i < d.length(); i++) {
			parla.append(d.charAt(i) + "    ");
		}
		if (x.startsWith("-"))
			i = 1;
		else
			i = 0;
		parla.append("\n_________________________________________________________________________________\n");
		for (; i < x.length(); i++) {
			parla.append("(" + i + ") ");
			if (j > 1) {
				j = 0;
				if (d.startsWith("-"))
					j = 1;
			}
			for (; j < d.length(); j++) {
				matriz[i][j] = (byte) (Byte.parseByte(x.charAt(i) + "") * Byte.parseByte(d.charAt(j) + ""));
				parla.append(matriz[i][j] / 10 + "/" + matriz[i][j] % 10 + " | ");
				numerosResultado[i + j] += (byte) (matriz[i][j] / 10);
				numerosResultado[i + j + 1] += (byte) (matriz[i][j] % 10);
				sumarDecenas(numerosResultado, i + j);
			}
			parla.append("|" + x.charAt(i) + "\n\n");
		}
		int sigDigito;
		if (x.startsWith("-"))
			i = 1;
		else
			i = 0;
		parla.append("   ");
		for (; i < d.length(); i++) {
			sigDigito = i + x.length();
			parla.append("( " + sigDigito + " ) ");
		}
		parla.append("\nDonde (#) es el dígito proporcionado por la suma de su diagonal respectiva\n");
		parla.append("pasadas sus decenas a la suma del dígito anterior tenemos\n");
		String resultado = concatenarValores(numerosResultado);
		if (negativo)
			resultado = "-" + resultado;
		parla.append("respuesta: " + resultado);
		procedimiento.add(parla.toString());
		return resultado;
	}

	public String concatenarValores(byte[] arreglo) {
		String valor = "";
		int i = 0;
		while (arreglo[i] == 0 && i < arreglo.length - 1)
			i++;
		while (i < arreglo.length) {
			valor += arreglo[i];
			i++;
		}
		return valor;
	}

	public void sumarDecenas(byte[] numerosResultado, int anterior) {
		while (numerosResultado[anterior] >= 10) {
			numerosResultado[anterior - 1] += 1;
			numerosResultado[anterior] -= 10;
			anterior--;
		}
	}

	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		String resultado = f.multiplicacion("73", "-73");
		System.out.println(resultado);
		BigInteger a = new BigInteger("73");
		BigInteger b = new BigInteger("-73");

		System.out.println(a.multiply(b));
	}

	public ArrayList<String> getProcedimiento() {
		return procedimiento;
	}

	public void setProcedimiento(ArrayList<String> procedimiento) {
		this.procedimiento = procedimiento;
	}
}
