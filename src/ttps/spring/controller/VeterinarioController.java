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

import ttps.spring.DTO.StringResponse;
import ttps.spring.DTO.VeterinarioDTO;
import ttps.spring.services.VeterinarioService;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class VeterinarioController {
	@Autowired
	private VeterinarioService vetservice;
	
	@PostMapping("/create/veterinario")
	public ResponseEntity<?> nuevoVeterinario(@RequestBody VeterinarioDTO vet){
		if (!vetservice.existeVet(vet.getEmail())) {
			if (vetservice.crearVet(vet)) {
				StringResponse sr = new StringResponse("veterinario creado correctamente");
				return new ResponseEntity<StringResponse>(sr, HttpStatus.CREATED);
			}else {
				StringResponse sr = new StringResponse("error en la creacion");
				return new ResponseEntity<StringResponse>(sr, HttpStatus.CONFLICT);
			}
		}
		StringResponse sr = new StringResponse("usuario existente");
		return new ResponseEntity<StringResponse>(sr, HttpStatus.NOT_ACCEPTABLE);
	}
}
