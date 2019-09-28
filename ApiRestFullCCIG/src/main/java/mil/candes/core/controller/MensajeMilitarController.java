package mil.candes.core.controller;

import java.util.List;
import javax.validation.Valid;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mil.candes.core.configuration.Routes;
import mil.candes.core.entity.MensajeMilitarEntity;
import mil.candes.core.model.DestinoModel;
import mil.candes.core.model.MensajeMilitarModel;
import mil.candes.core.model.PrecedenciaModel;
import mil.candes.core.model.PromotorModel;
import mil.candes.core.model.SeguridadModel;
import mil.candes.core.service.MensajeMilitarService;

@RestController
//@RequestMapping(Pages.rootRoute)
@RequestMapping(Routes.api)
public class MensajeMilitarController {

	@Autowired
	@Qualifier("mensajeMilitarService")
	MensajeMilitarService service;

	@PutMapping(path = "/mm")
	public boolean agregarMensajeMilitar(@RequestBody @Valid MensajeMilitarEntity mensaje) {
		return service.crearMM(mensaje);
	}

	@PostMapping(path = Routes.guardarMM)
	public ResponseEntity<String> guardarMM(@RequestBody String mmil) {
		boolean guardado;
		try {

			JSONParser parser = new JSONParser();
			JSONObject jsonObect = (JSONObject) parser.parse(mmil);
			MensajeMilitarEntity mensajeEntity = service.convertirModelAEntity(service.convertirJsonAMensaje(jsonObect));
			guardado = service.crearMM(mensajeEntity);
			
			if(guardado) {
				ResponseEntity<String> response = new ResponseEntity<String>("MM guardado con éxito", HttpStatus.CREATED);
				return response;
				
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ResponseEntity<String> response = new ResponseEntity<String>("Algo salió mal", HttpStatus.NOT_MODIFIED);
		return response;
		
	}

	@PostMapping(path = "/mm")
	public boolean actualizarMensajeMilitar(@RequestBody @Valid MensajeMilitarEntity mensaje) {
		return service.actualizarMM(mensaje);
	}

	@DeleteMapping(path = "/mm/{id}")
	public boolean borrarMM(@PathVariable("id") long id) {
		return service.borrarMM(id);
	}

	@GetMapping(path = Routes.mm)
	public List<MensajeMilitarModel> obtenerMM() {
		return service.obtenerMM();
	}

	@GetMapping(path = Routes.destinos) // api/datoscarga/destinos
	@ResponseBody
	public List<DestinoModel> obtenerDestinos() {
		return service.getDestinos();
	}

	@GetMapping(path = Routes.precedencias) // api/datoscarga/precedencias
	@ResponseBody
	public List<PrecedenciaModel> obtenerPrecedencias() {
		return service.getPrecedencias();
	}

	@GetMapping(path = Routes.promotores)
	@ResponseBody
	public List<PromotorModel> obtenerPromotores() {
		return service.getPromotores();
	}

	@GetMapping(path = Routes.seguridades)
	@ResponseBody
	public List<SeguridadModel> obtenerSeguridades() {
		return service.getSeguridades();
	}

}
