package mil.candes.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mil.candes.core.converter.PrecedenciaConverter;
import mil.candes.core.entity.PrecedenciaEntity;
import mil.candes.core.model.PrecedenciaModel;
import mil.candes.core.repository.PrecedenciaRepository;

@Service("precedenciaService")
public class PrecedenciaService {

	@Autowired
	PrecedenciaRepository repositorio;
	
	@Autowired
	PrecedenciaConverter converter;

	public List<PrecedenciaModel> getAll() {
		return converter.convertirListaPrecedencia(repositorio.findAll());
	}
	
	public PrecedenciaModel getPrecedenciaModel(long id) {
		return converter.convertirAModel(this.getPredecedenciaEntity(id));
	}
	
	public PrecedenciaEntity getPredecedenciaEntity(long id) {
		return repositorio.findById(id);
	}
}
