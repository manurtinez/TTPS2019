package ttps.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ttps.spring.DAO.ConfigFichaDAO;
import ttps.spring.DAO.DuenoDAO;
import ttps.spring.DAO.MascotaDAO;
import ttps.spring.DTO.MascotaDTO;
import ttps.spring.model.Dueno;
import ttps.spring.model.Mascota;

@Service
public class MascotaService {
	
	private MascotaDAO mascotaDAO;
	private DuenoDAO duenoDAO;
	
	@Autowired
	public MascotaService(MascotaDAO mascotaDAO, DuenoDAO duenodao, ConfigFichaDAO configdao) {
		super();
		this.mascotaDAO = mascotaDAO;
		this.duenoDAO = duenodao;
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
}
