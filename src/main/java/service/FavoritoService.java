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


import facade.FavoritoFacade;
import model.Core;
import model.Favorito;
@Path("/Favoritos")
public class FavoritoService {

	@EJB 
	FavoritoFacade favoritoFacadeEJB;
	
	Logger logger = Logger.getLogger(FavoritoService.class.getName());
	

	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Favorito> findAll(){
		return favoritoFacadeEJB.findAll();
	}
	
	@GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Favorito find_id(@PathParam("id") Integer id) {
        return favoritoFacadeEJB.find(id);
    }


	@POST
	@Path("crear")
    @Consumes({"application/xml", "application/json"})
    public void create(Favorito entity) {
        favoritoFacadeEJB.create(entity);
    }
	@PUT
	@Path("/edit/{id}")
    @Consumes({"application/xml", "application/json"})
	public void edit(@PathParam("id") Integer id, Favorito entity){
		entity.setIdFavorito(id);
		favoritoFacadeEJB.edit(entity);
	}
	@GET
    @Path("/users/{id}")
    @Produces({"application/xml", "application/json"})
    public List<Favorito> find_user(@PathParam("id") Integer id) {
        return favoritoFacadeEJB.find_user(id);
    }

	@GET
    @Path("/Servicios/{id}")
    @Produces({"application/xml", "application/json"})
    public List<Core> find_oferta(@PathParam("id") Integer id) {
        return favoritoFacadeEJB.find_oferta(id);
    }

}
