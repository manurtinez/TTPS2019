package clasesDAO;

import model.ConfigFicha;

public interface ConfigFichaDAO extends Dao<ConfigFicha> {
	public ConfigFicha getById(int id);

}
