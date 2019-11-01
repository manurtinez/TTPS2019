package tests;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import clasesDAOjpa.DuenoDAOjpa;
import clasesDAOjpa.MascotaDAOjpa;
import factory.FactoryDAO;
import model.Desparasitacion;
import model.Dueno;
import model.Evento;
import model.Mascota;

public class TestMascota {
	
	Mascota m = new Mascota("fufi", "perro", "caniche", "masculino", "blanco", "ninguna"
			, Calendar.getInstance().getTime() , new BufferedImage[2]);

	
	Mascota m2 = new Mascota("fufi", "perro", "caniche", "masculino", "blanco", "ninguna",
		Calendar.getInstance().getTime(), new BufferedImage[2]);
	
	Dueno du = new Dueno("seba", "pose", "hola@gmail.com", "1234", 1234);
	
	Desparasitacion d = new Desparasitacion(LocalDate.now(), m, "cualquiera", "todo bien");
	
	
	MascotaDAOjpa mascotajpa = FactoryDAO.getMascotaDAO();
	DuenoDAOjpa duenojpa = FactoryDAO.getDuenoDAO();
	
	@Before
	public void setUp() throws Exception {
		m.setDueno(du);
		duenojpa.save(du);
		mascotajpa.save(m);
	}

	@Test
	public void test() {
		/*List<Mascota> lista = mascotajpa.getAll();
		Assert.assertEquals(0, lista.size());
		mascotajpa.save(m);
		Assert.assertEquals(1, lista.size());
		mascotajpa.delete(m);
		Assert.assertEquals(0, lista.size());*/
	}

}
