package clasesDAOjpa;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import clasesDAO.MascotaDAO;
import entityManager.MiEntityManager;
import model.Mascota;
import model.Usuario;

public class MascotaDAOjpa implements MascotaDAO {

	EntityManagerFactory emf = MiEntityManager.getEmf();
	
	@Override
	public Mascota getById(int id) {
		EntityManager em = emf.createEntityManager();
		Mascota mascota = em.find(Mascota.class, id);
        return mascota;
	}

	@Override
	public List<Mascota> getAll() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT * FROM mascota");
		return (List<Mascota>)query.getResultList();
	}

	@Override
	public void save(Mascota m) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		em.persist(m);
		etx.commit();
	}

	@Override
	public void update(Mascota t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Mascota m) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		em.remove(m);
		etx.commit();
	}

	@Override
	public List<Mascota> getByDueno_id(int id) {
		EntityManager em = emf.createEntityManager();
		return (List<Mascota>) em.createQuery("SELECT m FROM mascota m WHERE m.dueno_id=:id").getResultList();
	}

	@Override
	public List<Mascota> getByVet(int id) {
		EntityManager em = emf.createEntityManager();
		return (List<Mascota>) em.createQuery("SELECT m FROM mascota m WHERE m.veterinario_id=:id").getResultList();
	}
	
}
