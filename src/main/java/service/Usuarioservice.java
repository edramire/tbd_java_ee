package service;

import java.util.List;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import helper.ResponseHelper;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import auth.Credentials;
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

	@PUT
	@Path("/edit/{usuario}")
    @Consumes({"application/xml", "application/json"})
	public void create(@PathParam("usuario") String usuario, Usuario entity){
		entity.setUsuario(usuario);
		usuarioFacadeEJB.create(entity);
	}

	@POST
	@Path("crear")
    @Consumes({"application/xml", "application/json"})
    public void create(Usuario entity) {
        usuarioFacadeEJB.create(entity);
    }
	@POST
    @Path("login")
    @Produces({"application/xml", "application/json"})
	public Response login(@Context HttpHeaders httpHeaders,Credentials input) {
		String user=input.username;
		String password=input.password;
		if (usuarioFacadeEJB.login(user,password).equals("malo")){
			JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        	jsonObjBuilder.add( "message", "Error de usuario o password" );
        	JsonObject jsonObj = jsonObjBuilder.build();

        	return ResponseHelper.getNoCacheResponseBuilder( Response.Status.UNAUTHORIZED ).entity( jsonObj.toString() ).build();
		}
		else{
			JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
            JsonObject jsonObj = jsonObjBuilder.build();
        	jsonObjBuilder.add( "message", "Login exitoso");
            return ResponseHelper.getNoCacheResponseBuilder( Response.Status.OK ).entity( jsonObj.toString() ).build();
		}
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
