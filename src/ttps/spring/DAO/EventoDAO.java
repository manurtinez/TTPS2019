package ttps.spring.DAO;

import java.time.LocalDate;
import java.util.List;

import ttps.spring.model.Evento;

public interface EventoDAO extends GenericDAO<Evento> {
	List<Evento> getByDate(LocalDate d);
}
