package usuario;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import clasesDAO.ConfigFichaDAO;
import clasesDAO.DuenoDAO;
import clasesDAO.EventoDAO;
import clasesDAO.MascotaDAO;
import clasesDAO.VeterinarioDAO;
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
	private static MascotaDAO mascotajpa = FactoryDAO.getMascotaDAO();
	private static VeterinarioDAO veterinariojpa = FactoryDAO.getVeterinarioDAO();
	private static EventoDAO eventojpa = FactoryDAO.getEventoDAO();
	private static DuenoDAO duenojpa = FactoryDAO.getDuenoDAO();
	private static ConfigFichaDAO fichajpa = FactoryDAO.getConfigFichaDAO();

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
		/*mascotajpa.save(mas);
		mascotajpa.save(mas2);*/
	}

	@Test
	public void test() {
		ArrayList<Mascota> mascotas;
		mascotas = (ArrayList<Mascota>) mascotajpa.getAll();
		assertEquals(2,mascotas.size());
		
		Mascota mas = mascotas.get(1);
		assertEquals(1, mas.getHistorial().size());
		
		assertEquals(1, veterinariojpa.getAll().size());
		//ArrayList<Veterinario> vets = (ArrayList<Veterinario>) veterinariojpa.getAll();
		Veterinario veterinario = veterinariojpa.getAll().get(0);
		assertEquals(2, veterinario.getMascotas().size());
		List<Mascota> mascotasdeVet = (List<Mascota>) veterinario.getMascotas();
		Mascota mascotita = mascotasdeVet.get(0);
		assertEquals("chihuahua", mascotita.getRaza());
		mascotita.setRaza("chihuahuenio");
		mascotajpa.update(mascotita);
		mascotasdeVet = veterinariojpa.getById(veterinario.getId()).getMascotas();
		assertEquals("chihuahuenio", mascotasdeVet.get(1).getRaza());
				
	}
	@AfterClass
	public static void AfterClass() {
		vet = veterinariojpa.getAll().get(0);
		
		Mascota masBorrado = vet.getMascotas().get(0);
		Mascota mas2Borrado = vet.getMascotas().get(1);
		masBorrado.nullVeterinario(vet);
		mas2Borrado.nullVeterinario(vet);
		mascotajpa.save(masBorrado);
		mascotajpa.save(mas2Borrado);
		
		duenojpa.delete(duenojpa.getAll().get(0));

		vet = veterinariojpa.getAll().get(0);
		veterinariojpa.delete(vet);
	}

}
