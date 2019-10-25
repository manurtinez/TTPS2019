package clasesDAOjpa;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import clasesDAO.MascotaDAO;
import entityManager.MiEntityManager;
import model.Mascota;

public class MascotaDAOjpa implements MascotaDAO {

	EntityManager em = MiEntityManager.getManager();
	
	@Override
	public Optional<Mascota> getById(int id) {
		return Optional.ofNullable(em.find(Mascota.class, id));
	}

	@Override
	public List<Mascota> getAll() {
		Query query = em.createQuery("SELECT * FROM mascota");
		return (List<Mascota>)query.getResultList();
	}

	@Override
	public void save(Mascota m) {
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
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		em.remove(m);
		etx.commit();
	}

	@Override
	public List<Mascota> getByDueno_id(int id) {
		return (List<Mascota>) em.createQuery("SELECT m FROM mascota m WHERE m.dueno_id=:id").getResultList();
	}

	@Override
	public List<Mascota> getByVet(int id) {
		return (List<Mascota>) em.createQuery("SELECT m FROM mascota m WHERE m.veterinario_id=:id").getResultList();
	}
	
}
