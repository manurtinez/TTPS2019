package model;

import java.util.ArrayList;
import java.util.Set;
import javax.persistence.*;

@Entity
@DiscriminatorValue("Veterinario")
public class Veterinario extends Usuario {
	//private String nomClinica;
	//private String dirClinica;
	//private int nroMatricula;
	//private boolean habilitado;

	//private ArrayList<Mascota> mascotas;
	
	public Veterinario() {}

	public Veterinario(String nombre, String apellido, String email, String password, int telefono) {
		super(nombre, apellido, email, password, telefono);
		// TODO Auto-generated constructor stub
	}
	
	
}
