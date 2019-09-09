package mil.candes.core.model;

import mil.candes.core.entity.DestinoEntity;

public class DestinoModel {

	private long id;

	private String descripcion;

	private String correo;

	public DestinoModel(DestinoEntity destinoEntity) {
		this.id = destinoEntity.getId();
		this.descripcion = destinoEntity.getDescripcion();
		this.correo = destinoEntity.getCorreo();
	}

	public DestinoModel() {

	}

	public DestinoModel(long id, String descripcion, String correo) {

		this.id = id;
		this.descripcion = descripcion;
		this.correo = correo;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
