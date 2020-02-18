package ttps.spring.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.DAO.DuenoDAO;
import ttps.spring.DAO.EventoDAO;
import ttps.spring.model.Evento;
import ttps.spring.model.Mascota;
@Service
public class EventoService {
	@Autowired
	private DuenoDAO duenoDAO;
	
	@Autowired
	private EventoDAO eventoDAO;
	
	public List<Evento> getAllEventosDeDueno(int id, String fecha) {
		LocalDate f = LocalDate.parse(fecha);
		List<Mascota> lista = duenoDAO.getAllMascotas(id);
		List<Evento> resultado = new ArrayList<>(); 
		for (Mascota m : lista) {
			resultado.addAll((List<Evento>) eventoDAO.getByDate(f, m.getId()));
		}
		return resultado;
	}
}
