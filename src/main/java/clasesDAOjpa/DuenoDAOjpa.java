package clasesDAOjpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import clasesDAO.Dao;
import entityManager.MiEntityManager;
import model.Dueno;

public class DuenoDAOjpa implements Dao<Dueno> {

	protected EntityManagerFactory emf = MiEntityManager.getEmf();

	/*@Override
	public List<Usuario> getByName(String name) {
		return (List<Usuario>) em.createQuery("SELECT u FROM User u WHERE u.")
	}*/

	@Override
	public Dueno getById(int id) {
		EntityManager em = emf.createEntityManager();
		Dueno user = em.find(Dueno.class, id);
        return user;
	}

	@Override
	public List<Dueno> getAll() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("FROM Dueno", Dueno.class);
		List<Dueno> lista = query.getResultList();
		em.close();
		return lista;
	}

	@Override
	public void save(Dueno u) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		em.persist(u);
		etx.commit();
		em.close();
	}

	@Override
	public void update(Dueno u, String[] params) {
		//...
	}

	@Override
	public void delete(Dueno u) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		em.remove(em.merge(u));
		etx.commit();
		em.close();
	}
	
}
