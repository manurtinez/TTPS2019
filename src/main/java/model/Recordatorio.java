package model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "recordatorio")
public class Recordatorio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "fecha", nullable = false)
	private Date fecha;
	
	@Column(nullable = false)
	private String descripcion;
	
	public Recordatorio() {}
	public Recordatorio(Date fecha, String descripcion) {
		super();
		this.fecha = fecha;
		this.descripcion = descripcion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
