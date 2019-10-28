package test;

import clasesDAOjpa.UsuarioDAOjpa;
import model.Usuario;

public class UserTest {

	public static void main(String[] args) {
		UsuarioDAOjpa u = new UsuarioDAOjpa();
		u.save(new Usuario("hola", "chau", "hola@gmail.com", "1234", 1234));
		System.out.println(u.getAll());
	}
	
	/*private static Usuario getUser(int id) {
		Usuario user = UsuarioDAOjpa.getByID(id);
		return user;
	}*/
	
	

}
