package mil.candes.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mil.candes.core.converter.SeguridadConverter;
import mil.candes.core.entity.SeguridadEntity;
import mil.candes.core.model.SeguridadModel;
import mil.candes.core.repository.SeguridadRepository;

@Service("seguridadService")
public class SeguridadService {

	@Autowired
	SeguridadRepository repositorio;

	@Autowired
	SeguridadConverter converter;

	public List<SeguridadModel> getAll() {
		return converter.convertirListaSeguridad(repositorio.findAll());
	}

	public SeguridadEntity getSeguridadEntity(long id) {
		return repositorio.findById(id);
	}

	public SeguridadModel getSeguridadModelPorDescripcion(String descripcion) {
		return new SeguridadModel(repositorio.findByDescripcion(descripcion));
	}
	
	public SeguridadModel getSeguridadModel(long id) {
		return new SeguridadModel(getSeguridadEntity(id));
	}
}
