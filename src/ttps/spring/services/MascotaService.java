package ttps.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ttps.spring.DAO.DuenoDAO;
import ttps.spring.DAO.MascotaDAO;
import ttps.spring.DTO.DuenoDTO;
import ttps.spring.DTO.MascotaConDueno;
import ttps.spring.DTO.MascotaDTO;
import ttps.spring.model.Dueno;
import ttps.spring.model.Mascota;

@Service
public class MascotaService {
	
	private MascotaDAO mascotaDAO;
	private DuenoDAO duenoDAO;
	
	@Autowired
	public MascotaService(MascotaDAO mascotaDAO, DuenoDAO duenoDAO) {
		super();
		this.mascotaDAO = mascotaDAO;
		this.duenoDAO = duenoDAO;
	}
	public MascotaService() {}
	
	public boolean altaMascota(MascotaDTO mascota, int id){
		try {
			Dueno dueno = duenoDAO.getById(id);
			Mascota mascotaSave = new Mascota(mascota.getNombre(), mascota.getEspecie(), mascota.getRaza()
					, mascota.getSexo(), mascota.getColor(), mascota.getSenas(), mascota.getNacimiento()
					, mascota.getFotos(), dueno, mascota.getConfigFicha());
			mascotaDAO.save(mascotaSave);
			return true;
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean borrarMascota(int MascotaId, int duenoId) {
		try {
			Mascota mascota = mascotaDAO.getById(MascotaId);
			Dueno dueno = duenoDAO.getById(duenoId);
			dueno.borrarrMascota(mascota);
			duenoDAO.update(dueno);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public List<Mascota> ultimasMascotas(){
		return mascotaDAO.ultimasMascotas();
	}
	
	public boolean editarMascota(MascotaDTO mascota, int id) {
		try {
			Mascota mascotaEditar = mascotaDAO.getById(id);
			
			mascotaEditar.setColor(mascota.getColor());
			mascotaEditar.setConfigFicha(mascota.getConfigFicha());
			mascotaEditar.setEspecie(mascota.getEspecie());
			mascotaEditar.setFotos(mascota.getFotos());
			mascotaEditar.setNombre(mascota.getNombre());
			mascotaEditar.setRaza(mascota.getRaza());
			mascotaEditar.setSexo(mascota.getSexo());
			mascotaEditar.setSenas(mascota.getSenas());
			mascotaEditar.setNacimiento(mascota.getNacimiento());
			
			mascotaDAO.update(mascotaEditar);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public MascotaDTO unaMascota (int id) {
		try {
			Mascota mascota = mascotaDAO.getById(id);
			MascotaDTO mascotaDTO = new MascotaDTO();
			
			mascotaDTO.setColor(mascota.getColor());
			mascotaDTO.setConfigFichaId(mascota.getConfigFicha());
			mascotaDTO.setEspecie(mascota.getEspecie());
			mascotaDTO.setFotos(mascota.getFotos());
			mascotaDTO.setNombre(mascota.getNombre());
			mascotaDTO.setRaza(mascota.getRaza());
			mascotaDTO.setSexo(mascota.getSexo());
			mascotaDTO.setSenas(mascota.getSenas());
			mascotaDTO.setNacimiento(mascota.getNacimiento());
			
			return mascotaDTO;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	public MascotaConDueno unaMascotaConDueno(int mascotaId) {
		try {
			Mascota mascota = mascotaDAO.getById(mascotaId);
			MascotaConDueno mascotaConDueno = new MascotaConDueno();
			DuenoDTO duenoDTO = new DuenoDTO();
			
			duenoDTO.setApellido(mascota.getDueno().getApellido());
			duenoDTO.setEmail(mascota.getDueno().getEmail());
			duenoDTO.setNombre(mascota.getDueno().getNombre());
			duenoDTO.setTelefono(mascota.getDueno().getTelefono());;
			
			mascotaConDueno.setDueno(duenoDTO);
			mascotaConDueno.setColor(mascota.getColor());
			mascotaConDueno.setConfigFichaId(mascota.getConfigFicha());
			mascotaConDueno.setEspecie(mascota.getEspecie());
			mascotaConDueno.setFotos(mascota.getFotos());
			mascotaConDueno.setNombre(mascota.getNombre());
			mascotaConDueno.setRaza(mascota.getRaza());
			mascotaConDueno.setSexo(mascota.getSexo());
			mascotaConDueno.setSenas(mascota.getSenas());
			mascotaConDueno.setNacimiento(mascota.getNacimiento());
			
			return mascotaConDueno;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	
}
