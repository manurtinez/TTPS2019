package ttps.spring.utils;

import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ttps.spring.DAO.UsuarioDAO;
import ttps.spring.exception.InvalidTokenException;

@Component
public class TokenValidator {
	@Autowired
	private UsuarioDAO usuariodao;
	
	public int validateTokenAndGetId(String token) throws InvalidTokenException {
        if(token.contains("123456")){
            String idToken = token.split("123456$")[0];
        	int id = Integer.parseInt(idToken);
            try {
                usuariodao.getById(id);
            }
            catch (NoResultException e){
                throw new InvalidTokenException();
            }
            return id;
        }
        throw new InvalidTokenException();
    }

}
