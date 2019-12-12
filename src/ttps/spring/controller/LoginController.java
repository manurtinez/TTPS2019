package ttps.spring.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.DTO.Credentials;
import ttps.spring.DTO.LoginDTO;
import ttps.spring.model.Usuario;
import ttps.spring.services.LoginService;

@RestController
@RequestMapping
@CrossOrigin
public class LoginController {
	@Autowired
	private LoginService loginservice;
	
	private final int EXPIRATION_IN_SEC = 10;
	  
	@PostMapping("/autenticacion")
	public ResponseEntity<?> autenticateUser(@RequestBody LoginDTO login){
		Usuario u = loginservice.isLoginSuccess(login.getUsuario(), login.getPassword());
		if (u != null) {
		    String token = loginservice.generateToken(login.getUsuario(), EXPIRATION_IN_SEC);
		    Credentials c = new Credentials(token, EXPIRATION_IN_SEC, login.getUsuario(), u.getId(), u.getClassString());
		    System.out.println(c.getId());
            return ResponseEntity.ok(c);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o password incorrecto");
		}
	}
}