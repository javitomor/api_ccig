package mil.candes.core.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "PRECEDENCIA")
@Entity
public class PrecedenciaEntity implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "ID_PRECEDENCIA")
	private long id;

	@Column(name = "DESCRIPCION")
	private String descripcion;

	public PrecedenciaEntity() {
	}

	public PrecedenciaEntity(long id, String descripcion) {
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
