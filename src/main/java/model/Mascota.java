package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="mascota")
public class Mascota {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre", nullable = false)
	private String nombre;
	
	@Column(name="especie", nullable = false)
	private String especie;
	
	@Column(name="raza", nullable = false)
	private String raza;
	
	@Column(name="sexo", nullable = false)
	private String sexo;
	
	@Column(name="color", nullable = false)
	private String color;
	
	@Column(name="senas")
	private String senas;
	
	@Column(name="veterinario_alt", nullable = false)
	private String veterinarioAlt;
	
	@Column(name="nacimiento")
	private Date nacimiento;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="dueno_id") //dudas con esto
	private Usuario dueno;
	
	private BufferedImage[] fotos;
	
	//private Veterinario veterinario;
	
	@OneToMany(mappedBy="mascota")
	private List<Evento> historial;
	
	@OneToOne
	@JoinColumn(name="config_ficha_id", nullable = false)
	private ConfigFicha configFicha;
	
	
	
	public Mascota() {}
	
	public Mascota(String nombre, String especie, String raza, String sexo, String color, String senas,
			String veterinarioAlt, Date nacimiento, BufferedImage[] fotos) {
		super();
		this.nombre = nombre;
		this.especie = especie;
		this.raza = raza;
		this.sexo = sexo;
		this.color = color;
		this.senas = senas;
		this.veterinarioAlt = veterinarioAlt;
		this.nacimiento = nacimiento;
		this.fotos = fotos;
		this.historial = new ArrayList<Evento>();
	}
	/*
	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

	public void agregarEvento(Evento e) {
		this.historial.add(e);
	}

	public void cambiarVeterinario(Veterinario vet) {
		this.veterinario = vet;
	}
	*/
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSenas() {
		return senas;
	}
	public void setSenas(String senas) {
		this.senas = senas;
	}
	public String getVeterinarioAlt() {
		return veterinarioAlt;
	}
	public void setVeterinarioAlt(String veterinarioAlt) {
		this.veterinarioAlt = veterinarioAlt;
	}
	public Date getNacimiento() {
		return nacimiento;
	}
	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}
	public BufferedImage[] getFotos() {
		return fotos;
	}
	public void setFotos(BufferedImage[] fotos) {
		this.fotos = fotos;
	}

	public Usuario getDueno() {
		return dueno;
	}

	public void setDueno(Dueno dueno) {
		this.dueno = dueno;
	}

	public ConfigFicha getConfigFicha() {
		return configFicha;
	}

	public void setConfigFicha(ConfigFicha configFicha) {
		this.configFicha = configFicha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
