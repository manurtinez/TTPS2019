package clasesDAOjpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import clasesDAO.DuenoDAO;
import model.Dueno;

public class DuenoDAOjpa extends GenericDAOjpa<Dueno>
implements DuenoDAO {

	public DuenoDAOjpa() {
		super(Dueno.class);
	}
	
	public Dueno getByName(String name) {
		EntityManager em = emf.createEntityManager();
		return (Dueno) em.createQuery("SELECT d FROM Dueno d WHERE d.nombre=:name");
	}
	
}
