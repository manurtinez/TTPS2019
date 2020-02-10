package ttps.spring.DAOjpa;

import java.util.List;

import javax.persistence.EntityManager;

import ttps.spring.DAO.RecordatorioDAO;
import ttps.spring.model.Recordatorio;

public class RecordatorioDAOjpa extends GenericDAOjpa<Recordatorio>
implements RecordatorioDAO{

	public RecordatorioDAOjpa() {
		super(Recordatorio.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Recordatorio> getAllByUsuarioId(int id) {
		EntityManager em = getEntityManager();
		return (List<Recordatorio>) em.createQuery("FROM Recordatorio  WHERE Recordatorio.usuario_id = :id").getResultList();
	}

}
