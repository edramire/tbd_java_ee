package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the transaccion database table.
 * 
 */
@Entity
@Table(name="transaccion")
@NamedQuery(name="Transaccion.findAll", query="SELECT t FROM Transaccion t")
public class Transaccion {
	private int idSolicitud;
	private Date fecha;
	private String informacion;
	private int servicio_idServicio;
	private String valor;
	private Usuario usuario;

	public Transaccion() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getIdSolicitud() {
		return this.idSolicitud;
	}

	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}


	@Temporal(TemporalType.TIMESTAMP)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	@Column(length=255)
	public String getInformacion() {
		return this.informacion;
	}

	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}


	@Column(name="Servicio_idServicio", nullable=false)
	public int getServicio_idServicio() {
		return this.servicio_idServicio;
	}

	public void setServicio_idServicio(int servicio_idServicio) {
		this.servicio_idServicio = servicio_idServicio;
	}


	@Column(length=45)
	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}


	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="Usuario_idUsuario", nullable=false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}