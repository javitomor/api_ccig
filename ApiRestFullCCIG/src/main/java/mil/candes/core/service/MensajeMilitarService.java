package mil.candes.core.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import mil.candes.core.configuration.Routes;
import mil.candes.core.configuration.Util;
import mil.candes.core.converter.MensajeMilitarConverter;
import mil.candes.core.entity.DestinoEntity;
import mil.candes.core.entity.MensajeMilitarEntity;
import mil.candes.core.entity.PrecedenciaEntity;
import mil.candes.core.entity.PromotorEntity;
import mil.candes.core.entity.SeguridadEntity;
import mil.candes.core.model.DestinoModel;
import mil.candes.core.model.MensajeMilitarModel;
import mil.candes.core.model.PrecedenciaModel;
import mil.candes.core.model.PromotorModel;
import mil.candes.core.model.SeguridadModel;
import mil.candes.core.repository.MensajeMilitarRepository;

@Service("mensajeMilitarService")
public class MensajeMilitarService {
	private static final Log logger = LogFactory.getLog(MensajeMilitarService.class);

	@Autowired
	@Qualifier("mensajeMilitarRepositorio")
	private MensajeMilitarRepository repositorio;

	@Autowired
	@Qualifier("mensajeMilitarConverter")
	private MensajeMilitarConverter convertidor;

	@Autowired
	@Qualifier("destinoService")
	DestinoService destinoService;

	@Autowired
	PrecedenciaService precedenciaService;

	@Autowired
	PromotorService promotorService;

	@Autowired
	SeguridadService seguridadService;

	public long guardarMM(MensajeMilitarEntity mmEntity) {
		try {

			// Guardo MM en DB
			repositorio.save(mmEntity);

			return mmEntity.getId();

		} catch (Exception e) {
			logger.error("No se pudo crear el MM");
			e.printStackTrace();
			return 0L;
		}
	}

