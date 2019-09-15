package mil.candes.core.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import mil.candes.core.entity.SeguridadEntity;
import mil.candes.core.model.SeguridadModel;

@Component("seguridadConverter")
public class SeguridadConverter {

	public List<SeguridadModel> convertirListaSeguridad(List<SeguridadEntity> seguridadesEntity){
		List<SeguridadModel> seguridadesModel = new ArrayList<>();
		for(SeguridadEntity seguridadEntity: seguridadesEntity) {
			seguridadesModel.add(new SeguridadModel(seguridadEntity));
		}
		return seguridadesModel;
	}
}
