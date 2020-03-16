package ttps.spring.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ttps.spring.DTO.EventoDTO;
import ttps.spring.model.Desparasitacion;
import ttps.spring.model.Enfermedad;
import ttps.spring.model.Evento;
import ttps.spring.model.HistorialReproductivo;
import ttps.spring.model.Intervencion;
import ttps.spring.model.Mascota;
import ttps.spring.model.Vacunacion;
import ttps.spring.model.Visita;

@Component
public class EventoGenerator {

	public Evento nuevoEvento (LocalDate fecha, EventoDTO eventoDTO, Mascota mascota) {
		Evento ev = null;
		switch (eventoDTO.getTipo_evento()) {
		case "Desparasitacion": 
			ev = new Desparasitacion(fecha, mascota, eventoDTO.getDroga(), eventoDTO.getResultado());
			break;
		case "Enfermedad":
			ev = new Enfermedad(fecha, mascota, eventoDTO.getDescripcion());
			break;		
		case "HistorialReproductivo":
			ev = new HistorialReproductivo(fecha, mascota, eventoDTO.getNro_nacidos());
			break;
		case "Intervencion":
			ev = new Intervencion(fecha, mascota, eventoDTO.getDescripcion());
			break;
		case "Vacunacion":
			ev = new Vacunacion(fecha, mascota, eventoDTO.getDescripcion());
			break;
		case "Visita":
			ev = new Visita(fecha, mascota, eventoDTO.getPeso(), eventoDTO.getMotivo(), eventoDTO.getDescripcion(), eventoDTO.getIndicaciones());
			break;
		}
		return ev;
	}
	public List<EventoDTO> listGenerator (List<Evento> lista){
		List<EventoDTO> resultado =  new ArrayList<>();
		for (Evento e : lista) {
			String clase = e.getClass().getSimpleName();
			EventoDTO eventoDTO;
			switch (clase) {
				case "Desparasitacion": 
					eventoDTO = new EventoDTO(clase, e.getId(), e.getFecha(),
							((Desparasitacion) e).getDroga(), ((Desparasitacion) e).getResultado());
					resultado.add(eventoDTO);
					break;
				case "Enfermedad":
					eventoDTO = new EventoDTO(clase, e.getId(), e.getFecha(), ( (Enfermedad) e ).getDescripcion());
					resultado.add(eventoDTO);
					break;		
				case "HistorialReproductivo":
					eventoDTO = new EventoDTO(clase, e.getId(), e.getFecha(), ((HistorialReproductivo) e).getNroNacidos());
					resultado.add(eventoDTO);
					break;
				case "Intervencion":
					eventoDTO = new EventoDTO(clase, e.getId(), e.getFecha(), ((Intervencion)e).getDescripcion());
					resultado.add(eventoDTO);
					break;
				case "Vacunacion":
					eventoDTO = new EventoDTO(clase, e.getId(), e.getFecha(), ((Vacunacion)e).getDescripcion());
					resultado.add(eventoDTO);
					break;
				case "Visita":
					eventoDTO = new EventoDTO(clase, e.getId(), e.getFecha(), ((Visita) e).getDescripcion(),
							((Visita) e).getIndicaciones(), ((Visita) e).getMotivo(), ((Visita) e).getPeso());
					resultado.add(eventoDTO);
					break;
			}
		}
		return resultado;
	}
}
