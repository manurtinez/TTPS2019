package ttps.spring.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.DAO.DuenoDAO;
import ttps.spring.DAO.EventoDAO;
import ttps.spring.DTO.EventoDTO;
import ttps.spring.model.Evento;
import ttps.spring.model.Mascota;
import ttps.spring.utils.EventoDTOListGenerator;

@Service
public class EventoService {
	@Autowired
	private DuenoDAO duenoDAO;
	
	@Autowired
	private EventoDAO eventoDAO;
	
	@Autowired
	private EventoDTOListGenerator eventoDTOListGenerator;
	
	public List<EventoDTO> getAllEventosPasados(int id, String fecha){
		LocalDate f = LocalDate.parse(fecha);
		List<Mascota> listaMascota = duenoDAO.getAllMascotas(id);
		List<Evento> listaEventos = new ArrayList<>(); 
		for (Mascota m : listaMascota) {
			listaEventos.addAll((List<Evento>) eventoDAO.getBeforeDate(f, m.getId()));
		}
		return this.listGenerator(listaEventos);
	}
	
	public List<EventoDTO> getAllEventosFuturos(int id, String fecha) {
		LocalDate f = LocalDate.parse(fecha);
		List<Mascota> listaMascota = duenoDAO.getAllMascotas(id);
		List<Evento> listaEventos = new ArrayList<>(); 
		for (Mascota m : listaMascota) {
			listaEventos.addAll((List<Evento>) eventoDAO.getAfterDate(f, m.getId()));
		}
		return this.listGenerator(listaEventos);
	}
	
	public List<EventoDTO> listGenerator(List<Evento> lista){
		return eventoDTOListGenerator.listGenerator(lista);
	}
}
