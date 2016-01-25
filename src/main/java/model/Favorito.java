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
	private int Servicio_idServicio;
	private int Usuario_idUsuario;

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
		return this.Servicio_idServicio;
	}

	public void setServicio_idServicio(int servicio_idServicio) {
		this.Servicio_idServicio = servicio_idServicio;
	}


	@Column(name="Usuario_idUsuario", nullable=false)
	public int getUsuario_idUsuario() {
		return Usuario_idUsuario;
	}


	public void setUsuario_idUsuario(int usuario_idUsuario) {
		this.Usuario_idUsuario = usuario_idUsuario;
	}



}