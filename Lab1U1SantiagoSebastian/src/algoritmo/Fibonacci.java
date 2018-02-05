package algoritmo;

import java.math.BigInteger;

public class Fibonacci {

	public String multiplicacion (String x, String d) {
		byte matriz [][] = new byte [x.length()][d.length()];
		byte [] numerosResultado = new byte [x.length() + d.length()];
		for (int i = 0; i < x.length(); i++) {
			for (int j = 0; j < d.length(); j++) {
			matriz[i][j] = (byte) (Character.getNumericValue(x.charAt(i)) * Character.getNumericValue(d.charAt(j)));
				numerosResultado[i + j] += (byte) (matriz[i][j]/10);
				numerosResultado[i + j + 1] += (byte) (matriz[i][j]%10);
				sumarDecenas(numerosResultado, i + j);
			}
		}
		if(numerosResultado[numerosResultado.length-1]>=10)
			sumarDecenas(numerosResultado, numerosResultado.length-1);
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
		String resultado = f.multiplicacion("1234567891234566", "8800000000000000000000");
		System.out.println(resultado);
		BigInteger a = new BigInteger("1234567891234566");
		BigInteger b = new BigInteger("8800000000000000000000");
		
		System.out.println(a.multiply(b));
	}
}
