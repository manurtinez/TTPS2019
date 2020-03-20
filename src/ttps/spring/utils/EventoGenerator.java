package ttps.spring.utils;

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

	public Evento nuevoEvento (EventoDTO eventoDTO, Mascota mascota) {
		Evento ev = null;
		switch (eventoDTO.getTipo_evento()) {
		case "Desparasitacion": 
			ev = new Desparasitacion(eventoDTO.getFecha(), mascota, eventoDTO.getDroga(), eventoDTO.getResultado());
			break;
		case "Enfermedad":
			ev = new Enfermedad(eventoDTO.getFecha(), mascota, eventoDTO.getDescripcion());
			break;		
		case "HistorialReproductivo":
			ev = new HistorialReproductivo(eventoDTO.getFecha(), mascota, eventoDTO.getNro_nacidos());
			break;
		case "Intervencion":
			ev = new Intervencion(eventoDTO.getFecha(), mascota, eventoDTO.getDescripcion());
			break;
		case "Vacunacion":
			ev = new Vacunacion(eventoDTO.getFecha(), mascota, eventoDTO.getDescripcion());
			break;
		case "Visita":
			ev = new Visita(eventoDTO.getFecha(), mascota, eventoDTO.getPeso(), eventoDTO.getMotivo(), eventoDTO.getDescripcion(), eventoDTO.getIndicaciones());
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
							((Desparasitacion) e).getDroga(), ((Desparasitacion) e).getResultado(), e.getMascota().getId());
					resultado.add(eventoDTO);
					break;
				case "Enfermedad":
					eventoDTO = new EventoDTO(clase, e.getId(), e.getFecha(), ( (Enfermedad) e ).getDescripcion(), e.getMascota().getId());
					resultado.add(eventoDTO);
					break;		
				case "HistorialReproductivo":
					eventoDTO = new EventoDTO(clase, e.getId(), e.getFecha(), ((HistorialReproductivo) e).getNroNacidos(), e.getMascota().getId());
					resultado.add(eventoDTO);
					break;
				case "Intervencion":
					eventoDTO = new EventoDTO(clase, e.getId(), e.getFecha(), ((Intervencion)e).getDescripcion(), e.getMascota().getId());
					resultado.add(eventoDTO);
					break;
				case "Vacunacion":
					eventoDTO = new EventoDTO(clase, e.getId(), e.getFecha(), ((Vacunacion)e).getDescripcion(), e.getMascota().getId());
					resultado.add(eventoDTO);
					break;
				case "Visita":
					eventoDTO = new EventoDTO(clase, e.getId(), e.getFecha(), ((Visita) e).getDescripcion(),
							((Visita) e).getIndicaciones(), ((Visita) e).getMotivo(), ((Visita) e).getPeso(), e.getMascota().getId());
					resultado.add(eventoDTO);
					break;
			}
		}
		return resultado;
	}
	
	public Evento editarEvento(Evento evento, EventoDTO eventoDTO, Mascota mascota) {
		evento.setFecha(eventoDTO.getFecha());
		evento.setMascota(mascota);
		switch (eventoDTO.getTipo_evento()) {
			case "Desparasitacion": 
				((Desparasitacion) evento).setDroga(eventoDTO.getDroga());
				((Desparasitacion) evento).setResultado(eventoDTO.getResultado());			
				break;
			case "Enfermedad":
				((Enfermedad) evento).setDescripcion(eventoDTO.getDescripcion());
				break;		
			case "HistorialReproductivo":
				((HistorialReproductivo) evento).setNroNacidos(eventoDTO.getNro_nacidos());
				break;
			case "Intervencion":
				((Intervencion) evento).setDescripcion(eventoDTO.getDescripcion());
				break;
			case "Vacunacion":
				((Vacunacion) evento).setDescripcion(eventoDTO.getDescripcion());
				break;
			case "Visita":
				((Visita) evento).setPeso(eventoDTO.getPeso());
				((Visita) evento).setMotivo(eventoDTO.getMotivo());
				((Visita) evento).setDescripcion(eventoDTO.getDescripcion());
				((Visita) evento).setIndicaciones(eventoDTO.getIndicaciones());
				break;
		}
		return evento;
	}
}
