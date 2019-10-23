package model;

public class Desparasitacion extends Evento {
	private String droga;
	private String resultado;
	public String getDroga() {
		return droga;
	}
	public void setDroga(String droga) {
		this.droga = droga;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
}
