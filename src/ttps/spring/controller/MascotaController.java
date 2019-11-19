package ttps.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.model.Mascota;
import ttps.spring.services.MascotaService;

@RestController
@RequestMapping
public class MascotaController {
	@Autowired
	private MascotaService mascotaService;

	@PostMapping("/mascota")
	public ResponseEntity<Mascota> altaMascota (@RequestBody Mascota mascota ) {
		System.out.println("antes del if");
		if(mascotaService.altaMascota(mascota)) {
			return new ResponseEntity<Mascota>(mascota, HttpStatus.CREATED);
		}
		return new ResponseEntity<Mascota>(HttpStatus.CONFLICT);
	}
}
