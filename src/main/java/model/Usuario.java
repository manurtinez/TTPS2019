package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="nombre", nullable = false, length = 150)
	private String nombre;
	
	@Column(name="apellido", nullable = false, length = 200)
	private String apellido;
	
	@Column(name="email", nullable = false, length = 200)
	private String email;
	
	@Column(name="password", nullable = false, length = 50)
	private String password;
	
	@Column(name="telefono", nullable = false, length = 20)
	private long telefono;
	
	@OneToMany(mappedBy="usuario", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)//corrige error de EAGER -> MultipleBagFetchException: cannot simultaneously fetch multiple bags
	private List<Recordatorio> recordatorios;
	
	public void agregarRecordatorio(Recordatorio r) {
		this.getRecordatorios().add(r);
	}
	public void borrarRecordatorio(Recordatorio r) {
		this.getRecordatorios().remove(r);
	}
	
	public List<Recordatorio> getRecordatorios() {
		return recordatorios;
	}

	public void setRecordatorios(List<Recordatorio> recordatorios) {
		this.recordatorios = recordatorios;
	}

	public Usuario() { } //necesario para q sea entidad
	
	public Usuario(String nombre, String apellido, String email, String password, int telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.recordatorios = new ArrayList<Recordatorio>();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
