package clasesDAOjpa;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import clasesDAO.EventoDAO;
import entityManager.MiEntityManager;
import model.Evento;

public class EventoDAOjpa implements EventoDAO {
	
	EntityManager em = MiEntityManager.getManager();
	
	public Optional<Evento> getById(int id) {
		return Optional.ofNullable(em.find(Evento.class, id));
	}

	@Override
	public List<Evento> getAll() {
		Query query = em.createQuery("SELECT * FROM evento");
		return (List<Evento>)query.getResultList();
	}

	@Override
	public void save(Evento e) {
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
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		em.remove(e);
		etx.commit();
	}

	@Override
	public List<Evento> getByDate(Date d) {
		Query query = em.createQuery("SELECT e FROM evento WHERE e.fecha>=:d");
		return (List<Evento>)query.getResultList();
	}
}
