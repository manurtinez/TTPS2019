package ttps.spring.DAO;

import ttps.spring.model.Admin;
import ttps.spring.model.Veterinario;
import java.util.List;

public interface AdminDAO extends GenericDAO<Admin>{
	public List<Veterinario> getAllVeterinarioInhabilitados();
}
