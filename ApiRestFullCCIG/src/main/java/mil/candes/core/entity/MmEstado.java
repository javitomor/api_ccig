package mil.candes.core.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MM_ESTADO")
public class MmEstado {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private long id;
	
	@Column(name="ID_ESTADO_MM")
	private long idEstadoMM;
	
	@Column(name="ID_MM")
	private long idMM;
	
	@Column(name="ACTUAL")
	private boolean actual;
	
	@Column(name="FECHA")
	private LocalDate fecha;
}
