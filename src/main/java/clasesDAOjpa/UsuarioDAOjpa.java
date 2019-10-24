package clasesDAOjpa;

import java.util.List;

import javax.persistence.EntityManager;
import clasesDAO.UsuarioDAO;
import model.Usuario;
import entityManager.MiEntityManager;

public class UsuarioDAOjpa implements UsuarioDAO {
	
	protected EntityManager em = MiEntityManager.getManager();
	@Override
	public List<Usuario> all() {
		return (List<Usuario>) em.createQuery("SELECT * FROM User").getResultList();
	}

	@Override
	public List<Usuario> getByID(int id) {
		return (List<Usuario>) em.createQuery("SELECT u FROM User u WHERE u.id = :id");
	}

	/*@Override
	public List<Usuario> getByName(String name) {
		return (List<Usuario>) em.createQuery("SELECT u FROM User u WHERE u.")
	}*/

	@Override
	public void crearUsuario(Usuario usuario) {
		try {
			em.persist(usuario);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	@Override
	public void modificarUsuario(Usuario usuario) {
		//...
	}

	@Override
	public void borrarUsuario(Usuario usuario) {
		try {
			em.remove(usuario);
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

}
