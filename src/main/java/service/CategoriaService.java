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
import facade.CategoriaFacade;
import facade.SolicitudFacade;
import model.Categoria;
import model.Comunidad;
import model.Core;
import model.Core_2;
import model.Usuario;

@Path("/Categoria")
public class CategoriaService {
	
	
	@EJB 
	CategoriaFacade categoriadFacadeEJB;
	
	Logger logger = Logger.getLogger(CategoriaService.class.getName());
	

	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Categoria> findAll(){
		return categoriadFacadeEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Categoria find_id(@PathParam("id") Integer id) {
        return categoriadFacadeEJB.find(id);
    }


	@POST
	@Path("crear")
    @Consumes({"application/xml", "application/json"})
    public void create(Categoria entity) {
        categoriadFacadeEJB.create(entity);
    }
	@PUT
	@Path("/edit_core/{id}")
    @Consumes({"application/xml", "application/json"})
	public void edit(@PathParam("id") Integer id, Categoria entity){
		entity.setIdCategoria(id);
		categoriadFacadeEJB.edit(entity);
	}
}