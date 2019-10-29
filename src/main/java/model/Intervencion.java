package model;
import java.util.Date;

import javax.persistence.*;

@Entity
@DiscriminatorValue("Intervencion")
public class Intervencion extends Evento {
	
	@Column(name = "descripcion", length = 255)
	private String descripcion;
	
	public Intervencion() {}
	
	public Intervencion(Date fecha, Mascota mascota, String descripcion) {
		super(fecha, mascota);
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
