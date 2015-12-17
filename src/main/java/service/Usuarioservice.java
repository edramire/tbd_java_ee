package service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import facade.UsuarioFacade;
import model.Usuario;

@Path("/Usuario")
public class Usuarioservice {
	
	@EJB 
	UsuarioFacade usuarioFacadeEJB;
	
	Logger logger = Logger.getLogger(Usuarioservice.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Usuario> findAll(){
		return usuarioFacadeEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Usuario find_id(@PathParam("id") Integer id) {
        return usuarioFacadeEJB.find(id);
    }

	@GET
    @Path("{usuario}")
    @Produces({"application/xml", "application/json"})
    public Usuario find_user(@PathParam("usuario") String usuario) {
        return usuarioFacadeEJB.find(usuario);
    }
	@PUT
	@Path("{/adduser/{usuario}")
    @Consumes({"application/xml", "application/json"})
	public void create(@PathParam("usuario") String usuario, Usuario entity){
		entity.setUsuario(usuario);
		usuarioFacadeEJB.create(entity);
	}
	/*@GET
    @Path("{mail}")
    @Produces({"application/xml", "application/json"})
    public Usuario find_mail(@PathParam("mail") String mail) {
        return usuarioFacadeEJB.find(mail);
    }	
	@GET
    @Path("{nombre}")
    @Produces({"application/xml", "application/json"})
    public Usuario find_nombre(@PathParam("nombre") String nombre) {
        return usuarioFacadeEJB.find(nombre);
    }	
	@GET
    @Path("{apellido}")
    @Produces({"application/xml", "application/json"})
    public Usuario find_apellido(@PathParam("apellido") String apellido) {
        return usuarioFacadeEJB.find(apellido);
    }*/
	

}
