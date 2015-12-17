package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Comentario database table.
 * 
 */
@Entity
@Table(name="Comentario")
@NamedQuery(name="Comentario.findAll", query="SELECT c FROM Comentario c")
public class Comentario implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idComentario;
	private int servicio_idServicio;
	private String texto;
	private Usuario usuario;

	public Comentario() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getIdComentario() {
		return this.idComentario;
	}

	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}


	@Column(name="Servicio_idServicio", nullable=false)
	public int getServicio_idServicio() {
		return this.servicio_idServicio;
	}

	public void setServicio_idServicio(int servicio_idServicio) {
		this.servicio_idServicio = servicio_idServicio;
	}


	@Column(nullable=false, length=255)
	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
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