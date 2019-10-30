package clasesDAO;

import model.Usuario;

public interface UsuarioDAO extends Dao<Usuario> {
	public Usuario getByNombre(String nombre);
}
