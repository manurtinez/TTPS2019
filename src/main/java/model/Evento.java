package model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="evento")
@Inheritance
public abstract class Evento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="fecha", nullable = false)
	private Date fecha;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="mascota_id")
	private Mascota mascota;
	
	public Evento() {
		
	}
	

	public Evento(Date fecha, Mascota mascota) {
		this.fecha = fecha;
		this.mascota = mascota;
	}


	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}
}
