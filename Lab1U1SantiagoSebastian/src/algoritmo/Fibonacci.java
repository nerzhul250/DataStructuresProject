package algoritmo;

public class Fibonacci {

	public byte[] multiplicacion (String x, String d) {
		byte matriz [][] = new byte [x.length()][d.length()];
		byte [] numerosResultado = new byte [x.length() + d.length()];
		for (int i = 0; i < x.length(); i++) {
			for (int j = 0; j < d.length(); j++) {
			matriz[i][j] = (byte) (Character.getNumericValue(x.charAt(i)) * Character.getNumericValue(d.charAt(j)));
				numerosResultado[i + j] += (byte) (matriz[i][j]/10);
				numerosResultado[i + j + 1] += (byte) (matriz[i][j]%10);
				int anterior = i+j;
//				if(numerosResultado[i + j + 1] >= 10) {
					while(numerosResultado[anterior + 1]>=10) {
						numerosResultado[anterior] += 1;
						numerosResultado[anterior + 1] -=10;
						anterior --;
//					}
				}
			}
		}
		
		return numerosResultado;
	}
	
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci();
		byte [] resultado = f.multiplicacion("7634189325", "3561053102738");
		String impresion = "";
		for (int i = 0; i < resultado.length; i++) {
			impresion += resultado[i];
		}
		System.out.println(impresion);
	}
	//Números de la muerte "763418769325", "356108653102738"
}
