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
import facade.CoreFacade;
import model.Core;
import model.Usuario;

@Path("/Core")
public class Coreservice {
	
	@EJB 
	CoreFacade coreFacadeEJB;
	
	Logger logger = Logger.getLogger(Coreservice.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Core> findAll(){
		return coreFacadeEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Core find_id(@PathParam("id") Integer id) {
        return coreFacadeEJB.find(id);
    }

	@POST
	@Path("crear")
    @Consumes({"application/xml", "application/json"})
    public void create(Core entity) {
        coreFacadeEJB.create(entity);
    }
	@PUT
	@Path("/edit_core/{id}")
    @Consumes({"application/xml", "application/json"})
	public void edit(@PathParam("id") Integer id, Core entity){
		entity.setIdServicio(id);
		coreFacadeEJB.edit(entity);
	}
}