package clasesDAOjpa;

import java.util.List;

import javax.persistence.EntityManager;

import clasesDAO.RecordatorioDAO;
import model.Recordatorio;

public class RecordatorioDAOjpa extends GenericDAOjpa<Recordatorio>
implements RecordatorioDAO{

	public RecordatorioDAOjpa() {
		super(Recordatorio.class);
	}

	@Override
	public List<Recordatorio> getAllByUsuarioId(int id) {
		EntityManager em = emf.createEntityManager();
		return (List<Recordatorio>) em.createQuery("FROM Recordatorio  WHERE Recordatorio.usuario_id = :id").getResultList();
	}

}
