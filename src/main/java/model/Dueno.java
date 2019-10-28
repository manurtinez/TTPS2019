package model;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.persistence.*;
@Entity
@DiscriminatorValue("Dueno")
public class Dueno extends Usuario {

	//private ArrayList<Mascota> mascotas;
	
	public Dueno() {}
	public Dueno(String nombre, String apellido, String email, String password, int telefono) {
		super(nombre, apellido, email, password, telefono);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Image generarChapita() {
		return new BufferedImage(10, 10, 10);
	}

	
}