	public boolean guardarMensajeMilitarDesdePDF(String mensajeMilitarDesarmado) {
		
		try {
			JSONParser parser = new JSONParser();
			JSONObject jsonObect = (JSONObject) parser.parse(mensajeMilitarDesarmado);
			MensajeMilitarModel mensajeMilitar = new MensajeMilitarModel();

			mensajeMilitar.setTexto(jsonObect.get("texto").toString());
			mensajeMilitar.setGrupoFechaHora(jsonObect.get("GFH").toString());
			mensajeMilitar.setNumeroControl(Long.parseLong(jsonObect.get("NC").toString()));
			mensajeMilitar.setNumeroRegistro(Long.parseLong(jsonObect.get("NR").toString()));

			mensajeMilitar.setSeguridad(
					seguridadService.getSeguridadModelPorDescripcion(jsonObect.get("seguridad").toString()));
			mensajeMilitar.setPrecedencia(
					precedenciaService.getPrecedenciaModelPorDescripcion(jsonObect.get("precedencia").toString()));
			
			Object promotor  =jsonObect.get("promotor");
//			promotor = Long.parseLong(jsonObect.get("promotor").toString());
			System.out.println(mensajeMilitarDesarmado);
			System.out.println("el promotor es: "+promotor);
			
			mensajeMilitar.setPromotor(promotorService.getPromotorModel(jsonObect.get("promotor").toString()));
			mensajeMilitar
					.setInformativo(destinoService.getTodosDestinosModel(jsonObect.get("informativos").toString()));
			mensajeMilitar.setEjecutivo(destinoService.getTodosDestinosModel(jsonObect.get("ejecutivos").toString()));

			repositorio.save(convertirModelAEntity(mensajeMilitar));
			return true;
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
	}

	public String guardarArchivoMM(MultipartFile filePDF, long idMensajeMilitar) {
		// Gaurdo Archivo pdf

		String nombreArchivo = Util.getNombreArchivo(filePDF.getOriginalFilename());
		String ruta = Routes.workDirectory + nombreArchivo;
		File convertFile = new File(ruta);

		try {
			convertFile.createNewFile();
			FileOutputStream fout = new FileOutputStream(convertFile);
			fout.write(filePDF.getBytes());

			repositorio.findById(idMensajeMilitar).setArchivo(ruta);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return nombreArchivo;
	}

	public boolean actualizarMM(MensajeMilitarEntity mmEntity) {
		try {
			if (mmEntity.getId() == 0) {

			} else {
				repositorio.save(mmEntity);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean borrarMM(long id) {
		try {
			repositorio.delete(repositorio.findById(id));
			return true;
		} catch (Exception e) {
			logger.error("No se pudo borrar el mensaje");
			e.printStackTrace();
			return false;
		}

	}

	public List<MensajeMilitarModel> obtenerMM() {
		return convertidor.convertirListaMM(repositorio.findAll());
	}

	public List<MensajeMilitarModel> obtenerMMPaginados(Pageable pageable) {
		return convertidor.convertirListaMM(repositorio.findAll(pageable).getContent());
	}

	public List<DestinoModel> getDestinos() {
		return destinoService.getAll();
	}

	public DestinoModel getDestino(String descripcion) {
		return destinoService.getDestinoModel(descripcion);
	}
	
	public DestinoModel getDestinoModel(long id) {
		return destinoService.getDestinoModel(id);
	}

	public DestinoEntity getDestinoEntity(long id) {
		return destinoService.getDestinoEntity(id);
	}
	
	public List<DestinoEntity> getDestinosEntity(List<DestinoModel> destinosModelos){
		List<DestinoEntity> destinosEntity = new ArrayList<DestinoEntity>();
		for(DestinoModel destinoModelo : destinosModelos) {
			destinosEntity.add(getDestinoEntity(destinoModelo.getId()));
		}
		return destinosEntity;
	}

	public List<PrecedenciaModel> getPrecedencias() {
		return precedenciaService.getAll();
	}

	public PrecedenciaModel getPrecedenciaModel(long id) {
		return precedenciaService.getPrecedenciaModel(id);
	}
	
	public PrecedenciaEntity getPrecedenciaEntity(long id) {
		return precedenciaService.getPredecedenciaEntity(id);
	}

	public List<PromotorModel> getPromotores() {
		return promotorService.getAll();
	}

	public PromotorModel getPromotor(String descripcion) {
		return promotorService.getPromotorModel(descripcion);
	}
	
	public PromotorModel getPromotorModel(long id) {
		return promotorService.getPromotorModel(id);
	}

	public PromotorEntity getPromotorEntity(long id) {
		return promotorService.getPromotorEntity(id);
	}

	public List<SeguridadModel> getSeguridades() {
		return seguridadService.getAll();
	}

	public SeguridadModel getSeguridadModel(long id) {
		return seguridadService.getSeguridadModel(id);
	}
	public SeguridadEntity getSeguridadEntity(long id) {
		return seguridadService.getSeguridadEntity(id);
	}

	public MensajeMilitarModel convertirJsonAMensaje(JSONObject mmil) {
		return convertidor.convertirJsonAMensaje(mmil);
	}

	public MensajeMilitarEntity convertirModelAEntity(MensajeMilitarModel mensajeModel) {
		return convertidor.convertirModelAEntity(mensajeModel);
	}

	public List<MensajeMilitarEntity> getMensajesMilitares() {
		return repositorio.findAll();
	}

	public List<MensajeMilitarModel> convertirMmEntityAMmModel(List<MensajeMilitarEntity> listaEntidades) {
		return convertidor.convertirMmEntityAMmModel(listaEntidades);

	}

	public MensajeMilitarModel getMensajeMilitar(long idMensajeMilitar) {
		return new MensajeMilitarModel(repositorio.findById(idMensajeMilitar));
	}

	public JSONArray armarJson(List<MensajeMilitarEntity> listaEntidades) {

		JSONArray jsonArray = new JSONArray();
		for (MensajeMilitarEntity mensajeEntity : listaEntidades) {
			JSONObject jsonObj = new JSONObject();
			JSONArray jsonEjecutivos = new JSONArray();
			JSONArray jsonInformativos = new JSONArray();
			jsonObj.put("id", mensajeEntity.getId());
			jsonObj.put("nr", mensajeEntity.getNumeroRegistro());
			jsonObj.put("nc", mensajeEntity.getNumeroControl());
			jsonObj.put("folio", mensajeEntity.getNumeroFolio());
			jsonObj.put("gfh", mensajeEntity.getGrupoFechaHora());
			jsonObj.put("texto", mensajeEntity.getTexto());
			jsonObj.put("urlPdf", mensajeEntity.getArchivo());
			jsonObj.put("fecha", mensajeEntity.getFechaAlta());
			jsonObj.put("precedencia", mensajeEntity.getPrecedencia().getDescripcion());
			jsonObj.put("seguridad", mensajeEntity.getSeguridad().getDescripcion());
			jsonObj.put("promotor", mensajeEntity.getPromotor().getDescripcion());

			for (DestinoEntity ejecutivo : mensajeEntity.getEjecutivo()) {
				jsonEjecutivos.add(ejecutivo.getDescripcion());

			}
			jsonObj.put("ejecutivos", jsonEjecutivos);

			for (DestinoEntity informativo : mensajeEntity.getInformativo()) {
				jsonInformativos.add(informativo.getDescripcion());
			}
			jsonObj.put("informativos", jsonInformativos);

			jsonArray.add(jsonObj);

		}
		return jsonArray;
	}

}
