package mil.candes.core.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import mil.candes.core.entity.DestinoEntity;
import mil.candes.core.entity.MensajeMilitarEntity;

public class MensajeMilitarModel {

	private long id;
	private long numeroRegistro;
	private long numeroControl;
	private long numeroFolio;
	private String grupoFechaHora;
	private String texto;
	private LocalDate fechaAlta;
	private String archivo;

	private PrecedenciaModel precedencia;
	private SeguridadModel seguridad;
	private PromotorModel promotor;
	private List<DestinoModel> ejecutivo;
	private List<DestinoModel> informativo;

	public MensajeMilitarModel(MensajeMilitarEntity mmEntity) {
		this.id = mmEntity.getId();
		this.numeroRegistro = mmEntity.getNumeroRegistro();
		this.numeroControl = mmEntity.getNumeroControl();
		this.numeroFolio = mmEntity.getNumeroFolio();
		this.grupoFechaHora = mmEntity.getGrupoFechaHora();
		this.texto = mmEntity.getTexto();
		this.fechaAlta = mmEntity.getFechaAlta();
		this.precedencia = new PrecedenciaModel(mmEntity.getPrecedencia());
		this.seguridad = new SeguridadModel(mmEntity.getSeguridad());
		this.promotor = new PromotorModel(mmEntity.getPromotor());
		this.ejecutivo = getDestinosModelos(mmEntity.getEjecutivo());
		this.informativo = getDestinosModelos(mmEntity.getInformativo());
		this.archivo = mmEntity.getArchivo();
	}

	public MensajeMilitarModel() {

	}

	public MensajeMilitarModel(long id, long numeroRegistro, long numeroControl, long numeroFolio,
			String grupoFechaHora, String texto, LocalDate fechaAlta, String archivo, PrecedenciaModel precedencia,
			SeguridadModel seguridad, PromotorModel promotor, List<DestinoModel> ejecutivo,
			List<DestinoModel> informativo) {
		this.id = id;
		this.numeroRegistro = numeroRegistro;
		this.numeroControl = numeroControl;
		this.numeroFolio = numeroFolio;
		this.grupoFechaHora = grupoFechaHora;
		this.texto = texto;
		this.fechaAlta = fechaAlta;
		this.archivo = archivo;
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

	public PrecedenciaModel getPrecedencia() {
		return precedencia;
	}

	public void setPrecedencia(PrecedenciaModel precedencia) {
		this.precedencia = precedencia;
	}

	public SeguridadModel getSeguridad() {
		return seguridad;
	}

	public void setSeguridad(SeguridadModel seguridad) {
		this.seguridad = seguridad;
	}

	public PromotorModel getPromotor() {
		return promotor;
	}

	public void setPromotor(PromotorModel promotor) {
		this.promotor = promotor;
	}

	public List<DestinoModel> getEjecutivo() {
		return ejecutivo;
	}

	public void setEjecutivo(List<DestinoModel> ejecutivo) {
		this.ejecutivo = ejecutivo;
	}

	public List<DestinoModel> getInformativo() {
		return informativo;
	}

	public void setInformativo(List<DestinoModel> informativo) {
		this.informativo = informativo;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	private List<DestinoModel> getDestinosModelos(List<DestinoEntity> destinosEntidades) {
		List<DestinoModel> destinosModel = new ArrayList<DestinoModel>();
		for (DestinoEntity destinoEntidad : destinosEntidades) {
			destinosModel.add(new DestinoModel(destinoEntidad));
		}
		return destinosModel;
	}

}
