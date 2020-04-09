package ttps.spring.DAOjpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import ttps.spring.DAO.AdminDAO;
import ttps.spring.model.Admin;
import ttps.spring.model.Veterinario;
@Repository
public class AdminDAOjpa extends GenericDAOjpa<Admin> implements AdminDAO{

	public AdminDAOjpa() {
		super(Admin.class);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Veterinario> getAllVeterinarioInhabilitados() {
		EntityManager em = getEntityManager();
		return (List<Veterinario>) em.createQuery("FROM Veterinario WHERE habilitado = 0").getResultList();
	}

	@Override
	public Veterinario habilitarVeterinario(Veterinario vet) {
		try {
			System.out.println(vet.getId());
			EntityManager em = getEntityManager();
			vet.setHabilitado(true);
			return em.merge(vet);	
		} catch (Exception e) {
			return null;
		}	
	}
	
}
