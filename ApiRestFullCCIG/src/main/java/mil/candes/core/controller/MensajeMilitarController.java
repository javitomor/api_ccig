package mil.candes.core.controller;

import java.util.List;
import javax.validation.Valid;

import org.json.simple.JSONArray;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
@RequestMapping(value = Routes.api)
public class MensajeMilitarController {

	@Autowired
	@Qualifier("mensajeMilitarService")
	MensajeMilitarService service;

	@PostMapping(path = Routes.guardarMM)
	@ResponseBody
	public ResponseEntity<String> guardarEntidadMM(@RequestBody String mensajeMilitarJson) {
		try {

			JSONParser parser = new JSONParser();
			JSONObject jsonObect = (JSONObject) parser.parse(mensajeMilitarJson);
			MensajeMilitarEntity mensajeEntity = service
					.convertirModelAEntity(service.convertirJsonAMensaje(jsonObect));
			mensajeEntity.setGrupoFechaHora(mensajeEntity.getGrupoFechaHora().toUpperCase());
//			mensajeEntity.setArchivo(Routes.workDirectory + archivo.getOriginalFilename());
//			, @RequestParam("file")MultipartFile archivo

			return new ResponseEntity<String>(Long.toString(service.guardarMM(mensajeEntity)), HttpStatus.CREATED);

		} catch (ParseException | NullPointerException e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Algo salió mal", HttpStatus.NOT_MODIFIED);
		}
	}

	@PostMapping(path = Routes.guardarMMdesdePdf)
	@ResponseBody
	public ResponseEntity<String> guardarMensajeDesdePDF(@RequestBody String mensajeMilitarDesarmado) {

		boolean mensajeGuardado = false;
		mensajeGuardado = service.guardarMensajeMilitarDesdePDF(mensajeMilitarDesarmado);

		if (mensajeGuardado) {
			return new ResponseEntity<String>("bien", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("mal", HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping(path = Routes.guardarArchivoMM)
	@ResponseBody
	public ResponseEntity<String> guardarArchivoMM(@RequestParam("file") MultipartFile filePDF,
			@RequestParam("idMensajeMilitar") long idMensajeMilitar) {
		return new ResponseEntity<String>(service.guardarArchivoMM(filePDF, idMensajeMilitar), HttpStatus.CREATED);
	}

	@GetMapping(path = Routes.obtenerTodosMensajesMilitares)
	@ResponseBody
	public JSONArray getMensajesMilitares() {
//		List<MensajeMilitarModel> mensaje = service.armarJson(service.getMensajesMilitares());
//		for(MensajeMilitarModel mm : mensaje) {
//			System.out.println(mm.getPromotor());
//		}
		return service.armarJson(service.getMensajesMilitares());
	}

	@GetMapping(Routes.obtenerMensajeMilitar)
	@ResponseBody
	public MensajeMilitarModel getMensajeMilitar(@PathVariable("id") long idMensajeMilitar) {
		return service.getMensajeMilitar(idMensajeMilitar);
	}

//	@PostMapping(path = "/mm")
//	public boolean actualizarMensajeMilitar(@RequestBody @Valid MensajeMilitarEntity mensaje) {
//		return service.actualizarMM(mensaje);
//	}

//	@DeleteMapping(path = "/mm/{id}")
//	public boolean borrarMM(@PathVariable("id") long id) {
//		return service.borrarMM(id);
//	}

	@GetMapping(path = Routes.mm)
	public List<MensajeMilitarModel> obtenerMM() {
		return service.obtenerMM();
	}

	@GetMapping(path = Routes.destinos) // api/datoscarga/destinos/all
	@ResponseBody
	public List<DestinoModel> obtenerDestinos() {
		return service.getDestinos();
	}

	@GetMapping(path = Routes.destino)
	@ResponseBody
	public DestinoModel getDestino(String descripcion) {
		return service.getDestino(descripcion);
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

	@GetMapping(path = Routes.promotor)
	@ResponseBody
	public PromotorModel getPromotor(String descripcion) {
		return service.getPromotor(descripcion);

	}

	@GetMapping(path = Routes.seguridades)
	@ResponseBody
	public List<SeguridadModel> obtenerSeguridades() {
		return service.getSeguridades();
	}

	@GetMapping(path = Routes.seguridad)
	@ResponseBody
	public SeguridadModel getSeguridad(@PathVariable("id") long id) {
		return new SeguridadModel(service.getSeguridadEntity(id));
	}

}
