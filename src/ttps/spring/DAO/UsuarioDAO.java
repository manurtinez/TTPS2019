package ttps.spring.DAO;

import ttps.spring.model.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario> {
	public Usuario getByNombre(String nombre);
	public Usuario getByEmailAndPass(String email, String pass);
	public Usuario getByEmail(String email);
}
