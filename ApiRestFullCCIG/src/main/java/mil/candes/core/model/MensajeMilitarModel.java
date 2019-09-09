package mil.candes.core.model;

import java.time.LocalDate;
import java.util.Set;

import mil.candes.core.entity.DestinoEntity;
import mil.candes.core.entity.MensajeMilitarEntity;
import mil.candes.core.entity.PrecedenciaEntity;
import mil.candes.core.entity.PromotorEntity;
import mil.candes.core.entity.SeguridadEntity;

public class MensajeMilitarModel {

	private long id;
	private long numeroRegistro;
	private long numeroControl;
	private long numeroFolio;
	private String grupoFechaHora;
	private String texto;
	private LocalDate fechaAlta;
	
	private PrecedenciaEntity precedencia;
	private SeguridadEntity seguridad;
	private PromotorEntity promotor;
	private Set<DestinoEntity> ejecutivo;
	private Set<DestinoEntity> informativo;
	
	
	
	public MensajeMilitarModel(MensajeMilitarEntity mmEntity) {
		this.id = mmEntity.getId();
		this.numeroRegistro = mmEntity.getNumeroRegistro();
		this.numeroControl = mmEntity.getNumeroControl();
		this.numeroFolio = mmEntity.getNumeroFolio();
		this.grupoFechaHora = mmEntity.getGrupoFechaHora();
		this.texto = mmEntity.getTexto();
		this.fechaAlta = mmEntity.getFechaAlta();
		this.precedencia = mmEntity.getPrecedencia();
		this.seguridad = mmEntity.getSeguridad();
		this.promotor = mmEntity.getPromotor();
		this.ejecutivo = mmEntity.getEjecutivo();
		this.informativo = mmEntity.getInformativo();
	}

	public MensajeMilitarModel() {
		
	}
	
	public MensajeMilitarModel(long id, long numeroRegistro, long numeroControl, long numeroFolio,
			String grupoFechaHora, String texto, LocalDate fechaAlta, PrecedenciaEntity precedencia,
			SeguridadEntity seguridad, PromotorEntity promotor, Set<DestinoEntity> ejecutivo, Set<DestinoEntity> informativo) {
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
