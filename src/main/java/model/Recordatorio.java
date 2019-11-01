package model;

import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "recordatorio")
public class Recordatorio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String titulo;
	
	@Column(name = "fecha", nullable = false)
	private LocalDateTime fecha;
	
	@Column(nullable = false)
	private String descripcion;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="usuario_id", nullable = false)
	private Usuario usuario;
	
	public Recordatorio() {}
	public Recordatorio(String titulo, LocalDateTime fecha, String descripcion, Usuario usuario) {
		super();
		this.titulo = titulo;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.usuario = usuario;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
    @Override
    public boolean equals(Object obj)
    {
        if ( obj == null ) return false;
        if ( this == obj ) return true;
        if ( ! (obj instanceof Recordatorio ) ) return false;
        Recordatorio e = (Recordatorio) obj;
        return this.getId() == e.getId();
    }
	
}
