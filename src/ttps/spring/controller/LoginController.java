package ttps.spring.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.DTO.Credentials;
import ttps.spring.DTO.LoginDTO;
import ttps.spring.DTO.StringResponse;
import ttps.spring.model.Usuario;
import ttps.spring.services.LoginService;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class LoginController {
	@Autowired
	private LoginService loginservice;
	
	private final int EXPIRATION_IN_SEC = 1800;
	  
	@PostMapping("/autenticacion")
	public ResponseEntity<?> autenticateUser(@RequestBody LoginDTO login){
		Usuario u = loginservice.isLoginSuccess(login.getUsuario(), login.getPassword());
		if (u != null) {
		    String token = loginservice.generateToken(login.getUsuario(), EXPIRATION_IN_SEC);
		    Credentials c = new Credentials(token, EXPIRATION_IN_SEC, login.getUsuario(), u.getId(), u.getClass().getName(),
		    		u.getNombre(), u.getApellido(),u.getTelefono(), u.getEmail());
		    System.out.println(c.getId());
            return new ResponseEntity<Credentials>(c, HttpStatus.OK);
        } else {
        	return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
}