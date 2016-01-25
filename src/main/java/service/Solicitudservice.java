package service;

import java.util.Date;
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
import auth.Credentials3;
import facade.SolicitudFacade;
import model.Categoria;
import model.Comunidad;
import model.Core;
import model.Core_2;
import model.Favorito;
import model.Usuario;

@Path("/Solicitud")
public class Solicitudservice {
	
	
	@EJB 
	SolicitudFacade solicitudFacadeEJB;
	
	Logger logger = Logger.getLogger(Solicitudservice.class.getName());
	

	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Core_2> findAll(){
		return solicitudFacadeEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Core_2 find_id(@PathParam("id") Integer id) {
        return solicitudFacadeEJB.find(id);
    }
	
	


	@POST
	@Path("crear")
    @Consumes({"application/xml", "application/json"})
    public void create(Core_2 entity) {
        solicitudFacadeEJB.create(entity);
    }
	@PUT
	@Path("/edit_core/{id}")
    @Consumes({"application/xml", "application/json"})
	public void edit(@PathParam("id") Integer id, Core_2 entity){
		entity.setIdServicio(id);
		solicitudFacadeEJB.edit(entity);
	}

	@GET
    @Path("users/{id}")
    @Produces({"application/xml", "application/json"})
    public List<Core_2> find_user(@PathParam("id") Integer id) {
        return solicitudFacadeEJB.find_user(id);
    }
}