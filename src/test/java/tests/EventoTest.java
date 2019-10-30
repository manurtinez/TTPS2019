package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
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
import model.Mascota;

public class EventoTest {
	
	private static Mascota mascota;
	private static ConfigFicha config;
	private static Dueno duenoMascota;
	private static MascotaDAOjpa mascotaJPA = FactoryDAO.getMascotaDAO();
	private static DuenoDAOjpa duenoJPA = FactoryDAO.getDuenoDAO();
	private static ConfigFichaDAOjpa configFichaJPA = FactoryDAO.getConfigFichaDAO();
	private static EventoDAOjpa EventoJPA = FactoryDAO.getEventoDAO();
	
	@BeforeClass
	public static void beforeClass() {
		config = new ConfigFicha(false, false, false, false, false, false, false, false, false, false); 
		duenoMascota = new Dueno("seba", "pose", "seba@gmail.com", "1234", 22155620);	
		mascota = new Mascota("fufi", "perro", "caniche", "masculino", "blanco", "ninguna", null , null, duenoMascota, config);
		duenoJPA.save(duenoMascota);
		configFichaJPA.save(config);
		mascotaJPA.save(mascota);
	}
	@Before
	public void beforeDesparacitacionTest() {
		Desparasitacion eventoD = new Desparasitacion(new Date(), mascota, "fenbendazol", "positivo");
		EventoJPA.save(eventoD);
		mascota.agregarEvento(eventoD);		
		mascotaJPA.update(mascota);
	}
	
	@Test
	public void test() {
		ArrayList<Mascota> mascotas = (ArrayList<Mascota>) mascotaJPA.getAll();
		assertEquals(1,mascotas.size());
		assertEquals(1, mascotas.get(0).getHistorial().size());
	}

}
