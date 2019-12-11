package ttps.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.DAO.DuenoDAO;
import ttps.spring.DAO.UsuarioDAO;
import ttps.spring.DTO.DuenoDTO;
import ttps.spring.model.Dueno;
import ttps.spring.model.Mascota;
import ttps.spring.model.Usuario;

@Service
public class DuenoService {
	
	@Autowired
	private DuenoDAO duenoDAO;
	
	@Autowired
	private UsuarioDAO usuariodao;
	
	public List<Dueno> getAll() {
		return duenoDAO.getAll();
	}
	
	public List<Mascota> getAllMascotas(int id) {
		return duenoDAO.getAllMascotas(id);
	}
	
	public boolean existeDueno(String email) {
		Usuario u = usuariodao.getByEmail(email);
		return (u != null);
	}

	public boolean crearDueno(DuenoDTO dueno) {
		try {
			Dueno d = new Dueno(dueno.getNombre(), dueno.getApellido(), dueno.getEmail(), dueno.getPassword(), dueno.getTelefono());
			duenoDAO.save(d);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
}
