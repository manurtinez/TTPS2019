package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Dueno extends Usuario {

	private ArrayList<Mascota> mascotas;
	
	public Dueno(String nombre, String apellido, String email, String password, int telefono) {
		super(nombre, apellido, email, password, telefono);
		// TODO Auto-generated constructor stub
	}
	
	public void agregarMascota(Mascota m) {
		this.mascotas.add(m);
	}
	
	public void editarMascota(Mascota m) {
		//...;
	}
	
	public void eliminarMascota(Mascota m) {
		this.mascotas.remove(m);
	}
	
	public Image generarChapita() {
		return new BufferedImage(10, 10, 10);
	}

	
}
