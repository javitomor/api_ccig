package mil.candes.core.model;

import mil.candes.core.entity.PrecedenciaEntity;

public class PrecedenciaModel {

	private long id;
	private String descripcion;

	public PrecedenciaModel(PrecedenciaEntity precedenciaEntity) {
		this.id = precedenciaEntity.getId();
		this.descripcion = precedenciaEntity.getDescripcion();
	}

	public PrecedenciaModel() {
	}

	public PrecedenciaModel(long id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
