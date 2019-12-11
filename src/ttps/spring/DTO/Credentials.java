package ttps.spring.DTO;

public class Credentials {
	private String token;
    private int exp;
    private String usuario;
    private int id;

    public Credentials() { }

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Credentials(String token, int exp, String usuario, int id) {
		this.token = token;
		this.exp = exp;
		this.usuario = usuario;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}   
}
