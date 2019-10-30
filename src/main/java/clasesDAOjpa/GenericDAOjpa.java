package clasesDAOjpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import clasesDAO.Dao;
import model.Usuario;
import entityManager.MiEntityManager;

public class GenericDAOjpa<T> implements Dao<T> {
	
	protected EntityManagerFactory emf = MiEntityManager.getEmf();
	
	private Class<T> clase;

	/*@Override
	public List<Usuario> getByName(String name) {
		return (List<Usuario>) em.createQuery("SELECT u FROM User u WHERE u.")
	}*/

	@Override
	public T getById(int id) {
		EntityManager em = emf.createEntityManager();
		T user = em.find(clase, id);
        return user;
	}

	@Override
	public List<T> getAll() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("from " + clase.getName());
		List<T> lista = query.getResultList();
		em.close();
		return lista;
	}

	@Override
	public void save(T t) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		em.persist(t);
		etx.commit();
		em.close();
	}

	@Override
	public void update(T u, String[] params) {
		//...
	}

	@Override
	public void delete(T t) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		em.remove(em.merge(t));
		etx.commit();
		em.close();
	}

	public Class<T> getClase() {
		return clase;
	}

	public void setClase(Class<T> clase) {
		this.clase = clase;
	}

}
