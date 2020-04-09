package ttps.spring.DTO;

public class VeterinarioDTO {
	private int id;
	private String nombre;
	private String apellido;
	private String email;
	private String password;
	private long telefono;
	private String nomClinica;
	private String dirClinica;
	private int nroMatricula;
	
	public VeterinarioDTO() {}
	
	public VeterinarioDTO(String nombre, String apellido, String email, String password, long telefono,
			String nomClinica, String dirClinica, int nroMatricula) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.nomClinica = nomClinica;
		this.dirClinica = dirClinica;
		this.nroMatricula = nroMatricula;
	}
	
	public VeterinarioDTO(int id, String nombre, String apellido, String email, String password, long telefono,
			String nomClinica, String dirClinica, int nroMatricula) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.nomClinica = nomClinica;
		this.dirClinica = dirClinica;
		this.nroMatricula = nroMatricula;
		this.id = id;
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
	public String getNomClinica() {
		return nomClinica;
	}
	public void setNomClinica(String nomClinica) {
		this.nomClinica = nomClinica;
	}
	public String getDirClinica() {
		return dirClinica;
	}
	public void setDirClinica(String dirClinica) {
		this.dirClinica = dirClinica;
	}
	public int getNroMatricula() {
		return nroMatricula;
	}
	public void setNroMatricula(int nroMatricula) {
		this.nroMatricula = nroMatricula;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
