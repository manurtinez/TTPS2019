package ttps.spring.DAOjpa;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import ttps.spring.DAO.UsuarioDAO;
import ttps.spring.model.Usuario;

@Repository
public class UsuarioDAOjpa extends GenericDAOjpa<Usuario> implements UsuarioDAO {

	public UsuarioDAOjpa(Class<Usuario> clase) {
		super(clase);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Usuario getByNombre(String nombre) {
		EntityManager em = getEntityManager();
		return (Usuario) em.createQuery("SELECT u FROM Usuario u WHERE u.nombre=:name");
	}

	@Override
	public Usuario getByEmailAndPass(String email, String pass) {
		EntityManager em = getEntityManager();
		return (Usuario) em.createQuery("SELECT u FROM Usuario u WHERE u.email=:email AND u.password=:pass");
	}

}
