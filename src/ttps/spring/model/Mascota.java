package ttps.spring.model;

import java.util.Date;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="mascota")
public class Mascota {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre", nullable = false, length = 100)
	private String nombre;
	
	@Column(name="especie", nullable = false, length = 100)
	private String especie;
	
	@Column(name="raza", nullable = false, length = 150)
	private String raza;
	
	@Column(name="sexo", nullable = false, length = 50)
	private String sexo;
	
	@Column(name="color", nullable = false, length = 50)
	private String color;
	
	@Column(name="senas", length = 255)
	private String senas;
	
	@Column(name="nacimiento")
	@Temporal(TemporalType.DATE)
	private Date nacimiento;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="dueno_id")
	private Dueno dueno;
	
	private BufferedImage[] fotos;
	
	@ManyToOne(optional = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="veterinario_id")
	private Veterinario veterinario;
	
	@OneToMany(mappedBy="mascota", orphanRemoval = true, fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	private List<Evento> historial;
	
	@OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, orphanRemoval = true)
	private ConfigFicha configFicha;
	
	@Column(nullable = false)
	private boolean vetStatus;
	
	public Mascota() {}
	
	public Mascota(String nombre, String especie, String raza, String sexo, String color, String senas,
			Date nacimiento, BufferedImage[] fotos,Dueno dueno, Veterinario vet, ConfigFicha config ) {
		super();
		this.nombre = nombre;
		this.especie = especie;
		this.raza = raza;
		this.sexo = sexo;
		this.color = color;
		this.senas = senas;
		this.nacimiento = nacimiento;
		this.fotos = fotos;
		this.vetStatus = false;
		setDueno(dueno);
		if(vet != null) {
			this.veterinario = vet;
		} else {
			this.veterinario = null;
		}
		this.configFicha = config;
		this.historial = new ArrayList<Evento>();
	}
	
	public Veterinario getVeterinario() {
		return this.veterinario;
	}
	public void setVeterinario(Veterinario veterinario) {
		veterinario.agregarMascota(this);
		this.veterinario = veterinario;
	}
	public void nullVeterinario(Veterinario veterinario) {
		veterinario.borrarMascota(this);
		this.veterinario = null;
 	}
	
	public void aceptarMascota () {
		this.setVetStatus(true);
	}
	
	public void cancelarMascota() {
		this.setVetStatus(false);
		this.nullVeterinario(this.getVeterinario());
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

	public void setDueno(Dueno dueno) {
		dueno.agregarMascota(this);
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
	public void agregarEvento(Evento e) {
		this.historial.add(e);
	}
	public void borrarEvento(Evento e) {
		this.historial.remove(e);
	}

	public List<Evento> getHistorial() {
		return historial;
	}

	public void setHistorial(List<Evento> historial) {
		this.historial = historial;
	}
	public Dueno getDueno() {
		return this.dueno;
	}
	
	public boolean isVetStatus() {
		return vetStatus;
	}

	public void setVetStatus(boolean vetStatus) {
		this.vetStatus = vetStatus;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;

	    Mascota m = (Mascota) obj;

	    return getId() == m.getId();
	}
}
