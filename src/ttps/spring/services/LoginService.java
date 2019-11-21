package ttps.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import ttps.spring.DAO.UsuarioDAO;
import ttps.spring.model.Usuario;


@Service
public class LoginService {
	@Autowired
	private UsuarioDAO usuariodao;

	public HttpHeaders autenticateUser(String email, String password) {
		try {
			Usuario user = usuariodao.getByEmail(email);
            if (user.getPassword().equals(password)) {
    			HttpHeaders headers = new HttpHeaders();
                headers.add("Authorization",user.getId() + "123456");
                return headers;
            }
            return null;
		}catch(Exception e) {
			return null;
		}
	}
	
	
}
