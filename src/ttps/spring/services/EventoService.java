package ttps.spring.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.DAO.DuenoDAO;
import ttps.spring.DAO.EventoDAO;
import ttps.spring.DAO.MascotaDAO;
import ttps.spring.DTO.EventoDTO;
import ttps.spring.model.Evento;
import ttps.spring.model.Mascota;
import ttps.spring.model.Visita;
import ttps.spring.utils.EventoDTOListGenerator;

@Service
public class EventoService {

	private MascotaDAO mascotaDAO;
	private DuenoDAO duenoDAO;
	private EventoDAO eventoDAO;
	private EventoDTOListGenerator eventoDTOListGenerator;
	
	public EventoService () {}
	
	@Autowired
	public EventoService (MascotaDAO mascotaDAO, DuenoDAO duenoDAO, EventoDAO eventoDAO, EventoDTOListGenerator eventoDTOListGenerator) {
		this.duenoDAO = duenoDAO;
		this.eventoDAO = eventoDAO;
		this.eventoDTOListGenerator = eventoDTOListGenerator;
		this.mascotaDAO = mascotaDAO;
	}
	public boolean altaVisita (String fecha, EventoDTO eventoDTO, int id){
		try {
			LocalDate f = LocalDate.parse(fecha);
			Mascota mascota = mascotaDAO.getById(id);
			Visita visita = new Visita(f, mascota, eventoDTO.getPeso(), eventoDTO.getMotivo(),
							eventoDTO.getDescripcion(), eventoDTO.getIndicaciones());
			eventoDAO.save(visita);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<EventoDTO> getAllEventosPasados(int id, String fecha){
		try {
			LocalDate f = LocalDate.parse(fecha);
			List<Mascota> listaMascota = duenoDAO.getAllMascotas(id);
			List<Evento> listaEventos = new ArrayList<>(); 
			for (Mascota m : listaMascota) {
				listaEventos.addAll((List<Evento>) eventoDAO.getBeforeDate(f, m.getId()));
			}
			return this.listGenerator(listaEventos);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<EventoDTO> getAllEventosFuturos(int id, String fecha) {
		try {
			LocalDate f = LocalDate.parse(fecha);
			List<Mascota> listaMascota = duenoDAO.getAllMascotas(id);
			List<Evento> listaEventos = new ArrayList<>(); 
			for (Mascota m : listaMascota) {
				listaEventos.addAll((List<Evento>) eventoDAO.getAfterDate(f, m.getId()));
			}
			return this.listGenerator(listaEventos);	
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<EventoDTO> listGenerator(List<Evento> lista){
		return eventoDTOListGenerator.listGenerator(lista);
	}
}
