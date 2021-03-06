package mil.candes.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mil.candes.core.converter.PromotorConverter;
import mil.candes.core.entity.PromotorEntity;
import mil.candes.core.model.PromotorModel;
import mil.candes.core.repository.PromotorRepository;

@Service("promotorService")
public class PromotorService {
	@Autowired
	PromotorRepository repositorio;
	
	@Autowired
	PromotorConverter converter;
	
	
	
	public List<PromotorModel> getAll(){
		return converter.convertirListaPromotor(repositorio.findAll());
	}
	
	public PromotorEntity getPromotorEntity(long id) {
		return repositorio.findById(id);
	}
	
	public PromotorModel getPromotorModel(String descripcion){
		System.out.println(descripcion);
		System.out.println(repositorio.findByDescripcion(descripcion));
		return converter.convertirEntityToModel(repositorio.findByDescripcion(descripcion));
	}
	
	public PromotorModel getPromotorModel(long id) {
		return new PromotorModel(getPromotorEntity(id));
	}

}
