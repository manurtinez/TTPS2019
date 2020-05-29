package ttps.spring.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("reproducion")
public class HistorialReproductivo extends Evento {
	@Column(name = "nro_nacidos", length = 11)
	private int nroNacidos;

	public HistorialReproductivo() {}

	public HistorialReproductivo(Date date, Mascota mascota, int nroNacidos) {
		super(date, mascota);
		this.nroNacidos= nroNacidos;
	}

	public int getNroNacidos() {
		return nroNacidos;
	}

	public void setNroNacidos(int nroNacidos) {
		this.nroNacidos = nroNacidos;
	}
}
