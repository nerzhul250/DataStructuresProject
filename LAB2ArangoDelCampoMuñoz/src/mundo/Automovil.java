package mundo;

public class Automovil {
	private String placa;
	public Automovil(String p){
		placa=p;
	}
	@Override
	public int hashCode() {
		return placa.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		Automovil a=(Automovil)obj;
		return a.getPlaca().equals(placa);
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
}
