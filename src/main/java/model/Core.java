package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Core database table.
 * 
 */
@Entity
@Table(name="Core")
@NamedQuery(name="Core.findAll", query="SELECT c FROM Core c")
public class Core implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idServicio;
	private int categoria_idCategoria;
	private int comunidad_idComunidad;
	private String descripcion;
	private String duracion;
	private Date fecha;
	private byte[] imagen;
	private String precio;
	private String titulo;
	private int usuario_idUsuario;
	private int promedio;

	public Core() {
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
	@Column(nullable=false)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Column(nullable=false, length=45)
	public String getDuracion() {
		return this.duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	@Lob
	public byte[] getImagen() {
		return this.imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}


	@Column(length=45)
	public String getPrecio() {
		return this.precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}


	@Column(nullable=false, length=45)
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


	public int getPromedio() {
		return promedio;
	}


	public void setPromedio(int promedio) {
		this.promedio = promedio;
	}

}