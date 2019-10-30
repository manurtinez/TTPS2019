package clasesDAOjpa;

import clasesDAO.DuenoDAO;
import model.Dueno;

public class DuenoDAOjpa extends GenericDAOjpa<Dueno>
implements DuenoDAO {

	public DuenoDAOjpa() {
		super(Dueno.class);
	}
	
	public Dueno getByName(String name) {
		return new Dueno();
	}
	
}
