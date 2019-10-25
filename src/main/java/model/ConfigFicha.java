package model;

import javax.persistence.*;

@Entity
@Table(name="config_ficha")
public class ConfigFicha {
	@Id
	@Column(name="id")
	private int id;
	private boolean nombre;
	private boolean especie;
	private boolean raza;
	private boolean sexo;
	private boolean color;
	private boolean senas;
	private boolean veterinarioAlt;
	private boolean nacimiento;
	private boolean dueno;
	private boolean fotos;
	private boolean veterinario;
	
	public ConfigFicha() {
		
	}
	
	public ConfigFicha(boolean nombre, boolean especie, boolean raza, boolean sexo, boolean color, boolean senas,
			boolean veterinarioAlt, boolean nacimiento, boolean dueno, boolean fotos, boolean veterinario) {
		super();
		this.nombre = nombre;
		this.especie = especie;
		this.raza = raza;
		this.sexo = sexo;
		this.color = color;
		this.senas = senas;
		this.veterinarioAlt = veterinarioAlt;
		this.nacimiento = nacimiento;
		this.dueno = dueno;
		this.fotos = fotos;
		this.veterinario = veterinario;
	}
	public boolean isNombre() {
		return nombre;
	}
	public void setNombre(boolean nombre) {
		this.nombre = nombre;
	}
	public boolean isEspecie() {
		return especie;
	}
	public void setEspecie(boolean especie) {
		this.especie = especie;
	}
	public boolean isRaza() {
		return raza;
	}
	public void setRaza(boolean raza) {
		this.raza = raza;
	}
	public boolean isSexo() {
		return sexo;
	}
	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}
	public boolean isColor() {
		return color;
	}
	public void setColor(boolean color) {
		this.color = color;
	}
	public boolean isSenas() {
		return senas;
	}
	public void setSenas(boolean senas) {
		this.senas = senas;
	}
	public boolean isVeterinarioAlt() {
		return veterinarioAlt;
	}
	public void setVeterinarioAlt(boolean veterinarioAlt) {
		this.veterinarioAlt = veterinarioAlt;
	}
	public boolean isNacimiento() {
		return nacimiento;
	}
	public void setNacimiento(boolean nacimiento) {
		this.nacimiento = nacimiento;
	}
	public boolean isDueno() {
		return dueno;
	}
	public void setDueno(boolean dueno) {
		this.dueno = dueno;
	}
	public boolean isFotos() {
		return fotos;
	}
	public void setFotos(boolean fotos) {
		this.fotos = fotos;
	}
	public boolean isVeterinario() {
		return veterinario;
	}
	public void setVeterinario(boolean veterinario) {
		this.veterinario = veterinario;
	}
}
