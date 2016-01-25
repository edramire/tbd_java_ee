package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Core_2 database table.
 * 
 */
@Entity
@Table(name="Core_2")
@NamedQuery(name="Core_2.findAll", query="SELECT c FROM Core_2 c")
public class Core_2 implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idServicio;
	private int categoria_idCategoria;
	private int comunidad_idComunidad;
	private String descripcion;
	private String duracion;
	private Date fecha;
	private int estado;
	private String imagen;
	private String precio;
	private String titulo;
	private int usuario_idUsuario;
	private String region;
	private String unombre;
	private String unick;
	private String catnombre;
	private String comnombre;

	public Core_2() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getIdServicio() {
		return this.idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}


	@Column(name="Categoria_idCategoria", nullable=false)
	public int getCategoria_idCategoria() {
		return this.categoria_idCategoria;
	}

	public void setCategoria_idCategoria(int categoria_idCategoria) {
		this.categoria_idCategoria = categoria_idCategoria;
	}


	@Column(name="Comunidad_idComunidad", nullable=false)
	public int getComunidad_idComunidad() {
		return this.comunidad_idComunidad;
	}

	public void setComunidad_idComunidad(int comunidad_idComunidad) {
		this.comunidad_idComunidad = comunidad_idComunidad;
	}


	@Lob
	@Column(nullable=true)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Column(nullable=true, length=45)
	public String getDuracion() {
		return this.duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}


	@Temporal(TemporalType.DATE)
	@Column(nullable=true)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	@Column(length=100, nullable=true)
	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	@Column(length=45, nullable=true)
	public String getPrecio() {
		return this.precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}


	@Column(nullable=true, length=45)
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	@Column(name="Usuario_idUsuario", nullable=false)
	public int getUsuario_idUsuario() {
		return this.usuario_idUsuario;
	}

	public void setUsuario_idUsuario(int usuario_idUsuario) {
		this.usuario_idUsuario = usuario_idUsuario;
	}


	@Column(name="region", nullable=true)
	public String getRegion() {
		return region;
	}


	public void setRegion(String region) {
		this.region = region;
	}

	@Column(name="unombre", nullable=true)
	public String getUnombre() {
		return unombre;
	}


	public void setUnombre(String unombre) {
		this.unombre = unombre;
	}

	@Column(name="unick", nullable=true)
	public String getUnick() {
		return unick;
	}

	
	public void setUnick(String unick) {
		this.unick = unick;
	}

	@Column(name="catnombre", nullable=true)
	public String getCatnombre() {
		return catnombre;
	}


	public void setCatnombre(String catnombre) {
		this.catnombre = catnombre;
	}

	@Column(name="comnombre", nullable=true)
	public String getComnombre() {
		return comnombre;
	}


	public void setComnombre(String comnombre) {
		this.comnombre = comnombre;
	}

	@Column(name="estado", nullable=true)
	public int getEstado() {
		return estado;
	}


	public void setEstado(int estado) {
		this.estado = estado;
	}
}