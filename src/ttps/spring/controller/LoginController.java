package ttps.spring.controller;
import java.util.List;

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
import ttps.spring.DTO.VeterinarioDTO;
import ttps.spring.model.Usuario;
import ttps.spring.services.AdminService;
import ttps.spring.services.LoginService;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class LoginController {
	@Autowired
	private LoginService loginservice;
	private AdminService adminservice;
	
	private final int EXPIRATION_IN_SEC = 60*60;
	  
	@PostMapping("/autenticacion")
	public ResponseEntity<?> autenticateUser(@RequestBody LoginDTO login){
		Usuario u = loginservice.isLoginSuccess(login.getUsuario(), login.getPassword());
		if (u != null) {
		    String token = loginservice.generateToken(login.getUsuario(), EXPIRATION_IN_SEC);
		    Credentials c = new Credentials(token, EXPIRATION_IN_SEC, login.getUsuario(), u.getId(), u.getClass().getSimpleName(),
		    		u.getNombre(), u.getApellido(),u.getTelefono(), u.getEmail());
		    System.out.println(u.getClass().getSimpleName());
		    if (u.getClass().getSimpleName() == "Veterinario") {
		    	List<VeterinarioDTO> list = adminservice.getAllVeterinariosInhabilitados();
		    	System.out.println(list);
		    	for (VeterinarioDTO v : list) {
		    		System.out.println("id actual " + v.getId());
		    		if (v.getId() == u.getId()) {
		    			System.out.println("encontre vet" + v);
		    			c.setHabilitado(v.getHabilitado());
		    		}
		    	}
		    } else {
		    	c.setHabilitado(1);
		    }
            return new ResponseEntity<Credentials>(c, HttpStatus.OK);
        } else {
        	return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
}