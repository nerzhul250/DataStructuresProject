package mundo;

public class Automovil {
	private String placa;
	public Automovil(String p){
		placa=p;
	}
	@Override
	public int hashCode() {
		char[] caracteres=placa.toCharArray();
		int modulus=(int) Math.pow(2,30);
		int k=2;
		long hash=0;
		for (int i = 0; i <caracteres.length; i++) {
			hash+=((Math.pow(2,i%30)%modulus)*(caracteres[i]%modulus))%modulus;
		}
		return (int)hash;
	}
}
