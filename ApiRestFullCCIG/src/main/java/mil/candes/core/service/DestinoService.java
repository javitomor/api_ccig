package mil.candes.core.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mil.candes.core.converter.DestinosConverter;
import mil.candes.core.entity.DestinoEntity;
import mil.candes.core.model.DestinoModel;
import mil.candes.core.repository.DestinosRepository;

@Service("destinoService")
public class DestinoService {
	
	@Autowired
	@Qualifier("destinoRepositorio")
	private DestinosRepository repositorio;
	
	@Autowired
	@Qualifier("destinoConverter")
	private DestinosConverter converter;
	
	
	public List<DestinoModel> getAll(){
		return converter.convertirListaDestino(repositorio.findAll());
	}
	
	public DestinoEntity getDestinoEntity(long id) {
		return repositorio.findById(id);
	}
	
	public DestinoModel getDestinoModel(String descripcion) {
		return converter.convertirEntityToModel(repositorio.findByDescripcion(descripcion));
	}
	
	public List<DestinoModel> getTodosDestinosModel(String arrayJson){
		return new ArrayList<DestinoModel>();
	}
	
	public DestinoModel getDestinoModel(long id) {
		return converter.convertirEntityToModel(repositorio.findById(id));
	}

}
