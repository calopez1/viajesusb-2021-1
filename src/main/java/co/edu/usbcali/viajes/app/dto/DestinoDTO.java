package co.edu.usbcali.viajes.app.dto;

import java.io.Serializable;
import java.util.Date;

public class DestinoDTO implements Serializable {
	
	private static final long serialVersionUID = -4735233971064962119L;

	private Integer idDest;
	private String codigo;
	private String nombre;
	private String descripcion;
	private String aire;
	private String mar;
	private String tierra;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String usuCreador;	
	private String usuModificador;
	private String estado;
	
	private Integer tipoDestinoId;
	private String tipoDestinoCodigo;
	
	
	public DestinoDTO() {
		super();
	}
	
	public Integer getIdDest() {
		return idDest;
	}
	public void setIdDest(Integer idDest) {
		this.idDest = idDest;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getAire() {
		return aire;
	}
	public void setAire(String aire) {
		this.aire = aire;
	}
	public String getMar() {
		return mar;
	}
	public void setMar(String mar) {
		this.mar = mar;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public String getUsuCreador() {
		return usuCreador;
	}
	public void setUsuCreador(String usuCreador) {
		this.usuCreador = usuCreador;
	}
	public String getUsuModificador() {
		return usuModificador;
	}
	public void setUsuModificador(String usuModificador) {
		this.usuModificador = usuModificador;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getTipoDestinoId() {
		return tipoDestinoId;
	}
	public void setTipoDestinoId(Integer tipoDestinoId) {
		this.tipoDestinoId = tipoDestinoId;
	}
	public String getTipoDestinoCodigo() {
		return tipoDestinoCodigo;
	}
	public void setTipoDestinoCodigo(String tipoDestinoCodigo) {
		this.tipoDestinoCodigo = tipoDestinoCodigo;
	}

	public String getTierra() {
		return tierra;
	}

	public void setTierra(String tierra) {
		this.tierra = tierra;
	}
	
	
	
}