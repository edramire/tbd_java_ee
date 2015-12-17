package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Comunidad database table.
 * 
 */
@Entity
@Table(name="Comunidad")
@NamedQuery(name="Comunidad.findAll", query="SELECT c FROM Comunidad c")
public class Comunidad implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idComunidad;
	private String ciudad;
	private String comuna;
	private String cordenadas;
	private String nombre;

	public Comunidad() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getIdComunidad() {
		return this.idComunidad;
	}

	public void setIdComunidad(int idComunidad) {
		this.idComunidad = idComunidad;
	}


	@Column(length=45)
	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	@Column(length=45)
	public String getComuna() {
		return this.comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}


	@Column(length=45)
	public String getCordenadas() {
		return this.cordenadas;
	}

	public void setCordenadas(String cordenadas) {
		this.cordenadas = cordenadas;
	}


	@Column(length=45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}