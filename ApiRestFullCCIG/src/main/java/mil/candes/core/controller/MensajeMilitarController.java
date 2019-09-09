package mil.candes.core.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mil.candes.core.entity.MensajeMilitarEntity;
import mil.candes.core.model.MensajeMilitarModel;
import mil.candes.core.service.MensajeMilitarService;

@RestController
@RequestMapping("/v1")
public class MensajeMilitarController {

	@Autowired
	@Qualifier("mensajeMilitarService")
	MensajeMilitarService service;
	
	@PutMapping("/mm")
	public boolean agregarMensajeMilitar(@RequestBody @Valid MensajeMilitarEntity mensaje) {
		return service.crearMM(mensaje);
	}
	
	@PostMapping("/mm")
	public boolean actualizarMensajeMilitar(@RequestBody @Valid MensajeMilitarEntity mensaje) {
		return service.actualizarMM(mensaje);
	}
	
	@DeleteMapping("/mm/{id}")
		public boolean borrarMM(@PathVariable("id") long id) {
			return service.borrarMM(id);
		}
	@GetMapping("/mm")
	public List<MensajeMilitarModel> obtenerMM(){
		return service.obtenerMM();
	}
}
