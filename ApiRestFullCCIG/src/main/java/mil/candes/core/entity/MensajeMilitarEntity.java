package mil.candes.core.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name="mensajesMilitares")
@Entity

public class MensajeMilitarEntity implements Serializable {

	@Column(name="ID_MENSAJE_MILITAR")
	@GeneratedValue
	@Id
	private long id;
	
	@Column(name="NUMERO_REGISTRO")
	private long numeroRegistro;
	
	@Column(name="NUMERO_CONTROL")
	private long numeroControl;
	
	@Column(name="NUMERO_FOLIO")
	private long numeroFolio;
	
	@Column(name="GRUPO_FECHA_HORA")
	private String grupoFechaHora;
	
	@Column(name="TEXTO")
	private String texto;
	
	@Column(name="FECHA_ALTA")
	private LocalDate fechaAlta;
	
	@OneToOne
	@JoinColumn(name="ID_PRECEDENCIA")
	private PrecedenciaEntity precedencia;
	
	@OneToOne
	@JoinColumn(name="ID_SEGURIDAD")
	private SeguridadEntity seguridad;
	
	@OneToOne
	@JoinColumn(name="ID_PROMOTOR")
	private PromotorEntity promotor;
	
	@ManyToMany
	@JoinTable(name="MM_EJECUTIVO",
	joinColumns = @JoinColumn(name="ID_MM"),
	inverseJoinColumns = @JoinColumn(name="ID_EJECUTIVO"))
	private Set<DestinoEntity> ejecutivo;
	
	@ManyToMany
	@JoinTable(name="MM_INFORMATIVO",
	joinColumns = @JoinColumn(name="ID_MM"),
	inverseJoinColumns = @JoinColumn(name="ID_INFORMATIVO"))
	private Set<DestinoEntity> informativo;
	
	@ManyToMany
	@JoinTable(name="MM_ESTADO",
	joinColumns = @JoinColumn(name="ID_MM"),
	inverseJoinColumns = @JoinColumn(name="ID_ESTADO_MM"))
	private Set<EstadoMMEntity> estado;
	
	public MensajeMilitarEntity() {
		
	}
	public MensajeMilitarEntity(long id, long numeroRegistro, long numeroControl, long numeroFolio,
			String grupoFechaHora, String texto, LocalDate fechaAlta, PrecedenciaEntity precedencia, SeguridadEntity seguridad,
			PromotorEntity promotor, Set<DestinoEntity> ejecutivo, Set<DestinoEntity> informativo) {
		this.id = id;
		this.numeroRegistro = numeroRegistro;
		this.numeroControl = numeroControl;
		this.numeroFolio = numeroFolio;
		this.grupoFechaHora = grupoFechaHora;
		this.texto = texto;
		this.fechaAlta = fechaAlta;
		this.precedencia = precedencia;
		this.seguridad = seguridad;
		this.promotor = promotor;
		this.ejecutivo = ejecutivo;
		this.informativo = informativo;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getNumeroRegistro() {
		return numeroRegistro;
	}
	public void setNumeroRegistro(long numeroRegistro) {
		this.numeroRegistro = numeroRegistro;
	}
	public long getNumeroControl() {
		return numeroControl;
	}
	public void setNumeroControl(long numeroControl) {
		this.numeroControl = numeroControl;
	}
	public long getNumeroFolio() {
		return numeroFolio;
	}
	public void setNumeroFolio(long numeroFolio) {
		this.numeroFolio = numeroFolio;
	}
	public String getGrupoFechaHora() {
		return grupoFechaHora;
	}
	public void setGrupoFechaHora(String grupoFechaHora) {
		this.grupoFechaHora = grupoFechaHora;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public LocalDate getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public PrecedenciaEntity getPrecedencia() {
		return precedencia;
	}
	public void setPrecedencia(PrecedenciaEntity precedencia) {
		this.precedencia = precedencia;
	}
	public SeguridadEntity getSeguridad() {
		return seguridad;
	}
	public void setSeguridad(SeguridadEntity seguridad) {
		this.seguridad = seguridad;
	}
	public PromotorEntity getPromotor() {
		return promotor;
	}
	public void setPromotor(PromotorEntity promotor) {
		this.promotor = promotor;
	}
	public Set<DestinoEntity> getEjecutivo() {
		return ejecutivo;
	}
	public void setEjecutivo(Set<DestinoEntity> ejecutivo) {
		this.ejecutivo = ejecutivo;
	}
	public Set<DestinoEntity> getInformativo() {
		return informativo;
	}
	public void setInformativo(Set<DestinoEntity> informativo) {
		this.informativo = informativo;
	}
	
	
	
	
}
