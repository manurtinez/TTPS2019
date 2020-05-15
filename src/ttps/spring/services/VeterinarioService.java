package ttps.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ttps.spring.DAO.MascotaDAO;
import ttps.spring.DAO.UsuarioDAO;
import ttps.spring.DAO.VeterinarioDAO;
import ttps.spring.DTO.DuenoDTO;
import ttps.spring.DTO.MascotaConDueno;
import ttps.spring.DTO.VeterinarioDTO;
import ttps.spring.model.Mascota;
import ttps.spring.model.Usuario;
import ttps.spring.model.Veterinario;

@Service
public class VeterinarioService {
	@Autowired
	private UsuarioDAO usuariodao;
	@Autowired
	private VeterinarioDAO vetdao;
	@Autowired
	private MascotaDAO mascotadao;
	
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
				VeterinarioDTO vetDTO = new VeterinarioDTO(veterinario.getId(), veterinario.getNombre(), veterinario.getApellido(), veterinario.getEmail(),
										null, veterinario.getTelefono(), veterinario.getNomClinica(), veterinario.getDirClinica(),
										veterinario.getNroMatricula(), veterinario.isHabilitado() ? 1 : 0);
				listDTO.add(vetDTO);
			}
			return listDTO;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
//	public int buscarHabilitado(int id) {
//		try {
//			List<Veterinario> list = vetdao.getAll();
//			System.out.println(list.toString());
//			for (Veterinario v : list) {
//				if (v.getId() == id) {
//					return v.isHabilitado() ? 1 : 0;
//				}
//			}
//			return 0;
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//			return -1;
//		}
//	}
	
	public List<MascotaConDueno> getAllMascotasDeVeterinarioPendientes(int vetId) {
		try {
			List<Mascota> list = vetdao.getMascotas(vetId);
			List<MascotaConDueno> listaResultado = new ArrayList<>();
			for (Mascota mascota : list) {
				if (! mascota.isVetStatus()) {
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
					listaResultado.add(mascotaConDueno);
				}
			}
			return listaResultado;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<MascotaConDueno> getAllMascotasDeVeterinario(int vetId) {
		try {
			List<Mascota> list = vetdao.getMascotas(vetId);
			List<MascotaConDueno> listaResultado = new ArrayList<>();
			for (Mascota mascota : list) {
				if (mascota.isVetStatus()) {
					MascotaConDueno mascotaConDueno = new MascotaConDueno();
					DuenoDTO duenoDTO = new DuenoDTO();
					
					duenoDTO.setApellido(mascota.getDueno().getApellido());
					duenoDTO.setEmail(mascota.getDueno().getEmail());
					duenoDTO.setNombre(mascota.getDueno().getNombre());
					duenoDTO.setTelefono(mascota.getDueno().getTelefono());;
					
					mascotaConDueno.setId(mascota.getId());
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
					listaResultado.add(mascotaConDueno);
				}
			}
			return listaResultado;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean aceptarMascota(int mascotaId) {
		try {
			Mascota mascota = mascotadao.getById(mascotaId);
			mascota.aceptarMascota();
			mascotadao.update(mascota);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean rechazarMascota(int mascotaId) {
		try {
			Mascota mascota = mascotadao.getById(mascotaId);
			mascota.cancelarMascota();
			mascotadao.update(mascota);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
