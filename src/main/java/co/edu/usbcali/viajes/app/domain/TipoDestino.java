package co.edu.usbcali.viajes.app.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import co.edu.usbcali.viajes.app.dto.TipoDestinoDTO;

/**
 * @author cesarlopez
 *
 */

@NamedNativeQueries({
	@NamedNativeQuery(name="TipoDestino.consultarTipoDestinoPorEstado", query="", resultSetMapping = "consultarTipoDestinoPorEstado"),
})

@SqlResultSetMappings({
	@SqlResultSetMapping( name="consultarTipoDestinoPorEstado",
			classes= { @ConstructorResult(targetClass = TipoDestinoDTO.class,
				columns = {
						@ColumnResult(name="idTide", type = Integer.class),
						@ColumnResult(name="codigo", type = String.class),
						@ColumnResult(name="nombre", type = String.class),
						@ColumnResult(name="descripcion", type = String.class),

				}) }),		
})

@Entity
@Table(name="tipo_destino")
public class TipoDestino implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6034764721728942577L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_tide")
	private Integer idTide;
	
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
	@Column(name = "fecha_creacion", nullable = false)
	private Date fechaCreacion;
	
	@Column(name = "fecha_modificacion")
	private Date fechaModificacion;
	
	@NotNull
	@NotEmpty
	@Size(max = 10)
	@Column(name = "usu_creador", nullable = false, length = 10)
	private String usuCreador;
	
	@Column(name = "usu_modificador", length = 10)
	private String usuModificador;
	
	@NotNull
	@NotEmpty
	@Size(max = 1)
	@Column(name = "estado", nullable = false, length = 1)
	private String estado;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoDestino")
	private List<Destino> destino = new ArrayList<>();
	
	/**
	 * 
	 */
	public TipoDestino() {
		super();
	}

	/**
	 * @param idTide
	 * @param codigo
	 * @param nombre
	 * @param descripcion
	 * @param fechaCreacion
	 * @param fechaModificacion
	 * @param usuCreador
	 * @param usuModificador
	 * @param estado
	 */
	public TipoDestino(@NotNull @NotEmpty Integer idTide, @NotNull @NotEmpty @Size(max = 5) String codigo,
			@NotNull @NotEmpty @Size(max = 100) String nombre, @NotNull @NotEmpty @Size(max = 300) String descripcion,
			@NotNull @NotEmpty Date fechaCreacion, Date fechaModificacion,
			@NotNull @NotEmpty @Size(max = 10) String usuCreador, String usuModificador,
			@NotNull @NotEmpty @Size(max = 1) String estado) {
		super();
		this.idTide = idTide;
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.usuCreador = usuCreador;
		this.usuModificador = usuModificador;
		this.estado = estado;
	}

	/**
	 * @return the idTide
	 */
	public Integer getIdTide() {
		return idTide;
	}

	/**
	 * @param idTide the idTide to set
	 */
	public void setIdTide(Integer idTide) {
		this.idTide = idTide;
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
