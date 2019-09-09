package mil.candes.core.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import mil.candes.core.entity.MensajeMilitarEntity;
import mil.candes.core.model.MensajeMilitarModel;

@Component("mensajeMilitarConverter")
public class MensajeMilitarConverter {
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

}
