package factory;

import clasesDAOjpa.AdminDAOjpa;
import clasesDAOjpa.ConfigFichaDAOjpa;
import clasesDAOjpa.DuenoDAOjpa;
import clasesDAOjpa.EventoDAOjpa;
import clasesDAOjpa.MascotaDAOjpa;
import clasesDAOjpa.RecordatorioDAOjpa;
import clasesDAOjpa.VeterinarioDAOjpa;

public class FactoryDAO {
	public static DuenoDAOjpa getDuenoDAO(){
		return new DuenoDAOjpa();
	}

	public static MascotaDAOjpa getMascotaDAO() {
		return new MascotaDAOjpa();
	}
	
	public static EventoDAOjpa getEventoDAO() {
		return new EventoDAOjpa();
	}
	public static ConfigFichaDAOjpa getConfigFichaDAO() {
		return new ConfigFichaDAOjpa();
	}
	public static RecordatorioDAOjpa getRecordatorioDAO() {
		return new RecordatorioDAOjpa();
	}
	public static VeterinarioDAOjpa getVeterinarioDAO() {
		return new VeterinarioDAOjpa();
	}
	public static AdminDAOjpa getAdminDAO() {
		return new AdminDAOjpa();
	}
}
