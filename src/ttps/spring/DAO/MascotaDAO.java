package ttps.spring.DAO;

import java.util.List;
import ttps.spring.model.Mascota;

public interface MascotaDAO extends GenericDAO<Mascota> {
	List<Mascota> getByDuenoId(int id);
	List<Mascota> getByVet(int id);
	List<Mascota> ultimasMascotas();
}
