package service;

import java.util.Date;
import java.util.List;

import javax.ws.rs.core.Context;
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
import auth.Credentials3;
import facade.OfertaFacade;
import model.Core;
import model.Favorito;
import model.Usuario;

@Path("/Oferta")
public class OfertaService {
	
	@EJB 
	OfertaFacade ofertaFacadeEJB;
	
	Logger logger = Logger.getLogger(OfertaService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Core> findAllplus(){
		return ofertaFacadeEJB.findAllplus();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Core find_id(@PathParam("id") Integer id) {
        return ofertaFacadeEJB.find(id);
    }


	@POST
	@Path("crear")
    @Consumes({"application/xml", "application/json"})
    public void create(Core entity) {
        ofertaFacadeEJB.create(entity);
    }
	@PUT
	@Path("/edit_core/{id}")
    @Consumes({"application/xml", "application/json"})
	public void edit(@PathParam("id") Integer id, Core entity){
		entity.setIdServicio(id);
		ofertaFacadeEJB.edit(entity);
	}

	@GET
    @Path("users/{id}")
    @Produces({"application/xml", "application/json"})
    public List<Core> find_user(@PathParam("id") Integer id) {
        return ofertaFacadeEJB.find_user(id);
    }
}
