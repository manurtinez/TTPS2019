package ttps.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.DTO.DuenoDTO;
import ttps.spring.DTO.StringResponse;
import ttps.spring.model.Dueno;
import ttps.spring.model.Mascota;
import ttps.spring.services.DuenoService;
import org.springframework.http.MediaType;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class DuenoController {
	
	@Autowired
	DuenoService duenoservice;
	
	//recupero todas las mascotas de un dueno
	@GetMapping("/dueno/mascota/{id}")
	public ResponseEntity<List<Mascota>> todasLasMascotasDeUnDueno (@PathVariable("id") int id) {
		//System.out.println(id);
		List<Mascota> lista = duenoservice.getAllMascotas(id);
		if(lista.isEmpty()) {
			return new ResponseEntity<List<Mascota>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Mascota>>(lista, HttpStatus.OK);
	}
	//recupero todos los duenos
	@GetMapping("/duenos")
	public ResponseEntity<List<Dueno>> listar(){
		List<Dueno> lista = duenoservice.getAll();
		if(! lista.isEmpty()) {
			return new ResponseEntity<List<Dueno>>(lista, HttpStatus.OK);
		}
		return new ResponseEntity<List<Dueno>>(HttpStatus.NO_CONTENT);
	}
	@PostMapping("/create/dueno")
	public ResponseEntity<StringResponse> nuevoDueno(@RequestBody DuenoDTO dueno){
		if (!duenoservice.existeDueno(dueno.getEmail())) {
			if (duenoservice.crearDueno(dueno)) {
				StringResponse sr = new StringResponse("el dueño se creo correctamente");
				return new ResponseEntity<StringResponse>(sr, HttpStatus.OK);
			}else {
				StringResponse sr = new StringResponse("error en la creacion");
				return new ResponseEntity<StringResponse>(sr, HttpStatus.CONFLICT);
			}
		}
		StringResponse sr = new StringResponse("usuario existente");
		return new ResponseEntity<StringResponse>(sr, HttpStatus.NOT_ACCEPTABLE);
	}
	
	@PostMapping("/editDueno/{id}")
	public ResponseEntity<?> editarDueno (@PathVariable("id") int id, @RequestBody DuenoDTO dueno) {
		if (duenoservice.editarDueno(id, dueno)) {
			StringResponse sr = new StringResponse("dueno editado correctamente");
			return new ResponseEntity<StringResponse>(sr, HttpStatus.OK);
		}else {
			StringResponse sr = new StringResponse("error en la edicion");
			return new ResponseEntity<StringResponse>(sr, HttpStatus.CONFLICT);
		}
	}
}
