package Recordatorio;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import clasesDAO.DuenoDAO;
import clasesDAO.RecordatorioDAO;
import factory.FactoryDAO;
import model.Dueno;
import model.Recordatorio;

public class RecordatorioTest {
	private static Recordatorio r1;
	private static Dueno dueno;
	private static DuenoDAO duenoJPA = FactoryDAO.getDuenoDAO();
	private static RecordatorioDAO recordatorioJPA = FactoryDAO.getRecordatorioDAO();
	
	@BeforeClass
	public static void beforeClass() {
		dueno = new Dueno("seba", "pose", "seba@gmail.com", "1234", 22155620);
		r1 = new Recordatorio("comprar alimento para America", LocalDateTime.now(),"juan no tiene dog chow, conseguir otro numero", dueno);
		duenoJPA.save(dueno);
		recordatorioJPA.save(r1);
	}
	
	@Test
	public void test() {
		ArrayList<Dueno> duenos;
		
		duenos = (ArrayList<Dueno>) duenoJPA.getAll();
		assertEquals(1, duenos.size());
		Dueno d1 = duenos.get(0);
		assertEquals(1, d1.getRecordatorios().size());
		Recordatorio r2 = d1.getRecordatorios().get(0);
		assertTrue(r2.equals(r1));
		
		Recordatorio r3 = new Recordatorio("nuevo recordatorio", LocalDateTime.now(), "descripcion del nuevo recordatorio", d1);
		recordatorioJPA.save(r3);
		d1.agregarRecordatorio(r3);
		assertEquals(2, d1.getRecordatorios().size());
		d1.borrarRecordatorio(r3);
		recordatorioJPA.delete(r3);
		assertEquals(1, d1.getRecordatorios().size());
		
		r2.setDescripcion("una descripcion nueva");
		recordatorioJPA.update(r2);
		duenos = (ArrayList<Dueno>) duenoJPA.getAll();
		Recordatorio r4 = (Recordatorio) duenos.get(0).getRecordatorios().get(0);
		assertTrue(r4.getDescripcion().equals("una descripcion nueva"));
		
		Recordatorio r5 = (Recordatorio) recordatorioJPA.getById(1);
		assertTrue(r5.equals(r1));
	}
	@AfterClass
	public static void afterClass() {
		dueno.borrarRecordatorio(r1);
		recordatorioJPA.delete(r1);
		duenoJPA.delete(dueno);
	}
}
