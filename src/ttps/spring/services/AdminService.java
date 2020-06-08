package ttps.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.DAO.AdminDAO;
import ttps.spring.DAO.VeterinarioDAO;
import ttps.spring.DTO.VeterinarioDTO;
import ttps.spring.model.Veterinario;

@Service
public class AdminService {
	
	@Autowired
	private AdminDAO adminDAO;
	
	@Autowired
	private VeterinarioDAO vetDAO;
	
	public List<VeterinarioDTO> getAllVeterinariosInhabilitados() {
		try {
			List<VeterinarioDTO> listaDTO = new ArrayList<VeterinarioDTO>();
			
			List<Veterinario> listaModel = adminDAO.getAllVeterinarioInhabilitados();
			for (Veterinario vet : listaModel) {
				VeterinarioDTO vetDTO = new VeterinarioDTO(vet.getId(), vet.getNombre(), vet.getApellido(), vet.getEmail(), 
						vet.getPassword(), vet.getTelefono(), vet.getNomClinica(),vet.getDirClinica(), vet.getNroMatricula(), vet.isHabilitado() ? 1 : 0);
				listaDTO.add(vetDTO);				
			}
			
			return listaDTO;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public boolean habilitarVeterinario (int id) {
		try {
			System.out.println(id);
			Veterinario vet = vetDAO.getById(id);
			if (adminDAO.habilitarVeterinario(vet) != null) {
				return true;
			}
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}
