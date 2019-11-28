package mil.candes.core.converter;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



import mil.candes.core.entity.MensajeMilitarEntity;
import mil.candes.core.model.DestinoModel;
import mil.candes.core.model.MensajeMilitarModel;
import mil.candes.core.service.MensajeMilitarService;

@Component("mensajeMilitarConverter")
public class MensajeMilitarConverter {

	@Autowired
	MensajeMilitarService service;

	public List<MensajeMilitarModel> convertirListaMM(List<MensajeMilitarEntity> mensajesMilitaresEntitys) {
		List<MensajeMilitarModel> mensajesMilitaresModels = new ArrayList<>();
		for (MensajeMilitarEntity mensajeMilitarEntity : mensajesMilitaresEntitys) {
			mensajesMilitaresModels.add(new MensajeMilitarModel(mensajeMilitarEntity));
		}
		return mensajesMilitaresModels;
	}

	public MensajeMilitarModel convertirMensajeMilitar(MensajeMilitarEntity mensajeMilitarEntity) {
		return new MensajeMilitarModel(mensajeMilitarEntity);
	}

	public MensajeMilitarModel convertirJsonAMensaje(JSONObject mmil) {

		MensajeMilitarModel mensaje = new MensajeMilitarModel();

		mensaje.setNumeroControl((long) mmil.get("numeroControl"));
		mensaje.setNumeroRegistro((long) mmil.get("numeroRegistro"));
		mensaje.setNumeroFolio((long) mmil.get("numeroFolio"));
		mensaje.setGrupoFechaHora((String) mmil.get("grupoFechaHora"));
		mensaje.setTexto((String) mmil.get("texto"));
		mensaje.setFechaAlta(LocalDate.now());

//		ejecutivos
		List<DestinoModel> ejecutivos = new ArrayList<DestinoModel>();
		JSONArray ejecutivosArray = (JSONArray) mmil.get("ejecutivo");
		for (int i = 0; i < ejecutivosArray.size(); i++) {
			ejecutivos.add(service.getDestinoModel((long) ejecutivosArray.get(i)));
		}
		mensaje.setEjecutivo(ejecutivos);

//		informativos
		List<DestinoModel> informativos = new ArrayList<DestinoModel>();
		JSONArray informativosArray = (JSONArray) mmil.get("informativo");
		for (int i = 0; i < informativosArray.size(); i++) {
			informativos.add(service.getDestinoModel((long)(informativosArray.get(i))));
		}
		mensaje.setInformativo(informativos);

//		precedencia
		mensaje.setPrecedencia(service.getPrecedenciaModel((long) mmil.get("precedencia")));

//		seguridad
		mensaje.setSeguridad(service.getSeguridadModel((long) mmil.get("seguridad")));

//		promotor
		mensaje.setPromotor(service.getPromotorModel((long) mmil.get("promotor")));
		
		
//		try {
//			MultipartFile archivo = (MultipartFile)mmil.get("archivo");
//			mensaje.setArchivo(archivo.getBytes());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		return mensaje;
	}

	public MensajeMilitarEntity convertirModelAEntity(MensajeMilitarModel model) {
		MensajeMilitarEntity entity = new MensajeMilitarEntity();
		entity.setNumeroControl(model.getNumeroControl());
		entity.setNumeroRegistro(model.getNumeroRegistro());
		entity.setNumeroFolio(model.getNumeroFolio());
		entity.setGrupoFechaHora(model.getGrupoFechaHora());
		entity.setTexto(model.getTexto());
		entity.setPrecedencia(service.getPrecedenciaEntity(model.getPrecedencia().getId()));
		entity.setSeguridad(service.getSeguridadEntity(model.getSeguridad().getId()));
		entity.setPromotor(service.getPromotorEntity(model.getPromotor().getId()));
		entity.setEjecutivo(service.getDestinosEntity(model.getEjecutivo()));
		entity.setInformativo(service.getDestinosEntity(model.getInformativo()));
		entity.setFechaAlta(model.getFechaAlta());
//		entity.setArchivo(model.getArchivo());
		return entity;
	}
	
	public List<MensajeMilitarModel> convertirMmEntityAMmModel(List<MensajeMilitarEntity> listaEntidades){
		List<MensajeMilitarModel> mensajesModel = new ArrayList<>();
		for(MensajeMilitarEntity mensajeEntity : listaEntidades) {
			mensajesModel.add(new MensajeMilitarModel(mensajeEntity));
		}
		return mensajesModel;
		
	}

}
