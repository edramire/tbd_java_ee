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

import facade.CategoriaFacade;
import facade.ComunidadFacade;
import model.Categoria;
import model.Comunidad;



@Path("/Comunidad")
public class ComunidadService {

	
	@EJB 
	ComunidadFacade comunidadFacadeEJB;
	
	Logger logger = Logger.getLogger(ComunidadService.class.getName());
	

	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Comunidad> findAll(){
		return comunidadFacadeEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Comunidad find_id(@PathParam("id") Integer id) {
        return comunidadFacadeEJB.find(id);
    }


	@POST
	@Path("crear")
    @Consumes({"application/xml", "application/json"})
    public void create(Comunidad entity) {
        comunidadFacadeEJB.create(entity);
    }
	@PUT
	@Path("/edit_core/{id}")
    @Consumes({"application/xml", "application/json"})
	public void edit(@PathParam("id") Integer id, Comunidad entity){
		entity.setIdComunidad(id);
		comunidadFacadeEJB.edit(entity);
	}

}
