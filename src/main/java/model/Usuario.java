package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the Usuario database table.
 * 
 */
@Entity
@Table(name="Usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idUsuario;
	private String apellido;
	private String ciudad;
	private String comuna;
	private String direccion;
	private String mail;
	private String nombre;
	private String password;
	private String region;
	private String usuario;
	private Set<Comentario> comentarios;
	private Set<Favorito> favoritos;
	private Set<Voto> votos;
	private Set<Transaccion> transaccions;

	public Usuario() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	@Column(length=45)
	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	@Column(nullable=false, length=45)
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}


	@Column(length=45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Column(nullable=false, length=45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	@Column(length=45)
	public String getRegion() {
		return this.region;
	}

	public void setRegion(String region) {
		this.region = region;
	}


	@Column(nullable=false, length=45)
	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	//bi-directional many-to-one association to Comentario
	@OneToMany(mappedBy="usuario")
	public Set<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Comentario addComentario(Comentario comentario) {
		getComentarios().add(comentario);
		comentario.setUsuario(this);

		return comentario;
	}

	public Comentario removeComentario(Comentario comentario) {
		getComentarios().remove(comentario);
		comentario.setUsuario(null);

		return comentario;
	}


	//bi-directional many-to-one association to Favorito
	@OneToMany(mappedBy="usuario")
	public Set<Favorito> getFavoritos() {
		return this.favoritos;
	}

	public void setFavoritos(Set<Favorito> favoritos) {
		this.favoritos = favoritos;
	}

	public Favorito addFavorito(Favorito favorito) {
		getFavoritos().add(favorito);
		favorito.setUsuario(this);

		return favorito;
	}

	public Favorito removeFavorito(Favorito favorito) {
		getFavoritos().remove(favorito);
		favorito.setUsuario(null);

		return favorito;
	}


	//bi-directional many-to-one association to Voto
	@OneToMany(mappedBy="usuario")
	public Set<Voto> getVotos() {
		return this.votos;
	}

	public void setVotos(Set<Voto> votos) {
		this.votos = votos;
	}

	public Voto addVoto(Voto voto) {
		getVotos().add(voto);
		voto.setUsuario(this);

		return voto;
	}

	public Voto removeVoto(Voto voto) {
		getVotos().remove(voto);
		voto.setUsuario(null);

		return voto;
	}


	//bi-directional many-to-one association to Transaccion
	@OneToMany(mappedBy="usuario")
	public Set<Transaccion> getTransaccions() {
		return this.transaccions;
	}

	public void setTransaccions(Set<Transaccion> transaccions) {
		this.transaccions = transaccions;
	}

	public Transaccion addTransaccion(Transaccion transaccion) {
		getTransaccions().add(transaccion);
		transaccion.setUsuario(this);

		return transaccion;
	}

	public Transaccion removeTransaccion(Transaccion transaccion) {
		getTransaccions().remove(transaccion);
		transaccion.setUsuario(null);

		return transaccion;
	}

}