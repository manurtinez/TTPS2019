package clasesDAOjpa;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
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
	public Usuario getById(int id) {
		EntityManager em = emf.createEntityManager();
		Usuario user = em.find(Usuario.class, id);
        return user;
	}

	@Override
	public List<Usuario> getAll() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("FROM Usuario", Usuario.class);
		List<Usuario> lista = query.getResultList();
		em.close();
		return lista;
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
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		em.remove(em.merge(u));
		etx.commit();
		em.close();
	}

}
