package ttps.spring.utils;

import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ttps.spring.DAO.UsuarioDAO;
import ttps.spring.exception.InvalidTokenException;
import ttps.spring.model.Usuario;

@Component
public class TokenValidator {
	@Autowired
	private UsuarioDAO usuariodao;
	
	public Usuario validateTokenAndGetUser(String token) throws InvalidTokenException {
		Character c = token.charAt(0);
    	int id = Character.getNumericValue(c);
		try {
            Usuario user = usuariodao.getById(id);
            String tokenuser = user.getToken();
            if(tokenuser.equals(token)){
                return user;
            }
        }
        catch (NoResultException e){
            throw new NoResultException();
        }
        throw new InvalidTokenException();
    }

}
