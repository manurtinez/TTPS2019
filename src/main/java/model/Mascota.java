package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;

public class Mascota {
	private String nombre;
	private String especie;
	private String raza;
	private String sexo;
	private String color;
	private String senas;
	private String veterinarioAlt;
	private Date nacimiento;
	private Dueno dueno;
	private BufferedImage[] fotos;
<<<<<<< Updated upstream
	private Veterinario veterinario;
	private ArrayList<Evento> historial;
=======
	//private Veterinario veterinario;
	@OneToMany(mappedBy="mascota")
	private List<Evento> historial;
	@OneToOne
	@JoinColumn(name="config_ficha_id")
>>>>>>> Stashed changes
	private ConfigFicha configFicha;
	
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

	public Dueno getDueno() {
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
}
