package clasesDAOjpa;

import java.sql.Date;
import java.util.List;

import clasesDAO.EventoDAO;
import model.Evento;

public class EventoDAOjpa extends GenericDAOjpa<Evento>
implements EventoDAO {
	
	public EventoDAOjpa() {
		super(Evento.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Evento> getByDate(Date d) {
		// TODO Auto-generated method stub
		return null;
	}
}
