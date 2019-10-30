package factory;

import clasesDAOjpa.DuenoDAOjpa;
import clasesDAOjpa.MascotaDAOjpa;

public class FactoryDAO {
	public static DuenoDAOjpa getDuenoDAO(){
		return new DuenoDAOjpa();
	}

	public static MascotaDAOjpa getMascotaDAO() {
		return new MascotaDAOjpa();
	}
}
