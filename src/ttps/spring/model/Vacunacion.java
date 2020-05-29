package ttps.spring.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("vacunacion")
public class Vacunacion extends Evento {
	@Column(name = "descripcion", length = 255)
	private String descripcion;

	public Vacunacion() {}
	
	public Vacunacion(Date date, Mascota mascota, String descripcion) {
		super(date, mascota);
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
