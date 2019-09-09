package mil.candes.core.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mil.candes.core.converter.MensajeMilitarConverter;
import mil.candes.core.entity.MensajeMilitarEntity;
import mil.candes.core.model.MensajeMilitarModel;
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

	public boolean crearMM(MensajeMilitarEntity mmEntity) {
		try {
			logger.info("Creando MM");
			repositorio.save(mmEntity);
			return true;
		} catch (Exception e) {
			logger.error("No se pudo crear el MM");
			e.printStackTrace();
			return false;
		}
	}

	public boolean actualizarMM(MensajeMilitarEntity mmEntity) {
		try {
			logger.info("Actualizando MM");
			if (mmEntity.getId() == 0) {
				this.crearMM(mmEntity);
			} else {
				repositorio.save(mmEntity);
			}
			return true;
		} catch (Exception e) {
			logger.error("No se pudo actualizar el MM");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean borrarMM(long id) {
		try {
			logger.info("Borrando MM");
			repositorio.delete(repositorio.findById(id));
			return true;
		} catch (Exception e) {
			logger.error("No se pudo borrar el mensaje");
			e.printStackTrace();
			return false;
		}
		
	}
	
	public List<MensajeMilitarModel> obtenerMM(){
		logger.info("Obteniendo MM");
		return convertidor.convertirListaMM(repositorio.findAll());
	}
	
	public List<MensajeMilitarModel> obtenerMMPaginados(Pageable pageable){
		return convertidor.convertirListaMM(repositorio.findAll(pageable).getContent());
	}
}
