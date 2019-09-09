package mil.candes.core.model;

import mil.candes.core.entity.SeguridadEntity;

public class SeguridadModel {
	private long id;
	private String descripcion;

	
	public SeguridadModel(SeguridadEntity seguridadEntity) {
	
		this.id = seguridadEntity.getId();
		this.descripcion = seguridadEntity.getDescripcion();
	}

	public SeguridadModel() {
	}

	public SeguridadModel(long id, String descripcion) {
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
