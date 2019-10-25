package test;

import clasesDAO.Dao;
import clasesDAO.UsuarioDAO;
import model.Usuario;

public class UserTest {

	private static Dao<Usuario> Usuariojpa;
	public static void main(String[] args) {
		//save(new Usuario("hola", "chau", "hola@gmail.com", "1234", 1234));
		System.out.println(Usuariojpa.getAll());
	}
	
	/*private static Usuario getUser(int id) {
		Usuario user = UsuarioDAOjpa.getByID(id);
		return user;
	}*/
	
	public static void save(Usuario u) {
		
	}

}
