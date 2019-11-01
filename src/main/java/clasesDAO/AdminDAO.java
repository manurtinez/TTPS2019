package clasesDAO;

import model.Admin;
import model.Veterinario;
import java.util.List;

public interface AdminDAO extends Dao<Admin>{
	public List<Veterinario> getAllVeterinarioInhabilitados();
}
