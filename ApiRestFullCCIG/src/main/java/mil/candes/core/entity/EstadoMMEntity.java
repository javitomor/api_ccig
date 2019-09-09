package mil.candes.core.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ESTADO_MENSAJE_MILITAR")
public class EstadoMMEntity {

	@Id
	@GeneratedValue
	@Column(name="ID_ESTADO")
	private long id;
	
	@Column(name="NOMBRE")
	private String nombre;
}
