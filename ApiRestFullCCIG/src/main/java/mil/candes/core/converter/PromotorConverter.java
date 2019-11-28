package mil.candes.core.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import mil.candes.core.entity.PromotorEntity;
import mil.candes.core.model.PromotorModel;

@Component("promotorConverter")
public class PromotorConverter {
	
	public List<PromotorModel> convertirListaPromotor(List<PromotorEntity> promotoresEntity){
		
		List<PromotorModel> promotoresModel = new ArrayList<>();
		for(PromotorEntity promotorEntity:promotoresEntity) {
			promotoresModel.add(new PromotorModel(promotorEntity));
		}
		return promotoresModel;
	}
	
	public PromotorModel convertirEntityToModel(PromotorEntity entidad) {
		System.out.println(entidad.getId());
		return new PromotorModel(entidad);
	}

}
