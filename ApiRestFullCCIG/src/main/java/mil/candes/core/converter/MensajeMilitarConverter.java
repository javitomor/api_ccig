package mil.candes.core.converter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mil.candes.core.entity.DestinoEntity;
import mil.candes.core.entity.MensajeMilitarEntity;
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

		mensaje.setNumeroControl((long) mmil.get("nc"));
		mensaje.setNumeroRegistro((long) mmil.get("nr"));
		mensaje.setNumeroFolio((long) mmil.get("folio"));
		mensaje.setGrupoFechaHora((String) mmil.get("gfh"));
		mensaje.setTexto((String) mmil.get("texto"));
		mensaje.setFechaAlta(LocalDate.now());

//		ejecutivos
		List<DestinoEntity> ejecutivos = new ArrayList<DestinoEntity>();
		JSONArray ejecutivosArray = (JSONArray) mmil.get("ejecutivos");
		for (int i = 0; i < ejecutivosArray.size(); i++) {
			ejecutivos.add(service.getDestinoEntity((long) ejecutivosArray.get(i)));
		}
		mensaje.setEjecutivo(ejecutivos);

//		informativos
		List<DestinoEntity> informativos = new ArrayList<DestinoEntity>();
		JSONArray informativosArray = (JSONArray) mmil.get("informativos");
		for (int i = 0; i < informativosArray.size(); i++) {
			informativos.add(service.getDestinoEntity((long)(informativosArray.get(i))));
		}
		mensaje.setInformativo(informativos);

//		precedencia
		mensaje.setPrecedencia(service.getPrecedenciaEntity((long) mmil.get("precedencia")));

//		seguridad
		mensaje.setSeguridad(service.getSeguridadEntity((long) mmil.get("seguridad")));

//		promotor
		mensaje.setPromotor(service.getPromotorEntity((long) mmil.get("promotor")));

		return mensaje;
	}

	public MensajeMilitarEntity convertirModelAEntity(MensajeMilitarModel model) {
		MensajeMilitarEntity entity = new MensajeMilitarEntity();
		entity.setNumeroControl(model.getNumeroControl());
		entity.setNumeroRegistro(model.getNumeroRegistro());
		entity.setNumeroFolio(model.getNumeroFolio());
		entity.setGrupoFechaHora(model.getGrupoFechaHora());
		entity.setTexto(model.getTexto());
		entity.setPrecedencia(model.getPrecedencia());
		entity.setSeguridad(model.getSeguridad());
		entity.setPromotor(model.getPromotor());
		entity.setEjecutivo(model.getEjecutivo());
		entity.setInformativo(model.getInformativo());
		entity.setFechaAlta(model.getFechaAlta());
		return entity;
	}

}
