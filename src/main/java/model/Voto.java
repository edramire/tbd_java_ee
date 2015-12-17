package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Voto database table.
 * 
 */
@Entity
@Table(name="Voto")
@NamedQuery(name="Voto.findAll", query="SELECT v FROM Voto v")
public class Voto implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idVoto;
	private int calificacion;
	private int servicio_idServicio;
	private Usuario usuario;

	public Voto() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getIdVoto() {
		return this.idVoto;
	}

	public void setIdVoto(int idVoto) {
		this.idVoto = idVoto;
	}


	@Column(nullable=false)
	public int getCalificacion() {
		return this.calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}


	@Column(name="Servicio_idServicio", nullable=false)
	public int getServicio_idServicio() {
		return this.servicio_idServicio;
	}

	public void setServicio_idServicio(int servicio_idServicio) {
		this.servicio_idServicio = servicio_idServicio;
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