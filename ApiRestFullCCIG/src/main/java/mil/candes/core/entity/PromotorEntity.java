package mil.candes.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "PROMOTORES")
@Entity
public class PromotorEntity implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "ID_PROMOTOR")
	private long id;

	@Column(name = "DESCRIPCION")
	private String descripcion;

	@Column(name = "CORREO")
	private String correo;

	public PromotorEntity() {
	}

	public PromotorEntity(long id, String descripcion, String correo) {
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
