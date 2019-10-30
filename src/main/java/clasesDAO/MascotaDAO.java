package clasesDAO;

import java.util.List;

import model.Evento;
import model.Mascota;

public interface MascotaDAO extends Dao<Mascota> {
	List<Mascota> getByDueno_id(int id);
	List<Mascota> getByVet(int id);
}
