package clasesDAOjpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import clasesDAO.MascotaDAO;
import entityManager.MiEntityManager;
import model.Evento;
import model.Mascota;

public class MascotaDAOjpa extends GenericDAOjpa<Mascota>
implements MascotaDAO{

	public MascotaDAOjpa() {
		super(Mascota.class);
		// TODO Auto-generated constructor stub
	}

	EntityManagerFactory emf = MiEntityManager.getEmf();

	@Override
	public List<Mascota> getByDueno_id(int id) {
		EntityManager em = emf.createEntityManager();
		return (List<Mascota>) em.createQuery("SELECT m FROM Mascota m WHERE m.dueno.id= ?1").setParameter(1, id).getResultList();
	}

	@Override
	public List<Mascota> getByVet(int id) {
		EntityManager em = emf.createEntityManager();
		return (List<Mascota>) em.createQuery("SELECT m FROM Mascota m WHERE m.veterinario.id= ?1").setParameter(1, id).getResultList();
	}

}
