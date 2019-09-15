package mil.candes.core.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import mil.candes.core.entity.DestinoEntity;
import mil.candes.core.model.DestinoModel;

@Component("destinoConverter")
public class DestinosConverter {

	public List<DestinoModel> convertirListaDestino(List<DestinoEntity> destinosEntitys) {
		
			List<DestinoModel> destinosModels = new ArrayList<>();
			for (DestinoEntity destinoEntity : destinosEntitys) {
				destinosModels.add(new DestinoModel(destinoEntity));
			}
			return destinosModels;
		}
	
}
