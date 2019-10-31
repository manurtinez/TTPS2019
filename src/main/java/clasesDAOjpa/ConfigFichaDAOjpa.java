package clasesDAOjpa;

import javax.persistence.EntityManager;
import clasesDAO.ConfigFichaDAO;
import model.ConfigFicha;

public class ConfigFichaDAOjpa extends GenericDAOjpa<ConfigFicha>
implements ConfigFichaDAO {

	public ConfigFichaDAOjpa() {
		super(ConfigFicha.class);
	}

	@Override
	public ConfigFicha getById(int id) {
		EntityManager em = emf.createEntityManager();
		return (ConfigFicha) em.createQuery("FROM ConfigFicha cf WHERE cf.id = :id");
	}
	
}
