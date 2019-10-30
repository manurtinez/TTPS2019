package model;

import java.util.List;

import javax.persistence.*;
import org.hibernate.annotations.DiscriminatorOptions;
@Entity
@Table(name = "usuario")
@Inheritance
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "tipo_usuario")
@DiscriminatorOptions(force=true)
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}
	@Column(name="nombre", nullable = false)
	private String nombre;
	
	@Column(name="apellido", nullable = false)
	private String apellido;
	
	@Column(name="email", nullable = false)
	private String email;
	
	@Column(name="password", nullable = false)
	private String password;
	
	@Column(name="telefono", nullable = false)
	private int telefono;
	
	@OneToMany(mappedBy="dueno")
	private List<Mascota> mascotas;
	
	public Usuario() { } //necesario para q sea entidad
	
	public Usuario(String nombre, String apellido, String email, String password, int telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
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
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
}
