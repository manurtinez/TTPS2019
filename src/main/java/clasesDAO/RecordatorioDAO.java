package clasesDAO;

import java.util.List;

import model.Recordatorio;

public interface RecordatorioDAO extends Dao<Recordatorio>{
	public List<Recordatorio> getAllByUsuarioId(int id);
}
