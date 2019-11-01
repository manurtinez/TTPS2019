package eventos;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clasesDAOjpa.ConfigFichaDAOjpa;
import clasesDAOjpa.DuenoDAOjpa;
import clasesDAOjpa.EventoDAOjpa;
import clasesDAOjpa.MascotaDAOjpa;
import factory.FactoryDAO;
import model.ConfigFicha;
import model.Desparasitacion;
import model.Dueno;
import model.Evento;
import model.Mascota;

public class EventoTest {

	private static Evento evento;
	private static Mascota mascota;
	private static ConfigFicha config;
	private static Dueno due;
	private static MascotaDAOjpa mascotajpa = FactoryDAO.getMascotaDAO();
	private static EventoDAOjpa eventojpa = FactoryDAO.getEventoDAO();
	private static DuenoDAOjpa duenojpa = FactoryDAO.getDuenoDAO();
	private static ConfigFichaDAOjpa fichajpa = FactoryDAO.getConfigFichaDAO();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		config = new ConfigFicha(false, false, false, false, false, false, false, false, false, false);
		mascota = new Mascota("fufi", "perro", "caniche", "masculino", "blanco", "ninguna",
				null, null, config);
		evento = new Desparasitacion(new Date(100, 11, 10), mascota, "droga", "bien");
		due = new Dueno("pepe", "mujica", "elPepe@gmail.com", "1234", 22155620);
		fichajpa.save(config);
		mascota.setDueno(due);
		duenojpa.save(due);
		eventojpa.save(evento);
	}


	@Test
	public void test() {
		Date fecha = new Date(2000, 12, 1);
		int d = fecha.getYear();
		List<Evento> prueba =(List<Evento>) eventojpa.getByDate(d);
		assertEquals(1, prueba.size());
		
	}

}
