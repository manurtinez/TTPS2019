package clasesDAO;

import java.util.List;

import model.Usuario;

public interface UsuarioDAO {
	List<Usuario> all();
	Usuario getByID(int id);
	void crearUsuario(Usuario usuario);
	void modificarUsuario(Usuario usuario);
	void borrarUsuario(Usuario usuario);
}
