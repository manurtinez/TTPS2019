package clasesDAOjpa;

import java.util.List;

import clasesDAO.DesparasitacionDAO;
import clasesDAO.DuenoDAO;
import model.Desparasitacion;
import model.Dueno;
import model.Evento;

public class DesparacitacionDAOjpa extends GenericDAOjpa<Desparasitacion>
implements DesparasitacionDAO {

	public DesparacitacionDAOjpa() {
		super(Desparasitacion.class);
	}

	@Override
	public String getDroga() {
		return null;
	}

}
