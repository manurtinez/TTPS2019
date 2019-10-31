package clasesDAOjpa;

import javax.persistence.EntityManager;
import clasesDAO.ConfigFichaDAO;
import model.ConfigFicha;

public class ConfigFichaDAOjpa extends GenericDAOjpa<ConfigFicha>
implements ConfigFichaDAO {

	public ConfigFichaDAOjpa() {
		super(ConfigFicha.class);
	}

}
