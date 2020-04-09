package ttps.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.DTO.IdRequest;
import ttps.spring.DTO.StringResponse;
import ttps.spring.DTO.VeterinarioDTO;
import ttps.spring.services.AdminService;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class AdminController {
	
	@Autowired
	private AdminService adminservice;
	
	@GetMapping("/admin/veterinarios")
	public ResponseEntity<List<VeterinarioDTO>> getAllVeterinarios () {
		List<VeterinarioDTO> lista = adminservice.getAllVeterinariosInhabilitados();
		if(lista.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<VeterinarioDTO>>(lista, HttpStatus.OK);
	}
	
	@PostMapping("/admin/habilitarVeterinario")
	public ResponseEntity<List<VeterinarioDTO>> habilitarVeterinario (@RequestBody IdRequest id ) {
		if(adminservice.habilitarVeterinario(id.getId())) {
			List<VeterinarioDTO> lista = adminservice.getAllVeterinariosInhabilitados();
			if(lista.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<VeterinarioDTO>>(lista, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}
}
