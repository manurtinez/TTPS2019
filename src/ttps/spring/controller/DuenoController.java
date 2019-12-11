package ttps.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.DTO.DuenoDTO;
import ttps.spring.model.Dueno;
import ttps.spring.model.Mascota;
import ttps.spring.services.DuenoService;

@RestController
@RequestMapping
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
	public ResponseEntity<?> nuevoDueno(@RequestBody DuenoDTO dueno){
		if (!duenoservice.existeDueno(dueno.getEmail())) {
			if (duenoservice.crearDueno(dueno)) {
				return  ResponseEntity.status(HttpStatus.CREATED).body("dueno creado correctamente");
			}else {
				return ResponseEntity.status(HttpStatus.CONFLICT).body("error en la creacion");
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("usuario existente");
	}
}
