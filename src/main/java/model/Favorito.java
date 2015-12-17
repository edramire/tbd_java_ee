package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Favorito database table.
 * 
 */
@Entity
@Table(name="Favorito")
@NamedQuery(name="Favorito.findAll", query="SELECT f FROM Favorito f")
public class Favorito implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idFavorito;
	private int servicio_idServicio;
	private Usuario usuario;

	public Favorito() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getIdFavorito() {
		return this.idFavorito;
	}

	public void setIdFavorito(int idFavorito) {
		this.idFavorito = idFavorito;
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