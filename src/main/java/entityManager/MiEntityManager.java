package entityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MiEntityManager {
	private static EntityManager manager = null;
	
	private static EntityManagerFactory emf = null;
	
	static {
		MiEntityManager.emf = Persistence.createEntityManagerFactory("historia_clinica_mascotas");
		MiEntityManager.setManager(emf.createEntityManager());
	}
	
	public static EntityManager getManager() {
		return manager;
	}
	
	private static void setManager(EntityManager manager) {
		MiEntityManager.manager = manager;
	}
}
