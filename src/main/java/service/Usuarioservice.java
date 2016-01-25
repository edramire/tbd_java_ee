package service;

import java.util.List;
import auth.DemoHTTPHeaderNames;

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
import model.Core_2;
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
    @Path("estado/{nombre}")
    @Produces({"application/xml", "application/json"})
    public Usuario getestado(@PathParam("nombre") String nombre) {
       return usuarioFacadeEJB.find_estado(nombre);
    }
	@GET
    @Path("nombre/{nombre}")
    @Produces({"application/xml", "application/json"})
    public String getid(@PathParam("nombre") String nombre) {
        try{return usuarioFacadeEJB.find_nombre(nombre);}
        catch(Exception e){return e.toString()+"aca va el nombre:"+nombre;}
    }
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Usuario find_id(@PathParam("id") Integer id) {
        return usuarioFacadeEJB.find(id);
    }
	

	@PUT
	@Path("/edit_user/{id}")
    @Consumes({"application/xml", "application/json"})
	public void edit(@PathParam("id") Integer id, Usuario entity){
		entity.setIdUsuario(id);
		usuarioFacadeEJB.edit(entity);
	}

	@POST
	@Path("crear")
    @Consumes({"application/xml", "application/json"})
    public void create(Usuario entity) {
        usuarioFacadeEJB.create(entity);
    }
	@POST
    @Path("registro")
    @Produces("application/json")
    @Consumes({"application/xml", "application/json"})
    public Response registro(
    		 Usuario entity
    		 ){
      		
      		try{
      			usuarioFacadeEJB.create(entity);
      			
      			JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
                jsonObjBuilder.add( "message", "Registro exitoso." );
                JsonObject jsonObj = jsonObjBuilder.build();     
                return ResponseHelper.getNoCacheResponseBuilder( Response.Status.CREATED ).entity( jsonObj.toString() ).build();
      		}
      		catch(final Exception ex){
      			
      			JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
                jsonObjBuilder.add( "message", "Error en el registro" );
                JsonObject jsonObj = jsonObjBuilder.build();
     
                return ResponseHelper.getNoCacheResponseBuilder( Response.Status.UNAUTHORIZED /* cambiar codigo */ ).entity( jsonObj.toString() ).build();
      		}
    }	
		
	@POST
    @Path("login")
    @Produces({"application/xml", "application/json"})
	public Response login(@Context HttpHeaders httpHeaders,Credentials input) {
		String user=input.username;
		String password=input.password;
        String authTokenTest = httpHeaders.getHeaderString( DemoHTTPHeaderNames.AUTH_TOKEN );
		if (usuarioFacadeEJB.login(user,password).equals("mal")){
			JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        	jsonObjBuilder.add( "message", usuarioFacadeEJB.login(user,password) );
        	JsonObject jsonObj = jsonObjBuilder.build();

        	return ResponseHelper.getNoCacheResponseBuilder( Response.Status.UNAUTHORIZED ).entity( jsonObj.toString() ).build();

	}
		else{
			
			String authToken = usuarioFacadeEJB.login( user, password );
			JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
            JsonObject jsonObj = jsonObjBuilder.build();
        	jsonObjBuilder.add( "message", usuarioFacadeEJB.login(user,password) );
        	jsonObjBuilder.add( "auth_token", authToken);
            return ResponseHelper.getNoCacheResponseBuilder( Response.Status.OK ).entity( jsonObj.toString() ).build();	

		}
    }	
	@POST
    @Path("logout")
    @Produces({"application/xml", "application/json"})
	public Response logout(@Context HttpHeaders httpHeaders,Credentials input) {
		String user=input.username;	
		usuarioFacadeEJB.logout(user);
		JsonObjectBuilder jsonObjBuilder = Json.createObjectBuilder();
        JsonObject jsonObj = jsonObjBuilder.build();
        return ResponseHelper.getNoCacheResponseBuilder( Response.Status.OK ).entity( jsonObj.toString() ).build();	

		
    }

}
