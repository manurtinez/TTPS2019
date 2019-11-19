package ttps.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.DAO.UsuarioDAO;
import ttps.spring.model.Usuario;

@Service
public class UserService {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	public Usuario getByEmailAndPass(String email, String pass) {
		return usuarioDAO.getByEmailAndPass(email, pass);
	}
	
	public Usuario getByNombre(String nombre) {
		return usuarioDAO.getByNombre(nombre);
	}

}
