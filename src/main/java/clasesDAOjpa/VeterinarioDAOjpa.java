package clasesDAOjpa;

import java.util.List;

import javax.persistence.EntityManager;

import clasesDAO.VeterinarioDAO;
import model.Mascota;
import model.Veterinario;

public class VeterinarioDAOjpa extends GenericDAOjpa<Veterinario> implements VeterinarioDAO {

	public VeterinarioDAOjpa() {
		super(Veterinario.class);
	}

	@Override
	public List<Mascota> getMascotas(Veterinario vet) {
		EntityManager em = emf.createEntityManager();
		return (List<Mascota>) em.createQuery("SELECT m FROM Mascota m WHERE m.veterinario_id=:vet.veterinario_id").getResultList();
	}

}
