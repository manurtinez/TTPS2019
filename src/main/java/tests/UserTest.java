package tests;

import java.util.List;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Admin;
import model.Dueno;
import model.Usuario;
import model.Veterinario;

public class UserTest {

	public static void main(String[] args) {
		//UsuarioDAOjpa u = new UsuarioDAOjpa();
		//u.save(new Usuario("hola", "chau", "hola@gmail.com", "1234", 1234));
		//System.out.println(u.getAll());
		Usuario u = new Usuario("eva", "peron", "evap@gmail.com", "1234", 1234);
		Veterinario v = new Veterinario("america", "latina", "america@gmail.com", "1234", 1234);
		Admin a = new Admin("alberto", "cristina", "hola@gmail.com", "1234", 1234);
		Dueno d = new Dueno("seba", "pose", "hola@gmail.com", "1234", 1234);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("historia_clinica_mascotas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(u);
		em.persist(v);
		em.persist(a);
		em.persist(d);
		
		em.getTransaction().commit();
		List<Veterinario> vet = em.createQuery("From Usuario").getResultList();
		
		System.out.println(vet);
		em.close();
	}
	
	/*private static Usuario getUser(int id) {
		Usuario user = UsuarioDAOjpa.getByID(id);
		return user;
	}*/
	
	

}
