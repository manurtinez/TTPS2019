package clasesDAOjpa;

import java.sql.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import clasesDAO.EventoDAO;
import entityManager.MiEntityManager;
import model.Evento;

public class EventoDAOjpa implements EventoDAO {
	
	protected EntityManagerFactory emf = MiEntityManager.getEmf();
	
	public Evento getById(int id) {
		EntityManager em = emf.createEntityManager();
		Evento evento = em.find(Evento.class, id);
        return evento;
	}

	@Override
	public List<Evento> getAll() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT * FROM evento");
		return (List<Evento>)query.getResultList();
	}

	@Override
	public void save(Evento e) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		em.persist(e);
		etx.commit();
	}

	@Override
	public void update(Evento e, String[] params) {
		//...
	}

	@Override
	public void delete(Evento e) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		em.remove(e);
		etx.commit();
	}

	@Override
	public List<Evento> getByDate(Date d) {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT e FROM evento WHERE e.fecha>=:d");
		return (List<Evento>)query.getResultList();
	}
}
