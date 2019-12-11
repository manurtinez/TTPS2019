package ttps.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.DTO.MascotaDTO;
import ttps.spring.services.MascotaService;

@RestController
@RequestMapping
@CrossOrigin
public class MascotaController {
	
	private MascotaService mascotaService;

	@Autowired
	public MascotaController(MascotaService mascotaService) {
		this.mascotaService = mascotaService;

	}
	public MascotaController() {}

	@PostMapping("/dueno/{id}/nuevaMascota")
	public ResponseEntity<?> altaMascota (/*@RequestHeader("Authorization") String token,*/@PathVariable("id") int id,
												@RequestBody MascotaDTO mascota ) {
		System.out.println(id);
		if(mascotaService.altaMascota(mascota, id/*, token*/)) {
			return new ResponseEntity<String>("mascota creada correctamente", HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}
}
