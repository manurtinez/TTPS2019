package usuario;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import clasesDAO.AdminDAO;
import clasesDAO.VeterinarioDAO;
import factory.FactoryDAO;
import model.Admin;
import model.Veterinario;

public class AdminTest {
	private static Admin admin;
	private static AdminDAO adminD = FactoryDAO.getAdminDAO();
	private static Veterinario vet1;
	private static Veterinario vet2;
	private static VeterinarioDAO vetD = FactoryDAO.getVeterinarioDAO();
	
	@BeforeClass
	public static void before() {
		admin = new Admin("root", "root", "admin@root.com", "asd", 232312);
		vet1 = new Veterinario("juan", "martinez", "juan@gmail.com", "asd", 234, null, null, 2345);
		vet2 = new Veterinario("carla", "campos", "carla@gmail.com", "asd", 234, null, null, 2345);
		vetD.save(vet1);
		vetD.save(vet2);
		adminD.save(admin);
	}
	
	@Test
	public void test() {
		ArrayList<Admin> admins = (ArrayList<Admin>) adminD.getAll();
		assertEquals(1, admins.size());
		ArrayList<Veterinario> veterinarios =(ArrayList<Veterinario>) adminD.getAllVeterinarioInhabilitados();
		assertEquals(2, veterinarios.size());
		
		Admin adminTest = admins.get(0);
		Veterinario vett = veterinarios.get(0);
		adminTest.habilitarVeterinario(vett);
		vetD.update(vett);
		veterinarios =(ArrayList<Veterinario>) adminD.getAllVeterinarioInhabilitados();
		assertEquals(1, veterinarios.size());
		
	}
	@AfterClass
	public static void AfterClass() {
		ArrayList<Veterinario> veterinariosBorrado =(ArrayList<Veterinario>) vetD.getAll();
		vetD.delete(veterinariosBorrado.get(0));
		vetD.delete(veterinariosBorrado.get(1));
		adminD.delete(adminD.getAll().get(0));
	}

}
