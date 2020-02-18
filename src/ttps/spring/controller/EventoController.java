package ttps.spring.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.model.Evento;
import ttps.spring.services.EventoService;
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class EventoController {
	@Autowired
	private EventoService eventoservice;
	
	@GetMapping("/dueno/{id}/mascotas/eventos/{fecha}")
	public ResponseEntity<List<Evento>> TodosLosEventosDeTodasLasMascotasDeUnDueno (@PathVariable("fecha") String fecha ,
																					@PathVariable("id") int id) {
		List<Evento> lista = eventoservice.getAllEventosDeDueno(id, fecha);
		if(lista.isEmpty()) {
			return new ResponseEntity<List<Evento>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Evento>>(lista, HttpStatus.OK); 
	}
}
