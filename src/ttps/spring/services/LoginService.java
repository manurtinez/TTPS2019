package ttps.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import ttps.spring.DAO.UsuarioDAO;
import ttps.spring.DAO.VeterinarioDAO;
import ttps.spring.model.Usuario;
import ttps.spring.model.Veterinario;
import ttps.spring.utils.TokenValidator;

import java.util.UUID;

@Service
public class LoginService {
	@Autowired
	private UsuarioDAO usuariodao;
	@Autowired
	private TokenValidator tokenvalidator;
	@Autowired
	private VeterinarioDAO veterinariodao;
	
	public boolean isLoginSuccess(String email, String password) {
        // recupero el usuario de la base de usuarios
        Usuario u = usuariodao.getByEmailAndPass(email, password);

        // chequeo que el usuario exista y el password sea correcto
        return (u != null && u.getPassword().equals(password));
    }

	public String generateToken(String usuario, int sec) {
		String rol =  this.getRolUsuario(usuario);
		String token = tokenvalidator.generateToken(usuario, rol, sec);
		return token;
	}

	private String getRolUsuario(String usuario) {
		Veterinario v = veterinariodao.getByIdEmail(usuario);
		if (v != null) {
			return "Veterinario";
		}
		return "Dueno";
	}
		
}
