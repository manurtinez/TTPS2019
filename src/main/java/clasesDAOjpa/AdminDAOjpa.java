package clasesDAOjpa;

import java.util.List;

import javax.persistence.EntityManager;

import clasesDAO.AdminDAO;
import model.Admin;
import model.Veterinario;

public class AdminDAOjpa extends GenericDAOjpa<Admin> implements AdminDAO{

	public AdminDAOjpa() {
		super(Admin.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Veterinario> getAllVeterinarioInhabilitados() {
		EntityManager em = emf.createEntityManager();
		return (List<Veterinario>) em.createQuery("FROM Veterinario WHERE habilitado = 0").getResultList();
	}

}
