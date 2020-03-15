package ttps.spring.controller;

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

import ttps.spring.DTO.IdRequest;
import ttps.spring.DTO.MascotaConDueno;
import ttps.spring.DTO.MascotaDTO;
import ttps.spring.DTO.StringResponse;
import ttps.spring.services.MascotaService;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class MascotaController {
	
	private MascotaService mascotaService;

	@Autowired
	public MascotaController(MascotaService mascotaService) {
		this.mascotaService = mascotaService;

	}
	public MascotaController() {}

	@PostMapping("/dueno/{id}/nuevaMascota")
	public ResponseEntity<StringResponse> altaMascota (@PathVariable("id") int id,
												@RequestBody MascotaDTO mascota ) {
		if(mascotaService.altaMascota(mascota, id)) {
			StringResponse sr = new StringResponse("mascota creada correctamente");
			return new ResponseEntity<StringResponse>(sr, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@PostMapping("/dueno/editarMascota/{mascota_id}")
	public ResponseEntity<StringResponse> editarMascota (@PathVariable("mascota_id") int mascotaId,
											@RequestBody MascotaDTO mascota ) {
		if(mascotaService.editarMascota(mascota, mascotaId)) {
			StringResponse sr = new StringResponse("mascota editada correctamente");
			return new ResponseEntity<StringResponse>(sr, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@PostMapping("/dueno/{dueno_id}/borrarMascota")
	public ResponseEntity<StringResponse> borrarMascota (@PathVariable("dueno_id") int duenoId,
														@RequestBody int idMascota) {
		if(mascotaService.borrarMascota(idMascota, duenoId)) {
			StringResponse sr = new StringResponse("mascota borrada correctamente");
			return new ResponseEntity<StringResponse>(sr, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping("mascotaSola/{mascota_id}")
	public ResponseEntity<MascotaDTO> unaMascota (@PathVariable("mascota_id") int mascotaId){
		MascotaDTO mascotaDTO = mascotaService.unaMascota(mascotaId);
		if( mascotaDTO != null) {
			return new ResponseEntity<MascotaDTO>(mascotaDTO, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("mascotaConDueno/{mascota_id}")
	public ResponseEntity<MascotaConDueno> unaMascotaConDueno (@PathVariable("mascota_id") int mascotaId){
		MascotaConDueno MascotaConDueno = mascotaService.unaMascotaConDueno(mascotaId);
		if( MascotaConDueno != null) {
			return new ResponseEntity<MascotaConDueno>(MascotaConDueno, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
