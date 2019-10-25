package clasesDAOjpa;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import clasesDAO.Dao;
import model.Usuario;
import entityManager.MiEntityManager;

public class UsuarioDAOjpa implements Dao<Usuario> {
	
	protected EntityManagerFactory emf = MiEntityManager.getEmf();

	/*@Override
	public List<Usuario> getByName(String name) {
		return (List<Usuario>) em.createQuery("SELECT u FROM User u WHERE u.")
	}*/

	@Override
	public Optional<Usuario> getById(int id) {
		return Optional.ofNullable(em.find(Usuario.class, id));
	}

	@Override
	public List<Usuario> getAll() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("FROM Usuario");
		List <Usuario> resultado = (List<Usuario>)query.getResultList();
		em.close();
		return resultado;
	}

	@Override
	public void save(Usuario u) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		em.persist(u);
		etx.commit();
		em.close();
	}

	@Override
	public void update(Usuario u, String[] params) {
		//...
	}

	@Override
	public void delete(Usuario u) {
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		em.remove(u);
		etx.commit();
	}

}
