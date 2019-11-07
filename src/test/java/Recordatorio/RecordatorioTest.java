package Recordatorio;

import static org.junit.Assert.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
	}
	
	@Test
	public void test() {
		ArrayList<Dueno> duenos;
		
		duenos = (ArrayList<Dueno>) duenoJPA.getAll();
		assertEquals(1, duenos.size());
		Dueno d1 = duenos.get(0);
		assertEquals(1, d1.getRecordatorios().size());
		
		Recordatorio r2= new Recordatorio("nuevo recordatorio", LocalDateTime.now(), "descripcion del nuevo recordatorio", d1);
		duenoJPA.save(d1);
		d1 = duenoJPA.getAll().get(0);
		assertEquals(2, d1.getRecordatorios().size());
		r2 = (Recordatorio) recordatorioJPA.getAll().get(0);
		d1 = duenoJPA.getAll().get(0);
		d1.borrarRecordatorio(r2);
		duenoJPA.save(d1);
		d1 = duenoJPA.getAll().get(0);
		assertEquals(1, d1.getRecordatorios().size());
		
		r2 = (Recordatorio)recordatorioJPA.getAll().get(0);
		r2.setDescripcion("una descripcion nueva");
		recordatorioJPA.update(r2);
		Recordatorio r4 = (Recordatorio)recordatorioJPA.getAll().get(0);
		assertTrue(r4.getDescripcion().equals(r2.getDescripcion()));
	}
	@AfterClass
	public static void afterClass() {
		Dueno duenoDel = duenoJPA.getAll().get(0);
		duenoJPA.delete(duenoDel);
	}
}
