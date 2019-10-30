package entityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MiEntityManager {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("historia_clinica_mascotas");

	public static EntityManagerFactory getEmf() {
		return emf;
	}
}