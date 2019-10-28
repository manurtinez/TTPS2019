package model;

import java.util.ArrayList;
import java.util.Set;

public class Veterinario extends Usuario {
	private String nomClinica;
	private String dirClinica;
	private int nroMatricula;
	private boolean habilitado;

	private ArrayList<Mascota> mascotas;
	
	
	public Veterinario(String nombre, String apellido, String email, String password, int telefono, String nomClinica,
			String dirClinica) {
		super(nombre, apellido, email, password, telefono);
		this.nomClinica = nomClinica;
		this.dirClinica = dirClinica;
		this.mascotas = new ArrayList<Mascota>();
		this.setHabilitado(false);
	}
	public void setNroMatricula(int nroMatricula) {
		this.nroMatricula = nroMatricula;
	}
	public int getNroMatricula() {
		return nroMatricula;
	}
	
	public ArrayList<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(ArrayList<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

	public Set<Mascota> verMascotas(){
		return null;
	}
	

	public String getNomClinica() {
		return nomClinica;
	}
	public void setNomClinica(String nomClinica) {
		this.nomClinica = nomClinica;
	}
	public String getDirClinica() {
		return dirClinica;
	}
	public void setDirClinica(String dirClinica) {
		this.dirClinica = dirClinica;
	}
	public boolean isHabilitado() {
		return habilitado;
	}
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	
}
