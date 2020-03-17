package ttps.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.DAO.UsuarioDAO;
import ttps.spring.DAO.VeterinarioDAO;
import ttps.spring.DTO.VeterinarioDTO;
import ttps.spring.model.Usuario;
import ttps.spring.model.Veterinario;

@Service
public class VeterinarioService {
	@Autowired
	private UsuarioDAO usuariodao;
	@Autowired
	private VeterinarioDAO vetdao;
	
	public boolean existeVet(String email) {
		Usuario u = usuariodao.getByEmail(email);
		return (u != null);
	}

	public boolean crearVet(VeterinarioDTO vet) {
		try {
			Veterinario v = new Veterinario(vet.getNombre(), vet.getApellido(), vet.getEmail(), vet.getPassword(),  vet.getTelefono(), vet.getNomClinica(), vet.getDirClinica(), vet.getNroMatricula());
			vetdao.save(v);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<VeterinarioDTO> todosLosVeterinarios() {
		try {
			List<Veterinario> list = vetdao.getAll();
			List<VeterinarioDTO> listDTO = new ArrayList<>();
			for (Veterinario veterinario : list) {
				VeterinarioDTO vetDTO = new VeterinarioDTO(veterinario.getNombre(), veterinario.getApellido(), veterinario.getEmail(),
										null, veterinario.getTelefono(), veterinario.getNomClinica(), veterinario.getDirClinica(),
										veterinario.getNroMatricula());
				listDTO.add(vetDTO);
			}
			return listDTO;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
