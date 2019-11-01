package eventos;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.hibernate.type.descriptor.java.LocalDateJavaDescriptor;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import clasesDAO.ConfigFichaDAO;
import clasesDAO.DuenoDAO;
import clasesDAO.EventoDAO;
import clasesDAO.MascotaDAO;
import factory.FactoryDAO;
import model.ConfigFicha;
import model.Desparasitacion;
import model.Dueno;
import model.Evento;
import model.Mascota;

public class EventoTest {

	private static Evento evento;
	private static Evento evento2;
	private static Mascota mascota;
	private static ConfigFicha config;
	private static Dueno due;
	private static MascotaDAO mascotajpa = FactoryDAO.getMascotaDAO();
	private static EventoDAO eventojpa = FactoryDAO.getEventoDAO();
	private static DuenoDAO duenojpa = FactoryDAO.getDuenoDAO();
	private static ConfigFichaDAO fichajpa = FactoryDAO.getConfigFichaDAO();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		config = new ConfigFicha(false, false, false, false, false, false, false, false, false, false);
		mascota = new Mascota("fufi", "perro", "caniche", "masculino", "blanco", "ninguna",
				null, null, config);
		evento = new Desparasitacion(LocalDate.of(2000, 6, 7), mascota, "droga", "bien");
		evento2 = new Desparasitacion(LocalDate.of(2004, 6, 7), mascota, "droga", "bien");
		due = new Dueno("pepe", "mujica", "elPepe@gmail.com", "1234", 22155620);
		fichajpa.save(config);
		mascota.setDueno(due);
		duenojpa.save(due);
		eventojpa.save(evento);
		eventojpa.save(evento2);
	}


	@Test
	public void test() {
		LocalDate da = LocalDate.of(2000, 2, 2);
		Evento ev = eventojpa.getAll().get(0);
		System.out.println(ev.getFecha());
		List<Evento> prueba =(List<Evento>) eventojpa.getByDate(da);
		assertEquals(2, prueba.size());
	}

}
