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
	private DuenoDAO duenodao;
	
	@Autowired
	public MascotaService(MascotaDAO mascotaDAO, DuenoDAO duenodao, ConfigFichaDAO configdao) {
		super();
		this.mascotaDAO = mascotaDAO;
		this.duenodao = duenodao;
	}
	public MascotaService() {}
	
	public boolean altaMascota(MascotaDTO mascota, int id){
		try {
			Dueno dueno = duenodao.getById(id);
			Mascota mascotaSave = new Mascota(mascota.getNombre(), mascota.getEspecie(), mascota.getRaza()
					, mascota.getSexo(), mascota.getColor(), mascota.getSenas(), mascota.getNacimiento()
					, mascota.getFotos(), dueno, mascota.getConfigFicha());
			mascotaDAO.save(mascotaSave);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
}
