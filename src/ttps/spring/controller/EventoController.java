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

import ttps.spring.DTO.EventoDTO;
import ttps.spring.DTO.IdRequest;
import ttps.spring.DTO.StringResponse;
import ttps.spring.services.EventoService;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class EventoController {
	@Autowired
	private EventoService eventoservice;
	
	//retorna eventos posteriores a la fecha (inclusive) enviada como parametro
	@GetMapping("/dueno/{id}/mascotas/eventos-posteriores/{fecha}")//ejemplo fecha: 2020-02-12
	public ResponseEntity<List<EventoDTO>> TodosLosEventosDeTodasLasMascotasDeUnDuenoPostFecha (@PathVariable("fecha") String fecha ,
																					@PathVariable("id") int id) {
		List<EventoDTO> lista = eventoservice.getAllEventosFuturos(id, fecha);
		if(lista.isEmpty()) {
			return new ResponseEntity<List<EventoDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EventoDTO>>(lista, HttpStatus.OK); 
	}
	//retorna eventos anteriores a la fecha enviada como parametro. (Historial)
	@GetMapping("/dueno/{id}/mascotas/eventos-anteriores/{fecha}")//ejemplo fecha: 2020-02-12
	public ResponseEntity<List<EventoDTO>> TodosLosEventosDeTodasLasMascotasDeUnDuenoAntesFecha (@PathVariable("fecha") String fecha ,
																					@PathVariable("id") int id) {
		List<EventoDTO> lista = eventoservice.getAllEventosPasados(id, fecha);
		if(lista.isEmpty()) {
			return new ResponseEntity<List<EventoDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EventoDTO>>(lista, HttpStatus.OK); 
	}
	
	@PostMapping("/dueno/mascota/{id}/nueva-visita/{fecha}")
	public ResponseEntity<StringResponse> altaMascota (@PathVariable("fecha") String fecha ,
											    @PathVariable("id") int idMascota,
												@RequestBody EventoDTO eventoDTO ) {
		
		if(eventoservice.altaVisita(fecha, eventoDTO, idMascota)) {
			StringResponse sr = new StringResponse("Visita creada correctamente");
			return new ResponseEntity<StringResponse>(sr, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@PostMapping("/dueno/mascota/{idMascota}/borrar-evento")
	public ResponseEntity<StringResponse> altaMascota (@PathVariable("idMascota") int idMascota,
												@RequestBody IdRequest idrequest ) {
		
		if(eventoservice.borrarEvento(idMascota, idrequest.getId())) {
			StringResponse sr = new StringResponse("Evento borrado correctamente");
			return new ResponseEntity<StringResponse>(sr, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}
}
