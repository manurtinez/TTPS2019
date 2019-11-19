package ttps.spring.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.model.Usuario;
import ttps.spring.services.UserService;

@RestController
@RequestMapping
public class LoginController {
	
	@Autowired
	UserService userservice;
	
	private RequestCache requestCache = new HttpSessionRequestCache();
	
	@RequestMapping(value = "/login", method= RequestMethod.POST)
	public ResponseEntity<Usuario> login(HttpServletRequest request,
			HttpServletResponse response, String email, String pass)
	throws ServletException{
		Usuario user = userservice.getByEmailAndPass(email, pass);
		try {
			request.login(email, pass);
			SavedRequest savedRequest = requestCache.getRequest(request, response);
			if(savedRequest != null) {
				return new ResponseEntity<Usuario>(user, HttpStatus.OK);
			}
			return new ResponseEntity<Usuario>(HttpStatus.UNAUTHORIZED);
		}
		catch (ServletException authenticationFailed){
			System.out.println(authenticationFailed.getMessage());
			return new ResponseEntity<Usuario>(HttpStatus.UNAUTHORIZED);
		}
	}
}
