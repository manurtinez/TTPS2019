package clasesDAOjpa;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import clasesDAO.EventoDAO;
import model.Dueno;
import model.Evento;

public class EventoDAOjpa extends GenericDAOjpa<Evento>
implements EventoDAO {
	
	public EventoDAOjpa() {
		super(Evento.class);
	}

	@Override
	public List<Evento> getByDate(int year) {
		EntityManager em = emf.createEntityManager();
		/*Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		int year = calendar.get(Calendar.YEAR);*/
		return (List<Evento>) em.createQuery("select e from Evento e where year(e.fecha) >= ?1")
				.setParameter(1, year).getResultList();
	}
}
