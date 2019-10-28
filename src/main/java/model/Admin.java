package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Admin")
public class Admin extends Usuario {

	public Admin() {}
	public Admin(String nombre, String apellido, String email, String password, int telefono) {
		super(nombre, apellido, email, password, telefono);
		// TODO Auto-generated constructor stub
	}
	
	public void validarVet(Veterinario v) {
		//...
	}

}
