package ttps.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.DAO.MascotaDAO;
import ttps.spring.model.Mascota;



@Service
public class MascotaService {
	@Autowired
	private MascotaDAO mascotaDAO;
	
	public boolean altaMascota(Mascota mascota){
		
		return true;
	}

}
