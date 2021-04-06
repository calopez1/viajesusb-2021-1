
package co.edu.usbcali.viajes.app.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author cesarlopez
 *
 */

@Entity
@Table(name="destino")
public class Destino implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4735233971064962119L;

	@Id
	@Column(name = "id_dest")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDest;
	
	@NotNull
	@NotEmpty
	@Size(max = 5)
	@Column(name = "codigo", unique = true, nullable = false, length = 5)
	private String codigo;
	
	@NotNull
	@NotEmpty
	@Size(max = 100)
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	
	@NotNull
	@NotEmpty
	@Size(max = 300)
	@Column(name = "descripcion", nullable = false, length = 300)
	private String descripcion;
	
	@NotNull
	@NotEmpty
	@Size(max = 1)
	@Column(name = "tierra", nullable = false, length = 1)
	private String tierra;
	
	@NotNull
	@NotEmpty
	@Size(max = 1)
	@Column(name = "aire", nullable = false, length = 1)
	private String aire;
	
	@NotNull
	@NotEmpty
	@Size(max = 1)
	@Column(name = "mar", nullable = false, length = 1)
	private String mar;
	
	@NotNull
	@Column(name = "fecha_creacion", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;
	
	@Column(name = "fecha_modificacion")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaModificacion;
	
	@NotNull
	@NotEmpty
	@Column(name = "usu_creador", nullable = false, length = 10)
	private String usuCreador;
	
	@Column(name = "usu_modificador", length = 10)
	private String usuModificador;
	
	@NotNull
	@NotEmpty
	@Size(max = 1)
	@Column(name = "estado", nullable = false, length = 1)
	private String estado;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tide", nullable = false)
	private TipoDestino tipoDestino;
	
	/**
	 * 
	 */
	public Destino() {
		super();
	}
	
	/**
	 * @param idDest
	 * @param codigo
	 * @param nombre
	 * @param descripcion
	 * @param tierra
	 * @param aire
	 * @param mar
	 * @param fechaCreacion
	 * @param fechaModificacion
	 * @param usuCreador
	 * @param usuModificador
	 * @param tipoDestino
	 */
	public Destino(Integer idDest, @NotNull String codigo, @NotNull String nombre, @NotNull String descripcion,
			@NotNull String tierra, @NotNull String aire, @NotNull String mar, @NotNull Date fechaCreacion,
			Date fechaModificacion, @NotNull String usuCreador, String usuModificador,
			@NotNull TipoDestino tipoDestino) {
		super();
		this.idDest = idDest;
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tierra = tierra;
		this.aire = aire;
		this.mar = mar;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuCreador = usuCreador;
		this.usuModificador = usuModificador;
		this.tipoDestino = tipoDestino;
	}



	/**
	 * @return the idDest
	 */
	public Integer getIdDest() {
		return idDest;
	}

	/**
	 * @param idDest the idDest to set
	 */
	public void setIdDest(Integer idDest) {
		this.idDest = idDest;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the tierra
	 */
	public String getTierra() {
		return tierra;
	}

	/**
	 * @param tierra the tierra to set
	 */
	public void setTierra(String tierra) {
		this.tierra = tierra;
	}

	/**
	 * @return the aire
	 */
	public String getAire() {
		return aire;
	}

	/**
	 * @param aire the aire to set
	 */
	public void setAire(String aire) {
		this.aire = aire;
	}

	/**
	 * @return the mar
	 */
	public String getMar() {
		return mar;
	}

	/**
	 * @param mar the mar to set
	 */
	public void setMar(String mar) {
		this.mar = mar;
	}

	/**
	 * @return the fechaCreacion
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return the fechaModificacion
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the usuCreador
	 */
	public String getUsuCreador() {
		return usuCreador;
	}

	/**
	 * @param usuCreador the usuCreador to set
	 */
	public void setUsuCreador(String usuCreador) {
		this.usuCreador = usuCreador;
	}

	/**
	 * @return the usuModificador
	 */
	public String getUsuModificador() {
		return usuModificador;
	}

	/**
	 * @param usuModificador the usuModificador to set
	 */
	public void setUsuModificador(String usuModificador) {
		this.usuModificador = usuModificador;
	}

	/**
	 * @return the tipoDestino
	 */
	public TipoDestino getTipoDestino() {
		return tipoDestino;
	}

	/**
	 * @param tipoDestino the tipoDestino to set
	 */
	public void setTipoDestino(TipoDestino tipoDestino) {
		this.tipoDestino = tipoDestino;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

}
