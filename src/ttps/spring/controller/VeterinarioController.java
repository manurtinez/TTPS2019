package ttps.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.DTO.MascotaConDueno;
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
	
	@GetMapping("/todos-los-veterinarios")
	public ResponseEntity<List<VeterinarioDTO>> todosLosVet (){
		List<VeterinarioDTO> lista = vetservice.todosLosVeterinarios();
		if(lista.isEmpty()) {
			return new ResponseEntity<List<VeterinarioDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<VeterinarioDTO>>(lista, HttpStatus.OK); 	
	}
	
	//todas las mascotas (aceptadas) con su dueno de un determinado veterinario
	@GetMapping("veterinario/{id}/mascotas")
	public ResponseEntity<List<MascotaConDueno>> getAllMascotasDeVeterinario (@PathVariable("id") int vetId){
		List<MascotaConDueno> lista = vetservice.getAllMascotasDeVeterinario(vetId);
		if(lista.isEmpty()) {
			return new ResponseEntity<List<MascotaConDueno>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<MascotaConDueno>>(lista, HttpStatus.OK); 	
	}
	
	//todas las mascotas (pendientes a aceptar) con su dueno de un determinado veterinario
	@GetMapping("veterinario/{id}/mascotas-pendientes")
	public ResponseEntity<List<MascotaConDueno>> getAllMascotasPendientesDeVeterinario (@PathVariable("id") int vetId){
		List<MascotaConDueno> lista = vetservice.getAllMascotasDeVeterinarioPendientes(vetId);
		if(lista.isEmpty()) {
			return new ResponseEntity<List<MascotaConDueno>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<MascotaConDueno>>(lista, HttpStatus.OK); 	
	}
	
	@GetMapping("veterinario/mascotas/{id}/aceptar-mascota")
	public ResponseEntity<StringResponse> aceptarMascota (@PathVariable("id") int mascotaId){
		if(vetservice.aceptarMascota(mascotaId)) {
			StringResponse sr = new StringResponse("mascota aceptada");
			return new ResponseEntity<StringResponse>(sr, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping("veterinario/mascotas/{id}/rechazar-mascota")
	public ResponseEntity<StringResponse> rechazarMascota (@PathVariable("id") int mascotaId){
		if(vetservice.rechazarMascota(mascotaId)) {
			StringResponse sr = new StringResponse("mascota rechazada");
			return new ResponseEntity<StringResponse>(sr, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}
	
}
