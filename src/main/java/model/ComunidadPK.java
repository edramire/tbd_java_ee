package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the Comunidad database table.
 * 
 */
@Embeddable
public class ComunidadPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private int idComunidad;
	private int comuna_idComuna;

	public ComunidadPK() {
	}

	public int getIdComunidad() {
		return this.idComunidad;
	}
	public void setIdComunidad(int idComunidad) {
		this.idComunidad = idComunidad;
	}

	@Column(name="Comuna_idComuna")
	public int getComuna_idComuna() {
		return this.comuna_idComuna;
	}
	public void setComuna_idComuna(int comuna_idComuna) {
		this.comuna_idComuna = comuna_idComuna;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ComunidadPK)) {
			return false;
		}
		ComunidadPK castOther = (ComunidadPK)other;
		return 
			(this.idComunidad == castOther.idComunidad)
			&& (this.comuna_idComuna == castOther.comuna_idComuna);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idComunidad;
		hash = hash * prime + this.comuna_idComuna;
		
		return hash;
	}
}