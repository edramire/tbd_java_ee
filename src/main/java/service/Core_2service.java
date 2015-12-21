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
import facade.Core_2Facade;
import model.Core_2;
import model.Usuario;

@Path("/Core")
public class Core_2service {
	
	@EJB 
	Core_2Facade core_2FacadeEJB;
	
	Logger logger = Logger.getLogger(Coreservice.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Core_2> findAll(){
		return core_2FacadeEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Core_2 find_id(@PathParam("id") Integer id) {
        return core_2FacadeEJB.find(id);
    }

	@POST
	@Path("crear")
    @Consumes({"application/xml", "application/json"})
    public void create(Core_2 entity) {
        core_2FacadeEJB.create(entity);
    }
	@PUT
	@Path("/edit_core/{id}")
    @Consumes({"application/xml", "application/json"})
	public void edit(@PathParam("id") Integer id, Core_2 entity){
		entity.setIdServicio(id);
		core_2FacadeEJB.edit(entity);
	}
}