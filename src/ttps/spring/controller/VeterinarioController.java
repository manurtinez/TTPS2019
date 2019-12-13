package ttps.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.DTO.VeterinarioDTO;
import ttps.spring.services.VeterinarioService;

@RestController
@RequestMapping
@CrossOrigin
public class VeterinarioController {
	@Autowired
	private VeterinarioService vetservice;
	
	@PostMapping("/create/veterinario")
	public ResponseEntity<?> nuevoVeterinario(@RequestBody VeterinarioDTO vet){
		if (!vetservice.existeVet(vet.getEmail())) {
			if (vetservice.crearVet(vet)) {
				return  ResponseEntity.status(HttpStatus.CREATED).body("veterinario creado correctamente");
			}else {
				return ResponseEntity.status(HttpStatus.CONFLICT).body("error en la creacion");
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("usuario existente");
	}
}
