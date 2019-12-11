package ttps.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ttps.spring.DAO.UsuarioDAO;
import ttps.spring.model.Usuario;
import ttps.spring.utils.TokenValidator;

@Service
public class LoginService {
	@Autowired
	private UsuarioDAO usuariodao;
	@Autowired
	private TokenValidator tokenvalidator;
	
	public Usuario isLoginSuccess(String email, String password) {
        // recupero el usuario de la base de usuarios
        Usuario u = usuariodao.getByEmailAndPass(email, password);
     // chequeo que el usuario exista y el password sea correcto
        if (u != null && u.getPassword().equals(password)) {
        	return u;
        }
        return null;
    }

	public String generateToken(String usuario, int sec) {
		String token = tokenvalidator.generateToken(usuario, sec);
		return token;
	}
		
}
