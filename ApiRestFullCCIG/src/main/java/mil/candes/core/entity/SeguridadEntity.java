package mil.candes.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "SEGURIDAD")
@Entity
public class SeguridadEntity implements Serializable{

	@Column(name="ID_SEGURIDAD")
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="DESCRIPCION")
	private String descripcion;

	public SeguridadEntity() {
	}

	public SeguridadEntity(long id, String descripcion) {
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
