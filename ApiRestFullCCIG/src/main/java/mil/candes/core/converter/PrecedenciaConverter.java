package mil.candes.core.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import mil.candes.core.entity.PrecedenciaEntity;
import mil.candes.core.model.PrecedenciaModel;

@Component("precendeciaConverter")
public class PrecedenciaConverter {
	
	public List<PrecedenciaModel> convertirListaPrecedencia(List<PrecedenciaEntity> precedenciasEntitys){
	
		List<PrecedenciaModel> precedenciasModel = new ArrayList<>();
		
		for (PrecedenciaEntity precedenciaEntity: precedenciasEntitys) {
			precedenciasModel.add(new PrecedenciaModel(precedenciaEntity));
		}
		
		return precedenciasModel;
	}

}
