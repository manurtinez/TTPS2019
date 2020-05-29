package ttps.spring.DAOjpa;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import ttps.spring.DAO.EventoDAO;
import ttps.spring.model.Evento;
@Repository
public class EventoDAOjpa extends GenericDAOjpa<Evento>
implements EventoDAO {
	
	public EventoDAOjpa() {
		super(Evento.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Evento> getAfterDate(Date d, int id) {
		EntityManager em = getEntityManager();
		return (List<Evento>) em.createQuery("select e from Evento e where e.fecha >= ?1 AND e.mascota.id = ?2")
				.setParameter(1, d).setParameter(2, id).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Evento> getBeforeDate(Date d, int id) {
		EntityManager em = getEntityManager();
		return (List<Evento>) em.createQuery("select e from Evento e where e.fecha < ?1 AND e.mascota.id = ?2")
				.setParameter(1, d).setParameter(2, id).getResultList();
	}
}
