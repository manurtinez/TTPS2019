package usuario;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import clasesDAOjpa.ConfigFichaDAOjpa;
import clasesDAOjpa.DuenoDAOjpa;
import clasesDAOjpa.EventoDAOjpa;
import clasesDAOjpa.MascotaDAOjpa;
import clasesDAOjpa.VeterinarioDAOjpa;
import factory.FactoryDAO;
import model.ConfigFicha;
import model.Dueno;
import model.Mascota;
import model.Veterinario;
import model.Visita;

public class VeterinarioTest {
	
	private static Mascota mas;
	private static Mascota mas2;
	private static ConfigFicha config;
	private static Dueno due;
	private static Veterinario vet;
	private static Visita evento;
	private static MascotaDAOjpa mascotajpa = FactoryDAO.getMascotaDAO();
	private static VeterinarioDAOjpa veterinariojpa = FactoryDAO.getVeterinarioDAO();
	private static EventoDAOjpa eventojpa = FactoryDAO.getEventoDAO();
	private static DuenoDAOjpa duenojpa = FactoryDAO.getDuenoDAO();
	private static ConfigFichaDAOjpa fichajpa = FactoryDAO.getConfigFichaDAO();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		config = new ConfigFicha(false, false, false, false, false, false, false, false, false, false);
		vet = new Veterinario("manu", "martinez", "manu@gmail.com", "1234", 4456677,
				"mascotas Manu", "calle 1 678", 442312345);
		due = new Dueno("pepe", "mujica", "elPepe@gmail.com", "1234", 22155620);
		mas = new Mascota("fufi", "perro", "caniche", "masculino", "blanco", "ninguna",
				null, null, due, config);
		mas2 = new Mascota("fufi2", "perro", "chihuahua", "femenino", "negro", "ninguna",
				null, null, due, config);
		evento = new Visita(LocalDate.now(), mas, 22.2f , "se escapa seguido", "no sabe volver",
				"usar correa");
		mas.setVeterinario(vet);
		mas2.setVeterinario(vet);
		duenojpa.save(due);
		fichajpa.save(config);
		/*mascotajpa.save(mas);
		mascotajpa.save(mas2);*/
		veterinariojpa.save(vet);
		eventojpa.save(evento);
	}

	@Test
	public void test() {
		ArrayList<Mascota> mascotas;
		
		mascotas = (ArrayList<Mascota>) mascotajpa.getAll();
		assertEquals(2,mascotas.size());
		Mascota mas = mascotas.get(0);
		assertEquals(1, mas.getHistorial().size());
		Visita e1 = (Visita) mas.getHistorial().get(0);
		assertTrue(e1.equals(evento));
		
		assertEquals(1, veterinariojpa.getAll().size());
		//ArrayList<Veterinario> vets = (ArrayList<Veterinario>) veterinariojpa.getAll();
		Veterinario veterinario = veterinariojpa.getById(vet.getId());
		assertEquals(2, veterinario.getMascotas().size());
		List<Mascota> mascotasdeVet = (List<Mascota>) veterinario.getMascotas();
		assertEquals("chihuahua", mascotasdeVet.get(1).getRaza());
		mas2.setRaza("chihuahue�o");
		mascotajpa.update(mas2);
		mascotasdeVet = veterinariojpa.getById(veterinario.getId()).getMascotas();
		assertEquals("chihuahue�o", mascotasdeVet.get(1).getRaza());
	}
	@AfterClass
	public static void AfterClass() {
		mas.borrarEvento(evento);
		eventojpa.delete(evento);
		mascotajpa.delete(mas);
		mascotajpa.delete(mas2);
		fichajpa.delete(config);
		veterinariojpa.delete(vet);
		duenojpa.delete(due);
	}

}
