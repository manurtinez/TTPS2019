package clasesDAO;

import model.Dueno;

public interface DuenoDAO extends Dao<Dueno> {
	public Dueno getByName(String name);
}
