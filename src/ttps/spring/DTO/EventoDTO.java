package ttps.spring.DTO;

import java.time.LocalDate;

public class EventoDTO {
	private String tipo_evento;
	private int id;
	private int mascotaId;
	private LocalDate fecha;
	private String droga;	
	private String resultado;	
	private String descripcion;	
	private String indicaciones;	
	private String motivo;	
	private float peso;	
	private int nro_nacidos;
	
	public EventoDTO () {}
	
	public EventoDTO(String tipo_evento, int id, LocalDate fecha, String descripcion, 
			String indicaciones, String motivo, float peso, int mascotaId) {
		//visita
		this.tipo_evento = tipo_evento;
		this.id = id;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.indicaciones = indicaciones;
		this.motivo = motivo;
		this.peso = peso;
		this.mascotaId = mascotaId;
	}
	
	public EventoDTO(String tipo_evento, int id, LocalDate fecha, String descripcion, int mascotaId) {
		//vacunacion, enfermedad, intervencion
		this.tipo_evento = tipo_evento;
		this.id = id;
		this.fecha = fecha;
		this.descripcion = descripcion;
		this.mascotaId = mascotaId;
	}
	public EventoDTO(String tipo_evento, int id, LocalDate fecha, int nro_nacidos, int mascotaId) {
		//historial reproductivo
		this.tipo_evento = tipo_evento;
		this.id = id;
		this.fecha = fecha;
		this.nro_nacidos = nro_nacidos;
		this.mascotaId = mascotaId;
	}
	
	public EventoDTO (String tipo_evento, int id, LocalDate fecha, String droga, String resultado, int mascotaId) {
		//desparasitacion
		this.tipo_evento = tipo_evento;
		this.id = id;
		this.fecha = fecha;
		this.droga = droga;
		this.resultado = resultado;
		this.mascotaId = mascotaId;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public String getDroga() {
		return droga;
	}
	public void setDroga(String droga) {
		this.droga = droga;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getIndicaciones() {
		return indicaciones;
	}
	public void setIndicaciones(String indicaciones) {
		this.indicaciones = indicaciones;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public int getNro_nacidos() {
		return nro_nacidos;
	}
	public void setNro_nacidos(int nro_nacidos) {
		this.nro_nacidos = nro_nacidos;
	}

	public String getTipo_evento() {
		return tipo_evento;
	}

	public void setTipo_evento(String tipo_evento) {
		this.tipo_evento = tipo_evento;
	}

	public int getMascotaId() {
		return mascotaId;
	}

	public void setMascotaId(int mascotaId) {
		this.mascotaId = mascotaId;
	}
	
}
