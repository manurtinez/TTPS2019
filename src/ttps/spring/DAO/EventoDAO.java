package ttps.spring.DAO;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import ttps.spring.model.Evento;

public interface EventoDAO extends GenericDAO<Evento> {
	List<Evento> getAfterDate(Date d, int id);
	List<Evento> getBeforeDate(Date d, int id);
}
