package model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "dueno")
@PrimaryKeyJoinColumn(name = "dueno_id")
public class Dueno extends Usuario {
	
	@OneToMany(mappedBy="dueno")
	private List<Mascota> mascotas;
	
	public Dueno() {}
	public Dueno(String nombre, String apellido, String email, String password, int telefono) {
		super(nombre, apellido, email, password, telefono);
	}
		
	public List<Mascota> getMascotas() {
		return mascotas;
	}
	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}	
	
}
