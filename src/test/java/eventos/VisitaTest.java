package eventos;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import clasesDAOjpa.ConfigFichaDAOjpa;
import clasesDAOjpa.DuenoDAOjpa;
import clasesDAOjpa.EventoDAOjpa;
import clasesDAOjpa.MascotaDAOjpa;
import factory.FactoryDAO;
import model.ConfigFicha;
import model.Dueno;
import model.Mascota;
import model.Visita;

public class VisitaTest {
	private static Mascota mascota;
	private static ConfigFicha config;
	private static Dueno duenoMascota;
	private static Visita eventoV;
	private static MascotaDAOjpa mascotaJPA = FactoryDAO.getMascotaDAO();
	private static DuenoDAOjpa duenoJPA = FactoryDAO.getDuenoDAO();
	private static ConfigFichaDAOjpa configFichaJPA = FactoryDAO.getConfigFichaDAO();
	private static EventoDAOjpa eventoJPA = FactoryDAO.getEventoDAO();
	
	@BeforeClass
	public static void beforeClass() {
		config = new ConfigFicha(false, false, false, false, false, false, false, false, false, false); 
		duenoMascota = new Dueno("pepe", "mujica", "elPepe@gmail.com", "1234", 22155620);	
		mascota = new Mascota("taton", "perro", "pitbull", "masculino", "blanco", "ninguna", null , null, duenoMascota, config);
		eventoV = new Visita(new Date(), mascota, 22.2f , "pelea en la calle", "perdida de oreja derecha", "alejar del dueño");
		duenoJPA.save(duenoMascota);
		configFichaJPA.save(config);
		mascotaJPA.save(mascota);
		eventoJPA.save(eventoV);
		mascota.agregarEvento(eventoV);		

	}
	@Test
	public void test() {
		ArrayList<Mascota> mascotas = (ArrayList<Mascota>) mascotaJPA.getAll();
		assertEquals(1,mascotas.size());
		Mascota m1 = mascotas.get(0);
		assertEquals(1, m1.getHistorial().size());
		Visita e1 = (Visita) m1.getHistorial().get(0);
		assertTrue(e1.equals(eventoV));
		Visita e2 = new Visita(null, m1, 22.2f , "perdida de nariz", "ninguna", "ninguna");
		m1.agregarEvento(e2);
		assertEquals(2, m1.getHistorial().size());
		m1.borrarEvento(e2);		;
		assertEquals(1, m1.getHistorial().size());
		
		e1.setMotivo("sarasa");
		eventoJPA.update(e1);
		mascotas = (ArrayList<Mascota>) mascotaJPA.getAll();
		e1 = (Visita) mascotas.get(0).getHistorial().get(0);
		assertTrue(e1.getMotivo().equals("sarasa"));
		
		Visita e3 = (Visita) eventoJPA.getById(1);
		assertTrue(e3.equals(eventoV));
		
	}
	@AfterClass
	public static void AfterClass() {
		mascota.borrarEvento(eventoV);
		eventoJPA.delete(eventoV);	
		mascotaJPA.delete(mascota);	
		configFichaJPA.delete(config);
		duenoJPA.delete(duenoMascota);	    
	}
}
