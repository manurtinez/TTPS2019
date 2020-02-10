package ttps.spring.DAOjpa;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import ttps.spring.DAO.EventoDAO;
import ttps.spring.model.Evento;

public class EventoDAOjpa extends GenericDAOjpa<Evento>
implements EventoDAO {
	
	public EventoDAOjpa() {
		super(Evento.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Evento> getByDate(LocalDate d) {
		EntityManager em = getEntityManager();
		return (List<Evento>) em.createQuery("select e from Evento e where e.fecha >= ?1")
				.setParameter(1, d).getResultList();
	}
}
